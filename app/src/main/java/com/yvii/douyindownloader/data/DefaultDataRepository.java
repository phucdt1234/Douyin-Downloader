package com.yvii.douyindownloader.data;

import androidx.compose.ui.tooling.preview.AndroidUiModes;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: DataRepository.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/example/douyinvideodownloader/data/DefaultDataRepository;", "Lcom/example/douyinvideodownloader/data/DataRepository;", "<init>", "()V", "data", "Lkotlinx/coroutines/flow/Flow;", "", "", "getData", "()Lkotlinx/coroutines/flow/Flow;", "app"}, k = 1, mv = {2, 3, 0}, xi = AndroidUiModes.UI_MODE_NIGHT_MASK)
public final class DefaultDataRepository implements DataRepository {
    public static final int $stable = 8;
    private final Flow<List<String>> data = FlowKt.flow(new DefaultDataRepository$data$1(null));

    @Override // com.yvii.douyindownloader.data.DataRepository
    public Flow<List<String>> getData() {
        return this.data;
    }
}
