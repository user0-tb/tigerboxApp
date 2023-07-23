package p009j$.util.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import p009j$.util.Comparator;
import p009j$.util.Spliterator;
import p009j$.util.function.IntFunction;
import p009j$.util.stream.Nodes;
import p009j$.util.stream.ReferencePipeline;

/* renamed from: j$.util.stream.SortedOps$OfRef */
final class SortedOps$OfRef extends ReferencePipeline.StatefulOp {
    private final Comparator comparator;
    private final boolean isNaturalSort;

    SortedOps$OfRef(AbstractPipeline abstractPipeline) {
        super(abstractPipeline, StreamShape.REFERENCE, StreamOpFlag.IS_ORDERED | StreamOpFlag.IS_SORTED);
        this.isNaturalSort = true;
        this.comparator = Comparator.CC.naturalOrder();
    }

    SortedOps$OfRef(AbstractPipeline abstractPipeline, java.util.Comparator comparator2) {
        super(abstractPipeline, StreamShape.REFERENCE, StreamOpFlag.IS_ORDERED | StreamOpFlag.NOT_SORTED);
        this.isNaturalSort = false;
        Objects.requireNonNull(comparator2);
        this.comparator = comparator2;
    }

    public Node opEvaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator, IntFunction intFunction) {
        if (StreamOpFlag.SORTED.isKnown(pipelineHelper.getStreamAndOpFlags()) && this.isNaturalSort) {
            return pipelineHelper.evaluate(spliterator, false, intFunction);
        }
        Object[] asArray = pipelineHelper.evaluate(spliterator, true, intFunction).asArray(intFunction);
        Arrays.sort(asArray, this.comparator);
        return new Nodes.ArrayNode(asArray);
    }

    public Sink opWrapSink(int i, Sink sink) {
        Objects.requireNonNull(sink);
        if (!StreamOpFlag.SORTED.isKnown(i) || !this.isNaturalSort) {
            return StreamOpFlag.SIZED.isKnown(i) ? new SortedOps$SizedRefSortingSink(sink, this.comparator) : new SortedOps$RefSortingSink(sink, this.comparator);
        }
        return sink;
    }
}
