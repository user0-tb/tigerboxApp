package p009j$.util.stream;

import p009j$.util.function.BiConsumer;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Consumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.ReduceOps$3ReducingSink */
class ReduceOps$3ReducingSink extends ReduceOps$Box implements ReduceOps$AccumulatingSink {
    final /* synthetic */ BiConsumer val$accumulator;
    final /* synthetic */ BinaryOperator val$combiner;
    final /* synthetic */ Supplier val$supplier;

    ReduceOps$3ReducingSink(Supplier supplier, BiConsumer biConsumer, BinaryOperator binaryOperator) {
        this.val$supplier = supplier;
        this.val$accumulator = biConsumer;
        this.val$combiner = binaryOperator;
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

    public void accept(Object obj) {
        this.val$accumulator.accept(this.state, obj);
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
        this.state = this.val$combiner.apply(this.state, ((ReduceOps$3ReducingSink) reduceOps$AccumulatingSink).state);
    }

    public /* synthetic */ void end() {
    }
}
