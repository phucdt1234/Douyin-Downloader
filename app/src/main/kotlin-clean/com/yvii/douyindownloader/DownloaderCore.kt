package com.yvii.douyindownloader

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaCodec
import android.media.MediaExtractor
import android.media.MediaFormat
import android.media.MediaMuxer
import android.net.Uri
import android.os.Build
import com.yausername.ffmpeg.FFmpeg
import com.yausername.youtubedl_android.YoutubeDL
import com.yausername.youtubedl_android.YoutubeDLRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileOutputStream
import java.net.HttpURLConnection
import java.net.URL
import java.nio.ByteBuffer
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

enum class DownloadMode(val title: String, val subtitle: String) {
    Douyin("Douyin downloader", "Native Douyin parser, no yt-dlp fallback"),
    Video("Video downloader", "yt-dlp engine for supported sites"),
    Extra("Extra downloader", "cobalt API for Pinterest, SoundCloud, and more")
}

enum class MediaChoice(val label: String) {
    Auto("Auto"), Video("Video"), Audio("Audio"), Images("Images")
}

enum class QualityChoice(val label: String, val ytdlpFormat: String) {
    Best("Best", "bestvideo*+bestaudio/best"),
    Medium("Medium", "bv*[height<=720]+ba/b[height<=720]/best"),
    Small("Small", "bv*[height<=480]+ba/b[height<=480]/best")
}

enum class FileTypeChoice(val label: String) {
    Auto("Auto"), Mp4("MP4"), Mp3("MP3"), Image("Image")
}

enum class ImageFormatChoice(val label: String, val extension: String?) {
    Auto("Original", null), Png("PNG", "png"), Jpg("JPG", "jpg"), Webp("WebP", "webp")
}

data class MediaItem(
    val url: String,
    val label: String,
    val alternativeUrls: List<String> = emptyList()
) {
    val candidates: List<String>
        get() = (listOf(url) + alternativeUrls).filter(String::isNotBlank).distinct()
}

data class LivePhotoItem(
    val image: MediaItem?,
    val video: MediaItem,
    val label: String
) {
    val selectionKey: String
        get() = image?.url ?: video.url
}

data class AnalyzedMedia(
    val title: String,
    val sourceUrl: String,
    val videoUrl: String? = null,
    val audioUrl: String? = null,
    val images: List<MediaItem> = emptyList(),
    val livePhotos: List<LivePhotoItem> = emptyList(),
    val videoAlternatives: List<String> = emptyList(),
    val audioAlternatives: List<String> = emptyList(),
    val audioSourceVideoCandidates: List<String> = emptyList()
) {
    val videoCandidates: List<String>
        get() = (listOfNotNull(videoUrl) + videoAlternatives).distinct()
    val audioCandidates: List<String>
        get() = (listOfNotNull(audioUrl) + audioAlternatives).distinct()
}

data class HttpResult(val finalUrl: String, val body: String)

data class DownloadSettings(
    val mediaChoice: MediaChoice = MediaChoice.Auto,
    val quality: QualityChoice = QualityChoice.Best,
    val fileType: FileTypeChoice = FileTypeChoice.Auto,
    val imageFormat: ImageFormatChoice = ImageFormatChoice.Auto,
    val updateYtDlp: Boolean = true,
    val includeThumbnail: Boolean = true,
    val cookies: String = "",
    val cobaltApi: String = "https://api.cobalt.tools",
    val cobaltDownloadMode: String = "auto",
    val cobaltVideoQuality: String = "1080",
    val cobaltAudioFormat: String = "mp3",
    val cobaltAudioBitrate: String = "128",
    val cobaltAuthorization: String = ""
)

