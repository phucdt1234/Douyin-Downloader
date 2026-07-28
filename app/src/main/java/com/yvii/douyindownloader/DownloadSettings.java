package com.yvii.douyindownloader;

import androidx.compose.ui.tooling.preview.AndroidUiModes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J\u008b\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000eHÆ\u0001J\u0014\u00108\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010:\u001a\u00020;HÖ\u0081\u0004J\n\u0010<\u001a\u00020\u000eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#¨\u0006="}, d2 = {"Lcom/example/douyinvideodownloader/DownloadSettings;", "", "mediaChoice", "Lcom/example/douyinvideodownloader/MediaChoice;", "quality", "Lcom/example/douyinvideodownloader/QualityChoice;", "fileType", "Lcom/example/douyinvideodownloader/FileTypeChoice;", "imageFormat", "Lcom/example/douyinvideodownloader/ImageFormatChoice;", "updateYtDlp", "", "includeThumbnail", "cookies", "", "cobaltApi", "cobaltDownloadMode", "cobaltVideoQuality", "cobaltAudioFormat", "cobaltAudioBitrate", "cobaltAuthorization", "<init>", "(Lcom/example/douyinvideodownloader/MediaChoice;Lcom/example/douyinvideodownloader/QualityChoice;Lcom/example/douyinvideodownloader/FileTypeChoice;Lcom/example/douyinvideodownloader/ImageFormatChoice;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMediaChoice", "()Lcom/example/douyinvideodownloader/MediaChoice;", "getQuality", "()Lcom/example/douyinvideodownloader/QualityChoice;", "getFileType", "()Lcom/example/douyinvideodownloader/FileTypeChoice;", "getImageFormat", "()Lcom/example/douyinvideodownloader/ImageFormatChoice;", "getUpdateYtDlp", "()Z", "getIncludeThumbnail", "getCookies", "()Ljava/lang/String;", "getCobaltApi", "getCobaltDownloadMode", "getCobaltVideoQuality", "getCobaltAudioFormat", "getCobaltAudioBitrate", "getCobaltAuthorization", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
public final /* data */ class DownloadSettings {
    public static final int $stable = 0;
    private final String cobaltApi;
    private final String cobaltAudioBitrate;
    private final String cobaltAudioFormat;
    private final String cobaltAuthorization;
    private final String cobaltDownloadMode;
    private final String cobaltVideoQuality;
    private final String cookies;
    private final FileTypeChoice fileType;
    private final ImageFormatChoice imageFormat;
    private final boolean includeThumbnail;
    private final MediaChoice mediaChoice;
    private final QualityChoice quality;
    private final boolean updateYtDlp;

    public DownloadSettings() {
        this(null, null, null, null, false, false, null, null, null, null, null, null, null, 8191, null);
    }

    public static /* synthetic */ DownloadSettings copy$default(DownloadSettings downloadSettings, MediaChoice mediaChoice, QualityChoice qualityChoice, FileTypeChoice fileTypeChoice, ImageFormatChoice imageFormatChoice, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            mediaChoice = downloadSettings.mediaChoice;
        }
        return downloadSettings.copy(mediaChoice, (i & 2) != 0 ? downloadSettings.quality : qualityChoice, (i & 4) != 0 ? downloadSettings.fileType : fileTypeChoice, (i & 8) != 0 ? downloadSettings.imageFormat : imageFormatChoice, (i & 16) != 0 ? downloadSettings.updateYtDlp : z, (i & 32) != 0 ? downloadSettings.includeThumbnail : z2, (i & 64) != 0 ? downloadSettings.cookies : str, (i & 128) != 0 ? downloadSettings.cobaltApi : str2, (i & 256) != 0 ? downloadSettings.cobaltDownloadMode : str3, (i & 512) != 0 ? downloadSettings.cobaltVideoQuality : str4, (i & 1024) != 0 ? downloadSettings.cobaltAudioFormat : str5, (i & 2048) != 0 ? downloadSettings.cobaltAudioBitrate : str6, (i & 4096) != 0 ? downloadSettings.cobaltAuthorization : str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MediaChoice getMediaChoice() {
        return this.mediaChoice;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCobaltVideoQuality() {
        return this.cobaltVideoQuality;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getCobaltAudioFormat() {
        return this.cobaltAudioFormat;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCobaltAudioBitrate() {
        return this.cobaltAudioBitrate;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getCobaltAuthorization() {
        return this.cobaltAuthorization;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final QualityChoice getQuality() {
        return this.quality;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final FileTypeChoice getFileType() {
        return this.fileType;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ImageFormatChoice getImageFormat() {
        return this.imageFormat;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getUpdateYtDlp() {
        return this.updateYtDlp;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIncludeThumbnail() {
        return this.includeThumbnail;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCookies() {
        return this.cookies;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCobaltApi() {
        return this.cobaltApi;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCobaltDownloadMode() {
        return this.cobaltDownloadMode;
    }

    public final DownloadSettings copy(MediaChoice mediaChoice, QualityChoice quality, FileTypeChoice fileType, ImageFormatChoice imageFormat, boolean updateYtDlp, boolean includeThumbnail, String cookies, String cobaltApi, String cobaltDownloadMode, String cobaltVideoQuality, String cobaltAudioFormat, String cobaltAudioBitrate, String cobaltAuthorization) {
        Intrinsics.checkNotNullParameter(mediaChoice, "mediaChoice");
        Intrinsics.checkNotNullParameter(quality, "quality");
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Intrinsics.checkNotNullParameter(cobaltApi, "cobaltApi");
        Intrinsics.checkNotNullParameter(cobaltDownloadMode, "cobaltDownloadMode");
        Intrinsics.checkNotNullParameter(cobaltVideoQuality, "cobaltVideoQuality");
        Intrinsics.checkNotNullParameter(cobaltAudioFormat, "cobaltAudioFormat");
        Intrinsics.checkNotNullParameter(cobaltAudioBitrate, "cobaltAudioBitrate");
        Intrinsics.checkNotNullParameter(cobaltAuthorization, "cobaltAuthorization");
        return new DownloadSettings(mediaChoice, quality, fileType, imageFormat, updateYtDlp, includeThumbnail, cookies, cobaltApi, cobaltDownloadMode, cobaltVideoQuality, cobaltAudioFormat, cobaltAudioBitrate, cobaltAuthorization);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadSettings)) {
            return false;
        }
        DownloadSettings downloadSettings = (DownloadSettings) other;
        return this.mediaChoice == downloadSettings.mediaChoice && this.quality == downloadSettings.quality && this.fileType == downloadSettings.fileType && this.imageFormat == downloadSettings.imageFormat && this.updateYtDlp == downloadSettings.updateYtDlp && this.includeThumbnail == downloadSettings.includeThumbnail && Intrinsics.areEqual(this.cookies, downloadSettings.cookies) && Intrinsics.areEqual(this.cobaltApi, downloadSettings.cobaltApi) && Intrinsics.areEqual(this.cobaltDownloadMode, downloadSettings.cobaltDownloadMode) && Intrinsics.areEqual(this.cobaltVideoQuality, downloadSettings.cobaltVideoQuality) && Intrinsics.areEqual(this.cobaltAudioFormat, downloadSettings.cobaltAudioFormat) && Intrinsics.areEqual(this.cobaltAudioBitrate, downloadSettings.cobaltAudioBitrate) && Intrinsics.areEqual(this.cobaltAuthorization, downloadSettings.cobaltAuthorization);
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.mediaChoice.hashCode() * 31) + this.quality.hashCode()) * 31) + this.fileType.hashCode()) * 31) + this.imageFormat.hashCode()) * 31) + Boolean.hashCode(this.updateYtDlp)) * 31) + Boolean.hashCode(this.includeThumbnail)) * 31) + this.cookies.hashCode()) * 31) + this.cobaltApi.hashCode()) * 31) + this.cobaltDownloadMode.hashCode()) * 31) + this.cobaltVideoQuality.hashCode()) * 31) + this.cobaltAudioFormat.hashCode()) * 31) + this.cobaltAudioBitrate.hashCode()) * 31) + this.cobaltAuthorization.hashCode();
    }

    public String toString() {
        return "DownloadSettings(mediaChoice=" + this.mediaChoice + ", quality=" + this.quality + ", fileType=" + this.fileType + ", imageFormat=" + this.imageFormat + ", updateYtDlp=" + this.updateYtDlp + ", includeThumbnail=" + this.includeThumbnail + ", cookies=" + this.cookies + ", cobaltApi=" + this.cobaltApi + ", cobaltDownloadMode=" + this.cobaltDownloadMode + ", cobaltVideoQuality=" + this.cobaltVideoQuality + ", cobaltAudioFormat=" + this.cobaltAudioFormat + ", cobaltAudioBitrate=" + this.cobaltAudioBitrate + ", cobaltAuthorization=" + this.cobaltAuthorization + ")";
    }

    public DownloadSettings(MediaChoice mediaChoice, QualityChoice quality, FileTypeChoice fileType, ImageFormatChoice imageFormat, boolean z, boolean z2, String cookies, String cobaltApi, String cobaltDownloadMode, String cobaltVideoQuality, String cobaltAudioFormat, String cobaltAudioBitrate, String cobaltAuthorization) {
        Intrinsics.checkNotNullParameter(mediaChoice, "mediaChoice");
        Intrinsics.checkNotNullParameter(quality, "quality");
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        Intrinsics.checkNotNullParameter(imageFormat, "imageFormat");
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        Intrinsics.checkNotNullParameter(cobaltApi, "cobaltApi");
        Intrinsics.checkNotNullParameter(cobaltDownloadMode, "cobaltDownloadMode");
        Intrinsics.checkNotNullParameter(cobaltVideoQuality, "cobaltVideoQuality");
        Intrinsics.checkNotNullParameter(cobaltAudioFormat, "cobaltAudioFormat");
        Intrinsics.checkNotNullParameter(cobaltAudioBitrate, "cobaltAudioBitrate");
        Intrinsics.checkNotNullParameter(cobaltAuthorization, "cobaltAuthorization");
        this.mediaChoice = mediaChoice;
        this.quality = quality;
        this.fileType = fileType;
        this.imageFormat = imageFormat;
        this.updateYtDlp = z;
        this.includeThumbnail = z2;
        this.cookies = cookies;
        this.cobaltApi = cobaltApi;
        this.cobaltDownloadMode = cobaltDownloadMode;
        this.cobaltVideoQuality = cobaltVideoQuality;
        this.cobaltAudioFormat = cobaltAudioFormat;
        this.cobaltAudioBitrate = cobaltAudioBitrate;
        this.cobaltAuthorization = cobaltAuthorization;
    }

    public /* synthetic */ DownloadSettings(MediaChoice mediaChoice, QualityChoice qualityChoice, FileTypeChoice fileTypeChoice, ImageFormatChoice imageFormatChoice, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MediaChoice.Auto : mediaChoice, (i & 2) != 0 ? QualityChoice.Best : qualityChoice, (i & 4) != 0 ? FileTypeChoice.Auto : fileTypeChoice, (i & 8) != 0 ? ImageFormatChoice.Auto : imageFormatChoice, (i & 16) != 0 ? true : z, (i & 32) == 0 ? z2 : true, (i & 64) != 0 ? "" : str, (i & 128) != 0 ? "https://api.cobalt.tools" : str2, (i & 256) != 0 ? DebugKt.DEBUG_PROPERTY_VALUE_AUTO : str3, (i & 512) != 0 ? "1080" : str4, (i & 1024) != 0 ? "mp3" : str5, (i & 2048) != 0 ? "128" : str6, (i & 4096) != 0 ? "" : str7);
    }

    public final MediaChoice getMediaChoice() {
        return this.mediaChoice;
    }

    public final QualityChoice getQuality() {
        return this.quality;
    }

    public final FileTypeChoice getFileType() {
        return this.fileType;
    }

    public final ImageFormatChoice getImageFormat() {
        return this.imageFormat;
    }

    public final boolean getUpdateYtDlp() {
        return this.updateYtDlp;
    }

    public final boolean getIncludeThumbnail() {
        return this.includeThumbnail;
    }

    public final String getCookies() {
        return this.cookies;
    }

    public final String getCobaltApi() {
        return this.cobaltApi;
    }

    public final String getCobaltDownloadMode() {
        return this.cobaltDownloadMode;
    }

    public final String getCobaltVideoQuality() {
        return this.cobaltVideoQuality;
    }

    public final String getCobaltAudioFormat() {
        return this.cobaltAudioFormat;
    }

    public final String getCobaltAudioBitrate() {
        return this.cobaltAudioBitrate;
    }

    public final String getCobaltAuthorization() {
        return this.cobaltAuthorization;
    }
}
