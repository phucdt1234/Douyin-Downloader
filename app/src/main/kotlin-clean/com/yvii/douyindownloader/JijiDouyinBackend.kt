package com.yvii.douyindownloader

import android.net.Uri
import android.util.Base64
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom
import kotlin.math.abs

private const val DOUYIN_BASE_URL = "https://www.douyin.com"
private const val DOUYIN_USER_AGENT =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
        "(KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36"
private val GALLERY_AWEME_TYPES = setOf(2, 68, 150)
private val PLAY_ADDRESS_KEYS = listOf("play_addr_h264", "play_addr_265", "play_addr_256", "play_addr")

internal suspend fun analyzeDouyinWithJiji(
    url: String,
    settings: DownloadSettings,
    onProgress: (String) -> Unit
): AnalyzedMedia = withContext(Dispatchers.IO) {
    onProgress("Resolving Douyin link")
    val resolved = douyinHttpGet(normalizeDouyinUrl(url), settings.cookies)
    extractMusicId(resolved.finalUrl)?.let { musicId ->
        return@withContext analyzeMusic(musicId, resolved.finalUrl, settings.cookies, onProgress)
    }
    val awemeId = extractJijiAwemeId(resolved.finalUrl, resolved.body)
        ?: error("Cannot find Douyin aweme ID in this link.")
    onProgress("Fetching Douyin detail")
    val apiPayload = fetchAwemeDetail(awemeId, settings.cookies)
    val shareBody = runCatching {
        val mediaType = if (
            resolved.finalUrl.contains("/note/") || resolved.finalUrl.contains("/gallery/")
        ) "note" else "video"
        douyinHttpGet(
            "https://www.iesdouyin.com/share/$mediaType/$awemeId/?from_ssr=1",
            settings.cookies,
            mobileUserAgent = true
        ).body
    }.getOrDefault("")
    val payload = apiPayload
        ?: extractDouyinPayloadFromHtml(shareBody)
        ?: extractDouyinPayloadFromHtml(resolved.body)
        ?: error("Douyin returned no downloadable media. Add fresh cookies and try again.")
    parseAwemePayload(payload, resolved.finalUrl, settings.quality)
}

private fun analyzeMusic(
    musicId: String,
    sourceUrl: String,
    cookies: String,
    onProgress: (String) -> Unit
): AnalyzedMedia {
    onProgress("Fetching Douyin music")
    val detailResponse = fetchSignedJson(
        "/aweme/v1/web/music/detail/",
        linkedMapOf("music_id" to musicId),
        cookies
    )
    val detail = detailResponse?.optJSONObject("music_info")
        ?: detailResponse?.optJSONObject("music_detail")
        ?: detailResponse
    var audioCandidates = extractMusicCandidates(detail)
    if (audioCandidates.isEmpty()) {
        val awemePage = fetchSignedJson(
            "/aweme/v1/web/music/aweme/",
            linkedMapOf("music_id" to musicId, "cursor" to "0", "count" to "1"),
            cookies
        )
        audioCandidates = awemePage?.optJSONArray("aweme_list")
            ?.optJSONObject(0)
            ?.optJSONObject("music")
            ?.let(::extractMusicCandidates)
            .orEmpty()
    }
    check(audioCandidates.isNotEmpty()) { "No playable audio found for this Douyin music link." }
    val title = detail?.optString("title")?.takeIf(String::isNotBlank)
        ?: detail?.optString("music_name")?.takeIf(String::isNotBlank)
        ?: "Douyin music $musicId"
    return AnalyzedMedia(
        title = title,
        sourceUrl = sourceUrl,
        audioUrl = audioCandidates.first(),
        audioAlternatives = audioCandidates.drop(1)
    )
}

private fun fetchAwemeDetail(awemeId: String, cookies: String): JSONObject? {
    for (aid in listOf("6383", "1128")) {
        val response = fetchSignedJson(
            "/aweme/v1/web/aweme/detail/",
            linkedMapOf("aweme_id" to awemeId, "aid" to aid),
            cookies
        ) ?: continue
        response.optJSONObject("aweme_detail")?.let { return it }
    }
    return runCatching {
        JSONObject(
            douyinHttpGet(
                "https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=$awemeId",
                cookies
            ).body
        ).optJSONArray("item_list")?.optJSONObject(0)
    }.getOrNull()
}

