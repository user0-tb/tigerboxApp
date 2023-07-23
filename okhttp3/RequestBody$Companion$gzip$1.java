package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

@Metadata(mo33736d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo33737d2 = {"okhttp3/RequestBody$Companion$gzip$1", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "isOneShot", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestBody.kt */
public final class RequestBody$Companion$gzip$1 extends RequestBody {
    final /* synthetic */ RequestBody $this_gzip;

    public long contentLength() {
        return -1;
    }

    RequestBody$Companion$gzip$1(RequestBody requestBody) {
        this.$this_gzip = requestBody;
    }

    public MediaType contentType() {
        return this.$this_gzip.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        BufferedSink buffer = Okio.buffer((Sink) new GzipSink(bufferedSink));
        this.$this_gzip.writeTo(buffer);
        buffer.close();
    }

    public boolean isOneShot() {
        return this.$this_gzip.isOneShot();
    }
}
