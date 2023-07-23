package p009j$.util.stream;

import p009j$.util.DoubleSummaryStatistics;
import p009j$.util.function.ObjDoubleConsumer;

/* renamed from: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda10 */
public final /* synthetic */ class DoublePipeline$$ExternalSyntheticLambda10 implements ObjDoubleConsumer {
    public static final /* synthetic */ DoublePipeline$$ExternalSyntheticLambda10 INSTANCE = new DoublePipeline$$ExternalSyntheticLambda10();

    private /* synthetic */ DoublePipeline$$ExternalSyntheticLambda10() {
    }

    public final void accept(Object obj, double d) {
        ((DoubleSummaryStatistics) obj).accept(d);
    }
}
