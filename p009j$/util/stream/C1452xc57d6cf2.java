package p009j$.util.stream;

import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.StreamSpliterators$DoubleWrappingSpliterator$$ExternalSyntheticLambda1 */
public final /* synthetic */ class C1452xc57d6cf2 implements Sink.OfDouble {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ C1452xc57d6cf2(DoubleConsumer doubleConsumer) {
        this.f$0 = doubleConsumer;
    }

    public final void accept(double d) {
        switch (this.$r8$classId) {
            case 0:
                ((DoubleConsumer) this.f$0).accept(d);
                return;
            default:
                ((SpinedBuffer.OfDouble) this.f$0).accept(d);
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

    public /* synthetic */ void begin(long j) {
    }

    public /* synthetic */ boolean cancellationRequested() {
        return false;
    }

    public /* synthetic */ void end() {
    }

    public /* synthetic */ C1452xc57d6cf2(SpinedBuffer.OfDouble ofDouble) {
        this.f$0 = ofDouble;
    }

    public /* synthetic */ void accept(int i) {
        switch (this.$r8$classId) {
            case 0:
                Node.CC.$default$accept(this);
                throw null;
            default:
                Node.CC.$default$accept(this);
                throw null;
        }
    }

    public /* synthetic */ void accept(long j) {
        switch (this.$r8$classId) {
            case 0:
                Node.CC.$default$accepta(this);
                throw null;
            default:
                Node.CC.$default$accepta(this);
                throw null;
        }
    }

    public /* synthetic */ void accept(Double d) {
        switch (this.$r8$classId) {
            case 0:
                Node.CC.$default$accept((Sink.OfDouble) this, d);
                return;
            default:
                Node.CC.$default$accept((Sink.OfDouble) this, d);
                return;
        }
    }

    public /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                accept((Double) obj);
                return;
            default:
                accept((Double) obj);
                return;
        }
    }
}
