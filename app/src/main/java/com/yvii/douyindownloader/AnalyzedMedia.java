package com.yvii.douyindownloader;

import androidx.compose.ui.tooling.preview.AndroidUiModes;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/example/douyinvideodownloader/AnalyzedMedia;", "", "title", "", "sourceUrl", "videoUrl", "audioUrl", "images", "", "Lcom/example/douyinvideodownloader/MediaItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getSourceUrl", "getVideoUrl", "getAudioUrl", "getImages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
public final /* data */ class AnalyzedMedia {
    public static final int $stable = 8;
    private final String audioUrl;
    private final List<MediaItem> images;
    private final String sourceUrl;
    private final String title;
    private final String videoUrl;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnalyzedMedia copy$default(AnalyzedMedia analyzedMedia, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = analyzedMedia.title;
        }
        if ((i & 2) != 0) {
            str2 = analyzedMedia.sourceUrl;
        }
        if ((i & 4) != 0) {
            str3 = analyzedMedia.videoUrl;
        }
        if ((i & 8) != 0) {
            str4 = analyzedMedia.audioUrl;
        }
        if ((i & 16) != 0) {
            list = analyzedMedia.images;
        }
        List list2 = list;
        String str5 = str3;
        return analyzedMedia.copy(str, str2, str5, str4, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAudioUrl() {
        return this.audioUrl;
    }

    public final List<MediaItem> component5() {
        return this.images;
    }

    public final AnalyzedMedia copy(String title, String sourceUrl, String videoUrl, String audioUrl, List<MediaItem> images) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        Intrinsics.checkNotNullParameter(images, "images");
        return new AnalyzedMedia(title, sourceUrl, videoUrl, audioUrl, images);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnalyzedMedia)) {
            return false;
        }
        AnalyzedMedia analyzedMedia = (AnalyzedMedia) other;
        return Intrinsics.areEqual(this.title, analyzedMedia.title) && Intrinsics.areEqual(this.sourceUrl, analyzedMedia.sourceUrl) && Intrinsics.areEqual(this.videoUrl, analyzedMedia.videoUrl) && Intrinsics.areEqual(this.audioUrl, analyzedMedia.audioUrl) && Intrinsics.areEqual(this.images, analyzedMedia.images);
    }

    public int hashCode() {
        int iHashCode = ((this.title.hashCode() * 31) + this.sourceUrl.hashCode()) * 31;
        String str = this.videoUrl;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.audioUrl;
        return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.images.hashCode();
    }

    public String toString() {
        return "AnalyzedMedia(title=" + this.title + ", sourceUrl=" + this.sourceUrl + ", videoUrl=" + this.videoUrl + ", audioUrl=" + this.audioUrl + ", images=" + this.images + ")";
    }

    public AnalyzedMedia(String title, String sourceUrl, String str, String str2, List<MediaItem> images) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        Intrinsics.checkNotNullParameter(images, "images");
        this.title = title;
        this.sourceUrl = sourceUrl;
        this.videoUrl = str;
        this.audioUrl = str2;
        this.images = images;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSourceUrl() {
        return this.sourceUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final String getAudioUrl() {
        return this.audioUrl;
    }

    public final List<MediaItem> getImages() {
        return this.images;
    }
}
