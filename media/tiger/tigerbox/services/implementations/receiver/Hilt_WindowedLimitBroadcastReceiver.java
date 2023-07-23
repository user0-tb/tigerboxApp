package media.tiger.tigerbox.services.implementations.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import dagger.hilt.android.internal.managers.BroadcastReceiverComponentManager;
import dagger.hilt.internal.UnsafeCasts;

public abstract class Hilt_WindowedLimitBroadcastReceiver extends BroadcastReceiver {
    private volatile boolean injected = false;
    private final Object injectedLock = new Object();
    private final boolean onReceiveBytecodeInjectionMarker = false;

    public void onReceive(Context context, Intent intent) {
        inject(context);
    }

    /* access modifiers changed from: protected */
    public void inject(Context context) {
        if (!this.injected) {
            synchronized (this.injectedLock) {
                if (!this.injected) {
                    ((WindowedLimitBroadcastReceiver_GeneratedInjector) BroadcastReceiverComponentManager.generatedComponent(context)).injectWindowedLimitBroadcastReceiver((WindowedLimitBroadcastReceiver) UnsafeCasts.unsafeCast(this));
                    this.injected = true;
                }
            }
        }
    }
}
