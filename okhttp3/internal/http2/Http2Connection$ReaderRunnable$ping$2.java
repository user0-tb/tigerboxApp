package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Http2Connection.kt */
final class Http2Connection$ReaderRunnable$ping$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $payload1;
    final /* synthetic */ int $payload2;
    final /* synthetic */ Http2Connection this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Http2Connection$ReaderRunnable$ping$2(Http2Connection http2Connection, int i, int i2) {
        super(0);
        this.this$0 = http2Connection;
        this.$payload1 = i;
        this.$payload2 = i2;
    }

    public final void invoke() {
        this.this$0.writePing(true, this.$payload1, this.$payload2);
    }
}
