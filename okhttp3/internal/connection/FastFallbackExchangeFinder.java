package okhttp3.internal.connection;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RoutePlanner;

@Metadata(mo33736d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo33737d2 = {"Lokhttp3/internal/connection/FastFallbackExchangeFinder;", "Lokhttp3/internal/connection/ExchangeFinder;", "routePlanner", "Lokhttp3/internal/connection/RoutePlanner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(Lokhttp3/internal/connection/RoutePlanner;Lokhttp3/internal/concurrent/TaskRunner;)V", "connectDelayNanos", "", "connectResults", "Ljava/util/concurrent/BlockingQueue;", "Lokhttp3/internal/connection/RoutePlanner$ConnectResult;", "kotlin.jvm.PlatformType", "nextTcpConnectAtNanos", "getRoutePlanner", "()Lokhttp3/internal/connection/RoutePlanner;", "tcpConnectsInFlight", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lokhttp3/internal/connection/RoutePlanner$Plan;", "awaitTcpConnect", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "cancelInFlightConnects", "", "find", "Lokhttp3/internal/connection/RealConnection;", "launchTcpConnect", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: FastFallbackExchangeFinder.kt */
public final class FastFallbackExchangeFinder implements ExchangeFinder {
    private final long connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250);
    /* access modifiers changed from: private */
    public final BlockingQueue<RoutePlanner.ConnectResult> connectResults;
    private long nextTcpConnectAtNanos = Long.MIN_VALUE;
    private final RoutePlanner routePlanner;
    private final TaskRunner taskRunner;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<RoutePlanner.Plan> tcpConnectsInFlight = new CopyOnWriteArrayList<>();

    public FastFallbackExchangeFinder(RoutePlanner routePlanner2, TaskRunner taskRunner2) {
        Intrinsics.checkNotNullParameter(routePlanner2, "routePlanner");
        Intrinsics.checkNotNullParameter(taskRunner2, "taskRunner");
        this.routePlanner = routePlanner2;
        this.taskRunner = taskRunner2;
        this.connectResults = taskRunner2.getBackend().decorate(new LinkedBlockingDeque());
    }

    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[Catch:{ all -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d A[Catch:{ all -> 0x00be }, PHI: r4 
      PHI: (r4v3 okhttp3.internal.connection.RoutePlanner$ConnectResult) = (r4v2 okhttp3.internal.connection.RoutePlanner$ConnectResult), (r4v7 okhttp3.internal.connection.RoutePlanner$ConnectResult) binds: [B:18:0x0052, B:20:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.internal.connection.RealConnection find() {
        /*
            r9 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.util.concurrent.CopyOnWriteArrayList<okhttp3.internal.connection.RoutePlanner$Plan> r2 = r9.tcpConnectsInFlight     // Catch:{ all -> 0x00be }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x00be }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00be }
            r3 = 1
            r2 = r2 ^ r3
            if (r2 != 0) goto L_0x0020
            okhttp3.internal.connection.RoutePlanner r2 = r9.getRoutePlanner()     // Catch:{ all -> 0x00be }
            boolean r2 = okhttp3.internal.connection.RoutePlanner.DefaultImpls.hasNext$default(r2, r0, r3, r0)     // Catch:{ all -> 0x00be }
            if (r2 == 0) goto L_0x0019
            goto L_0x0020
        L_0x0019:
            r9.cancelInFlightConnects()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            throw r1
        L_0x0020:
            okhttp3.internal.connection.RoutePlanner r2 = r9.getRoutePlanner()     // Catch:{ all -> 0x00be }
            boolean r2 = r2.isCanceled()     // Catch:{ all -> 0x00be }
            if (r2 != 0) goto L_0x00b6
            okhttp3.internal.concurrent.TaskRunner r2 = r9.taskRunner     // Catch:{ all -> 0x00be }
            okhttp3.internal.concurrent.TaskRunner$Backend r2 = r2.getBackend()     // Catch:{ all -> 0x00be }
            long r2 = r2.nanoTime()     // Catch:{ all -> 0x00be }
            long r4 = r9.nextTcpConnectAtNanos     // Catch:{ all -> 0x00be }
            long r4 = r4 - r2
            java.util.concurrent.CopyOnWriteArrayList<okhttp3.internal.connection.RoutePlanner$Plan> r6 = r9.tcpConnectsInFlight     // Catch:{ all -> 0x00be }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x00be }
            if (r6 != 0) goto L_0x0049
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            r5 = r4
            r4 = r0
            goto L_0x0052
        L_0x0049:
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r9.launchTcpConnect()     // Catch:{ all -> 0x00be }
            long r5 = r9.connectDelayNanos     // Catch:{ all -> 0x00be }
            long r2 = r2 + r5
            r9.nextTcpConnectAtNanos = r2     // Catch:{ all -> 0x00be }
        L_0x0052:
            if (r4 != 0) goto L_0x005d
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x00be }
            okhttp3.internal.connection.RoutePlanner$ConnectResult r4 = r9.awaitTcpConnect(r5, r2)     // Catch:{ all -> 0x00be }
            if (r4 != 0) goto L_0x005d
            goto L_0x0002
        L_0x005d:
            boolean r2 = r4.isSuccess()     // Catch:{ all -> 0x00be }
            if (r2 == 0) goto L_0x008b
            r9.cancelInFlightConnects()     // Catch:{ all -> 0x00be }
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getPlan()     // Catch:{ all -> 0x00be }
            boolean r2 = r2.isReady()     // Catch:{ all -> 0x00be }
            if (r2 != 0) goto L_0x0079
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getPlan()     // Catch:{ all -> 0x00be }
            okhttp3.internal.connection.RoutePlanner$ConnectResult r2 = r2.connectTlsEtc()     // Catch:{ all -> 0x00be }
            r4 = r2
        L_0x0079:
            boolean r2 = r4.isSuccess()     // Catch:{ all -> 0x00be }
            if (r2 == 0) goto L_0x008b
            okhttp3.internal.connection.RoutePlanner$Plan r0 = r4.getPlan()     // Catch:{ all -> 0x00be }
            okhttp3.internal.connection.RealConnection r0 = r0.handleSuccess()     // Catch:{ all -> 0x00be }
            r9.cancelInFlightConnects()
            return r0
        L_0x008b:
            java.lang.Throwable r2 = r4.getThrowable()     // Catch:{ all -> 0x00be }
            if (r2 == 0) goto L_0x00a3
            boolean r3 = r2 instanceof java.io.IOException     // Catch:{ all -> 0x00be }
            if (r3 == 0) goto L_0x00a2
            if (r1 != 0) goto L_0x009b
            java.io.IOException r2 = (java.io.IOException) r2     // Catch:{ all -> 0x00be }
            r1 = r2
            goto L_0x00a3
        L_0x009b:
            r3 = r1
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x00be }
            kotlin.ExceptionsKt.addSuppressed(r3, r2)     // Catch:{ all -> 0x00be }
            goto L_0x00a3
        L_0x00a2:
            throw r2     // Catch:{ all -> 0x00be }
        L_0x00a3:
            okhttp3.internal.connection.RoutePlanner$Plan r2 = r4.getNextPlan()     // Catch:{ all -> 0x00be }
            if (r2 == 0) goto L_0x0002
            okhttp3.internal.connection.RoutePlanner r3 = r9.getRoutePlanner()     // Catch:{ all -> 0x00be }
            kotlin.collections.ArrayDeque r3 = r3.getDeferredPlans()     // Catch:{ all -> 0x00be }
            r3.addFirst(r2)     // Catch:{ all -> 0x00be }
            goto L_0x0002
        L_0x00b6:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00be }
            java.lang.String r1 = "Canceled"
            r0.<init>(r1)     // Catch:{ all -> 0x00be }
            throw r0     // Catch:{ all -> 0x00be }
        L_0x00be:
            r0 = move-exception
            r9.cancelInFlightConnects()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.FastFallbackExchangeFinder.find():okhttp3.internal.connection.RealConnection");
    }

    private final RoutePlanner.ConnectResult launchTcpConnect() {
        RoutePlanner.Plan plan;
        if (RoutePlanner.DefaultImpls.hasNext$default(getRoutePlanner(), (RealConnection) null, 1, (Object) null)) {
            try {
                plan = getRoutePlanner().plan();
            } catch (Throwable th) {
                plan = new FailedPlan(th);
            }
            RoutePlanner.Plan plan2 = plan;
            if (plan2.isReady()) {
                return new RoutePlanner.ConnectResult(plan2, (RoutePlanner.Plan) null, (Throwable) null, 6, (DefaultConstructorMarker) null);
            }
            if (plan2 instanceof FailedPlan) {
                return ((FailedPlan) plan2).getResult();
            }
            this.tcpConnectsInFlight.add(plan2);
            TaskQueue.schedule$default(this.taskRunner.newQueue(), new FastFallbackExchangeFinder$launchTcpConnect$1(_UtilJvmKt.okHttpName + " connect " + getRoutePlanner().getAddress().url().redact(), plan2, this), 0, 2, (Object) null);
        }
        return null;
    }

    private final RoutePlanner.ConnectResult awaitTcpConnect(long j, TimeUnit timeUnit) {
        RoutePlanner.ConnectResult poll;
        if (this.tcpConnectsInFlight.isEmpty() || (poll = this.connectResults.poll(j, timeUnit)) == null) {
            return null;
        }
        this.tcpConnectsInFlight.remove(poll.getPlan());
        return poll;
    }

    private final void cancelInFlightConnects() {
        Iterator<RoutePlanner.Plan> it = this.tcpConnectsInFlight.iterator();
        while (it.hasNext()) {
            RoutePlanner.Plan next = it.next();
            next.cancel();
            RoutePlanner.Plan retry = next.retry();
            if (retry != null) {
                getRoutePlanner().getDeferredPlans().addLast(retry);
            }
        }
        this.tcpConnectsInFlight.clear();
    }
}
