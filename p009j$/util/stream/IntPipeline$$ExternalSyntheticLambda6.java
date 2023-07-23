package p009j$.util.stream;

import p009j$.util.function.IntConsumer;
import p009j$.util.stream.IntPipeline;

/* renamed from: j$.util.stream.IntPipeline$$ExternalSyntheticLambda6 */
public final /* synthetic */ class IntPipeline$$ExternalSyntheticLambda6 implements IntConsumer {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ IntPipeline$$ExternalSyntheticLambda6(IntPipeline.C14321.C14331 r2) {
        this.f$0 = r2;
    }

    public final void accept(int i) {
        switch (this.$r8$classId) {
            case 0:
                ((Sink) this.f$0).accept(i);
                return;
            default:
                ((IntPipeline.C14321.C14331) this.f$0).downstream.accept(i);
                return;
        }
    }

    public /* synthetic */ IntPipeline$$ExternalSyntheticLambda6(Sink sink) {
        this.f$0 = sink;
    }
}