fun loadSettings(context: Context): Map<DownloadMode, DownloadSettings> {
    val preferences = context.getSharedPreferences("downloader_settings", Context.MODE_PRIVATE)
    return DownloadMode.entries.associateWith { mode ->
        val raw = preferences.getString(mode.name, null) ?: return@associateWith DownloadSettings()
        runCatching {
            val json = JSONObject(raw)
            DownloadSettings(
                mediaChoice = enumValue(json.optString("mediaChoice"), MediaChoice.Auto),
                quality = enumValue(json.optString("quality"), QualityChoice.Best),
                fileType = enumValue(json.optString("fileType"), FileTypeChoice.Auto),
                imageFormat = enumValue(json.optString("imageFormat"), ImageFormatChoice.Auto),
                updateYtDlp = json.optBoolean("updateYtDlp", true),
                includeThumbnail = json.optBoolean("includeThumbnail", true),
                cookies = json.optString("cookies", ""),
                cobaltApi = json.optString("cobaltApi", "https://api.cobalt.tools"),
                cobaltDownloadMode = json.optString("cobaltDownloadMode", "auto"),
                cobaltVideoQuality = json.optString("cobaltVideoQuality", "1080"),
                cobaltAudioFormat = json.optString("cobaltAudioFormat", "mp3"),
                cobaltAudioBitrate = json.optString("cobaltAudioBitrate", "128"),
                cobaltAuthorization = json.optString("cobaltAuthorization", "")
            )
        }.getOrDefault(DownloadSettings())
    }
}

fun saveSettings(context: Context, settings: Map<DownloadMode, DownloadSettings>) {
    val editor = context.getSharedPreferences("downloader_settings", Context.MODE_PRIVATE).edit()
    settings.forEach { (mode, value) ->
        editor.putString(
            mode.name,
            JSONObject()
                .put("mediaChoice", value.mediaChoice.name)
                .put("quality", value.quality.name)
                .put("fileType", value.fileType.name)
                .put("imageFormat", value.imageFormat.name)
                .put("updateYtDlp", value.updateYtDlp)
                .put("includeThumbnail", value.includeThumbnail)
                .put("cookies", value.cookies)
                .put("cobaltApi", value.cobaltApi)
                .put("cobaltDownloadMode", value.cobaltDownloadMode)
                .put("cobaltVideoQuality", value.cobaltVideoQuality)
                .put("cobaltAudioFormat", value.cobaltAudioFormat)
                .put("cobaltAudioBitrate", value.cobaltAudioBitrate)
                .put("cobaltAuthorization", value.cobaltAuthorization)
                .toString()
        )
    }
    editor.apply()
}

private inline fun <reified Value : Enum<Value>> enumValue(raw: String, fallback: Value): Value =
    runCatching { enumValueOf<Value>(raw) }.getOrDefault(fallback)

fun extractUrl(text: String): String? =
    Regex("https?://[^\\s\"'<>，。]+", RegexOption.IGNORE_CASE)
        .find(text)
        ?.value
        ?.trimEnd(':', ';', ',', '.', ')', ']', '}')

fun mediaSummary(media: AnalyzedMedia): String = buildList {
    if (media.videoUrl != null) add("1 video")
    if (media.audioUrl != null) add("1 audio")
    if (media.images.isNotEmpty()) add("${media.images.size} image(s)")
    if (media.livePhotos.isNotEmpty()) add("${media.livePhotos.size} live photo(s)")
}.joinToString().ifBlank { "no downloadable media" }

suspend fun analyzeByMode(
    context: Context,
    mode: DownloadMode,
    url: String,
    settings: DownloadSettings,
    onProgress: (String) -> Unit
): AnalyzedMedia = when (mode) {
    DownloadMode.Douyin -> analyzeDouyin(context, url, settings, onProgress)
    DownloadMode.Video -> analyzeVideo(context, url, settings, onProgress)
    DownloadMode.Extra -> analyzeCobalt(url, settings, onProgress)
}

private suspend fun analyzeVideo(
    context: Context,
    url: String,
    settings: DownloadSettings,
    onProgress: (String) -> Unit
): AnalyzedMedia = withContext(Dispatchers.IO) {
    val normalizedUrl = normalizeUrl(url)
    if (isDirectImage(normalizedUrl)) {
        return@withContext AnalyzedMedia(
            title = "Direct image",
            sourceUrl = normalizedUrl,
            images = listOf(MediaItem(normalizedUrl, "Image 1"))
        )
    }
    onProgress("Initializing yt-dlp")
    YoutubeDL.getInstance().init(context.applicationContext)
    val request = YoutubeDLRequest(normalizedUrl).addOption("-f", settings.quality.ytdlpFormat)
    val info = YoutubeDL.getInstance().getInfo(request)
    val thumbnails = info.thumbnails.orEmpty().mapIndexedNotNull { index, thumbnail ->
        thumbnail.url?.takeIf { it.startsWith("http") }?.let { MediaItem(it, "Thumbnail ${index + 1}") }
    }
    AnalyzedMedia(
        title = info.title ?: "Video",
        sourceUrl = normalizedUrl,
        videoUrl = info.url,
        images = thumbnails
    )
}

