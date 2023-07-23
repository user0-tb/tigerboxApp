package p009j$.util.stream;

import p009j$.util.function.ObjIntConsumer;

/* renamed from: j$.util.stream.IntPipeline$$ExternalSyntheticLambda11 */
public final /* synthetic */ class IntPipeline$$ExternalSyntheticLambda11 implements ObjIntConsumer {
    public static final /* synthetic */ IntPipeline$$ExternalSyntheticLambda11 INSTANCE = new IntPipeline$$ExternalSyntheticLambda11();

    private /* synthetic */ IntPipeline$$ExternalSyntheticLambda11() {
    }

    public final void accept(Object obj, int i) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + ((long) i);
    }
}
