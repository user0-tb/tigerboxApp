package com.bumptech.glide.manager;

import com.bumptech.glide.util.C0957Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

class ActivityFragmentLifecycle implements Lifecycle {
    private boolean isDestroyed;
    private boolean isStarted;
    private final Set<LifecycleListener> lifecycleListeners = Collections.newSetFromMap(new WeakHashMap());

    ActivityFragmentLifecycle() {
    }

    public void addListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.isDestroyed) {
            lifecycleListener.onDestroy();
        } else if (this.isStarted) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    public void removeListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.remove(lifecycleListener);
    }

    /* access modifiers changed from: package-private */
    public void onStart() {
        this.isStarted = true;
        for (T onStart : C0957Util.getSnapshot(this.lifecycleListeners)) {
            onStart.onStart();
        }
    }

    /* access modifiers changed from: package-private */
    public void onStop() {
        this.isStarted = false;
        for (T onStop : C0957Util.getSnapshot(this.lifecycleListeners)) {
            onStop.onStop();
        }
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        this.isDestroyed = true;
        for (T onDestroy : C0957Util.getSnapshot(this.lifecycleListeners)) {
            onDestroy.onDestroy();
        }
    }
}
