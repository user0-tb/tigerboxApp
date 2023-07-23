package p009j$.util.stream;

import p009j$.util.Spliterator;

/* renamed from: j$.util.stream.MatchOps$MatchTask */
final class MatchOps$MatchTask extends AbstractShortCircuitTask {

    /* renamed from: op */
    private final MatchOps$MatchOp f236op;

    MatchOps$MatchTask(MatchOps$MatchOp matchOps$MatchOp, PipelineHelper pipelineHelper, Spliterator spliterator) {
        super(pipelineHelper, spliterator);
        this.f236op = matchOps$MatchOp;
    }

    MatchOps$MatchTask(MatchOps$MatchTask matchOps$MatchTask, Spliterator spliterator) {
        super((AbstractShortCircuitTask) matchOps$MatchTask, spliterator);
        this.f236op = matchOps$MatchTask.f236op;
    }

    /* access modifiers changed from: protected */
    public Object doLeaf() {
        PipelineHelper pipelineHelper = this.helper;
        MatchOps$BooleanTerminalSink matchOps$BooleanTerminalSink = (MatchOps$BooleanTerminalSink) this.f236op.sinkSupplier.get();
        pipelineHelper.wrapAndCopyInto(matchOps$BooleanTerminalSink, this.spliterator);
        boolean z = matchOps$BooleanTerminalSink.value;
        if (z != this.f236op.matchKind.shortCircuitResult) {
            return null;
        }
        shortCircuit(Boolean.valueOf(z));
        return null;
    }

    /* access modifiers changed from: protected */
    public Object getEmptyResult() {
        return Boolean.valueOf(!this.f236op.matchKind.shortCircuitResult);
    }

    /* access modifiers changed from: protected */
    public AbstractTask makeChild(Spliterator spliterator) {
        return new MatchOps$MatchTask(this, spliterator);
    }
}
