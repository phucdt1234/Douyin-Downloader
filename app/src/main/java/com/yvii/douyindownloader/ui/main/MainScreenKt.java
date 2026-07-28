package com.yvii.douyindownloader.ui.main;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.tooling.preview.AndroidUiModes;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation3.runtime.NavKey;
import com.yvii.douyindownloader.data.DefaultDataRepository;
import com.yvii.douyindownloader.theme.ThemeKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: MainScreen.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\u001a5\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a%\u0010\u0000\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002"}, d2 = {"MainScreen", "", "onItemClick", "Lkotlin/Function1;", "Landroidx/navigation3/runtime/NavKey;", "modifier", "Landroidx/compose/ui/Modifier;", "viewModel", "Lcom/example/douyinvideodownloader/ui/main/MainScreenViewModel;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lcom/example/douyinvideodownloader/ui/main/MainScreenViewModel;Landroidx/compose/runtime/Composer;II)V", "data", "", "", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Greeting", HintConstants.AUTOFILL_HINT_NAME, "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MainScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "MainScreenPortraitPreview", "app", "state", "Lcom/example/douyinvideodownloader/ui/main/MainScreenUiState;"}, k = 2, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
public final class MainScreenKt {
    static final Unit Greeting$lambda$0(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Greeting(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit MainScreen$lambda$2(Function1 function1, Modifier modifier, MainScreenViewModel mainScreenViewModel, int i, int i2, Composer composer, int i3) {
        MainScreen(function1, modifier, mainScreenViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit MainScreen$lambda$4(List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        MainScreen(list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    static final Unit MainScreenPortraitPreview$lambda$0(int i, Composer composer, int i2) {
        MainScreenPortraitPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    static final Unit MainScreenPreview$lambda$0(int i, Composer composer, int i2) {
        MainScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MainScreenViewModel MainScreen$lambda$0$0(CreationExtras viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "$this$viewModel");
        return new MainScreenViewModel(new DefaultDataRepository());
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0110  */
    /* JADX WARN: Code duplicated, block: B:62:0x0134  */
    /* JADX WARN: Code duplicated, block: B:63:0x013f  */
    /* JADX WARN: Code duplicated, block: B:65:0x0143  */
    /* JADX WARN: Code duplicated, block: B:66:0x0166  */
    /* JADX WARN: Code duplicated, block: B:68:0x016a  */
    /* JADX WARN: Code duplicated, block: B:71:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:72:0x01cf  */
    public static final void MainScreen(final Function1<? super NavKey, Unit> onItemClick, Modifier modifier, MainScreenViewModel mainScreenViewModel, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        MainScreenViewModel mainScreenViewModel2;
        final Modifier.Companion companion;
        final MainScreenViewModel mainScreenViewModel3;
        CreationExtras.Empty defaultViewModelCreationExtras;
        State stateCollectAsStateWithLifecycle;
        MainScreenUiState mainScreenUiStateMainScreen$lambda$1;
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1094722069);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MainScreen)N(onItemClick,modifier,viewModel)20@838L29:MainScreen.kt#kwo028");
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 = i | 48;
            modifier2 = modifier;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 32 : 16) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                mainScreenViewModel2 = mainScreenViewModel;
                int i5 = composerStartRestartGroup.changedInstance(mainScreenViewModel2) ? 256 : 128;
                i3 |= i5;
            } else {
                mainScreenViewModel2 = mainScreenViewModel;
            }
            i3 |= i5;
        } else {
            mainScreenViewModel2 = mainScreenViewModel;
        }
        int i6 = i3;
        if (composerStartRestartGroup.shouldExecute((i6 & 145) != 144, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "18@751L48,18@741L58");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i6 &= -897;
                }
                companion = modifier2;
            } else {
                companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 4) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -239075099, "CC(remember):MainScreen.kt#9igjgp");
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.yvii.douyindownloader.ui.main.MainScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MainScreenKt.MainScreen$lambda$0$0((CreationExtras) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function1 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 419377738, "CC(viewModel)N(viewModelStoreOwner,key,initializer)127@5935L7,133@6124L329:ViewModel.kt#3tja67");
                    ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current == null) {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
                    }
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MainScreenViewModel.class);
                    InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
                    initializerViewModelFactoryBuilder.addInitializer(Reflection.getOrCreateKotlinClass(MainScreenViewModel.class), function1);
                    ViewModelProvider.Factory factoryBuild = initializerViewModelFactoryBuilder.build();
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    ViewModel viewModel = ViewModelKt.viewModel((KClass<ViewModel>) orCreateKotlinClass, current, (String) null, factoryBuild, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    mainScreenViewModel3 = (MainScreenViewModel) viewModel;
                    i6 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1094722069, i6, -1, "com.yvii.douyindownloader.ui.main.MainScreen (MainScreen.kt:19)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(mainScreenViewModel3.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                composerStartRestartGroup = composerStartRestartGroup;
                mainScreenUiStateMainScreen$lambda$1 = MainScreen$lambda$1(stateCollectAsStateWithLifecycle);
                if (Intrinsics.areEqual(mainScreenUiStateMainScreen$lambda$1, MainScreenUiState.Loading.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(1178771383);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (mainScreenUiStateMainScreen$lambda$1 instanceof MainScreenUiState.Success) {
                    composerStartRestartGroup.startReplaceGroup(1178832174);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "26@985L81");
                    MainScreenUiState mainScreenUiStateMainScreen$lambda$2 = MainScreen$lambda$1(stateCollectAsStateWithLifecycle);
                    Intrinsics.checkNotNull(mainScreenUiStateMainScreen$lambda$2, "null cannot be cast to non-null type com.yvii.douyindownloader.ui.main.MainScreenUiState.Success");
                    MainScreen(((MainScreenUiState.Success) mainScreenUiStateMainScreen$lambda$2).getData(), companion, composerStartRestartGroup, i6 & 112, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (mainScreenUiStateMainScreen$lambda$1 instanceof MainScreenUiState.Error) {
                    composerStartRestartGroup.startReplaceGroup(1178961196);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "29@1115L83");
                    MainScreenUiState mainScreenUiStateMainScreen$lambda$3 = MainScreen$lambda$1(stateCollectAsStateWithLifecycle);
                    Intrinsics.checkNotNull(mainScreenUiStateMainScreen$lambda$3, "null cannot be cast to non-null type com.yvii.douyindownloader.ui.main.MainScreenUiState.Error");
                    TextKt.m2713TextNvy7gAk("Error loading data: " + ((MainScreenUiState.Error) mainScreenUiStateMainScreen$lambda$3).getThrowable().getMessage(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 0, 0, 262142);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-239071001);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            mainScreenViewModel3 = mainScreenViewModel2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1094722069, i6, -1, "com.yvii.douyindownloader.ui.main.MainScreen (MainScreen.kt:19)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(mainScreenViewModel3.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            composerStartRestartGroup = composerStartRestartGroup;
            mainScreenUiStateMainScreen$lambda$1 = MainScreen$lambda$1(stateCollectAsStateWithLifecycle);
            if (Intrinsics.areEqual(mainScreenUiStateMainScreen$lambda$1, MainScreenUiState.Loading.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(1178771383);
                composerStartRestartGroup.endReplaceGroup();
            } else if (mainScreenUiStateMainScreen$lambda$1 instanceof MainScreenUiState.Success) {
                composerStartRestartGroup.startReplaceGroup(1178832174);
                ComposerKt.sourceInformation(composerStartRestartGroup, "26@985L81");
                MainScreenUiState mainScreenUiStateMainScreen$lambda$4 = MainScreen$lambda$1(stateCollectAsStateWithLifecycle);
                Intrinsics.checkNotNull(mainScreenUiStateMainScreen$lambda$4, "null cannot be cast to non-null type com.yvii.douyindownloader.ui.main.MainScreenUiState.Success");
                MainScreen(((MainScreenUiState.Success) mainScreenUiStateMainScreen$lambda$4).getData(), companion, composerStartRestartGroup, i6 & 112, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (mainScreenUiStateMainScreen$lambda$1 instanceof MainScreenUiState.Error) {
                composerStartRestartGroup.startReplaceGroup(1178961196);
                ComposerKt.sourceInformation(composerStartRestartGroup, "29@1115L83");
                MainScreenUiState mainScreenUiStateMainScreen$lambda$5 = MainScreen$lambda$1(stateCollectAsStateWithLifecycle);
                Intrinsics.checkNotNull(mainScreenUiStateMainScreen$lambda$5, "null cannot be cast to non-null type com.yvii.douyindownloader.ui.main.MainScreenUiState.Error");
                TextKt.m2713TextNvy7gAk("Error loading data: " + ((MainScreenUiState.Error) mainScreenUiStateMainScreen$lambda$5).getThrowable().getMessage(), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 0, 0, 262142);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-239071001);
                composerStartRestartGroup.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            mainScreenViewModel3 = mainScreenViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.ui.main.MainScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainScreenKt.MainScreen$lambda$2(onItemClick, companion, mainScreenViewModel3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void MainScreen(final List<String> data, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer composerStartRestartGroup = composer.startRestartGroup(467833139);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MainScreen)N(data,modifier)36@1303L50:MainScreen.kt#kwo028");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(data) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(467833139, i3, -1, "com.yvii.douyindownloader.ui.main.MainScreen (MainScreen.kt:35)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier);
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
            Updater.m4016setimpl(composerM4008constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m4016setimpl(composerM4008constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m4012initimpl(composerM4008constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m4014reconcileimpl(composerM4008constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m4016setimpl(composerM4008constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1563169193, "C:MainScreen.kt#kwo028");
            composerStartRestartGroup.startReplaceGroup(1574445621);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*36@1337L12");
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                Greeting((String) it.next(), null, composerStartRestartGroup, 0, 2);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.ui.main.MainScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainScreenKt.MainScreen$lambda$4(data, modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:24:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x00af  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    public static final void Greeting(final String name, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(name, "name");
        Composer composerStartRestartGroup = composer.startRestartGroup(547432404);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Greeting)N(name,modifier)41@1431L48:MainScreen.kt#kwo028");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(name) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(547432404, i3, -1, "com.yvii.douyindownloader.ui.main.Greeting (MainScreen.kt:40)");
                }
                int i5 = i3 & 112;
                modifier3 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m2713TextNvy7gAk("Hello " + name + "!", modifier3, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, i5, 0, 262140);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.ui.main.MainScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainScreenKt.Greeting$lambda$0(name, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(547432404, i3, -1, "com.yvii.douyindownloader.ui.main.Greeting (MainScreen.kt:40)");
            }
            int i6 = i3 & 112;
            modifier3 = companion;
            composer2 = composerStartRestartGroup;
            TextKt.m2713TextNvy7gAk("Hello " + name + "!", modifier3, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, i6, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.ui.main.MainScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainScreenKt.Greeting$lambda$0(name, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void MainScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1832163766);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MainScreenPreview)47@1555L60:MainScreen.kt#kwo028");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1832163766, i, -1, "com.yvii.douyindownloader.ui.main.MainScreenPreview (MainScreen.kt:46)");
            }
            ThemeKt.DouyinVideoDownloaderTheme(false, false, ComposableSingletons$MainScreenKt.INSTANCE.getLambda$1371782426$app(), composerStartRestartGroup, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.ui.main.MainScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainScreenKt.MainScreenPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void MainScreenPortraitPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1547475761);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MainScreenPortraitPreview)53@1714L60:MainScreen.kt#kwo028");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1547475761, i, -1, "com.yvii.douyindownloader.ui.main.MainScreenPortraitPreview (MainScreen.kt:52)");
            }
            ThemeKt.DouyinVideoDownloaderTheme(false, false, ComposableSingletons$MainScreenKt.INSTANCE.m8043getLambda$2018239851$app(), composerStartRestartGroup, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.yvii.douyindownloader.ui.main.MainScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainScreenKt.MainScreenPortraitPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final MainScreenUiState MainScreen$lambda$1(State<? extends MainScreenUiState> state) {
        return state.getValue();
    }
}
