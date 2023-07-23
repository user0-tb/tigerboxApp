package p012io.shipbook.shipbooksdk.Networking;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "io.shipbook.shipbooksdk.Networking.SessionManager", mo34424f = "SessionManager.kt", mo34425i = {0}, mo34426l = {161}, mo34427m = "refreshToken", mo34428n = {"this"}, mo34429s = {"L$0"})
/* renamed from: io.shipbook.shipbooksdk.Networking.SessionManager$refreshToken$1 */
/* compiled from: SessionManager.kt */
final class SessionManager$refreshToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionManager$refreshToken$1(SessionManager sessionManager, Continuation<? super SessionManager$refreshToken$1> continuation) {
        super(continuation);
        this.this$0 = sessionManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshToken(this);
    }
}
