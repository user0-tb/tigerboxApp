package p009j$.util.stream;

import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.StreamSpliterators$IntWrappingSpliterator */
final class StreamSpliterators$IntWrappingSpliterator extends StreamSpliterators$AbstractWrappingSpliterator implements Spliterator.OfInt {
    StreamSpliterators$IntWrappingSpliterator(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z) {
        super(pipelineHelper, spliterator, z);
    }

    StreamSpliterators$IntWrappingSpliterator(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        super(pipelineHelper, supplier, z);
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Objects.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
    }

    public void forEachRemaining(IntConsumer intConsumer) {
        if (this.buffer != null || this.finished) {
            do {
            } while (tryAdvance(intConsumer));
            return;
        }
        java.util.Objects.requireNonNull(intConsumer);
        init();
        this.f252ph.wrapAndCopyInto(new C1453x808788f0(intConsumer), this.spliterator);
        this.finished = true;
    }

    /* access modifiers changed from: package-private */
    public void initPartialTraversalState() {
        SpinedBuffer.OfInt ofInt = new SpinedBuffer.OfInt();
        this.buffer = ofInt;
        this.bufferSink = this.f252ph.wrapSink(new C1453x808788f0(ofInt));
        this.pusher = new SpinedBuffer$$ExternalSyntheticLambda0(this);
    }

    public /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return Objects.$default$tryAdvance((Spliterator.OfInt) this, consumer);
    }

    public boolean tryAdvance(IntConsumer intConsumer) {
        java.util.Objects.requireNonNull(intConsumer);
        boolean doAdvance = doAdvance();
        if (doAdvance) {
            SpinedBuffer.OfInt ofInt = (SpinedBuffer.OfInt) this.buffer;
            long j = this.nextToConsume;
            int chunkFor = ofInt.chunkFor(j);
            intConsumer.accept((ofInt.spineIndex == 0 && chunkFor == 0) ? ((int[]) ofInt.curChunk)[(int) j] : ((int[][]) ofInt.spine)[chunkFor][(int) (j - ofInt.priorElementCount[chunkFor])]);
        }
        return doAdvance;
    }

    public Spliterator.OfInt trySplit() {
        return (Spliterator.OfInt) super.trySplit();
    }

    /* access modifiers changed from: package-private */
    public StreamSpliterators$AbstractWrappingSpliterator wrap(Spliterator spliterator) {
        return new StreamSpliterators$IntWrappingSpliterator(this.f252ph, spliterator, this.isParallel);
    }
}
