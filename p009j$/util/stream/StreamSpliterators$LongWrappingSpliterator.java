package p009j$.util.stream;

import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.LongConsumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.StreamSpliterators$LongWrappingSpliterator */
final class StreamSpliterators$LongWrappingSpliterator extends StreamSpliterators$AbstractWrappingSpliterator implements Spliterator.OfLong {
    StreamSpliterators$LongWrappingSpliterator(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z) {
        super(pipelineHelper, spliterator, z);
    }

    StreamSpliterators$LongWrappingSpliterator(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        super(pipelineHelper, supplier, z);
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Objects.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
    }

    public void forEachRemaining(LongConsumer longConsumer) {
        if (this.buffer != null || this.finished) {
            do {
            } while (tryAdvance(longConsumer));
            return;
        }
        java.util.Objects.requireNonNull(longConsumer);
        init();
        this.f252ph.wrapAndCopyInto(new C1454xa6d810a7(longConsumer), this.spliterator);
        this.finished = true;
    }

    /* access modifiers changed from: package-private */
    public void initPartialTraversalState() {
        SpinedBuffer.OfLong ofLong = new SpinedBuffer.OfLong();
        this.buffer = ofLong;
        this.bufferSink = this.f252ph.wrapSink(new C1454xa6d810a7(ofLong));
        this.pusher = new SpinedBuffer$$ExternalSyntheticLambda0(this);
    }

    public /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return Objects.$default$tryAdvance((Spliterator.OfLong) this, consumer);
    }

    public boolean tryAdvance(LongConsumer longConsumer) {
        java.util.Objects.requireNonNull(longConsumer);
        boolean doAdvance = doAdvance();
        if (doAdvance) {
            SpinedBuffer.OfLong ofLong = (SpinedBuffer.OfLong) this.buffer;
            long j = this.nextToConsume;
            int chunkFor = ofLong.chunkFor(j);
            longConsumer.accept((ofLong.spineIndex == 0 && chunkFor == 0) ? ((long[]) ofLong.curChunk)[(int) j] : ((long[][]) ofLong.spine)[chunkFor][(int) (j - ofLong.priorElementCount[chunkFor])]);
        }
        return doAdvance;
    }

    public Spliterator.OfLong trySplit() {
        return (Spliterator.OfLong) super.trySplit();
    }

    /* access modifiers changed from: package-private */
    public StreamSpliterators$AbstractWrappingSpliterator wrap(Spliterator spliterator) {
        return new StreamSpliterators$LongWrappingSpliterator(this.f252ph, spliterator, this.isParallel);
    }
}
