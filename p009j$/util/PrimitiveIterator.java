package p009j$.util;

import java.util.Iterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;

/* renamed from: j$.util.PrimitiveIterator */
public interface PrimitiveIterator extends Iterator {

    /* renamed from: j$.util.PrimitiveIterator$OfDouble */
    public interface OfDouble extends PrimitiveIterator {
        void forEachRemaining(Consumer consumer);

        void forEachRemaining(DoubleConsumer doubleConsumer);

        Double next();

        double nextDouble();
    }

    /* renamed from: j$.util.PrimitiveIterator$OfInt */
    public interface OfInt extends PrimitiveIterator {
        void forEachRemaining(Consumer consumer);

        void forEachRemaining(IntConsumer intConsumer);

        Integer next();

        int nextInt();
    }

    /* renamed from: j$.util.PrimitiveIterator$OfLong */
    public interface OfLong extends PrimitiveIterator {
        void forEachRemaining(Consumer consumer);

        void forEachRemaining(LongConsumer longConsumer);

        Long next();

        long nextLong();
    }

    void forEachRemaining(Object obj);
}
