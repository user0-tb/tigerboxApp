package p009j$.util;

import p009j$.util.function.Consumer;
import p009j$.util.function.LongConsumer;

/* renamed from: j$.util.PrimitiveIterator$OfLong$$ExternalSyntheticLambda0 */
public final /* synthetic */ class PrimitiveIterator$OfLong$$ExternalSyntheticLambda0 implements LongConsumer {
    public final /* synthetic */ Consumer f$0;

    public /* synthetic */ PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(Consumer consumer) {
        this.f$0 = consumer;
    }

    public final void accept(long j) {
        this.f$0.accept(Long.valueOf(j));
    }
}
