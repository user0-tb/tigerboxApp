package p009j$.util.stream;

import java.util.List;
import p009j$.util.Spliterator;
import p009j$.util.function.BooleanSupplier;
import p009j$.util.function.Consumer;
import p009j$.util.function.IntFunction;
import p009j$.util.function.LongFunction;
import p009j$.util.function.Supplier;
import p009j$.util.stream.Nodes;

/* renamed from: j$.util.stream.SpinedBuffer$$ExternalSyntheticLambda0 */
public final /* synthetic */ class SpinedBuffer$$ExternalSyntheticLambda0 implements Consumer, Supplier, LongFunction, BooleanSupplier {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SpinedBuffer$$ExternalSyntheticLambda0(Spliterator spliterator) {
        this.f$0 = spliterator;
    }

    public void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((List) this.f$0).add(obj);
                return;
            default:
                ((Sink) this.f$0).accept(obj);
                return;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.$r8$classId) {
            case 0:
                return Consumer.CC.$default$andThen(this, consumer);
            default:
                return Consumer.CC.$default$andThen(this, consumer);
        }
    }

    public Object apply(long j) {
        int i = Nodes.CollectorTask.OfInt.$r8$clinit;
        return Nodes.builder(j, (IntFunction) this.f$0);
    }

    public Object get() {
        switch (this.$r8$classId) {
            case 1:
                return (Spliterator) this.f$0;
            default:
                return ((AbstractPipeline) this.f$0).m741lambda$spliterator$0$javautilstreamAbstractPipeline();
        }
    }

    public /* synthetic */ SpinedBuffer$$ExternalSyntheticLambda0(IntFunction intFunction) {
        this.f$0 = intFunction;
    }

    public /* synthetic */ SpinedBuffer$$ExternalSyntheticLambda0(AbstractPipeline abstractPipeline) {
        this.f$0 = abstractPipeline;
    }

    public /* synthetic */ SpinedBuffer$$ExternalSyntheticLambda0(Sink sink) {
        this.f$0 = sink;
    }

    public /* synthetic */ SpinedBuffer$$ExternalSyntheticLambda0(StreamSpliterators$DoubleWrappingSpliterator streamSpliterators$DoubleWrappingSpliterator) {
        this.f$0 = streamSpliterators$DoubleWrappingSpliterator;
    }

    public /* synthetic */ SpinedBuffer$$ExternalSyntheticLambda0(StreamSpliterators$IntWrappingSpliterator streamSpliterators$IntWrappingSpliterator) {
        this.f$0 = streamSpliterators$IntWrappingSpliterator;
    }

    public /* synthetic */ SpinedBuffer$$ExternalSyntheticLambda0(StreamSpliterators$LongWrappingSpliterator streamSpliterators$LongWrappingSpliterator) {
        this.f$0 = streamSpliterators$LongWrappingSpliterator;
    }

    public /* synthetic */ SpinedBuffer$$ExternalSyntheticLambda0(StreamSpliterators$WrappingSpliterator streamSpliterators$WrappingSpliterator) {
        this.f$0 = streamSpliterators$WrappingSpliterator;
    }

    public /* synthetic */ SpinedBuffer$$ExternalSyntheticLambda0(List list) {
        this.f$0 = list;
    }
}
