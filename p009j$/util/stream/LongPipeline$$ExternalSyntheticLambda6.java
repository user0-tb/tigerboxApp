package p009j$.util.stream;

import p009j$.util.function.LongBinaryOperator;

/* renamed from: j$.util.stream.LongPipeline$$ExternalSyntheticLambda6 */
public final /* synthetic */ class LongPipeline$$ExternalSyntheticLambda6 implements LongBinaryOperator {
    public static final /* synthetic */ LongPipeline$$ExternalSyntheticLambda6 INSTANCE = new LongPipeline$$ExternalSyntheticLambda6();

    private /* synthetic */ LongPipeline$$ExternalSyntheticLambda6() {
    }

    public final long applyAsLong(long j, long j2) {
        return Math.min(j, j2);
    }
}
