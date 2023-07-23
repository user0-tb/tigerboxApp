package p009j$.util.stream;

import java.util.Objects;
import p009j$.util.Spliterator;

/* renamed from: j$.util.stream.ReduceOps$ReduceOp */
abstract class ReduceOps$ReduceOp implements TerminalOp {
    private final StreamShape inputShape;

    ReduceOps$ReduceOp(StreamShape streamShape) {
        this.inputShape = streamShape;
    }

    public Object evaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator) {
        return ((ReduceOps$AccumulatingSink) new ReduceOps$ReduceTask(this, pipelineHelper, spliterator).invoke()).get();
    }

    public Object evaluateSequential(PipelineHelper pipelineHelper, Spliterator spliterator) {
        ReduceOps$AccumulatingSink makeSink = makeSink();
        AbstractPipeline abstractPipeline = (AbstractPipeline) pipelineHelper;
        Objects.requireNonNull(makeSink);
        abstractPipeline.copyInto(abstractPipeline.wrapSink(makeSink), spliterator);
        return makeSink.get();
    }

    public /* synthetic */ int getOpFlags() {
        return 0;
    }

    public abstract ReduceOps$AccumulatingSink makeSink();
}
