package okhttp3;

import kotlin.Metadata;
import okio.FileSystem;
import okio.Path;

@Metadata(mo33736d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo33737d2 = {"okhttp3/RequestBody$Companion$asRequestBody$2", "Lokhttp3/RequestBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestBody.kt */
public final class RequestBody$Companion$asRequestBody$2 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ FileSystem $fileSystem;
    final /* synthetic */ Path $this_asRequestBody;

    RequestBody$Companion$asRequestBody$2(MediaType mediaType, FileSystem fileSystem, Path path) {
        this.$contentType = mediaType;
        this.$fileSystem = fileSystem;
        this.$this_asRequestBody = path;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public long contentLength() {
        Long size = this.$fileSystem.metadata(this.$this_asRequestBody).getSize();
        if (size != null) {
            return size.longValue();
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r0, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(okio.BufferedSink r3) {
        /*
            r2 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            okio.FileSystem r0 = r2.$fileSystem
            okio.Path r1 = r2.$this_asRequestBody
            okio.Source r0 = r0.source(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            okio.Source r1 = (okio.Source) r1     // Catch:{ all -> 0x001a }
            r3.writeAll(r1)     // Catch:{ all -> 0x001a }
            r3 = 0
            kotlin.p013io.CloseableKt.closeFinally(r0, r3)
            return
        L_0x001a:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001c }
        L_0x001c:
            r1 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.RequestBody$Companion$asRequestBody$2.writeTo(okio.BufferedSink):void");
    }
}
