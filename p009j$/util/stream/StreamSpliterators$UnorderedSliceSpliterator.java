package p009j$.util.stream;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;
import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;
import p009j$.util.stream.StreamSpliterators$ArrayBuffer;

/* renamed from: j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator */
abstract class StreamSpliterators$UnorderedSliceSpliterator {
    private final AtomicLong permits;

    /* renamed from: s */
    protected final Spliterator f256s;
    private final long skipThreshold;
    protected final boolean unlimited;

    /* renamed from: j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfDouble */
    final class OfDouble extends OfPrimitive implements Spliterator.OfDouble, DoubleConsumer {
        double tmpValue;

        OfDouble(Spliterator.OfDouble ofDouble, long j, long j2) {
            super(ofDouble, j, j2);
        }

        OfDouble(Spliterator.OfDouble ofDouble, OfDouble ofDouble2) {
            super(ofDouble, ofDouble2);
        }

        public void accept(double d) {
            this.tmpValue = d;
        }

        /* access modifiers changed from: protected */
        public void acceptConsumed(Object obj) {
            ((DoubleConsumer) obj).accept(this.tmpValue);
        }

        /* access modifiers changed from: protected */
        public StreamSpliterators$ArrayBuffer.OfPrimitive bufferCreate(int i) {
            return new StreamSpliterators$ArrayBuffer.OfDouble(i);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Objects.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
        }

        /* access modifiers changed from: protected */
        public Spliterator makeSpliterator(Spliterator spliterator) {
            return new OfDouble((Spliterator.OfDouble) spliterator, this);
        }

        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Objects.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfInt */
    final class OfInt extends OfPrimitive implements Spliterator.OfInt, IntConsumer {
        int tmpValue;

        OfInt(Spliterator.OfInt ofInt, long j, long j2) {
            super(ofInt, j, j2);
        }

        OfInt(Spliterator.OfInt ofInt, OfInt ofInt2) {
            super(ofInt, ofInt2);
        }

        public void accept(int i) {
            this.tmpValue = i;
        }

        /* access modifiers changed from: protected */
        public void acceptConsumed(Object obj) {
            ((IntConsumer) obj).accept(this.tmpValue);
        }

        /* access modifiers changed from: protected */
        public StreamSpliterators$ArrayBuffer.OfPrimitive bufferCreate(int i) {
            return new StreamSpliterators$ArrayBuffer.OfInt(i);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Objects.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
        }

        /* access modifiers changed from: protected */
        public Spliterator makeSpliterator(Spliterator spliterator) {
            return new OfInt((Spliterator.OfInt) spliterator, this);
        }

        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Objects.$default$tryAdvance((Spliterator.OfInt) this, consumer);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfLong */
    final class OfLong extends OfPrimitive implements Spliterator.OfLong, LongConsumer {
        long tmpValue;

        OfLong(Spliterator.OfLong ofLong, long j, long j2) {
            super(ofLong, j, j2);
        }

        OfLong(Spliterator.OfLong ofLong, OfLong ofLong2) {
            super(ofLong, ofLong2);
        }

        public void accept(long j) {
            this.tmpValue = j;
        }

        /* access modifiers changed from: protected */
        public void acceptConsumed(Object obj) {
            ((LongConsumer) obj).accept(this.tmpValue);
        }

        /* access modifiers changed from: protected */
        public StreamSpliterators$ArrayBuffer.OfPrimitive bufferCreate(int i) {
            return new StreamSpliterators$ArrayBuffer.OfLong(i);
        }

        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Objects.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
        }

        /* access modifiers changed from: protected */
        public Spliterator makeSpliterator(Spliterator spliterator) {
            return new OfLong((Spliterator.OfLong) spliterator, this);
        }

        public /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Objects.$default$tryAdvance((Spliterator.OfLong) this, consumer);
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfPrimitive */
    abstract class OfPrimitive extends StreamSpliterators$UnorderedSliceSpliterator implements Spliterator.OfPrimitive {
        OfPrimitive(Spliterator.OfPrimitive ofPrimitive, long j, long j2) {
            super(ofPrimitive, j, j2);
        }

        OfPrimitive(Spliterator.OfPrimitive ofPrimitive, OfPrimitive ofPrimitive2) {
            super(ofPrimitive, ofPrimitive2);
        }

        /* access modifiers changed from: protected */
        public abstract void acceptConsumed(Object obj);

        /* access modifiers changed from: protected */
        public abstract StreamSpliterators$ArrayBuffer.OfPrimitive bufferCreate(int i);

