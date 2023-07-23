package p009j$.util;

import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;

/* renamed from: j$.util.PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0 */
public final /* synthetic */ class PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0 implements DoubleConsumer {
    public final /* synthetic */ Consumer f$0;

    public /* synthetic */ PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(Consumer consumer) {
        this.f$0 = consumer;
    }

    public final void accept(double d) {
        this.f$0.accept(Double.valueOf(d));
    }
}
