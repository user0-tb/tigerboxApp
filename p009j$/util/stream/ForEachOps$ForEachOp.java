package p009j$.util.stream;

import p009j$.util.Spliterator;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ForEachOps$ForEachOp */
abstract class ForEachOps$ForEachOp implements TerminalOp, TerminalSink {
    private final boolean ordered;

    /* renamed from: j$.util.stream.ForEachOps$ForEachOp$OfDouble */
    final class OfDouble extends ForEachOps$ForEachOp implements Sink.OfDouble {
        final DoubleConsumer consumer;

        OfDouble(DoubleConsumer doubleConsumer, boolean z) {
            super(z);
            this.consumer = doubleConsumer;
        }

        public void accept(double d) {
            this.consumer.accept(d);
        }

        public /* synthetic */ void accept(Double d) {
            Node.CC.$default$accept((Sink.OfDouble) this, d);
        }
    }

    /* renamed from: j$.util.stream.ForEachOps$ForEachOp$OfInt */
    final class OfInt extends ForEachOps$ForEachOp implements Sink.OfInt {
        final IntConsumer consumer;

        OfInt(IntConsumer intConsumer, boolean z) {
            super(z);
            this.consumer = intConsumer;
        }

        public void accept(int i) {
            this.consumer.accept(i);
        }

        public /* synthetic */ void accept(Integer num) {
            Node.CC.$default$accept((Sink.OfInt) this, num);
        }
    }

    /* renamed from: j$.util.stream.ForEachOps$ForEachOp$OfLong */
    final class OfLong extends ForEachOps$ForEachOp implements Sink.OfLong {
        final LongConsumer consumer;

        OfLong(LongConsumer longConsumer, boolean z) {
            super(z);
            this.consumer = longConsumer;
        }

        public void accept(long j) {
            this.consumer.accept(j);
        }

        public /* synthetic */ void accept(Long l) {
            Node.CC.$default$accept((Sink.OfLong) this, l);
        }
    }

    /* renamed from: j$.util.stream.ForEachOps$ForEachOp$OfRef */
    final class OfRef extends ForEachOps$ForEachOp {
        final Consumer consumer;

        OfRef(Consumer consumer2, boolean z) {
            super(z);
            this.consumer = consumer2;
        }

        public void accept(Object obj) {
            this.consumer.accept(obj);
        }
    }

    protected ForEachOps$ForEachOp(boolean z) {
        this.ordered = z;
    }

    public /* synthetic */ void accept(double d) {
        Node.CC.$default$acceptb(this);
        throw null;
    }

    public /* synthetic */ void accept(int i) {
        Node.CC.$default$accept(this);
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        Node.CC.$default$accepta(this);
        throw null;
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public /* synthetic */ void begin(long j) {
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public /* synthetic */ void end() {
    }

    public Object evaluateParallel(PipelineHelper pipelineHelper, Spliterator spliterator) {
        (this.ordered ? new ForEachOps$ForEachOrderedTask(pipelineHelper, spliterator, (Sink) this) : new ForEachOps$ForEachTask(pipelineHelper, spliterator, pipelineHelper.wrapSink(this))).invoke();
        return null;
    }

    public Object evaluateSequential(PipelineHelper pipelineHelper, Spliterator spliterator) {
        AbstractPipeline abstractPipeline = (AbstractPipeline) pipelineHelper;
        abstractPipeline.copyInto(abstractPipeline.wrapSink(this), spliterator);
        return null;
    }

    public /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    public int getOpFlags() {
        if (this.ordered) {
            return 0;
        }
        return StreamOpFlag.NOT_ORDERED;
    }
}
