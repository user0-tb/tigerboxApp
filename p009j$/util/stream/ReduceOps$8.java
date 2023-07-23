package p009j$.util.stream;

import p009j$.util.function.LongBinaryOperator;

/* renamed from: j$.util.stream.ReduceOps$8 */
class ReduceOps$8 extends ReduceOps$ReduceOp {
    final /* synthetic */ long val$identity;
    final /* synthetic */ LongBinaryOperator val$operator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReduceOps$8(StreamShape streamShape, LongBinaryOperator longBinaryOperator, long j) {
        super(streamShape);
        this.val$operator = longBinaryOperator;
        this.val$identity = j;
    }

    public ReduceOps$AccumulatingSink makeSink() {
        return new ReduceOps$8ReducingSink(this.val$identity, this.val$operator);
    }
}
