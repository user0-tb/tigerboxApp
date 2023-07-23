package p009j$.util.stream;

import p009j$.util.function.Consumer;
import p009j$.util.function.IntBinaryOperator;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ReduceOps$5ReducingSink */
class ReduceOps$5ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfInt {
    private int state;
    final /* synthetic */ int val$identity;
    final /* synthetic */ IntBinaryOperator val$operator;

    ReduceOps$5ReducingSink(int i, IntBinaryOperator intBinaryOperator) {
        this.val$identity = i;
        this.val$operator = intBinaryOperator;
    }

    public /* synthetic */ void accept(double d) {
        Node.CC.$default$acceptb(this);
        throw null;
    }

    public void accept(int i) {
        this.state = this.val$operator.applyAsInt(this.state, i);
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
        this.state = this.val$identity;
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public void combine(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        accept(((ReduceOps$5ReducingSink) reduceOps$AccumulatingSink).state);
    }

    public /* synthetic */ void end() {
    }

    public Object get() {
        return Integer.valueOf(this.state);
    }
}
