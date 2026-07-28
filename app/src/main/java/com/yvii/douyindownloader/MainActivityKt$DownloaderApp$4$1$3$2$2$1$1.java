package com.yvii.douyindownloader;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.tooling.preview.AndroidUiModes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
@DebugMetadata(c = "com.yvii.douyindownloader.MainActivityKt$DownloaderApp$4$1$3$2$2$1$1", f = "MainActivity.kt", i = {0, 0, 0}, l = {267}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-MainActivityKt$DownloaderApp$4$1$3$2$2$1$1$1"}, nl = {266}, s = {"L$0", "L$1", "I$0"}, v = 2)
final class MainActivityKt$DownloaderApp$4$1$3$2$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
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
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivityKt$DownloaderApp$4$1$3$2$2$1$1(Context context, String str, DownloadSettings downloadSettings, MutableState<DownloadMode> mutableState, MutableState<String> mutableState2, SnapshotStateList<String> snapshotStateList, MutableState<AnalyzedMedia> mutableState3, MutableState<String> mutableState4, MutableState<Boolean> mutableState5, Continuation<? super MainActivityKt$DownloaderApp$4$1$3$2$2$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$url = str;
        this.$settings = downloadSettings;
        this.$mode$delegate = mutableState;
        this.$status$delegate = mutableState2;
        this.$selectedImages = snapshotStateList;
        this.$analyzed$delegate = mutableState3;
        this.$log$delegate = mutableState4;
        this.$busy$delegate = mutableState5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainActivityKt$DownloaderApp$4$1$3$2$2$1$1 mainActivityKt$DownloaderApp$4$1$3$2$2$1$1 = new MainActivityKt$DownloaderApp$4$1$3$2$2$1$1(this.$context, this.$url, this.$settings, this.$mode$delegate, this.$status$delegate, this.$selectedImages, this.$analyzed$delegate, this.$log$delegate, this.$busy$delegate, continuation);
        mainActivityKt$DownloaderApp$4$1$3$2$2$1$1.L$0 = obj;
        return mainActivityKt$DownloaderApp$4$1$3$2$2$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivityKt$DownloaderApp$4$1$3$2$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MainActivityKt$DownloaderApp$4$1$3$2$2$1$1 mainActivityKt$DownloaderApp$4$1$3$2$2$1$1;
        Throwable th;
        Object objM8052constructorimpl;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            String str = this.$url;
            DownloadSettings downloadSettings = this.$settings;
            MutableState<DownloadMode> mutableState = this.$mode$delegate;
            final MutableState<String> mutableState2 = this.$status$delegate;
            try {
                Result.Companion companion = Result.INSTANCE;
                DownloadMode downloadModeDownloaderApp$lambda$1 = MainActivityKt.DownloaderApp$lambda$1(mutableState);
                Function1 function1 = new Function1() { // from class: com.yvii.douyindownloader.MainActivityKt$DownloaderApp$4$1$3$2$2$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return MainActivityKt$DownloaderApp$4$1$3$2$2$1$1.invokeSuspend$lambda$0$0(mutableState2, (String) obj2);
                    }
                };
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.I$0 = 0;
                this.label = 1;
                mainActivityKt$DownloaderApp$4$1$3$2$2$1$1 = this;
                try {
                    obj = MainActivityKt.analyzeByMode(context, downloadModeDownloaderApp$lambda$1, str, downloadSettings, function1, mainActivityKt$DownloaderApp$4$1$3$2$2$1$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    Result.Companion companion2 = Result.INSTANCE;
                    objM8052constructorimpl = Result.m8052constructorimpl(ResultKt.createFailure(th));
                }
            } catch (Throwable th3) {
                th = th3;
                mainActivityKt$DownloaderApp$4$1$3$2$2$1$1 = this;
                th = th;
                Result.Companion companion3 = Result.INSTANCE;
                objM8052constructorimpl = Result.m8052constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                ResultKt.throwOnFailure(obj);
                mainActivityKt$DownloaderApp$4$1$3$2$2$1$1 = this;
            } catch (Throwable th4) {
                th = th4;
                mainActivityKt$DownloaderApp$4$1$3$2$2$1$1 = this;
                Result.Companion companion4 = Result.INSTANCE;
                objM8052constructorimpl = Result.m8052constructorimpl(ResultKt.createFailure(th));
            }
        }
        objM8052constructorimpl = Result.m8052constructorimpl((AnalyzedMedia) obj);
        SnapshotStateList<String> snapshotStateList = mainActivityKt$DownloaderApp$4$1$3$2$2$1$1.$selectedImages;
        MutableState<AnalyzedMedia> mutableState3 = mainActivityKt$DownloaderApp$4$1$3$2$2$1$1.$analyzed$delegate;
        MutableState<String> mutableState4 = mainActivityKt$DownloaderApp$4$1$3$2$2$1$1.$status$delegate;
        MutableState<String> mutableState5 = mainActivityKt$DownloaderApp$4$1$3$2$2$1$1.$log$delegate;
        if (Result.m8059isSuccessimpl(objM8052constructorimpl)) {
            AnalyzedMedia analyzedMedia = (AnalyzedMedia) objM8052constructorimpl;
            mutableState3.setValue(analyzedMedia);
            SnapshotStateList<String> snapshotStateList2 = snapshotStateList;
            List<MediaItem> images = analyzedMedia.getImages();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(images, 10));
            Iterator<T> it = images.iterator();
            while (it.hasNext()) {
                arrayList.add(((MediaItem) it.next()).getUrl());
            }
            MainActivityKt.setSelectedImages(snapshotStateList2, arrayList);
            mutableState4.setValue("Found " + MainActivityKt.mediaSummary(analyzedMedia));
            mutableState5.setValue("Analyzed: " + analyzedMedia.getSourceUrl());
        }
        MutableState<String> mutableState6 = mainActivityKt$DownloaderApp$4$1$3$2$2$1$1.$status$delegate;
        MutableState<String> mutableState7 = mainActivityKt$DownloaderApp$4$1$3$2$2$1$1.$log$delegate;
        Throwable thM8055exceptionOrNullimpl = Result.m8055exceptionOrNullimpl(objM8052constructorimpl);
        if (thM8055exceptionOrNullimpl != null) {
            mutableState6.setValue("Analyze failed");
            String message = thM8055exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = thM8055exceptionOrNullimpl.getClass().getSimpleName();
                Intrinsics.checkNotNullExpressionValue(message, "getSimpleName(...)");
            }
            mutableState7.setValue(message);
        }
        MainActivityKt.DownloaderApp$lambda$8(mainActivityKt$DownloaderApp$4$1$3$2$2$1$1.$busy$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(MutableState mutableState, String str) {
        mutableState.setValue(str);
        return Unit.INSTANCE;
    }
}
