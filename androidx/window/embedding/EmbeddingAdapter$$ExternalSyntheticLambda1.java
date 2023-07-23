package androidx.window.embedding;

import android.util.Pair;
import java.util.Set;
import p009j$.util.function.Predicate;

public final /* synthetic */ class EmbeddingAdapter$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ EmbeddingAdapter f$0;
    public final /* synthetic */ Set f$1;

    public /* synthetic */ EmbeddingAdapter$$ExternalSyntheticLambda1(EmbeddingAdapter embeddingAdapter, Set set) {
        this.f$0 = embeddingAdapter;
        this.f$1 = set;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    /* renamed from: or */
    public /* synthetic */ Predicate mo6806or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return EmbeddingAdapter.m712translateActivityPairPredicates$lambda1(this.f$0, this.f$1, (Pair) obj);
    }
}
