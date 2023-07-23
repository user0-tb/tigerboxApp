package p009j$.util.stream;

import p009j$.util.function.BiConsumer;

/* renamed from: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda2 */
public final /* synthetic */ class DoublePipeline$$ExternalSyntheticLambda2 implements BiConsumer {
    public static final /* synthetic */ DoublePipeline$$ExternalSyntheticLambda2 INSTANCE = new DoublePipeline$$ExternalSyntheticLambda2();

    private /* synthetic */ DoublePipeline$$ExternalSyntheticLambda2() {
    }

    public final void accept(Object obj, Object obj2) {
        double[] dArr = (double[]) obj;
        double[] dArr2 = (double[]) obj2;
        Collectors.sumWithCompensation(dArr, dArr2[0]);
        Collectors.sumWithCompensation(dArr, dArr2[1]);
        dArr[2] = dArr[2] + dArr2[2];
    }
}
