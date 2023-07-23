package okhttp3.internal.connection;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.connection.RoutePlanner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MBW\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u00102\u001a\u000203H\u0016J\u0006\u00104\u001a\u000203J\b\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u000207H\u0016J\u0018\u00108\u001a\u0002032\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u000207H\u0016J\r\u0010>\u001a\u000207H\u0000¢\u0006\u0002\b?J2\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0002J\n\u0010A\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010B\u001a\u00020\u0017H\u0016J%\u0010C\u001a\u0004\u0018\u00010\u00002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020<0\f2\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\bEJ\b\u0010F\u001a\u000203H\u0016J#\u0010G\u001a\u00020\u00002\f\u0010D\u001a\b\u0012\u0004\u0012\u00020<0\f2\u0006\u00109\u001a\u00020:H\u0000¢\u0006\u0002\bHJ\b\u0010I\u001a\u00020\u0001H\u0016J\u001a\u0010J\u001a\u0002032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010K\u001a\u0004\u0018\u00010LH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, mo33737d2 = {"Lokhttp3/internal/connection/ConnectPlan;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "Lokhttp3/internal/http/ExchangeCodec$Carrier;", "client", "Lokhttp3/OkHttpClient;", "call", "Lokhttp3/internal/connection/RealCall;", "routePlanner", "Lokhttp3/internal/connection/RealRoutePlanner;", "route", "Lokhttp3/Route;", "routes", "", "attempt", "", "tunnelRequest", "Lokhttp3/Request;", "connectionSpecIndex", "isTlsFallback", "", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealCall;Lokhttp3/internal/connection/RealRoutePlanner;Lokhttp3/Route;Ljava/util/List;ILokhttp3/Request;IZ)V", "canceled", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnectionSpecIndex$okhttp", "()I", "eventListener", "Lokhttp3/EventListener;", "handshake", "Lokhttp3/Handshake;", "isReady", "()Z", "isTlsFallback$okhttp", "protocol", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "getRoute", "()Lokhttp3/Route;", "getRoutes$okhttp", "()Ljava/util/List;", "sink", "Lokio/BufferedSink;", "socket", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "source", "Lokio/BufferedSource;", "cancel", "", "closeQuietly", "connectSocket", "connectTcp", "Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "connectTls", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "connectionSpec", "Lokhttp3/ConnectionSpec;", "connectTlsEtc", "connectTunnel", "connectTunnel$okhttp", "copy", "createTunnel", "handleSuccess", "nextConnectionSpec", "connectionSpecs", "nextConnectionSpec$okhttp", "noNewExchanges", "planWithCurrentOrInitialConnectionSpec", "planWithCurrentOrInitialConnectionSpec$okhttp", "retry", "trackFailure", "e", "Ljava/io/IOException;", "Companion", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ConnectPlan.kt */
public final class ConnectPlan implements RoutePlanner.Plan, ExchangeCodec.Carrier {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private final int attempt;
    private final RealCall call;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final int connectionSpecIndex;
    private final EventListener eventListener;
    private Handshake handshake;
    private final boolean isTlsFallback;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    private final RealRoutePlanner routePlanner;
    private final List<Route> routes;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    private final Request tunnelRequest;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ConnectPlan.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void noNewExchanges() {
    }

    public void trackFailure(RealCall realCall, IOException iOException) {
        Intrinsics.checkNotNullParameter(realCall, NotificationCompat.CATEGORY_CALL);
    }

