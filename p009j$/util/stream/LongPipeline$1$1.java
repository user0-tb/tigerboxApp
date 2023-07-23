package p009j$.util.stream;

import p009j$.lang.Iterable$CC$$IA$1;
import p009j$.lang.Iterable$CC$$IA$2;
import p009j$.lang.Iterable$CC$$IA$3;
import p009j$.util.function.LongConsumer;
import p009j$.util.function.LongFunction;
import p009j$.util.function.LongUnaryOperator;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.Sink;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.LongPipeline$1$1 */
class LongPipeline$1$1 extends Sink.ChainedLong {
    public final /* synthetic */ int $r8$classId = 0;
    final /* synthetic */ Object this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPipeline$1$1(IntPipeline.C14342 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    public void accept(long j) {
        switch (this.$r8$classId) {
            case 0:
                this.downstream.accept((double) j);
                return;
            case 1:
                this.downstream.accept(((LongUnaryOperator) ((IntPipeline.C14375) this.this$1).val$mapper).applyAsLong(j));
                return;
            case 2:
                this.downstream.accept(((LongFunction) ((IntPipeline.C14364) this.this$1).val$mapper).apply(j));
                return;
            case 3:
                this.downstream.accept(((C$r8$wrapper$java$util$function$IntPredicate$VWRP) ((IntPipeline.C14353) this.this$1).val$mapper).applyAsInt(j));
                return;
            case 4:
                this.downstream.accept(((C$r8$wrapper$java$util$function$IntPredicate$VWRP) ((IntPipeline.C14386) this.this$1).val$mapper).applyAsDouble(j));
                return;
            case 5:
                LongStream longStream = (LongStream) ((LongFunction) ((IntPipeline.C14375) this.this$1).val$mapper).apply(j);
                if (longStream != null) {
                    try {
                        longStream.sequential().forEach(new LongPipeline$$ExternalSyntheticLambda7(this));
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                        break;
                    }
                }
                if (longStream != null) {
                    longStream.close();
                    return;
                }
                return;
            case 6:
                if (((C$r8$wrapper$java$util$function$IntPredicate$VWRP) ((IntPipeline.C14375) this.this$1).val$mapper).test(j)) {
                    this.downstream.accept(j);
                    return;
                }
                return;
            default:
                ((LongConsumer) ((IntPipeline.C14375) this.this$1).val$mapper).accept(j);
                this.downstream.accept(j);
                return;
        }
        throw th;
    }

    public void begin(long j) {
        switch (this.$r8$classId) {
            case 5:
                this.downstream.begin(-1);
                return;
            case 6:
                this.downstream.begin(-1);
                return;
            default:
                this.downstream.begin(j);
                return;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPipeline$1$1(IntPipeline.C14353 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPipeline$1$1(IntPipeline.C14364 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPipeline$1$1(IntPipeline.C14375 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPipeline$1$1(IntPipeline.C14375 r1, Sink sink, Iterable$CC$$IA$1 r3) {
        super(sink);
        this.this$1 = r1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPipeline$1$1(IntPipeline.C14375 r1, Sink sink, Iterable$CC$$IA$2 r3) {
        super(sink);
        this.this$1 = r1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPipeline$1$1(IntPipeline.C14375 r1, Sink sink, Iterable$CC$$IA$3 r3) {
        super(sink);
        this.this$1 = r1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPipeline$1$1(IntPipeline.C14386 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }
}
