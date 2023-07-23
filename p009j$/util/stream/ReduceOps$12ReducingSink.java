package p009j$.util.stream;

import p009j$.util.OptionalDouble;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleBinaryOperator;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ReduceOps$12ReducingSink */
class ReduceOps$12ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfDouble {
    private boolean empty;
    private double state;
    final /* synthetic */ DoubleBinaryOperator val$operator;

    ReduceOps$12ReducingSink(DoubleBinaryOperator doubleBinaryOperator) {
        this.val$operator = doubleBinaryOperator;
    }

    public void accept(double d) {
        if (this.empty) {
            this.empty = false;
        } else {
            d = this.val$operator.applyAsDouble(this.state, d);
        }
        this.state = d;
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
        this.empty = true;
        this.state = 0.0d;
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public void combine(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        ReduceOps$12ReducingSink reduceOps$12ReducingSink = (ReduceOps$12ReducingSink) reduceOps$AccumulatingSink;
        if (!reduceOps$12ReducingSink.empty) {
            accept(reduceOps$12ReducingSink.state);
        }
    }

    public /* synthetic */ void end() {
    }

    public Object get() {
        return this.empty ? OptionalDouble.empty() : OptionalDouble.m202of(this.state);
    }
}
