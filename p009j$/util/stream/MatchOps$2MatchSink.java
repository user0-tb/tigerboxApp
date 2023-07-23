package p009j$.util.stream;

import p009j$.util.stream.Node;
import p009j$.util.stream.Sink;
import p009j$.wrappers.C$r8$wrapper$java$util$function$IntPredicate$VWRP;

/* renamed from: j$.util.stream.MatchOps$2MatchSink */
class MatchOps$2MatchSink extends MatchOps$BooleanTerminalSink implements Sink.OfInt {
    final /* synthetic */ MatchOps$MatchKind val$matchKind;
    final /* synthetic */ C$r8$wrapper$java$util$function$IntPredicate$VWRP val$predicate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchOps$2MatchSink(MatchOps$MatchKind matchOps$MatchKind, C$r8$wrapper$java$util$function$IntPredicate$VWRP r2) {
        super(matchOps$MatchKind);
        this.val$matchKind = matchOps$MatchKind;
        this.val$predicate = r2;
    }

    public void accept(int i) {
        if (!this.stop && this.val$predicate.test(i) == this.val$matchKind.stopOnPredicateMatches) {
            this.stop = true;
            this.value = this.val$matchKind.shortCircuitResult;
        }
    }

    public /* synthetic */ void accept(Integer num) {
        Node.CC.$default$accept((Sink.OfInt) this, num);
    }
}
