package p012io.shipbook.shipbooksdk.Networking;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "io.shipbook.shipbooksdk.Networking.ConnectionClient", mo34424f = "ConnectionClient.kt", mo34425i = {0, 0, 0, 0}, mo34426l = {82, 83}, mo34427m = "request", mo34428n = {"url", "data", "method", "responseData"}, mo34429s = {"L$0", "L$1", "L$2", "L$3"})
/* renamed from: io.shipbook.shipbooksdk.Networking.ConnectionClient$request$4 */
/* compiled from: ConnectionClient.kt */
final class ConnectionClient$request$4 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectionClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionClient$request$4(ConnectionClient connectionClient, Continuation<? super ConnectionClient$request$4> continuation) {
        super(continuation);
        this.this$0 = connectionClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.request((String) null, (String) null, (HttpMethod) null, (Continuation<? super ResponseData>) this);
    }
}
