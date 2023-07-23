package p009j$.util.stream;

import p009j$.util.OptionalLong;
import p009j$.util.function.Consumer;
import p009j$.util.function.LongBinaryOperator;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ReduceOps$9ReducingSink */
class ReduceOps$9ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfLong {
    private boolean empty;
    private long state;
    final /* synthetic */ LongBinaryOperator val$operator;

    ReduceOps$9ReducingSink(LongBinaryOperator longBinaryOperator) {
        this.val$operator = longBinaryOperator;
    }

    public /* synthetic */ void accept(double d) {
        Node.CC.$default$acceptb(this);
        throw null;
    }

    public /* synthetic */ void accept(int i) {
        Node.CC.$default$accept(this);
        throw null;
    }

    public void accept(long j) {
        if (this.empty) {
            this.empty = false;
        } else {
            j = this.val$operator.applyAsLong(this.state, j);
        }
        this.state = j;
    }

    public /* synthetic */ void accept(Long l) {
        Node.CC.$default$accept((Sink.OfLong) this, l);
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
        ReduceOps$9ReducingSink reduceOps$9ReducingSink = (ReduceOps$9ReducingSink) reduceOps$AccumulatingSink;
        if (!reduceOps$9ReducingSink.empty) {
            accept(reduceOps$9ReducingSink.state);
        }
    }

    public /* synthetic */ void end() {
    }

    public Object get() {
        return this.empty ? OptionalLong.empty() : OptionalLong.m204of(this.state);
    }
}
