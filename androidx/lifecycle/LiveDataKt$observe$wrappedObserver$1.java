package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo33735bv = {1, 0, 3}, mo33736d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n"}, mo33737d2 = {"T", "kotlin.jvm.PlatformType", "t", "", "<anonymous>"}, mo33738k = 3, mo33739mv = {1, 5, 1})
/* compiled from: LiveData.kt */
public final class LiveDataKt$observe$wrappedObserver$1<T> implements Observer {
    final /* synthetic */ Function1<T, Unit> $onChanged;

    public LiveDataKt$observe$wrappedObserver$1(Function1<? super T, Unit> function1) {
        this.$onChanged = function1;
    }

    public final void onChanged(T t) {
        this.$onChanged.invoke(t);
    }
}
