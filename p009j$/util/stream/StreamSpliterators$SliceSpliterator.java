package p009j$.util.stream;

import java.util.Comparator;
import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.StreamSpliterators$SliceSpliterator */
abstract class StreamSpliterators$SliceSpliterator {
    long fence;
    long index;

    /* renamed from: s */
    Spliterator f255s;
    final long sliceFence;
    final long sliceOrigin;

    /* renamed from: j$.util.stream.StreamSpliterators$SliceSpliterator$OfDouble */
    final class OfDouble extends OfPrimitive implements Spliterator.OfDouble {
        OfDouble(Spliterator.OfDouble ofDouble, long j, long j2) {
            super(ofDouble, j, j2);
        }

        OfDouble(Spliterator.OfDouble ofDouble, long j, long j2, long j3, long j4) {
            super(ofDouble, j, j2, j3, j4, (Node.CC) null);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object emptyConsumer() {
            return C1455x1d92bb82.INSTANCE;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Objects.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
        }

        /* access modifiers changed from: protected */
        public Spliterator makeSpliterator(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new OfDouble((Spliterator.OfDouble) spliterator, j, j2, j3, j4);
        }

        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Objects.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$SliceSpliterator$OfInt */
    final class OfInt extends OfPrimitive implements Spliterator.OfInt {
        OfInt(Spliterator.OfInt ofInt, long j, long j2) {
            super(ofInt, j, j2);
        }

        OfInt(Spliterator.OfInt ofInt, long j, long j2, long j3, long j4) {
            super(ofInt, j, j2, j3, j4, (Node.CC) null);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object emptyConsumer() {
            return C1456xd052fd1c.INSTANCE;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Objects.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
        }

        /* access modifiers changed from: protected */
        public Spliterator makeSpliterator(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new OfInt((Spliterator.OfInt) spliterator, j, j2, j3, j4);
        }

        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Objects.$default$tryAdvance((Spliterator.OfInt) this, consumer);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$SliceSpliterator$OfLong */
    final class OfLong extends OfPrimitive implements Spliterator.OfLong {
        OfLong(Spliterator.OfLong ofLong, long j, long j2) {
            super(ofLong, j, j2);
        }

        OfLong(Spliterator.OfLong ofLong, long j, long j2, long j3, long j4) {
            super(ofLong, j, j2, j3, j4, (Node.CC) null);
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object emptyConsumer() {
            return C1457xec23d6ed.INSTANCE;
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Objects.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
        }

        /* access modifiers changed from: protected */
        public Spliterator makeSpliterator(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new OfLong((Spliterator.OfLong) spliterator, j, j2, j3, j4);
        }

        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Objects.$default$tryAdvance((Spliterator.OfLong) this, consumer);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$SliceSpliterator$OfPrimitive */
    abstract class OfPrimitive extends StreamSpliterators$SliceSpliterator implements Spliterator.OfPrimitive {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        OfPrimitive(p009j$.util.Spliterator.OfPrimitive r13, long r14, long r16) {
            /*
                r12 = this;
                long r0 = r13.estimateSize()
                r6 = r16
                long r10 = java.lang.Math.min(r0, r6)
                r8 = 0
                r2 = r12
                r3 = r13
                r4 = r14
                r2.<init>(r3, r4, r6, r8, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.StreamSpliterators$SliceSpliterator.OfPrimitive.<init>(j$.util.Spliterator$OfPrimitive, long, long):void");
        }

        /* access modifiers changed from: protected */
        public abstract Object emptyConsumer();

        public void forEachRemaining(Object obj) {
            java.util.Objects.requireNonNull(obj);
            long j = this.sliceOrigin;
            long j2 = this.fence;
            if (j < j2) {
                long j3 = this.index;
                if (j3 < j2) {
                    if (j3 < j || ((Spliterator.OfPrimitive) this.f255s).estimateSize() + j3 > this.sliceFence) {
                        while (this.sliceOrigin > this.index) {
                            ((Spliterator.OfPrimitive) this.f255s).tryAdvance(emptyConsumer());
                            this.index++;
                        }
                        while (this.index < this.fence) {
                            ((Spliterator.OfPrimitive) this.f255s).tryAdvance(obj);
                            this.index++;
                        }
                        return;
                    }
                    ((Spliterator.OfPrimitive) this.f255s).forEachRemaining(obj);
                    this.index = this.fence;
                }
            }
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

        public boolean tryAdvance(Object obj) {
            long j;
            java.util.Objects.requireNonNull(obj);
            if (this.sliceOrigin >= this.fence) {
                return false;
            }
            while (true) {
                long j2 = this.sliceOrigin;
                j = this.index;
                if (j2 <= j) {
                    break;
                }
                ((Spliterator.OfPrimitive) this.f255s).tryAdvance(emptyConsumer());
                this.index++;
            }
            if (j >= this.fence) {
                return false;
            }
            this.index = j + 1;
            return ((Spliterator.OfPrimitive) this.f255s).tryAdvance(obj);
        }

        OfPrimitive(Spliterator.OfPrimitive ofPrimitive, long j, long j2, long j3, long j4, Node.CC r10) {
            super(ofPrimitive, j, j2, j3, j4);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$SliceSpliterator$OfRef */
    final class OfRef extends StreamSpliterators$SliceSpliterator implements Spliterator {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        OfRef(p009j$.util.Spliterator r13, long r14, long r16) {
            /*
                r12 = this;
                long r0 = r13.estimateSize()
                r6 = r16
                long r10 = java.lang.Math.min(r0, r6)
                r8 = 0
                r2 = r12
                r3 = r13
                r4 = r14
                r2.<init>(r3, r4, r6, r8, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.StreamSpliterators$SliceSpliterator.OfRef.<init>(j$.util.Spliterator, long, long):void");
        }

        private OfRef(Spliterator spliterator, long j, long j2, long j3, long j4) {
            super(spliterator, j, j2, j3, j4);
        }

        public void forEachRemaining(Consumer consumer) {
            java.util.Objects.requireNonNull(consumer);
            long j = this.sliceOrigin;
            long j2 = this.fence;
            if (j < j2) {
                long j3 = this.index;
                if (j3 < j2) {
                    if (j3 < j || this.f255s.estimateSize() + j3 > this.sliceFence) {
                        while (this.sliceOrigin > this.index) {
                            this.f255s.tryAdvance(C1458xaa59d8c0.INSTANCE);
                            this.index++;
                        }
                        while (this.index < this.fence) {
                            this.f255s.tryAdvance(consumer);
                            this.index++;
                        }
                        return;
                    }
                    this.f255s.forEachRemaining(consumer);
                    this.index = this.fence;
                }
            }
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

        /* access modifiers changed from: protected */
        public Spliterator makeSpliterator(Spliterator spliterator, long j, long j2, long j3, long j4) {
            return new OfRef(spliterator, j, j2, j3, j4);
        }

        public boolean tryAdvance(Consumer consumer) {
            long j;
            java.util.Objects.requireNonNull(consumer);
            if (this.sliceOrigin >= this.fence) {
                return false;
            }
            while (true) {
                long j2 = this.sliceOrigin;
                j = this.index;
                if (j2 <= j) {
                    break;
                }
                this.f255s.tryAdvance(C1459xaa59d8c1.INSTANCE);
                this.index++;
            }
            if (j >= this.fence) {
                return false;
            }
            this.index = j + 1;
            return this.f255s.tryAdvance(consumer);
        }
    }

    StreamSpliterators$SliceSpliterator(Spliterator spliterator, long j, long j2, long j3, long j4) {
        this.f255s = spliterator;
        this.sliceOrigin = j;
        this.sliceFence = j2;
        this.index = j3;
        this.fence = j4;
    }

    public int characteristics() {
        return this.f255s.characteristics();
    }

    public long estimateSize() {
        long j = this.sliceOrigin;
        long j2 = this.fence;
        if (j < j2) {
            return j2 - Math.max(j, this.index);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract Spliterator makeSpliterator(Spliterator spliterator, long j, long j2, long j3, long j4);

    public Spliterator trySplit() {
        long j = this.sliceOrigin;
        long j2 = this.fence;
        if (j >= j2 || this.index >= j2) {
            return null;
        }
        while (true) {
            Spliterator trySplit = this.f255s.trySplit();
            if (trySplit == null) {
                return null;
            }
            long estimateSize = trySplit.estimateSize() + this.index;
            long min = Math.min(estimateSize, this.sliceFence);
            long j3 = this.sliceOrigin;
            if (j3 >= min) {
                this.index = min;
            } else {
                long j4 = this.sliceFence;
                if (min >= j4) {
                    this.f255s = trySplit;
                    this.fence = min;
                } else {
                    long j5 = this.index;
                    if (j5 < j3 || estimateSize > j4) {
                        this.index = min;
                        return makeSpliterator(trySplit, j3, j4, j5, min);
                    }
                    this.index = min;
                    return trySplit;
                }
            }
        }
    }
}
