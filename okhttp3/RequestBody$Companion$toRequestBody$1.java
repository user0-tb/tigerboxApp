package okhttp3;

import java.io.FileDescriptor;
import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo33737d2 = {"okhttp3/RequestBody$Companion$toRequestBody$1", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "isOneShot", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestBody.kt */
public final class RequestBody$Companion$toRequestBody$1 extends RequestBody {
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ FileDescriptor $this_toRequestBody;

    public boolean isOneShot() {
        return true;
    }

    RequestBody$Companion$toRequestBody$1(MediaType mediaType, FileDescriptor fileDescriptor) {
        this.$contentType = mediaType;
        this.$this_toRequestBody = fileDescriptor;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0025, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r0, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(okio.BufferedSink r3) {
        /*
            r2 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            java.io.FileDescriptor r1 = r2.$this_toRequestBody
            r0.<init>(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            java.io.FileInputStream r1 = (java.io.FileInputStream) r1     // Catch:{ all -> 0x0023 }
            okio.Buffer r3 = r3.getBuffer()     // Catch:{ all -> 0x0023 }
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ all -> 0x0023 }
            okio.Source r1 = okio.Okio.source((java.io.InputStream) r1)     // Catch:{ all -> 0x0023 }
            r3.writeAll(r1)     // Catch:{ all -> 0x0023 }
            r3 = 0
            kotlin.p013io.CloseableKt.closeFinally(r0, r3)
            return
        L_0x0023:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r1 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.RequestBody$Companion$toRequestBody$1.writeTo(okio.BufferedSink):void");
    }
}
