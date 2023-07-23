package p009j$.util.stream;

import p009j$.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.DoublePipeline$$ExternalSyntheticLambda6 */
public final /* synthetic */ class DoublePipeline$$ExternalSyntheticLambda6 implements DoubleConsumer {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DoublePipeline$$ExternalSyntheticLambda6(DoublePipeline$1$1 doublePipeline$1$1) {
        this.f$0 = doublePipeline$1$1;
    }

    public final void accept(double d) {
        switch (this.$r8$classId) {
            case 0:
                ((Sink) this.f$0).accept(d);
                return;
            default:
                ((DoublePipeline$1$1) this.f$0).downstream.accept(d);
                return;
        }
    }

    public /* synthetic */ DoublePipeline$$ExternalSyntheticLambda6(Sink sink) {
        this.f$0 = sink;
    }
}
