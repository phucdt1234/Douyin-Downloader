package com.yvii.douyindownloader

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ApplicationInfo
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import coil.compose.AsyncImage
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private var sharedText by mutableStateOf<String?>(null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE != 0) verifyParserContract()
        requestLegacyStoragePermission()
        sharedText = intent.sharedText()
        enableEdgeToEdge()
        setContent {
            DownloaderTheme {
                DownloaderApp(sharedText)
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        sharedText = intent.sharedText()
    }

    private fun requestLegacyStoragePermission() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.P &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
            PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                STORAGE_PERMISSION_REQUEST
            )
        }
    }

    private companion object {
        const val STORAGE_PERMISSION_REQUEST = 100
    }
}

@Composable
private fun DownloaderTheme(content: @Composable () -> Unit) {
    val darkTheme = isSystemInDarkTheme()
    val context = LocalContext.current
    val colors = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        if (darkTheme) darkColorScheme() else lightColorScheme()
    }
    MaterialTheme(colorScheme = colors, content = content)
}

private fun Intent.sharedText(): String? = when (action) {
    Intent.ACTION_SEND -> getStringExtra(Intent.EXTRA_TEXT)
    Intent.ACTION_VIEW -> dataString
    else -> null
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DownloaderApp(sharedText: String?) {
    val context = LocalContext.current
    val clipboard = LocalClipboardManager.current
    val scope = rememberCoroutineScope()
    var mode by remember { mutableStateOf(DownloadMode.Douyin) }
    var input by remember { mutableStateOf("") }
    var busy by remember { mutableStateOf(false) }
    var showSettings by remember { mutableStateOf(false) }
    var settingsByMode by remember { mutableStateOf(loadSettings(context)) }
    var analyzed by remember { mutableStateOf<AnalyzedMedia?>(null) }
    var status by remember { mutableStateOf("Ready") }
    var saveDestination by remember { mutableStateOf(loadSaveDestination(context)) }
    var log by remember { mutableStateOf("Downloads save to ${saveDestination.label}.") }
    val selectedImages = remember { mutableStateListOf<String>() }
    val detectedUrl = remember(input) { extractUrl(input) }
    val settings = settingsByMode[mode] ?: DownloadSettings()
    val folderLauncher = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocumentTree()) { uri: Uri? ->
        if (uri != null) {
            runCatching { persistSaveDestination(context, uri) }
                .onSuccess { destination ->
                    saveDestination = destination
                    status = "Save folder updated"
                    log = destination.label
                }
                .onFailure { error ->
                    status = "Cannot use selected folder"
                    log = error.message ?: error.javaClass.simpleName
                }
        }
    }

    LaunchedEffect(sharedText) {
        if (!sharedText.isNullOrBlank()) input = sharedText
    }

    if (showSettings) {
        SettingsDialog(
            mode = mode,
            initial = settings,
            saveLocation = saveDestination.label,
            customSaveLocation = saveDestination.treeUri != null,
            onChooseFolder = { folderLauncher.launch(saveDestination.treeUri?.let(Uri::parse)) },
            onUseDefaultFolder = {
                saveDestination = resetSaveDestination(context)
                status = "Default folder restored"
                log = saveDestination.label
            },
            onDismiss = { showSettings = false },
            onSave = { newSettings ->
                val updated = settingsByMode + (mode to newSettings)
                settingsByMode = updated
                saveSettings(context, updated)
                showSettings = false
            }
        )
    }

    fun setProgress(message: String) {
        scope.launch { status = message }
    }

    fun analyze() {
        val url = detectedUrl ?: return
        busy = true
        status = "Analyzing..."
        log = ""
        scope.launch {
            runCatching { analyzeByMode(context, mode, url, settings, ::setProgress) }
                .onSuccess { media ->
                    analyzed = media
                    selectedImages.clear()
                    selectedImages.addAll(media.images.map(MediaItem::url))
                    selectedImages.addAll(media.livePhotos.map(LivePhotoItem::selectionKey))
                    status = "Found ${mediaSummary(media)}"
                    log = "Analyzed: ${media.sourceUrl}"
                }
                .onFailure { error ->
                    status = "Analyze failed"
                    log = error.message ?: error.javaClass.simpleName
                }
            busy = false
        }
    }

    fun startDownload() {
        val url = detectedUrl ?: return
        busy = true
        status = "Starting..."
        log = ""
        scope.launch {
            runCatching {
                val current = analyzed ?: analyzeByMode(context, mode, url, settings, ::setProgress).also {
                    analyzed = it
                    selectedImages.clear()
                    selectedImages.addAll(it.images.map(MediaItem::url))
                    selectedImages.addAll(it.livePhotos.map(LivePhotoItem::selectionKey))
                }
                download(context, mode, current, settings, selectedImages.toSet(), ::setProgress)
            }.onSuccess { location ->
                status = "Downloaded"
                log = "Saved to $location"
            }.onFailure { error ->
                status = "Download failed"
                log = error.message ?: error.javaClass.simpleName
            }
            busy = false
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Douyin Downloader") },
                actions = { TextButton(onClick = { showSettings = true }) { Text("Settings") } }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Paste link", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text(
                "Share text accepted. First URL is detected automatically.",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ModeChip(mode, DownloadMode.Douyin, Modifier.weight(1f)) { selected ->
                    mode = selected
                    analyzed = null
                    selectedImages.clear()
                }
                ModeChip(mode, DownloadMode.Video, Modifier.weight(1f)) { selected ->
                    mode = selected
                    analyzed = null
                    selectedImages.clear()
                }
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ModeChip(mode, DownloadMode.Extra, Modifier.weight(1f)) { selected ->
                    mode = selected
                    analyzed = null
                    selectedImages.clear()
                }
                Spacer(Modifier.weight(1f))
            }
            SurfaceCard {
                OutlinedTextField(
                    value = input,
                    onValueChange = { value ->
                        input = value
                        analyzed = null
                        selectedImages.clear()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 5,
                    label = { Text("URL or share text") }
                )
                Spacer(Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedButton(
                        onClick = {
                            val text = clipboard.getText()?.text.orEmpty()
                            input = text
                            analyzed = null
                            selectedImages.clear()
                            status = if (extractUrl(text) == null) "No link found in clipboard" else "Link detected"
                        },
                        modifier = Modifier.weight(1f)
                    ) { Text("Paste") }
                    OutlinedButton(
                        onClick = ::analyze,
                        enabled = detectedUrl != null && !busy,
                        modifier = Modifier.weight(1f)
                    ) { Text("Analyze") }
                    Button(
                        onClick = ::startDownload,
                        enabled = detectedUrl != null && !busy,
                        modifier = Modifier.weight(1.2f)
                    ) {
                        if (busy) {
                            CircularProgressIndicator(Modifier.size(18.dp), strokeWidth = 2.dp)
                            Spacer(Modifier.width(8.dp))
                        }
                        Text("Download")
                    }
                }
                Spacer(Modifier.height(12.dp))
                Text("Detected: ${detectedUrl ?: "none"}", maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
            analyzed?.let { media -> AnalyzedCard(media, selectedImages) }
            SurfaceCard {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Box(
                        Modifier
                            .size(10.dp)
                            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(50))
                    )
                    Text(status, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                }
                Spacer(Modifier.height(8.dp))
                SelectionContainer { Text(log, color = MaterialTheme.colorScheme.onSurfaceVariant) }
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}

@Composable
private fun ModeChip(
    selectedMode: DownloadMode,
    mode: DownloadMode,
    modifier: Modifier,
    onSelect: (DownloadMode) -> Unit
) {
    FilterChip(
        selected = selectedMode == mode,
        onClick = { onSelect(mode) },
        modifier = modifier.heightIn(min = 64.dp),
        label = {
            Column(Modifier.padding(vertical = 4.dp)) {
                Text(mode.title, fontWeight = FontWeight.SemiBold)
                Text(mode.subtitle, style = MaterialTheme.typography.labelSmall, maxLines = 2)
            }
        }
    )
}

@Composable
private fun SurfaceCard(content: @Composable ColumnScope.() -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        color = MaterialTheme.colorScheme.surfaceContainer
    ) {
        Column(Modifier.padding(16.dp), content = content)
    }
}

@Composable
private fun AnalyzedCard(media: AnalyzedMedia, selectedImages: MutableList<String>) {
    SurfaceCard {
        Text(media.title.ifBlank { "Media" }, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))
        Text(mediaSummary(media), color = MaterialTheme.colorScheme.onSurfaceVariant)
        if (media.images.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            Text("Choose images", style = MaterialTheme.typography.titleSmall)
            media.images.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            if (item.url in selectedImages) selectedImages.remove(item.url) else selectedImages.add(item.url)
                        }
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = item.url in selectedImages,
                        onCheckedChange = {
                            if (item.url in selectedImages) selectedImages.remove(item.url) else selectedImages.add(item.url)
                        }
                    )
                    AsyncImage(
                        model = item.url,
                        contentDescription = item.label,
                        modifier = Modifier
                            .size(72.dp)
                            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(Modifier.width(10.dp))
                    Column(Modifier.weight(1f)) {
                        Text(item.label, style = MaterialTheme.typography.bodyMedium)
                        Text(
                            item.url,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
        if (media.livePhotos.isNotEmpty()) {
            Spacer(Modifier.height(12.dp))
            Text("Choose live photos", style = MaterialTheme.typography.titleSmall)
            media.livePhotos.forEach { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            if (item.selectionKey in selectedImages) {
                                selectedImages.remove(item.selectionKey)
                            } else {
                                selectedImages.add(item.selectionKey)
                            }
                        }
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = item.selectionKey in selectedImages,
                        onCheckedChange = {
                            if (item.selectionKey in selectedImages) {
                                selectedImages.remove(item.selectionKey)
                            } else {
                                selectedImages.add(item.selectionKey)
                            }
                        }
                    )
                    AsyncImage(
                        model = item.image?.url,
                        contentDescription = item.label,
                        modifier = Modifier
                            .size(72.dp)
                            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(Modifier.width(10.dp))
                    Column(Modifier.weight(1f)) {
                        Text(item.label, style = MaterialTheme.typography.bodyMedium)
                        Text(
                            "Still image + motion video",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SettingsDialog(
    mode: DownloadMode,
    initial: DownloadSettings,
    saveLocation: String,
    customSaveLocation: Boolean,
    onChooseFolder: () -> Unit,
    onUseDefaultFolder: () -> Unit,
    onDismiss: () -> Unit,
    onSave: (DownloadSettings) -> Unit
) {
    var draft by remember(mode, initial) { mutableStateOf(initial) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("${mode.title} settings") },
        text = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("Save location", style = MaterialTheme.typography.titleSmall)
                Text(
                    saveLocation,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick = onChooseFolder) { Text("Choose folder") }
                    if (customSaveLocation) {
                        TextButton(onClick = onUseDefaultFolder) { Text("Use default") }
                    }
                }
                when (mode) {
                    DownloadMode.Douyin -> {
                        CompactDropdown("Media", draft.mediaChoice, MediaChoice.entries, MediaChoice::label) {
                            draft = draft.copy(mediaChoice = it)
                        }
                        CompactDropdown("Quality", draft.quality, QualityChoice.entries, QualityChoice::label) {
                            draft = draft.copy(quality = it)
                        }
                        CompactDropdown("File type", draft.fileType, FileTypeChoice.entries, FileTypeChoice::label) {
                            draft = draft.copy(fileType = it)
                        }
                        CompactDropdown(
                            "Image format",
                            draft.imageFormat,
                            ImageFormatChoice.entries,
                            ImageFormatChoice::label
                        ) { draft = draft.copy(imageFormat = it) }
                        OutlinedTextField(
                            value = draft.cookies,
                            onValueChange = { draft = draft.copy(cookies = it) },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("Douyin cookie header (optional)") },
                            minLines = 2
                        )
                    }
                    DownloadMode.Video -> {
                        CompactDropdown("Media", draft.mediaChoice, MediaChoice.entries, MediaChoice::label) {
                            draft = draft.copy(mediaChoice = it)
                        }
                        CompactDropdown("Quality", draft.quality, QualityChoice.entries, QualityChoice::label) {
                            draft = draft.copy(quality = it)
                        }
                        CompactDropdown("File type", draft.fileType, FileTypeChoice.entries, FileTypeChoice::label) {
                            draft = draft.copy(fileType = it)
                        }
                        SettingSwitch("Update yt-dlp before video downloads", draft.updateYtDlp) {
                            draft = draft.copy(updateYtDlp = it)
                        }
                        SettingSwitch("Write thumbnails in video mode", draft.includeThumbnail) {
                            draft = draft.copy(includeThumbnail = it)
                        }
                    }
                    DownloadMode.Extra -> {
                        CompactDropdown("File type", draft.fileType, FileTypeChoice.entries, FileTypeChoice::label) {
                            draft = draft.copy(fileType = it)
                        }
                        Text(
                            "Warning: public cobalt APIs may require auth, rate-limit, or log requests. " +
                                "Best use your own cobalt instance and direct media URLs when possible.",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall
                        )
                        OutlinedTextField(
                            value = draft.cobaltApi,
                            onValueChange = { draft = draft.copy(cobaltApi = it) },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("cobalt API base URL") }
                        )
                        CompactDropdown("downloadMode", draft.cobaltDownloadMode, listOf("auto", "audio", "mute"), { it }) {
                            draft = draft.copy(cobaltDownloadMode = it)
                        }
                        CompactDropdown(
                            "videoQuality",
                            draft.cobaltVideoQuality,
                            listOf("max", "2160", "1440", "1080", "720", "480", "360"),
                            { it }
                        ) { draft = draft.copy(cobaltVideoQuality = it) }
                        CompactDropdown(
                            "audioFormat",
                            draft.cobaltAudioFormat,
                            listOf("best", "mp3", "ogg", "wav", "opus"),
                            { it }
                        ) { draft = draft.copy(cobaltAudioFormat = it) }
                        CompactDropdown(
                            "audioBitrate",
                            draft.cobaltAudioBitrate,
                            listOf("320", "256", "128", "96", "64"),
                            { it }
                        ) { draft = draft.copy(cobaltAudioBitrate = it) }
                        OutlinedTextField(
                            value = draft.cobaltAuthorization,
                            onValueChange = { draft = draft.copy(cobaltAuthorization = it) },
                            modifier = Modifier.fillMaxWidth(),
                            label = { Text("Authorization (Api-Key ... or Bearer ...)") },
                            minLines = 2
                        )
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = { onSave(draft) }) { Text("Save") } },
        dismissButton = { TextButton(onClick = onDismiss) { Text("Cancel") } }
    )
}

@Composable
private fun <Value> CompactDropdown(
    label: String,
    selected: Value,
    options: List<Value>,
    valueLabel: (Value) -> String,
    onSelect: (Value) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(label, modifier = Modifier.weight(1f))
        Box {
            OutlinedButton(onClick = { expanded = true }) { Text(valueLabel(selected)) }
            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(valueLabel(option)) },
                        onClick = {
                            expanded = false
                            onSelect(option)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun SettingSwitch(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!checked) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, modifier = Modifier.weight(1f))
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}
