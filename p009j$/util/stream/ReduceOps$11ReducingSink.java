package p009j$.util.stream;

import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleBinaryOperator;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ReduceOps$11ReducingSink */
class ReduceOps$11ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfDouble {
    private double state;
    final /* synthetic */ double val$identity;
    final /* synthetic */ DoubleBinaryOperator val$operator;

    ReduceOps$11ReducingSink(double d, DoubleBinaryOperator doubleBinaryOperator) {
        this.val$identity = d;
        this.val$operator = doubleBinaryOperator;
    }

    public void accept(double d) {
        this.state = this.val$operator.applyAsDouble(this.state, d);
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
        this.state = this.val$identity;
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public void combine(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        accept(((ReduceOps$11ReducingSink) reduceOps$AccumulatingSink).state);
    }

    public /* synthetic */ void end() {
    }

    public Object get() {
        return Double.valueOf(this.state);
    }
}
