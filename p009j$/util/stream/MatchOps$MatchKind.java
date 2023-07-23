package p009j$.util.stream;

/* renamed from: j$.util.stream.MatchOps$MatchKind */
enum MatchOps$MatchKind {
    ANY(true, true),
    ALL(false, false),
    NONE(true, false);
    
    /* access modifiers changed from: private */
    public final boolean shortCircuitResult;
    /* access modifiers changed from: private */
    public final boolean stopOnPredicateMatches;

    private MatchOps$MatchKind(boolean z, boolean z2) {
        this.stopOnPredicateMatches = z;
        this.shortCircuitResult = z2;
    }
}
