package p009j$.util.stream;

import java.util.Arrays;
import java.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.IntFunction;
import p009j$.util.stream.DoublePipeline;
import p009j$.util.stream.Node;
import p009j$.util.stream.Nodes;

/* renamed from: j$.util.stream.SortedOps$OfDouble */
final class SortedOps$OfDouble extends DoublePipeline.StatefulOp {
    SortedOps$OfDouble(AbstractPipeline abstractPipeline) {
        super(abstractPipeline, StreamShape.DOUBLE_VALUE, StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
    }

    public Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
        if (StreamOpFlag.SORTED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
            return pipelineHelper.evaluate(spliterator, false, intFunction);
        }
        double[] dArr = (double[]) ((Node.OfDouble) pipelineHelper.evaluate(spliterator, true, intFunction)).asPrimitiveArray();
        Arrays.sort(dArr);
        return new Nodes.DoubleArrayNode(dArr);
    }

    public Sink opWrapSink(int i, Sink sink) {
        Objects.requireNonNull(sink);
        if (StreamOpFlag.SORTED.isKnown(i)) {
            return sink;
        }
        return StreamOpFlag.SIZED.isKnown(i) ? new SortedOps$SizedDoubleSortingSink(sink) : new SortedOps$DoubleSortingSink(sink);
    }
}
