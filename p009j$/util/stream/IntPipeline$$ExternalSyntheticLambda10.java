package p009j$.util.stream;

import p009j$.util.IntSummaryStatistics;
import p009j$.util.function.ObjIntConsumer;

/* renamed from: j$.util.stream.IntPipeline$$ExternalSyntheticLambda10 */
public final /* synthetic */ class IntPipeline$$ExternalSyntheticLambda10 implements ObjIntConsumer {
    public static final /* synthetic */ IntPipeline$$ExternalSyntheticLambda10 INSTANCE = new IntPipeline$$ExternalSyntheticLambda10();

    private /* synthetic */ IntPipeline$$ExternalSyntheticLambda10() {
    }

    public final void accept(Object obj, int i) {
        ((IntSummaryStatistics) obj).accept(i);
    }
}
