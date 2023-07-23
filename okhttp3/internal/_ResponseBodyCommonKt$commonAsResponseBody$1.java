package okhttp3.internal;

import kotlin.Metadata;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

@Metadata(mo33736d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo33737d2 = {"okhttp3/internal/_ResponseBodyCommonKt$commonAsResponseBody$1", "Lokhttp3/ResponseBody;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "Lokio/BufferedSource;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -ResponseBodyCommon.kt */
public final class _ResponseBodyCommonKt$commonAsResponseBody$1 extends ResponseBody {
    final /* synthetic */ long $contentLength;
    final /* synthetic */ MediaType $contentType;
    final /* synthetic */ BufferedSource $this_commonAsResponseBody;

    _ResponseBodyCommonKt$commonAsResponseBody$1(MediaType mediaType, long j, BufferedSource bufferedSource) {
        this.$contentType = mediaType;
        this.$contentLength = j;
        this.$this_commonAsResponseBody = bufferedSource;
    }

    public MediaType contentType() {
        return this.$contentType;
    }

    public long contentLength() {
        return this.$contentLength;
    }

    public BufferedSource source() {
        return this.$this_commonAsResponseBody;
    }
}
