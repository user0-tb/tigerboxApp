package p009j$.util.stream;

import java.util.concurrent.CountedCompleter;
import p009j$.util.Spliterator;

/* renamed from: j$.util.stream.ForEachOps$ForEachTask */
final class ForEachOps$ForEachTask extends CountedCompleter {
    private final PipelineHelper helper;
    private final Sink sink;
    private Spliterator spliterator;
    private long targetSize;

    ForEachOps$ForEachTask(ForEachOps$ForEachTask forEachOps$ForEachTask, Spliterator spliterator2) {
        super(forEachOps$ForEachTask);
        this.spliterator = spliterator2;
        this.sink = forEachOps$ForEachTask.sink;
        this.targetSize = forEachOps$ForEachTask.targetSize;
        this.helper = forEachOps$ForEachTask.helper;
    }

    ForEachOps$ForEachTask(PipelineHelper pipelineHelper, Spliterator spliterator2, Sink sink2) {
        super((CountedCompleter) null);
        this.sink = sink2;
        this.helper = pipelineHelper;
        this.spliterator = spliterator2;
        this.targetSize = 0;
    }

    public void compute() {
        Spliterator trySplit;
        Spliterator spliterator2 = this.spliterator;
        long estimateSize = spliterator2.estimateSize();
        long j = this.targetSize;
        if (j == 0) {
            j = AbstractTask.suggestTargetSize(estimateSize);
            this.targetSize = j;
        }
        boolean isKnown = StreamOpFlag.SHORT_CIRCUIT.isKnown(this.helper.getStreamAndOpFlags());
        boolean z = false;
        Sink sink2 = this.sink;
        ForEachOps$ForEachTask forEachOps$ForEachTask = this;
        while (true) {
            if (isKnown && sink2.cancellationRequested()) {
                break;
            } else if (estimateSize <= j || (trySplit = spliterator2.trySplit()) == null) {
                forEachOps$ForEachTask.helper.copyInto(sink2, spliterator2);
            } else {
                ForEachOps$ForEachTask forEachOps$ForEachTask2 = new ForEachOps$ForEachTask(forEachOps$ForEachTask, trySplit);
                forEachOps$ForEachTask.addToPendingCount(1);
                if (z) {
                    spliterator2 = trySplit;
                } else {
                    ForEachOps$ForEachTask forEachOps$ForEachTask3 = forEachOps$ForEachTask;
                    forEachOps$ForEachTask = forEachOps$ForEachTask2;
                    forEachOps$ForEachTask2 = forEachOps$ForEachTask3;
                }
                z = !z;
                forEachOps$ForEachTask.fork();
                forEachOps$ForEachTask = forEachOps$ForEachTask2;
                estimateSize = spliterator2.estimateSize();
            }
        }
        forEachOps$ForEachTask.helper.copyInto(sink2, spliterator2);
        forEachOps$ForEachTask.spliterator = null;
        forEachOps$ForEachTask.propagateCompletion();
    }
}
