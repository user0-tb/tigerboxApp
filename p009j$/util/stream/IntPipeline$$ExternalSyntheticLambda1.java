package p009j$.util.stream;

import p009j$.util.function.BiConsumer;

/* renamed from: j$.util.stream.IntPipeline$$ExternalSyntheticLambda1 */
public final /* synthetic */ class IntPipeline$$ExternalSyntheticLambda1 implements BiConsumer {
    public static final /* synthetic */ IntPipeline$$ExternalSyntheticLambda1 INSTANCE = new IntPipeline$$ExternalSyntheticLambda1();

    private /* synthetic */ IntPipeline$$ExternalSyntheticLambda1() {
    }

    public final void accept(Object obj, Object obj2) {
        long[] jArr = (long[]) obj;
        long[] jArr2 = (long[]) obj2;
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
    }
}
