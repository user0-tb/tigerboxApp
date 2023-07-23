package p009j$.util;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import p009j$.lang.Iterable;
import p009j$.util.Spliterators;
import p009j$.util.function.Consumer;
import p009j$.util.function.Predicate;
import p009j$.util.stream.Stream;

/* renamed from: j$.util.Collection */
public interface Collection extends Iterable {

    /* renamed from: j$.util.Collection$-EL  reason: invalid class name */
    public final /* synthetic */ class EL {
        public static /* synthetic */ void forEach(java.util.Collection collection, Consumer consumer) {
            if (collection instanceof Collection) {
                ((Collection) collection).forEach(consumer);
            } else {
                Objects.$default$forEach(collection, consumer);
            }
        }

        public static /* synthetic */ boolean removeIf(java.util.Collection collection, Predicate predicate) {
            return collection instanceof Collection ? ((Collection) collection).removeIf(predicate) : Objects.$default$removeIf(collection, predicate);
        }

        public static Spliterator spliterator(java.util.Collection collection) {
            if (collection instanceof Collection) {
                return ((Collection) collection).spliterator();
            }
            if (collection instanceof LinkedHashSet) {
                LinkedHashSet linkedHashSet = (LinkedHashSet) collection;
                Objects.requireNonNull(linkedHashSet);
                return new Spliterators.IteratorSpliterator((java.util.Collection) linkedHashSet, 17);
            } else if (collection instanceof SortedSet) {
                SortedSet sortedSet = (SortedSet) collection;
                return new SortedSet$1(sortedSet, sortedSet, 21);
            } else if (collection instanceof Set) {
                Set set = (Set) collection;
                Objects.requireNonNull(set);
                return new Spliterators.IteratorSpliterator((java.util.Collection) set, 1);
            } else if (collection instanceof List) {
                List list = (List) collection;
                Objects.requireNonNull(list);
                return new Spliterators.IteratorSpliterator((java.util.Collection) list, 16);
            } else {
                Objects.requireNonNull(collection);
                return new Spliterators.IteratorSpliterator(collection, 0);
            }
        }
    }

    void forEach(Consumer consumer);

    boolean removeIf(Predicate predicate);

    Spliterator spliterator();

    Stream stream();
}
