package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.connection.RoutePlanner;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"okhttp3/internal/connection/FastFallbackExchangeFinder$launchTcpConnect$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: FastFallbackExchangeFinder.kt */
public final class FastFallbackExchangeFinder$launchTcpConnect$1 extends Task {
    final /* synthetic */ RoutePlanner.Plan $plan;
    final /* synthetic */ FastFallbackExchangeFinder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FastFallbackExchangeFinder$launchTcpConnect$1(String str, RoutePlanner.Plan plan, FastFallbackExchangeFinder fastFallbackExchangeFinder) {
        super(str, false, 2, (DefaultConstructorMarker) null);
        this.$plan = plan;
        this.this$0 = fastFallbackExchangeFinder;
    }

    public long runOnce() {
        RoutePlanner.ConnectResult connectResult;
        try {
            connectResult = this.$plan.connectTcp();
        } catch (Throwable th) {
            connectResult = new RoutePlanner.ConnectResult(this.$plan, (RoutePlanner.Plan) null, th, 2, (DefaultConstructorMarker) null);
        }
        if (!this.this$0.tcpConnectsInFlight.contains(this.$plan)) {
            return -1;
        }
        this.this$0.connectResults.put(connectResult);
        return -1;
    }
}
