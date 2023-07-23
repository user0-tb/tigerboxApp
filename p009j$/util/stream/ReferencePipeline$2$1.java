package p009j$.util.stream;

import p009j$.lang.Iterable$CC$$IA$1;
import p009j$.util.function.Consumer;
import p009j$.util.function.Predicate;
import p009j$.util.function.ToDoubleFunction;
import p009j$.util.function.ToIntFunction;
import p009j$.util.function.ToLongFunction;
import p009j$.util.stream.IntPipeline;
import p009j$.util.stream.ReferencePipeline;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.ReferencePipeline$2$1 */
class ReferencePipeline$2$1 extends Sink.ChainedReference {
    public final /* synthetic */ int $r8$classId = 3;
    final /* synthetic */ Object this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferencePipeline$2$1(IntPipeline.C14353 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    public void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                if (((Predicate) ((IntPipeline.C14364) this.this$1).val$mapper).test(obj)) {
                    this.downstream.accept(obj);
                    return;
                }
                return;
            case 1:
                ((Consumer) ((IntPipeline.C14364) this.this$1).val$mapper).accept(obj);
                this.downstream.accept(obj);
                return;
            case 2:
                this.downstream.accept(((ReferencePipeline.C14423) this.this$1).val$mapper.apply(obj));
                return;
            case 3:
                this.downstream.accept(((ToIntFunction) ((IntPipeline.C14353) this.this$1).val$mapper).applyAsInt(obj));
                return;
            case 4:
                this.downstream.accept(((ToLongFunction) ((IntPipeline.C14375) this.this$1).val$mapper).applyAsLong(obj));
                return;
            case 5:
                this.downstream.accept(((ToDoubleFunction) ((IntPipeline.C14386) this.this$1).val$mapper).applyAsDouble(obj));
                return;
            default:
                Stream stream = (Stream) ((ReferencePipeline.C14423) this.this$1).val$mapper.apply(obj);
                if (stream != null) {
                    try {
                        ((Stream) stream.sequential()).forEach(this.downstream);
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                        break;
                    }
                }
                if (stream != null) {
                    stream.close();
                    return;
                }
                return;
        }
        throw th;
    }

    public void begin(long j) {
        switch (this.$r8$classId) {
            case 0:
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
    public ReferencePipeline$2$1(IntPipeline.C14364 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferencePipeline$2$1(IntPipeline.C14364 r1, Sink sink, Iterable$CC$$IA$1 r3) {
        super(sink);
        this.this$1 = r1;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferencePipeline$2$1(IntPipeline.C14375 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferencePipeline$2$1(IntPipeline.C14386 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferencePipeline$2$1(ReferencePipeline.C14423 r2, Sink sink) {
        super(sink);
        this.this$1 = r2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReferencePipeline$2$1(ReferencePipeline.C14423 r1, Sink sink, Iterable$CC$$IA$1 r3) {
        super(sink);
        this.this$1 = r1;
    }
}
