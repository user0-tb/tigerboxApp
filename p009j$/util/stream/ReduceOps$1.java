package p009j$.util.stream;

import p009j$.util.function.BiConsumer;
import p009j$.util.function.BiFunction;
import p009j$.util.function.BinaryOperator;
import p009j$.util.function.ObjDoubleConsumer;
import p009j$.util.function.ObjIntConsumer;
import p009j$.util.function.ObjLongConsumer;
import p009j$.util.function.Supplier;

/* renamed from: j$.util.stream.ReduceOps$1 */
class ReduceOps$1 extends ReduceOps$ReduceOp {
    public final /* synthetic */ int $r8$classId = 3;
    final /* synthetic */ Object val$combiner;
    final /* synthetic */ Object val$reducer;
    final /* synthetic */ Object val$seed;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReduceOps$1(StreamShape streamShape, BiConsumer biConsumer, BiConsumer biConsumer2, Supplier supplier) {
        super(streamShape);
        this.val$combiner = biConsumer;
        this.val$reducer = biConsumer2;
        this.val$seed = supplier;
    }

    public ReduceOps$AccumulatingSink makeSink() {
        switch (this.$r8$classId) {
            case 0:
                return new ReduceOps$1ReducingSink(this.val$seed, (BiFunction) this.val$reducer, (BinaryOperator) this.val$combiner);
            case 1:
                return new ReduceOps$10ReducingSink((Supplier) this.val$seed, (ObjLongConsumer) this.val$reducer, (BinaryOperator) this.val$combiner);
            case 2:
                return new ReduceOps$13ReducingSink((Supplier) this.val$seed, (ObjDoubleConsumer) this.val$reducer, (BinaryOperator) this.val$combiner);
            case 3:
                return new ReduceOps$4ReducingSink((Supplier) this.val$seed, (BiConsumer) this.val$reducer, (BiConsumer) this.val$combiner);
            default:
                return new ReduceOps$7ReducingSink((Supplier) this.val$seed, (ObjIntConsumer) this.val$reducer, (BinaryOperator) this.val$combiner);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReduceOps$1(StreamShape streamShape, BinaryOperator binaryOperator, BiFunction biFunction, Object obj) {
        super(streamShape);
        this.val$combiner = binaryOperator;
        this.val$reducer = biFunction;
        this.val$seed = obj;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReduceOps$1(StreamShape streamShape, BinaryOperator binaryOperator, ObjDoubleConsumer objDoubleConsumer, Supplier supplier) {
        super(streamShape);
        this.val$combiner = binaryOperator;
        this.val$reducer = objDoubleConsumer;
        this.val$seed = supplier;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReduceOps$1(StreamShape streamShape, BinaryOperator binaryOperator, ObjIntConsumer objIntConsumer, Supplier supplier) {
        super(streamShape);
        this.val$combiner = binaryOperator;
        this.val$reducer = objIntConsumer;
        this.val$seed = supplier;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReduceOps$1(StreamShape streamShape, BinaryOperator binaryOperator, ObjLongConsumer objLongConsumer, Supplier supplier) {
        super(streamShape);
        this.val$combiner = binaryOperator;
        this.val$reducer = objLongConsumer;
        this.val$seed = supplier;
    }
}
