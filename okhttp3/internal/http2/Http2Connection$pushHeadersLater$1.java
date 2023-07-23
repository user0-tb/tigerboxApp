package okhttp3.internal.http2;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Http2Connection.kt */
final class Http2Connection$pushHeadersLater$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $inFinished;
    final /* synthetic */ List<Header> $requestHeaders;
    final /* synthetic */ int $streamId;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Http2Connection$pushHeadersLater$1(Http2Connection http2Connection, int i, List<Header> list, boolean z) {
        super(0);
        this.this$0 = http2Connection;
        this.$streamId = i;
        this.$requestHeaders = list;
        this.$inFinished = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r6 = this;
            okhttp3.internal.http2.Http2Connection r0 = r6.this$0
            okhttp3.internal.http2.PushObserver r0 = r0.pushObserver
            int r1 = r6.$streamId
            java.util.List<okhttp3.internal.http2.Header> r2 = r6.$requestHeaders
            boolean r3 = r6.$inFinished
            boolean r0 = r0.onHeaders(r1, r2, r3)
            okhttp3.internal.http2.Http2Connection r1 = r6.this$0
            int r2 = r6.$streamId
            boolean r3 = r6.$inFinished
            if (r0 == 0) goto L_0x0021
            okhttp3.internal.http2.Http2Writer r4 = r1.getWriter()     // Catch:{ IOException -> 0x0036 }
            okhttp3.internal.http2.ErrorCode r5 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x0036 }
            r4.rstStream(r2, r5)     // Catch:{ IOException -> 0x0036 }
        L_0x0021:
            if (r0 != 0) goto L_0x0025
            if (r3 == 0) goto L_0x0036
        L_0x0025:
            monitor-enter(r1)     // Catch:{ IOException -> 0x0036 }
            java.util.Set r0 = r1.currentPushRequests     // Catch:{ all -> 0x0033 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0033 }
            r0.remove(r2)     // Catch:{ all -> 0x0033 }
            monitor-exit(r1)     // Catch:{ IOException -> 0x0036 }
            goto L_0x0036
        L_0x0033:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ IOException -> 0x0036 }
            throw r0     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection$pushHeadersLater$1.invoke():void");
    }
}