private suspend fun analyzeDouyin(
    context: Context,
    url: String,
    settings: DownloadSettings,
    onProgress: (String) -> Unit
): AnalyzedMedia = analyzeDouyinWithJiji(context, url, settings, onProgress)

private suspend fun analyzeCobalt(
    url: String,
    settings: DownloadSettings,
    onProgress: (String) -> Unit
): AnalyzedMedia = withContext(Dispatchers.IO) {
    onProgress("Calling cobalt API")
    val request = JSONObject()
        .put("url", normalizeUrl(url))
        .put("downloadMode", settings.cobaltDownloadMode)
        .put("videoQuality", settings.cobaltVideoQuality)
        .put("audioFormat", settings.cobaltAudioFormat)
        .put("audioBitrate", settings.cobaltAudioBitrate)
    val response = JSONObject(httpPostJson(settings.cobaltApi, request, settings.cobaltAuthorization))
    val status = response.optString("status")
    when (status) {
        "redirect", "tunnel" -> {
            val mediaUrl = response.optString("url").takeIf(String::isNotBlank)
                ?: error("cobalt returned no media URL")
            val title = response.optString("filename", "cobalt media")
            if (looksLikeImageUrl(mediaUrl) || settings.fileType == FileTypeChoice.Image) {
                AnalyzedMedia(title, url, images = listOf(MediaItem(mediaUrl, "Image 1")))
            } else {
                AnalyzedMedia(title, url, videoUrl = mediaUrl)
            }
        }
        "picker" -> {
            val picker = response.optJSONArray("picker") ?: JSONArray()
            val images = mutableListOf<MediaItem>()
            var videoUrl: String? = null
            for (index in 0 until picker.length()) {
                val item = picker.optJSONObject(index) ?: continue
                val mediaUrl = item.optString("url").takeIf(String::isNotBlank) ?: continue
                val type = item.optString("type")
                if (type.contains("photo", true) || type.contains("image", true) || looksLikeImageUrl(mediaUrl)) {
                    images += MediaItem(mediaUrl, "Image ${images.size + 1}")
                } else if (videoUrl == null) {
                    videoUrl = mediaUrl
                }
            }
            AnalyzedMedia(response.optString("filename", "cobalt media"), url, videoUrl, images = images)
        }
        "error" -> error(response.optJSONObject("error")?.optString("code") ?: "cobalt request failed")
        else -> error(response.optString("text").ifBlank { "Unsupported cobalt response: $status" })
    }
}

