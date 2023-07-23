package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class Functions {

    private enum IdentityFunction implements Function<Object, Object> {
        INSTANCE;

        @CheckForNull
        public Object apply(@CheckForNull Object obj) {
            return obj;
        }

        public String toString() {
            return "Functions.identity()";
        }
    }

    private Functions() {
    }

    public static Function<Object, String> toStringFunction() {
        return ToStringFunction.INSTANCE;
    }

    private enum ToStringFunction implements Function<Object, String> {
        INSTANCE;

        public String toString() {
            return "Functions.toStringFunction()";
        }

        public String apply(Object obj) {
            Preconditions.checkNotNull(obj);
            return obj.toString();
        }
    }

    public static <E> Function<E, E> identity() {
        return IdentityFunction.INSTANCE;
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> map) {
        return new FunctionForMapNoDefault(map);
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> map, @ParametricNullness V v) {
        return new ForMapWithDefault(map, v);
    }

    private static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        FunctionForMapNoDefault(Map<K, V> map2) {
            this.map = (Map) Preconditions.checkNotNull(map2);
        }

        @ParametricNullness
        public V apply(@ParametricNullness K k) {
            V v = this.map.get(k);
            Preconditions.checkArgument(v != null || this.map.containsKey(k), "Key '%s' not present in map", (Object) k);
            return NullnessCasts.uncheckedCastNullableTToT(v);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof FunctionForMapNoDefault) {
                return this.map.equals(((FunctionForMapNoDefault) obj).map);
            }
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.map);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
            sb.append("Functions.forMap(");
            sb.append(valueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    private static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        @ParametricNullness
        final V defaultValue;
        final Map<K, ? extends V> map;

        ForMapWithDefault(Map<K, ? extends V> map2, @ParametricNullness V v) {
            this.map = (Map) Preconditions.checkNotNull(map2);
            this.defaultValue = v;
        }

        @ParametricNullness
        public V apply(@ParametricNullness K k) {
            Object obj = this.map.get(k);
            if (obj != null || this.map.containsKey(k)) {
                return NullnessCasts.uncheckedCastNullableTToT(obj);
            }
            return this.defaultValue;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ForMapWithDefault)) {
                return false;
            }
            ForMapWithDefault forMapWithDefault = (ForMapWithDefault) obj;
            if (!this.map.equals(forMapWithDefault.map) || !Objects.equal(this.defaultValue, forMapWithDefault.defaultValue)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.map, this.defaultValue);
        }

        public String toString() {
            String valueOf = String.valueOf(this.map);
            String valueOf2 = String.valueOf(this.defaultValue);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 33 + String.valueOf(valueOf2).length());
            sb.append("Functions.forMap(");
            sb.append(valueOf);
            sb.append(", defaultValue=");
            sb.append(valueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> function, Function<A, ? extends B> function2) {
        return new FunctionComposition(function, function2);
    }

    private static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f */
        private final Function<A, ? extends B> f283f;

        /* renamed from: g */
        private final Function<B, C> f284g;

        public FunctionComposition(Function<B, C> function, Function<A, ? extends B> function2) {
            this.f284g = (Function) Preconditions.checkNotNull(function);
            this.f283f = (Function) Preconditions.checkNotNull(function2);
        }

        @ParametricNullness
        public C apply(@ParametricNullness A a) {
            return this.f284g.apply(this.f283f.apply(a));
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionComposition)) {
                return false;
            }
            FunctionComposition functionComposition = (FunctionComposition) obj;
            if (!this.f283f.equals(functionComposition.f283f) || !this.f284g.equals(functionComposition.f284g)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f283f.hashCode() ^ this.f284g.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.f284g);
            String valueOf2 = String.valueOf(this.f283f);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length());
            sb.append(valueOf);
            sb.append("(");
            sb.append(valueOf2);
            sb.append(")");
            return sb.toString();
        }
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> predicate) {
        return new PredicateFunction(predicate);
    }

    private static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final Predicate<T> predicate;

        private PredicateFunction(Predicate<T> predicate2) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate2);
        }

        public Boolean apply(@ParametricNullness T t) {
            return Boolean.valueOf(this.predicate.apply(t));
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof PredicateFunction) {
                return this.predicate.equals(((PredicateFunction) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.predicate);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Functions.forPredicate(");
            sb.append(valueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static <E> Function<Object, E> constant(@ParametricNullness E e) {
        return new ConstantFunction(e);
    }

    private static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;
        @ParametricNullness
        private final E value;

        public ConstantFunction(@ParametricNullness E e) {
            this.value = e;
        }

        @ParametricNullness
        public E apply(@CheckForNull Object obj) {
            return this.value;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ConstantFunction) {
                return Objects.equal(this.value, ((ConstantFunction) obj).value);
            }
            return false;
        }

        public int hashCode() {
            E e = this.value;
            if (e == null) {
                return 0;
            }
            return e.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.value);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("Functions.constant(");
            sb.append(valueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static <F, T> Function<F, T> forSupplier(Supplier<T> supplier) {
        return new SupplierFunction(supplier);
    }

    private static class SupplierFunction<F, T> implements Function<F, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<T> supplier;

        private SupplierFunction(Supplier<T> supplier2) {
            this.supplier = (Supplier) Preconditions.checkNotNull(supplier2);
        }

        @ParametricNullness
        public T apply(@ParametricNullness F f) {
            return this.supplier.get();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SupplierFunction) {
                return this.supplier.equals(((SupplierFunction) obj).supplier);
            }
            return false;
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.supplier);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Functions.forSupplier(");
            sb.append(valueOf);
            sb.append(")");
            return sb.toString();
        }
    }
}
