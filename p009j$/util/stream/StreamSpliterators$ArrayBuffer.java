package p009j$.util.stream;

import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;

/* renamed from: j$.util.stream.StreamSpliterators$ArrayBuffer */
abstract class StreamSpliterators$ArrayBuffer {
    int index;

    /* renamed from: j$.util.stream.StreamSpliterators$ArrayBuffer$OfDouble */
    final class OfDouble extends OfPrimitive implements DoubleConsumer {
        final double[] array;

        OfDouble(int i) {
            this.array = new double[i];
        }

        public void accept(double d) {
            double[] dArr = this.array;
            int i = this.index;
            this.index = i + 1;
            dArr[i] = d;
        }

        /* access modifiers changed from: package-private */
        public void forEach(Object obj, long j) {
            DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
            for (int i = 0; ((long) i) < j; i++) {
                doubleConsumer.accept(this.array[i]);
            }
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$ArrayBuffer$OfInt */
    final class OfInt extends OfPrimitive implements IntConsumer {
        final int[] array;

        OfInt(int i) {
            this.array = new int[i];
        }

        public void accept(int i) {
            int[] iArr = this.array;
            int i2 = this.index;
            this.index = i2 + 1;
            iArr[i2] = i;
        }

        public void forEach(Object obj, long j) {
            IntConsumer intConsumer = (IntConsumer) obj;
            for (int i = 0; ((long) i) < j; i++) {
                intConsumer.accept(this.array[i]);
            }
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$ArrayBuffer$OfLong */
    final class OfLong extends OfPrimitive implements LongConsumer {
        final long[] array;

        OfLong(int i) {
            this.array = new long[i];
        }

        public void accept(long j) {
            long[] jArr = this.array;
            int i = this.index;
            this.index = i + 1;
            jArr[i] = j;
        }

        public void forEach(Object obj, long j) {
            LongConsumer longConsumer = (LongConsumer) obj;
            for (int i = 0; ((long) i) < j; i++) {
                longConsumer.accept(this.array[i]);
            }
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$ArrayBuffer$OfPrimitive */
    abstract class OfPrimitive extends StreamSpliterators$ArrayBuffer {
        int index;

        OfPrimitive() {
        }

        /* access modifiers changed from: package-private */
        public abstract void forEach(Object obj, long j);
    }

    /* renamed from: j$.util.stream.StreamSpliterators$ArrayBuffer$OfRef */
    final class OfRef extends StreamSpliterators$ArrayBuffer implements Consumer {
        final Object[] array;

        OfRef(int i) {
            this.array = new Object[i];
        }

        public void accept(Object obj) {
            Object[] objArr = this.array;
            int i = this.index;
            this.index = i + 1;
            objArr[i] = obj;
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    StreamSpliterators$ArrayBuffer() {
    }
}
