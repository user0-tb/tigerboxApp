package p009j$.util.stream;

import p009j$.util.LongSummaryStatistics;
import p009j$.util.function.BiConsumer;

/* renamed from: j$.util.stream.LongPipeline$$ExternalSyntheticLambda0 */
public final /* synthetic */ class LongPipeline$$ExternalSyntheticLambda0 implements BiConsumer {
    public static final /* synthetic */ LongPipeline$$ExternalSyntheticLambda0 INSTANCE = new LongPipeline$$ExternalSyntheticLambda0();

    private /* synthetic */ LongPipeline$$ExternalSyntheticLambda0() {
    }

    public final void accept(Object obj, Object obj2) {
        ((LongSummaryStatistics) obj).combine((LongSummaryStatistics) obj2);
    }
}
