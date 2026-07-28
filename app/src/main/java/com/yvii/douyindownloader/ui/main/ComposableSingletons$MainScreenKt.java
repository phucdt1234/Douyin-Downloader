package com.yvii.douyindownloader.ui.main;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.tooling.preview.AndroidUiModes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MainScreen.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
public final class ComposableSingletons$MainScreenKt {
    public static final ComposableSingletons$MainScreenKt INSTANCE = new ComposableSingletons$MainScreenKt();
    private static Function2<Composer, Integer, Unit> lambda$1371782426 = ComposableLambdaKt.composableLambdaInstance(1371782426, false, new Function2() { // from class: com.yvii.douyindownloader.ui.main.ComposableSingletons$MainScreenKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainScreenKt.lambda_1371782426$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: lambda$-2018239851, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f131lambda$2018239851 = ComposableLambdaKt.composableLambdaInstance(-2018239851, false, new Function2() { // from class: com.yvii.douyindownloader.ui.main.ComposableSingletons$MainScreenKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainScreenKt.lambda__2018239851$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: getLambda$-2018239851$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m8043getLambda$2018239851$app() {
        return f131lambda$2018239851;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1371782426$app() {
        return lambda$1371782426;
    }

    static final Unit lambda_1371782426$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C47@1584L29:MainScreen.kt#kwo028");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1371782426, i, -1, "com.yvii.douyindownloader.ui.main.ComposableSingletons$MainScreenKt.lambda$1371782426.<anonymous> (MainScreen.kt:47)");
            }
            MainScreenKt.MainScreen(CollectionsKt.listOf("Android"), null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__2018239851$lambda$0(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C53@1743L29:MainScreen.kt#kwo028");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2018239851, i, -1, "com.yvii.douyindownloader.ui.main.ComposableSingletons$MainScreenKt.lambda$-2018239851.<anonymous> (MainScreen.kt:53)");
            }
            MainScreenKt.MainScreen(CollectionsKt.listOf("Android"), null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