suspend fun download(
    context: Context,
    mode: DownloadMode,
    media: AnalyzedMedia,
    settings: DownloadSettings,
    selectedImages: Set<String>,
    onProgress: (String) -> Unit
): String = withContext(Dispatchers.IO) {
    val destination = loadSaveDestination(context)
    val audioOnly = settings.fileType == FileTypeChoice.Mp3 || settings.mediaChoice == MediaChoice.Audio
    val imageOnly = !audioOnly &&
        (settings.fileType == FileTypeChoice.Image || settings.mediaChoice == MediaChoice.Images)
    val videoOnly = !audioOnly && !imageOnly &&
        (settings.fileType == FileTypeChoice.Mp4 || settings.mediaChoice == MediaChoice.Video)
    val automatic = !audioOnly && !imageOnly && !videoOnly
    if (mode == DownloadMode.Video && settings.mediaChoice == MediaChoice.Images) {
        val images = media.images.filter { selectedImages.isEmpty() || it.url in selectedImages }
        check(images.isNotEmpty()) { "No images found. Use Auto or Video media setting for this URL." }
        images.forEachIndexed { index, item ->
            downloadDirectFile(
                context,
                destination,
                item.candidates,
                "image-${index + 1}",
                settings.cookies,
                ImageFormatChoice.Auto,
                onProgress
            )
        }
        return@withContext destination.label
    }
    if (mode == DownloadMode.Video && !isDirectImage(media.sourceUrl)) {
        onProgress("Initializing yt-dlp")
        YoutubeDL.getInstance().init(context.applicationContext)
        FFmpeg.getInstance().init(context.applicationContext)
        if (settings.updateYtDlp) {
            onProgress("Updating yt-dlp stable")
            YoutubeDL.getInstance().updateYoutubeDL(context.applicationContext, YoutubeDL.UpdateChannel._STABLE)
            onProgress("yt-dlp ${YoutubeDL.getInstance().versionName(context.applicationContext)}")
        }
        val temporaryDirectory = File(context.cacheDir, "download-${System.currentTimeMillis()}")
        check(temporaryDirectory.mkdirs()) { "Cannot create temporary download folder." }
        val request = YoutubeDLRequest(media.videoUrl?.removePrefix("ytdlp:") ?: media.sourceUrl)
            .addOption("--no-playlist")
            .addOption("--restrict-filenames")
        if (audioOnly) {
            request.addOption("-x").addOption("--audio-format", "mp3")
        } else {
            request.addOption("-f", settings.quality.ytdlpFormat)
            if (settings.fileType == FileTypeChoice.Mp4) request.addOption("--merge-output-format", "mp4")
        }
        if (settings.includeThumbnail && !audioOnly) {
            request.addOption("--write-thumbnail").addOption("--convert-thumbnails", "jpg")
        }
        request.addOption("-o", File(temporaryDirectory, "%(title).80s-%(id)s.%(ext)s").absolutePath)
        try {
            YoutubeDL.getInstance().execute(request, "download-${System.currentTimeMillis()}") { percent, eta, line ->
                val prefix = if (percent >= 0) "${percent.toInt()}% ETA ${eta}s" else "yt-dlp"
                onProgress("$prefix $line")
            }
            val generated = temporaryDirectory.walkTopDown()
                .filter { it.isFile && !it.name.endsWith(".part") }
                .toList()
            check(generated.isNotEmpty()) { "yt-dlp completed without producing a file." }
            generated.forEach { file -> exportDownloadedFile(context, destination, file, onProgress) }
        } finally {
            temporaryDirectory.deleteRecursively()
        }
        return@withContext destination.label
    }
    if (audioOnly) {
        if (media.audioCandidates.isNotEmpty()) {
            downloadDirectFile(
                context,
                destination,
                media.audioCandidates,
                "audio",
                settings.cookies,
                ImageFormatChoice.Auto,
                onProgress
            )
        } else {
            val sourceVideos = (
                media.audioSourceVideoCandidates + media.videoCandidates +
                    media.livePhotos.flatMap { it.video.candidates }
                ).distinct()
            check(sourceVideos.isNotEmpty()) { "No audio source found for this URL." }
            downloadAudioTrack(context, destination, sourceVideos, settings.cookies, onProgress)
        }
        return@withContext destination.label
    }
    var savedFiles = 0
    if ((automatic || videoOnly) && media.videoCandidates.isNotEmpty()) {
        downloadDirectFile(
            context,
            destination,
            media.videoCandidates,
            "video",
            settings.cookies,
            ImageFormatChoice.Auto,
            onProgress
        )
        savedFiles++
    }
    if (automatic || imageOnly) {
        val imageFormat = if (mode == DownloadMode.Douyin) settings.imageFormat else ImageFormatChoice.Auto
        media.images
            .filter { selectedImages.isEmpty() || it.url in selectedImages }
            .forEachIndexed { index, item ->
                downloadDirectFile(
                    context,
                    destination,
                    item.candidates,
                    "image-${index + 1}",
                    settings.cookies,
                    imageFormat,
                    onProgress
                )
                savedFiles++
            }
    }
    media.livePhotos
        .filter { selectedImages.isEmpty() || it.selectionKey in selectedImages }
        .forEachIndexed { index, livePhoto ->
            if (automatic || imageOnly) {
                livePhoto.image?.let { image ->
                    downloadDirectFile(
                        context,
                        destination,
                        image.candidates,
                        "live-photo-${index + 1}",
                        settings.cookies,
                        settings.imageFormat,
                        onProgress
                    )
                    savedFiles++
                }
            }
            if (automatic || videoOnly) {
                downloadDirectFile(
                    context,
                    destination,
                    livePhoto.video.candidates,
                    "live-photo-motion-${index + 1}",
                    settings.cookies,
                    ImageFormatChoice.Auto,
                    onProgress
                )
                savedFiles++
            }
        }
    if (automatic && savedFiles == 0 && media.audioCandidates.isNotEmpty()) {
        downloadDirectFile(
            context,
            destination,
            media.audioCandidates,
            "audio",
            settings.cookies,
            ImageFormatChoice.Auto,
            onProgress
        )
        savedFiles++
    }
    check(savedFiles > 0) { "No downloadable media found for the selected type." }
    destination.label
}

