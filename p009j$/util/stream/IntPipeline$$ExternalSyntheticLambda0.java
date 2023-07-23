package p009j$.util.stream;

import p009j$.util.IntSummaryStatistics;
import p009j$.util.function.BiConsumer;

/* renamed from: j$.util.stream.IntPipeline$$ExternalSyntheticLambda0 */
public final /* synthetic */ class IntPipeline$$ExternalSyntheticLambda0 implements BiConsumer {
    public static final /* synthetic */ IntPipeline$$ExternalSyntheticLambda0 INSTANCE = new IntPipeline$$ExternalSyntheticLambda0();

    private /* synthetic */ IntPipeline$$ExternalSyntheticLambda0() {
    }

    public final void accept(Object obj, Object obj2) {
        ((IntSummaryStatistics) obj).combine((IntSummaryStatistics) obj2);
    }
}
