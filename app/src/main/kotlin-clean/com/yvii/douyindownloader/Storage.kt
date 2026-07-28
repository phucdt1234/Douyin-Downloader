package com.yvii.douyindownloader

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

private const val STORAGE_PREFERENCES = "download_storage"
private const val STORAGE_TREE_URI = "tree_uri"
private const val DEFAULT_RELATIVE_PATH = "DCIM/DouyinDownloader"

data class SaveDestination(val treeUri: String? = null) {
    val label: String
        get() = treeUri?.let(::treeUriLabel) ?: "Internal storage/$DEFAULT_RELATIVE_PATH"
}

fun loadSaveDestination(context: Context): SaveDestination {
    val value = context.getSharedPreferences(STORAGE_PREFERENCES, Context.MODE_PRIVATE)
        .getString(STORAGE_TREE_URI, null)
    return SaveDestination(value)
}

fun persistSaveDestination(context: Context, uri: Uri): SaveDestination {
    context.contentResolver.takePersistableUriPermission(
        uri,
        Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
    )
    val destination = SaveDestination(uri.toString())
    context.getSharedPreferences(STORAGE_PREFERENCES, Context.MODE_PRIVATE)
        .edit()
        .putString(STORAGE_TREE_URI, destination.treeUri)
        .apply()
    return destination
}

fun resetSaveDestination(context: Context): SaveDestination {
    context.getSharedPreferences(STORAGE_PREFERENCES, Context.MODE_PRIVATE)
        .edit()
        .remove(STORAGE_TREE_URI)
        .apply()
    return SaveDestination()
}

internal fun saveContent(
    context: Context,
    destination: SaveDestination,
    displayName: String,
    mimeType: String,
    write: (OutputStream) -> Unit
): Uri {
    val treeUri = destination.treeUri?.let(Uri::parse)
    return when {
        treeUri != null -> saveToTree(context, treeUri, displayName, mimeType, write)
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q ->
            saveToMediaStore(context, displayName, mimeType, write)
        else -> saveLegacy(context, displayName, mimeType, write)
    }
}

private fun saveToTree(
    context: Context,
    treeUri: Uri,
    displayName: String,
    mimeType: String,
    write: (OutputStream) -> Unit
): Uri {
    val resolver = context.contentResolver
    val parent = DocumentsContract.buildDocumentUriUsingTree(
        treeUri,
        DocumentsContract.getTreeDocumentId(treeUri)
    )
    val uri = DocumentsContract.createDocument(resolver, parent, mimeType, displayName)
        ?: error("Cannot create $displayName in selected folder.")
    return try {
        resolver.openOutputStream(uri, "w")?.use(write)
            ?: error("Cannot open $displayName for writing.")
        uri
    } catch (error: Throwable) {
        runCatching { DocumentsContract.deleteDocument(resolver, uri) }
        throw error
    }
}

@androidx.annotation.RequiresApi(Build.VERSION_CODES.Q)
private fun saveToMediaStore(
    context: Context,
    displayName: String,
    mimeType: String,
    write: (OutputStream) -> Unit
): Uri {
    val resolver = context.contentResolver
    val values = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, displayName)
        put(MediaStore.MediaColumns.MIME_TYPE, mimeType)
        put(MediaStore.MediaColumns.RELATIVE_PATH, DEFAULT_RELATIVE_PATH)
        put(MediaStore.MediaColumns.IS_PENDING, 1)
    }
    val preferredCollection = when {
        mimeType.startsWith("image/") -> MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        mimeType.startsWith("video/") -> MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        mimeType.startsWith("audio/") -> MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
        else -> MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
    }
    val fallbackCollection = MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
    val uri = listOf(preferredCollection, fallbackCollection).distinct().firstNotNullOfOrNull { collection ->
        runCatching { resolver.insert(collection, values) }.getOrNull()
    }
        ?: error("Cannot create $displayName in $DEFAULT_RELATIVE_PATH.")
    return try {
        resolver.openOutputStream(uri, "w")?.use(write)
            ?: error("Cannot open $displayName for writing.")
        resolver.update(uri, ContentValues().apply { put(MediaStore.MediaColumns.IS_PENDING, 0) }, null, null)
        uri
    } catch (error: Throwable) {
        resolver.delete(uri, null, null)
        throw error
    }
}

@Suppress("DEPRECATION")
private fun saveLegacy(
    context: Context,
    displayName: String,
    mimeType: String,
    write: (OutputStream) -> Unit
): Uri {
    val directory = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "DouyinDownloader")
    check(directory.exists() || directory.mkdirs()) { "Cannot create ${directory.absolutePath}" }
    val file = File(directory, displayName)
    try {
        FileOutputStream(file).use(write)
    } catch (error: Throwable) {
        file.delete()
        throw error
    }
    MediaScannerConnection.scanFile(context, arrayOf(file.absolutePath), arrayOf(mimeType), null)
    return Uri.fromFile(file)
}

internal fun mimeTypeForFileName(fileName: String): String = when (fileName.substringAfterLast('.', "").lowercase()) {
    "jpg", "jpeg" -> "image/jpeg"
    "png" -> "image/png"
    "webp" -> "image/webp"
    "gif" -> "image/gif"
    "mp4", "m4v" -> "video/mp4"
    "webm" -> "video/webm"
    "mp3" -> "audio/mpeg"
    "m4a", "aac" -> "audio/mp4"
    "ogg", "opus" -> "audio/ogg"
    "wav" -> "audio/wav"
    else -> "application/octet-stream"
}

private fun treeUriLabel(value: String): String = runCatching {
    val documentId = DocumentsContract.getTreeDocumentId(Uri.parse(value))
    val parts = documentId.split(':', limit = 2)
    val volume = if (parts.firstOrNull() == "primary") "Internal storage" else parts.firstOrNull().orEmpty()
    listOf(volume, parts.getOrNull(1).orEmpty()).filter(String::isNotBlank).joinToString("/")
}.getOrDefault("Selected folder")
