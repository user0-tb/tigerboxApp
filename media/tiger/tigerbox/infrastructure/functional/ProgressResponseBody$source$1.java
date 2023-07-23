package media.tiger.tigerbox.infrastructure.functional;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(mo33736d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, mo33737d2 = {"media/tiger/tigerbox/infrastructure/functional/ProgressResponseBody$source$1", "Lokio/ForwardingSource;", "totalBytesRead", "", "getTotalBytesRead", "()J", "setTotalBytesRead", "(J)V", "read", "sink", "Lokio/Buffer;", "byteCount", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProgressResponseBody.kt */
public final class ProgressResponseBody$source$1 extends ForwardingSource {
    final /* synthetic */ ProgressResponseBody this$0;
    private long totalBytesRead;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressResponseBody$source$1(Source source, ProgressResponseBody progressResponseBody) {
        super(source);
        this.this$0 = progressResponseBody;
    }

    public final long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    public final void setTotalBytesRead(long j) {
        this.totalBytesRead = j;
    }

    public long read(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        long read = super.read(buffer, j);
        int i = (read > -1 ? 1 : (read == -1 ? 0 : -1));
        long j2 = this.totalBytesRead + (i != 0 ? read : 0);
        this.totalBytesRead = j2;
        double d = 100.0d;
        if (i != 0) {
            d = 100.0d * (((double) j2) / ((double) this.this$0.responseBody.contentLength()));
        }
        DownloadProgressUpdate access$getProgressListener$p = this.this$0.progressListener;
        if (access$getProgressListener$p != null) {
            access$getProgressListener$p.invoke(d);
        }
        return read;
    }
}
