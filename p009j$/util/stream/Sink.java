package p009j$.util.stream;

import java.util.Objects;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.Sink */
interface Sink extends Consumer {

    /* renamed from: j$.util.stream.Sink$ChainedDouble */
    public abstract class ChainedDouble implements OfDouble {
        protected final Sink downstream;

        public ChainedDouble(Sink sink) {
            Objects.requireNonNull(sink);
            this.downstream = sink;
        }

        public /* synthetic */ void accept(int i) {
            Node.CC.$default$accept(this);
            throw null;
        }

        public /* synthetic */ void accept(long j) {
            Node.CC.$default$accepta(this);
            throw null;
        }

        public /* synthetic */ void accept(Double d) {
            Node.CC.$default$accept((OfDouble) this, d);
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }

        public void end() {
            this.downstream.end();
        }
    }

    /* renamed from: j$.util.stream.Sink$ChainedInt */
    public abstract class ChainedInt implements OfInt {
        protected final Sink downstream;

        public ChainedInt(Sink sink) {
            Objects.requireNonNull(sink);
            this.downstream = sink;
        }

        public /* synthetic */ void accept(double d) {
            Node.CC.$default$acceptb(this);
            throw null;
        }

        public /* synthetic */ void accept(long j) {
            Node.CC.$default$accepta(this);
            throw null;
        }

        public /* synthetic */ void accept(Integer num) {
            Node.CC.$default$accept((OfInt) this, num);
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }

        public void end() {
            this.downstream.end();
        }
    }

    /* renamed from: j$.util.stream.Sink$ChainedLong */
    public abstract class ChainedLong implements OfLong {
        protected final Sink downstream;

        public ChainedLong(Sink sink) {
            Objects.requireNonNull(sink);
            this.downstream = sink;
        }

        public /* synthetic */ void accept(double d) {
            Node.CC.$default$acceptb(this);
            throw null;
        }

        public /* synthetic */ void accept(int i) {
            Node.CC.$default$accept(this);
            throw null;
        }

        public /* synthetic */ void accept(Long l) {
            Node.CC.$default$accept((OfLong) this, l);
        }

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }

        public void end() {
            this.downstream.end();
        }
    }

    /* renamed from: j$.util.stream.Sink$ChainedReference */
    public abstract class ChainedReference implements Sink {
        protected final Sink downstream;

        public ChainedReference(Sink sink) {
            Objects.requireNonNull(sink);
            this.downstream = sink;
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

        public /* synthetic */ Consumer andThen(Consumer consumer) {
            return Consumer.CC.$default$andThen(this, consumer);
        }

        public boolean cancellationRequested() {
            return this.downstream.cancellationRequested();
        }

        public void end() {
            this.downstream.end();
        }
    }

    /* renamed from: j$.util.stream.Sink$OfDouble */
    public interface OfDouble extends Sink, DoubleConsumer {
        void accept(double d);
    }

    /* renamed from: j$.util.stream.Sink$OfInt */
    public interface OfInt extends Sink, IntConsumer {
        void accept(int i);
    }

    /* renamed from: j$.util.stream.Sink$OfLong */
    public interface OfLong extends Sink, LongConsumer {
        void accept(long j);
    }

    void accept(double d);

    void accept(int i);

    void accept(long j);

    void begin(long j);

    boolean cancellationRequested();

    void end();
}