private fun fetchSignedJson(
    path: String,
    extra: LinkedHashMap<String, String>,
    cookies: String
): JSONObject? = runCatching {
    val params = defaultQuery(cookies).apply { putAll(extra) }
    val query = params.entries.joinToString("&") { (key, value) -> "${encode(key)}=${encode(value)}" }
    val unsignedUrl = "$DOUYIN_BASE_URL$path?$query"
    val signedUrl = XBogus(DOUYIN_USER_AGENT).sign(unsignedUrl)
    JSONObject(douyinHttpGet(signedUrl, cookies).body)
}.getOrNull()

private fun defaultQuery(cookies: String): LinkedHashMap<String, String> = linkedMapOf(
    "device_platform" to "webapp",
    "aid" to "6383",
    "channel" to "channel_pc_web",
    "update_version_code" to "170400",
    "pc_client_type" to "1",
    "pc_libra_divert" to "Windows",
    "version_code" to "290100",
    "version_name" to "29.1.0",
    "cookie_enabled" to "true",
    "screen_width" to "1536",
    "screen_height" to "864",
    "browser_language" to "zh-CN",
    "browser_platform" to "Win32",
    "browser_name" to "Chrome",
    "browser_version" to "139.0.0.0",
    "browser_online" to "true",
    "engine_name" to "Blink",
    "engine_version" to "139.0.0.0",
    "os_name" to "Windows",
    "os_version" to "10",
    "cpu_core_num" to "16",
    "device_memory" to "8",
    "platform" to "PC",
    "downlink" to "10",
    "effective_type" to "4g",
    "round_trip_time" to "200",
    "support_h265" to "1",
    "support_dash" to "1",
    "uifid" to "",
    "msToken" to extractCookie(cookies, "msToken").ifBlank(::fallbackMsToken)
)

private fun parseAwemePayload(
    payload: JSONObject,
    sourceUrl: String,
    quality: QualityChoice
): AnalyzedMedia {
    val galleryItems = galleryItems(payload)
    val topVideo = payload.optJSONObject("video")
    val topVideoCandidates = collectVideoCandidates(topVideo, quality)
    val topLevelLiveCandidates = if (
        payload.isLivePhoto() ||
        payload.optInt("aweme_type", -1) == 2 && galleryItems.size == 1 &&
        topVideo?.optInt("duration", -1) == 0 && topVideoCandidates.isNotEmpty()
    ) {
        topVideoCandidates
    } else {
        emptyList()
    }
    val isGallery = galleryItems.isNotEmpty() ||
        payload.optInt("aweme_type", -1) in GALLERY_AWEME_TYPES && !hasVideoSource(topVideo)
    val images = mutableListOf<MediaItem>()
    val livePhotos = mutableListOf<LivePhotoItem>()
    if (isGallery) {
        galleryItems.forEachIndexed { index, item ->
            val imageCandidates = collectImageCandidates(item)
            val image = imageCandidates.firstOrNull()?.let {
                MediaItem(it, "Image ${index + 1}", imageCandidates.drop(1))
            }
            val liveCandidates = collectLivePhotoVideoCandidates(item, quality).ifEmpty {
                if (index == 0) topLevelLiveCandidates else emptyList()
            }
            if (liveCandidates.isNotEmpty()) {
                livePhotos += LivePhotoItem(
                    image = image,
                    video = MediaItem(liveCandidates.first(), "Motion ${index + 1}", liveCandidates.drop(1)),
                    label = "Live photo ${index + 1}"
                )
            } else if (image != null) {
                images += image
            }
        }
    }
    val videoCandidates = if (isGallery) emptyList() else topVideoCandidates
    val audioCandidates = extractMusicCandidates(payload.optJSONObject("music"))
    return AnalyzedMedia(
        title = payload.optString("desc").takeIf(String::isNotBlank) ?: "Douyin media",
        sourceUrl = sourceUrl,
        videoUrl = videoCandidates.firstOrNull(),
        videoAlternatives = videoCandidates.drop(1),
        audioUrl = audioCandidates.firstOrNull(),
        audioAlternatives = audioCandidates.drop(1),
        images = images,
        livePhotos = livePhotos,
        audioSourceVideoCandidates = topVideoCandidates
    )
}

