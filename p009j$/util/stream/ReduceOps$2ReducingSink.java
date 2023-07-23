package p009j$.util.stream;

import p009j$.util.Optional;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Consumer;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.ReduceOps$2ReducingSink */
class ReduceOps$2ReducingSink implements ReduceOps$AccumulatingSink {
    private boolean empty;
    private Object state;
    final /* synthetic */ BinaryOperator val$operator;

    ReduceOps$2ReducingSink(BinaryOperator binaryOperator) {
        this.val$operator = binaryOperator;
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
        if (this.empty) {
            this.empty = false;
        } else {
            obj = this.val$operator.apply(this.state, obj);
        }
        this.state = obj;
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public void begin(long j) {
        this.empty = true;
        this.state = null;
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public void combine(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        ReduceOps$2ReducingSink reduceOps$2ReducingSink = (ReduceOps$2ReducingSink) reduceOps$AccumulatingSink;
        if (!reduceOps$2ReducingSink.empty) {
            accept(reduceOps$2ReducingSink.state);
        }
    }

    public /* synthetic */ void end() {
    }

    public Object get() {
        return this.empty ? Optional.empty() : Optional.m201of(this.state);
    }
}
