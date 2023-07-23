package okhttp3.internal.connection;

import kotlin.Metadata;
import okhttp3.internal.p017ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"okhttp3/internal/connection/RealConnection$newWebSocketStreams$1", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "close", "", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RealConnection.kt */
public final class RealConnection$newWebSocketStreams$1 extends RealWebSocket.Streams {
    final /* synthetic */ Exchange $exchange;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealConnection$newWebSocketStreams$1(BufferedSource bufferedSource, BufferedSink bufferedSink, Exchange exchange) {
        super(true, bufferedSource, bufferedSink);
        this.$exchange = exchange;
    }

    public void close() {
        this.$exchange.bodyComplete(-1, true, true, null);
    }
}