private fun JSONObject.isLivePhoto(): Boolean = when (val value = opt("is_live_photo")) {
    is Boolean -> value
    is Number -> value.toInt() == 1
    is String -> value == "1" || value.equals("true", ignoreCase = true)
    else -> false
}

private fun collectVideoCandidates(video: JSONObject?, quality: QualityChoice): List<String> {
    video ?: return emptyList()
    val preferred = selectPlayAddress(video, quality)
    val raw = buildList {
        preferred?.optString("uri")?.takeIf(String::isHttpUrl)?.let(::add)
        addAll(preferred.urlList())
        PLAY_ADDRESS_KEYS.forEach { key ->
            val address = video.optJSONObject(key)
            address?.optString("uri")?.takeIf(String::isHttpUrl)?.let(::add)
            addAll(address.urlList())
        }
        val downloadAddress = video.optJSONObject("download_addr")
        downloadAddress?.optString("uri")?.takeIf(String::isHttpUrl)?.let(::add)
        addAll(downloadAddress.urlList())
    }.distinct()
    val direct = mutableListOf<String>()
    val play = mutableListOf<String>()
    val watermarked = mutableListOf<String>()
    raw.forEach { candidate ->
        val cleaned = cleanDouyinUrl(candidate)
        when {
            isWatermarked(cleaned) -> watermarked += cleaned.replace("/playwm/", "/play/")
            Uri.parse(cleaned).host.orEmpty().endsWith("douyin.com") -> play += signIfNeeded(cleaned)
            else -> direct += cleaned
        }
    }
    val constructed = buildSignedPlayUrl(video, preferred, quality)
    return (direct + play + listOfNotNull(constructed) + watermarked).distinct()
}

private fun collectLivePhotoVideoCandidates(item: JSONObject, quality: QualityChoice): List<String> {
    val nestedVideo = item.optJSONObject("video")
    val nested = collectVideoCandidates(nestedVideo, quality)
    val direct = listOf("video_play_addr", "video_download_addr")
        .flatMap { item.optJSONObject(it).urlList() }
        .map(::cleanDouyinUrl)
    return (nested + direct).distinct()
}

private fun selectPlayAddress(video: JSONObject, quality: QualityChoice): JSONObject? {
    val entries = video.optJSONArray("bit_rate").objects().mapNotNull { entry ->
        val address = entry.optJSONObject("play_addr") ?: return@mapNotNull null
        val width = address.optInt("width", entry.optInt("width", 0))
        val height = address.optInt("height", entry.optInt("height", 0))
        val pixels = if (width > 0 && height > 0) width.toLong() * height else maxOf(width, height).toLong()
        val shortEdge = if (width > 0 && height > 0) minOf(width, height) else minOf(width, height).coerceAtLeast(0)
        PlayAddress(entry.optInt("bit_rate", 0), shortEdge, pixels, address)
    }
    val selected = when (quality) {
        QualityChoice.Best -> entries.maxWithOrNull(compareBy<PlayAddress> { it.pixels }.thenBy { it.bitRate })
        QualityChoice.Medium -> entries.minWithOrNull(
            compareBy<PlayAddress> { abs(it.shortEdge - 720) }.thenByDescending { it.bitRate }
        )
        QualityChoice.Small -> entries.minWithOrNull(compareBy<PlayAddress> { it.bitRate }.thenBy { it.pixels })
    }?.address
    if (selected != null) return selected
    return PLAY_ADDRESS_KEYS.firstNotNullOfOrNull { key ->
        video.optJSONObject(key)?.takeIf { it.urlList().isNotEmpty() || it.optString("uri").isNotBlank() }
    }
}

private fun buildSignedPlayUrl(
    video: JSONObject,
    selected: JSONObject?,
    quality: QualityChoice
): String? {
    val uri = selected?.optString("uri")?.takeIf(String::isNotBlank)
        ?: video.optString("vid").takeIf(String::isNotBlank)
        ?: video.optJSONObject("download_addr")?.optString("uri")?.takeIf(String::isNotBlank)
        ?: return null
    val ratio = when (quality) {
        QualityChoice.Best -> "1080p"
        QualityChoice.Medium -> "720p"
        QualityChoice.Small -> "540p"
    }
    val params = linkedMapOf(
        "video_id" to uri,
        "ratio" to ratio,
        "line" to "0",
        "is_play_url" to "1",
        "watermark" to "0",
        "source" to "PackSourceEnum_PUBLISH"
    )
    val query = params.entries.joinToString("&") { (key, value) -> "${encode(key)}=${encode(value)}" }
    return XBogus(DOUYIN_USER_AGENT).sign("$DOUYIN_BASE_URL/aweme/v1/play/?$query")
}

