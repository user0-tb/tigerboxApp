package media.tiger.tigerbox;

import android.app.Application;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.android.internal.managers.ComponentSupplier;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.UnsafeCasts;

public abstract class Hilt_TigerBoxApplication extends Application implements GeneratedComponentManagerHolder {
    private final ApplicationComponentManager componentManager = new ApplicationComponentManager(new ComponentSupplier() {
        public Object get() {
            return DaggerTigerBoxApplication_HiltComponents_SingletonC.builder().applicationContextModule(new ApplicationContextModule(Hilt_TigerBoxApplication.this)).build();
        }
    });
    private boolean injected = false;

    public final ApplicationComponentManager componentManager() {
        return this.componentManager;
    }

    public final Object generatedComponent() {
        return componentManager().generatedComponent();
    }

    public void onCreate() {
        hiltInternalInject();
        super.onCreate();
    }

    /* access modifiers changed from: protected */
    public void hiltInternalInject() {
        if (!this.injected) {
            this.injected = true;
            ((TigerBoxApplication_GeneratedInjector) generatedComponent()).injectTigerBoxApplication((TigerBoxApplication) UnsafeCasts.unsafeCast(this));
        }
    }
}
