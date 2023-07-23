package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okio.Buffer;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Http2Connection.kt */
final class Http2Connection$pushDataLater$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Buffer $buffer;
    final /* synthetic */ int $byteCount;
    final /* synthetic */ boolean $inFinished;
    final /* synthetic */ int $streamId;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Http2Connection$pushDataLater$1(Http2Connection http2Connection, int i, Buffer buffer, int i2, boolean z) {
        super(0);
        this.this$0 = http2Connection;
        this.$streamId = i;
        this.$buffer = buffer;
        this.$byteCount = i2;
        this.$inFinished = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r6 = this;
            okhttp3.internal.http2.Http2Connection r0 = r6.this$0
            int r1 = r6.$streamId
            okio.Buffer r2 = r6.$buffer
            int r3 = r6.$byteCount
            boolean r4 = r6.$inFinished
            okhttp3.internal.http2.PushObserver r5 = r0.pushObserver     // Catch:{ IOException -> 0x0034 }
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ IOException -> 0x0034 }
            boolean r2 = r5.onData(r1, r2, r3, r4)     // Catch:{ IOException -> 0x0034 }
            if (r2 == 0) goto L_0x001f
            okhttp3.internal.http2.Http2Writer r3 = r0.getWriter()     // Catch:{ IOException -> 0x0034 }
            okhttp3.internal.http2.ErrorCode r5 = okhttp3.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x0034 }
            r3.rstStream(r1, r5)     // Catch:{ IOException -> 0x0034 }
        L_0x001f:
            if (r2 != 0) goto L_0x0023
            if (r4 == 0) goto L_0x0034
        L_0x0023:
            monitor-enter(r0)     // Catch:{ IOException -> 0x0034 }
            java.util.Set r2 = r0.currentPushRequests     // Catch:{ all -> 0x0031 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0031 }
            r2.remove(r1)     // Catch:{ all -> 0x0031 }
            monitor-exit(r0)     // Catch:{ IOException -> 0x0034 }
            goto L_0x0034
        L_0x0031:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ IOException -> 0x0034 }
            throw r1     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection$pushDataLater$1.invoke():void");
    }
}
