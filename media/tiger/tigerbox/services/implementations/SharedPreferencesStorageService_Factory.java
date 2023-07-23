package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import android.media.AudioManager;
import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;

public final class SharedPreferencesStorageService_Factory implements Factory<SharedPreferencesStorageService> {
    private final Provider<String> applicationDataDirectoryProvider;
    private final Provider<String> applicationExternalStoragePathProvider;
    private final Provider<AudioManager> audioManagerProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<SharedPreferences> encryptedSharedPreferencesProvider;

    public SharedPreferencesStorageService_Factory(Provider<String> provider, Provider<String> provider2, Provider<SharedPreferences> provider3, Provider<AudioManager> provider4, Provider<ConfigurationProperties> provider5) {
        this.applicationDataDirectoryProvider = provider;
        this.applicationExternalStoragePathProvider = provider2;
        this.encryptedSharedPreferencesProvider = provider3;
        this.audioManagerProvider = provider4;
        this.configurationPropertiesProvider = provider5;
    }

    public SharedPreferencesStorageService get() {
        return newInstance(this.applicationDataDirectoryProvider.get(), this.applicationExternalStoragePathProvider.get(), this.encryptedSharedPreferencesProvider.get(), this.audioManagerProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static SharedPreferencesStorageService_Factory create(Provider<String> provider, Provider<String> provider2, Provider<SharedPreferences> provider3, Provider<AudioManager> provider4, Provider<ConfigurationProperties> provider5) {
        return new SharedPreferencesStorageService_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SharedPreferencesStorageService newInstance(String str, String str2, SharedPreferences sharedPreferences, AudioManager audioManager, ConfigurationProperties configurationProperties) {
        return new SharedPreferencesStorageService(str, str2, sharedPreferences, audioManager, configurationProperties);
    }
}
