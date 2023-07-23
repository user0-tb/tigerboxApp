package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DigestValidator;

/* renamed from: media.tiger.tigerbox.infrastructure.di.RetrofitModule_ProvideSignatureValidatorFactory */
public final class RetrofitModule_ProvideSignatureValidatorFactory implements Factory<DigestValidator> {
    public DigestValidator get() {
        return provideSignatureValidator();
    }

    public static RetrofitModule_ProvideSignatureValidatorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DigestValidator provideSignatureValidator() {
        return (DigestValidator) Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideSignatureValidator());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.RetrofitModule_ProvideSignatureValidatorFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RetrofitModule_ProvideSignatureValidatorFactory INSTANCE = new RetrofitModule_ProvideSignatureValidatorFactory();

        private InstanceHolder() {
        }
    }
}
