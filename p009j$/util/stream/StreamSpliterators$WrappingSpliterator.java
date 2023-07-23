package p009j$.util.stream;

import java.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.Supplier;

/* renamed from: j$.util.stream.StreamSpliterators$WrappingSpliterator */
final class StreamSpliterators$WrappingSpliterator extends StreamSpliterators$AbstractWrappingSpliterator {
    StreamSpliterators$WrappingSpliterator(PipelineHelper pipelineHelper, Spliterator spliterator, boolean z) {
        super(pipelineHelper, spliterator, z);
    }

    StreamSpliterators$WrappingSpliterator(PipelineHelper pipelineHelper, Supplier supplier, boolean z) {
        super(pipelineHelper, supplier, z);
    }

    public void forEachRemaining(Consumer consumer) {
        if (this.buffer != null || this.finished) {
            do {
            } while (tryAdvance(consumer));
            return;
        }
        Objects.requireNonNull(consumer);
        init();
        this.f252ph.wrapAndCopyInto(new StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda1(consumer), this.spliterator);
        this.finished = true;
    }

    /* access modifiers changed from: package-private */
    public void initPartialTraversalState() {
        SpinedBuffer spinedBuffer = new SpinedBuffer();
        this.buffer = spinedBuffer;
        this.bufferSink = this.f252ph.wrapSink(new StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda1(spinedBuffer));
        this.pusher = new SpinedBuffer$$ExternalSyntheticLambda0(this);
    }

    public boolean tryAdvance(Consumer consumer) {
        Object obj;
        Objects.requireNonNull(consumer);
        boolean doAdvance = doAdvance();
        if (doAdvance) {
            SpinedBuffer spinedBuffer = (SpinedBuffer) this.buffer;
            long j = this.nextToConsume;
            if (spinedBuffer.spineIndex == 0) {
                if (j < ((long) spinedBuffer.elementIndex)) {
                    obj = spinedBuffer.curChunk[(int) j];
                } else {
                    throw new IndexOutOfBoundsException(Long.toString(j));
                }
            } else if (j < spinedBuffer.count()) {
                int i = 0;
                while (i <= spinedBuffer.spineIndex) {
                    long[] jArr = spinedBuffer.priorElementCount;
                    long j2 = jArr[i];
                    Object[][] objArr = spinedBuffer.spine;
                    if (j < j2 + ((long) objArr[i].length)) {
                        obj = objArr[i][(int) (j - jArr[i])];
                    } else {
                        i++;
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
            consumer.accept(obj);
        }
        return doAdvance;
    }

    /* access modifiers changed from: package-private */
    public StreamSpliterators$AbstractWrappingSpliterator wrap(Spliterator spliterator) {
        return new StreamSpliterators$WrappingSpliterator(this.f252ph, spliterator, this.isParallel);
    }
}
