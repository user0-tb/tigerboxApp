package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.RoutePlanner;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, mo33737d2 = {"Lokhttp3/internal/connection/SequentialExchangeFinder;", "Lokhttp3/internal/connection/ExchangeFinder;", "routePlanner", "Lokhttp3/internal/connection/RoutePlanner;", "(Lokhttp3/internal/connection/RoutePlanner;)V", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "find", "Lokhttp3/internal/connection/RealConnection;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SequentialExchangeFinder.kt */
public final class SequentialExchangeFinder implements ExchangeFinder {
    private final RoutePlanner routePlanner;

    public SequentialExchangeFinder(RoutePlanner routePlanner2) {
        Intrinsics.checkNotNullParameter(routePlanner2, "routePlanner");
        this.routePlanner = routePlanner2;
    }

    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    public RealConnection find() {
        IOException iOException = null;
        while (!getRoutePlanner().isCanceled()) {
            try {
                RoutePlanner.Plan plan = getRoutePlanner().plan();
                if (!plan.isReady()) {
                    RoutePlanner.ConnectResult connectTcp = plan.connectTcp();
                    if (connectTcp.isSuccess()) {
                        connectTcp = plan.connectTlsEtc();
                    }
                    RoutePlanner.Plan component2 = connectTcp.component2();
                    Throwable component3 = connectTcp.component3();
                    if (component3 != null) {
                        throw component3;
                    } else if (component2 != null) {
                        getRoutePlanner().getDeferredPlans().addFirst(component2);
                    }
                }
                return plan.handleSuccess();
            } catch (IOException e) {
                if (iOException == null) {
                    iOException = e;
                } else {
                    ExceptionsKt.addSuppressed(iOException, e);
                }
                if (!RoutePlanner.DefaultImpls.hasNext$default(getRoutePlanner(), (RealConnection) null, 1, (Object) null)) {
                    throw iOException;
                }
            }
        }
        throw new IOException("Canceled");
    }
}
