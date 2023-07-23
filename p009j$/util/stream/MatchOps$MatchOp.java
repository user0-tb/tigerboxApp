package p009j$.util.stream;

import java.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.Supplier;

/* renamed from: j$.util.stream.MatchOps$MatchOp */
final class MatchOps$MatchOp implements TerminalOp {
    private final StreamShape inputShape;
    final MatchOps$MatchKind matchKind;
    final Supplier sinkSupplier;

    MatchOps$MatchOp(StreamShape streamShape, MatchOps$MatchKind matchOps$MatchKind, Supplier supplier) {
        this.inputShape = streamShape;
        this.matchKind = matchOps$MatchKind;
        this.sinkSupplier = supplier;
    }

    public Object evaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator) {
        return (Boolean) new MatchOps$MatchTask(this, pipelineHelper, spliterator).invoke();
    }

    public Object evaluateSequential(PipelineHelper pipelineHelper, Spliterator spliterator) {
        MatchOps$BooleanTerminalSink matchOps$BooleanTerminalSink = (MatchOps$BooleanTerminalSink) this.sinkSupplier.get();
        AbstractPipeline abstractPipeline = (AbstractPipeline) pipelineHelper;
        Objects.requireNonNull(matchOps$BooleanTerminalSink);
        abstractPipeline.copyInto(abstractPipeline.wrapSink(matchOps$BooleanTerminalSink), spliterator);
        return Boolean.valueOf(matchOps$BooleanTerminalSink.value);
    }

    public int getOpFlags() {
        return StreamOpFlag.IS_SHORT_CIRCUIT | StreamOpFlag.NOT_ORDERED;
    }
}
