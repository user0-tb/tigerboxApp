package p009j$.util;

import p009j$.util.function.Consumer;
import p009j$.util.function.IntConsumer;

/* renamed from: j$.util.PrimitiveIterator$OfInt$$ExternalSyntheticLambda0 */
public final /* synthetic */ class PrimitiveIterator$OfInt$$ExternalSyntheticLambda0 implements IntConsumer {
    public final /* synthetic */ Consumer f$0;

    public /* synthetic */ PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(Consumer consumer) {
        this.f$0 = consumer;
    }

    public final void accept(int i) {
        this.f$0.accept(Integer.valueOf(i));
    }
}
