package p009j$.util.stream;

import p009j$.util.function.BiConsumer;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.Supplier;
import p009j$.util.stream.Collector;

/* renamed from: j$.util.stream.ReduceOps$3 */
class ReduceOps$3 extends ReduceOps$ReduceOp {
    final /* synthetic */ BiConsumer val$accumulator;
    final /* synthetic */ Collector val$collector;
    final /* synthetic */ BinaryOperator val$combiner;
    final /* synthetic */ Supplier val$supplier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReduceOps$3(StreamShape streamShape, BinaryOperator binaryOperator, BiConsumer biConsumer, Supplier supplier, Collector collector) {
        super(streamShape);
        this.val$combiner = binaryOperator;
        this.val$accumulator = biConsumer;
        this.val$supplier = supplier;
        this.val$collector = collector;
    }

    public int getOpFlags() {
        if (this.val$collector.characteristics().contains(Collector.Characteristics.UNORDERED)) {
            return StreamOpFlag.NOT_ORDERED;
        }
        return 0;
    }

    public ReduceOps$AccumulatingSink makeSink() {
        return new ReduceOps$3ReducingSink(this.val$supplier, this.val$accumulator, this.val$combiner);
    }
}
