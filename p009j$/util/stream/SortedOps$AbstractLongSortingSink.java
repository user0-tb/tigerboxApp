package p009j$.util.stream;

import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.SortedOps$AbstractLongSortingSink */
abstract class SortedOps$AbstractLongSortingSink extends Sink.ChainedLong {
    protected boolean cancellationWasRequested;

    SortedOps$AbstractLongSortingSink(Sink sink) {
        super(sink);
    }

    public final boolean cancellationRequested() {
        this.cancellationWasRequested = true;
        return false;
    }
}
