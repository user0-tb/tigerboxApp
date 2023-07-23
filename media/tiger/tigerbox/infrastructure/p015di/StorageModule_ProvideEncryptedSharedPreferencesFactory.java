package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: media.tiger.tigerbox.infrastructure.di.StorageModule_ProvideEncryptedSharedPreferencesFactory */
public final class StorageModule_ProvideEncryptedSharedPreferencesFactory implements Factory<SharedPreferences> {
    private final Provider<Context> contextProvider;

    public StorageModule_ProvideEncryptedSharedPreferencesFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public SharedPreferences get() {
        return provideEncryptedSharedPreferences(this.contextProvider.get());
    }

    public static StorageModule_ProvideEncryptedSharedPreferencesFactory create(Provider<Context> provider) {
        return new StorageModule_ProvideEncryptedSharedPreferencesFactory(provider);
    }

    public static SharedPreferences provideEncryptedSharedPreferences(Context context) {
        return (SharedPreferences) Preconditions.checkNotNullFromProvides(StorageModule.INSTANCE.provideEncryptedSharedPreferences(context));
    }
}
