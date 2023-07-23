package p009j$.util.stream;

import java.util.concurrent.atomic.AtomicReference;
import p009j$.util.Spliterator;

/* renamed from: j$.util.stream.AbstractShortCircuitTask */
abstract class AbstractShortCircuitTask extends AbstractTask {
    protected volatile boolean canceled;
    protected final AtomicReference sharedResult;

    protected AbstractShortCircuitTask(AbstractShortCircuitTask abstractShortCircuitTask, Spliterator spliterator) {
        super((AbstractTask) abstractShortCircuitTask, spliterator);
        this.sharedResult = abstractShortCircuitTask.sharedResult;
    }

    protected AbstractShortCircuitTask(PipelineHelper pipelineHelper, Spliterator spliterator) {
        super(pipelineHelper, spliterator);
        this.sharedResult = new AtomicReference((Object) null);
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        this.canceled = true;
    }

    /* access modifiers changed from: protected */
    public void cancelLaterNodes() {
        AbstractShortCircuitTask abstractShortCircuitTask = this;
        for (AbstractShortCircuitTask abstractShortCircuitTask2 = (AbstractShortCircuitTask) getParent(); abstractShortCircuitTask2 != null; abstractShortCircuitTask2 = (AbstractShortCircuitTask) abstractShortCircuitTask2.getParent()) {
            if (abstractShortCircuitTask2.leftChild == abstractShortCircuitTask) {
                AbstractShortCircuitTask abstractShortCircuitTask3 = (AbstractShortCircuitTask) abstractShortCircuitTask2.rightChild;
                if (!abstractShortCircuitTask3.canceled) {
                    abstractShortCircuitTask3.cancel();
                }
            }
            abstractShortCircuitTask = abstractShortCircuitTask2;
        }
    }

    public void compute() {
        Object obj;
        Spliterator trySplit;
        Spliterator spliterator = this.spliterator;
        long estimateSize = spliterator.estimateSize();
        long j = this.targetSize;
        if (j == 0) {
            j = AbstractTask.suggestTargetSize(estimateSize);
            this.targetSize = j;
        }
        boolean z = false;
        AtomicReference atomicReference = this.sharedResult;
        AbstractShortCircuitTask abstractShortCircuitTask = this;
        while (true) {
            obj = atomicReference.get();
            if (obj != null) {
                break;
            }
            boolean z2 = abstractShortCircuitTask.canceled;
            if (!z2) {
                AbstractTask parent = abstractShortCircuitTask.getParent();
                while (true) {
                    AbstractShortCircuitTask abstractShortCircuitTask2 = (AbstractShortCircuitTask) parent;
                    if (z2 || abstractShortCircuitTask2 == null) {
                        break;
                    }
                    z2 = abstractShortCircuitTask2.canceled;
                    parent = abstractShortCircuitTask2.getParent();
                }
            }
            if (z2) {
                obj = abstractShortCircuitTask.getEmptyResult();
                break;
            } else if (estimateSize <= j || (trySplit = spliterator.trySplit()) == null) {
                obj = abstractShortCircuitTask.doLeaf();
            } else {
                AbstractShortCircuitTask abstractShortCircuitTask3 = (AbstractShortCircuitTask) abstractShortCircuitTask.makeChild(trySplit);
                abstractShortCircuitTask.leftChild = abstractShortCircuitTask3;
                AbstractShortCircuitTask abstractShortCircuitTask4 = (AbstractShortCircuitTask) abstractShortCircuitTask.makeChild(spliterator);
                abstractShortCircuitTask.rightChild = abstractShortCircuitTask4;
                abstractShortCircuitTask.setPendingCount(1);
                if (z) {
                    spliterator = trySplit;
                    abstractShortCircuitTask = abstractShortCircuitTask3;
                    abstractShortCircuitTask3 = abstractShortCircuitTask4;
                } else {
                    abstractShortCircuitTask = abstractShortCircuitTask4;
                }
                z = !z;
                abstractShortCircuitTask3.fork();
                estimateSize = spliterator.estimateSize();
            }
        }
        abstractShortCircuitTask.setLocalResult(obj);
        abstractShortCircuitTask.tryComplete();
    }

    /* access modifiers changed from: protected */
    public abstract Object getEmptyResult();

    public Object getLocalResult() {
        if (!isRoot()) {
            return super.getLocalResult();
        }
        Object obj = this.sharedResult.get();
        return obj == null ? getEmptyResult() : obj;
    }

    public Object getRawResult() {
        return getLocalResult();
    }

    /* access modifiers changed from: protected */
    public void setLocalResult(Object obj) {
        if (!isRoot()) {
            super.setLocalResult(obj);
        } else if (obj != null) {
            this.sharedResult.compareAndSet((Object) null, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void shortCircuit(Object obj) {
        if (obj != null) {
            this.sharedResult.compareAndSet((Object) null, obj);
        }
    }
}
