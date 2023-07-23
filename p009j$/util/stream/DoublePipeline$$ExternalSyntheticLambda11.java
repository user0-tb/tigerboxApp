package p009j$.util.stream;

import p009j$.util.function.ObjDoubleConsumer;

/* renamed from: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda11 */
public final /* synthetic */ class DoublePipeline$$ExternalSyntheticLambda11 implements ObjDoubleConsumer {
    public static final /* synthetic */ DoublePipeline$$ExternalSyntheticLambda11 INSTANCE = new DoublePipeline$$ExternalSyntheticLambda11();

    private /* synthetic */ DoublePipeline$$ExternalSyntheticLambda11() {
    }

    public final void accept(Object obj, double d) {
        double[] dArr = (double[]) obj;
        dArr[2] = dArr[2] + 1.0d;
        Collectors.sumWithCompensation(dArr, d);
        dArr[3] = dArr[3] + d;
    }
}
