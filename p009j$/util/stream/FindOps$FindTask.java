package p009j$.util.stream;

import java.util.concurrent.CountedCompleter;
import p009j$.util.Spliterator;

/* renamed from: j$.util.stream.FindOps$FindTask */
final class FindOps$FindTask extends AbstractShortCircuitTask {

    /* renamed from: op */
    private final FindOps$FindOp f235op;

    FindOps$FindTask(FindOps$FindOp findOps$FindOp, PipelineHelper pipelineHelper, Spliterator spliterator) {
        super(pipelineHelper, spliterator);
        this.f235op = findOps$FindOp;
    }

    FindOps$FindTask(FindOps$FindTask findOps$FindTask, Spliterator spliterator) {
        super((AbstractShortCircuitTask) findOps$FindTask, spliterator);
        this.f235op = findOps$FindTask.f235op;
    }

    private void foundResult(Object obj) {
        boolean z;
        AbstractTask abstractTask = this;
        while (true) {
            if (abstractTask != null) {
                AbstractTask parent = abstractTask.getParent();
                if (parent != null && parent.leftChild != abstractTask) {
                    z = false;
                    break;
                }
                abstractTask = parent;
            } else {
                z = true;
                break;
            }
        }
        if (z) {
            shortCircuit(obj);
        } else {
            cancelLaterNodes();
        }
    }

    /* access modifiers changed from: protected */
    public Object doLeaf() {
        PipelineHelper pipelineHelper = this.helper;
        TerminalSink terminalSink = (TerminalSink) this.f235op.sinkSupplier.get();
        pipelineHelper.wrapAndCopyInto(terminalSink, this.spliterator);
        Object obj = terminalSink.get();
        if (!this.f235op.mustFindFirst) {
            if (obj != null) {
                shortCircuit(obj);
            }
            return null;
        } else if (obj == null) {
            return null;
        } else {
            foundResult(obj);
            return obj;
        }
    }

    /* access modifiers changed from: protected */
    public Object getEmptyResult() {
        return this.f235op.emptyValue;
    }

    /* access modifiers changed from: protected */
    public AbstractTask makeChild(Spliterator spliterator) {
        return new FindOps$FindTask(this, spliterator);
    }

    public void onCompletion(CountedCompleter countedCompleter) {
        if (this.f235op.mustFindFirst) {
            FindOps$FindTask findOps$FindTask = (FindOps$FindTask) this.leftChild;
            FindOps$FindTask findOps$FindTask2 = null;
            while (true) {
                if (findOps$FindTask != findOps$FindTask2) {
                    Object localResult = findOps$FindTask.getLocalResult();
                    if (localResult != null && this.f235op.presentPredicate.test(localResult)) {
                        setLocalResult(localResult);
                        foundResult(localResult);
                        break;
                    }
                    findOps$FindTask2 = findOps$FindTask;
                    findOps$FindTask = (FindOps$FindTask) this.rightChild;
                } else {
                    break;
                }
            }
        }
        this.spliterator = null;
        this.rightChild = null;
        this.leftChild = null;
    }
}
