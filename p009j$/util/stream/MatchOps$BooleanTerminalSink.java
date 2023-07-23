package p009j$.util.stream;

import p009j$.util.function.Consumer;
import p009j$.util.stream.Node;

/* renamed from: j$.util.stream.MatchOps$BooleanTerminalSink */
abstract class MatchOps$BooleanTerminalSink implements Sink {
    boolean stop;
    boolean value;

    MatchOps$BooleanTerminalSink(MatchOps$MatchKind matchOps$MatchKind) {
        this.value = !matchOps$MatchKind.shortCircuitResult;
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

    public /* synthetic */ void begin(long j) {
    }

    public boolean cancellationRequested() {
        return this.stop;
    }

    public /* synthetic */ void end() {
    }
}
