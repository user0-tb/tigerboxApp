package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/di/ConfigurationPropertiesModule;", "", "()V", "provideConfigurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "appContext", "Landroid/content/Context;", "sharedPreferences", "Landroid/content/SharedPreferences;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@Module
/* renamed from: media.tiger.tigerbox.infrastructure.di.ConfigurationPropertiesModule */
/* compiled from: ConfigurationPropertiesModule.kt */
public final class ConfigurationPropertiesModule {
    public static final ConfigurationPropertiesModule INSTANCE = new ConfigurationPropertiesModule();

    private ConfigurationPropertiesModule() {
    }

    @Singleton
    @Provides
    public final ConfigurationProperties provideConfigurationProperties(@ApplicationContext Context context, SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        return new ConfigurationProperties(context, ConfigurationProperties.ConfigurationEnvironment.PRODUCTION, sharedPreferences);
    }
}
