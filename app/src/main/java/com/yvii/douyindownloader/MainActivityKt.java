package com.yvii.douyindownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.SelectionContainerKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.tooling.preview.AndroidUiModes;
import androidx.compose.ui.unit.Dp;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.exifinterface.media.ExifInterface;
import coil.compose.SingletonAsyncImageKt;
import com.yausername.ffmpeg.FFmpeg;
import com.yausername.youtubedl_android.YoutubeDL;
import com.yausername.youtubedl_android.YoutubeDLException;
import com.yausername.youtubedl_android.YoutubeDLRequest;
import com.yausername.youtubedl_android.mapper.VideoInfo;
import com.yausername.youtubedl_android.mapper.VideoThumbnail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Dispatchers;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a9\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\nH\u0003¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0003¢\u0006\u0002\u0010\u0011\u001a?\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\nH\u0003¢\u0006\u0002\u0010\u0019\u001a1\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\nH\u0003¢\u0006\u0002\u0010 \u001aY\u0010!\u001a\u00020\u0001\"\u0004\b\u0000\u0010\"2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u0002H\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u00020\u001c0\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u00020\u00010\nH\u0003¢\u0006\u0002\u0010)\u001a$\u0010*\u001a\u00020\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001c0&H\u0002\u001a\u001c\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150/2\u0006\u00100\u001a\u000201H\u0002\u001a$\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u0002012\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150/H\u0002\u001a0\u00104\u001a\u0002H\"\"\u0010\b\u0000\u0010\"\u0018\u0001*\b\u0012\u0004\u0012\u0002H\"052\u0006\u0010$\u001a\u00020\u001c2\u0006\u00106\u001a\u0002H\"H\u0082\b¢\u0006\u0002\u00107\u001a\u0012\u00108\u001a\u0004\u0018\u00010\u001c2\u0006\u00109\u001a\u00020\u001cH\u0002\u001a\u0010\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020<H\u0002\u001aB\u0010=\u001a\u00020<2\u0006\u00100\u001a\u0002012\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\nH\u0082@¢\u0006\u0002\u0010@\u001a:\u0010A\u001a\u00020<2\u0006\u00100\u001a\u0002012\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\nH\u0082@¢\u0006\u0002\u0010B\u001a2\u0010C\u001a\u00020<2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\nH\u0082@¢\u0006\u0002\u0010D\u001a2\u0010E\u001a\u00020<2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\nH\u0082@¢\u0006\u0002\u0010D\u001aP\u0010F\u001a\u00020G2\u0006\u00100\u001a\u0002012\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010;\u001a\u00020<2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0H2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\nH\u0082@¢\u0006\u0002\u0010I\u001a\u0010\u0010J\u001a\u00020\u00012\u0006\u00100\u001a\u000201H\u0002\u001a$\u0010K\u001a\u00020L2\u0006\u0010>\u001a\u00020\u001c2\b\b\u0002\u0010M\u001a\u00020\u001c2\b\b\u0002\u0010N\u001a\u00020\u001eH\u0002\u001a\"\u0010O\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020Q2\b\b\u0002\u0010R\u001a\u00020\u001cH\u0002\u001a\u001a\u0010S\u001a\u0004\u0018\u00010Q2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u001cH\u0002\u001a\u001a\u0010U\u001a\u0004\u0018\u00010\u001c2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010P\u001a\u00020\u001cH\u0002\u001a\u001a\u0010V\u001a\u0004\u0018\u00010\u001c2\u0006\u0010W\u001a\u00020Q2\u0006\u0010X\u001a\u00020YH\u0002\u001a\u0012\u0010Z\u001a\u0004\u0018\u00010\u001c2\u0006\u0010W\u001a\u00020QH\u0002\u001a\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0&2\u0006\u0010W\u001a\u00020QH\u0002\u001a\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020Q0&*\u0004\u0018\u00010^H\u0002\u001a\u0014\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001c0&*\u0004\u0018\u00010^H\u0002\u001a\u0018\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001c0&2\b\u0010a\u001a\u0004\u0018\u00010QH\u0002\u001a\u001a\u0010b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010c\u001a\u00020\u001c2\u0006\u0010d\u001a\u00020\u001eH\u0002\u001a\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00020\u001c0&2\u0006\u0010c\u001a\u00020\u001cH\u0002\u001a\u0012\u0010f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010c\u001a\u00020\u001cH\u0002\u001a\u0010\u0010g\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020\u001cH\u0002\u001a\u0010\u0010h\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u001cH\u0002\u001a\u0010\u0010i\u001a\u00020\u001c2\u0006\u0010j\u001a\u00020\u001cH\u0002\u001a\u0010\u0010k\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001cH\u0002\u001a\u0010\u0010l\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001cH\u0002\u001a\u0010\u0010m\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020\u001cH\u0002\u001aD\u0010n\u001a\u00020G2\u0006\u0010>\u001a\u00020\u001c2\u0006\u0010o\u001a\u00020G2\u0006\u0010p\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020\u001c2\u0006\u0010q\u001a\u00020r2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010\nH\u0002¨\u0006s²\u0006\n\u0010\u0013\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010t\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\n\u0010u\u001a\u00020\u001eX\u008a\u008e\u0002²\u0006\n\u0010v\u001a\u00020\u001eX\u008a\u008e\u0002²\u0006\u0016\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150/X\u008a\u008e\u0002²\u0006\f\u0010w\u001a\u0004\u0018\u00010<X\u008a\u008e\u0002²\u0006\n\u0010x\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\n\u0010y\u001a\u00020\u001cX\u008a\u008e\u0002²\u0006\n\u0010z\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010{\u001a\u00020\u001eX\u008a\u008e\u0002"}, d2 = {"DownloaderApp", "", "(Landroidx/compose/runtime/Composer;I)V", "ModeChip", "item", "Lcom/example/douyinvideodownloader/DownloadMode;", "selected", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function1;", "(Lcom/example/douyinvideodownloader/DownloadMode;Lcom/example/douyinvideodownloader/DownloadMode;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SurfaceCard", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "SettingsDialog", "mode", "settings", "Lcom/example/douyinvideodownloader/DownloadSettings;", "onDismiss", "Lkotlin/Function0;", "onSave", "(Lcom/example/douyinvideodownloader/DownloadMode;Lcom/example/douyinvideodownloader/DownloadSettings;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SettingSwitch", "title", "", "checked", "", "onCheckedChange", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CompactDropdown", ExifInterface.GPS_DIRECTION_TRUE, "label", "value", "options", "", "optionLabel", "onSelected", "(Ljava/lang/String;Ljava/lang/Object;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "setSelectedImages", "selectedImages", "", "urls", "loadSettings", "", "context", "Landroid/content/Context;", "saveSettings", "settingsByMode", "enumValue", "", "fallback", "(Ljava/lang/String;Ljava/lang/Enum;)Ljava/lang/Enum;", "extractUrl", "text", "mediaSummary", "media", "Lcom/example/douyinvideodownloader/AnalyzedMedia;", "analyzeByMode", "url", "onProgress", "(Landroid/content/Context;Lcom/example/douyinvideodownloader/DownloadMode;Ljava/lang/String;Lcom/example/douyinvideodownloader/DownloadSettings;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyzeVideo", "(Landroid/content/Context;Ljava/lang/String;Lcom/example/douyinvideodownloader/DownloadSettings;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyzeDouyin", "(Ljava/lang/String;Lcom/example/douyinvideodownloader/DownloadSettings;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyzeCobalt", "download", "Ljava/io/File;", "", "(Landroid/content/Context;Lcom/example/douyinvideodownloader/DownloadMode;Lcom/example/douyinvideodownloader/AnalyzedMedia;Lcom/example/douyinvideodownloader/DownloadSettings;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureDownloadPermission", "httpGet", "Lcom/example/douyinvideodownloader/HttpResult;", "cookie", "mobile", "httpPostJson", "body", "Lorg/json/JSONObject;", "authorization", "fetchDouyinPayload", "awemeId", "extractAwemeId", "extractDouyinVideo", "aweme", "quality", "Lcom/example/douyinvideodownloader/QualityChoice;", "extractDouyinAudio", "extractDouyinImages", "Lcom/example/douyinvideodownloader/MediaItem;", "toObjects", "Lorg/json/JSONArray;", "toStrings", "extractUrlList", "obj", "extractFirstMediaUrl", "html", "video", "extractImageUrlsFromHtml", "extractHtmlTitle", "decodeEscapedHtml", "cleanDouyinUrl", "normalizeUrl", "raw", "isDirectImage", "isDirectImageLike", "looksLikeImageUrl", "downloadDirectFile", "outputDir", "prefix", "imageFormat", "Lcom/example/douyinvideodownloader/ImageFormatChoice;", "app", "input", "busy", "settingsOpen", "analyzed", NotificationCompat.CATEGORY_STATUS, "log", "draft", "expanded"}, k = 2, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
public final class MainActivityKt {

    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[DownloadMode.values().length];
            try {
                iArr[DownloadMode.Douyin.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DownloadMode.Video.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DownloadMode.Extra.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[QualityChoice.values().length];
            try {
                iArr2[QualityChoice.Best.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[QualityChoice.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[QualityChoice.Small.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ImageFormatChoice.values().length];
            try {
                iArr3[ImageFormatChoice.Png.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[ImageFormatChoice.Jpg.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ImageFormatChoice.Webp.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ImageFormatChoice.Auto.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    static final Unit CompactDropdown$lambda$4(String str, Object obj, List list, Function1 function1, Function1 function2, int i, Composer composer, int i2) {
        CompactDropdown(str, obj, list, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit DownloaderApp$lambda$30(int i, Composer composer, int i2) {
        DownloaderApp(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit ModeChip$lambda$2(DownloadMode downloadMode, DownloadMode downloadMode2, Modifier modifier, Function1 function1, int i, Composer composer, int i2) {
        ModeChip(downloadMode, downloadMode2, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SettingSwitch$lambda$1(String str, boolean z, Function1 function1, int i, Composer composer, int i2) {
        SettingSwitch(str, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsDialog$lambda$6$0$14$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsDialog$lambda$6$0$16$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsDialog$lambda$6$0$18$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsDialog$lambda$6$0$20$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    static final Unit SettingsDialog$lambda$7(DownloadMode downloadMode, DownloadSettings downloadSettings, Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        SettingsDialog(downloadMode, downloadSettings, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit SurfaceCard$lambda$1(Function3 function3, int i, Composer composer, int i2) {
        SurfaceCard(function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DownloaderApp(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-547428817);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DownloaderApp)158@6131L7,159@6179L7,160@6201L24,161@6240L48,162@6304L31,163@6350L34,164@6407L34,165@6466L56,168@6541L49,169@6607L36,170@6657L78,171@6759L41,172@6818L37,189@7255L320,196@7580L7574,188@7232L7922:MainActivity.kt#tgtg9h");
        if (composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-547428817, i, -1, "com.yvii.douyindownloader.DownloaderApp (MainActivity.kt:157)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            ProvidableCompositionLocal<ClipboardManager> localClipboardManager = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localClipboardManager);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ClipboardManager clipboardManager = (ClipboardManager) objConsume2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093077857, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DownloadMode.Douyin, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093075826, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093074351, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093072527, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093070617, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(loadSettings(context), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableState mutableState5 = (MutableState) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093068224, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState6 = (MutableState) objRememberedValue7;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093066125, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Ready", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            final MutableState mutableState7 = (MutableState) objRememberedValue8;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093064483, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Downloads save to Android app Downloads folder.", null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            final MutableState mutableState8 = (MutableState) objRememberedValue9;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093061256, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue10 = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            final SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue10;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            String strDownloaderApp$lambda$4 = DownloaderApp$lambda$4(mutableState2);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093059372, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strDownloaderApp$lambda$4);
            Object objRememberedValue11 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue11 = extractUrl(DownloaderApp$lambda$4(mutableState2));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue11);
            }
            final String str = (String) objRememberedValue11;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            DownloadSettings downloadSettings = DownloaderApp$lambda$13(mutableState5).get(DownloaderApp$lambda$1(mutableState));
            if (downloadSettings == null) {
                downloadSettings = new DownloadSettings(null, null, null, null, false, false, null, null, null, null, null, null, null, 8191, null);
            }
            if (DownloaderApp$lambda$10(mutableState4)) {
                composerStartRestartGroup.startReplaceGroup(-460205168);
                ComposerKt.sourceInformation(composerStartRestartGroup, "179@7023L24,180@7064L154,176@6943L281");
                DownloadMode downloadModeDownloaderApp$lambda$1 = DownloaderApp$lambda$1(mutableState);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093052825, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue12 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue12 = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivityKt.DownloaderApp$lambda$26$0(mutableState4);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue12);
                }
                Function0 function0 = (Function0) objRememberedValue12;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2093051383, "CC(remember):MainActivity.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(context);
                Object objRememberedValue13 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.DownloaderApp$lambda$27$0(context, mutableState5, mutableState, mutableState4, (DownloadSettings) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue13);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SettingsDialog(downloadModeDownloaderApp$lambda$1, downloadSettings, function0, (Function1) objRememberedValue13, composerStartRestartGroup, 384);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-459925517);
                composerStartRestartGroup.endReplaceGroup();
            }
            final DownloadSettings downloadSettings2 = downloadSettings;
            ScaffoldKt.m2406ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(496243179, true, new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.DownloaderApp$lambda$28(mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(509504128, true, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.DownloaderApp$lambda$29(mutableState, snapshotStateList, mutableState6, str, mutableState2, clipboardManager, coroutineScope, context, downloadSettings2, mutableState7, mutableState3, mutableState8, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.DownloaderApp$lambda$30(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadMode DownloaderApp$lambda$1(MutableState<DownloadMode> mutableState) {
        return mutableState.getValue();
    }

    private static final String DownloaderApp$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean DownloaderApp$lambda$7(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DownloaderApp$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean DownloaderApp$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DownloaderApp$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Map<DownloadMode, DownloadSettings> DownloaderApp$lambda$13(MutableState<Map<DownloadMode, DownloadSettings>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnalyzedMedia DownloaderApp$lambda$16(MutableState<AnalyzedMedia> mutableState) {
        return mutableState.getValue();
    }

    private static final String DownloaderApp$lambda$19(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final String DownloaderApp$lambda$22(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$26$0(MutableState mutableState) {
        DownloaderApp$lambda$11(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$27$0(Context context, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, DownloadSettings it) throws JSONException {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(MapsKt.plus(DownloaderApp$lambda$13(mutableState), TuplesKt.to(DownloaderApp$lambda$1(mutableState2), it)));
        saveSettings(context, MapsKt.plus(DownloaderApp$lambda$13(mutableState), TuplesKt.to(DownloaderApp$lambda$1(mutableState2), it)));
        DownloaderApp$lambda$11(mutableState3, false);
        return Unit.INSTANCE;
    }

    static final Unit DownloaderApp$lambda$28(final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C192@7387L70,193@7541L11,193@7494L67,190@7263L306:MainActivity.kt#tgtg9h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(496243179, i, -1, "com.yvii.douyindownloader.DownloaderApp.<anonymous> (MainActivity.kt:190)");
            }
            AppBarKt.m1730TopAppBarGHTll3U(ComposableSingletons$MainActivityKt.INSTANCE.m8017getLambda$200789073$app(), null, null, ComposableLambdaKt.rememberComposableLambda(-250636582, true, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.DownloaderApp$lambda$28$0(mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m2928topAppBarColors5tl4gsc(MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, 0L, 0L, composer, TopAppBarDefaults.$stable << 18, 62), null, composer, 3078, 182);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$28$0(final MutableState mutableState, RowScope TopAppBar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C192@7410L23,192@7389L66:MainActivity.kt#tgtg9h");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-250636582, i, -1, "com.yvii.douyindownloader.DownloaderApp.<anonymous>.<anonymous> (MainActivity.kt:192)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -343585967, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.DownloaderApp$lambda$28$0$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m8016getLambda$1867525251$app(), composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$28$0$0$0(MutableState mutableState) {
        DownloaderApp$lambda$11(mutableState, true);
        return Unit.INSTANCE;
    }

    static final Unit DownloaderApp$lambda$29(final MutableState mutableState, final SnapshotStateList snapshotStateList, final MutableState mutableState2, final String str, final MutableState mutableState3, final ClipboardManager clipboardManager, final CoroutineScope coroutineScope, final Context context, final DownloadSettings downloadSettings, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, PaddingValues padding, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)202@7728L11,203@7778L21,197@7597L7553:MainActivity.kt#tgtg9h");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(padding) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(509504128, i2, -1, "com.yvii.douyindownloader.DownloaderApp.<anonymous> (MainActivity.kt:197)");
            }
            Modifier modifierM819padding3ABfNKs = PaddingKt.m819padding3ABfNKs(ScrollKt.verticalScroll$default(BackgroundKt.m265backgroundbw27NRU$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), padding), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getBackground(), null, 2, null), ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null), Dp.m7521constructorimpl(16));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM689spacedBy0680j_4 = Arrangement.INSTANCE.m689spacedBy0680j_4(Dp.m7521constructorimpl(14));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM689spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM819padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4008constructorimpl = Updater.m4008constructorimpl(composer);
            Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -38399809, "C209@7956L10,211@8051L11,207@7898L185,215@8195L10,216@8248L11,213@8090L194,219@8292L408,227@8707L272,232@8999L3680,232@8987L3692,362@14606L538,362@14594L550:MainActivity.kt#tgtg9h");
            TextKt.m2713TextNvy7gAk("Paste link", null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnBackground(), null, 0L, null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getHeadlineMedium(), composer, 1572870, 0, 131002);
            TextKt.m2713TextNvy7gAk("Share text accepted. First URL is detected automatically.", null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 6, 0, 131066);
            float f = 8;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM689spacedBy0680j_5 = Arrangement.INSTANCE.m689spacedBy0680j_4(Dp.m7521constructorimpl(f));
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM689spacedBy0680j_5, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM4008constructorimpl2 = Updater.m4008constructorimpl(composer);
            Updater.m4016setimpl(composerM4008constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2058682817, "C220@8451L106,220@8394L163,225@8622L70,225@8566L126:MainActivity.kt#tgtg9h");
            DownloadMode downloadMode = DownloadMode.Douyin;
            DownloadMode downloadModeDownloaderApp$lambda$1 = DownloaderApp$lambda$1(mutableState);
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -897691484, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda40
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivityKt.DownloaderApp$lambda$29$0$0$0$0(snapshotStateList, mutableState, mutableState2, (DownloadMode) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ModeChip(downloadMode, downloadModeDownloaderApp$lambda$1, modifierWeight$default, (Function1) objRememberedValue, composer, 3078);
            DownloadMode downloadMode2 = DownloadMode.Video;
            DownloadMode downloadModeDownloaderApp$lambda$2 = DownloaderApp$lambda$1(mutableState);
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -897686048, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda41
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivityKt.DownloaderApp$lambda$29$0$0$1$0(snapshotStateList, mutableState, mutableState2, (DownloadMode) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ModeChip(downloadMode2, downloadModeDownloaderApp$lambda$2, modifierWeight$default2, (Function1) objRememberedValue2, composer, 3078);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM689spacedBy0680j_6 = Arrangement.INSTANCE.m689spacedBy0680j_4(Dp.m7521constructorimpl(f));
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM689spacedBy0680j_6, Alignment.INSTANCE.getTop(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM4008constructorimpl3 = Updater.m4008constructorimpl(composer);
            Updater.m4016setimpl(composerM4008constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1181511216, "C228@8865L70,228@8809L126,229@8944L27:MainActivity.kt#tgtg9h");
            DownloadMode downloadMode3 = DownloadMode.Extra;
            DownloadMode downloadModeDownloaderApp$lambda$3 = DownloaderApp$lambda$1(mutableState);
            Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, -2040095017, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda42
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivityKt.DownloaderApp$lambda$29$0$1$0$0(snapshotStateList, mutableState, mutableState2, (DownloadMode) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ModeChip(downloadMode3, downloadModeDownloaderApp$lambda$3, modifierWeight$default3, (Function1) objRememberedValue3, composer, 3078);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SurfaceCard(ComposableLambdaKt.rememberComposableLambda(-1772831976, true, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.DownloaderApp$lambda$29$0$2(str, mutableState3, snapshotStateList, mutableState2, clipboardManager, coroutineScope, context, downloadSettings, mutableState4, mutableState5, mutableState6, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 6);
            final AnalyzedMedia analyzedMediaDownloaderApp$lambda$16 = DownloaderApp$lambda$16(mutableState2);
            if (analyzedMediaDownloaderApp$lambda$16 == null) {
                composer.startReplaceGroup(-33805270);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-33805269);
                ComposerKt.sourceInformation(composer, "*327@12732L1846,327@12720L1858");
                SurfaceCard(ComposableLambdaKt.rememberComposableLambda(-470455969, true, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda45
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return MainActivityKt.DownloaderApp$lambda$29$0$3$0(analyzedMediaDownloaderApp$lambda$16, snapshotStateList, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 6);
                Unit unit = Unit.INSTANCE;
                composer.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            SurfaceCard(ComposableLambdaKt.rememberComposableLambda(714998735, true, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.DownloaderApp$lambda$29$0$4(mutableState4, mutableState6, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$0$0$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, DownloadMode newMode) {
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        mutableState.setValue(newMode);
        mutableState2.setValue(null);
        snapshotStateList.clear();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$0$1$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, DownloadMode newMode) {
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        mutableState.setValue(newMode);
        mutableState2.setValue(null);
        snapshotStateList.clear();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$1$0$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, DownloadMode newMode) {
        Intrinsics.checkNotNullParameter(newMode, "newMode");
        mutableState.setValue(newMode);
        mutableState2.setValue(null);
        snapshotStateList.clear();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$2(final String str, final MutableState mutableState, final SnapshotStateList snapshotStateList, final MutableState mutableState2, final ClipboardManager clipboardManager, final CoroutineScope coroutineScope, final Context context, final DownloadSettings downloadSettings, final MutableState mutableState3, final MutableState mutableState4, final MutableState mutableState5, final MutableState mutableState6, ColumnScope SurfaceCard, Composer composer, int i) {
        float f;
        boolean z;
        Intrinsics.checkNotNullParameter(SurfaceCard, "$this$SurfaceCard");
        ComposerKt.sourceInformation(composer, "C235@9079L99,233@9009L375,245@9393L30,246@9432L3056,322@12497L30,323@12598L10,323@12642L11,323@12536L135:MainActivity.kt#tgtg9h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1772831976, i, -1, "com.yvii.douyindownloader.DownloaderApp.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:233)");
            }
            String strDownloaderApp$lambda$4 = DownloaderApp$lambda$4(mutableState);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1410490235, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda35
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivityKt.DownloaderApp$lambda$29$0$2$0$0(snapshotStateList, mutableState, mutableState2, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            OutlinedTextFieldKt.OutlinedTextField(strDownloaderApp$lambda$4, (Function1<? super String, Unit>) objRememberedValue, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1003212606$app(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1549605247$app(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 4, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 14156208, 805306368, 0, 7864120);
            SpacerKt.Spacer(SizeKt.m851height3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(12)), composer, 6);
            float f2 = 10;
            Arrangement.HorizontalOrVertical horizontalOrVerticalM689spacedBy0680j_4 = Arrangement.INSTANCE.m689spacedBy0680j_4(Dp.m7521constructorimpl(f2));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM689spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4008constructorimpl = Updater.m4008constructorimpl(composer);
            Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 852432766, "C248@9587L273,247@9549L341,259@9989L753,257@9902L872,283@10865L1384,314@12262L216,281@10786L1692:MainActivity.kt#tgtg9h");
            ComposerKt.sourceInformationMarkerStart(composer, 2105706373, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(clipboardManager);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                f = f2;
                Function0 function0 = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda36
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.DownloaderApp$lambda$29$0$2$1$0$0(clipboardManager, snapshotStateList, mutableState, mutableState2, mutableState3);
                    }
                };
                composer.updateRememberedValue(function0);
                objRememberedValue2 = function0;
            } else {
                f = f2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.OutlinedButton((Function0) objRememberedValue2, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.m8020getLambda$969385342$app(), composer, 805306368, 510);
            boolean z2 = (DownloaderApp$lambda$7(mutableState4) || str == null) ? false : true;
            ComposerKt.sourceInformationMarkerStart(composer, 2105719717, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChanged = composer.changed(str) | composer.changedInstance(coroutineScope) | composer.changedInstance(context) | composer.changed(downloadSettings);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                z = false;
                Function0 function1 = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.DownloaderApp$lambda$29$0$2$1$1$0(str, coroutineScope, mutableState4, mutableState3, mutableState5, context, downloadSettings, mutableState6, snapshotStateList, mutableState2);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue3 = function1;
            } else {
                z = false;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.OutlinedButton((Function0) objRememberedValue3, null, z2, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1766952427$app(), composer, 805306368, 506);
            if (!DownloaderApp$lambda$7(mutableState4) && str != null) {
                z = true;
            }
            ComposerKt.sourceInformationMarkerStart(composer, 2105748380, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChanged2 = composer.changed(str) | composer.changedInstance(coroutineScope) | composer.changedInstance(context) | composer.changed(downloadSettings);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Function0 function2 = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda38
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.DownloaderApp$lambda$29$0$2$1$2$0(str, coroutineScope, mutableState4, mutableState3, mutableState5, context, downloadSettings, snapshotStateList, mutableState2, mutableState6);
                    }
                };
                composer.updateRememberedValue(function2);
                objRememberedValue4 = function2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.Button((Function0) objRememberedValue4, null, z, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-763912380, true, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.DownloaderApp$lambda$29$0$2$1$3(mutableState4, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 506);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.m851height3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(f)), composer, 6);
            TextKt.m2713TextNvy7gAk("Detected: " + (str == null ? "none" : str), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$2$0$0(SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        mutableState2.setValue(null);
        snapshotStateList.clear();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$2$1$0$0(ClipboardManager clipboardManager, SnapshotStateList snapshotStateList, MutableState mutableState, MutableState mutableState2, MutableState mutableState3) {
        AnnotatedString text = clipboardManager.getText();
        String text2 = text != null ? text.getText() : null;
        if (text2 == null) {
            text2 = "";
        }
        mutableState.setValue(text2);
        mutableState2.setValue(null);
        snapshotStateList.clear();
        mutableState3.setValue(extractUrl(text2) == null ? "No link found in clipboard" : "Link detected");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$2$1$1$0(String str, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Context context, DownloadSettings downloadSettings, MutableState mutableState4, SnapshotStateList snapshotStateList, MutableState mutableState5) {
        if (str == null) {
            return Unit.INSTANCE;
        }
        DownloaderApp$lambda$8(mutableState, true);
        mutableState2.setValue("Analyzing...");
        mutableState3.setValue("");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MainActivityKt$DownloaderApp$4$1$3$2$2$1$1(context, str, downloadSettings, mutableState4, mutableState2, snapshotStateList, mutableState5, mutableState3, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$2$1$2$0(String str, CoroutineScope coroutineScope, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, Context context, DownloadSettings downloadSettings, SnapshotStateList snapshotStateList, MutableState mutableState4, MutableState mutableState5) {
        if (str == null) {
            return Unit.INSTANCE;
        }
        DownloaderApp$lambda$8(mutableState, true);
        mutableState2.setValue("Starting...");
        mutableState3.setValue("");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new MainActivityKt$DownloaderApp$4$1$3$2$3$1$1(context, str, downloadSettings, snapshotStateList, mutableState4, mutableState5, mutableState2, mutableState3, mutableState, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$2$1$3(MutableState mutableState, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C319@12450L16:MainActivity.kt#tgtg9h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-763912380, i, -1, "com.yvii.douyindownloader.DownloaderApp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:315)");
            }
            if (DownloaderApp$lambda$7(mutableState)) {
                composer.startReplaceGroup(1318017415);
                ComposerKt.sourceInformation(composer, "316@12302L78,317@12395L28");
                ProgressIndicatorKt.m2368CircularProgressIndicator4lLiAd8(SizeKt.m865size3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(18)), 0L, Dp.m7521constructorimpl(2), 0L, 0, 0.0f, composer, 390, 58);
                SpacerKt.Spacer(SizeKt.m870width3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(8)), composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1318162526);
                composer.endReplaceGroup();
            }
            TextKt.m2713TextNvy7gAk("Download", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$3$0(AnalyzedMedia analyzedMedia, SnapshotStateList snapshotStateList, ColumnScope SurfaceCard, Composer composer, int i) {
        final SnapshotStateList snapshotStateList2;
        Intrinsics.checkNotNullParameter(SurfaceCard, "$this$SurfaceCard");
        ComposerKt.sourceInformation(composer, "C328@12804L10,328@12744L117,329@12872L29,330@12960L10,330@13005L11,330@12912L122:MainActivity.kt#tgtg9h");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-470455969, i, -1, "com.yvii.douyindownloader.DownloaderApp.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:328)");
            }
            String title = analyzedMedia.getTitle();
            if (StringsKt.isBlank(title)) {
                title = "Media";
            }
            TextKt.m2713TextNvy7gAk(title, null, 0L, null, 0L, null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 1572864, 0, 131006);
            float f = 8;
            SpacerKt.Spacer(SizeKt.m851height3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(f)), composer, 6);
            TextKt.m2713TextNvy7gAk(mediaSummary(analyzedMedia), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 131066);
            if (analyzedMedia.getImages().isEmpty()) {
                composer.startReplaceGroup(-873664317);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-875098129);
                ComposerKt.sourceInformation(composer, "332@13090L30,333@13177L10,333@13133L66,*336@13324L145,335@13258L1284");
                SpacerKt.Spacer(SizeKt.m851height3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(12)), composer, 6);
                TextKt.m2713TextNvy7gAk("Choose images", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), composer, 6, 0, 131070);
                Composer composer2 = composer;
                for (final MediaItem mediaItem : analyzedMedia.getImages()) {
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 457434965, "CC(remember):MainActivity.kt#9igjgp");
                    boolean zChanged = composer2.changed(mediaItem);
                    Object objRememberedValue = composer2.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        snapshotStateList2 = snapshotStateList;
                        objRememberedValue = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MainActivityKt.DownloaderApp$lambda$29$0$3$0$1$0$0(snapshotStateList2, mediaItem);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        snapshotStateList2 = snapshotStateList;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierM821paddingVpY3zN4$default = PaddingKt.m821paddingVpY3zN4$default(ClickableKt.m300clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (Function0) objRememberedValue, 15, null), 0.0f, Dp.m7521constructorimpl(4), 1, null);
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM821paddingVpY3zN4$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM4008constructorimpl = Updater.m4008constructorimpl(composer2);
                    Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1719409602, "C341@13666L174,341@13593L248,349@14086L11,345@13858L299,351@14174L29,352@14220L306:MainActivity.kt#tgtg9h");
                    boolean zContains = snapshotStateList2.contains(mediaItem.getUrl());
                    ComposerKt.sourceInformationMarkerStart(composer2, -1163841906, "CC(remember):MainActivity.kt#9igjgp");
                    boolean zChanged2 = composer2.changed(mediaItem);
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda28
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MainActivityKt.DownloaderApp$lambda$29$0$3$0$1$1$0$0(snapshotStateList2, mediaItem, ((Boolean) obj).booleanValue());
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Composer composer3 = composer2;
                    CheckboxKt.Checkbox(zContains, (Function1) objRememberedValue2, null, false, null, null, composer3, 0, 60);
                    SingletonAsyncImageKt.m7996AsyncImagegl8XCv8(mediaItem.getUrl(), mediaItem.getLabel(), BackgroundKt.m264backgroundbw27NRU(SizeKt.m865size3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(72)), MaterialTheme.INSTANCE.getColorScheme(composer3, MaterialTheme.$stable).getSurfaceVariant(), RoundedCornerShapeKt.m1127RoundedCornerShape0680j_4(Dp.m7521constructorimpl(f))), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, composer, 1572864, 0, 4024);
                    SpacerKt.Spacer(SizeKt.m870width3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(10)), composer, 6);
                    Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                    ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor2);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM4008constructorimpl2 = Updater.m4008constructorimpl(composer);
                    Updater.m4016setimpl(composerM4008constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m4016setimpl(composerM4008constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m4012initimpl(composerM4008constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m4014reconcileimpl(composerM4008constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m4016setimpl(composerM4008constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, 397951241, "C353@14308L10,353@14268L62,354@14435L10,354@14479L11,354@14349L159:MainActivity.kt#tgtg9h");
                    TextKt.m2713TextNvy7gAk(mediaItem.getLabel(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 131070);
                    TextKt.m2713TextNvy7gAk(mediaItem.getUrl(), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m7457getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 24960, 110586);
                    composer2 = composer;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                }
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$3$0$1$0$0(SnapshotStateList snapshotStateList, MediaItem mediaItem) {
        boolean zContains = snapshotStateList.contains(mediaItem.getUrl());
        String url = mediaItem.getUrl();
        if (zContains) {
            snapshotStateList.remove(url);
        } else {
            snapshotStateList.add(url);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$3$0$1$1$0$0(SnapshotStateList snapshotStateList, MediaItem mediaItem, boolean z) {
        if (z && !snapshotStateList.contains(mediaItem.getUrl())) {
            snapshotStateList.add(mediaItem.getUrl());
        }
        if (!z) {
            snapshotStateList.remove(mediaItem.getUrl());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$4(MutableState mutableState, final MutableState mutableState2, ColumnScope SurfaceCard, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(SurfaceCard, "$this$SurfaceCard");
        ComposerKt.sourceInformation(composer, "C363@14616L327,367@14952L29,368@15009L127,368@14990L146:MainActivity.kt#tgtg9h");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(714998735, i, -1, "com.yvii.douyindownloader.DownloaderApp.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:363)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM689spacedBy0680j_4 = Arrangement.INSTANCE.m689spacedBy0680j_4(Dp.m7521constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM689spacedBy0680j_4, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4008constructorimpl = Updater.m4008constructorimpl(composer);
            Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1635374096, "C364@14783L11,364@14733L97,365@14876L10,365@14841L92:MainActivity.kt#tgtg9h");
            float f = 8;
            BoxKt.Box(BackgroundKt.m264backgroundbw27NRU(SizeKt.m865size3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(10)), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getPrimary(), RoundedCornerShapeKt.m1127RoundedCornerShape0680j_4(Dp.m7521constructorimpl(f))), composer, 0);
            TextKt.m2713TextNvy7gAk(DownloaderApp$lambda$19(mutableState), null, 0L, null, 0L, null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 1572864, 0, 131006);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            SpacerKt.Spacer(SizeKt.m851height3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(f)), composer, 6);
            SelectionContainerKt.SelectionContainer(null, ComposableLambdaKt.rememberComposableLambda(221773644, true, new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda52
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.DownloaderApp$lambda$29$0$4$1(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderApp$lambda$29$0$4$1(MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C369@15053L10,369@15097L11,369@15021L105:MainActivity.kt#tgtg9h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(221773644, i, -1, "com.yvii.douyindownloader.DownloaderApp.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:369)");
            }
            TextKt.m2713TextNvy7gAk(DownloaderApp$lambda$22(mutableState), null, MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getOnSurfaceVariant(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ModeChip(final DownloadMode downloadMode, final DownloadMode downloadMode2, final Modifier modifier, final Function1<? super DownloadMode, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-938373260);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModeChip)N(item,selected,modifier,onClick)380@15351L17,381@15382L211,378@15292L352:MainActivity.kt#tgtg9h");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(downloadMode.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(downloadMode2.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-938373260, i2, -1, "com.yvii.douyindownloader.ModeChip (MainActivity.kt:377)");
            }
            boolean z = downloadMode == downloadMode2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 166434853, "CC(remember):MainActivity.kt#9igjgp");
            boolean z2 = ((i2 & 7168) == 2048) | ((i2 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda54
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.ModeChip$lambda$0$0(function1, downloadMode);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            ChipKt.FilterChip(z, (Function0) objRememberedValue, ComposableLambdaKt.rememberComposableLambda(-1880978905, true, new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda56
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.ModeChip$lambda$1(downloadMode, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), SizeKt.m853heightInVpY3zN4$default(modifier, Dp.m7521constructorimpl(64), 0.0f, 2, null), false, null, null, null, null, null, null, null, composer2, 384, 0, 4080);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda57
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.ModeChip$lambda$2(downloadMode, downloadMode2, modifier, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModeChip$lambda$0$0(Function1 function1, DownloadMode downloadMode) {
        function1.invoke(downloadMode);
        return Unit.INSTANCE;
    }

    static final Unit ModeChip$lambda$1(DownloadMode downloadMode, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C382@15390L197:MainActivity.kt#tgtg9h");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1880978905, i, -1, "com.yvii.douyindownloader.ModeChip.<anonymous> (MainActivity.kt:382)");
            }
            Modifier modifierM821paddingVpY3zN4$default = PaddingKt.m821paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m7521constructorimpl(4), 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM821paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4008constructorimpl = Updater.m4008constructorimpl(composer);
            Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -455904355, "C383@15442L50,384@15543L10,384@15501L78:MainActivity.kt#tgtg9h");
            TextKt.m2713TextNvy7gAk(downloadMode.getTitle(), null, 0L, null, 0L, null, FontWeight.INSTANCE.getSemiBold(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 1572864, 0, 262078);
            TextKt.m2713TextNvy7gAk(downloadMode.getSubtitle(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 2, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getLabelSmall(), composer, 0, CpioConstants.C_ISBLK, 114686);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void SurfaceCard(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1801382664);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SurfaceCard)N(content)394@15807L11,394@15765L71,395@15864L6,397@15926L60,393@15733L253:MainActivity.kt#tgtg9h");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1801382664, i2, -1, "com.yvii.douyindownloader.SurfaceCard (MainActivity.kt:392)");
            }
            composer2 = composerStartRestartGroup;
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes(composer2, MaterialTheme.$stable).getExtraLarge(), CardDefaults.INSTANCE.m1784cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, MaterialTheme.$stable).getSurfaceContainer(), 0L, 0L, 0L, composer2, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-731823638, true, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda58
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.SurfaceCard$lambda$0(function3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda59
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.SurfaceCard$lambda$1(function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    static final Unit SurfaceCard$lambda$0(Function3 function3, ColumnScope Card, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Card, "$this$Card");
        ComposerKt.sourceInformation(composer, "C398@15932L50:MainActivity.kt#tgtg9h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-731823638, i, -1, "com.yvii.douyindownloader.SurfaceCard.<anonymous> (MainActivity.kt:398)");
            }
            Modifier modifierM819padding3ABfNKs = PaddingKt.m819padding3ABfNKs(Modifier.INSTANCE, Dp.m7521constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM819padding3ABfNKs);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4008constructorimpl = Updater.m4008constructorimpl(composer);
            Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void SettingsDialog(final DownloadMode downloadMode, final DownloadSettings downloadSettings, final Function0<Unit> function0, final Function1<? super DownloadSettings, Unit> function1, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(380721467);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingsDialog)N(mode,settings,onDismiss,onSave)404@16153L37,468@19802L56,469@19880L54,407@16252L34,408@16299L3481,405@16193L3745:MainActivity.kt#tgtg9h");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(downloadMode.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(downloadSettings) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(380721467, i2, -1, "com.yvii.douyindownloader.SettingsDialog (MainActivity.kt:403)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 801114240, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(downloadSettings, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            AndroidAlertDialog_androidKt.m1706AlertDialogOix01E0(function0, ComposableLambdaKt.rememberComposableLambda(1504616835, true, new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.SettingsDialog$lambda$3(function1, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1343769595, true, new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda48
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.SettingsDialog$lambda$4(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(102811271, true, new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda49
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.SettingsDialog$lambda$5(downloadMode, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(826101704, true, new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda50
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.SettingsDialog$lambda$6(downloadMode, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i2 >> 6) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda51
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.SettingsDialog$lambda$7(downloadMode, downloadSettings, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final DownloadSettings SettingsDialog$lambda$1(MutableState<DownloadSettings> mutableState) {
        return mutableState.getValue();
    }

    static final Unit SettingsDialog$lambda$5(DownloadMode downloadMode, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C407@16254L30:MainActivity.kt#tgtg9h");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(102811271, i, -1, "com.yvii.douyindownloader.SettingsDialog.<anonymous> (MainActivity.kt:407)");
            }
            TextKt.m2713TextNvy7gAk(downloadMode.getTitle() + " settings", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit SettingsDialog$lambda$6(final DownloadMode downloadMode, final MutableState mutableState, Composer composer, int i) {
        final MutableState mutableState2;
        ArrayList entries;
        ComposerKt.sourceInformation(composer, "C410@16358L21,409@16307L3467:MainActivity.kt#tgtg9h");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(826101704, i, -1, "com.yvii.douyindownloader.SettingsDialog.<anonymous> (MainActivity.kt:409)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(Modifier.INSTANCE, ScrollKt.rememberScrollState(0, composer, 0, 1), false, null, false, 14, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM689spacedBy0680j_4 = Arrangement.INSTANCE.m689spacedBy0680j_4(Dp.m7521constructorimpl(8));
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM689spacedBy0680j_4, Alignment.INSTANCE.getStart(), composer, 6);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM4008constructorimpl = Updater.m4008constructorimpl(composer);
            Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 22798200, "C420@17021L12,420@17035L37,420@16952L120:MainActivity.kt#tgtg9h");
            if (downloadMode != DownloadMode.Extra) {
                composer.startReplaceGroup(22735920);
                ComposerKt.sourceInformation(composer, "415@16701L12,415@16715L40,415@16643L112");
                if (downloadMode == DownloadMode.Douyin) {
                    entries = MediaChoice.getEntries();
                } else {
                    EnumEntries<MediaChoice> entries2 = MediaChoice.getEntries();
                    ArrayList arrayList = new ArrayList();
                    for (MediaChoice mediaChoice : entries2) {
                        if (mediaChoice != MediaChoice.Audio) {
                            arrayList.add(mediaChoice);
                        }
                    }
                    entries = arrayList;
                }
                List list = entries;
                MediaChoice mediaChoice2 = SettingsDialog$lambda$1(mutableState).getMediaChoice();
                ComposerKt.sourceInformationMarkerStart(composer, 1386213258, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$1$0((MediaChoice) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1386213734, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$2$0(mutableState, (MediaChoice) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CompactDropdown("Media", mediaChoice2, list, function1, (Function1) objRememberedValue2, composer, 27654);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(23001156);
                composer.endReplaceGroup();
            }
            if (downloadMode != DownloadMode.Extra) {
                composer.startReplaceGroup(23046075);
                ComposerKt.sourceInformation(composer, "418@16883L12,418@16897L36,418@16818L115");
                QualityChoice quality = SettingsDialog$lambda$1(mutableState).getQuality();
                EnumEntries<QualityChoice> entries3 = QualityChoice.getEntries();
                ComposerKt.sourceInformationMarkerStart(composer, 1386219082, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$3$0((QualityChoice) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Function1 function2 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1386219554, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue4 = composer.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$4$0(mutableState, (QualityChoice) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CompactDropdown("Quality", quality, entries3, function2, (Function1) objRememberedValue4, composer, 27654);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(23177732);
                composer.endReplaceGroup();
            }
            FileTypeChoice fileType = SettingsDialog$lambda$1(mutableState).getFileType();
            EnumEntries<FileTypeChoice> entries4 = FileTypeChoice.getEntries();
            ComposerKt.sourceInformationMarkerStart(composer, 1386223498, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivityKt.SettingsDialog$lambda$6$0$5$0((FileTypeChoice) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            Function1 function3 = (Function1) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 1386223971, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue6 = composer.rememberedValue();
            if (objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainActivityKt.SettingsDialog$lambda$6$0$6$0(mutableState, (FileTypeChoice) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CompactDropdown("File type", fileType, entries4, function3, (Function1) objRememberedValue6, composer, 27654);
            if (downloadMode == DownloadMode.Douyin) {
                composer.startReplaceGroup(23352138);
                ComposerKt.sourceInformation(composer, "422@17204L12,422@17218L40,422@17126L132");
                ImageFormatChoice imageFormat = SettingsDialog$lambda$1(mutableState).getImageFormat();
                EnumEntries<ImageFormatChoice> entries5 = ImageFormatChoice.getEntries();
                ComposerKt.sourceInformationMarkerStart(composer, 1386229354, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue7 = composer.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$7$0((ImageFormatChoice) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue7);
                }
                Function1 function4 = (Function1) objRememberedValue7;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1386229830, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue8 = composer.rememberedValue();
                if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue8 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$8$0(mutableState, (ImageFormatChoice) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CompactDropdown("Image format", imageFormat, entries5, function4, (Function1) objRememberedValue8, composer, 27654);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(23500132);
                composer.endReplaceGroup();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[downloadMode.ordinal()];
            if (i2 == 1) {
                composer.startReplaceGroup(23580019);
                ComposerKt.sourceInformation(composer, "428@17424L36,430@17534L71,426@17338L337");
                String cookies = SettingsDialog$lambda$1(mutableState).getCookies();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composer, 1386236418, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue9 = composer.rememberedValue();
                if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue9 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$9$0(mutableState, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                OutlinedTextFieldKt.OutlinedTextField(cookies, (Function1<? super String, Unit>) objRememberedValue9, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-245644592, true, new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainActivityKt.SettingsDialog$lambda$6$0$10(downloadMode, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 2, 1, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 905969664, 0, 7602104);
                composer.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            } else if (i2 == 2) {
                composer.startReplaceGroup(23956855);
                ComposerKt.sourceInformation(composer, "436@17807L40,436@17734L113,437@17932L45,437@17860L117");
                boolean updateYtDlp = SettingsDialog$lambda$1(mutableState).getUpdateYtDlp();
                ComposerKt.sourceInformationMarkerStart(composer, 1386248678, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue10 = composer.rememberedValue();
                if (objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue10 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda22
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$11$0(mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SettingSwitch("Update yt-dlp before video downloads", updateYtDlp, (Function1) objRememberedValue10, composer, 390);
                boolean includeThumbnail = SettingsDialog$lambda$1(mutableState).getIncludeThumbnail();
                ComposerKt.sourceInformationMarkerStart(composer, 1386252683, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue11 = composer.rememberedValue();
                if (objRememberedValue11 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue11 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$12$0(mutableState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue11);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                SettingSwitch("Write thumbnails in video mode", includeThumbnail, (Function1) objRememberedValue11, composer, 390);
                composer.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            } else {
                if (i2 != 3) {
                    composer.startReplaceGroup(1386234167);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(24301854);
                ComposerKt.sourceInformation(composer, "441@18081L11,442@18145L6,440@18036L582,452@18666L38,452@18631L140,453@18875L6,453@18883L47,453@18784L146,454@19061L6,454@19069L47,454@18943L173,455@19230L6,455@19238L46,455@19129L155,456@19396L6,456@19404L47,456@19297L154,459@19538L48,457@19464L280");
                SurfaceKt.m2570SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getShapes(composer, MaterialTheme.$stable).getMedium(), MaterialTheme.INSTANCE.getColorScheme(composer, MaterialTheme.$stable).getErrorContainer(), 0L, 0.0f, 0.0f, null, ComposableSingletons$MainActivityKt.INSTANCE.m8018getLambda$2029254055$app(), composer, 12582918, 120);
                String cobaltApi = SettingsDialog$lambda$1(mutableState).getCobaltApi();
                ComposerKt.sourceInformationMarkerStart(composer, 1386276164, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue12 = composer.rememberedValue();
                if (objRememberedValue12 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue12 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda44
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$13$0(mutableState, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue12);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                OutlinedTextFieldKt.OutlinedTextField(cobaltApi, (Function1<? super String, Unit>) objRememberedValue12, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1167145624$app(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 0, 0, 8388536);
                String cobaltDownloadMode = SettingsDialog$lambda$1(mutableState).getCobaltDownloadMode();
                List listListOf = CollectionsKt.listOf((Object[]) new String[]{DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "audio", "mute"});
                ComposerKt.sourceInformationMarkerStart(composer, 1386282820, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue13 = composer.rememberedValue();
                if (objRememberedValue13 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue13 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda55
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$14$0((String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue13);
                }
                Function1 function5 = (Function1) objRememberedValue13;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1386283117, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue14 = composer.rememberedValue();
                if (objRememberedValue14 == Composer.INSTANCE.getEmpty()) {
                    mutableState2 = mutableState;
                    objRememberedValue14 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda60
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$15$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue14);
                } else {
                    mutableState2 = mutableState;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CompactDropdown("downloadMode", cobaltDownloadMode, listListOf, function5, (Function1) objRememberedValue14, composer, 28038);
                String cobaltVideoQuality = SettingsDialog$lambda$1(mutableState2).getCobaltVideoQuality();
                List listListOf2 = CollectionsKt.listOf((Object[]) new String[]{"max", "2160", "1440", "1080", "720", "480", "360"});
                ComposerKt.sourceInformationMarkerStart(composer, 1386288772, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue15 = composer.rememberedValue();
                if (objRememberedValue15 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue15 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda61
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$16$0((String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue15);
                }
                Function1 function6 = (Function1) objRememberedValue15;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1386289069, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue16 = composer.rememberedValue();
                if (objRememberedValue16 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue16 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda62
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$17$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue16);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CompactDropdown("videoQuality", cobaltVideoQuality, listListOf2, function6, (Function1) objRememberedValue16, composer, 28038);
                String cobaltAudioFormat = SettingsDialog$lambda$1(mutableState2).getCobaltAudioFormat();
                List listListOf3 = CollectionsKt.listOf((Object[]) new String[]{"best", "mp3", "ogg", "wav", "opus"});
                ComposerKt.sourceInformationMarkerStart(composer, 1386294180, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue17 = composer.rememberedValue();
                if (objRememberedValue17 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue17 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda63
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$18$0((String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue17);
                }
                Function1 function7 = (Function1) objRememberedValue17;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1386294476, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue18 = composer.rememberedValue();
                if (objRememberedValue18 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue18 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$19$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue18);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CompactDropdown("audioFormat", cobaltAudioFormat, listListOf3, function7, (Function1) objRememberedValue18, composer, 28038);
                String cobaltAudioBitrate = SettingsDialog$lambda$1(mutableState2).getCobaltAudioBitrate();
                List listListOf4 = CollectionsKt.listOf((Object[]) new String[]{"320", "256", "128", "96", "64"});
                ComposerKt.sourceInformationMarkerStart(composer, 1386299492, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue19 = composer.rememberedValue();
                if (objRememberedValue19 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue19 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$20$0((String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue19);
                }
                Function1 function8 = (Function1) objRememberedValue19;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 1386299789, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue20 = composer.rememberedValue();
                if (objRememberedValue20 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue20 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$21$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue20);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CompactDropdown("audioBitrate", cobaltAudioBitrate, listListOf4, function8, (Function1) objRememberedValue20, composer, 28038);
                String cobaltAuthorization = SettingsDialog$lambda$1(mutableState2).getCobaltAuthorization();
                ComposerKt.sourceInformationMarkerStart(composer, 1386304078, "CC(remember):MainActivity.kt#9igjgp");
                Object objRememberedValue21 = composer.rememberedValue();
                if (objRememberedValue21 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue21 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MainActivityKt.SettingsDialog$lambda$6$0$22$0(mutableState2, (String) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue21);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                OutlinedTextFieldKt.OutlinedTextField(cobaltAuthorization, (Function1<? super String, Unit>) objRememberedValue21, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$MainActivityKt.INSTANCE.getLambda$400643599$app(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 2, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, composer, 1573296, 100663296, 0, 8126392);
                composer.endReplaceGroup();
                Unit unit3 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsDialog$lambda$6$0$1$0(MediaChoice it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$2$0(MutableState mutableState, MediaChoice it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), it, null, null, null, false, false, null, null, null, null, null, null, null, 8190, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsDialog$lambda$6$0$3$0(QualityChoice it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$4$0(MutableState mutableState, QualityChoice it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, it, null, null, false, false, null, null, null, null, null, null, null, 8189, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsDialog$lambda$6$0$5$0(FileTypeChoice it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$6$0(MutableState mutableState, FileTypeChoice it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, it, null, false, false, null, null, null, null, null, null, null, 8187, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String SettingsDialog$lambda$6$0$7$0(ImageFormatChoice it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLabel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$8$0(MutableState mutableState, ImageFormatChoice it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, it, false, false, null, null, null, null, null, null, null, 8183, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$9$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, null, false, false, it, null, null, null, null, null, null, 8127, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$10(DownloadMode downloadMode, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C430@17536L67:MainActivity.kt#tgtg9h");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-245644592, i, -1, "com.yvii.douyindownloader.SettingsDialog.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:430)");
            }
            TextKt.m2713TextNvy7gAk(StringsKt.substringBefore$default(downloadMode.getTitle(), " ", (String) null, 2, (Object) null) + " cookie header (optional)", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$11$0(MutableState mutableState, boolean z) {
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, null, z, false, null, null, null, null, null, null, null, 8175, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$12$0(MutableState mutableState, boolean z) {
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, null, false, z, null, null, null, null, null, null, null, 8159, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$13$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, null, false, false, null, it, null, null, null, null, null, 8063, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$15$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, null, false, false, null, null, it, null, null, null, null, 7935, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$17$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, null, false, false, null, null, null, it, null, null, null, 7679, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$19$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, null, false, false, null, null, null, null, it, null, null, 7167, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$21$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, null, false, false, null, null, null, null, null, it, null, 6143, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$6$0$22$0(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(DownloadSettings.copy$default(SettingsDialog$lambda$1(mutableState), null, null, null, null, false, false, null, null, null, null, null, null, it, UnixStat.PERM_MASK, null));
        return Unit.INSTANCE;
    }

    static final Unit SettingsDialog$lambda$3(final Function1 function1, final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C468@19821L17,468@19804L52:MainActivity.kt#tgtg9h");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1504616835, i, -1, "com.yvii.douyindownloader.SettingsDialog.<anonymous> (MainActivity.kt:468)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -1467199692, "CC(remember):MainActivity.kt#9igjgp");
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.SettingsDialog$lambda$3$0$0(function1, mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ButtonKt.Button((Function0) objRememberedValue, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$1999034739$app(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SettingsDialog$lambda$3$0$0(Function1 function1, MutableState mutableState) {
        function1.invoke(SettingsDialog$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    static final Unit SettingsDialog$lambda$4(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C469@19882L50:MainActivity.kt#tgtg9h");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1343769595, i, -1, "com.yvii.douyindownloader.SettingsDialog.<anonymous> (MainActivity.kt:469)");
            }
            ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$MainActivityKt.INSTANCE.getLambda$72289218$app(), composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void SettingSwitch(String str, boolean z, Function1<? super Boolean, Unit> function1, Composer composer, final int i) {
        int i2;
        final String str2;
        final boolean z2;
        final Function1<? super Boolean, Unit> function2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-210861551);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SettingSwitch)N(title,checked,onCheckedChange)475@20053L251:MainActivity.kt#tgtg9h");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            str2 = str;
            z2 = z;
            function2 = function1;
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-210861551, i2, -1, "com.yvii.douyindownloader.SettingSwitch (MainActivity.kt:474)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4008constructorimpl = Updater.m4008constructorimpl(composerStartRestartGroup);
            Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1790447741, "C476@20213L10,476@20147L88,477@20240L60:MainActivity.kt#tgtg9h");
            composer2 = composerStartRestartGroup;
            TextKt.m2713TextNvy7gAk(str, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composer2, i2 & 14, 0, 131068);
            str2 = str;
            z2 = z;
            function2 = function1;
            SwitchKt.Switch(z2, function2, null, null, false, null, null, composer2, (i2 >> 3) & WebSocketProtocol.PAYLOAD_SHORT, 124);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda53
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.SettingSwitch$lambda$1(str2, z2, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final <T> void CompactDropdown(final String str, final T t, final List<? extends T> list, final Function1<? super T, String> function1, final Function1<? super T, Unit> function2, Composer composer, final int i) {
        String str2;
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(524305294);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CompactDropdown)N(label,value,options,optionLabel,onSelected)489@20480L34,490@20517L743:MainActivity.kt#tgtg9h");
        if ((i & 6) == 0) {
            str2 = str;
            i2 = (composerStartRestartGroup.changed(str2) ? 4 : 2) | i;
        } else {
            str2 = str;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(t) : composerStartRestartGroup.changedInstance(t) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & CpioConstants.C_ISBLK) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(524305294, i2, -1, "com.yvii.douyindownloader.CompactDropdown (MainActivity.kt:488)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1346218800, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM689spacedBy0680j_4 = Arrangement.INSTANCE.m689spacedBy0680j_4(Dp.m7521constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM689spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i3 = i2;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4008constructorimpl = Updater.m4008constructorimpl(composerStartRestartGroup);
            Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2118929967, "C495@20746L10,495@20680L88,496@20773L483:MainActivity.kt#tgtg9h");
            TextKt.m2713TextNvy7gAk(str2, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getBodyMedium(), composerStartRestartGroup, i3 & 14, 0, 131068);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM4008constructorimpl2 = Updater.m4008constructorimpl(composerStartRestartGroup);
            Updater.m4016setimpl(composerM4008constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 586692826, "C497@20810L19,497@20831L90,497@20785L136,500@20981L20,500@21003L247,500@20928L322:MainActivity.kt#tgtg9h");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2059284053, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.CompactDropdown$lambda$3$0$0$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.OutlinedButton((Function0) objRememberedValue2, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1817914134, true, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.CompactDropdown$lambda$3$0$1(function1, t, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306374, 510);
            boolean zCompactDropdown$lambda$1 = CompactDropdown$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2059278580, "CC(remember):MainActivity.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivityKt.CompactDropdown$lambda$3$0$2$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidMenu_androidKt.m1709DropdownMenuIlH_yew(zCompactDropdown$lambda$1, (Function0) objRememberedValue3, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1833123741, true, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.CompactDropdown$lambda$3$0$3(list, function2, function1, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 48, 2044);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.CompactDropdown$lambda$4(str, t, list, function1, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean CompactDropdown$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void CompactDropdown$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactDropdown$lambda$3$0$0$0(MutableState mutableState) {
        CompactDropdown$lambda$2(mutableState, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactDropdown$lambda$3$0$1(Function1 function1, Object obj, RowScope OutlinedButton, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
        ComposerKt.sourceInformation(composer, "C498@20841L72:MainActivity.kt#tgtg9h");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1817914134, i, -1, "com.yvii.douyindownloader.CompactDropdown.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:498)");
            }
            TextKt.m2713TextNvy7gAk((String) function1.invoke(obj), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m7457getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer, 0, 24960, 241662);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactDropdown$lambda$3$0$2$0(MutableState mutableState) {
        CompactDropdown$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactDropdown$lambda$3$0$3(List list, final Function1 function1, final Function1 function2, final MutableState mutableState, ColumnScope DropdownMenu, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*503@21088L29,504@21141L79,502@21051L181:MainActivity.kt#tgtg9h");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1833123741, i, -1, "com.yvii.douyindownloader.CompactDropdown.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:501)");
            }
            for (final Object obj : list) {
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1298623760, true, new Function2() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return MainActivityKt.CompactDropdown$lambda$3$0$3$0$0(function2, obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, -1175834321, "CC(remember):MainActivity.kt#9igjgp");
                boolean zChanged = composer2.changed(function1) | composer2.changedInstance(obj);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainActivityKt.CompactDropdown$lambda$3$0$3$0$1$0(function1, obj, mutableState);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) objRememberedValue, null, null, null, false, null, null, null, composer2, 6, TarConstants.XSTAR_MAGIC_OFFSET);
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactDropdown$lambda$3$0$3$0$0(Function1 function1, Object obj, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C503@21090L25:MainActivity.kt#tgtg9h");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1298623760, i, -1, "com.yvii.douyindownloader.CompactDropdown.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:503)");
            }
            TextKt.m2713TextNvy7gAk((String) function1.invoke(obj), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompactDropdown$lambda$3$0$3$0$1$0(Function1 function1, Object obj, MutableState mutableState) {
        function1.invoke(obj);
        CompactDropdown$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setSelectedImages(List<String> list, List<String> list2) {
        list.clear();
        Iterator it = CollectionsKt.distinct(list2).iterator();
        while (it.hasNext()) {
            list.add((String) it.next());
        }
    }

    private static final Map<DownloadMode, DownloadSettings> loadSettings(Context context) {
        Object objM8052constructorimpl;
        DownloadSettings downloadSettings;
        Object objM8052constructorimpl2;
        Object objM8052constructorimpl3;
        Object objM8052constructorimpl4;
        Object objM8052constructorimpl5;
        SharedPreferences sharedPreferences = context.getSharedPreferences("downloader_settings", 0);
        EnumEntries<DownloadMode> entries = DownloadMode.getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (DownloadMode downloadMode : entries) {
            String string = sharedPreferences.getString(downloadMode.name(), null);
            if (string == null) {
                downloadSettings = new DownloadSettings(null, null, null, null, false, false, null, null, null, null, null, null, null, 8191, null);
            } else {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject jSONObject = new JSONObject(string);
                    String strOptString = jSONObject.optString("mediaChoice");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    MediaChoice mediaChoice = MediaChoice.Auto;
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM8052constructorimpl2 = Result.m8052constructorimpl(MediaChoice.valueOf(strOptString));
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        objM8052constructorimpl2 = Result.m8052constructorimpl(ResultKt.createFailure(th));
                    }
                    if (!Result.m8058isFailureimpl(objM8052constructorimpl2)) {
                        mediaChoice = objM8052constructorimpl2;
                    }
                    MediaChoice mediaChoice2 = (MediaChoice) ((Enum) mediaChoice);
                    String strOptString2 = jSONObject.optString("quality");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    QualityChoice qualityChoice = QualityChoice.Best;
                    try {
                        Result.Companion companion4 = Result.INSTANCE;
                        objM8052constructorimpl3 = Result.m8052constructorimpl(QualityChoice.valueOf(strOptString2));
                    } catch (Throwable th2) {
                        Result.Companion companion5 = Result.INSTANCE;
                        objM8052constructorimpl3 = Result.m8052constructorimpl(ResultKt.createFailure(th2));
                    }
                    if (!Result.m8058isFailureimpl(objM8052constructorimpl3)) {
                        qualityChoice = objM8052constructorimpl3;
                    }
                    QualityChoice qualityChoice2 = (QualityChoice) ((Enum) qualityChoice);
                    String strOptString3 = jSONObject.optString("fileType");
                    Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                    FileTypeChoice fileTypeChoice = FileTypeChoice.Auto;
                    try {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM8052constructorimpl4 = Result.m8052constructorimpl(FileTypeChoice.valueOf(strOptString3));
                    } catch (Throwable th3) {
                        Result.Companion companion7 = Result.INSTANCE;
                        objM8052constructorimpl4 = Result.m8052constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (!Result.m8058isFailureimpl(objM8052constructorimpl4)) {
                        fileTypeChoice = objM8052constructorimpl4;
                    }
                    FileTypeChoice fileTypeChoice2 = (FileTypeChoice) ((Enum) fileTypeChoice);
                    String strOptString4 = jSONObject.optString("imageFormat");
                    Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
                    ImageFormatChoice imageFormatChoice = ImageFormatChoice.Auto;
                    try {
                        Result.Companion companion8 = Result.INSTANCE;
                        objM8052constructorimpl5 = Result.m8052constructorimpl(ImageFormatChoice.valueOf(strOptString4));
                    } catch (Throwable th4) {
                        Result.Companion companion9 = Result.INSTANCE;
                        objM8052constructorimpl5 = Result.m8052constructorimpl(ResultKt.createFailure(th4));
                    }
                    if (!Result.m8058isFailureimpl(objM8052constructorimpl5)) {
                        imageFormatChoice = objM8052constructorimpl5;
                    }
                    ImageFormatChoice imageFormatChoice2 = (ImageFormatChoice) ((Enum) imageFormatChoice);
                    boolean zOptBoolean = jSONObject.optBoolean("updateYtDlp", true);
                    boolean zOptBoolean2 = jSONObject.optBoolean("includeThumbnail", true);
                    String strOptString5 = jSONObject.optString("cookies", "");
                    Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
                    String strOptString6 = jSONObject.optString("cobaltApi", "https://api.cobalt.tools");
                    Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
                    String strOptString7 = jSONObject.optString("cobaltDownloadMode", DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
                    Intrinsics.checkNotNullExpressionValue(strOptString7, "optString(...)");
                    String strOptString8 = jSONObject.optString("cobaltVideoQuality", "1080");
                    Intrinsics.checkNotNullExpressionValue(strOptString8, "optString(...)");
                    String strOptString9 = jSONObject.optString("cobaltAudioFormat", "mp3");
                    Intrinsics.checkNotNullExpressionValue(strOptString9, "optString(...)");
                    String strOptString10 = jSONObject.optString("cobaltAudioBitrate", "128");
                    Intrinsics.checkNotNullExpressionValue(strOptString10, "optString(...)");
                    String strOptString11 = jSONObject.optString("cobaltAuthorization", "");
                    Intrinsics.checkNotNullExpressionValue(strOptString11, "optString(...)");
                    objM8052constructorimpl = Result.m8052constructorimpl(new DownloadSettings(mediaChoice2, qualityChoice2, fileTypeChoice2, imageFormatChoice2, zOptBoolean, zOptBoolean2, strOptString5, strOptString6, strOptString7, strOptString8, strOptString9, strOptString10, strOptString11));
                } catch (Throwable th5) {
                    Result.Companion companion10 = Result.INSTANCE;
                    objM8052constructorimpl = Result.m8052constructorimpl(ResultKt.createFailure(th5));
                }
                DownloadSettings downloadSettings2 = new DownloadSettings(null, null, null, null, false, false, null, null, null, null, null, null, null, 8191, null);
                if (Result.m8058isFailureimpl(objM8052constructorimpl)) {
                    objM8052constructorimpl = downloadSettings2;
                }
                downloadSettings = (DownloadSettings) objM8052constructorimpl;
            }
            linkedHashMap.put(downloadMode, downloadSettings);
        }
        return linkedHashMap;
    }

    private static final void saveSettings(Context context, Map<DownloadMode, DownloadSettings> map) throws JSONException {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("downloader_settings", 0).edit();
        for (Map.Entry<DownloadMode, DownloadSettings> entry : map.entrySet()) {
            DownloadMode key = entry.getKey();
            DownloadSettings value = entry.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("mediaChoice", value.getMediaChoice().name());
            jSONObject.put("quality", value.getQuality().name());
            jSONObject.put("fileType", value.getFileType().name());
            jSONObject.put("imageFormat", value.getImageFormat().name());
            jSONObject.put("updateYtDlp", value.getUpdateYtDlp());
            jSONObject.put("includeThumbnail", value.getIncludeThumbnail());
            jSONObject.put("cookies", value.getCookies());
            jSONObject.put("cobaltApi", value.getCobaltApi());
            jSONObject.put("cobaltDownloadMode", value.getCobaltDownloadMode());
            jSONObject.put("cobaltVideoQuality", value.getCobaltVideoQuality());
            jSONObject.put("cobaltAudioFormat", value.getCobaltAudioFormat());
            jSONObject.put("cobaltAudioBitrate", value.getCobaltAudioBitrate());
            jSONObject.put("cobaltAuthorization", value.getCobaltAuthorization());
            editorEdit.putString(key.name(), jSONObject.toString());
        }
        editorEdit.apply();
    }

    private static final /* synthetic */ <T extends Enum<T>> T enumValue(String str, T t) {
        Object objM8052constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Intrinsics.reifiedOperationMarker(5, ExifInterface.GPS_DIRECTION_TRUE);
            objM8052constructorimpl = Result.m8052constructorimpl(Enum.valueOf(null, str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM8052constructorimpl = Result.m8052constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m8058isFailureimpl(objM8052constructorimpl)) {
            t = (T) objM8052constructorimpl;
        }
        return t;
    }

    private static final String extractUrl(String str) {
        String value;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("https?://[^\\s\"'<>，。]+"), str, 0, 2, null);
        if (matchResultFind$default == null || (value = matchResultFind$default.getValue()) == null) {
            return null;
        }
        return StringsKt.trimEnd(value, ':', ';', ',', FilenameUtils.EXTENSION_SEPARATOR, ')', ']', '}');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mediaSummary(AnalyzedMedia analyzedMedia) {
        ArrayList arrayList = new ArrayList();
        if (analyzedMedia.getVideoUrl() != null) {
            arrayList.add("1 video");
        }
        if (analyzedMedia.getAudioUrl() != null) {
            arrayList.add("1 audio");
        }
        if (!analyzedMedia.getImages().isEmpty()) {
            arrayList.add(analyzedMedia.getImages().size() + " image(s)");
        }
        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
        if (StringsKt.isBlank(strJoinToString$default)) {
            strJoinToString$default = "no downloadable media";
        }
        return strJoinToString$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object analyzeByMode(Context context, DownloadMode downloadMode, String str, DownloadSettings downloadSettings, Function1<? super String, Unit> function1, Continuation<? super AnalyzedMedia> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[downloadMode.ordinal()];
        if (i == 1) {
            return analyzeDouyin(str, downloadSettings, function1, continuation);
        }
        if (i == 2) {
            return analyzeVideo(context, str, downloadSettings, function1, continuation);
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return analyzeCobalt(str, downloadSettings, function1, continuation);
    }

    /* JADX INFO: renamed from: com.yvii.douyindownloader.MainActivityKt$analyzeVideo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/douyinvideodownloader/AnalyzedMedia;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
    @DebugMetadata(c = "com.yvii.douyindownloader.MainActivityKt$analyzeVideo$2", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C03352 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnalyzedMedia>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Function1<String, Unit> $onProgress;
        final /* synthetic */ DownloadSettings $settings;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03352(String str, Function1<? super String, Unit> function1, Context context, DownloadSettings downloadSettings, Continuation<? super C03352> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$onProgress = function1;
            this.$context = context;
            this.$settings = downloadSettings;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03352(this.$url, this.$onProgress, this.$context, this.$settings, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AnalyzedMedia> continuation) {
            return ((C03352) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws YoutubeDL.CanceledException, InterruptedException, YoutubeDLException {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String strNormalizeUrl = MainActivityKt.normalizeUrl(this.$url);
                if (MainActivityKt.isDirectImage(strNormalizeUrl)) {
                    return new AnalyzedMedia("Direct image", strNormalizeUrl, null, null, CollectionsKt.listOf(new MediaItem(strNormalizeUrl, "Image 1")));
                }
                this.$onProgress.invoke("Initializing yt-dlp");
                YoutubeDL youtubeDL = YoutubeDL.getInstance();
                Context applicationContext = this.$context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                youtubeDL.init(applicationContext);
                YoutubeDL youtubeDL2 = YoutubeDL.getInstance();
                YoutubeDLRequest youtubeDLRequest = new YoutubeDLRequest(strNormalizeUrl);
                youtubeDLRequest.addOption("-f", this.$settings.getQuality().getYtdlpFormat());
                VideoInfo info = youtubeDL2.getInfo(youtubeDLRequest);
                ArrayList<VideoThumbnail> thumbnails = info.getThumbnails();
                if (thumbnails == null) {
                    thumbnails = CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (Object obj2 : thumbnails) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    String url = ((VideoThumbnail) obj2).getUrl();
                    MediaItem mediaItem = null;
                    if (url != null) {
                        if (!StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
                            url = null;
                        }
                        if (url != null) {
                            mediaItem = new MediaItem(url, "Thumbnail " + i2);
                        }
                    }
                    if (mediaItem != null) {
                        arrayList.add(mediaItem);
                    }
                    i = i2;
                }
                ArrayList arrayList2 = arrayList;
                String title = info.getTitle();
                if (title == null) {
                    title = "Video";
                }
                return new AnalyzedMedia(title, strNormalizeUrl, info.getUrl(), null, arrayList2);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object analyzeVideo(Context context, String str, DownloadSettings downloadSettings, Function1<? super String, Unit> function1, Continuation<? super AnalyzedMedia> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C03352(str, function1, context, downloadSettings, null), continuation);
    }

    /* JADX INFO: renamed from: com.yvii.douyindownloader.MainActivityKt$analyzeDouyin$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/douyinvideodownloader/AnalyzedMedia;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
    @DebugMetadata(c = "com.yvii.douyindownloader.MainActivityKt$analyzeDouyin$2", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C03342 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnalyzedMedia>, Object> {
        final /* synthetic */ Function1<String, Unit> $onProgress;
        final /* synthetic */ DownloadSettings $settings;
        final /* synthetic */ String $url;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03342(Function1<? super String, Unit> function1, String str, DownloadSettings downloadSettings, Continuation<? super C03342> continuation) {
            super(2, continuation);
            this.$onProgress = function1;
            this.$url = str;
            this.$settings = downloadSettings;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C03342 c03342 = new C03342(this.$onProgress, this.$url, this.$settings, continuation);
            c03342.L$0 = obj;
            return c03342;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AnalyzedMedia> continuation) {
            return ((C03342) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:36:0x00ed  */
        /* JADX WARN: Code duplicated, block: B:38:0x00f3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            JSONObject jSONObjectFetchDouyinPayload;
            String strExtractHtmlTitle;
            String strExtractFirstMediaUrl;
            String str2;
            Object objM8052constructorimpl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$onProgress.invoke("Resolving Douyin link");
            int i = 0;
            String strExtractDouyinAudio = null;
            HttpResult httpResultHttpGet$default = MainActivityKt.httpGet$default(this.$url, this.$settings.getCookies(), false, 4, null);
            String finalUrl = httpResultHttpGet$default.getFinalUrl();
            String strExtractAwemeId = MainActivityKt.extractAwemeId(finalUrl, httpResultHttpGet$default.getBody());
            if (strExtractAwemeId != null) {
                Function1<String, Unit> function1 = this.$onProgress;
                DownloadSettings downloadSettings = this.$settings;
                String str3 = finalUrl;
                String str4 = (StringsKt.contains$default((CharSequence) str3, (CharSequence) "/note/", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str3, (CharSequence) "/gallery/", false, 2, (Object) null)) ? "note" : "video";
                try {
                    Result.Companion companion = Result.INSTANCE;
                    function1.invoke("Fetching Douyin share page");
                    objM8052constructorimpl = Result.m8052constructorimpl(MainActivityKt.httpGet("https://www.iesdouyin.com/share/" + str4 + "/" + strExtractAwemeId + "/?from_ssr=1", downloadSettings.getCookies(), true).getBody());
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM8052constructorimpl = Result.m8052constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m8058isFailureimpl(objM8052constructorimpl)) {
                    objM8052constructorimpl = null;
                }
                str = (String) objM8052constructorimpl;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (strExtractAwemeId != null) {
                Function1<String, Unit> function2 = this.$onProgress;
                DownloadSettings downloadSettings2 = this.$settings;
                function2.invoke("Fetching Douyin detail");
                jSONObjectFetchDouyinPayload = MainActivityKt.fetchDouyinPayload(strExtractAwemeId, downloadSettings2.getCookies());
            } else {
                jSONObjectFetchDouyinPayload = null;
            }
            String str5 = httpResultHttpGet$default.getBody() + IOUtils.LINE_SEPARATOR_UNIX + str;
            if (jSONObjectFetchDouyinPayload == null || (strExtractHtmlTitle = jSONObjectFetchDouyinPayload.optString("desc")) == null) {
                strExtractHtmlTitle = MainActivityKt.extractHtmlTitle(str5);
                if (strExtractHtmlTitle == null) {
                    strExtractHtmlTitle = "Douyin media";
                }
            } else {
                if (StringsKt.isBlank(strExtractHtmlTitle)) {
                    strExtractHtmlTitle = null;
                }
                if (strExtractHtmlTitle == null) {
                    strExtractHtmlTitle = MainActivityKt.extractHtmlTitle(str5);
                    if (strExtractHtmlTitle == null) {
                        strExtractHtmlTitle = "Douyin media";
                    }
                }
            }
            String str6 = strExtractHtmlTitle;
            List listExtractDouyinImages = jSONObjectFetchDouyinPayload != null ? MainActivityKt.extractDouyinImages(jSONObjectFetchDouyinPayload) : null;
            if (listExtractDouyinImages == null) {
                listExtractDouyinImages = CollectionsKt.emptyList();
            }
            ArrayList arrayList = listExtractDouyinImages;
            if (arrayList.isEmpty()) {
                List listExtractImageUrlsFromHtml = MainActivityKt.extractImageUrlsFromHtml(str5);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listExtractImageUrlsFromHtml, 10));
                for (Object obj2 : listExtractImageUrlsFromHtml) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    arrayList2.add(new MediaItem((String) obj2, "Image " + i2));
                    i = i2;
                }
                arrayList = arrayList2;
            }
            List list = arrayList;
            if (list.isEmpty()) {
                if (jSONObjectFetchDouyinPayload == null || (strExtractFirstMediaUrl = MainActivityKt.extractDouyinVideo(jSONObjectFetchDouyinPayload, this.$settings.getQuality())) == null) {
                    strExtractFirstMediaUrl = MainActivityKt.extractFirstMediaUrl(str5, true);
                }
                str2 = strExtractFirstMediaUrl;
            } else {
                str2 = null;
            }
            if ((list.isEmpty() || this.$settings.getMediaChoice() == MediaChoice.Audio || this.$settings.getFileType() == FileTypeChoice.Mp3) && jSONObjectFetchDouyinPayload != null) {
                strExtractDouyinAudio = MainActivityKt.extractDouyinAudio(jSONObjectFetchDouyinPayload);
            }
            return new AnalyzedMedia(str6, finalUrl, str2, strExtractDouyinAudio, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object analyzeDouyin(String str, DownloadSettings downloadSettings, Function1<? super String, Unit> function1, Continuation<? super AnalyzedMedia> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C03342(function1, str, downloadSettings, null), continuation);
    }

    /* JADX INFO: renamed from: com.yvii.douyindownloader.MainActivityKt$analyzeCobalt$2, reason: invalid class name */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/example/douyinvideodownloader/AnalyzedMedia;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
    @DebugMetadata(c = "com.yvii.douyindownloader.MainActivityKt$analyzeCobalt$2", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnalyzedMedia>, Object> {
        final /* synthetic */ Function1<String, Unit> $onProgress;
        final /* synthetic */ DownloadSettings $settings;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super String, Unit> function1, DownloadSettings downloadSettings, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$onProgress = function1;
            this.$settings = downloadSettings;
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$onProgress, this.$settings, this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AnalyzedMedia> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:114:0x02c8 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:115:0x02ca  */
        /* JADX WARN: Code duplicated, block: B:116:0x02cd  */
        /* JADX WARN: Code duplicated, block: B:135:0x02ed A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:42:0x011a  */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x01d9, code lost:
        
            if (r1.equals("redirect") != false) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x01e0, code lost:
        
            if (r1.equals("tunnel") != false) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x01e2, code lost:
        
            r14 = r6.optString("url");
            r16 = r6.optString("filename", "cobalt media");
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x01f1, code lost:
        
            if (com.yvii.douyindownloader.MainActivityKt.looksLikeImageUrl(r14) != false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x01fb, code lost:
        
            if (r21.$settings.getFileType() != com.yvii.douyindownloader.FileTypeChoice.Image) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x01fe, code lost:
        
            kotlin.jvm.internal.Intrinsics.checkNotNull(r16);
         */
        /* JADX WARN: Code restructure failed: missing block: B:76:0x020f, code lost:
        
            return new com.yvii.douyindownloader.AnalyzedMedia(r16, r21.$url, r14, null, kotlin.collections.CollectionsKt.emptyList());
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x0210, code lost:
        
            kotlin.jvm.internal.Intrinsics.checkNotNull(r16);
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x022f, code lost:
        
            return new com.yvii.douyindownloader.AnalyzedMedia(r16, r21.$url, null, null, kotlin.collections.CollectionsKt.listOf(new com.yvii.douyindownloader.MediaItem(r14, "Image 1")));
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) throws org.json.JSONException {
            /*
                Method dump skipped, instruction units count: 820
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yvii.douyindownloader.MainActivityKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object analyzeCobalt(String str, DownloadSettings downloadSettings, Function1<? super String, Unit> function1, Continuation<? super AnalyzedMedia> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(function1, downloadSettings, str, null), continuation);
    }

    /* JADX INFO: renamed from: com.yvii.douyindownloader.MainActivityKt$download$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
    @DebugMetadata(c = "com.yvii.douyindownloader.MainActivityKt$download$2", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C03362 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ AnalyzedMedia $media;
        final /* synthetic */ DownloadMode $mode;
        final /* synthetic */ Function1<String, Unit> $onProgress;
        final /* synthetic */ Set<String> $selectedImages;
        final /* synthetic */ DownloadSettings $settings;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C03362(Context context, DownloadMode downloadMode, DownloadSettings downloadSettings, AnalyzedMedia analyzedMedia, Function1<? super String, Unit> function1, Set<String> set, Continuation<? super C03362> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$mode = downloadMode;
            this.$settings = downloadSettings;
            this.$media = analyzedMedia;
            this.$onProgress = function1;
            this.$selectedImages = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C03362(this.$context, this.$mode, this.$settings, this.$media, this.$onProgress, this.$selectedImages, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
            return ((C03362) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws YoutubeDL.CanceledException, InterruptedException, IOException, YoutubeDLException {
            String sourceUrl;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MainActivityKt.ensureDownloadPermission(this.$context);
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "douyinDownloader");
                file.mkdirs();
                int i = 0;
                if (this.$mode == DownloadMode.Video && this.$settings.getMediaChoice() == MediaChoice.Images) {
                    List<MediaItem> images = this.$media.getImages();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(images, 10));
                    Iterator<T> it = images.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((MediaItem) it.next()).getUrl());
                    }
                    Set<String> set = this.$selectedImages;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj2 : arrayList) {
                        String str = (String) obj2;
                        if (set.isEmpty() || set.contains(str)) {
                            arrayList2.add(obj2);
                        }
                    }
                    ArrayList arrayList3 = arrayList2;
                    if (arrayList3.isEmpty()) {
                        throw new IllegalStateException("No images found. Use Auto or Video media setting for this URL.".toString());
                    }
                    DownloadSettings downloadSettings = this.$settings;
                    Function1<String, Unit> function1 = this.$onProgress;
                    for (Object obj3 : arrayList3) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        MainActivityKt.downloadDirectFile((String) obj3, file, "image-" + i2, downloadSettings.getCookies(), ImageFormatChoice.Auto, function1);
                        i = i2;
                    }
                } else {
                    if (this.$mode == DownloadMode.Video && !MainActivityKt.isDirectImage(this.$media.getSourceUrl())) {
                        this.$onProgress.invoke("Initializing yt-dlp");
                        YoutubeDL youtubeDL = YoutubeDL.getInstance();
                        Context applicationContext = this.$context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        youtubeDL.init(applicationContext);
                        FFmpeg fFmpeg = FFmpeg.getInstance();
                        Context applicationContext2 = this.$context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
                        fFmpeg.init(applicationContext2);
                        if (this.$settings.getUpdateYtDlp()) {
                            this.$onProgress.invoke("Updating yt-dlp stable");
                            YoutubeDL youtubeDL2 = YoutubeDL.getInstance();
                            Context applicationContext3 = this.$context.getApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(applicationContext3, "getApplicationContext(...)");
                            youtubeDL2.updateYoutubeDL(applicationContext3, YoutubeDL.UpdateChannel._STABLE);
                            this.$onProgress.invoke("yt-dlp " + YoutubeDL.getInstance().versionName(this.$context.getApplicationContext()));
                        }
                        String videoUrl = this.$media.getVideoUrl();
                        if (videoUrl == null || (sourceUrl = StringsKt.removePrefix(videoUrl, (CharSequence) "ytdlp:")) == null) {
                            sourceUrl = this.$media.getSourceUrl();
                        }
                        YoutubeDLRequest youtubeDLRequest = new YoutubeDLRequest(sourceUrl);
                        youtubeDLRequest.addOption("--no-playlist");
                        youtubeDLRequest.addOption("--restrict-filenames");
                        youtubeDLRequest.addOption("-f", this.$settings.getQuality().getYtdlpFormat());
                        if (this.$settings.getIncludeThumbnail()) {
                            youtubeDLRequest.addOption("--write-thumbnail");
                            youtubeDLRequest.addOption("--convert-thumbnails", "jpg");
                        }
                        String absolutePath = new File(file, "%(title).80s-%(id)s.%(ext)s").getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                        youtubeDLRequest.addOption("-o", absolutePath);
                        YoutubeDL youtubeDL3 = YoutubeDL.getInstance();
                        String str2 = "download-" + System.currentTimeMillis();
                        final Function1<String, Unit> function2 = this.$onProgress;
                        youtubeDL3.execute(youtubeDLRequest, str2, new Function3() { // from class: com.yvii.douyindownloader.MainActivityKt$download$2$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                return MainActivityKt.C03362.invokeSuspend$lambda$4(function2, ((Float) obj4).floatValue(), ((Long) obj5).longValue(), (String) obj6);
                            }
                        });
                        return file;
                    }
                    boolean z = this.$settings.getMediaChoice() == MediaChoice.Audio || this.$settings.getFileType() == FileTypeChoice.Mp3;
                    boolean z2 = (z || this.$settings.getMediaChoice() == MediaChoice.Images || this.$settings.getFileType() == FileTypeChoice.Image) ? false : true;
                    boolean z3 = (z || this.$settings.getMediaChoice() == MediaChoice.Video || this.$settings.getFileType() == FileTypeChoice.Mp4 || this.$settings.getFileType() == FileTypeChoice.Mp3) ? false : true;
                    if (z) {
                        String audioUrl = this.$media.getAudioUrl();
                        if (audioUrl == null && (audioUrl = this.$media.getVideoUrl()) == null) {
                            throw new IllegalStateException("No audio found for this URL.".toString());
                        }
                        MainActivityKt.downloadDirectFile(audioUrl, file, "audio", this.$settings.getCookies(), ImageFormatChoice.Auto, this.$onProgress);
                        return file;
                    }
                    if (z2 && this.$media.getVideoUrl() != null) {
                        MainActivityKt.downloadDirectFile(this.$media.getVideoUrl(), file, "video", this.$settings.getCookies(), ImageFormatChoice.Auto, this.$onProgress);
                    }
                    List<MediaItem> images2 = this.$media.getImages();
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(images2, 10));
                    Iterator<T> it2 = images2.iterator();
                    while (it2.hasNext()) {
                        arrayList4.add(((MediaItem) it2.next()).getUrl());
                    }
                    Set<String> set2 = this.$selectedImages;
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj4 : arrayList4) {
                        String str3 = (String) obj4;
                        if (set2.isEmpty() || set2.contains(str3)) {
                            arrayList5.add(obj4);
                        }
                    }
                    ArrayList arrayList6 = arrayList5;
                    if (z3) {
                        ImageFormatChoice imageFormat = this.$mode == DownloadMode.Douyin ? this.$settings.getImageFormat() : ImageFormatChoice.Auto;
                        DownloadSettings downloadSettings2 = this.$settings;
                        Function1<String, Unit> function3 = this.$onProgress;
                        for (Object obj5 : arrayList6) {
                            int i3 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            MainActivityKt.downloadDirectFile((String) obj5, file, "image-" + i3, downloadSettings2.getCookies(), imageFormat, function3);
                            i = i3;
                        }
                    }
                }
                return file;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        static final Unit invokeSuspend$lambda$4(Function1 function1, float f, long j, String str) {
            String str2;
            if (f >= 0.0f) {
                str2 = ((int) f) + "% ETA " + j + "s";
            } else {
                str2 = "yt-dlp";
            }
            function1.invoke(str2 + " " + str);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object download(Context context, DownloadMode downloadMode, AnalyzedMedia analyzedMedia, DownloadSettings downloadSettings, Set<String> set, Function1<? super String, Unit> function1, Continuation<? super File> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C03362(context, downloadMode, downloadSettings, analyzedMedia, function1, set, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureDownloadPermission(Context context) {
        if (Build.VERSION.SDK_INT < 30 || Environment.isExternalStorageManager()) {
            return;
        }
        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        intent.addFlags(268435456);
        try {
            Result.Companion companion = Result.INSTANCE;
            context.startActivity(intent);
            Result.m8052constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m8052constructorimpl(ResultKt.createFailure(th));
        }
        throw new IllegalStateException("Storage permission required. Enable All files access, then press Download again.".toString());
    }

    static /* synthetic */ HttpResult httpGet$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return httpGet(str, str2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpResult httpGet(String str, String str2, boolean z) throws Throwable {
        String str3;
        Object objM8052constructorimpl;
        URLConnection uRLConnectionOpenConnection = new URL(normalizeUrl(str)).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setInstanceFollowRedirects(true);
        if (z) {
            str3 = "Mozilla/5.0 (iPhone; CPU iPhone OS 17_0 like Mac OS X) AppleWebKit/605.1.15 Mobile/15E148";
        } else {
            str3 = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 Chrome/124 Safari/537.36";
        }
        httpURLConnection.setRequestProperty("User-Agent", str3);
        httpURLConnection.setRequestProperty("Referer", "https://www.douyin.com/");
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8");
        if (!StringsKt.isBlank(str2)) {
            httpURLConnection.setRequestProperty("Cookie", str2);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM8052constructorimpl = Result.m8052constructorimpl(httpURLConnection.getInputStream());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM8052constructorimpl = Result.m8052constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM8055exceptionOrNullimpl = Result.m8055exceptionOrNullimpl(objM8052constructorimpl);
        if (thM8055exceptionOrNullimpl != null && (objM8052constructorimpl = httpURLConnection.getErrorStream()) == null) {
            throw thM8055exceptionOrNullimpl;
        }
        InputStream inputStream = (InputStream) objM8052constructorimpl;
        String string = httpURLConnection.getURL().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Intrinsics.checkNotNull(inputStream);
        Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            String text = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            return new HttpResult(string, text);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.closeFinally(bufferedReader, th2);
                throw th3;
            }
        }
    }

    static /* synthetic */ String httpPostJson$default(String str, JSONObject jSONObject, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        return httpPostJson(str, jSONObject, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String httpPostJson(String str, JSONObject jSONObject, String str2) throws Throwable {
        Object objM8052constructorimpl;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        URLConnection uRLConnectionOpenConnection = new URL(normalizeUrl(str)).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        httpURLConnection.setReadTimeout(60000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("User-Agent", "DouyinDownloaderAndroid/1.0");
        if (!StringsKt.isBlank(str2)) {
            httpURLConnection.setRequestProperty("Authorization", str2);
        }
        OutputStream outputStream = httpURLConnection.getOutputStream();
        try {
            outputStream.write(bytes);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                objM8052constructorimpl = Result.m8052constructorimpl(httpURLConnection.getInputStream());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM8052constructorimpl = Result.m8052constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM8055exceptionOrNullimpl = Result.m8055exceptionOrNullimpl(objM8052constructorimpl);
            if (thM8055exceptionOrNullimpl != null && (objM8052constructorimpl = httpURLConnection.getErrorStream()) == null) {
                throw thM8055exceptionOrNullimpl;
            }
            InputStream inputStream = (InputStream) objM8052constructorimpl;
            Intrinsics.checkNotNull(inputStream);
            Reader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                return text;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.closeFinally(bufferedReader, th2);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                CloseableKt.closeFinally(outputStream, th4);
                throw th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONObject fetchDouyinPayload(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        for (String str3 : CollectionsKt.listOf((Object[]) new String[]{"https://www.iesdouyin.com/web/api/v2/aweme/iteminfo/?item_ids=" + str, "https://www.douyin.com/aweme/v1/web/aweme/detail/?device_platform=webapp&aid=6383&channel=channel_pc_web&aweme_id=" + str, "https://www.douyin.com/aweme/v1/web/aweme/detail/?device_platform=webapp&aid=1128&channel=channel_pc_web&aweme_id=" + str})) {
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONObject jSONObject = new JSONObject(httpGet$default(str3, str2, false, 4, null).getBody());
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("aweme_detail");
                if (jSONObjectOptJSONObject2 != null) {
                    return jSONObjectOptJSONObject2;
                }
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("item_list");
                if (jSONArrayOptJSONArray != null && (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) != null) {
                    return jSONObjectOptJSONObject;
                }
                Result.m8052constructorimpl(null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m8052constructorimpl(ResultKt.createFailure(th));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractAwemeId(String str, String str2) {
        List<String> groupValues;
        String str3;
        List<String> groupValues2;
        String str4;
        for (Regex regex : CollectionsKt.listOf((Object[]) new Regex[]{new Regex("/(?:video|note|gallery|slides)/(\\d{15,20})"), new Regex("modal_id=(\\d{15,20})"), new Regex("\"aweme_id\"\\s*:\\s*\"(\\d{15,20})\""), new Regex("\"group_id\"\\s*:\\s*\"(\\d{15,20})\"")})) {
            MatchResult matchResultFind$default = Regex.find$default(regex, str, 0, 2, null);
            if (matchResultFind$default != null && (groupValues2 = matchResultFind$default.getGroupValues()) != null && (str4 = groupValues2.get(1)) != null) {
                return str4;
            }
            MatchResult matchResultFind$default2 = Regex.find$default(regex, str2, 0, 2, null);
            if (matchResultFind$default2 != null && (groupValues = matchResultFind$default2.getGroupValues()) != null && (str3 = groupValues.get(1)) != null) {
                return str3;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractDouyinVideo(JSONObject jSONObject, QualityChoice qualityChoice) {
        JSONObject jSONObject2;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("bit_rate");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            IntRange intRangeUntil = RangesKt.until(0, jSONArrayOptJSONArray.length());
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(((IntIterator) it).nextInt());
                if (jSONObjectOptJSONObject2 != null) {
                    arrayList.add(jSONObjectOptJSONObject2);
                }
            }
            List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.yvii.douyindownloader.MainActivityKt$extractDouyinVideo$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((JSONObject) t2).optInt("bit_rate", 0)), Integer.valueOf(((JSONObject) t).optInt("bit_rate", 0)));
                }
            });
            int i = WhenMappings.$EnumSwitchMapping$1[qualityChoice.ordinal()];
            if (i == 1) {
                jSONObject2 = (JSONObject) CollectionsKt.firstOrNull(listSortedWith);
            } else if (i == 2) {
                jSONObject2 = (JSONObject) CollectionsKt.getOrNull(listSortedWith, listSortedWith.size() / 2);
                if (jSONObject2 == null) {
                    jSONObject2 = (JSONObject) CollectionsKt.firstOrNull(listSortedWith);
                }
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                jSONObject2 = (JSONObject) CollectionsKt.lastOrNull(listSortedWith);
            }
            String str = (String) CollectionsKt.firstOrNull((List) extractUrlList(jSONObject2 != null ? jSONObject2.optJSONObject("play_addr") : null));
            if (str != null) {
                return cleanDouyinUrl(str);
            }
        }
        String str2 = (String) CollectionsKt.firstOrNull(CollectionsKt.plus((Collection) extractUrlList(jSONObjectOptJSONObject.optJSONObject("play_addr")), (Iterable) extractUrlList(jSONObjectOptJSONObject.optJSONObject("download_addr"))));
        if (str2 != null) {
            return cleanDouyinUrl(str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractDouyinAudio(JSONObject jSONObject) {
        Object next;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("music");
        Iterator it = CollectionsKt.plus((Collection) extractUrlList(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject("play_url") : null), (Iterable) extractUrlList(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optJSONObject("download_url") : null)).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!StringsKt.startsWith$default((String) next, "http", false, 2, (Object) null));
        String str = (String) next;
        if (str != null) {
            return cleanDouyinUrl(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<MediaItem> extractDouyinImages(JSONObject jSONObject) {
        List<JSONObject> objects;
        List<JSONObject> objects2;
        List<JSONObject> objects3;
        List<JSONObject> objects4;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("image_post_info");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
            if (jSONArrayOptJSONArray != null && (objects4 = toObjects(jSONArrayOptJSONArray)) != null) {
                CollectionsKt.addAll(arrayList, objects4);
            }
            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("image_list");
            if (jSONArrayOptJSONArray2 != null && (objects3 = toObjects(jSONArrayOptJSONArray2)) != null) {
                CollectionsKt.addAll(arrayList, objects3);
            }
        }
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray3 != null && (objects2 = toObjects(jSONArrayOptJSONArray3)) != null) {
            CollectionsKt.addAll(arrayList, objects2);
        }
        JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("image_list");
        if (jSONArrayOptJSONArray4 != null && (objects = toObjects(jSONArrayOptJSONArray4)) != null) {
            CollectionsKt.addAll(arrayList, objects);
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            List listListOf = CollectionsKt.listOf((Object[]) new JSONObject[]{jSONObject2.optJSONObject("watermark_free_download_url_list"), jSONObject2.optJSONObject("origin_image"), jSONObject2.optJSONObject("display_image"), jSONObject2.optJSONObject("download_addr"), jSONObject2.optJSONObject("owner_watermark_image")});
            ArrayList arrayList3 = new ArrayList();
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                CollectionsKt.addAll(arrayList3, extractUrlList((JSONObject) it.next()));
            }
            String str = (String) CollectionsKt.firstOrNull(CollectionsKt.plus((Collection) arrayList3, (Iterable) toStrings(jSONObject2.optJSONArray("download_url_list"))));
            MediaItem mediaItem = str != null ? new MediaItem(cleanDouyinUrl(str), "Image " + i2) : null;
            if (mediaItem != null) {
                arrayList2.add(mediaItem);
            }
            i = i2;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (hashSet.add(((MediaItem) obj2).getUrl())) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    private static final List<JSONObject> toObjects(JSONArray jSONArray) {
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(((IntIterator) it).nextInt());
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(jSONObjectOptJSONObject);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> toStrings(JSONArray jSONArray) {
        if (jSONArray == null) {
            return CollectionsKt.emptyList();
        }
        IntRange intRangeUntil = RangesKt.until(0, jSONArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            String strOptString = jSONArray.optString(((IntIterator) it).nextInt());
            Intrinsics.checkNotNull(strOptString);
            if (StringsKt.isBlank(strOptString)) {
                strOptString = null;
            }
            if (strOptString != null) {
                arrayList.add(strOptString);
            }
        }
        return arrayList;
    }

    private static final List<String> extractUrlList(JSONObject jSONObject) {
        if (jSONObject == null) {
            return CollectionsKt.emptyList();
        }
        return CollectionsKt.plus((Collection) toStrings(jSONObject.optJSONArray("url_list")), (Iterable) toStrings(jSONObject.optJSONArray("urlList")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractFirstMediaUrl(String str, boolean z) {
        Regex regex;
        String value;
        String strDecodeEscapedHtml = decodeEscapedHtml(str);
        if (z) {
            regex = new Regex("https?://[^\"'<>\\s\\\\]+(?:douyinvod|idouyinvod|amemv|snssdk|/aweme/v1/play|/aweme/v1/playwm)[^\"'<>\\s\\\\]+", RegexOption.IGNORE_CASE);
        } else {
            regex = new Regex("https?://[^\"'<>\\s\\\\]+(?:douyinpic|p\\d+-sign\\.douyinpic)[^\"'<>\\s\\\\]+", RegexOption.IGNORE_CASE);
        }
        MatchResult matchResultFind$default = Regex.find$default(regex, strDecodeEscapedHtml, 0, 2, null);
        if (matchResultFind$default == null || (value = matchResultFind$default.getValue()) == null) {
            return null;
        }
        return StringsKt.replace$default(cleanDouyinUrl(value), "/playwm/", "/play/", false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> extractImageUrlsFromHtml(String str) {
        String lastPathSegment;
        List<String> groupValues;
        Sequence<String> sequenceFilter = SequencesKt.filter(SequencesKt.map(Regex.findAll$default(new Regex("https?://[^\"'<>\\s]+(?:douyinpic|p\\d+-sign\\.douyinpic)[^\"'<>\\s]+"), decodeEscapedHtml(str), 0, 2, null), new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivityKt.extractImageUrlsFromHtml$lambda$0((MatchResult) obj);
            }
        }), new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(MainActivityKt.extractImageUrlsFromHtml$lambda$1((String) obj));
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str2 : sequenceFilter) {
            String str3 = str2;
            MatchResult matchResultFind$default = Regex.find$default(new Regex("/([^/?#]+)~"), str3, 0, 2, null);
            if ((matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (lastPathSegment = (String) CollectionsKt.getOrNull(groupValues, 1)) == null) && (lastPathSegment = Uri.parse(str2).getLastPathSegment()) == null) {
                lastPathSegment = "";
            }
            String str4 = (String) linkedHashMap.get(lastPathSegment);
            if (str4 != null) {
                String str5 = str4;
                if ((!StringsKt.contains((CharSequence) str5, (CharSequence) "cover", true) || StringsKt.contains((CharSequence) str3, (CharSequence) "cover", true)) && ((!StringsKt.contains((CharSequence) str5, (CharSequence) "shrink", true) || StringsKt.contains((CharSequence) str3, (CharSequence) "shrink", true)) && (!StringsKt.contains((CharSequence) str5, (CharSequence) "water", true) || StringsKt.contains((CharSequence) str3, (CharSequence) "water", true)))) {
                }
            }
            linkedHashMap.put(lastPathSegment, str2);
        }
        Collection collectionValues = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        return CollectionsKt.toList(CollectionsKt.take(collectionValues, 12));
    }

    static final String extractImageUrlsFromHtml$lambda$0(MatchResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return cleanDouyinUrl(it.getValue());
    }

    static final boolean extractImageUrlsFromHtml$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!isDirectImageLike(it)) {
            return false;
        }
        String str = it;
        return !StringsKt.contains((CharSequence) str, (CharSequence) "avatar", true) && StringsKt.contains((CharSequence) str, (CharSequence) "biz_tag=aweme_images", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractHtmlTitle(String str) {
        List<String> groupValues;
        String str2;
        String strReplace$default;
        String string;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("<title[^>]*>(.*?)</title>", RegexOption.IGNORE_CASE), str, 0, 2, null);
        if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (strReplace$default = StringsKt.replace$default(str2, " - 抖音", "", false, 4, (Object) null)) == null || (string = StringsKt.trim((CharSequence) strReplace$default).toString()) == null || StringsKt.isBlank(string)) {
            return null;
        }
        return string;
    }

    private static final String decodeEscapedHtml(String str) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "\\u002F", "/", false, 4, (Object) null), "\\/", "/", false, 4, (Object) null), "\\u0026", "&", false, 4, (Object) null), "&amp;", "&", false, 4, (Object) null);
    }

    private static final String cleanDouyinUrl(String str) {
        return StringsKt.trimEnd(decodeEscapedHtml(str), IOUtils.DIR_SEPARATOR_WINDOWS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String normalizeUrl(String str) {
        Uri uri = Uri.parse(str);
        return (uri.getScheme() != null || uri.getHost() == null) ? str : "https://" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isDirectImage(String str) {
        String path = Uri.parse(str).getPath();
        if (path == null) {
            path = "";
        }
        String lowerCase = path.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List listListOf = CollectionsKt.listOf((Object[]) new String[]{".jpg", ".jpeg", ".png", ".webp", ".gif"});
        if ((listListOf instanceof Collection) && listListOf.isEmpty()) {
            return false;
        }
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            if (StringsKt.endsWith$default(lowerCase, (String) it.next(), false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean isDirectImageLike(String str) {
        if (!isDirectImage(str)) {
            String str2 = str;
            if (!StringsKt.contains((CharSequence) str2, (CharSequence) "image", true) && !StringsKt.contains((CharSequence) str2, (CharSequence) "douyinpic", true)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean looksLikeImageUrl(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (isDirectImage(str)) {
            return true;
        }
        String str2 = lowerCase;
        return StringsKt.contains$default((CharSequence) str2, (CharSequence) "image", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "photo", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str2, (CharSequence) "douyinpic", false, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File downloadDirectFile(String str, File file, String str2, String str3, ImageFormatChoice imageFormatChoice, Function1<? super String, Unit> function1) throws IOException {
        String str4;
        String strSubstringAfterLast;
        String strTake;
        Bitmap.CompressFormat compressFormat;
        URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
        Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        httpURLConnection.setRequestProperty("Referer", "https://www.douyin.com/");
        if (!StringsKt.isBlank(str3)) {
            httpURLConnection.setRequestProperty("Cookie", str3);
        }
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = "";
        }
        long contentLengthLong = httpURLConnection.getContentLengthLong();
        if (Intrinsics.areEqual(str2, "video") && (StringsKt.startsWith$default(contentType, "text/", false, 2, (Object) null) || (1 <= contentLengthLong && contentLengthLong < 700001))) {
            throw new IllegalStateException(("Video URL did not return a full video (type=" + contentType + ", size=" + contentLengthLong + "). Try Video downloader mode or add cookies.").toString());
        }
        if (StringsKt.startsWith$default(str2, "image", false, 2, (Object) null) && imageFormatChoice != ImageFormatChoice.Auto) {
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                InputStream inputStream2 = inputStream;
                Intrinsics.checkNotNull(inputStream2);
                byte[] bytes = ByteStreamsKt.readBytes(inputStream2);
                CloseableKt.closeFinally(inputStream, null);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                if (bitmapDecodeByteArray == null) {
                    throw new IllegalStateException("Image conversion failed. Downloaded file is not a supported image.".toString());
                }
                File file2 = new File(file, str2 + "-" + new SimpleDateFormat("yyyyMMdd-HHmmss-SSS", Locale.US).format(new Date()) + "." + imageFormatChoice.getExtension());
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    FileOutputStream fileOutputStream2 = fileOutputStream;
                    int i = WhenMappings.$EnumSwitchMapping$2[imageFormatChoice.ordinal()];
                    if (i == 1) {
                        compressFormat = Bitmap.CompressFormat.PNG;
                    } else if (i == 2) {
                        compressFormat = Bitmap.CompressFormat.JPEG;
                    } else if (i == 3) {
                        compressFormat = Build.VERSION.SDK_INT >= 30 ? Bitmap.CompressFormat.WEBP_LOSSLESS : Bitmap.CompressFormat.WEBP;
                    } else {
                        if (i != 4) {
                            throw new NoWhenBranchMatchedException();
                        }
                        compressFormat = Bitmap.CompressFormat.JPEG;
                    }
                    bitmapDecodeByteArray.compress(compressFormat, 95, fileOutputStream2);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    function1.invoke("Saved " + imageFormatChoice.getLabel());
                    return file2;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(inputStream, th3);
                    throw th4;
                }
            }
        }
        if (Intrinsics.areEqual(str2, "video")) {
            str4 = "mp4";
        } else {
            str4 = Intrinsics.areEqual(str2, "audio") ? "mp3" : "jpg";
        }
        String path = Uri.parse(str).getPath();
        if (path != null && (strSubstringAfterLast = StringsKt.substringAfterLast(path, FilenameUtils.EXTENSION_SEPARATOR, str4)) != null && (strTake = StringsKt.take(strSubstringAfterLast, 5)) != null) {
            String str5 = strTake;
            if (!StringsKt.isBlank(str5)) {
                str4 = str5;
            }
            str4 = str4;
        }
        File file3 = new File(file, str2 + "-" + new SimpleDateFormat("yyyyMMdd-HHmmss-SSS", Locale.US).format(new Date()) + "." + str4);
        InputStream inputStream3 = httpURLConnection.getInputStream();
        try {
            InputStream inputStream4 = inputStream3;
            FileOutputStream fileOutputStream3 = new FileOutputStream(file3);
            try {
                FileOutputStream fileOutputStream4 = fileOutputStream3;
                byte[] bArr = new byte[65536];
                long j = 0;
                while (true) {
                    int i2 = inputStream4.read(bArr);
                    if (i2 > 0) {
                        fileOutputStream4.write(bArr, 0, i2);
                        j += (long) i2;
                        function1.invoke("Downloaded " + (j / ((long) 1024)) + " KB");
                    } else {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream3, null);
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(inputStream3, null);
                        return file3;
                    }
                    try {
                        throw th;
                    } catch (Throwable th5) {
                        CloseableKt.closeFinally(inputStream3, th);
                        throw th5;
                    }
                }
            } catch (Throwable th6) {
                try {
                    throw th6;
                } catch (Throwable th7) {
                    CloseableKt.closeFinally(fileOutputStream3, th6);
                    throw th7;
                }
            }
        } catch (Throwable th8) {
            throw th8;
        }
    }
}
