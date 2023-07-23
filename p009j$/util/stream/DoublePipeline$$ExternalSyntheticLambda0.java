package p009j$.util.stream;

import p009j$.util.DoubleSummaryStatistics;
import p009j$.util.function.BiConsumer;

/* renamed from: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda0 */
public final /* synthetic */ class DoublePipeline$$ExternalSyntheticLambda0 implements BiConsumer {
    public static final /* synthetic */ DoublePipeline$$ExternalSyntheticLambda0 INSTANCE = new DoublePipeline$$ExternalSyntheticLambda0();

    private /* synthetic */ DoublePipeline$$ExternalSyntheticLambda0() {
    }

    public final void accept(Object obj, Object obj2) {
        ((DoubleSummaryStatistics) obj).combine((DoubleSummaryStatistics) obj2);
    }
}
