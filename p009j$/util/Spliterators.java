package p009j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import p009j$.util.Iterator;
import p009j$.util.PrimitiveIterator;
import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;

/* renamed from: j$.util.Spliterators */
public final class Spliterators {
    private static final Spliterator.OfDouble EMPTY_DOUBLE_SPLITERATOR = new EmptySpliterator.OfDouble();
    private static final Spliterator.OfInt EMPTY_INT_SPLITERATOR = new EmptySpliterator.OfInt();
    private static final Spliterator.OfLong EMPTY_LONG_SPLITERATOR = new EmptySpliterator.OfLong();
    private static final Spliterator EMPTY_SPLITERATOR = new EmptySpliterator.OfRef();

    /* renamed from: j$.util.Spliterators$ArraySpliterator */
    static final class ArraySpliterator implements Spliterator {
        private final Object[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public ArraySpliterator(Object[] objArr, int i, int i2, int i3) {
            this.array = objArr;
            this.index = i;
            this.fence = i2;
            this.characteristics = i3 | 64 | 16384;
        }

        public int characteristics() {
            return this.characteristics;
        }

        public long estimateSize() {
            return (long) (this.fence - this.index);
        }

        public void forEachRemaining(Consumer consumer) {
            int i;
            Objects.requireNonNull(consumer);
            Object[] objArr = this.array;
            int length = objArr.length;
            int i2 = this.fence;
            if (length >= i2 && (i = this.index) >= 0) {
                this.index = i2;
                if (i < i2) {
                    do {
                        consumer.accept(objArr[i]);
                        i++;
                    } while (i < i2);
                }
            }
        }

        public Comparator getComparator() {
            if (Objects.$default$hasCharacteristics(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Objects.$default$hasCharacteristics(this, i);
        }

        public boolean tryAdvance(Consumer consumer) {
            Objects.requireNonNull(consumer);
            int i = this.index;
            if (i < 0 || i >= this.fence) {
                return false;
            }
            Object[] objArr = this.array;
            this.index = i + 1;
            consumer.accept(objArr[i]);
            return true;
        }

        public Spliterator trySplit() {
            int i = this.index;
            int i2 = (this.fence + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            Object[] objArr = this.array;
            this.index = i2;
            return new ArraySpliterator(objArr, i, i2, this.characteristics);
        }
    }

    /* renamed from: j$.util.Spliterators$DoubleArraySpliterator */
    static final class DoubleArraySpliterator implements Spliterator.OfDouble {
        private final double[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public DoubleArraySpliterator(double[] dArr, int i, int i2, int i3) {
            this.array = dArr;
            this.index = i;
            this.fence = i2;
            this.characteristics = i3 | 64 | 16384;
        }

        public int characteristics() {
            return this.characteristics;
        }

        public long estimateSize() {
            return (long) (this.fence - this.index);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Objects.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
        }

        public void forEachRemaining(DoubleConsumer doubleConsumer) {
            int i;
            Objects.requireNonNull(doubleConsumer);
            double[] dArr = this.array;
            int length = dArr.length;
            int i2 = this.fence;
            if (length >= i2 && (i = this.index) >= 0) {
                this.index = i2;
                if (i < i2) {
                    do {
                        doubleConsumer.accept(dArr[i]);
                        i++;
                    } while (i < i2);
                }
            }
        }

        public Comparator getComparator() {
            if (Objects.$default$hasCharacteristics(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Objects.$default$hasCharacteristics(this, i);
        }

        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Objects.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
        }

        public boolean tryAdvance(DoubleConsumer doubleConsumer) {
            Objects.requireNonNull(doubleConsumer);
            int i = this.index;
            if (i < 0 || i >= this.fence) {
                return false;
            }
            double[] dArr = this.array;
            this.index = i + 1;
            doubleConsumer.accept(dArr[i]);
            return true;
        }

        public Spliterator.OfDouble trySplit() {
            int i = this.index;
            int i2 = (this.fence + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            double[] dArr = this.array;
            this.index = i2;
            return new DoubleArraySpliterator(dArr, i, i2, this.characteristics);
        }
    }

    /* renamed from: j$.util.Spliterators$EmptySpliterator */
    private static abstract class EmptySpliterator {

        /* renamed from: j$.util.Spliterators$EmptySpliterator$OfDouble */
        private static final class OfDouble extends EmptySpliterator implements Spliterator.OfDouble {
            OfDouble() {
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Objects.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
            }

            public void forEachRemaining(DoubleConsumer doubleConsumer) {
                Objects.requireNonNull(doubleConsumer);
            }

            public Comparator getComparator() {
                throw new IllegalStateException();
            }

            public /* synthetic */ long getExactSizeIfKnown() {
                return Objects.$default$getExactSizeIfKnown(this);
            }

            public /* synthetic */ boolean hasCharacteristics(int i) {
                return Objects.$default$hasCharacteristics(this, i);
            }

            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Objects.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
            }

            public boolean tryAdvance(DoubleConsumer doubleConsumer) {
                Objects.requireNonNull(doubleConsumer);
                return false;
            }
        }

        /* renamed from: j$.util.Spliterators$EmptySpliterator$OfInt */
        private static final class OfInt extends EmptySpliterator implements Spliterator.OfInt {
            OfInt() {
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Objects.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
            }

            public void forEachRemaining(IntConsumer intConsumer) {
                Objects.requireNonNull(intConsumer);
            }

            public Comparator getComparator() {
                throw new IllegalStateException();
            }

            public /* synthetic */ long getExactSizeIfKnown() {
                return Objects.$default$getExactSizeIfKnown(this);
            }

            public /* synthetic */ boolean hasCharacteristics(int i) {
                return Objects.$default$hasCharacteristics(this, i);
            }

            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Objects.$default$tryAdvance((Spliterator.OfInt) this, consumer);
            }

            public boolean tryAdvance(IntConsumer intConsumer) {
                Objects.requireNonNull(intConsumer);
                return false;
            }
        }

        /* renamed from: j$.util.Spliterators$EmptySpliterator$OfLong */
        private static final class OfLong extends EmptySpliterator implements Spliterator.OfLong {
            OfLong() {
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Objects.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
            }

            public void forEachRemaining(LongConsumer longConsumer) {
                Objects.requireNonNull(longConsumer);
            }

            public Comparator getComparator() {
                throw new IllegalStateException();
            }

            public /* synthetic */ long getExactSizeIfKnown() {
                return Objects.$default$getExactSizeIfKnown(this);
            }

            public /* synthetic */ boolean hasCharacteristics(int i) {
                return Objects.$default$hasCharacteristics(this, i);
            }

            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Objects.$default$tryAdvance((Spliterator.OfLong) this, consumer);
            }

            public boolean tryAdvance(LongConsumer longConsumer) {
                Objects.requireNonNull(longConsumer);
                return false;
            }
        }

        /* renamed from: j$.util.Spliterators$EmptySpliterator$OfRef */
        private static final class OfRef extends EmptySpliterator implements Spliterator {
            OfRef() {
            }

            public void forEachRemaining(Consumer consumer) {
                Objects.requireNonNull(consumer);
            }

            public Comparator getComparator() {
                throw new IllegalStateException();
            }

            public /* synthetic */ long getExactSizeIfKnown() {
                return Objects.$default$getExactSizeIfKnown(this);
            }

            public /* synthetic */ boolean hasCharacteristics(int i) {
                return Objects.$default$hasCharacteristics(this, i);
            }

            public boolean tryAdvance(Consumer consumer) {
                Objects.requireNonNull(consumer);
                return false;
            }
        }

        EmptySpliterator() {
        }

        public int characteristics() {
            return 16448;
        }

        public long estimateSize() {
            return 0;
        }

        public void forEachRemaining(Object obj) {
            Objects.requireNonNull(obj);
        }

        public boolean tryAdvance(Object obj) {
            Objects.requireNonNull(obj);
            return false;
        }

        public Spliterator trySplit() {
            return null;
        }
    }

    /* renamed from: j$.util.Spliterators$IntArraySpliterator */
    static final class IntArraySpliterator implements Spliterator.OfInt {
        private final int[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public IntArraySpliterator(int[] iArr, int i, int i2, int i3) {
            this.array = iArr;
            this.index = i;
            this.fence = i2;
            this.characteristics = i3 | 64 | 16384;
        }

        public int characteristics() {
            return this.characteristics;
        }

        public long estimateSize() {
            return (long) (this.fence - this.index);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Objects.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
        }

        public void forEachRemaining(IntConsumer intConsumer) {
            int i;
            Objects.requireNonNull(intConsumer);
            int[] iArr = this.array;
            int length = iArr.length;
            int i2 = this.fence;
            if (length >= i2 && (i = this.index) >= 0) {
                this.index = i2;
                if (i < i2) {
                    do {
                        intConsumer.accept(iArr[i]);
                        i++;
                    } while (i < i2);
                }
            }
        }

        public Comparator getComparator() {
            if (Objects.$default$hasCharacteristics(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Objects.$default$hasCharacteristics(this, i);
        }

        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Objects.$default$tryAdvance((Spliterator.OfInt) this, consumer);
        }

        public boolean tryAdvance(IntConsumer intConsumer) {
            Objects.requireNonNull(intConsumer);
            int i = this.index;
            if (i < 0 || i >= this.fence) {
                return false;
            }
            int[] iArr = this.array;
            this.index = i + 1;
            intConsumer.accept(iArr[i]);
            return true;
        }

        public Spliterator.OfInt trySplit() {
            int i = this.index;
            int i2 = (this.fence + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            int[] iArr = this.array;
            this.index = i2;
            return new IntArraySpliterator(iArr, i, i2, this.characteristics);
        }
    }

    /* renamed from: j$.util.Spliterators$IteratorSpliterator */
    static class IteratorSpliterator implements Spliterator {
        private int batch;
        private final int characteristics;
        private final Collection collection;
        private long est;

        /* renamed from: it */
        private Iterator f232it;

        public IteratorSpliterator(Collection collection2, int i) {
            this.collection = collection2;
            this.f232it = null;
            this.characteristics = (i & 4096) == 0 ? i | 64 | 16384 : i;
        }

        public IteratorSpliterator(Iterator it, int i) {
            this.collection = null;
            this.f232it = it;
            this.est = Long.MAX_VALUE;
            this.characteristics = i & -16449;
        }

        public int characteristics() {
            return this.characteristics;
        }

        public long estimateSize() {
            if (this.f232it != null) {
                return this.est;
            }
            this.f232it = this.collection.iterator();
            long size = (long) this.collection.size();
            this.est = size;
            return size;
        }

        public void forEachRemaining(Consumer consumer) {
            Objects.requireNonNull(consumer);
            Iterator it = this.f232it;
            if (it == null) {
                it = this.collection.iterator();
                this.f232it = it;
                this.est = (long) this.collection.size();
            }
            if (it instanceof Iterator) {
                ((Iterator) it).forEachRemaining(consumer);
            } else {
                Iterator.CC.$default$forEachRemaining(it, consumer);
            }
        }

        public Comparator getComparator() {
            if (Objects.$default$hasCharacteristics(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Objects.$default$hasCharacteristics(this, i);
        }

        public boolean tryAdvance(Consumer consumer) {
            Objects.requireNonNull(consumer);
            if (this.f232it == null) {
                this.f232it = this.collection.iterator();
                this.est = (long) this.collection.size();
            }
            if (!this.f232it.hasNext()) {
                return false;
            }
            consumer.accept(this.f232it.next());
            return true;
        }

        public Spliterator trySplit() {
            long j;
            java.util.Iterator it = this.f232it;
            if (it == null) {
                it = this.collection.iterator();
                this.f232it = it;
                j = (long) this.collection.size();
                this.est = j;
            } else {
                j = this.est;
            }
            if (j <= 1 || !it.hasNext()) {
                return null;
            }
            int i = this.batch + 1024;
            if (((long) i) > j) {
                i = (int) j;
            }
            if (i > 33554432) {
                i = 33554432;
            }
            Object[] objArr = new Object[i];
            int i2 = 0;
            do {
                objArr[i2] = it.next();
                i2++;
                if (i2 >= i || !it.hasNext()) {
                    this.batch = i2;
                    long j2 = this.est;
                }
                objArr[i2] = it.next();
                i2++;
                break;
            } while (!it.hasNext());
            this.batch = i2;
            long j22 = this.est;
            if (j22 != Long.MAX_VALUE) {
                this.est = j22 - ((long) i2);
            }
            return new ArraySpliterator(objArr, 0, i2, this.characteristics);
        }
    }

    /* renamed from: j$.util.Spliterators$LongArraySpliterator */
    static final class LongArraySpliterator implements Spliterator.OfLong {
        private final long[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public LongArraySpliterator(long[] jArr, int i, int i2, int i3) {
            this.array = jArr;
            this.index = i;
            this.fence = i2;
            this.characteristics = i3 | 64 | 16384;
        }

        public int characteristics() {
            return this.characteristics;
        }

        public long estimateSize() {
            return (long) (this.fence - this.index);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Objects.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
        }

        public void forEachRemaining(LongConsumer longConsumer) {
            int i;
            Objects.requireNonNull(longConsumer);
            long[] jArr = this.array;
            int length = jArr.length;
            int i2 = this.fence;
            if (length >= i2 && (i = this.index) >= 0) {
                this.index = i2;
                if (i < i2) {
                    do {
                        longConsumer.accept(jArr[i]);
                        i++;
                    } while (i < i2);
                }
            }
        }

        public Comparator getComparator() {
            if (Objects.$default$hasCharacteristics(this, 4)) {
                return null;
            }
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Objects.$default$hasCharacteristics(this, i);
        }

        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Objects.$default$tryAdvance((Spliterator.OfLong) this, consumer);
        }

        public boolean tryAdvance(LongConsumer longConsumer) {
            Objects.requireNonNull(longConsumer);
            int i = this.index;
            if (i < 0 || i >= this.fence) {
                return false;
            }
            long[] jArr = this.array;
            this.index = i + 1;
            longConsumer.accept(jArr[i]);
            return true;
        }

        public Spliterator.OfLong trySplit() {
            int i = this.index;
            int i2 = (this.fence + i) >>> 1;
            if (i >= i2) {
                return null;
            }
            long[] jArr = this.array;
            this.index = i2;
            return new LongArraySpliterator(jArr, i, i2, this.characteristics);
        }
    }

    private static void checkFromToBounds(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new ArrayIndexOutOfBoundsException("origin(" + i2 + ") > fence(" + i3 + ")");
        } else if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(i2);
        } else if (i3 > i) {
            throw new ArrayIndexOutOfBoundsException(i3);
        }
    }

    public static Spliterator.OfDouble emptyDoubleSpliterator() {
        return EMPTY_DOUBLE_SPLITERATOR;
    }

    public static Spliterator.OfInt emptyIntSpliterator() {
        return EMPTY_INT_SPLITERATOR;
    }

    public static Spliterator.OfLong emptyLongSpliterator() {
        return EMPTY_LONG_SPLITERATOR;
    }

    public static Spliterator emptySpliterator() {
        return EMPTY_SPLITERATOR;
    }

    public static PrimitiveIterator.OfDouble iterator(final Spliterator.OfDouble ofDouble) {
        Objects.requireNonNull(ofDouble);
        return new Object() {
            double nextElement;
            boolean valueReady = false;

            public void accept(double d) {
                this.valueReady = true;
                this.nextElement = d;
            }

            public void forEachRemaining(Consumer consumer) {
                if (consumer instanceof DoubleConsumer) {
                    forEachRemaining((DoubleConsumer) consumer);
                    return;
                }
                Objects.requireNonNull(consumer);
                if (!Tripwire.ENABLED) {
                    while (hasNext()) {
                        consumer.accept(Double.valueOf(nextDouble()));
                    }
                    return;
                }
                Tripwire.trip(AnonymousClass4Adapter.class, "{0} calling PrimitiveIterator.OfDouble.forEachRemainingDouble(action::accept)");
                throw null;
            }

            public boolean hasNext() {
                if (!this.valueReady) {
                    Spliterator.OfDouble.this.tryAdvance((DoubleConsumer) this);
                }
                return this.valueReady;
            }

            public Double next() {
                if (!Tripwire.ENABLED) {
                    return Double.valueOf(nextDouble());
                }
                Tripwire.trip(AnonymousClass4Adapter.class, "{0} calling PrimitiveIterator.OfDouble.nextLong()");
                throw null;
            }

            public double nextDouble() {
                if (this.valueReady || hasNext()) {
                    this.valueReady = false;
                    return this.nextElement;
                }
                throw new NoSuchElementException();
            }

            public /* synthetic */ void remove() {
                Iterator.CC.$default$remove(this);
                throw null;
            }

            public void forEachRemaining(DoubleConsumer doubleConsumer) {
                Objects.requireNonNull(doubleConsumer);
                while (hasNext()) {
                    doubleConsumer.accept(nextDouble());
                }
            }
        };
    }

    public static Spliterator.OfDouble spliterator(double[] dArr, int i, int i2, int i3) {
        Objects.requireNonNull(dArr);
        checkFromToBounds(dArr.length, i, i2);
        return new DoubleArraySpliterator(dArr, i, i2, i3);
    }

    public static <T> Spliterator<T> spliteratorUnknownSize(java.util.Iterator<? extends T> it, int i) {
        Objects.requireNonNull(it);
        return new IteratorSpliterator((java.util.Iterator) it, i);
    }

    public static PrimitiveIterator.OfInt iterator(final Spliterator.OfInt ofInt) {
        Objects.requireNonNull(ofInt);
        return new Object() {
            int nextElement;
            boolean valueReady = false;

            public void accept(int i) {
                this.valueReady = true;
                this.nextElement = i;
            }

            public void forEachRemaining(Consumer consumer) {
                if (consumer instanceof IntConsumer) {
                    forEachRemaining((IntConsumer) consumer);
                    return;
                }
                Objects.requireNonNull(consumer);
                if (!Tripwire.ENABLED) {
                    while (hasNext()) {
                        consumer.accept(Integer.valueOf(nextInt()));
                    }
                    return;
                }
                Tripwire.trip(AnonymousClass2Adapter.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
                throw null;
            }

            public boolean hasNext() {
                if (!this.valueReady) {
                    Spliterator.OfInt.this.tryAdvance((IntConsumer) this);
                }
                return this.valueReady;
            }

            public Integer next() {
                if (!Tripwire.ENABLED) {
                    return Integer.valueOf(nextInt());
                }
                Tripwire.trip(AnonymousClass2Adapter.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
                throw null;
            }

            public int nextInt() {
                if (this.valueReady || hasNext()) {
                    this.valueReady = false;
                    return this.nextElement;
                }
                throw new NoSuchElementException();
            }

            public /* synthetic */ void remove() {
                Iterator.CC.$default$remove(this);
                throw null;
            }

            public void forEachRemaining(IntConsumer intConsumer) {
                Objects.requireNonNull(intConsumer);
                while (hasNext()) {
                    intConsumer.accept(nextInt());
                }
            }
        };
    }

    public static Spliterator.OfInt spliterator(int[] iArr, int i, int i2, int i3) {
        Objects.requireNonNull(iArr);
        checkFromToBounds(iArr.length, i, i2);
        return new IntArraySpliterator(iArr, i, i2, i3);
    }

    public static PrimitiveIterator.OfLong iterator(final Spliterator.OfLong ofLong) {
        Objects.requireNonNull(ofLong);
        return new Object() {
            long nextElement;
            boolean valueReady = false;

            public void accept(long j) {
                this.valueReady = true;
                this.nextElement = j;
            }

            public void forEachRemaining(Consumer consumer) {
                if (consumer instanceof LongConsumer) {
                    forEachRemaining((LongConsumer) consumer);
                    return;
                }
                Objects.requireNonNull(consumer);
                if (!Tripwire.ENABLED) {
                    while (hasNext()) {
                        consumer.accept(Long.valueOf(nextLong()));
                    }
                    return;
                }
                Tripwire.trip(AnonymousClass3Adapter.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
                throw null;
            }

            public boolean hasNext() {
                if (!this.valueReady) {
                    Spliterator.OfLong.this.tryAdvance((LongConsumer) this);
                }
                return this.valueReady;
            }

            public Long next() {
                if (!Tripwire.ENABLED) {
                    return Long.valueOf(nextLong());
                }
                Tripwire.trip(AnonymousClass3Adapter.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
                throw null;
            }

            public long nextLong() {
                if (this.valueReady || hasNext()) {
                    this.valueReady = false;
                    return this.nextElement;
                }
                throw new NoSuchElementException();
            }

            public /* synthetic */ void remove() {
                Iterator.CC.$default$remove(this);
                throw null;
            }

            public void forEachRemaining(LongConsumer longConsumer) {
                Objects.requireNonNull(longConsumer);
                while (hasNext()) {
                    longConsumer.accept(nextLong());
                }
            }
        };
    }

    public static Spliterator.OfLong spliterator(long[] jArr, int i, int i2, int i3) {
        Objects.requireNonNull(jArr);
        checkFromToBounds(jArr.length, i, i2);
        return new LongArraySpliterator(jArr, i, i2, i3);
    }

    public static java.util.Iterator iterator(final Spliterator spliterator) {
        Objects.requireNonNull(spliterator);
        return new Object() {
            Object nextElement;
            boolean valueReady = false;

            public void accept(Object obj) {
                this.valueReady = true;
                this.nextElement = obj;
            }

            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer.CC.$default$andThen(this, consumer);
            }

            public boolean hasNext() {
                if (!this.valueReady) {
                    Spliterator.this.tryAdvance(this);
                }
                return this.valueReady;
            }

            public Object next() {
                if (this.valueReady || hasNext()) {
                    this.valueReady = false;
                    return this.nextElement;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static Spliterator spliterator(Object[] objArr, int i, int i2, int i3) {
        Objects.requireNonNull(objArr);
        checkFromToBounds(objArr.length, i, i2);
        return new ArraySpliterator(objArr, i, i2, i3);
    }
}
