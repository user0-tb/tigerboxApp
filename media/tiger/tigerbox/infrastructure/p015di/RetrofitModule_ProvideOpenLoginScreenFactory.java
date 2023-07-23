package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.onboarding.ReauthenticationLoginHandler;

/* renamed from: media.tiger.tigerbox.infrastructure.di.RetrofitModule_ProvideOpenLoginScreenFactory */
public final class RetrofitModule_ProvideOpenLoginScreenFactory implements Factory<ReauthenticationLoginHandler> {
    private final Provider<Context> contextProvider;

    public RetrofitModule_ProvideOpenLoginScreenFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public ReauthenticationLoginHandler get() {
        return provideOpenLoginScreen(this.contextProvider.get());
    }

    public static RetrofitModule_ProvideOpenLoginScreenFactory create(Provider<Context> provider) {
        return new RetrofitModule_ProvideOpenLoginScreenFactory(provider);
    }

    public static ReauthenticationLoginHandler provideOpenLoginScreen(Context context) {
        return (ReauthenticationLoginHandler) Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideOpenLoginScreen(context));
    }
}
