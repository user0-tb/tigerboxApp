package p009j$.util.stream;

import p009j$.util.function.BiFunction;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Consumer;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.ReduceOps$1ReducingSink */
class ReduceOps$1ReducingSink extends ReduceOps$Box implements ReduceOps$AccumulatingSink {
    final /* synthetic */ BinaryOperator val$combiner;
    final /* synthetic */ BiFunction val$reducer;
    final /* synthetic */ Object val$seed;

    ReduceOps$1ReducingSink(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        this.val$seed = obj;
        this.val$reducer = biFunction;
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
        this.state = this.val$reducer.apply(this.state, obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public void begin(long j) {
        this.state = this.val$seed;
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public void combine(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        this.state = this.val$combiner.apply(this.state, ((ReduceOps$1ReducingSink) reduceOps$AccumulatingSink).state);
    }

    public /* synthetic */ void end() {
    }
}
