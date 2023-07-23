package p009j$.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import p009j$.util.Collection;
import p009j$.util.Comparator;
import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;
import p009j$.util.function.Predicate;
import p009j$.util.stream.Stream;
import p009j$.util.stream.StreamSupport;

/* renamed from: j$.util.Objects */
public abstract class Objects {
    public static void $default$forEach(Collection collection, Consumer consumer) {
        java.util.Objects.requireNonNull(consumer);
        for (Object accept : collection) {
            consumer.accept(accept);
        }
    }

    public static void $default$forEachRemaining(Spliterator.OfDouble ofDouble, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            ofDouble.forEachRemaining((DoubleConsumer) consumer);
        } else if (!Tripwire.ENABLED) {
            java.util.Objects.requireNonNull(consumer);
            ofDouble.forEachRemaining((DoubleConsumer) new PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(consumer));
        } else {
            Tripwire.trip(ofDouble.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
            throw null;
        }
    }

    public static long $default$getExactSizeIfKnown(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1;
        }
        return spliterator.estimateSize();
    }

    public static boolean $default$hasCharacteristics(Spliterator spliterator, int i) {
        return (spliterator.characteristics() & i) == i;
    }

    public static Stream $default$parallelStream(Collection collection) {
        return StreamSupport.stream(Collection.EL.spliterator(collection), true);
    }

    public static boolean $default$removeIf(java.util.Collection collection, Predicate predicate) {
        if (DesugarCollections.SYNCHRONIZED_COLLECTION.isInstance(collection)) {
            return DesugarCollections.removeIf(collection, predicate);
        }
        java.util.Objects.requireNonNull(predicate);
        boolean z = false;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (predicate.test(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static Stream $default$stream(java.util.Collection collection) {
        return StreamSupport.stream(Collection.EL.spliterator(collection), false);
    }

    public static boolean $default$tryAdvance(Spliterator.OfDouble ofDouble, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            return ofDouble.tryAdvance((DoubleConsumer) consumer);
        }
        if (!Tripwire.ENABLED) {
            java.util.Objects.requireNonNull(consumer);
            return ofDouble.tryAdvance((DoubleConsumer) new PrimitiveIterator$OfDouble$$ExternalSyntheticLambda0(consumer));
        }
        Tripwire.trip(ofDouble.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
        throw null;
    }

    public static Optional convert(Optional optional) {
        if (optional == null) {
            return null;
        }
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

    public static OptionalDouble convert(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        return optionalDouble.isPresent() ? OptionalDouble.of(optionalDouble.getAsDouble()) : OptionalDouble.empty();
    }

    public static OptionalInt convert(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        return optionalInt.isPresent() ? OptionalInt.of(optionalInt.getAsInt()) : OptionalInt.empty();
    }

    public static OptionalLong convert(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        return optionalLong.isPresent() ? OptionalLong.of(optionalLong.getAsLong()) : OptionalLong.empty();
    }

    public static boolean equals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void sort(List list, Comparator comparator) {
        if (DesugarCollections.SYNCHRONIZED_LIST.isInstance(list)) {
            DesugarCollections.sort(list, comparator);
            return;
        }
        Object[] array = list.toArray();
        Arrays.sort(array, comparator);
        ListIterator listIterator = list.listIterator();
        for (Object obj : array) {
            listIterator.next();
            listIterator.set(obj);
        }
    }

    public static /* synthetic */ Comparator thenComparing(Comparator comparator, Comparator comparator2) {
        return comparator instanceof Comparator ? ((Comparator) comparator).thenComparing(comparator2) : Comparator.CC.$default$thenComparing(comparator, comparator2);
    }

    public static void $default$forEachRemaining(Spliterator.OfInt ofInt, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            ofInt.forEachRemaining((IntConsumer) consumer);
        } else if (!Tripwire.ENABLED) {
            java.util.Objects.requireNonNull(consumer);
            ofInt.forEachRemaining((IntConsumer) new PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(consumer));
        } else {
            Tripwire.trip(ofInt.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
            throw null;
        }
    }

    public static boolean $default$tryAdvance(Spliterator.OfInt ofInt, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            return ofInt.tryAdvance((IntConsumer) consumer);
        }
        if (!Tripwire.ENABLED) {
            java.util.Objects.requireNonNull(consumer);
            return ofInt.tryAdvance((IntConsumer) new PrimitiveIterator$OfInt$$ExternalSyntheticLambda0(consumer));
        }
        Tripwire.trip(ofInt.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
        throw null;
    }

    public static void $default$forEachRemaining(Spliterator.OfLong ofLong, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            ofLong.forEachRemaining((LongConsumer) consumer);
        } else if (!Tripwire.ENABLED) {
            java.util.Objects.requireNonNull(consumer);
            ofLong.forEachRemaining((LongConsumer) new PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(consumer));
        } else {
            Tripwire.trip(ofLong.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
            throw null;
        }
    }

    public static boolean $default$tryAdvance(Spliterator.OfLong ofLong, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            return ofLong.tryAdvance((LongConsumer) consumer);
        }
        if (!Tripwire.ENABLED) {
            java.util.Objects.requireNonNull(consumer);
            return ofLong.tryAdvance((LongConsumer) new PrimitiveIterator$OfLong$$ExternalSyntheticLambda0(consumer));
        }
        Tripwire.trip(ofLong.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
        throw null;
    }
}