    public ConnectPlan(OkHttpClient okHttpClient, RealCall realCall, RealRoutePlanner realRoutePlanner, Route route2, List<Route> list, int i, Request request, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(okHttpClient, "client");
        Intrinsics.checkNotNullParameter(realCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(realRoutePlanner, "routePlanner");
        Intrinsics.checkNotNullParameter(route2, "route");
        this.client = okHttpClient;
        this.call = realCall;
        this.routePlanner = realRoutePlanner;
        this.route = route2;
        this.routes = list;
        this.attempt = i;
        this.tunnelRequest = request;
        this.connectionSpecIndex = i2;
        this.isTlsFallback = z;
        this.eventListener = realCall.getEventListener$okhttp();
    }

    public Route getRoute() {
        return this.route;
    }

    public final List<Route> getRoutes$okhttp() {
        return this.routes;
    }

    public final int getConnectionSpecIndex$okhttp() {
        return this.connectionSpecIndex;
    }

    public final boolean isTlsFallback$okhttp() {
        return this.isTlsFallback;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final void setSocket$okhttp(Socket socket2) {
        this.socket = socket2;
    }

    public boolean isReady() {
        return this.protocol != null;
    }

    static /* synthetic */ ConnectPlan copy$default(ConnectPlan connectPlan, int i, Request request, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = connectPlan.attempt;
        }
        if ((i3 & 2) != 0) {
            request = connectPlan.tunnelRequest;
        }
        if ((i3 & 4) != 0) {
            i2 = connectPlan.connectionSpecIndex;
        }
        if ((i3 & 8) != 0) {
            z = connectPlan.isTlsFallback;
        }
        return connectPlan.copy(i, request, i2, z);
    }

    private final ConnectPlan copy(int i, Request request, int i2, boolean z) {
        return new ConnectPlan(this.client, this.call, this.routePlanner, getRoute(), this.routes, i, request, i2, z);
    }

    public RoutePlanner.ConnectResult connectTcp() {
        Socket socket2;
        Socket socket3;
        boolean z = true;
        if (this.rawSocket == null) {
            this.call.getPlansToCancel$okhttp().add(this);
            try {
                this.eventListener.connectStart(this.call, getRoute().socketAddress(), getRoute().proxy());
                connectSocket();
                try {
                    RoutePlanner.ConnectResult connectResult = new RoutePlanner.ConnectResult(this, (RoutePlanner.Plan) null, (Throwable) null, 6, (DefaultConstructorMarker) null);
                    this.call.getPlansToCancel$okhttp().remove(this);
                    return connectResult;
                } catch (IOException e) {
                    e = e;
                    try {
                        this.eventListener.connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), (Protocol) null, e);
                        RoutePlanner.ConnectResult connectResult2 = new RoutePlanner.ConnectResult(this, (RoutePlanner.Plan) null, e, 2, (DefaultConstructorMarker) null);
                        this.call.getPlansToCancel$okhttp().remove(this);
                        if (!z && (socket3 = this.rawSocket) != null) {
                            _UtilJvmKt.closeQuietly(socket3);
                        }
                        return connectResult2;
                    } catch (Throwable th) {
                        th = th;
                        this.call.getPlansToCancel$okhttp().remove(this);
                        if (!z && (socket2 = this.rawSocket) != null) {
                            _UtilJvmKt.closeQuietly(socket2);
                        }
                        throw th;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                z = false;
                this.eventListener.connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), (Protocol) null, e);
                RoutePlanner.ConnectResult connectResult22 = new RoutePlanner.ConnectResult(this, (RoutePlanner.Plan) null, e, 2, (DefaultConstructorMarker) null);
                this.call.getPlansToCancel$okhttp().remove(this);
                _UtilJvmKt.closeQuietly(socket3);
                return connectResult22;
            } catch (Throwable th2) {
                th = th2;
                z = false;
                this.call.getPlansToCancel$okhttp().remove(this);
                _UtilJvmKt.closeQuietly(socket2);
                throw th;
            }
        } else {
            throw new IllegalStateException("TCP already connected".toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x018e A[Catch:{ all -> 0x0166 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01cb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.internal.connection.RoutePlanner.ConnectResult connectTlsEtc() {
        /*
            r20 = this;
            r1 = r20
            java.net.Socket r0 = r1.rawSocket
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            if (r0 == 0) goto L_0x01e6
            boolean r0 = r20.isReady()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x01da
            okhttp3.Route r0 = r20.getRoute()
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.connectionSpecs()
            okhttp3.internal.connection.RealCall r4 = r1.call
            java.util.concurrent.CopyOnWriteArrayList r4 = r4.getPlansToCancel$okhttp()
            java.util.Collection r4 = (java.util.Collection) r4
            r4.add(r1)
            r4 = 0
            okhttp3.Request r5 = r1.tunnelRequest     // Catch:{ IOException -> 0x0168 }
            if (r5 == 0) goto L_0x005a
            okhttp3.internal.connection.RoutePlanner$ConnectResult r5 = r20.connectTunnel$okhttp()     // Catch:{ IOException -> 0x0168 }
            okhttp3.internal.connection.RoutePlanner$Plan r6 = r5.getNextPlan()     // Catch:{ IOException -> 0x0168 }
            if (r6 != 0) goto L_0x0040
            java.lang.Throwable r6 = r5.getThrowable()     // Catch:{ IOException -> 0x0168 }
            if (r6 == 0) goto L_0x005a
        L_0x0040:
            okhttp3.internal.connection.RealCall r0 = r1.call
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.getPlansToCancel$okhttp()
            java.util.Collection r0 = (java.util.Collection) r0
            r0.remove(r1)
            java.net.Socket r0 = r1.socket
            if (r0 == 0) goto L_0x0052
            okhttp3.internal._UtilJvmKt.closeQuietly((java.net.Socket) r0)
        L_0x0052:
            java.net.Socket r0 = r1.rawSocket
            if (r0 == 0) goto L_0x0059
            okhttp3.internal._UtilJvmKt.closeQuietly((java.net.Socket) r0)
        L_0x0059:
            return r5
        L_0x005a:
            okhttp3.Route r5 = r20.getRoute()     // Catch:{ IOException -> 0x0168 }
            okhttp3.Address r5 = r5.address()     // Catch:{ IOException -> 0x0168 }
            javax.net.ssl.SSLSocketFactory r5 = r5.sslSocketFactory()     // Catch:{ IOException -> 0x0168 }
            if (r5 == 0) goto L_0x00d3
            okhttp3.EventListener r5 = r1.eventListener     // Catch:{ IOException -> 0x0168 }
            okhttp3.internal.connection.RealCall r6 = r1.call     // Catch:{ IOException -> 0x0168 }
            okhttp3.Call r6 = (okhttp3.Call) r6     // Catch:{ IOException -> 0x0168 }
            r5.secureConnectStart(r6)     // Catch:{ IOException -> 0x0168 }
            okhttp3.Route r5 = r20.getRoute()     // Catch:{ IOException -> 0x0168 }
            okhttp3.Address r5 = r5.address()     // Catch:{ IOException -> 0x0168 }
            javax.net.ssl.SSLSocketFactory r5 = r5.sslSocketFactory()     // Catch:{ IOException -> 0x0168 }
            java.net.Socket r6 = r1.rawSocket     // Catch:{ IOException -> 0x0168 }
            okhttp3.Route r7 = r20.getRoute()     // Catch:{ IOException -> 0x0168 }
            okhttp3.Address r7 = r7.address()     // Catch:{ IOException -> 0x0168 }
            okhttp3.HttpUrl r7 = r7.url()     // Catch:{ IOException -> 0x0168 }
            java.lang.String r7 = r7.host()     // Catch:{ IOException -> 0x0168 }
            okhttp3.Route r8 = r20.getRoute()     // Catch:{ IOException -> 0x0168 }
            okhttp3.Address r8 = r8.address()     // Catch:{ IOException -> 0x0168 }
            okhttp3.HttpUrl r8 = r8.url()     // Catch:{ IOException -> 0x0168 }
            int r8 = r8.port()     // Catch:{ IOException -> 0x0168 }
            java.net.Socket r5 = r5.createSocket(r6, r7, r8, r3)     // Catch:{ IOException -> 0x0168 }
            if (r5 == 0) goto L_0x00cb
            javax.net.ssl.SSLSocket r5 = (javax.net.ssl.SSLSocket) r5     // Catch:{ IOException -> 0x0168 }
            okhttp3.internal.connection.ConnectPlan r6 = r1.planWithCurrentOrInitialConnectionSpec$okhttp(r0, r5)     // Catch:{ IOException -> 0x0168 }
            int r7 = r6.connectionSpecIndex     // Catch:{ IOException -> 0x0168 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ IOException -> 0x0168 }
            okhttp3.ConnectionSpec r7 = (okhttp3.ConnectionSpec) r7     // Catch:{ IOException -> 0x0168 }
            okhttp3.internal.connection.ConnectPlan r8 = r6.nextConnectionSpec$okhttp(r0, r5)     // Catch:{ IOException -> 0x0168 }
            boolean r0 = r6.isTlsFallback     // Catch:{ IOException -> 0x0164 }
            r7.apply$okhttp(r5, r0)     // Catch:{ IOException -> 0x0164 }
            r1.connectTls(r5, r7)     // Catch:{ IOException -> 0x0164 }
            okhttp3.EventListener r0 = r1.eventListener     // Catch:{ IOException -> 0x0164 }
            okhttp3.internal.connection.RealCall r5 = r1.call     // Catch:{ IOException -> 0x0164 }
            okhttp3.Call r5 = (okhttp3.Call) r5     // Catch:{ IOException -> 0x0164 }
            okhttp3.Handshake r6 = r1.handshake     // Catch:{ IOException -> 0x0164 }
            r0.secureConnectEnd(r5, r6)     // Catch:{ IOException -> 0x0164 }
            goto L_0x00f3
        L_0x00cb:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ IOException -> 0x0168 }
            java.lang.String r3 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket"
            r0.<init>(r3)     // Catch:{ IOException -> 0x0168 }
            throw r0     // Catch:{ IOException -> 0x0168 }
        L_0x00d3:
            java.net.Socket r0 = r1.rawSocket     // Catch:{ IOException -> 0x0168 }
            r1.socket = r0     // Catch:{ IOException -> 0x0168 }
            okhttp3.Route r0 = r20.getRoute()     // Catch:{ IOException -> 0x0168 }
            okhttp3.Address r0 = r0.address()     // Catch:{ IOException -> 0x0168 }
            java.util.List r0 = r0.protocols()     // Catch:{ IOException -> 0x0168 }
            okhttp3.Protocol r5 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE     // Catch:{ IOException -> 0x0168 }
            boolean r0 = r0.contains(r5)     // Catch:{ IOException -> 0x0168 }
            if (r0 == 0) goto L_0x00ee
            okhttp3.Protocol r0 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE     // Catch:{ IOException -> 0x0168 }
            goto L_0x00f0
        L_0x00ee:
            okhttp3.Protocol r0 = okhttp3.Protocol.HTTP_1_1     // Catch:{ IOException -> 0x0168 }
        L_0x00f0:
            r1.protocol = r0     // Catch:{ IOException -> 0x0168 }
            r8 = r4
        L_0x00f3:
            okhttp3.internal.connection.RealConnection r0 = new okhttp3.internal.connection.RealConnection     // Catch:{ IOException -> 0x0164 }
            okhttp3.OkHttpClient r5 = r1.client     // Catch:{ IOException -> 0x0164 }
            okhttp3.internal.concurrent.TaskRunner r10 = r5.getTaskRunner$okhttp()     // Catch:{ IOException -> 0x0164 }
            okhttp3.OkHttpClient r5 = r1.client     // Catch:{ IOException -> 0x0164 }
            okhttp3.ConnectionPool r5 = r5.connectionPool()     // Catch:{ IOException -> 0x0164 }
            okhttp3.internal.connection.RealConnectionPool r11 = r5.getDelegate$okhttp()     // Catch:{ IOException -> 0x0164 }
            okhttp3.Route r12 = r20.getRoute()     // Catch:{ IOException -> 0x0164 }
            java.net.Socket r13 = r1.rawSocket     // Catch:{ IOException -> 0x0164 }
            java.net.Socket r14 = r1.socket     // Catch:{ IOException -> 0x0164 }
            okhttp3.Handshake r15 = r1.handshake     // Catch:{ IOException -> 0x0164 }
            okhttp3.Protocol r5 = r1.protocol     // Catch:{ IOException -> 0x0164 }
            okio.BufferedSource r6 = r1.source     // Catch:{ IOException -> 0x0164 }
            okio.BufferedSink r7 = r1.sink     // Catch:{ IOException -> 0x0164 }
            okhttp3.OkHttpClient r9 = r1.client     // Catch:{ IOException -> 0x0164 }
            int r19 = r9.pingIntervalMillis()     // Catch:{ IOException -> 0x0164 }
            r9 = r0
            r16 = r5
            r17 = r6
            r18 = r7
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ IOException -> 0x0164 }
            r1.connection = r0     // Catch:{ IOException -> 0x0164 }
            r0.start()     // Catch:{ IOException -> 0x0164 }
            okhttp3.EventListener r0 = r1.eventListener     // Catch:{ IOException -> 0x0164 }
            okhttp3.internal.connection.RealCall r5 = r1.call     // Catch:{ IOException -> 0x0164 }
            okhttp3.Call r5 = (okhttp3.Call) r5     // Catch:{ IOException -> 0x0164 }
            okhttp3.Route r6 = r20.getRoute()     // Catch:{ IOException -> 0x0164 }
            java.net.InetSocketAddress r6 = r6.socketAddress()     // Catch:{ IOException -> 0x0164 }
            okhttp3.Route r7 = r20.getRoute()     // Catch:{ IOException -> 0x0164 }
            java.net.Proxy r7 = r7.proxy()     // Catch:{ IOException -> 0x0164 }
            okhttp3.Protocol r9 = r1.protocol     // Catch:{ IOException -> 0x0164 }
            r0.connectEnd(r5, r6, r7, r9)     // Catch:{ IOException -> 0x0164 }
            okhttp3.internal.connection.RoutePlanner$ConnectResult r0 = new okhttp3.internal.connection.RoutePlanner$ConnectResult     // Catch:{ IOException -> 0x0161, all -> 0x015e }
            r11 = r1
            okhttp3.internal.connection.RoutePlanner$Plan r11 = (okhttp3.internal.connection.RoutePlanner.Plan) r11     // Catch:{ IOException -> 0x0161, all -> 0x015e }
            r12 = 0
            r13 = 0
            r14 = 6
            r15 = 0
            r10 = r0
            r10.<init>(r11, r12, r13, r14, r15)     // Catch:{ IOException -> 0x0161, all -> 0x015e }
            okhttp3.internal.connection.RealCall r2 = r1.call
            java.util.concurrent.CopyOnWriteArrayList r2 = r2.getPlansToCancel$okhttp()
            java.util.Collection r2 = (java.util.Collection) r2
            r2.remove(r1)
            return r0
        L_0x015e:
            r0 = move-exception
            r2 = 1
            goto L_0x01be
        L_0x0161:
            r0 = move-exception
            r2 = 1
            goto L_0x016a
        L_0x0164:
            r0 = move-exception
            goto L_0x016a
        L_0x0166:
            r0 = move-exception
            goto L_0x01be
        L_0x0168:
            r0 = move-exception
            r8 = r4
        L_0x016a:
            okhttp3.EventListener r9 = r1.eventListener     // Catch:{ all -> 0x0166 }
            okhttp3.internal.connection.RealCall r3 = r1.call     // Catch:{ all -> 0x0166 }
            r10 = r3
            okhttp3.Call r10 = (okhttp3.Call) r10     // Catch:{ all -> 0x0166 }
            okhttp3.Route r3 = r20.getRoute()     // Catch:{ all -> 0x0166 }
            java.net.InetSocketAddress r11 = r3.socketAddress()     // Catch:{ all -> 0x0166 }
            okhttp3.Route r3 = r20.getRoute()     // Catch:{ all -> 0x0166 }
            java.net.Proxy r12 = r3.proxy()     // Catch:{ all -> 0x0166 }
            r13 = 0
            r14 = r0
            r9.connectFailed(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0166 }
            okhttp3.OkHttpClient r3 = r1.client     // Catch:{ all -> 0x0166 }
            boolean r3 = r3.retryOnConnectionFailure()     // Catch:{ all -> 0x0166 }
            if (r3 == 0) goto L_0x0196
            boolean r3 = okhttp3.internal.connection.TlsHandshakeKt.retryTlsHandshake(r0)     // Catch:{ all -> 0x0166 }
            if (r3 != 0) goto L_0x0195
            goto L_0x0196
        L_0x0195:
            r4 = r8
        L_0x0196:
            okhttp3.internal.connection.RoutePlanner$ConnectResult r3 = new okhttp3.internal.connection.RoutePlanner$ConnectResult     // Catch:{ all -> 0x0166 }
            r5 = r1
            okhttp3.internal.connection.RoutePlanner$Plan r5 = (okhttp3.internal.connection.RoutePlanner.Plan) r5     // Catch:{ all -> 0x0166 }
            okhttp3.internal.connection.RoutePlanner$Plan r4 = (okhttp3.internal.connection.RoutePlanner.Plan) r4     // Catch:{ all -> 0x0166 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0166 }
            r3.<init>(r5, r4, r0)     // Catch:{ all -> 0x0166 }
            okhttp3.internal.connection.RealCall r0 = r1.call
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.getPlansToCancel$okhttp()
            java.util.Collection r0 = (java.util.Collection) r0
            r0.remove(r1)
            if (r2 != 0) goto L_0x01bd
            java.net.Socket r0 = r1.socket
            if (r0 == 0) goto L_0x01b6
            okhttp3.internal._UtilJvmKt.closeQuietly((java.net.Socket) r0)
        L_0x01b6:
            java.net.Socket r0 = r1.rawSocket
            if (r0 == 0) goto L_0x01bd
            okhttp3.internal._UtilJvmKt.closeQuietly((java.net.Socket) r0)
        L_0x01bd:
            return r3
        L_0x01be:
            okhttp3.internal.connection.RealCall r3 = r1.call
            java.util.concurrent.CopyOnWriteArrayList r3 = r3.getPlansToCancel$okhttp()
            java.util.Collection r3 = (java.util.Collection) r3
            r3.remove(r1)
            if (r2 != 0) goto L_0x01d9
            java.net.Socket r2 = r1.socket
            if (r2 == 0) goto L_0x01d2
            okhttp3.internal._UtilJvmKt.closeQuietly((java.net.Socket) r2)
        L_0x01d2:
            java.net.Socket r2 = r1.rawSocket
            if (r2 == 0) goto L_0x01d9
            okhttp3.internal._UtilJvmKt.closeQuietly((java.net.Socket) r2)
        L_0x01d9:
            throw r0
        L_0x01da:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "already connected"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x01e6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "TCP not connected"
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ConnectPlan.connectTlsEtc():okhttp3.internal.connection.RoutePlanner$ConnectResult");
    }

    private final void connectSocket() throws IOException {
        Socket socket2;
        Proxy.Type type = getRoute().proxy().type();
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1 || i == 2) {
            socket2 = getRoute().address().socketFactory().createSocket();
            Intrinsics.checkNotNull(socket2);
        } else {
            socket2 = new Socket(getRoute().proxy());
        }
        this.rawSocket = socket2;
        if (!this.canceled) {
            socket2.setSoTimeout(this.client.readTimeoutMillis());
            try {
                Platform.Companion.get().connectSocket(socket2, getRoute().socketAddress(), this.client.connectTimeoutMillis());
                try {
                    this.source = Okio.buffer(Okio.source(socket2));
                    this.sink = Okio.buffer(Okio.sink(socket2));
                } catch (NullPointerException e) {
                    if (Intrinsics.areEqual((Object) e.getMessage(), (Object) NPE_THROW_WITH_NULL)) {
                        throw new IOException(e);
                    }
                }
            } catch (ConnectException e2) {
                ConnectException connectException = new ConnectException("Failed to connect to " + getRoute().socketAddress());
                connectException.initCause(e2);
                throw connectException;
            }
        } else {
            throw new IOException("canceled");
        }
    }

    public final RoutePlanner.ConnectResult connectTunnel$okhttp() throws IOException {
        Request createTunnel = createTunnel();
        if (createTunnel == null) {
            return new RoutePlanner.ConnectResult(this, (RoutePlanner.Plan) null, (Throwable) null, 6, (DefaultConstructorMarker) null);
        }
        Socket socket2 = this.rawSocket;
        if (socket2 != null) {
            _UtilJvmKt.closeQuietly(socket2);
        }
        int i = this.attempt + 1;
        if (i < 21) {
            this.eventListener.connectEnd(this.call, getRoute().socketAddress(), getRoute().proxy(), (Protocol) null);
            return new RoutePlanner.ConnectResult(this, copy$default(this, i, createTunnel, 0, false, 12, (Object) null), (Throwable) null, 4, (DefaultConstructorMarker) null);
        }
        ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
        this.eventListener.connectFailed(this.call, getRoute().socketAddress(), getRoute().proxy(), (Protocol) null, protocolException);
        return new RoutePlanner.ConnectResult(this, (RoutePlanner.Plan) null, protocolException, 2, (DefaultConstructorMarker) null);
    }

    private final void connectTls(SSLSocket sSLSocket, ConnectionSpec connectionSpec) throws IOException {
        String str;
        Address address = getRoute().address();
        try {
            if (connectionSpec.supportsTlsExtensions()) {
                Platform.Companion.get().configureTlsExtensions(sSLSocket, address.url().host(), address.protocols());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            Handshake.Companion companion = Handshake.Companion;
            Intrinsics.checkNotNullExpressionValue(session, "sslSocketSession");
            Handshake handshake2 = companion.get(session);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier();
            Intrinsics.checkNotNull(hostnameVerifier);
            if (!hostnameVerifier.verify(address.url().host(), session)) {
                List<Certificate> peerCertificates = handshake2.peerCertificates();
                if (!peerCertificates.isEmpty()) {
                    X509Certificate x509Certificate = (X509Certificate) peerCertificates.get(0);
                    throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n            |Hostname " + address.url().host() + " not verified:\n            |    certificate: " + CertificatePinner.Companion.pin(x509Certificate) + "\n            |    DN: " + x509Certificate.getSubjectDN().getName() + "\n            |    subjectAltNames: " + OkHostnameVerifier.INSTANCE.allSubjectAltNames(x509Certificate) + "\n            ", (String) null, 1, (Object) null));
                }
                throw new SSLPeerUnverifiedException("Hostname " + address.url().host() + " not verified (no certificates)");
            }
            CertificatePinner certificatePinner = address.certificatePinner();
            Intrinsics.checkNotNull(certificatePinner);
            Handshake handshake3 = new Handshake(handshake2.tlsVersion(), handshake2.cipherSuite(), handshake2.localCertificates(), new ConnectPlan$connectTls$handshake$1(certificatePinner, handshake2, address));
            this.handshake = handshake3;
            certificatePinner.check$okhttp(address.url().host(), new ConnectPlan$connectTls$1(handshake3));
            if (connectionSpec.supportsTlsExtensions()) {
                str = Platform.Companion.get().getSelectedProtocol(sSLSocket);
            } else {
                str = null;
            }
            this.socket = sSLSocket;
            this.source = Okio.buffer(Okio.source((Socket) sSLSocket));
            this.sink = Okio.buffer(Okio.sink((Socket) sSLSocket));
            this.protocol = str != null ? Protocol.Companion.get(str) : Protocol.HTTP_1_1;
            Platform.Companion.get().afterHandshake(sSLSocket);
        } catch (Throwable th) {
            Platform.Companion.get().afterHandshake(sSLSocket);
            _UtilJvmKt.closeQuietly((Socket) sSLSocket);
            throw th;
        }
    }

    private final Request createTunnel() throws IOException {
        Request request = this.tunnelRequest;
        Intrinsics.checkNotNull(request);
        HttpUrl url = getRoute().address().url();
        String str = "CONNECT " + _UtilJvmKt.toHostHeader(url, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.source;
            Intrinsics.checkNotNull(bufferedSource);
            BufferedSink bufferedSink = this.sink;
            Intrinsics.checkNotNull(bufferedSink);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec((OkHttpClient) null, this, bufferedSource, bufferedSink);
            bufferedSource.timeout().timeout((long) this.client.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            bufferedSink.timeout().timeout((long) this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response.Builder readResponseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            Intrinsics.checkNotNull(readResponseHeaders);
            Response build = readResponseHeaders.request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = getRoute().address().proxyAuthenticator().authenticate(getRoute(), build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (StringsKt.equals("close", Response.header$default(build, "Connection", (String) null, 2, (Object) null), true)) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (bufferedSource.getBuffer().exhausted() && bufferedSink.getBuffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    public final ConnectPlan planWithCurrentOrInitialConnectionSpec$okhttp(List<ConnectionSpec> list, SSLSocket sSLSocket) throws IOException {
        Intrinsics.checkNotNullParameter(list, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        if (this.connectionSpecIndex != -1) {
            return this;
        }
        ConnectPlan nextConnectionSpec$okhttp = nextConnectionSpec$okhttp(list, sSLSocket);
        if (nextConnectionSpec$okhttp != null) {
            return nextConnectionSpec$okhttp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unable to find acceptable protocols. isFallback=");
        sb.append(this.isTlsFallback);
        sb.append(", modes=");
        sb.append(list);
        sb.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        Intrinsics.checkNotNull(enabledProtocols);
        String arrays = Arrays.toString(enabledProtocols);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb.append(arrays);
        throw new UnknownServiceException(sb.toString());
    }

    public final ConnectPlan nextConnectionSpec$okhttp(List<ConnectionSpec> list, SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter(list, "connectionSpecs");
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        int size = list.size();
        for (int i = this.connectionSpecIndex + 1; i < size; i++) {
            if (list.get(i).isCompatible(sSLSocket)) {
                return copy$default(this, 0, (Request) null, i, this.connectionSpecIndex != -1, 3, (Object) null);
            }
        }
        return null;
    }

    public RealConnection handleSuccess() {
        this.call.getClient().getRouteDatabase$okhttp().connected(getRoute());
        ReusePlan planReusePooledConnection$okhttp = this.routePlanner.planReusePooledConnection$okhttp(this, this.routes);
        if (planReusePooledConnection$okhttp != null) {
            return planReusePooledConnection$okhttp.getConnection();
        }
        RealConnection realConnection = this.connection;
        Intrinsics.checkNotNull(realConnection);
        synchronized (realConnection) {
            this.client.connectionPool().getDelegate$okhttp().put(realConnection);
            this.call.acquireConnectionNoEvents(realConnection);
            Unit unit = Unit.INSTANCE;
        }
        this.eventListener.connectionAcquired(this.call, realConnection);
        return realConnection;
    }

    public void cancel() {
        this.canceled = true;
        Socket socket2 = this.rawSocket;
        if (socket2 != null) {
            _UtilJvmKt.closeQuietly(socket2);
        }
    }

    public RoutePlanner.Plan retry() {
        return new ConnectPlan(this.client, this.call, this.routePlanner, getRoute(), this.routes, this.attempt, this.tunnelRequest, this.connectionSpecIndex, this.isTlsFallback);
    }

    public final void closeQuietly() {
        Socket socket2 = this.socket;
        if (socket2 != null) {
            _UtilJvmKt.closeQuietly(socket2);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lokhttp3/internal/connection/ConnectPlan$Companion;", "", "()V", "MAX_TUNNEL_ATTEMPTS", "", "NPE_THROW_WITH_NULL", "", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ConnectPlan.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