private fun httpPostJson(url: String, body: JSONObject, authorization: String = ""): String {
    val bytes = body.toString().toByteArray()
    val connection = URL(normalizeUrl(url.trimEnd('/') + "/")).openConnection() as HttpURLConnection
    connection.requestMethod = "POST"
    connection.connectTimeout = 15_000
    connection.readTimeout = 30_000
    connection.doOutput = true
    connection.setRequestProperty("Accept", "application/json")
    connection.setRequestProperty("Content-Type", "application/json")
    connection.setRequestProperty("Content-Length", bytes.size.toString())
    if (authorization.isNotBlank()) connection.setRequestProperty("Authorization", authorization)
    connection.outputStream.use { it.write(bytes) }
    val stream = runCatching { connection.inputStream }.getOrElse { connection.errorStream ?: throw it }
    return stream.bufferedReader().use { it.readText() }
}

internal fun verifyParserContract() {
    check(extractUrl("share https://v.douyin.com/example/ text") == "https://v.douyin.com/example/")
    verifyJijiParserContract()
}


private fun normalizeUrl(url: String): String =
    if (Uri.parse(url).scheme == null) "https://$url" else url

private fun isDirectImage(url: String): Boolean {
    val path = Uri.parse(url).path.orEmpty().lowercase(Locale.ROOT)
    return listOf(".jpg", ".jpeg", ".png", ".webp", ".gif").any(path::endsWith)
}

private fun looksLikeImageUrl(url: String): Boolean =
    isDirectImage(url) || url.contains("image", true) ||
        url.contains("photo", true) || url.contains("douyinpic", true)

private fun downloadAudioTrack(
    context: Context,
    destination: SaveDestination,
    urls: List<String>,
    cookies: String,
    onProgress: (String) -> Unit
) {
    val temporaryDirectory = File(context.cacheDir, "audio-${System.currentTimeMillis()}")
    check(temporaryDirectory.mkdirs()) { "Cannot create temporary audio folder." }
    try {
        val source = File(temporaryDirectory, "source.mp4")
        downloadTemporaryFile(urls, source, cookies, onProgress)
        onProgress("Extracting audio")
        val timestamp = SimpleDateFormat("yyyyMMdd-HHmmss-SSS", Locale.US).format(Date())
        val audio = File(temporaryDirectory, "audio-$timestamp.m4a")
        extractAudioTrack(source, audio)
        exportDownloadedFile(context, destination, audio, onProgress)
    } finally {
        temporaryDirectory.deleteRecursively()
    }
}

