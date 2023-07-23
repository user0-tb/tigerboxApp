package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(mo33735bv = {1, 0, 3}, mo33736d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00018\u00008\u0000H\n"}, mo33737d2 = {"X", "Y", "kotlin.jvm.PlatformType", "it", "<anonymous>"}, mo33738k = 3, mo33739mv = {1, 5, 1})
/* compiled from: Transformations.kt */
public final class TransformationsKt$map$1<I, O> implements Function {
    final /* synthetic */ Function1<X, Y> $transform;

    public TransformationsKt$map$1(Function1<? super X, ? extends Y> function1) {
        this.$transform = function1;
    }

    public final Y apply(X x) {
        return this.$transform.invoke(x);
    }
}
