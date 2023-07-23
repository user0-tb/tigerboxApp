package p009j$.util.stream;

import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.StreamSpliterators$DoubleWrappingSpliterator */
final class StreamSpliterators$DoubleWrappingSpliterator extends StreamSpliterators$AbstractWrappingSpliterator implements Spliterator.OfDouble {
    StreamSpliterators$DoubleWrappingSpliterator(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z) {
        super(pipelineHelper, spliterator, z);
    }

    StreamSpliterators$DoubleWrappingSpliterator(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        super(pipelineHelper, supplier, z);
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Objects.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
    }

    public void forEachRemaining(DoubleConsumer doubleConsumer) {
        if (this.buffer != null || this.finished) {
            do {
            } while (tryAdvance(doubleConsumer));
            return;
        }
        java.util.Objects.requireNonNull(doubleConsumer);
        init();
        this.f252ph.wrapAndCopyInto(new C1452xc57d6cf2(doubleConsumer), this.spliterator);
        this.finished = true;
    }

    /* access modifiers changed from: package-private */
    public void initPartialTraversalState() {
        SpinedBuffer.OfDouble ofDouble = new SpinedBuffer.OfDouble();
        this.buffer = ofDouble;
        this.bufferSink = this.f252ph.wrapSink(new C1452xc57d6cf2(ofDouble));
        this.pusher = new SpinedBuffer$$ExternalSyntheticLambda0(this);
    }

    public /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return Objects.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
    }

    public boolean tryAdvance(DoubleConsumer doubleConsumer) {
        java.util.Objects.requireNonNull(doubleConsumer);
        boolean doAdvance = doAdvance();
        if (doAdvance) {
            SpinedBuffer.OfDouble ofDouble = (SpinedBuffer.OfDouble) this.buffer;
            long j = this.nextToConsume;
            int chunkFor = ofDouble.chunkFor(j);
            doubleConsumer.accept((ofDouble.spineIndex == 0 && chunkFor == 0) ? ((double[]) ofDouble.curChunk)[(int) j] : ((double[][]) ofDouble.spine)[chunkFor][(int) (j - ofDouble.priorElementCount[chunkFor])]);
        }
        return doAdvance;
    }

    public Spliterator.OfDouble trySplit() {
        return (Spliterator.OfDouble) super.trySplit();
    }

    /* access modifiers changed from: package-private */
    public StreamSpliterators$AbstractWrappingSpliterator wrap(Spliterator spliterator) {
        return new StreamSpliterators$DoubleWrappingSpliterator(this.f252ph, spliterator, this.isParallel);
    }
}
