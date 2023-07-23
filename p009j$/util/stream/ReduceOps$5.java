package p009j$.util.stream;

import p009j$.util.function.IntBinaryOperator;

/* renamed from: j$.util.stream.ReduceOps$5 */
class ReduceOps$5 extends ReduceOps$ReduceOp {
    final /* synthetic */ int val$identity;
    final /* synthetic */ IntBinaryOperator val$operator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReduceOps$5(StreamShape streamShape, IntBinaryOperator intBinaryOperator, int i) {
        super(streamShape);
        this.val$operator = intBinaryOperator;
        this.val$identity = i;
    }

    public ReduceOps$AccumulatingSink makeSink() {
        return new ReduceOps$5ReducingSink(this.val$identity, this.val$operator);
    }
}
