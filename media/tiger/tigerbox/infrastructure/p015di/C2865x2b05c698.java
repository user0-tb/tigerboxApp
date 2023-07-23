package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ConfigurationPropertiesModule_ProvideConfigurationPropertiesFactory */
public final class C2865x2b05c698 implements Factory<ConfigurationProperties> {
    private final Provider<Context> appContextProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public C2865x2b05c698(Provider<Context> provider, Provider<SharedPreferences> provider2) {
        this.appContextProvider = provider;
        this.sharedPreferencesProvider = provider2;
    }

    public ConfigurationProperties get() {
        return provideConfigurationProperties(this.appContextProvider.get(), this.sharedPreferencesProvider.get());
    }

    public static C2865x2b05c698 create(Provider<Context> provider, Provider<SharedPreferences> provider2) {
        return new C2865x2b05c698(provider, provider2);
    }

    public static ConfigurationProperties provideConfigurationProperties(Context context, SharedPreferences sharedPreferences) {
        return (ConfigurationProperties) Preconditions.checkNotNullFromProvides(ConfigurationPropertiesModule.INSTANCE.provideConfigurationProperties(context, sharedPreferences));
    }
}
