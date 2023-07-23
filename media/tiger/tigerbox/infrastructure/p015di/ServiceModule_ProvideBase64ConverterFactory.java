package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.Base64Converter;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideBase64ConverterFactory */
public final class ServiceModule_ProvideBase64ConverterFactory implements Factory<Base64Converter> {
    public Base64Converter get() {
        return provideBase64Converter();
    }

    public static ServiceModule_ProvideBase64ConverterFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Base64Converter provideBase64Converter() {
        return (Base64Converter) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideBase64Converter());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideBase64ConverterFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ServiceModule_ProvideBase64ConverterFactory INSTANCE = new ServiceModule_ProvideBase64ConverterFactory();

        private InstanceHolder() {
        }
    }
}
