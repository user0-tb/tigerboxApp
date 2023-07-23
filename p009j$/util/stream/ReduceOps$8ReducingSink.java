package p009j$.util.stream;

import p009j$.util.function.Consumer;
import p009j$.util.function.LongBinaryOperator;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ReduceOps$8ReducingSink */
class ReduceOps$8ReducingSink implements ReduceOps$AccumulatingSink, Sink.OfLong {
    private long state;
    final /* synthetic */ long val$identity;
    final /* synthetic */ LongBinaryOperator val$operator;

    ReduceOps$8ReducingSink(long j, LongBinaryOperator longBinaryOperator) {
        this.val$identity = j;
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
        this.state = this.val$operator.applyAsLong(this.state, j);
    }

    public /* synthetic */ void accept(Long l) {
        Node.CC.$default$accept((Sink.OfLong) this, l);
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
        accept(((ReduceOps$8ReducingSink) reduceOps$AccumulatingSink).state);
    }

    public /* synthetic */ void end() {
    }

    public Object get() {
        return Long.valueOf(this.state);
    }
}
