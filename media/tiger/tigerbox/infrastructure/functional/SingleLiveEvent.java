package media.tiger.tigerbox.infrastructure.functional;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0010*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\fH\u0017J\u0017\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0017¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "pending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "call", "", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "setValue", "t", "(Ljava/lang/Object;)V", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SingleLiveEvent.kt */
public final class SingleLiveEvent<T> extends MutableLiveData<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "SingleLiveEvent";
    private final AtomicBoolean pending = new AtomicBoolean(false);

    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (hasActiveObservers()) {
            Timber.Forest.tag(TAG).mo50236w("Multiple observers registered but only one will be notified of changes.", new Object[0]);
        }
        super.observe(lifecycleOwner, new SingleLiveEvent$$ExternalSyntheticLambda0(this, observer));
    }

    /* access modifiers changed from: private */
    /* renamed from: observe$lambda-0  reason: not valid java name */
    public static final void m2337observe$lambda0(SingleLiveEvent singleLiveEvent, Observer observer, Object obj) {
        Intrinsics.checkNotNullParameter(singleLiveEvent, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        if (singleLiveEvent.pending.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }

    public void setValue(T t) {
        this.pending.set(true);
        super.setValue(t);
    }

    public final void call() {
        setValue((Object) null);
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent$Companion;", "", "()V", "TAG", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: SingleLiveEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
