package p009j$.util.stream;

import java.util.Comparator;
import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;
import p009j$.util.function.Supplier;

/* renamed from: j$.util.stream.StreamSpliterators$DelegatingSpliterator */
class StreamSpliterators$DelegatingSpliterator implements Spliterator {

    /* renamed from: s */
    private Spliterator f253s;
    private final Supplier supplier;

    /* renamed from: j$.util.stream.StreamSpliterators$DelegatingSpliterator$OfDouble */
    final class OfDouble extends OfPrimitive implements Spliterator.OfDouble {
        OfDouble(Supplier supplier) {
            super(supplier);
        }

        public void forEachRemaining(DoubleConsumer doubleConsumer) {
            ((Spliterator.OfPrimitive) get()).forEachRemaining(doubleConsumer);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$DelegatingSpliterator$OfInt */
    final class OfInt extends OfPrimitive implements Spliterator.OfInt {
        OfInt(Supplier supplier) {
            super(supplier);
        }

        public void forEachRemaining(IntConsumer intConsumer) {
            ((Spliterator.OfPrimitive) get()).forEachRemaining(intConsumer);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$DelegatingSpliterator$OfLong */
    final class OfLong extends OfPrimitive implements Spliterator.OfLong {
        OfLong(Supplier supplier) {
            super(supplier);
        }

        public void forEachRemaining(LongConsumer longConsumer) {
            ((Spliterator.OfPrimitive) get()).forEachRemaining(longConsumer);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$DelegatingSpliterator$OfPrimitive */
    abstract class OfPrimitive extends StreamSpliterators$DelegatingSpliterator implements Spliterator.OfPrimitive {
        OfPrimitive(Supplier supplier) {
            super(supplier);
        }

        public void forEachRemaining(Object obj) {
            ((Spliterator.OfPrimitive) get()).forEachRemaining(obj);
        }

        public boolean tryAdvance(Object obj) {
            return ((Spliterator.OfPrimitive) get()).tryAdvance(obj);
        }
    }

    StreamSpliterators$DelegatingSpliterator(Supplier supplier2) {
        this.supplier = supplier2;
    }

    public int characteristics() {
        return get().characteristics();
    }

    public long estimateSize() {
        return get().estimateSize();
    }

    public void forEachRemaining(Consumer consumer) {
        get().forEachRemaining(consumer);
    }

    /* access modifiers changed from: package-private */
    public Spliterator get() {
        if (this.f253s == null) {
            this.f253s = (Spliterator) this.supplier.get();
        }
        return this.f253s;
    }

    public Comparator getComparator() {
        return get().getComparator();
    }

    public long getExactSizeIfKnown() {
        return get().getExactSizeIfKnown();
    }

    public /* synthetic */ boolean hasCharacteristics(int i) {
        return Objects.$default$hasCharacteristics(this, i);
    }

    public String toString() {
        return getClass().getName() + "[" + get() + "]";
    }

    public boolean tryAdvance(Consumer consumer) {
        return get().tryAdvance(consumer);
    }

    public Spliterator trySplit() {
        return get().trySplit();
    }
}
