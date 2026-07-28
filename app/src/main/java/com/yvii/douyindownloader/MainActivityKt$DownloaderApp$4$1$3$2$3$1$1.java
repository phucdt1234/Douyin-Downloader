package com.yvii.douyindownloader;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.tooling.preview.AndroidUiModes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
@DebugMetadata(c = "com.yvii.douyindownloader.MainActivityKt$DownloaderApp$4$1$3$2$3$1$1", f = "MainActivity.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {292, 301}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-MainActivityKt$DownloaderApp$4$1$3$2$3$1$1$1", "$this$launch", "$this$invokeSuspend_u24lambda_u240", "current", "$i$a$-runCatching-MainActivityKt$DownloaderApp$4$1$3$2$3$1$1$1"}, nl = {291, 303}, s = {"L$0", "L$8", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
final class MainActivityKt$DownloaderApp$4$1$3$2$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<AnalyzedMedia> $analyzed$delegate;
    final /* synthetic */ MutableState<Boolean> $busy$delegate;
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableState<String> $log$delegate;
    final /* synthetic */ MutableState<DownloadMode> $mode$delegate;
    final /* synthetic */ SnapshotStateList<String> $selectedImages;
    final /* synthetic */ DownloadSettings $settings;
    final /* synthetic */ MutableState<String> $status$delegate;
    final /* synthetic */ String $url;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivityKt$DownloaderApp$4$1$3$2$3$1$1(Context context, String str, DownloadSettings downloadSettings, SnapshotStateList<String> snapshotStateList, MutableState<AnalyzedMedia> mutableState, MutableState<DownloadMode> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<Boolean> mutableState5, Continuation<? super MainActivityKt$DownloaderApp$4$1$3$2$3$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$url = str;
        this.$settings = downloadSettings;
        this.$selectedImages = snapshotStateList;
        this.$analyzed$delegate = mutableState;
        this.$mode$delegate = mutableState2;
        this.$status$delegate = mutableState3;
        this.$log$delegate = mutableState4;
        this.$busy$delegate = mutableState5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainActivityKt$DownloaderApp$4$1$3$2$3$1$1 mainActivityKt$DownloaderApp$4$1$3$2$3$1$1 = new MainActivityKt$DownloaderApp$4$1$3$2$3$1$1(this.$context, this.$url, this.$settings, this.$selectedImages, this.$analyzed$delegate, this.$mode$delegate, this.$status$delegate, this.$log$delegate, this.$busy$delegate, continuation);
        mainActivityKt$DownloaderApp$4$1$3$2$3$1$1.L$0 = obj;
        return mainActivityKt$DownloaderApp$4$1$3$2$3$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$DownloaderApp$4$1$3$2$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:54:0x01bc  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0164, code lost:
    
        if (r0 == r7) goto L37;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yvii.douyindownloader.MainActivityKt$DownloaderApp$4$1$3$2$3$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(MutableState mutableState, String str) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$2(MutableState mutableState, String str) {
        mutableState.setValue("Downloading: " + StringsKt.take(str, 80));
        return Unit.INSTANCE;
    }
}
