package p009j$.util.concurrent;

import java.util.Map;
import java.util.Objects;
import p009j$.util.Map;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BiFunction;
import p009j$.util.function.Consumer$$ExternalSyntheticLambda0;
import p009j$.util.function.Function;

/* renamed from: j$.util.concurrent.ConcurrentMap */
public interface ConcurrentMap<K, V> extends Map<K, V> {

    /* renamed from: j$.util.concurrent.ConcurrentMap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object $default$compute(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            while (true) {
                Object obj2 = concurrentMap.get(obj);
                while (true) {
                    Object apply = biFunction.apply(obj, obj2);
                    if (apply == null) {
                        if ((obj2 == null && !concurrentMap.containsKey(obj)) || concurrentMap.remove(obj, obj2)) {
                            return null;
                        }
                    } else if (obj2 == null) {
                        obj2 = concurrentMap.putIfAbsent(obj, apply);
                        if (obj2 == null) {
                            return apply;
                        }
                    } else if (concurrentMap.replace(obj, obj2, apply)) {
                        return apply;
                    }
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
            r0 = r1.putIfAbsent(r2, (r3 = r3.apply(r2)));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Object $default$computeIfAbsent(java.util.concurrent.ConcurrentMap r1, java.lang.Object r2, p009j$.util.function.Function r3) {
            /*
                java.util.Objects.requireNonNull(r3)
                java.lang.Object r0 = r1.get(r2)
                if (r0 != 0) goto L_0x0016
                java.lang.Object r3 = r3.apply(r2)
                if (r3 == 0) goto L_0x0016
                java.lang.Object r0 = r1.putIfAbsent(r2, r3)
                if (r0 != 0) goto L_0x0016
                goto L_0x0017
            L_0x0016:
                r3 = r0
            L_0x0017:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.concurrent.ConcurrentMap.CC.$default$computeIfAbsent(java.util.concurrent.ConcurrentMap, java.lang.Object, j$.util.function.Function):java.lang.Object");
        }

        public static Object $default$computeIfPresent(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            while (true) {
                Object obj2 = concurrentMap.get(obj);
                if (obj2 == null) {
                    return obj2;
                }
                Object apply = biFunction.apply(obj, obj2);
                if (apply != null) {
                    if (concurrentMap.replace(obj, obj2, apply)) {
                        return apply;
                    }
                } else if (concurrentMap.remove(obj, obj2)) {
                    return null;
                }
            }
        }

        public static void $default$forEach(java.util.concurrent.ConcurrentMap concurrentMap, BiConsumer biConsumer) {
            Objects.requireNonNull(biConsumer);
            for (Map.Entry entry : concurrentMap.entrySet()) {
                try {
                    biConsumer.accept(entry.getKey(), entry.getValue());
                } catch (IllegalStateException unused) {
                }
            }
        }

        public static Object $default$getOrDefault(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, Object obj2) {
            Object obj3 = concurrentMap.get(obj);
            return obj3 != null ? obj3 : obj2;
        }

        public static Object $default$merge(java.util.concurrent.ConcurrentMap concurrentMap, Object obj, Object obj2, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            Objects.requireNonNull(obj2);
            while (true) {
                Object obj3 = concurrentMap.get(obj);
                while (obj3 == null) {
                    obj3 = concurrentMap.putIfAbsent(obj, obj2);
                    if (obj3 == null) {
                        return obj2;
                    }
                }
                Object apply = biFunction.apply(obj3, obj2);
                if (apply != null) {
                    if (concurrentMap.replace(obj, obj3, apply)) {
                        return apply;
                    }
                } else if (concurrentMap.remove(obj, obj3)) {
                    return null;
                }
            }
        }

        public static void $default$replaceAll(java.util.concurrent.ConcurrentMap concurrentMap, BiFunction biFunction) {
            Objects.requireNonNull(biFunction);
            Consumer$$ExternalSyntheticLambda0 consumer$$ExternalSyntheticLambda0 = new Consumer$$ExternalSyntheticLambda0(concurrentMap, biFunction);
            if (concurrentMap instanceof ConcurrentMap) {
                ((ConcurrentMap) concurrentMap).forEach(consumer$$ExternalSyntheticLambda0);
            } else {
                $default$forEach(concurrentMap, consumer$$ExternalSyntheticLambda0);
            }
        }
    }

    V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction);

    V computeIfAbsent(K k, Function<? super K, ? extends V> function);

    V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction);

    void forEach(BiConsumer<? super K, ? super V> biConsumer);

    V getOrDefault(Object obj, V v);

    V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction);

    V putIfAbsent(K k, V v);

    boolean remove(Object obj, Object obj2);

    V replace(K k, V v);

    boolean replace(K k, V v, V v2);

    void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction);
}
