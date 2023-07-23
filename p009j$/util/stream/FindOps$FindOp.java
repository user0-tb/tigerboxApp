package p009j$.util.stream;

import java.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Predicate;
import p009j$.util.function.Supplier;

/* renamed from: j$.util.stream.FindOps$FindOp */
final class FindOps$FindOp implements TerminalOp {
    final Object emptyValue;
    final boolean mustFindFirst;
    final Predicate presentPredicate;
    private final StreamShape shape;
    final Supplier sinkSupplier;

    FindOps$FindOp(boolean z, StreamShape streamShape, Object obj, Predicate predicate, Supplier supplier) {
        this.mustFindFirst = z;
        this.shape = streamShape;
        this.emptyValue = obj;
        this.presentPredicate = predicate;
        this.sinkSupplier = supplier;
    }

    public Object evaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator) {
        return new FindOps$FindTask(this, pipelineHelper, spliterator).invoke();
    }

    public Object evaluateSequential(PipelineHelper pipelineHelper, Spliterator spliterator) {
        TerminalSink terminalSink = (TerminalSink) this.sinkSupplier.get();
        AbstractPipeline abstractPipeline = (AbstractPipeline) pipelineHelper;
        Objects.requireNonNull(terminalSink);
        abstractPipeline.copyInto(abstractPipeline.wrapSink(terminalSink), spliterator);
        Object obj = terminalSink.get();
        return obj != null ? obj : this.emptyValue;
    }

    public int getOpFlags() {
        return StreamOpFlag.IS_SHORT_CIRCUIT | (this.mustFindFirst ? 0 : StreamOpFlag.NOT_ORDERED);
    }
}
