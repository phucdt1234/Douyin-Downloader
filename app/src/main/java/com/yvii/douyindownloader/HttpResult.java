package com.yvii.douyindownloader;

import androidx.compose.ui.tooling.preview.AndroidUiModes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/example/douyinvideodownloader/HttpResult;", "", "finalUrl", "", "body", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getFinalUrl", "()Ljava/lang/String;", "getBody", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
final /* data */ class HttpResult {
    private final String body;
    private final String finalUrl;

    public static /* synthetic */ HttpResult copy$default(HttpResult httpResult, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = httpResult.finalUrl;
        }
        if ((i & 2) != 0) {
            str2 = httpResult.body;
        }
        return httpResult.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFinalUrl() {
        return this.finalUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    public final HttpResult copy(String finalUrl, String body) {
        Intrinsics.checkNotNullParameter(finalUrl, "finalUrl");
        Intrinsics.checkNotNullParameter(body, "body");
        return new HttpResult(finalUrl, body);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpResult)) {
            return false;
        }
        HttpResult httpResult = (HttpResult) other;
        return Intrinsics.areEqual(this.finalUrl, httpResult.finalUrl) && Intrinsics.areEqual(this.body, httpResult.body);
    }

    public int hashCode() {
        return (this.finalUrl.hashCode() * 31) + this.body.hashCode();
    }

    public String toString() {
        return "HttpResult(finalUrl=" + this.finalUrl + ", body=" + this.body + ")";
    }

    public HttpResult(String finalUrl, String body) {
        Intrinsics.checkNotNullParameter(finalUrl, "finalUrl");
        Intrinsics.checkNotNullParameter(body, "body");
        this.finalUrl = finalUrl;
        this.body = body;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getFinalUrl() {
        return this.finalUrl;
    }
}
