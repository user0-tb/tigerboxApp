package p009j$.util.stream;

import java.util.Iterator;
import p009j$.util.Spliterator;

/* renamed from: j$.util.stream.BaseStream */
public interface BaseStream extends AutoCloseable {
    void close();

    boolean isParallel();

    Iterator iterator();

    BaseStream onClose(Runnable runnable);

    BaseStream parallel();

    BaseStream sequential();

    Spliterator spliterator();

    BaseStream unordered();
}
