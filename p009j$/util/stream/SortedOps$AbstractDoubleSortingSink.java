package p009j$.util.stream;

import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.SortedOps$AbstractDoubleSortingSink */
abstract class SortedOps$AbstractDoubleSortingSink extends Sink.ChainedDouble {
    protected boolean cancellationWasRequested;

    SortedOps$AbstractDoubleSortingSink(Sink sink) {
        super(sink);
    }

    public final boolean cancellationRequested() {
        this.cancellationWasRequested = true;
        return false;
    }
}
