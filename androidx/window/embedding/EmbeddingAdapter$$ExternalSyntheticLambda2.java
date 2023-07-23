package androidx.window.embedding;

import android.view.WindowMetrics;
import p009j$.util.function.Predicate;

public final /* synthetic */ class EmbeddingAdapter$$ExternalSyntheticLambda2 implements Predicate {
    public final /* synthetic */ SplitRule f$0;

    public /* synthetic */ EmbeddingAdapter$$ExternalSyntheticLambda2(SplitRule splitRule) {
        this.f$0 = splitRule;
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
        return EmbeddingAdapter.m715translateParentMetricsPredicate$lambda4(this.f$0, (WindowMetrics) obj);
    }
}
