package p009j$.util.stream;

import p009j$.util.Optional;
import p009j$.util.OptionalDouble;
import p009j$.util.OptionalInt;
import p009j$.util.OptionalLong;
import p009j$.util.function.Consumer;
import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;

/* renamed from: j$.util.stream.FindOps$FindSink */
abstract class FindOps$FindSink implements TerminalSink {
    boolean hasValue;
    Object value;

    /* renamed from: j$.util.stream.FindOps$FindSink$OfDouble */
    final class OfDouble extends FindOps$FindSink implements Sink.OfDouble {
        OfDouble() {
        }

        public void accept(double d) {
            accept((Object) Double.valueOf(d));
        }

        public Object get() {
            if (this.hasValue) {
                return OptionalDouble.m202of(((Double) this.value).doubleValue());
            }
            return null;
        }
    }

    /* renamed from: j$.util.stream.FindOps$FindSink$OfInt */
    final class OfInt extends FindOps$FindSink implements Sink.OfInt {
        OfInt() {
        }

        public void accept(int i) {
            accept((Object) Integer.valueOf(i));
        }

        public Object get() {
            if (this.hasValue) {
                return OptionalInt.m203of(((Integer) this.value).intValue());
            }
            return null;
        }
    }

    /* renamed from: j$.util.stream.FindOps$FindSink$OfLong */
    final class OfLong extends FindOps$FindSink implements Sink.OfLong {
        OfLong() {
        }

        public void accept(long j) {
            accept((Object) Long.valueOf(j));
        }

        public Object get() {
            if (this.hasValue) {
                return OptionalLong.m204of(((Long) this.value).longValue());
            }
            return null;
        }
    }

    /* renamed from: j$.util.stream.FindOps$FindSink$OfRef */
    final class OfRef extends FindOps$FindSink {
        OfRef() {
        }

        public Object get() {
            if (this.hasValue) {
                return Optional.m201of(this.value);
            }
            return null;
        }
    }

    FindOps$FindSink() {
    }

    public /* synthetic */ void accept(double d) {
        Node.CC.$default$acceptb(this);
        throw null;
    }

    public /* synthetic */ void accept(int i) {
        Node.CC.$default$accept(this);
        throw null;
    }

    public /* synthetic */ void accept(long j) {
        Node.CC.$default$accepta(this);
        throw null;
    }

    public void accept(Object obj) {
        if (!this.hasValue) {
            this.hasValue = true;
            this.value = obj;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    public /* synthetic */ void begin(long j) {
    }

    public boolean cancellationRequested() {
        return this.hasValue;
    }

    public /* synthetic */ void end() {
    }
}
