package p009j$.util.stream;

import p009j$.util.function.Consumer;
import p009j$.util.function.LongConsumer;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;
import p009j$.util.stream.SpinedBuffer;

/* renamed from: j$.util.stream.StreamSpliterators$LongWrappingSpliterator$$ExternalSyntheticLambda1 */
public final /* synthetic */ class C1454xa6d810a7 implements Sink.OfLong {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ C1454xa6d810a7(LongConsumer longConsumer) {
        this.f$0 = longConsumer;
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

    public /* synthetic */ C1454xa6d810a7(SpinedBuffer.OfLong ofLong) {
        this.f$0 = ofLong;
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

    public final void accept(long j) {
        switch (this.$r8$classId) {
            case 0:
                ((LongConsumer) this.f$0).accept(j);
                return;
            default:
                ((SpinedBuffer.OfLong) this.f$0).accept(j);
                return;
        }
    }

    public /* synthetic */ void accept(Long l) {
        switch (this.$r8$classId) {
            case 0:
                Node.CC.$default$accept((Sink.OfLong) this, l);
                return;
            default:
                Node.CC.$default$accept((Sink.OfLong) this, l);
                return;
        }
    }

    public /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                accept((Long) obj);
                return;
            default:
                accept((Long) obj);
                return;
        }
    }
}
