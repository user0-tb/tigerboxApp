package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import android.os.PowerManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: media.tiger.tigerbox.infrastructure.di.AndroidModule_ProvidePowerManagerFactory */
public final class AndroidModule_ProvidePowerManagerFactory implements Factory<PowerManager> {
    private final Provider<Context> contextProvider;

    public AndroidModule_ProvidePowerManagerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public PowerManager get() {
        return providePowerManager(this.contextProvider.get());
    }

    public static AndroidModule_ProvidePowerManagerFactory create(Provider<Context> provider) {
        return new AndroidModule_ProvidePowerManagerFactory(provider);
    }

    public static PowerManager providePowerManager(Context context) {
        return (PowerManager) Preconditions.checkNotNullFromProvides(AndroidModule.INSTANCE.providePowerManager(context));
    }
}
