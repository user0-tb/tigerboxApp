package p009j$.util.stream;

import p009j$.util.function.Consumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.StreamSpliterators$IntWrappingSpliterator$$ExternalSyntheticLambda1 */
public final /* synthetic */ class C1453x808788f0 implements Sink.OfInt {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ C1453x808788f0(IntConsumer intConsumer) {
        this.f$0 = intConsumer;
    }

    public /* synthetic */ void accept(double d) {
        switch (this.$r8$classId) {
            case 0:
                Node.CC.$default$acceptb(this);
                throw null;
            default:
                Node.CC.$default$acceptb(this);
                throw null;
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

    public /* synthetic */ C1453x808788f0(SpinedBuffer.OfInt ofInt) {
        this.f$0 = ofInt;
    }

    public final void accept(int i) {
        switch (this.$r8$classId) {
            case 0:
                ((IntConsumer) this.f$0).accept(i);
                return;
            default:
                ((SpinedBuffer.OfInt) this.f$0).accept(i);
                return;
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

    public /* synthetic */ void accept(Integer num) {
        switch (this.$r8$classId) {
            case 0:
                Node.CC.$default$accept((Sink.OfInt) this, num);
                return;
            default:
                Node.CC.$default$accept((Sink.OfInt) this, num);
                return;
        }
    }

    public /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                accept((Integer) obj);
                return;
            default:
                accept((Integer) obj);
                return;
        }
    }
}
