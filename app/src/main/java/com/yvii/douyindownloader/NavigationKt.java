package com.yvii.douyindownloader;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.tooling.preview.AndroidUiModes;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.PointerIconCompat;
import androidx.navigation3.runtime.EntryProviderScope;
import androidx.navigation3.runtime.NavBackStack;
import androidx.navigation3.runtime.NavEntryKt;
import androidx.navigation3.runtime.NavKey;
import androidx.navigation3.runtime.RememberNavBackStackKt;
import androidx.navigation3.ui.NavDisplayKt;
import com.yvii.douyindownloader.ui.main.MainScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: Navigation.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"MainNavigation", "", "(Landroidx/compose/runtime/Composer;I)V", "app"}, k = 2, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
public final class NavigationKt {
    static final Unit MainNavigation$lambda$2(int i, Composer composer, int i2) {
        MainNavigation(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void MainNavigation(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1927859002);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MainNavigation)14@531L26,18@613L32,16@561L301:Navigation.kt#tgtg9h");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1927859002, i, -1, "com.yvii.douyindownloader.MainNavigation (Navigation.kt:13)");
            }
            final NavBackStack<NavKey> navBackStackRememberNavBackStack = RememberNavBackStackKt.rememberNavBackStack(new NavKey[]{Main.INSTANCE}, composerStartRestartGroup, 0);
            NavBackStack<NavKey> navBackStack = navBackStackRememberNavBackStack;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1541592378, "CC(remember):Navigation.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(navBackStackRememberNavBackStack);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.yvii.douyindownloader.NavigationKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationKt.MainNavigation$lambda$0$0(navBackStackRememberNavBackStack);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(-1541590306);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*21@709L140");
            EntryProviderScope entryProviderScope = new EntryProviderScope(new Function1() { // from class: com.yvii.douyindownloader.NavigationKt$MainNavigation$$inlined$entryProvider$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke((NavKey) obj);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(NavKey navKey) {
                    throw new IllegalStateException("Unknown screen " + navKey);
                }
            });
            entryProviderScope.addEntryProvider(Reflection.getOrCreateKotlinClass(Main.class), (Function1) new Function1<Main, Object>() { // from class: com.yvii.douyindownloader.NavigationKt$MainNavigation$lambda$1$$inlined$entry$default$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Main main) {
                    return NavEntryKt.defaultContentKey(main);
                }
            }, MapsKt.emptyMap(), (Function3) ComposableLambdaKt.rememberComposableLambda(-318203818, true, new Function3() { // from class: com.yvii.douyindownloader.NavigationKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NavigationKt.MainNavigation$lambda$1$0(navBackStackRememberNavBackStack, (Main) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54));
            Unit unit = Unit.INSTANCE;
            Function1 function1Build = entryProviderScope.build();
            composerStartRestartGroup.endReplaceGroup();
            NavDisplayKt.NavDisplay(navBackStack, null, null, (Function0) objRememberedValue, null, null, null, null, null, null, function1Build, composerStartRestartGroup, NavBackStack.$stable, 0, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.NavigationKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationKt.MainNavigation$lambda$2(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainNavigation$lambda$0$0(NavBackStack navBackStack) {
        CollectionsKt.removeLastOrNull(navBackStack);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainNavigation$lambda$1$0(final NavBackStack navBackStack, Main it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)22@746L35,22@721L118:Navigation.kt#tgtg9h");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-318203818, i, -1, "com.yvii.douyindownloader.MainNavigation.<anonymous>.<anonymous> (Navigation.kt:22)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -851189863, "CC(remember):Navigation.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(navBackStack);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.yvii.douyindownloader.NavigationKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationKt.MainNavigation$lambda$1$0$0$0(navBackStack, (NavKey) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            MainScreenKt.MainScreen((Function1) objRememberedValue, PaddingKt.m819padding3ABfNKs(WindowInsetsPadding_androidKt.safeDrawingPadding(Modifier.INSTANCE), Dp.m7521constructorimpl(16)), null, composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainNavigation$lambda$1$0$0$0(NavBackStack navBackStack, NavKey navKey) {
        Intrinsics.checkNotNullParameter(navKey, "navKey");
        navBackStack.add(navKey);
        return Unit.INSTANCE;
    }
}
