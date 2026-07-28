package com.yvii.douyindownloader.ui.main;

import androidx.compose.ui.tooling.preview.AndroidUiModes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: MainScreenViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/example/douyinvideodownloader/ui/main/MainScreenUiState;", "it", ""}, k = 3, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
@DebugMetadata(c = "com.yvii.douyindownloader.ui.main.MainScreenViewModel$uiState$4", f = "MainScreenViewModel.kt", i = {0, 0}, l = {17}, m = "invokeSuspend", n = {"$this$catch", "it"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
final class MainScreenViewModel$uiState$4 extends SuspendLambda implements Function3<FlowCollector<? super MainScreenUiState>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    MainScreenViewModel$uiState$4(Continuation<? super MainScreenViewModel$uiState$4> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super MainScreenUiState> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        MainScreenViewModel$uiState$4 mainScreenViewModel$uiState$4 = new MainScreenViewModel$uiState$4(continuation);
        mainScreenViewModel$uiState$4.L$0 = flowCollector;
        mainScreenViewModel$uiState$4.L$1 = th;
        return mainScreenViewModel$uiState$4.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.L$0;
        Throwable th = (Throwable) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.L$1 = SpillingKt.nullOutSpilledVariable(th);
            this.label = 1;
            if (flowCollector.emit(new MainScreenUiState.Error(th), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
