package p009j$.util;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import p009j$.util.Collection;
import p009j$.util.Map;
import p009j$.util.concurrent.ConcurrentMap;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BiFunction;
import p009j$.util.function.Function;
import p009j$.util.function.Predicate;
import p009j$.wrappers.C$r8$wrapper$java$util$function$BiConsumer$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$BiFunction$VWRP;
import p009j$.wrappers.C$r8$wrapper$java$util$function$Function$VWRP;

/* renamed from: j$.util.DesugarCollections */
public class DesugarCollections {
    private static final Field COLLECTION_FIELD;
    private static final Field MUTEX_FIELD;
    public static final Class SYNCHRONIZED_COLLECTION;
    /* access modifiers changed from: private */
    public static final Constructor SYNCHRONIZED_COLLECTION_CONSTRUCTOR;
    static final Class SYNCHRONIZED_LIST = Collections.synchronizedList(new LinkedList()).getClass();
    /* access modifiers changed from: private */
    public static final Constructor SYNCHRONIZED_SET_CONSTRUCTOR;

    static {
        Field field;
        Field field2;
        Constructor<?> constructor;
        Class<Object> cls = Object.class;
        Class<?> cls2 = Collections.synchronizedCollection(new ArrayList()).getClass();
        SYNCHRONIZED_COLLECTION = cls2;
        Constructor<?> constructor2 = null;
        try {
            field = cls2.getDeclaredField("mutex");
        } catch (NoSuchFieldException unused) {
            field = null;
        }
        MUTEX_FIELD = field;
        if (field != null) {
            field.setAccessible(true);
        }
        try {
            field2 = cls2.getDeclaredField("c");
        } catch (NoSuchFieldException unused2) {
            field2 = null;
        }
        COLLECTION_FIELD = field2;
        if (field2 != null) {
            field2.setAccessible(true);
        }
        try {
            constructor = Collections.synchronizedSet(new HashSet()).getClass().getDeclaredConstructor(new Class[]{Set.class, cls});
        } catch (NoSuchMethodException unused3) {
            constructor = null;
        }
        SYNCHRONIZED_SET_CONSTRUCTOR = constructor;
        if (constructor != null) {
            constructor.setAccessible(true);
        }
        try {
            constructor2 = cls2.getDeclaredConstructor(new Class[]{Collection.class, cls});
        } catch (NoSuchMethodException unused4) {
        }
        SYNCHRONIZED_COLLECTION_CONSTRUCTOR = constructor2;
        if (constructor2 != null) {
            constructor2.setAccessible(true);
        }
    }

    static boolean removeIf(Collection collection, Predicate predicate) {
        boolean removeIf;
        Field field = MUTEX_FIELD;
        if (field == null) {
            try {
                return Collection.EL.removeIf((java.util.Collection) COLLECTION_FIELD.get(collection), predicate);
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized collection removeIf fall-back.", e);
            }
        } else {
            try {
                synchronized (field.get(collection)) {
                    removeIf = Collection.EL.removeIf((java.util.Collection) COLLECTION_FIELD.get(collection), predicate);
                }
                return removeIf;
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized collection removeIf.", e2);
            }
        }
    }

    static void sort(List list, Comparator comparator) {
        Field field = MUTEX_FIELD;
        if (field == null) {
            try {
                Objects.sort((List) COLLECTION_FIELD.get(list), comparator);
            } catch (IllegalAccessException e) {
                throw new Error("Runtime illegal access in synchronized collection sort fall-back.", e);
            }
        } else {
            try {
                synchronized (field.get(list)) {
                    Objects.sort((List) COLLECTION_FIELD.get(list), comparator);
                }
            } catch (IllegalAccessException e2) {
                throw new Error("Runtime illegal access in synchronized list sort.", e2);
            }
        }
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return new SynchronizedMap(map);
    }

    /* renamed from: j$.util.DesugarCollections$SynchronizedMap */
    private static class SynchronizedMap implements Map, Serializable, Map {
        private transient Set entrySet;
        private transient Set keySet;

        /* renamed from: m */
        private final Map f231m;
        final Object mutex = this;
        private transient java.util.Collection values;

        SynchronizedMap(Map map) {
            Objects.requireNonNull(map);
            this.f231m = map;
        }

