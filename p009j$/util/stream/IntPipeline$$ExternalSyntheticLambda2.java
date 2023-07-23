package p009j$.util.stream;

import p009j$.util.function.BiConsumer;
import p009j$.util.function.BinaryOperator;

/* renamed from: j$.util.stream.IntPipeline$$ExternalSyntheticLambda2 */
public final /* synthetic */ class IntPipeline$$ExternalSyntheticLambda2 implements BinaryOperator {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BiConsumer f$0;

    public /* synthetic */ IntPipeline$$ExternalSyntheticLambda2(BiConsumer biConsumer, int i) {
        this.$r8$classId = i;
        if (i == 1) {
            this.f$0 = biConsumer;
        } else if (i != 2) {
            this.f$0 = biConsumer;
        } else {
            this.f$0 = biConsumer;
        }
    }

    public final Object apply(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.accept(obj, obj2);
                return obj;
            case 1:
                this.f$0.accept(obj, obj2);
                return obj;
            default:
                this.f$0.accept(obj, obj2);
                return obj;
        }
    }
}
