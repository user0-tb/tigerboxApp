package media.tiger.tigerbox.infrastructure.p015di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Environment;
import androidx.room.Room;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.DatabaseMigrationService;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.database.TigerBoxDatabaseKt;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;
import media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository;
import media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository;
import media.tiger.tigerbox.data.repository.DefaultPlaybackPositionsRepository;
import media.tiger.tigerbox.data.repository.DefaultPlaybackTrackingRepository;
import media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository;
import media.tiger.tigerbox.data.repository.HlsKeysRepository;
import media.tiger.tigerbox.data.repository.PlaybackPositionsRepository;
import media.tiger.tigerbox.data.repository.PlaybackTrackingRepository;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.onboarding.ReauthenticationLoginHandler;
import media.tiger.tigerbox.services.implementations.SharedPreferencesStorageService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SupportFactory;

@Metadata(mo33736d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0012\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0017H\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\r\u001a\u00020\u000eH\u0007J*\u0010!\u001a\u00020\u00152\b\b\u0001\u0010\u0018\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J8\u0010%\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006)"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/di/StorageModule;", "", "()V", "PREF_NAME", "", "provideAccessTokenRepository", "Lmedia/tiger/tigerbox/data/repository/AccessTokenRepository;", "databaseMigrationService", "Lmedia/tiger/tigerbox/DatabaseMigrationService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "tigerBoxDatabase", "Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "provideDatabase", "app", "Landroid/app/Application;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "provideEncryptedSharedPreferences", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "provideHlsKeysRepository", "Lmedia/tiger/tigerbox/data/repository/HlsKeysRepository;", "encryptedSharedPreferences", "providePlaybackPositionsRepository", "Lmedia/tiger/tigerbox/data/repository/PlaybackPositionsRepository;", "providePlaybackTrackingRepository", "Lmedia/tiger/tigerbox/data/repository/PlaybackTrackingRepository;", "provideStorageProvider", "sharedPreferences", "audioManager", "Landroid/media/AudioManager;", "provideTigerBoxAccountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "loginHandler", "Lmedia/tiger/tigerbox/ui/onboarding/ReauthenticationLoginHandler;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@Module
/* renamed from: media.tiger.tigerbox.infrastructure.di.StorageModule */
/* compiled from: StorageModule.kt */
public final class StorageModule {
    public static final StorageModule INSTANCE = new StorageModule();
    public static final String PREF_NAME = "TIGER_PREFS";

    private StorageModule() {
    }

    @Singleton
    @Provides
    public final SharedPreferences provideEncryptedSharedPreferences(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences create = EncryptedSharedPreferences.create(context, PREF_NAME, new MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        Intrinsics.checkNotNullExpressionValue(create, "create(\n            cont…heme.AES256_GCM\n        )");
        return create;
    }

    @Singleton
    @Provides
    public final StorageService provideStorageProvider(@ApplicationContext Context context, SharedPreferences sharedPreferences, AudioManager audioManager, ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(audioManager, "audioManager");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        String str = context.getApplicationInfo().dataDir;
        Intrinsics.checkNotNullExpressionValue(str, "context.applicationInfo.dataDir");
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getExternalStorageDirectory().absolutePath");
        return new SharedPreferencesStorageService(str, absolutePath, sharedPreferences, audioManager, configurationProperties);
    }

    @Singleton
    @Provides
    public final TigerBoxDatabase provideDatabase(Application application, StorageService storageService) {
        Intrinsics.checkNotNullParameter(application, "app");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        char[] charArray = storageService.getKeyStorePassword().toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        byte[] bytes = SQLiteDatabase.getBytes(charArray);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(storageService.…rePassword.toCharArray())");
        return Room.databaseBuilder(application, TigerBoxDatabase.class, TigerBoxDatabase.DATABASE_NAME).openHelperFactory(new SupportFactory(bytes)).fallbackToDestructiveMigration().addMigrations(TigerBoxDatabaseKt.getMIGRATION_TIGERBOX_DATABASE_1_2()).addMigrations(TigerBoxDatabaseKt.getMIGRATION_TIGERBOX_DATABASE_2_3()).build();
    }

    @Singleton
    @Provides
    public final TigerBoxAccountRepository provideTigerBoxAccountRepository(DatabaseMigrationService databaseMigrationService, TimeService timeService, TigerBoxWebService tigerBoxWebService, TigerBoxDatabase tigerBoxDatabase, StorageService storageService, ReauthenticationLoginHandler reauthenticationLoginHandler) {
        Intrinsics.checkNotNullParameter(databaseMigrationService, "databaseMigrationService");
        Intrinsics.checkNotNullParameter(timeService, "timeService");
        Intrinsics.checkNotNullParameter(tigerBoxWebService, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDatabase");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(reauthenticationLoginHandler, "loginHandler");
        return new DefaultTigerBoxAccountRepository(databaseMigrationService, timeService, tigerBoxWebService, tigerBoxDatabase, storageService, reauthenticationLoginHandler);
    }

    @Singleton
    @Provides
    public final AccessTokenRepository provideAccessTokenRepository(DatabaseMigrationService databaseMigrationService, TimeService timeService, TigerBoxWebService tigerBoxWebService, TigerBoxDatabase tigerBoxDatabase, ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(databaseMigrationService, "databaseMigrationService");
        Intrinsics.checkNotNullParameter(timeService, "timeService");
        Intrinsics.checkNotNullParameter(tigerBoxWebService, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDatabase");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        return new DefaultAccessTokenRepository(databaseMigrationService, timeService, tigerBoxWebService, tigerBoxDatabase, configurationProperties);
    }

    @Singleton
    @Provides
    public final PlaybackPositionsRepository providePlaybackPositionsRepository(TigerBoxDatabase tigerBoxDatabase) {
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDatabase");
        return new DefaultPlaybackPositionsRepository(tigerBoxDatabase);
    }

    @Singleton
    @Provides
    public final PlaybackTrackingRepository providePlaybackTrackingRepository(TigerBoxDatabase tigerBoxDatabase) {
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDatabase");
        return new DefaultPlaybackTrackingRepository(tigerBoxDatabase);
    }

    @Singleton
    @Provides
    public final HlsKeysRepository provideHlsKeysRepository(TigerBoxDatabase tigerBoxDatabase, SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDatabase");
        Intrinsics.checkNotNullParameter(sharedPreferences, "encryptedSharedPreferences");
        return new DefaultHlsKeysRepository(tigerBoxDatabase, sharedPreferences);
    }
}
