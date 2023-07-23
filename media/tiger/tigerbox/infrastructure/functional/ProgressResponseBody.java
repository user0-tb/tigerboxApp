package media.tiger.tigerbox.infrastructure.functional;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/functional/ProgressResponseBody;", "Lokhttp3/ResponseBody;", "responseBody", "progressListener", "Lmedia/tiger/tigerbox/infrastructure/functional/DownloadProgressUpdate;", "(Lokhttp3/ResponseBody;Lmedia/tiger/tigerbox/infrastructure/functional/DownloadProgressUpdate;)V", "bufferedSource", "Lokio/BufferedSource;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "Lokio/Source;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProgressResponseBody.kt */
public final class ProgressResponseBody extends ResponseBody {
    private BufferedSource bufferedSource;
    /* access modifiers changed from: private */
    public final DownloadProgressUpdate progressListener;
    /* access modifiers changed from: private */
    public final ResponseBody responseBody;

    public ProgressResponseBody(ResponseBody responseBody2, DownloadProgressUpdate downloadProgressUpdate) {
        Intrinsics.checkNotNullParameter(responseBody2, "responseBody");
        this.responseBody = responseBody2;
        this.progressListener = downloadProgressUpdate;
    }

    public MediaType contentType() {
        return this.responseBody.contentType();
    }

    public long contentLength() {
        return this.responseBody.contentLength();
    }

    public BufferedSource source() {
        if (this.bufferedSource == null) {
            this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
        }
        BufferedSource bufferedSource2 = this.bufferedSource;
        Intrinsics.checkNotNull(bufferedSource2);
        return bufferedSource2;
    }

    private final Source source(Source source) {
        return new ProgressResponseBody$source$1(source, this);
    }
}
