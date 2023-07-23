package p009j$.util.stream;

import p009j$.util.function.ObjDoubleConsumer;

/* renamed from: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda12 */
public final /* synthetic */ class DoublePipeline$$ExternalSyntheticLambda12 implements ObjDoubleConsumer {
    public static final /* synthetic */ DoublePipeline$$ExternalSyntheticLambda12 INSTANCE = new DoublePipeline$$ExternalSyntheticLambda12();

    private /* synthetic */ DoublePipeline$$ExternalSyntheticLambda12() {
    }

    public final void accept(Object obj, double d) {
        double[] dArr = (double[]) obj;
        Collectors.sumWithCompensation(dArr, d);
        dArr[2] = dArr[2] + d;
    }
}
