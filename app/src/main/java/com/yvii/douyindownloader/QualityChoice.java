package com.yvii.douyindownloader;

import androidx.compose.ui.tooling.preview.AndroidUiModes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/example/douyinvideodownloader/QualityChoice;", "", "label", "", "ytdlpFormat", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getYtdlpFormat", "Best", "Medium", "Small", "app"}, k = 1, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
public enum QualityChoice {
    Best("Best", "bestvideo*+bestaudio/best"),
    Medium("Medium", "bv*[height<=720]+ba/b[height<=720]/best"),
    Small("Small", "bv*[height<=480]+ba/b[height<=480]/best");

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final String label;
    private final String ytdlpFormat;

    public static EnumEntries<QualityChoice> getEntries() {
        return $ENTRIES;
    }

    QualityChoice(String str, String str2) {
        this.label = str;
        this.ytdlpFormat = str2;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getYtdlpFormat() {
        return this.ytdlpFormat;
    }
}
