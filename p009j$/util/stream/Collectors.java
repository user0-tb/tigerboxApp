package p009j$.util.stream;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import p009j$.util.function.BiConsumer;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Function;
import p009j$.util.function.Supplier;
import p009j$.util.stream.Collector;

/* renamed from: j$.util.stream.Collectors */
public final class Collectors {
    static final Set CH_ID;

    /* renamed from: j$.util.stream.Collectors$CollectorImpl */
    static class CollectorImpl implements Collector {
        private final BiConsumer accumulator;
        private final Set characteristics;
        private final BinaryOperator combiner;
        private final Function finisher;
        private final Supplier supplier;

        CollectorImpl(Supplier supplier2, BiConsumer biConsumer, BinaryOperator binaryOperator, Set set) {
            Set set2 = Collectors.CH_ID;
            Collectors$$ExternalSyntheticLambda53 collectors$$ExternalSyntheticLambda53 = Collectors$$ExternalSyntheticLambda53.INSTANCE;
            this.supplier = supplier2;
            this.accumulator = biConsumer;
            this.combiner = binaryOperator;
            this.finisher = collectors$$ExternalSyntheticLambda53;
            this.characteristics = set;
        }

        public BiConsumer accumulator() {
            return this.accumulator;
        }

        public Set characteristics() {
            return this.characteristics;
        }

        public BinaryOperator combiner() {
            return this.combiner;
        }

        public Function finisher() {
            return this.finisher;
        }

        public Supplier supplier() {
            return this.supplier;
        }
    }

    static {
        Collector.Characteristics characteristics = Collector.Characteristics.CONCURRENT;
        Collector.Characteristics characteristics2 = Collector.Characteristics.UNORDERED;
        Collector.Characteristics characteristics3 = Collector.Characteristics.IDENTITY_FINISH;
        Collections.unmodifiableSet(EnumSet.of(characteristics, characteristics2, characteristics3));
        Collections.unmodifiableSet(EnumSet.of(characteristics, characteristics2));
        CH_ID = Collections.unmodifiableSet(EnumSet.of(characteristics3));
        Collections.unmodifiableSet(EnumSet.of(characteristics2, characteristics3));
        Collections.emptySet();
    }

    static double computeFinalSum(double[] dArr) {
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (!Double.isNaN(d) || !Double.isInfinite(d2)) ? d : d2;
    }

    static double[] sumWithCompensation(double[] dArr, double d) {
        double d2 = d - dArr[1];
        double d3 = dArr[0];
        double d4 = d3 + d2;
        dArr[1] = (d4 - d3) - d2;
        dArr[0] = d4;
        return dArr;
    }

    public static <T> Collector<T, ?, List<T>> toList() {
        return new CollectorImpl(Collectors$$ExternalSyntheticLambda77.INSTANCE, Collectors$$ExternalSyntheticLambda20.INSTANCE, Collectors$$ExternalSyntheticLambda36.INSTANCE, CH_ID);
    }
}