private fun collectImageCandidates(item: JSONObject): List<String> {
    val sources = listOf(
        Triple(item.opt("watermark_free_download_url_list"), item, 0),
        Triple(item.opt("origin_image"), item.optJSONObject("origin_image"), 1),
        Triple(item.opt("display_image"), item.optJSONObject("display_image"), 2),
        Triple(item, item, 3),
        Triple(item.opt("download_url"), item.optJSONObject("download_url"), 4),
        Triple(item.opt("download_addr"), item.optJSONObject("download_addr"), 5),
        Triple(item.opt("download_url_list"), item, 6),
        Triple(item.opt("owner_watermark_image"), item.optJSONObject("owner_watermark_image"), 7)
    )
    return sources.flatMap { (source, metadata, rank) ->
        extractUrls(source).map { url ->
            val clean = cleanDouyinUrl(url)
            RankedImage(clean, isWatermarked(clean) || rank >= 4, imagePixels(metadata), rank)
        }
    }.distinctBy(RankedImage::url)
        .sortedWith(compareBy<RankedImage> { it.watermarked }.thenByDescending { it.pixels }.thenBy { it.rank })
        .map(RankedImage::url)
}

private fun extractMusicCandidates(detail: JSONObject?): List<String> {
    detail ?: return emptyList()
    val nestedMusic = detail.optJSONObject("music")
    val nestedInfo = detail.optJSONObject("music_info")
    return listOf(
        detail.opt("play_url"),
        detail.opt("play_url_lowbr"),
        detail.opt("audio_url"),
        detail.opt("download_url"),
        nestedMusic?.opt("play_url"),
        nestedMusic?.opt("play_url_lowbr"),
        nestedInfo?.opt("play_url")
    ).flatMap(::extractUrls).map(::cleanDouyinUrl).distinct()
}

private fun galleryItems(payload: JSONObject): List<JSONObject> {
    val imagePost = payload.optJSONObject("image_post_info")
    listOf("images", "image_list").forEach { key ->
        imagePost?.optJSONArray(key).objects().takeIf(List<JSONObject>::isNotEmpty)?.let { return it }
    }
    listOf("images", "image_list").forEach { key ->
        payload.optJSONArray(key).objects().takeIf(List<JSONObject>::isNotEmpty)?.let { return it }
    }
    return emptyList()
}

private fun hasVideoSource(video: JSONObject?): Boolean = video != null && (
    PLAY_ADDRESS_KEYS.any { video.optJSONObject(it).urlList().isNotEmpty() || video.optJSONObject(it)?.optString("uri").orEmpty().isNotBlank() } ||
        video.optString("vid").isNotBlank() || video.optJSONObject("download_addr")?.optString("uri").orEmpty().isNotBlank()
    )

private fun extractUrls(source: Any?): List<String> = when (source) {
    is JSONObject -> source.urlList()
    is JSONArray -> source.strings()
    is String -> listOf(source).filter(String::isNotBlank)
    else -> emptyList()
}

private fun JSONObject?.urlList(): List<String> = this?.let {
    it.optJSONArray("url_list").strings() + it.optJSONArray("urlList").strings()
}.orEmpty()

private fun JSONArray?.objects(): List<JSONObject> =
    if (this == null) emptyList() else (0 until length()).mapNotNull(::optJSONObject)

private fun JSONArray?.strings(): List<String> =
    if (this == null) emptyList() else (0 until length()).mapNotNull { optString(it).takeIf(String::isNotBlank) }

private fun imagePixels(source: JSONObject?): Long {
    source ?: return 0
    val width = source.optLong("width", source.optLong("w", 0))
    val height = source.optLong("height", source.optLong("h", 0))
    return if (width > 0 && height > 0) width * height else maxOf(width, height)
}

