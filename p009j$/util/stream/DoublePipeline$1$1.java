package p009j$.util.stream;

import p009j$.lang.Iterable$CC$$IA$1;
import p009j$.lang.Iterable$CC$$IA$2;
import p009j$.lang.Iterable$CC$$IA$3;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.DoubleFunction;
import p009j$.util.function.DoubleToLongFunction;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.Sink;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.DoublePipeline$1$1 */
class DoublePipeline$1$1 extends Sink.ChainedDouble {
    public final /* synthetic */ int $r8$classId = 2;
    final /* synthetic */ Object this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoublePipeline$1$1(IntPipeline.C14353 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    public void accept(double d) {
        switch (this.$r8$classId) {
            case 0:
                this.downstream.accept(((C$r8$wrapper$java$util$function$IntPredicate$VWRP) ((IntPipeline.C14386) this.this$1).val$mapper).applyAsDouble(d));
                return;
            case 1:
                this.downstream.accept(((DoubleFunction) ((IntPipeline.C14364) this.this$1).val$mapper).apply(d));
                return;
            case 2:
                this.downstream.accept(((C$r8$wrapper$java$util$function$IntPredicate$VWRP) ((IntPipeline.C14353) this.this$1).val$mapper).applyAsInt(d));
                return;
            case 3:
                this.downstream.accept(((DoubleToLongFunction) ((IntPipeline.C14375) this.this$1).val$mapper).applyAsLong(d));
                return;
            case 4:
                DoubleStream doubleStream = (DoubleStream) ((DoubleFunction) ((IntPipeline.C14386) this.this$1).val$mapper).apply(d);
                if (doubleStream != null) {
                    try {
                        doubleStream.sequential().forEach(new DoublePipeline$$ExternalSyntheticLambda6(this));
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                        break;
                    }
                }
                if (doubleStream != null) {
                    doubleStream.close();
                    return;
                }
                return;
            case 5:
                if (((C$r8$wrapper$java$util$function$IntPredicate$VWRP) ((IntPipeline.C14386) this.this$1).val$mapper).test(d)) {
                    this.downstream.accept(d);
                    return;
                }
                return;
            default:
                ((DoubleConsumer) ((IntPipeline.C14386) this.this$1).val$mapper).accept(d);
                this.downstream.accept(d);
                return;
        }
        throw th;
    }

    public void begin(long j) {
        switch (this.$r8$classId) {
            case 4:
                this.downstream.begin(-1);
                return;
            case 5:
                this.downstream.begin(-1);
                return;
            default:
                this.downstream.begin(j);
                return;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoublePipeline$1$1(IntPipeline.C14364 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoublePipeline$1$1(IntPipeline.C14375 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoublePipeline$1$1(IntPipeline.C14386 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoublePipeline$1$1(IntPipeline.C14386 r1, Sink sink, Iterable$CC$$IA$1 r3) {
        super(sink);
        this.this$1 = r1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoublePipeline$1$1(IntPipeline.C14386 r1, Sink sink, Iterable$CC$$IA$2 r3) {
        super(sink);
        this.this$1 = r1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DoublePipeline$1$1(IntPipeline.C14386 r1, Sink sink, Iterable$CC$$IA$3 r3) {
        super(sink);
        this.this$1 = r1;
    }
}