private fun downloadTemporaryFile(
    urls: List<String>,
    output: File,
    cookies: String,
    onProgress: (String) -> Unit
) {
    var lastError: Throwable? = null
    urls.filter(String::isNotBlank).distinct().forEachIndexed { index, url ->
        runCatching {
            if (index > 0) onProgress("Trying audio mirror ${index + 1}")
            val connection = URL(url).openConnection() as HttpURLConnection
            connection.connectTimeout = 15_000
            connection.readTimeout = 45_000
            connection.instanceFollowRedirects = true
            connection.setRequestProperty(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/139 Safari/537.36"
            )
            connection.setRequestProperty("Referer", "https://www.douyin.com/")
            if (cookies.isNotBlank()) connection.setRequestProperty("Cookie", cookies)
            try {
                val responseCode = connection.responseCode
                check(responseCode in 200..299) { "HTTP $responseCode" }
                val responseMime = connection.contentType.orEmpty().substringBefore(';').lowercase(Locale.ROOT)
                check(!responseMime.startsWith("text/") && responseMime != "application/json") {
                    "Audio source returned $responseMime instead of media."
                }
                FileOutputStream(output).use { fileOutput ->
                    connection.inputStream.use { input ->
                        val buffer = ByteArray(65_536)
                        var downloaded = 0L
                        while (true) {
                            val count = input.read(buffer)
                            if (count <= 0) break
                            fileOutput.write(buffer, 0, count)
                            downloaded += count
                            onProgress("Downloading audio source: ${downloaded / 1024} KB")
                        }
                    }
                }
                check(output.length() > 0) { "Downloaded audio source is empty." }
                return
            } finally {
                connection.disconnect()
            }
        }.onFailure {
            output.delete()
            lastError = it
        }
    }
    throw IllegalStateException(
        "All audio source mirrors failed: ${lastError?.message ?: "no URL available"}",
        lastError
    )
}

private fun extractAudioTrack(input: File, output: File) {
    val extractor = MediaExtractor()
    var muxer: MediaMuxer? = null
    var muxerStarted = false
    try {
        extractor.setDataSource(input.absolutePath)
        val inputTrack = (0 until extractor.trackCount).firstOrNull { index ->
            extractor.getTrackFormat(index).getString(MediaFormat.KEY_MIME)?.startsWith("audio/") == true
        } ?: error("Downloaded media has no audio track.")
        extractor.selectTrack(inputTrack)
        val format = extractor.getTrackFormat(inputTrack)
        muxer = MediaMuxer(output.absolutePath, MediaMuxer.OutputFormat.MUXER_OUTPUT_MPEG_4)
        val outputTrack = muxer.addTrack(format)
        muxer.start()
        muxerStarted = true
        val bufferSize = if (format.containsKey(MediaFormat.KEY_MAX_INPUT_SIZE)) {
            format.getInteger(MediaFormat.KEY_MAX_INPUT_SIZE)
        } else {
            1_048_576
        }
        val buffer = ByteBuffer.allocateDirect(maxOf(bufferSize, 1_048_576))
        val info = MediaCodec.BufferInfo()
        var sampleCount = 0
        while (true) {
            buffer.clear()
            val size = extractor.readSampleData(buffer, 0)
            if (size < 0) break
            info.set(0, size, extractor.sampleTime, extractor.sampleFlags)
            muxer.writeSampleData(outputTrack, buffer, info)
            sampleCount++
            extractor.advance()
        }
        check(sampleCount > 0) { "Audio track is empty." }
        muxer.stop()
        muxerStarted = false
    } catch (error: Throwable) {
        output.delete()
        throw error
    } finally {
        if (muxerStarted) runCatching { muxer?.stop() }
        runCatching { muxer?.release() }
        extractor.release()
    }
}

private fun exportDownloadedFile(
    context: Context,
    destination: SaveDestination,
    file: File,
    onProgress: (String) -> Unit
) {
    val mimeType = mimeTypeForFileName(file.name)
    saveContent(context, destination, file.name, mimeType) { output ->
        file.inputStream().use { input ->
            val buffer = ByteArray(65_536)
            var copied = 0L
            while (true) {
                val count = input.read(buffer)
                if (count <= 0) break
                output.write(buffer, 0, count)
                copied += count
                onProgress("Saving ${file.name}: ${copied / 1024} KB")
            }
        }
    }
}

private fun downloadDirectFile(
    context: Context,
    destination: SaveDestination,
    urls: List<String>,
    prefix: String,
    cookies: String,
    imageFormat: ImageFormatChoice,
    onProgress: (String) -> Unit
): Uri {
    var lastError: Throwable? = null
    urls.filter(String::isNotBlank).distinct().forEachIndexed { index, url ->
        runCatching {
            if (index > 0) onProgress("Trying mirror ${index + 1}")
            return downloadDirectCandidate(
                context,
                destination,
                url,
                prefix,
                cookies,
                imageFormat,
                onProgress
            )
        }.onFailure { lastError = it }
    }
    throw IllegalStateException(
        "All download mirrors failed: ${lastError?.message ?: "no URL available"}",
        lastError
    )
}

