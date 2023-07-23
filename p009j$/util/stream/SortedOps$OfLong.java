package p009j$.util.stream;

import java.util.Arrays;
import java.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.function.IntFunction;
import p009j$.util.stream.LongPipeline;
import p009j$.util.stream.Node;
import p009j$.util.stream.Nodes;

/* renamed from: j$.util.stream.SortedOps$OfLong */
final class SortedOps$OfLong extends LongPipeline.StatefulOp {
    SortedOps$OfLong(AbstractPipeline abstractPipeline) {
        super(abstractPipeline, StreamShape.LONG_VALUE, StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
    }

    public Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
        if (StreamOpFlag.SORTED.isKnown(pipelineHelper.getStreamAndOpFlags())) {
            return pipelineHelper.evaluate(spliterator, false, intFunction);
        }
        long[] jArr = (long[]) ((Node.OfLong) pipelineHelper.evaluate(spliterator, true, intFunction)).asPrimitiveArray();
        Arrays.sort(jArr);
        return new Nodes.LongArrayNode(jArr);
    }

    public Sink opWrapSink(int i, Sink sink) {
        Objects.requireNonNull(sink);
        if (StreamOpFlag.SORTED.isKnown(i)) {
            return sink;
        }
        return StreamOpFlag.SIZED.isKnown(i) ? new SortedOps$SizedLongSortingSink(sink) : new SortedOps$LongSortingSink(sink);
    }
}
