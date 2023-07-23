package p009j$.util.stream;

import java.util.Comparator;
import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.BooleanSupplier;
import p009j$.util.function.Supplier;

/* renamed from: j$.util.stream.StreamSpliterators$AbstractWrappingSpliterator */
abstract class StreamSpliterators$AbstractWrappingSpliterator implements Spliterator {
    AbstractSpinedBuffer buffer;
    Sink bufferSink;
    boolean finished;
    final boolean isParallel;
    long nextToConsume;

    /* renamed from: ph */
    final PipelineHelper f252ph;
    BooleanSupplier pusher;
    Spliterator spliterator;
    private Supplier spliteratorSupplier;

    StreamSpliterators$AbstractWrappingSpliterator(PipelineHelper pipelineHelper, Spliterator spliterator2, boolean z) {
        this.f252ph = pipelineHelper;
        this.spliteratorSupplier = null;
        this.spliterator = spliterator2;
        this.isParallel = z;
    }

    StreamSpliterators$AbstractWrappingSpliterator(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        this.f252ph = pipelineHelper;
        this.spliteratorSupplier = supplier;
        this.spliterator = null;
        this.isParallel = z;
    }

    private boolean fillBuffer() {
        boolean z;
        while (this.buffer.count() == 0) {
            if (!this.bufferSink.cancellationRequested()) {
                SpinedBuffer$$ExternalSyntheticLambda0 spinedBuffer$$ExternalSyntheticLambda0 = (SpinedBuffer$$ExternalSyntheticLambda0) this.pusher;
                switch (spinedBuffer$$ExternalSyntheticLambda0.$r8$classId) {
                    case 5:
                        StreamSpliterators$DoubleWrappingSpliterator streamSpliterators$DoubleWrappingSpliterator = (StreamSpliterators$DoubleWrappingSpliterator) spinedBuffer$$ExternalSyntheticLambda0.f$0;
                        z = streamSpliterators$DoubleWrappingSpliterator.spliterator.tryAdvance(streamSpliterators$DoubleWrappingSpliterator.bufferSink);
                        break;
                    case 6:
                        StreamSpliterators$IntWrappingSpliterator streamSpliterators$IntWrappingSpliterator = (StreamSpliterators$IntWrappingSpliterator) spinedBuffer$$ExternalSyntheticLambda0.f$0;
                        z = streamSpliterators$IntWrappingSpliterator.spliterator.tryAdvance(streamSpliterators$IntWrappingSpliterator.bufferSink);
                        break;
                    case 7:
                        StreamSpliterators$LongWrappingSpliterator streamSpliterators$LongWrappingSpliterator = (StreamSpliterators$LongWrappingSpliterator) spinedBuffer$$ExternalSyntheticLambda0.f$0;
                        z = streamSpliterators$LongWrappingSpliterator.spliterator.tryAdvance(streamSpliterators$LongWrappingSpliterator.bufferSink);
                        break;
                    default:
                        StreamSpliterators$WrappingSpliterator streamSpliterators$WrappingSpliterator = (StreamSpliterators$WrappingSpliterator) spinedBuffer$$ExternalSyntheticLambda0.f$0;
                        z = streamSpliterators$WrappingSpliterator.spliterator.tryAdvance(streamSpliterators$WrappingSpliterator.bufferSink);
                        break;
                }
                if (z) {
                    continue;
                }
            }
            if (this.finished) {
                return false;
            }
            this.bufferSink.end();
            this.finished = true;
        }
        return true;
    }

    public final int characteristics() {
        init();
        int streamFlags = StreamOpFlag.toStreamFlags(this.f252ph.getStreamAndOpFlags()) & StreamOpFlag.SPLITERATOR_CHARACTERISTICS_MASK;
        return (streamFlags & 64) != 0 ? (streamFlags & -16449) | (this.spliterator.characteristics() & 16448) : streamFlags;
    }

    /* access modifiers changed from: package-private */
    public final boolean doAdvance() {
        AbstractSpinedBuffer abstractSpinedBuffer = this.buffer;
        boolean z = false;
        if (abstractSpinedBuffer != null) {
            long j = this.nextToConsume + 1;
            this.nextToConsume = j;
            if (j < abstractSpinedBuffer.count()) {
                z = true;
            }
            if (z) {
                return z;
            }
            this.nextToConsume = 0;
            this.buffer.clear();
            return fillBuffer();
        } else if (this.finished) {
            return false;
        } else {
            init();
            initPartialTraversalState();
            this.nextToConsume = 0;
            this.bufferSink.begin(this.spliterator.getExactSizeIfKnown());
            return fillBuffer();
        }
    }

    public final long estimateSize() {
        init();
        return this.spliterator.estimateSize();
    }

    public Comparator getComparator() {
        if (Objects.$default$hasCharacteristics(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    public final long getExactSizeIfKnown() {
        init();
        if (StreamOpFlag.SIZED.isKnown(this.f252ph.getStreamAndOpFlags())) {
            return this.spliterator.getExactSizeIfKnown();
        }
        return -1;
    }

    public /* synthetic */ boolean hasCharacteristics(int i) {
        return Objects.$default$hasCharacteristics(this, i);
    }

    /* access modifiers changed from: package-private */
    public final void init() {
        if (this.spliterator == null) {
            this.spliterator = (Spliterator) this.spliteratorSupplier.get();
            this.spliteratorSupplier = null;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void initPartialTraversalState();

    public final String toString() {
        return String.format("%s[%s]", new Object[]{getClass().getName(), this.spliterator});
    }

    public Spliterator trySplit() {
        if (!this.isParallel || this.finished) {
            return null;
        }
        init();
        Spliterator trySplit = this.spliterator.trySplit();
        if (trySplit == null) {
            return null;
        }
        return wrap(trySplit);
    }

    /* access modifiers changed from: package-private */
    public abstract StreamSpliterators$AbstractWrappingSpliterator wrap(Spliterator spliterator2);
}
