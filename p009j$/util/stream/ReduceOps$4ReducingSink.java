package p009j$.util.stream;

import p009j$.util.function.BiConsumer;
import p009j$.util.function.Consumer;
import p009j$.util.function.Supplier;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.ReduceOps$4ReducingSink */
class ReduceOps$4ReducingSink extends ReduceOps$Box implements ReduceOps$AccumulatingSink {
    final /* synthetic */ BiConsumer val$accumulator;
    final /* synthetic */ BiConsumer val$reducer;
    final /* synthetic */ Supplier val$seedFactory;

    ReduceOps$4ReducingSink(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.val$seedFactory = supplier;
        this.val$accumulator = biConsumer;
        this.val$reducer = biConsumer2;
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
        this.state = this.val$seedFactory.get();
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public void combine(ReduceOps$AccumulatingSink reduceOps$AccumulatingSink) {
        this.val$reducer.accept(this.state, ((ReduceOps$4ReducingSink) reduceOps$AccumulatingSink).state);
    }

    public /* synthetic */ void end() {
    }
}
