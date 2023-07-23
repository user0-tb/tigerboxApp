package p009j$.util.stream;

import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.MatchOps$4MatchSink */
class MatchOps$4MatchSink extends MatchOps$BooleanTerminalSink implements Sink.OfDouble {
    final /* synthetic */ MatchOps$MatchKind val$matchKind;
    final /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP val$predicate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchOps$4MatchSink(MatchOps$MatchKind matchOps$MatchKind, C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        super(matchOps$MatchKind);
        this.val$matchKind = matchOps$MatchKind;
        this.val$predicate = r2;
    }

    public void accept(double d) {
        if (!this.stop && this.val$predicate.test(d) == this.val$matchKind.stopOnPredicateMatches) {
            this.stop = true;
            this.value = this.val$matchKind.shortCircuitResult;
        }
    }

    public /* synthetic */ void accept(Double d) {
        Node.CC.$default$accept((Sink.OfDouble) this, d);
    }
}
