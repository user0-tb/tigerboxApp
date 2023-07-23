package p009j$.util.stream;

import p009j$.util.function.BiConsumer;

/* renamed from: j$.util.stream.LongPipeline$$ExternalSyntheticLambda1 */
public final /* synthetic */ class LongPipeline$$ExternalSyntheticLambda1 implements BiConsumer {
    public static final /* synthetic */ LongPipeline$$ExternalSyntheticLambda1 INSTANCE = new LongPipeline$$ExternalSyntheticLambda1();

    private /* synthetic */ LongPipeline$$ExternalSyntheticLambda1() {
    }

    public final void accept(Object obj, Object obj2) {
        long[] jArr = (long[]) obj;
        long[] jArr2 = (long[]) obj2;
        jArr[0] = jArr[0] + jArr2[0];
        jArr[1] = jArr[1] + jArr2[1];
    }
}
