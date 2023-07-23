package p009j$.util.stream;

import p009j$.util.function.DoubleBinaryOperator;

/* renamed from: j$.util.stream.ReduceOps$11 */
class ReduceOps$11 extends ReduceOps$ReduceOp {
    final /* synthetic */ double val$identity;
    final /* synthetic */ DoubleBinaryOperator val$operator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReduceOps$11(StreamShape streamShape, DoubleBinaryOperator doubleBinaryOperator, double d) {
        super(streamShape);
        this.val$operator = doubleBinaryOperator;
        this.val$identity = d;
    }

    public ReduceOps$AccumulatingSink makeSink() {
        return new ReduceOps$11ReducingSink(this.val$identity, this.val$operator);
    }
}
