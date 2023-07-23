package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.infrastructure.properties.AndroidSystemProperties;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideAndroidSystemPropertiesFactory */
public final class ProcessModule_ProvideAndroidSystemPropertiesFactory implements Factory<AndroidSystemProperties> {
    public AndroidSystemProperties get() {
        return provideAndroidSystemProperties();
    }

    public static ProcessModule_ProvideAndroidSystemPropertiesFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AndroidSystemProperties provideAndroidSystemProperties() {
        return (AndroidSystemProperties) Preconditions.checkNotNullFromProvides(ProcessModule.INSTANCE.provideAndroidSystemProperties());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideAndroidSystemPropertiesFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ProcessModule_ProvideAndroidSystemPropertiesFactory INSTANCE = new ProcessModule_ProvideAndroidSystemPropertiesFactory();

        private InstanceHolder() {
        }
    }
}
