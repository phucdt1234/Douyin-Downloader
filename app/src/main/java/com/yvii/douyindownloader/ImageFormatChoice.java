package com.yvii.douyindownloader;

import androidx.compose.ui.tooling.preview.AndroidUiModes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/example/douyinvideodownloader/ImageFormatChoice;", "", "label", "", "extension", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getExtension", "Auto", "Png", "Jpg", "Webp", "app"}, k = 1, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
public enum ImageFormatChoice {
    Auto("Original", null),
    Png("PNG", "png"),
    Jpg("JPG", "jpg"),
    Webp("WebP", "webp");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String extension;
    private final String label;

    public static EnumEntries<ImageFormatChoice> getEntries() {
        return $ENTRIES;
    }

    ImageFormatChoice(String str, String str2) {
        this.label = str;
        this.extension = str2;
    }

    public final String getExtension() {
        return this.extension;
    }

    public final String getLabel() {
        return this.label;
    }
}