private fun signIfNeeded(url: String): String = XBogus(DOUYIN_USER_AGENT).sign(
    url.substringBefore('#').let { base ->
        val queryStart = base.indexOf('?')
        if (queryStart < 0) return@let base
        val query = base.substring(queryStart + 1)
            .split('&')
            .filterNot { parameter ->
                parameter.substringBefore('=').equals("X-Bogus", ignoreCase = true) ||
                    parameter.substringBefore('=').equals("a_bogus", ignoreCase = true)
            }
            .joinToString("&")
        base.substring(0, queryStart) + if (query.isBlank()) "" else "?$query"
    }
)

private fun isWatermarked(url: String): Boolean = listOf(
    "tplv-dy-water", "dy-water", "owner_watermark", "watermark_image", "watermark=1", "playwm"
).any { url.contains(it, ignoreCase = true) }

private fun extractMusicId(url: String): String? = Regex("/music/(\\d{15,20})").find(url)?.groupValues?.getOrNull(1)

private fun extractJijiAwemeId(url: String, body: String): String? {
    val patterns = listOf(
        Regex("/(?:video|note|gallery|slides)/(\\d{15,20})"),
        Regex("modal_id=(\\d{15,20})"),
        Regex("\"aweme_id\"\\s*:\\s*\"(\\d{15,20})\""),
        Regex("\"group_id\"\\s*:\\s*\"(\\d{15,20})\"")
    )
    return patterns.firstNotNullOfOrNull { pattern ->
        pattern.find(url)?.groupValues?.getOrNull(1) ?: pattern.find(body)?.groupValues?.getOrNull(1)
    }
}

private fun extractDouyinPayloadFromHtml(html: String): JSONObject? {
    val assignment = Regex("window\\._ROUTER_DATA\\s*=\\s*").find(html) ?: return null
    val raw = extractJsonObject(html, assignment.range.last + 1) ?: return null
    return runCatching { findDouyinPayload(JSONObject(raw)) }.getOrNull()
}

private fun extractJsonObject(text: String, start: Int): String? {
    val objectStart = text.indexOf('{', start)
    if (objectStart < 0) return null
    var depth = 0
    var inString = false
    var escaped = false
    for (index in objectStart until text.length) {
        val character = text[index]
        if (inString) {
            if (escaped) escaped = false
            else if (character == '\\') escaped = true
            else if (character == '"') inString = false
            continue
        }
        when (character) {
            '"' -> inString = true
            '{' -> depth++
            '}' -> if (--depth == 0) return text.substring(objectStart, index + 1)
        }
    }
    return null
}

private fun findDouyinPayload(value: Any?): JSONObject? = when (value) {
    is JSONObject -> {
        value.optJSONObject("videoInfoRes")?.optJSONArray("item_list")?.optJSONObject(0)?.let { return it }
        if (value.has("aweme_id") && (value.has("video") || value.has("image_post_info") || value.has("images"))) {
            return value
        }
        val keys = value.keys()
        while (keys.hasNext()) findDouyinPayload(value.opt(keys.next()))?.let { return it }
        null
    }
    is JSONArray -> (0 until value.length()).firstNotNullOfOrNull { findDouyinPayload(value.opt(it)) }
    else -> null
}

private fun douyinHttpGet(url: String, cookies: String, mobileUserAgent: Boolean = false): HttpResult {
    val connection = URL(url).openConnection() as HttpURLConnection
    connection.connectTimeout = 15_000
    connection.readTimeout = 30_000
    connection.instanceFollowRedirects = true
    connection.setRequestProperty(
        "User-Agent",
        if (mobileUserAgent) {
            "Mozilla/5.0 (iPhone; CPU iPhone OS 17_0 like Mac OS X) AppleWebKit/605.1.15 Mobile/15E148"
        } else DOUYIN_USER_AGENT
    )
    connection.setRequestProperty("Referer", "$DOUYIN_BASE_URL/?recommend=1")
    connection.setRequestProperty("Accept", "*/*")
    connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7")
    if (cookies.isNotBlank()) connection.setRequestProperty("Cookie", cookies)
    val stream = runCatching { connection.inputStream }.getOrElse { connection.errorStream ?: throw it }
    val body = stream.bufferedReader().use { it.readText() }
    if (connection.responseCode >= 400) error("Douyin HTTP ${connection.responseCode}")
    return HttpResult(connection.url.toString(), body)
}

private fun fallbackMsToken(): String {
    // ponytail: upstream first requests a real mssdk token; Android uses its documented random fallback until signed API rejects it.
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
    val random = SecureRandom()
    return buildString(184) {
        repeat(182) { append(alphabet[random.nextInt(alphabet.length)]) }
        append("==")
    }
}

