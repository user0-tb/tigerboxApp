package p009j$.util.stream;

import p009j$.util.function.BiConsumer;

/* renamed from: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda1 */
public final /* synthetic */ class DoublePipeline$$ExternalSyntheticLambda1 implements BiConsumer {
    public static final /* synthetic */ DoublePipeline$$ExternalSyntheticLambda1 INSTANCE = new DoublePipeline$$ExternalSyntheticLambda1();

    private /* synthetic */ DoublePipeline$$ExternalSyntheticLambda1() {
    }

    public final void accept(Object obj, Object obj2) {
        double[] dArr = (double[]) obj;
        double[] dArr2 = (double[]) obj2;
        Collectors.sumWithCompensation(dArr, dArr2[0]);
        Collectors.sumWithCompensation(dArr, dArr2[1]);
        dArr[2] = dArr[2] + dArr2[2];
        dArr[3] = dArr[3] + dArr2[3];
    }
}
