package androidx.core.view;

import android.content.ClipData;
import androidx.core.util.Predicate;

public final /* synthetic */ class ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ p009j$.util.function.Predicate f$0;

    public /* synthetic */ ContentInfoCompat$Api31Impl$$ExternalSyntheticLambda0(p009j$.util.function.Predicate predicate) {
        this.f$0 = predicate;
    }

    public final boolean test(Object obj) {
        return this.f$0.test((ClipData.Item) obj);
    }
}
