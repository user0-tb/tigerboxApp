package p009j$.util.stream;

import java.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Supplier;
import p009j$.util.stream.DoublePipeline;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.LongPipeline;
import p009j$.util.stream.ReferencePipeline;

/* renamed from: j$.util.stream.StreamSupport */
public final class StreamSupport {
    public static DoubleStream doubleStream(Spliterator.OfDouble ofDouble, boolean z) {
        return new DoublePipeline.Head(ofDouble, StreamOpFlag.fromCharacteristics(ofDouble), z);
    }

    public static IntStream intStream(Spliterator.OfInt ofInt, boolean z) {
        return new IntPipeline.Head(ofInt, StreamOpFlag.fromCharacteristics(ofInt), z);
    }

    public static LongStream longStream(Spliterator.OfLong ofLong, boolean z) {
        return new LongPipeline.Head(ofLong, StreamOpFlag.fromCharacteristics(ofLong), z);
    }

    public static Stream stream(Spliterator spliterator, boolean z) {
        Objects.requireNonNull(spliterator);
        return new ReferencePipeline.Head(spliterator, StreamOpFlag.fromCharacteristics(spliterator), z);
    }

    public static <T> Stream<T> stream(Supplier<? extends Spliterator<T>> supplier, int i, boolean z) {
        Objects.requireNonNull(supplier);
        return new ReferencePipeline.Head((Supplier) supplier, i & StreamOpFlag.SPLITERATOR_CHARACTERISTICS_MASK, z);
    }
}
