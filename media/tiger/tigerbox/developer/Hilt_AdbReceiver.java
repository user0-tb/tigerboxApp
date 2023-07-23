package media.tiger.tigerbox.developer;

import android.content.Context;
import android.content.Intent;
import dagger.hilt.android.internal.managers.BroadcastReceiverComponentManager;
import dagger.hilt.internal.UnsafeCasts;
import media.tiger.tigerbox.infrastructure.p015di.InjectableBroadcastReceiver;

public abstract class Hilt_AdbReceiver extends InjectableBroadcastReceiver {
    private volatile boolean injected = false;
    private final Object injectedLock = new Object();

    public void onReceive(Context context, Intent intent) {
        inject(context);
        super.onReceive(context, intent);
    }

    /* access modifiers changed from: protected */
    public void inject(Context context) {
        if (!this.injected) {
            synchronized (this.injectedLock) {
                if (!this.injected) {
                    ((AdbReceiver_GeneratedInjector) BroadcastReceiverComponentManager.generatedComponent(context)).injectAdbReceiver((AdbReceiver) UnsafeCasts.unsafeCast(this));
                    this.injected = true;
                }
            }
        }
    }
}
