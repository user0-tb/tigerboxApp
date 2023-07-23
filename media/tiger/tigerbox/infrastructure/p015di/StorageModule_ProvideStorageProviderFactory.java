package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.StorageModule_ProvideStorageProviderFactory */
public final class StorageModule_ProvideStorageProviderFactory implements Factory<StorageService> {
    private final Provider<AudioManager> audioManagerProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<Context> contextProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;

    public StorageModule_ProvideStorageProviderFactory(Provider<Context> provider, Provider<SharedPreferences> provider2, Provider<AudioManager> provider3, Provider<ConfigurationProperties> provider4) {
        this.contextProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.audioManagerProvider = provider3;
        this.configurationPropertiesProvider = provider4;
    }

    public StorageService get() {
        return provideStorageProvider(this.contextProvider.get(), this.sharedPreferencesProvider.get(), this.audioManagerProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static StorageModule_ProvideStorageProviderFactory create(Provider<Context> provider, Provider<SharedPreferences> provider2, Provider<AudioManager> provider3, Provider<ConfigurationProperties> provider4) {
        return new StorageModule_ProvideStorageProviderFactory(provider, provider2, provider3, provider4);
    }

    public static StorageService provideStorageProvider(Context context, SharedPreferences sharedPreferences, AudioManager audioManager, ConfigurationProperties configurationProperties) {
        return (StorageService) Preconditions.checkNotNullFromProvides(StorageModule.INSTANCE.provideStorageProvider(context, sharedPreferences, audioManager, configurationProperties));
    }
}
