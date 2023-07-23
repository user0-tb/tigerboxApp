package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;

@Metadata(mo33736d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u000fH\u0016J\b\u0010\"\u001a\u00020#H\u0002J'\u0010$\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u00152\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010&H\u0000¢\u0006\u0002\b'J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002J-\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010#2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010&H\u0000¢\u0006\u0002\b,J\u0012\u0010-\u001a\u0004\u0018\u00010\u00152\u0006\u0010.\u001a\u00020\u001fH\u0002J\u0010\u0010/\u001a\u00020\u00132\u0006\u00100\u001a\u000201H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo33737d2 = {"Lokhttp3/internal/connection/RealRoutePlanner;", "Lokhttp3/internal/connection/RoutePlanner;", "client", "Lokhttp3/OkHttpClient;", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "(Lokhttp3/OkHttpClient;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/internal/http/RealInterceptorChain;)V", "getAddress", "()Lokhttp3/Address;", "deferredPlans", "Lkotlin/collections/ArrayDeque;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "getDeferredPlans", "()Lkotlin/collections/ArrayDeque;", "doExtensiveHealthChecks", "", "nextRouteToTry", "Lokhttp3/Route;", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "createTunnelRequest", "Lokhttp3/Request;", "route", "hasNext", "failedConnection", "Lokhttp3/internal/connection/RealConnection;", "isCanceled", "plan", "planConnect", "Lokhttp3/internal/connection/ConnectPlan;", "planConnectToRoute", "routes", "", "planConnectToRoute$okhttp", "planReuseCallConnection", "Lokhttp3/internal/connection/ReusePlan;", "planReusePooledConnection", "planToReplace", "planReusePooledConnection$okhttp", "retryRoute", "connection", "sameHostAndPort", "url", "Lokhttp3/HttpUrl;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RealRoutePlanner.kt */
public final class RealRoutePlanner implements RoutePlanner {
    private final Address address;
    private final RealCall call;
    private final OkHttpClient client;
    private final ArrayDeque<RoutePlanner.Plan> deferredPlans = new ArrayDeque<>();
    private final boolean doExtensiveHealthChecks;
    private Route nextRouteToTry;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public RealRoutePlanner(OkHttpClient okHttpClient, Address address2, RealCall realCall, RealInterceptorChain realInterceptorChain) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(address2, "address");
        Intrinsics.checkNotNullParameter(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(realInterceptorChain, "chain");
        this.client = okHttpClient;
        this.address = address2;
        this.call = realCall;
        this.doExtensiveHealthChecks = !Intrinsics.areEqual((Object) realInterceptorChain.getRequest$okhttp().method(), (Object) "GET");
    }

    public Address getAddress() {
        return this.address;
    }

    public ArrayDeque<RoutePlanner.Plan> getDeferredPlans() {
        return this.deferredPlans;
    }

    public boolean isCanceled() {
        return this.call.isCanceled();
    }

    public RoutePlanner.Plan plan() throws IOException {
        ReusePlan planReuseCallConnection = planReuseCallConnection();
        if (planReuseCallConnection != null) {
            return planReuseCallConnection;
        }
        ReusePlan planReusePooledConnection$okhttp$default = planReusePooledConnection$okhttp$default(this, (ConnectPlan) null, (List) null, 3, (Object) null);
        if (planReusePooledConnection$okhttp$default != null) {
            return planReusePooledConnection$okhttp$default;
        }
        if (!getDeferredPlans().isEmpty()) {
            return getDeferredPlans().removeFirst();
        }
        ConnectPlan planConnect = planConnect();
        ReusePlan planReusePooledConnection$okhttp = planReusePooledConnection$okhttp(planConnect, planConnect.getRoutes$okhttp());
        if (planReusePooledConnection$okhttp != null) {
            return planReusePooledConnection$okhttp;
        }
        return planConnect;
    }

    private final ReusePlan planReuseCallConnection() {
        boolean z;
        Socket socket;
        RealConnection connection = this.call.getConnection();
        if (connection == null) {
            return null;
        }
        boolean isHealthy = connection.isHealthy(this.doExtensiveHealthChecks);
        synchronized (connection) {
            z = true;
            if (!isHealthy) {
                connection.setNoNewExchanges(true);
                socket = this.call.releaseConnectionNoEvents$okhttp();
            } else {
                if (!connection.getNoNewExchanges()) {
                    if (sameHostAndPort(connection.route().address().url())) {
                        socket = null;
                    }
                }
                socket = this.call.releaseConnectionNoEvents$okhttp();
            }
        }
        if (this.call.getConnection() != null) {
            if (socket != null) {
                z = false;
            }
            if (z) {
                return new ReusePlan(connection);
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        if (socket != null) {
            _UtilJvmKt.closeQuietly(socket);
        }
        this.call.getEventListener$okhttp().connectionReleased(this.call, connection);
        return null;
    }

    private final ConnectPlan planConnect() throws IOException {
        Route route = this.nextRouteToTry;
        if (route != null) {
            this.nextRouteToTry = null;
            return planConnectToRoute$okhttp$default(this, route, (List) null, 2, (Object) null);
        }
        RouteSelector.Selection selection = this.routeSelection;
        if (selection != null && selection.hasNext()) {
            return planConnectToRoute$okhttp$default(this, selection.next(), (List) null, 2, (Object) null);
        }
        RouteSelector routeSelector2 = this.routeSelector;
        if (routeSelector2 == null) {
            routeSelector2 = new RouteSelector(getAddress(), this.call.getClient().getRouteDatabase$okhttp(), this.call, this.client.fastFallback(), this.call.getEventListener$okhttp());
            this.routeSelector = routeSelector2;
        }
        if (routeSelector2.hasNext()) {
            RouteSelector.Selection next = routeSelector2.next();
            this.routeSelection = next;
            if (!this.call.isCanceled()) {
                return planConnectToRoute$okhttp(next.next(), next.getRoutes());
            }
            throw new IOException("Canceled");
        }
        throw new IOException("exhausted all routes");
    }

    public static /* synthetic */ ReusePlan planReusePooledConnection$okhttp$default(RealRoutePlanner realRoutePlanner, ConnectPlan connectPlan, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            connectPlan = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planReusePooledConnection$okhttp(connectPlan, list);
    }

    public final ReusePlan planReusePooledConnection$okhttp(ConnectPlan connectPlan, List<Route> list) {
        RealConnection callAcquirePooledConnection = this.client.connectionPool().getDelegate$okhttp().callAcquirePooledConnection(this.doExtensiveHealthChecks, getAddress(), this.call, list, connectPlan != null && connectPlan.isReady());
        if (callAcquirePooledConnection == null) {
            return null;
        }
        if (connectPlan != null) {
            this.nextRouteToTry = connectPlan.getRoute();
            connectPlan.closeQuietly();
        }
        this.call.getEventListener$okhttp().connectionAcquired(this.call, callAcquirePooledConnection);
        return new ReusePlan(callAcquirePooledConnection);
    }

    public static /* synthetic */ ConnectPlan planConnectToRoute$okhttp$default(RealRoutePlanner realRoutePlanner, Route route, List list, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            list = null;
        }
        return realRoutePlanner.planConnectToRoute$okhttp(route, list);
    }

    public final ConnectPlan planConnectToRoute$okhttp(Route route, List<Route> list) throws IOException {
        Intrinsics.checkNotNullParameter(route, "route");
        if (route.address().sslSocketFactory() == null) {
            if (route.address().connectionSpecs().contains(ConnectionSpec.CLEARTEXT)) {
                String host = route.address().url().host();
                if (!Platform.Companion.get().isCleartextTrafficPermitted(host)) {
                    throw new UnknownServiceException("CLEARTEXT communication to " + host + " not permitted by network security policy");
                }
            } else {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
        } else if (route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        return new ConnectPlan(this.client, this.call, this, route, list, 0, route.requiresTunnel() ? createTunnelRequest(route) : null, -1, false);
    }

    private final Request createTunnelRequest(Route route) throws IOException {
        Request build = new Request.Builder().url(route.address().url()).method("CONNECT", (RequestBody) null).header(HttpHeaders.HOST, _UtilJvmKt.toHostHeader(route.address().url(), true)).header("Proxy-Connection", HttpHeaders.KEEP_ALIVE).header("User-Agent", _UtilCommonKt.userAgent).build();
        Request authenticate = route.address().proxyAuthenticator().authenticate(route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(HttpStatusCodesKt.HTTP_PROXY_AUTH).message("Preemptive Authenticate").sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        return authenticate == null ? build : authenticate;
    }

    public boolean hasNext(RealConnection realConnection) {
        RouteSelector routeSelector2;
        Route retryRoute;
        if ((!getDeferredPlans().isEmpty()) || this.nextRouteToTry != null) {
            return true;
        }
        if (realConnection == null || (retryRoute = retryRoute(realConnection)) == null) {
            RouteSelector.Selection selection = this.routeSelection;
            boolean z = false;
            if (selection != null && selection.hasNext()) {
                z = true;
            }
            if (!z && (routeSelector2 = this.routeSelector) != null) {
                return routeSelector2.hasNext();
            }
            return true;
        }
        this.nextRouteToTry = retryRoute;
        return true;
    }

    private final Route retryRoute(RealConnection realConnection) {
        synchronized (realConnection) {
            if (realConnection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (!realConnection.getNoNewExchanges()) {
                return null;
            }
            if (!_UtilJvmKt.canReuseConnectionFor(realConnection.route().address().url(), getAddress().url())) {
                return null;
            }
            Route route = realConnection.route();
            return route;
        }
    }

    public boolean sameHostAndPort(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        HttpUrl url = getAddress().url();
        return httpUrl.port() == url.port() && Intrinsics.areEqual((Object) httpUrl.host(), (Object) url.host());
    }
}
