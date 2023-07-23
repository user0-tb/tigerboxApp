package media.tiger.tigerbox.services.interfaces;

import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0004¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007J\u001a\u0010\u0014\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/HardwareEventPublisher;", "T", "E", "", "()V", "subscribers", "", "Lmedia/tiger/tigerbox/services/interfaces/HardwareEventSubscriber;", "handleAction", "", "action", "", "intent", "Landroid/content/Intent;", "publish", "event", "(Ljava/lang/Object;)V", "publishError", "subscribe", "subscriber", "unsubscribe", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareEventPublisher.kt */
public abstract class HardwareEventPublisher<T, E> {
    private final List<HardwareEventSubscriber<T, E>> subscribers = new ArrayList();

    public abstract void handleAction(String str, Intent intent);

    public final void subscribe(HardwareEventSubscriber<T, E> hardwareEventSubscriber) {
        Intrinsics.checkNotNullParameter(hardwareEventSubscriber, "subscriber");
        if (!this.subscribers.contains(hardwareEventSubscriber)) {
            this.subscribers.add(hardwareEventSubscriber);
        }
    }

    public final void unsubscribe(HardwareEventSubscriber<T, E> hardwareEventSubscriber) {
        Intrinsics.checkNotNullParameter(hardwareEventSubscriber, "subscriber");
        if (this.subscribers.contains(hardwareEventSubscriber)) {
            this.subscribers.remove(hardwareEventSubscriber);
        }
    }

    /* access modifiers changed from: protected */
    public final void publish(T t) {
        for (HardwareEventSubscriber onReceive : this.subscribers) {
            onReceive.onReceive(t);
        }
    }

    /* access modifiers changed from: protected */
    public final void publishError(E e) {
        for (HardwareEventSubscriber onError : this.subscribers) {
            onError.onError(e);
        }
    }
}
