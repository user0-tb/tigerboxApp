package p009j$.util.stream;

import p009j$.util.function.Consumer;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda1 */
public final /* synthetic */ class StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda1 implements Sink {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda1(Consumer consumer) {
        this.f$0 = consumer;
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

    public /* synthetic */ StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda1(SpinedBuffer spinedBuffer) {
        this.f$0 = spinedBuffer;
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

    public final void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((Consumer) this.f$0).accept(obj);
                return;
            default:
                ((SpinedBuffer) this.f$0).accept(obj);
                return;
        }
    }
}