        public void forEachRemaining(Object obj) {
            java.util.Objects.requireNonNull(obj);
            StreamSpliterators$ArrayBuffer.OfPrimitive ofPrimitive = null;
            while (true) {
                int permitStatus$enumunboxing$ = permitStatus$enumunboxing$();
                if (permitStatus$enumunboxing$ == 1) {
                    return;
                }
                if (permitStatus$enumunboxing$ == 2) {
                    if (ofPrimitive == null) {
                        ofPrimitive = bufferCreate(128);
                    } else {
                        ofPrimitive.index = 0;
                    }
                    long j = 0;
                    while (((Spliterator.OfPrimitive) this.f256s).tryAdvance(ofPrimitive)) {
                        j++;
                        if (j >= 128) {
                            break;
                        }
                    }
                    if (j != 0) {
                        ofPrimitive.forEach(obj, acquirePermits(j));
                    } else {
                        return;
                    }
                } else {
                    ((Spliterator.OfPrimitive) this.f256s).forEachRemaining(obj);
                    return;
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
            java.util.Objects.requireNonNull(obj);
            while (permitStatus$enumunboxing$() != 1 && ((Spliterator.OfPrimitive) this.f256s).tryAdvance(this)) {
                if (acquirePermits(1) == 1) {
                    acceptConsumed(obj);
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator$OfRef */
    final class OfRef extends StreamSpliterators$UnorderedSliceSpliterator implements Spliterator, Consumer {
        Object tmpSlot;

        OfRef(Spliterator spliterator, long j, long j2) {
            super(spliterator, j, j2);
        }

        OfRef(Spliterator spliterator, OfRef ofRef) {
            super(spliterator, ofRef);
        }

        public final void accept(Object obj) {
            this.tmpSlot = obj;
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public void forEachRemaining(Consumer consumer) {
            java.util.Objects.requireNonNull(consumer);
            StreamSpliterators$ArrayBuffer.OfRef ofRef = null;
            while (true) {
                int permitStatus$enumunboxing$ = permitStatus$enumunboxing$();
                if (permitStatus$enumunboxing$ == 1) {
                    return;
                }
                if (permitStatus$enumunboxing$ == 2) {
                    if (ofRef == null) {
                        ofRef = new StreamSpliterators$ArrayBuffer.OfRef(128);
                    } else {
                        ofRef.index = 0;
                    }
                    long j = 0;
                    while (this.f256s.tryAdvance(ofRef)) {
                        j++;
                        if (j >= 128) {
                            break;
                        }
                    }
                    if (j != 0) {
                        long acquirePermits = acquirePermits(j);
                        for (int i = 0; ((long) i) < acquirePermits; i++) {
                            consumer.accept(ofRef.array[i]);
                        }
                    } else {
                        return;
                    }
                } else {
                    this.f256s.forEachRemaining(consumer);
                    return;
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
        public Spliterator makeSpliterator(Spliterator spliterator) {
            return new OfRef(spliterator, this);
        }

        public boolean tryAdvance(Consumer consumer) {
            java.util.Objects.requireNonNull(consumer);
            while (permitStatus$enumunboxing$() != 1 && this.f256s.tryAdvance(this)) {
                if (acquirePermits(1) == 1) {
                    consumer.accept(this.tmpSlot);
                    this.tmpSlot = null;
                    return true;
                }
            }
            return false;
        }
    }

    StreamSpliterators$UnorderedSliceSpliterator(Spliterator spliterator, long j, long j2) {
        this.f256s = spliterator;
        long j3 = 0;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        this.unlimited = i < 0;
        this.skipThreshold = i >= 0 ? j2 : j3;
        this.permits = new AtomicLong(i >= 0 ? j + j2 : j);
    }

    StreamSpliterators$UnorderedSliceSpliterator(Spliterator spliterator, StreamSpliterators$UnorderedSliceSpliterator streamSpliterators$UnorderedSliceSpliterator) {
        this.f256s = spliterator;
        this.unlimited = streamSpliterators$UnorderedSliceSpliterator.unlimited;
        this.permits = streamSpliterators$UnorderedSliceSpliterator.permits;
        this.skipThreshold = streamSpliterators$UnorderedSliceSpliterator.skipThreshold;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long acquirePermits(long r10) {
        /*
            r9 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicLong r0 = r9.permits
            long r0 = r0.get()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0013
            boolean r0 = r9.unlimited
            if (r0 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r10 = r2
        L_0x0012:
            return r10
        L_0x0013:
            long r4 = java.lang.Math.min(r0, r10)
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0025
            java.util.concurrent.atomic.AtomicLong r6 = r9.permits
            long r7 = r0 - r4
            boolean r6 = r6.compareAndSet(r0, r7)
            if (r6 == 0) goto L_0x0000
        L_0x0025:
            boolean r6 = r9.unlimited
            if (r6 == 0) goto L_0x002f
            long r10 = r10 - r4
            long r10 = java.lang.Math.max(r10, r2)
            return r10
        L_0x002f:
            long r10 = r9.skipThreshold
            int r6 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r6 <= 0) goto L_0x003c
            long r0 = r0 - r10
            long r4 = r4 - r0
            long r10 = java.lang.Math.max(r4, r2)
            return r10
        L_0x003c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.util.stream.StreamSpliterators$UnorderedSliceSpliterator.acquirePermits(long):long");
    }

    public final int characteristics() {
        return this.f256s.characteristics() & -16465;
    }

    public final long estimateSize() {
        return this.f256s.estimateSize();
    }

    /* access modifiers changed from: protected */
    public abstract Spliterator makeSpliterator(Spliterator spliterator);

    /* access modifiers changed from: protected */
    public final int permitStatus$enumunboxing$() {
        if (this.permits.get() > 0) {
            return 2;
        }
        return this.unlimited ? 3 : 1;
    }

    public final Spliterator trySplit() {
        Spliterator trySplit;
        if (this.permits.get() == 0 || (trySplit = this.f256s.trySplit()) == null) {
            return null;
        }
        return makeSpliterator(trySplit);
    }
}
