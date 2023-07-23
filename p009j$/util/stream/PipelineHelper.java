package p009j$.util.stream;

import p009j$.util.Spliterator;
import p009j$.util.function.IntFunction;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.PipelineHelper */
abstract class PipelineHelper {
    PipelineHelper() {
    }

    /* access modifiers changed from: package-private */
    public abstract void copyInto(Sink sink, Spliterator spliterator);

    /* access modifiers changed from: package-private */
    public abstract void copyIntoWithCancel(Sink sink, Spliterator spliterator);

    /* access modifiers changed from: package-private */
    public abstract Node evaluate(Spliterator spliterator, boolean z, IntFunction intFunction);

    /* access modifiers changed from: package-private */
    public abstract long exactOutputSizeIfKnown(Spliterator spliterator);

    /* access modifiers changed from: package-private */
    public abstract StreamShape getSourceShape();

    /* access modifiers changed from: package-private */
    public abstract int getStreamAndOpFlags();

    /* access modifiers changed from: package-private */
    public abstract Node.Builder makeNodeBuilder(long j, IntFunction intFunction);

    /* access modifiers changed from: package-private */
    public abstract Sink wrapAndCopyInto(Sink sink, Spliterator spliterator);

    /* access modifiers changed from: package-private */
    public abstract Sink wrapSink(Sink sink);

    /* access modifiers changed from: package-private */
    public abstract Spliterator wrapSpliterator(Spliterator spliterator);
}
