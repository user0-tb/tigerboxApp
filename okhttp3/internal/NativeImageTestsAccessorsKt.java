package okhttp3.internal;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okio.FileSystem;
import okio.Path;

@Metadata(mo33736d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u0016\u0010\u0017\u001a\u00020\u0018*\u00020\u00192\n\u0010\u001a\u001a\u00060\u001bR\u00020\u001c\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"(\u0010\u000b\u001a\u00020\n*\u00020\u00012\u0006\u0010\t\u001a\u00020\n8F@FX\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, mo33737d2 = {"connectionAccessor", "Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/connection/Exchange;", "getConnectionAccessor", "(Lokhttp3/internal/connection/Exchange;)Lokhttp3/internal/connection/RealConnection;", "exchangeAccessor", "Lokhttp3/Response;", "getExchangeAccessor", "(Lokhttp3/Response;)Lokhttp3/internal/connection/Exchange;", "value", "", "idleAtNsAccessor", "getIdleAtNsAccessor", "(Lokhttp3/internal/connection/RealConnection;)J", "setIdleAtNsAccessor", "(Lokhttp3/internal/connection/RealConnection;J)V", "buildCache", "Lokhttp3/Cache;", "file", "Lokio/Path;", "maxSize", "fileSystem", "Lokio/FileSystem;", "finishedAccessor", "", "Lokhttp3/Dispatcher;", "call", "Lokhttp3/internal/connection/RealCall$AsyncCall;", "Lokhttp3/internal/connection/RealCall;", "okhttp"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NativeImageTestsAccessors.kt */
public final class NativeImageTestsAccessorsKt {
    public static final Cache buildCache(Path path, long j, FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        return new Cache(path, j, fileSystem);
    }

    public static final long getIdleAtNsAccessor(RealConnection realConnection) {
        Intrinsics.checkNotNullParameter(realConnection, "<this>");
        return realConnection.getIdleAtNs();
    }

    public static final void setIdleAtNsAccessor(RealConnection realConnection, long j) {
        Intrinsics.checkNotNullParameter(realConnection, "<this>");
        realConnection.setIdleAtNs(j);
    }

    public static final Exchange getExchangeAccessor(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return response.exchange();
    }

    public static final RealConnection getConnectionAccessor(Exchange exchange) {
        Intrinsics.checkNotNullParameter(exchange, "<this>");
        return exchange.getConnection$okhttp();
    }

    public static final void finishedAccessor(Dispatcher dispatcher, RealCall.AsyncCall asyncCall) {
        Intrinsics.checkNotNullParameter(dispatcher, "<this>");
        Intrinsics.checkNotNullParameter(asyncCall, NotificationCompat.CATEGORY_CALL);
        dispatcher.finished$okhttp(asyncCall);
    }
}
