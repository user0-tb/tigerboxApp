package media.tiger.tigerbox;

import android.util.Log;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.TigerBoxLogTree;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.TigerBoxLogTree$saveLogsToFile$1", mo34424f = "TigerBoxLogTree.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: TigerBoxLogTree.kt */
final class TigerBoxLogTree$saveLogsToFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<TigerBoxLogTree.LogInfo> $logsList;
    int label;
    final /* synthetic */ TigerBoxLogTree this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerBoxLogTree$saveLogsToFile$1(List<TigerBoxLogTree.LogInfo> list, TigerBoxLogTree tigerBoxLogTree, Continuation<? super TigerBoxLogTree$saveLogsToFile$1> continuation) {
        super(2, continuation);
        this.$logsList = list;
        this.this$0 = tigerBoxLogTree;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TigerBoxLogTree$saveLogsToFile$1(this.$logsList, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TigerBoxLogTree$saveLogsToFile$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Log.e("TEST", "SAVE LOGS TO FILE " + this.$logsList.size());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            Date date = new Date();
            String encode = URLEncoder.encode(this.this$0.firmwareVersion + "__" + this.this$0.serialNumber + "__" + simpleDateFormat.format(date) + ".logTree", "UTF-8");
            Intrinsics.checkNotNullExpressionValue(encode, "encode(filename, \"UTF-8\")");
            TigerBoxLogTree tigerBoxLogTree = this.this$0;
            tigerBoxLogTree.writeToFile(encode, tigerBoxLogTree.logsToString(this.$logsList));
            this.this$0.removeOldLogFiles();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
