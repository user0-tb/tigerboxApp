package androidx.customview.poolingcontainer;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo33737d2 = {"Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "", "()V", "listeners", "Ljava/util/ArrayList;", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "Lkotlin/collections/ArrayList;", "addListener", "", "listener", "onRelease", "removeListener", "customview-poolingcontainer_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PoolingContainer.kt */
final class PoolingContainerListenerHolder {
    private final ArrayList<PoolingContainerListener> listeners = new ArrayList<>();

    public final void addListener(PoolingContainerListener poolingContainerListener) {
        Intrinsics.checkNotNullParameter(poolingContainerListener, "listener");
        this.listeners.add(poolingContainerListener);
    }

    public final void removeListener(PoolingContainerListener poolingContainerListener) {
        Intrinsics.checkNotNullParameter(poolingContainerListener, "listener");
        this.listeners.remove(poolingContainerListener);
    }

    public final void onRelease() {
        int lastIndex = CollectionsKt.getLastIndex(this.listeners);
        if (lastIndex >= 0) {
            while (true) {
                int i = lastIndex - 1;
                this.listeners.get(lastIndex).onRelease();
                if (i >= 0) {
                    lastIndex = i;
                } else {
                    return;
                }
            }
        }
    }
}
