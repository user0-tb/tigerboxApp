package p009j$.util.stream;

import p009j$.util.function.Predicate;

/* renamed from: j$.util.stream.MatchOps$1MatchSink */
class MatchOps$1MatchSink extends MatchOps$BooleanTerminalSink {
    final /* synthetic */ MatchOps$MatchKind val$matchKind;
    final /* synthetic */ Predicate val$predicate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MatchOps$1MatchSink(MatchOps$MatchKind matchOps$MatchKind, Predicate predicate) {
        super(matchOps$MatchKind);
        this.val$matchKind = matchOps$MatchKind;
        this.val$predicate = predicate;
    }

    public void accept(Object obj) {
        if (!this.stop && this.val$predicate.test(obj) == this.val$matchKind.stopOnPredicateMatches) {
            this.stop = true;
            this.value = this.val$matchKind.shortCircuitResult;
        }
    }
}