private fun downloadDirectCandidate(
    context: Context,
    destination: SaveDestination,
    url: String,
    prefix: String,
    cookies: String,
    imageFormat: ImageFormatChoice,
    onProgress: (String) -> Unit
): Uri {
    val connection = URL(url).openConnection() as HttpURLConnection
    connection.connectTimeout = 15_000
    connection.readTimeout = 45_000
    connection.instanceFollowRedirects = true
    connection.setRequestProperty(
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/139 Safari/537.36"
    )
    connection.setRequestProperty("Referer", "https://www.douyin.com/")
    if (cookies.isNotBlank()) connection.setRequestProperty("Cookie", cookies)
    try {
        val responseCode = connection.responseCode
        check(responseCode in 200..299) { "HTTP $responseCode" }
        val responseMime = connection.contentType.orEmpty().substringBefore(';').lowercase(Locale.ROOT)
        check(!responseMime.startsWith("text/") && responseMime != "application/json") {
            "Media URL returned $responseMime instead of a file."
        }
        val timestamp = SimpleDateFormat("yyyyMMdd-HHmmss-SSS", Locale.US).format(Date())
        val convertingImage = imageFormat != ImageFormatChoice.Auto
        if (convertingImage) {
            val bytes = connection.inputStream.use { it.readBytes() }
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
                ?: error("Image conversion failed. Downloaded file is not a supported image.")
            val extension = imageFormat.extension ?: "jpg"
            val mimeType = mimeTypeForFileName("file.$extension")
            return try {
                saveContent(context, destination, "$prefix-$timestamp.$extension", mimeType) { output ->
                    val format = when (imageFormat) {
                        ImageFormatChoice.Png -> Bitmap.CompressFormat.PNG
                        ImageFormatChoice.Jpg -> Bitmap.CompressFormat.JPEG
                        ImageFormatChoice.Webp -> if (Build.VERSION.SDK_INT >= 30) {
                            Bitmap.CompressFormat.WEBP_LOSSLESS
                        } else {
                            @Suppress("DEPRECATION")
                            Bitmap.CompressFormat.WEBP
                        }
                        ImageFormatChoice.Auto -> Bitmap.CompressFormat.JPEG
                    }
                    check(bitmap.compress(format, 95, output)) { "Image conversion failed." }
                }
            } finally {
                bitmap.recycle()
            }
        }
        val extension = inferExtension(url, responseMime, prefix)
        val mimeType = responseMime.takeIf { it.contains('/') && it != "application/octet-stream" }
            ?: mimeTypeForFileName("file.$extension")
        return saveContent(context, destination, "$prefix-$timestamp.$extension", mimeType) { output ->
            connection.inputStream.use { input ->
                val buffer = ByteArray(65_536)
                var downloaded = 0L
                while (true) {
                    val count = input.read(buffer)
                    if (count <= 0) break
                    output.write(buffer, 0, count)
                    downloaded += count
                    onProgress("Downloaded ${downloaded / 1024} KB")
                }
                check(downloaded > 0) { "Downloaded file is empty." }
            }
        }
    } finally {
        connection.disconnect()
    }
}

private fun inferExtension(url: String, mimeType: String, prefix: String): String {
    val mimeExtension = when (mimeType) {
        "image/jpeg" -> "jpg"
        "image/png" -> "png"
        "image/webp" -> "webp"
        "image/gif" -> "gif"
        "video/mp4" -> "mp4"
        "video/webm" -> "webm"
        "audio/mpeg" -> "mp3"
        "audio/mp4", "audio/aac" -> "m4a"
        "audio/ogg" -> "ogg"
        "audio/wav", "audio/x-wav" -> "wav"
        else -> null
    }
    if (mimeExtension != null) return mimeExtension
    val pathExtension = Uri.parse(url).path.orEmpty().substringAfterLast('.', "")
        .take(5)
        .lowercase(Locale.ROOT)
        .takeIf { it.matches(Regex("[a-z0-9]+")) }
    if (pathExtension != null) return pathExtension
    return when {
        prefix == "audio" -> "mp3"
        prefix == "video" || prefix.contains("motion") -> "mp4"
        else -> "jpg"
    }
}
