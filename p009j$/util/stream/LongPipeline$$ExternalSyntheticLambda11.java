package p009j$.util.stream;

import p009j$.util.function.ObjLongConsumer;

/* renamed from: j$.util.stream.LongPipeline$$ExternalSyntheticLambda11 */
public final /* synthetic */ class LongPipeline$$ExternalSyntheticLambda11 implements ObjLongConsumer {
    public static final /* synthetic */ LongPipeline$$ExternalSyntheticLambda11 INSTANCE = new LongPipeline$$ExternalSyntheticLambda11();

    private /* synthetic */ LongPipeline$$ExternalSyntheticLambda11() {
    }

    public final void accept(Object obj, long j) {
        long[] jArr = (long[]) obj;
        jArr[0] = jArr[0] + 1;
        jArr[1] = jArr[1] + j;
    }
}
