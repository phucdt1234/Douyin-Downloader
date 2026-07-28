package com.yvii.douyindownloader;

import androidx.compose.ui.tooling.preview.AndroidUiModes;
import androidx.navigation3.runtime.NavKey;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* JADX INFO: compiled from: NavigationKeys.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004¨\u0006\u000e"}, d2 = {"Lcom/example/douyinvideodownloader/Main;", "Landroidx/navigation3/runtime/NavKey;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "app"}, k = 1, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
@Serializable
public final /* data */ class Main implements NavKey {
    public static final int $stable = 0;
    public static final Main INSTANCE = new Main();
    private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.yvii.douyindownloader.Main$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Main._init_$_anonymous_();
        }
    });

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Main)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return -2020255364;
    }

    public String toString() {
        return "Main";
    }

    private Main() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new ObjectSerializer("com.yvii.douyindownloader.Main", INSTANCE, new Annotation[0]);
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return $cachedSerializer$delegate.getValue();
    }

    public final KSerializer<Main> serializer() {
        return get$cachedSerializer();
    }
}
