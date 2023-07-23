package p009j$.util.stream;

import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Consumer;
import p009j$.util.function.ObjDoubleConsumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ReduceOps$13ReducingSink */
class ReduceOps$13ReducingSink extends ReduceOps$Box implements ReduceOps$AccumulatingSink, Sink.OfDouble {
    final /* synthetic */ ObjDoubleConsumer val$accumulator;
    final /* synthetic */ BinaryOperator val$combiner;
    final /* synthetic */ Supplier val$supplier;

    ReduceOps$13ReducingSink(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BinaryOperator binaryOperator) {
        this.val$supplier = supplier;
        this.val$accumulator = objDoubleConsumer;
        this.val$combiner = binaryOperator;
    }

    public void accept(double d) {
        this.val$accumulator.accept(this.state, d);
    }

    public /* synthetic */ void accept(int i) {
        Node.CC.$default$accept(this);
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        Node.CC.$default$accepta(this);
        throw null;
    }

    public /* synthetic */ void accept(Double d) {
        Node.CC.$default$accept((Sink.OfDouble) this, d);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public void begin(long j) {
        this.state = this.val$supplier.get();
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public void combine(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        this.state = this.val$combiner.apply(this.state, ((ReduceOps$13ReducingSink) reduceOps$AccumulatingSink).state);
    }

    public /* synthetic */ void end() {
    }
}
