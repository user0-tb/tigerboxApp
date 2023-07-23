package p009j$.util.stream;

import p009j$.util.function.BinaryOperator;
import p009j$.util.function.DoubleBinaryOperator;
import p009j$.util.function.IntBinaryOperator;
import p009j$.util.function.LongBinaryOperator;

/* renamed from: j$.util.stream.ReduceOps$2 */
class ReduceOps$2 extends ReduceOps$ReduceOp {
    public final /* synthetic */ int $r8$classId = 0;
    final /* synthetic */ Object val$operator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReduceOps$2(StreamShape streamShape, BinaryOperator binaryOperator) {
        super(streamShape);
        this.val$operator = binaryOperator;
    }

    public ReduceOps$AccumulatingSink makeSink() {
        switch (this.$r8$classId) {
            case 0:
                return new ReduceOps$2ReducingSink((BinaryOperator) this.val$operator);
            case 1:
                return new ReduceOps$12ReducingSink((DoubleBinaryOperator) this.val$operator);
            case 2:
                return new ReduceOps$6ReducingSink((IntBinaryOperator) this.val$operator);
            default:
                return new ReduceOps$9ReducingSink((LongBinaryOperator) this.val$operator);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReduceOps$2(StreamShape streamShape, DoubleBinaryOperator doubleBinaryOperator) {
        super(streamShape);
        this.val$operator = doubleBinaryOperator;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReduceOps$2(StreamShape streamShape, IntBinaryOperator intBinaryOperator) {
        super(streamShape);
        this.val$operator = intBinaryOperator;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReduceOps$2(StreamShape streamShape, LongBinaryOperator longBinaryOperator) {
        super(streamShape);
        this.val$operator = longBinaryOperator;
    }
}
