package p009j$.util.stream;

import p009j$.util.function.LongConsumer;

/* renamed from: j$.util.stream.LongPipeline$$ExternalSyntheticLambda7 */
public final /* synthetic */ class LongPipeline$$ExternalSyntheticLambda7 implements LongConsumer {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ LongPipeline$$ExternalSyntheticLambda7(LongPipeline$1$1 longPipeline$1$1) {
        this.f$0 = longPipeline$1$1;
    }

    public final void accept(long j) {
        switch (this.$r8$classId) {
            case 0:
                ((Sink) this.f$0).accept(j);
                return;
            default:
                ((LongPipeline$1$1) this.f$0).downstream.accept(j);
                return;
        }
    }

    public /* synthetic */ LongPipeline$$ExternalSyntheticLambda7(Sink sink) {
        this.f$0 = sink;
    }
}
