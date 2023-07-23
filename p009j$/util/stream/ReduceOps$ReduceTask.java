package p009j$.util.stream;

import java.util.concurrent.CountedCompleter;
import p009j$.util.Spliterator;

/* renamed from: j$.util.stream.ReduceOps$ReduceTask */
final class ReduceOps$ReduceTask extends AbstractTask {

    /* renamed from: op */
    private final ReduceOps$ReduceOp f238op;

    ReduceOps$ReduceTask(ReduceOps$ReduceOp reduceOps$ReduceOp, PipelineHelper pipelineHelper, Spliterator spliterator) {
        super(pipelineHelper, spliterator);
        this.f238op = reduceOps$ReduceOp;
    }

    ReduceOps$ReduceTask(ReduceOps$ReduceTask reduceOps$ReduceTask, Spliterator spliterator) {
        super((AbstractTask) reduceOps$ReduceTask, spliterator);
        this.f238op = reduceOps$ReduceTask.f238op;
    }

    /* access modifiers changed from: protected */
    public Object doLeaf() {
        PipelineHelper pipelineHelper = this.helper;
        ReduceOps$AccumulatingSink makeSink = this.f238op.makeSink();
        pipelineHelper.wrapAndCopyInto(makeSink, this.spliterator);
        return makeSink;
    }

    /* access modifiers changed from: protected */
    public AbstractTask makeChild(Spliterator spliterator) {
        return new ReduceOps$ReduceTask(this, spliterator);
    }

    public void onCompletion(CountedCompleter countedCompleter) {
        if (!isLeaf()) {
            ReduceOps$AccumulatingSink reduceOps$AccumulatingSink = (ReduceOps$AccumulatingSink) ((ReduceOps$ReduceTask) this.leftChild).getLocalResult();
            reduceOps$AccumulatingSink.combine((ReduceOps$AccumulatingSink) ((ReduceOps$ReduceTask) this.rightChild).getLocalResult());
            setLocalResult(reduceOps$AccumulatingSink);
        }
        this.spliterator = null;
        this.rightChild = null;
        this.leftChild = null;
    }
}