        private Set instantiateSet(Set set, Object obj) {
            if (DesugarCollections.SYNCHRONIZED_SET_CONSTRUCTOR == null) {
                return Collections.synchronizedSet(set);
            }
            try {
                return (Set) DesugarCollections.SYNCHRONIZED_SET_CONSTRUCTOR.newInstance(new Object[]{set, obj});
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                throw new Error("Unable to instantiate a synchronized list.", e);
            }
        }

        public void clear() {
            synchronized (this.mutex) {
                this.f231m.clear();
            }
        }

        public Object compute(Object obj, BiFunction biFunction) {
            Object compute;
            synchronized (this.mutex) {
                try {
                    Map map = this.f231m;
                    compute = map instanceof Map ? ((Map) map).compute(obj, biFunction) : map instanceof ConcurrentMap ? ConcurrentMap.CC.$default$compute((java.util.concurrent.ConcurrentMap) map, obj, biFunction) : Map.CC.$default$compute(map, obj, biFunction);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return compute;
        }

        public /* synthetic */ Object compute(Object obj, java.util.function.BiFunction biFunction) {
            return compute(obj, C$r8$wrapper$java$util$function$BiFunction$VWRP.convert(biFunction));
        }

        public Object computeIfAbsent(Object obj, Function function) {
            Object computeIfAbsent;
            synchronized (this.mutex) {
                try {
                    java.util.Map map = this.f231m;
                    computeIfAbsent = map instanceof Map ? ((Map) map).computeIfAbsent(obj, function) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.$default$computeIfAbsent((java.util.concurrent.ConcurrentMap) map, obj, function) : Map.CC.$default$computeIfAbsent(map, obj, function);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return computeIfAbsent;
        }

        public /* synthetic */ Object computeIfAbsent(Object obj, java.util.function.Function function) {
            return computeIfAbsent(obj, C$r8$wrapper$java$util$function$Function$VWRP.convert(function));
        }

        public Object computeIfPresent(Object obj, BiFunction biFunction) {
            Object computeIfPresent;
            synchronized (this.mutex) {
                try {
                    java.util.Map map = this.f231m;
                    computeIfPresent = map instanceof Map ? ((Map) map).computeIfPresent(obj, biFunction) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.$default$computeIfPresent((java.util.concurrent.ConcurrentMap) map, obj, biFunction) : Map.CC.$default$computeIfPresent(map, obj, biFunction);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return computeIfPresent;
        }

        public /* synthetic */ Object computeIfPresent(Object obj, java.util.function.BiFunction biFunction) {
            return computeIfPresent(obj, C$r8$wrapper$java$util$function$BiFunction$VWRP.convert(biFunction));
        }

        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = this.f231m.containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = this.f231m.containsValue(obj);
            }
            return containsValue;
        }

        public Set entrySet() {
            Set set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = instantiateSet(this.f231m.entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = this.f231m.equals(obj);
            }
            return equals;
        }

        public void forEach(BiConsumer biConsumer) {
            synchronized (this.mutex) {
                try {
                    java.util.Map map = this.f231m;
                    if (map instanceof Map) {
                        ((Map) map).forEach(biConsumer);
                    } else if (map instanceof java.util.concurrent.ConcurrentMap) {
                        ConcurrentMap.CC.$default$forEach((java.util.concurrent.ConcurrentMap) map, biConsumer);
                    } else {
                        Map.CC.$default$forEach(map, biConsumer);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ void forEach(java.util.function.BiConsumer biConsumer) {
            forEach(C$r8$wrapper$java$util$function$BiConsumer$VWRP.convert(biConsumer));
        }

        public Object get(Object obj) {
            Object obj2;
            synchronized (this.mutex) {
                obj2 = this.f231m.get(obj);
            }
            return obj2;
        }

        public Object getOrDefault(Object obj, Object obj2) {
            Object orDefault;
            synchronized (this.mutex) {
                orDefault = Map.EL.getOrDefault(this.f231m, obj, obj2);
            }
            return orDefault;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = this.f231m.hashCode();
            }
            return hashCode;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = this.f231m.isEmpty();
            }
            return isEmpty;
        }

        public Set keySet() {
            Set set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = instantiateSet(this.f231m.keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        public Object merge(Object obj, Object obj2, BiFunction biFunction) {
            Object merge;
            synchronized (this.mutex) {
                try {
                    java.util.Map map = this.f231m;
                    merge = map instanceof Map ? ((Map) map).merge(obj, obj2, biFunction) : map instanceof java.util.concurrent.ConcurrentMap ? ConcurrentMap.CC.$default$merge((java.util.concurrent.ConcurrentMap) map, obj, obj2, biFunction) : Map.CC.$default$merge(map, obj, obj2, biFunction);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return merge;
        }

        public /* synthetic */ Object merge(Object obj, Object obj2, java.util.function.BiFunction biFunction) {
            return merge(obj, obj2, C$r8$wrapper$java$util$function$BiFunction$VWRP.convert(biFunction));
        }

        public Object put(Object obj, Object obj2) {
            Object put;
            synchronized (this.mutex) {
                put = this.f231m.put(obj, obj2);
            }
            return put;
        }

        public void putAll(java.util.Map map) {
            synchronized (this.mutex) {
                this.f231m.putAll(map);
            }
        }

        public Object putIfAbsent(Object obj, Object obj2) {
            Object putIfAbsent;
            synchronized (this.mutex) {
                putIfAbsent = Map.EL.putIfAbsent(this.f231m, obj, obj2);
            }
            return putIfAbsent;
        }

        public Object remove(Object obj) {
            Object remove;
            synchronized (this.mutex) {
                remove = this.f231m.remove(obj);
            }
            return remove;
        }

        public boolean remove(Object obj, Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = Map.EL.remove(this.f231m, obj, obj2);
            }
            return remove;
        }

        public Object replace(Object obj, Object obj2) {
            Object replace;
            synchronized (this.mutex) {
                try {
                    java.util.Map map = this.f231m;
                    replace = map instanceof Map ? ((Map) map).replace(obj, obj2) : Map.CC.$default$replace(map, obj, obj2);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return replace;
        }

        public void replaceAll(BiFunction biFunction) {
            synchronized (this.mutex) {
                try {
                    java.util.Map map = this.f231m;
                    if (map instanceof Map) {
                        ((Map) map).replaceAll(biFunction);
                    } else if (map instanceof java.util.concurrent.ConcurrentMap) {
                        ConcurrentMap.CC.$default$replaceAll((java.util.concurrent.ConcurrentMap) map, biFunction);
                    } else {
                        Map.CC.$default$replaceAll(map, biFunction);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ void replaceAll(java.util.function.BiFunction biFunction) {
            replaceAll(C$r8$wrapper$java$util$function$BiFunction$VWRP.convert(biFunction));
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = this.f231m.size();
            }
            return size;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.f231m.toString();
            }
            return obj;
        }

        public java.util.Collection values() {
            java.util.Collection collection;
            java.util.Collection collection2;
            synchronized (this.mutex) {
                try {
                    if (this.values == null) {
                        java.util.Collection values2 = this.f231m.values();
                        Object obj = this.mutex;
                        if (DesugarCollections.SYNCHRONIZED_COLLECTION_CONSTRUCTOR == null) {
                            collection2 = Collections.synchronizedCollection(values2);
                        } else {
                            collection2 = (java.util.Collection) DesugarCollections.SYNCHRONIZED_COLLECTION_CONSTRUCTOR.newInstance(new Object[]{values2, obj});
                        }
                        this.values = collection2;
                    }
                    collection = this.values;
                } catch (InstantiationException e) {
                    e = e;
                    throw new Error("Unable to instantiate a synchronized list.", e);
                } catch (IllegalAccessException e2) {
                    e = e2;
                    throw new Error("Unable to instantiate a synchronized list.", e);
                } catch (InvocationTargetException e3) {
                    e = e3;
                    throw new Error("Unable to instantiate a synchronized list.", e);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        public boolean replace(Object obj, Object obj2, Object obj3) {
            boolean replace;
            synchronized (this.mutex) {
                try {
                    java.util.Map map = this.f231m;
                    replace = map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : Map.CC.$default$replace(map, obj, obj2, obj3);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return replace;
        }
    }
}
