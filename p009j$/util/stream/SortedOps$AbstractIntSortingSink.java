package p009j$.util.stream;

import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.SortedOps$AbstractIntSortingSink */
abstract class SortedOps$AbstractIntSortingSink extends Sink.ChainedInt {
    protected boolean cancellationWasRequested;

    SortedOps$AbstractIntSortingSink(Sink sink) {
        super(sink);
    }

    public final boolean cancellationRequested() {
        this.cancellationWasRequested = true;
        return false;
    }
}
