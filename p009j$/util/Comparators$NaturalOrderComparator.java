package p009j$.util;

import java.util.Collections;
import java.util.Comparator;

/* renamed from: j$.util.Comparators$NaturalOrderComparator */
enum Comparators$NaturalOrderComparator implements Comparator, Comparator {
    INSTANCE;

    public int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }

    public Comparator reversed() {
        return Collections.reverseOrder();
    }
}
