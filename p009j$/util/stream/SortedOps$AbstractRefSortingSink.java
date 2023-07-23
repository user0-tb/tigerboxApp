package p009j$.util.stream;

import java.util.Comparator;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.SortedOps$AbstractRefSortingSink */
abstract class SortedOps$AbstractRefSortingSink extends Sink.ChainedReference {
    protected boolean cancellationWasRequested;
    protected final Comparator comparator;

    SortedOps$AbstractRefSortingSink(Sink sink, Comparator comparator2) {
        super(sink);
        this.comparator = comparator2;
    }

    public final boolean cancellationRequested() {
        this.cancellationWasRequested = true;
        return false;
    }
}
