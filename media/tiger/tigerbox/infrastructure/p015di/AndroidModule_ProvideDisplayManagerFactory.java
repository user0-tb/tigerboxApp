package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import android.hardware.display.DisplayManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: media.tiger.tigerbox.infrastructure.di.AndroidModule_ProvideDisplayManagerFactory */
public final class AndroidModule_ProvideDisplayManagerFactory implements Factory<DisplayManager> {
    private final Provider<Context> contextProvider;

    public AndroidModule_ProvideDisplayManagerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public DisplayManager get() {
        return provideDisplayManager(this.contextProvider.get());
    }

    public static AndroidModule_ProvideDisplayManagerFactory create(Provider<Context> provider) {
        return new AndroidModule_ProvideDisplayManagerFactory(provider);
    }

    public static DisplayManager provideDisplayManager(Context context) {
        return (DisplayManager) Preconditions.checkNotNullFromProvides(AndroidModule.INSTANCE.provideDisplayManager(context));
    }
}
