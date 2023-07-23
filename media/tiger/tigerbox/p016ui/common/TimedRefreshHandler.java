package media.tiger.tigerbox.p016ui.common;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0007J(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0007¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/TimedRefreshHandler;", "", "()V", "startAfterDelay", "Lkotlinx/coroutines/flow/Flow;", "", "initialDelay", "", "executionCount", "delayIncreasePerLoop", "startImmediately", "intervalDelay", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.TimedRefreshHandler */
/* compiled from: TimedRefreshHandler.kt */
public final class TimedRefreshHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int INFINITE_LOOPS = -1;

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/TimedRefreshHandler$Companion;", "", "()V", "INFINITE_LOOPS", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.TimedRefreshHandler$Companion */
    /* compiled from: TimedRefreshHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ Flow startImmediately$default(TimedRefreshHandler timedRefreshHandler, long j, int i, long j2, int i2, Object obj) {
        int i3 = (i2 & 2) != 0 ? -1 : i;
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        return timedRefreshHandler.startImmediately(j, i3, j2);
    }

    public final Flow<Integer> startImmediately(long j, int i, long j2) {
        return FlowKt.flow(new TimedRefreshHandler$startImmediately$1(j, i, j2, (Continuation<? super TimedRefreshHandler$startImmediately$1>) null));
    }

    public static /* synthetic */ Flow startAfterDelay$default(TimedRefreshHandler timedRefreshHandler, long j, int i, long j2, int i2, Object obj) {
        int i3 = (i2 & 2) != 0 ? -1 : i;
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        return timedRefreshHandler.startAfterDelay(j, i3, j2);
    }

    public final Flow<Integer> startAfterDelay(long j, int i, long j2) {
        return FlowKt.flow(new TimedRefreshHandler$startAfterDelay$1(j, i, j2, (Continuation<? super TimedRefreshHandler$startAfterDelay$1>) null));
    }
}
