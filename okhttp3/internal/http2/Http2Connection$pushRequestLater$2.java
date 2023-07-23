package okhttp3.internal.http2;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Http2Connection.kt */
final class Http2Connection$pushRequestLater$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<Header> $requestHeaders;
    final /* synthetic */ int $streamId;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Http2Connection$pushRequestLater$2(Http2Connection http2Connection, int i, List<Header> list) {
        super(0);
        this.this$0 = http2Connection;
        this.$streamId = i;
        this.$requestHeaders = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r4 = this;
            okhttp3.internal.http2.Http2Connection r0 = r4.this$0
            okhttp3.internal.http2.PushObserver r0 = r0.pushObserver
            int r1 = r4.$streamId
            java.util.List<okhttp3.internal.http2.Header> r2 = r4.$requestHeaders
            boolean r0 = r0.onRequest(r1, r2)
            okhttp3.internal.http2.Http2Connection r1 = r4.this$0
            int r2 = r4.$streamId
            if (r0 == 0) goto L_0x002e
            okhttp3.internal.http2.Http2Writer r0 = r1.getWriter()     // Catch:{ IOException -> 0x002e }
            okhttp3.internal.http2.ErrorCode r3 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x002e }
            r0.rstStream(r2, r3)     // Catch:{ IOException -> 0x002e }
            monitor-enter(r1)     // Catch:{ IOException -> 0x002e }
            java.util.Set r0 = r1.currentPushRequests     // Catch:{ all -> 0x002b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x002b }
            r0.remove(r2)     // Catch:{ all -> 0x002b }
            monitor-exit(r1)     // Catch:{ IOException -> 0x002e }
            goto L_0x002e
        L_0x002b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ IOException -> 0x002e }
            throw r0     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection$pushRequestLater$2.invoke():void");
    }
}
