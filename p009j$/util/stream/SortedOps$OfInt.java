package p009j$.util.stream;

import java.util.Arrays;
import java.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.IntFunction;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.Node;
import p009j$.util.stream.Nodes;

/* renamed from: j$.util.stream.SortedOps$OfInt */
final class SortedOps$OfInt extends IntPipeline.StatefulOp {
    SortedOps$OfInt(AbstractPipeline abstractPipeline) {
        super(abstractPipeline, StreamShape.INT_VALUE, StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
    }

    public Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
        if (StreamOpFlag.SORTED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
            return pipelineHelper.evaluate(spliterator, false, intFunction);
        }
        int[] iArr = (int[]) ((Node.OfInt) pipelineHelper.evaluate(spliterator, true, intFunction)).asPrimitiveArray();
        Arrays.sort(iArr);
        return new Nodes.IntArrayNode(iArr);
    }

    public Sink opWrapSink(int i, Sink sink) {
        Objects.requireNonNull(sink);
        if (StreamOpFlag.SORTED.isKnown(i)) {
            return sink;
        }
        return StreamOpFlag.SIZED.isKnown(i) ? new SortedOps$SizedIntSortingSink(sink) : new SortedOps$IntSortingSink(sink);
    }
}