private fun extractCookie(header: String, name: String): String = header.split(';')
    .map(String::trim)
    .firstOrNull { it.startsWith("$name=") }
    ?.substringAfter('=')
    .orEmpty()

private fun normalizeDouyinUrl(url: String): String = if (Uri.parse(url).scheme == null) "https://$url" else url

private fun cleanDouyinUrl(url: String): String = url
    .replace("\\u002F", "/")
    .replace("\\/", "/")
    .replace("\\u0026", "&")
    .replace("&amp;", "&")
    .trimEnd('\\')

private fun String.isHttpUrl(): Boolean = startsWith("http://") || startsWith("https://")

private fun encode(value: String): String = URLEncoder.encode(value, StandardCharsets.UTF_8.name())

private data class PlayAddress(val bitRate: Int, val shortEdge: Int, val pixels: Long, val address: JSONObject)
private data class RankedImage(val url: String, val watermarked: Boolean, val pixels: Long, val rank: Int)

private class XBogus(private val userAgent: String) {
    private val alphabet = "Dkdpgh4ZKsQB80/Mfvw36XI1R25-WUAlEi7NLboqYTOPuzmFjJnryx9HVGcaStCe="

    fun sign(url: String): String {
        val uaDigest = md5Bytes(
            Base64.encodeToString(rc4(byteArrayOf(0, 1, 12), userAgent.toByteArray(StandardCharsets.ISO_8859_1)), Base64.NO_WRAP)
                .toByteArray(StandardCharsets.ISO_8859_1)
        )
        val emptyDigest = md5Bytes(hexToBytes("d41d8cd98f00b204e9800998ecf8427e"))
        val urlDigest = md5Bytes(md5Bytes(url.toByteArray(StandardCharsets.ISO_8859_1)))
        val timestamp = System.currentTimeMillis() / 1000
        val constant = 536919696L
        val payload = mutableListOf(
            64, 0, 1, 12,
            urlDigest[14].unsigned(), urlDigest[15].unsigned(),
            emptyDigest[14].unsigned(), emptyDigest[15].unsigned(),
            uaDigest[14].unsigned(), uaDigest[15].unsigned(),
            ((timestamp shr 24) and 255).toInt(), ((timestamp shr 16) and 255).toInt(),
            ((timestamp shr 8) and 255).toInt(), (timestamp and 255).toInt(),
            ((constant shr 24) and 255).toInt(), ((constant shr 16) and 255).toInt(),
            ((constant shr 8) and 255).toInt(), (constant and 255).toInt()
        )
        payload += payload.reduce(Int::xor)
        val merged = payload.filterIndexed { index, _ -> index % 2 == 0 } +
            payload.filterIndexed { index, _ -> index % 2 == 1 }
        val order = listOf(0, 10, 1, 11, 2, 12, 3, 13, 4, 14, 5, 15, 6, 16, 7, 17, 8, 18, 9)
        val converted = order.map { merged[it].toByte() }.toByteArray()
        val garbled = byteArrayOf(2, 0xff.toByte()) + rc4(byteArrayOf(0xff.toByte()), converted)
        val signature = buildString {
            var index = 0
            while (index < garbled.size) {
                val value = (garbled[index].unsigned() shl 16) or
                    (garbled[index + 1].unsigned() shl 8) or garbled[index + 2].unsigned()
                append(alphabet[(value and 0xfc0000) shr 18])
                append(alphabet[(value and 0x03f000) shr 12])
                append(alphabet[(value and 0x000fc0) shr 6])
                append(alphabet[value and 0x00003f])
                index += 3
            }
        }
        return "$url${if (url.contains('?')) '&' else '?'}X-Bogus=$signature"
    }

    private fun md5Bytes(value: ByteArray): ByteArray = MessageDigest.getInstance("MD5").digest(value)

    private fun hexToBytes(value: String): ByteArray = ByteArray(value.length / 2) { index ->
        value.substring(index * 2, index * 2 + 2).toInt(16).toByte()
    }

