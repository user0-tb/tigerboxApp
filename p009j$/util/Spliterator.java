package p009j$.util;

import java.util.Comparator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;

/* renamed from: j$.util.Spliterator */
public interface Spliterator<T> {

    /* renamed from: j$.util.Spliterator$OfDouble */
    public interface OfDouble extends OfPrimitive {
        void forEachRemaining(Consumer consumer);

        void forEachRemaining(DoubleConsumer doubleConsumer);

        boolean tryAdvance(Consumer consumer);

        boolean tryAdvance(DoubleConsumer doubleConsumer);

        OfDouble trySplit();
    }

    /* renamed from: j$.util.Spliterator$OfInt */
    public interface OfInt extends OfPrimitive {
        void forEachRemaining(Consumer consumer);

        void forEachRemaining(IntConsumer intConsumer);

        boolean tryAdvance(Consumer consumer);

        boolean tryAdvance(IntConsumer intConsumer);

        OfInt trySplit();
    }

    /* renamed from: j$.util.Spliterator$OfLong */
    public interface OfLong extends OfPrimitive {
        void forEachRemaining(Consumer consumer);

        void forEachRemaining(LongConsumer longConsumer);

        boolean tryAdvance(Consumer consumer);

        boolean tryAdvance(LongConsumer longConsumer);

        OfLong trySplit();
    }

    /* renamed from: j$.util.Spliterator$OfPrimitive */
    public interface OfPrimitive extends Spliterator {
        void forEachRemaining(Object obj);

        boolean tryAdvance(Object obj);

        OfPrimitive trySplit();
    }

    int characteristics();

    long estimateSize();

    void forEachRemaining(Consumer consumer);

    Comparator getComparator();

    long getExactSizeIfKnown();

    boolean hasCharacteristics(int i);

    boolean tryAdvance(Consumer consumer);

    Spliterator trySplit();
}
