package media.tiger.tigerbox.p016ui.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.common.TimedRefreshHandler$startAfterDelay$1", mo34424f = "TimedRefreshHandler.kt", mo34425i = {0, 0, 0, 1, 1, 1}, mo34426l = {32, 34}, mo34427m = "invokeSuspend", mo34428n = {"$this$flow", "intervalDelay", "counter", "$this$flow", "intervalDelay", "counter"}, mo34429s = {"L$0", "J$0", "I$0", "L$0", "J$0", "I$0"})
/* renamed from: media.tiger.tigerbox.ui.common.TimedRefreshHandler$startAfterDelay$1 */
/* compiled from: TimedRefreshHandler.kt */
final class TimedRefreshHandler$startAfterDelay$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayIncreasePerLoop;
    final /* synthetic */ int $executionCount;
    final /* synthetic */ long $initialDelay;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimedRefreshHandler$startAfterDelay$1(long j, int i, long j2, Continuation<? super TimedRefreshHandler$startAfterDelay$1> continuation) {
        super(2, continuation);
        this.$initialDelay = j;
        this.$executionCount = i;
        this.$delayIncreasePerLoop = j2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TimedRefreshHandler$startAfterDelay$1 timedRefreshHandler$startAfterDelay$1 = new TimedRefreshHandler$startAfterDelay$1(this.$initialDelay, this.$executionCount, this.$delayIncreasePerLoop, continuation);
        timedRefreshHandler$startAfterDelay$1.L$0 = obj;
        return timedRefreshHandler$startAfterDelay$1;
    }

    public final Object invoke(FlowCollector<? super Integer> flowCollector, Continuation<? super Unit> continuation) {
        return ((TimedRefreshHandler$startAfterDelay$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            int r1 = r9.I$0
            long r4 = r9.J$0
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r6
            r6 = r9
            goto L_0x0069
        L_0x001c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0024:
            int r1 = r9.I$0
            long r4 = r9.J$0
            java.lang.Object r6 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r6
            r6 = r9
            goto L_0x0050
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            long r4 = r9.$initialDelay
            int r1 = r9.$executionCount
            r6 = r9
        L_0x003e:
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.L$0 = r10
            r6.J$0 = r4
            r6.I$0 = r1
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.DelayKt.delay(r4, r7)
            if (r7 != r0) goto L_0x0050
            return r0
        L_0x0050:
            long r7 = r6.$delayIncreasePerLoop
            long r4 = r4 + r7
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r8 = r6
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r6.L$0 = r10
            r6.J$0 = r4
            r6.I$0 = r1
            r6.label = r2
            java.lang.Object r7 = r10.emit(r7, r8)
            if (r7 != r0) goto L_0x0069
            return r0
        L_0x0069:
            if (r1 <= 0) goto L_0x006d
            int r1 = r1 + -1
        L_0x006d:
            if (r1 != 0) goto L_0x003e
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.common.TimedRefreshHandler$startAfterDelay$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
