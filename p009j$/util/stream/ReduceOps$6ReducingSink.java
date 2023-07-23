package p009j$.util.stream;

import p009j$.util.OptionalInt;
import p009j$.util.function.Consumer;
import p009j$.util.function.IntBinaryOperator;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ReduceOps$6ReducingSink */
class ReduceOps$6ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfInt {
    private boolean empty;
    private int state;
    final /* synthetic */ IntBinaryOperator val$operator;

    ReduceOps$6ReducingSink(IntBinaryOperator intBinaryOperator) {
        this.val$operator = intBinaryOperator;
    }

    public /* synthetic */ void accept(double d) {
        Node.CC.$default$acceptb(this);
        throw null;
    }

    public void accept(int i) {
        if (this.empty) {
            this.empty = false;
        } else {
            i = this.val$operator.applyAsInt(this.state, i);
        }
        this.state = i;
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
        this.empty = true;
        this.state = 0;
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public void combine(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        ReduceOps$6ReducingSink reduceOps$6ReducingSink = (ReduceOps$6ReducingSink) reduceOps$AccumulatingSink;
        if (!reduceOps$6ReducingSink.empty) {
            accept(reduceOps$6ReducingSink.state);
        }
    }

    public /* synthetic */ void end() {
    }

    public Object get() {
        return this.empty ? OptionalInt.empty() : OptionalInt.m203of(this.state);
    }
}