    private fun rc4(key: ByteArray, data: ByteArray): ByteArray {
        val state = IntArray(256) { it }
        var keyIndex = 0
        for (index in state.indices) {
            keyIndex = (keyIndex + state[index] + key[index % key.size].unsigned()) and 255
            val swap = state[index]
            state[index] = state[keyIndex]
            state[keyIndex] = swap
        }
        var left = 0
        var right = 0
        return ByteArray(data.size) { index ->
            left = (left + 1) and 255
            right = (right + state[left]) and 255
            val swap = state[left]
            state[left] = state[right]
            state[right] = swap
            (data[index].unsigned() xor state[(state[left] + state[right]) and 255]).toByte()
        }
    }

    private fun Byte.unsigned(): Int = toInt() and 255
}

internal fun verifyJijiParserContract() {
    val video = parseAwemePayload(
        JSONObject(
            """{"aweme_id":"1","video":{"bit_rate":[{"bit_rate":100,"play_addr":{"width":720,"height":1280,"url_list":["https://cdn/720.mp4"]}},{"bit_rate":200,"play_addr":{"width":1080,"height":1920,"url_list":["https://cdn/1080.mp4"]}}]},"music":{"play_url":{"url_list":["https://cdn/audio.mp3"]}}}"""
        ),
        "https://www.douyin.com/video/1",
        QualityChoice.Best
    )
    check(video.videoUrl == "https://cdn/1080.mp4" && video.audioUrl == "https://cdn/audio.mp3")
    val gallery = parseAwemePayload(
        JSONObject(
            """{"aweme_id":"2","aweme_type":68,"image_post_info":{"images":[{"display_image":{"url_list":["https://cdn/1.webp"]}},{"origin_image":{"url_list":["https://cdn/2.webp"]}},{"display_image":{"url_list":["https://cdn/live.webp"]},"video":{"play_addr":{"url_list":["https://cdn/live.mp4"]}}}]}}"""
        ),
        "https://www.douyin.com/note/2",
        QualityChoice.Best
    )
    check(gallery.images.size == 2)
    check(gallery.livePhotos.single().image?.url == "https://cdn/live.webp")
    check(gallery.livePhotos.single().video.url == "https://cdn/live.mp4")
    val topLevelLivePhoto = parseAwemePayload(
        JSONObject(
            """{"aweme_id":"3","aweme_type":68,"is_live_photo":1,"images":[{"display_image":{"url_list":["https://cdn/live-cover.webp"]}},{"display_image":{"url_list":["https://cdn/static.webp"]}}],"video":{"play_addr":{"url_list":["https://cdn/top-live.mp4"]}}}"""
        ),
        "https://www.douyin.com/note/3",
        QualityChoice.Best
    )
    check(topLevelLivePhoto.livePhotos.single().image?.url == "https://cdn/live-cover.webp")
    check(topLevelLivePhoto.livePhotos.single().video.url == "https://cdn/top-live.mp4")
    check(topLevelLivePhoto.images.single().url == "https://cdn/static.webp")
    val legacyLivePhoto = parseAwemePayload(
        JSONObject(
            """{"aweme_id":"legacy-live","aweme_type":2,"images":[{"url_list":["https://cdn/legacy-cover.webp"]}],"video":{"duration":0,"play_addr":{"url_list":["https://cdn/legacy-live.mp4"]}}}"""
        ),
        "https://www.douyin.com/note/legacy-live",
        QualityChoice.Best
    )
    check(legacyLivePhoto.images.isEmpty())
    check(legacyLivePhoto.livePhotos.single().video.url == "https://cdn/legacy-live.mp4")
    check(legacyLivePhoto.audioSourceVideoCandidates.single() == "https://cdn/legacy-live.mp4")
    val manyImages = parseAwemePayload(
        JSONObject().put("aweme_id", "4").put(
            "images",
            JSONArray().apply {
                repeat(48) { index ->
                    put(JSONObject().put("display_image", JSONObject().put("url_list", JSONArray().put("https://cdn/$index.webp"))))
                }
            }
        ),
        "https://www.douyin.com/note/4",
        QualityChoice.Best
    )
    check(manyImages.images.size == 48)
    val resigned = signIfNeeded("https://www.douyin.com/aweme/v1/play/?video_id=test&X-Bogus=stale")
    check(resigned.countSubstring("X-Bogus=") == 1 && "stale" !in resigned)
    check(mimeTypeForFileName("track.m4a") == "audio/mp4")
}

private fun String.countSubstring(value: String): Int = windowed(value.length).count { it == value }
