package p009j$.util.stream;

import p009j$.util.LongSummaryStatistics;
import p009j$.util.function.ObjLongConsumer;

/* renamed from: j$.util.stream.LongPipeline$$ExternalSyntheticLambda10 */
public final /* synthetic */ class LongPipeline$$ExternalSyntheticLambda10 implements ObjLongConsumer {
    public static final /* synthetic */ LongPipeline$$ExternalSyntheticLambda10 INSTANCE = new LongPipeline$$ExternalSyntheticLambda10();

    private /* synthetic */ LongPipeline$$ExternalSyntheticLambda10() {
    }

    public final void accept(Object obj, long j) {
        ((LongSummaryStatistics) obj).accept(j);
    }
}
