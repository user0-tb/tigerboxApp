package p009j$.util.stream;

import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Consumer;
import p009j$.util.function.ObjIntConsumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ReduceOps$7ReducingSink */
class ReduceOps$7ReducingSink extends ReduceOps$Box implements ReduceOps$AccumulatingSink, Sink.OfInt {
    final /* synthetic */ ObjIntConsumer val$accumulator;
    final /* synthetic */ BinaryOperator val$combiner;
    final /* synthetic */ Supplier val$supplier;

    ReduceOps$7ReducingSink(Supplier supplier, ObjIntConsumer objIntConsumer, BinaryOperator binaryOperator) {
        this.val$supplier = supplier;
        this.val$accumulator = objIntConsumer;
        this.val$combiner = binaryOperator;
    }

    public /* synthetic */ void accept(double d) {
        Node.CC.$default$acceptb(this);
        throw null;
    }

    public void accept(int i) {
        this.val$accumulator.accept(this.state, i);
    }

    public /* synthetic */ void accept(long j) {
        Node.CC.$default$accepta(this);
        throw null;
    }

    public /* synthetic */ void accept(Integer num) {
        Node.CC.$default$accept((Sink.OfInt) this, num);
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
        this.state = this.val$combiner.apply(this.state, ((ReduceOps$7ReducingSink) reduceOps$AccumulatingSink).state);
    }

    public /* synthetic */ void end() {
    }
}
