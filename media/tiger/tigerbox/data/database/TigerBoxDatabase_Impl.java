package media.tiger.tigerbox.data.database;

import androidx.core.app.NotificationCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p006db.SupportSQLiteDatabase;
import androidx.sqlite.p006db.SupportSQLiteOpenHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class TigerBoxDatabase_Impl extends TigerBoxDatabase {
    private volatile AccessTokenDao _accessTokenDao;
    private volatile HlsKeysDao _hlsKeysDao;
    private volatile PlaybackPositionsDao _playbackPositionsDao;
    private volatile PlaybackTrackingDao _playbackTrackingDao;
    private volatile TigerBoxProfileDao _tigerBoxProfileDao;
    private volatile TigerBoxUserDao _tigerBoxUserDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(3) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tigerboxUser` (`profileId` INTEGER NOT NULL, `accountId` INTEGER NOT NULL, `activeProfileId` INTEGER NOT NULL, `email` TEXT NOT NULL, `pin` TEXT, PRIMARY KEY(`profileId`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tigerboxProfile` (`id` INTEGER NOT NULL, `email` TEXT NOT NULL, `accountId` INTEGER NOT NULL, `nickName` TEXT NOT NULL, `birthday` TEXT, `gender` TEXT, `avatarUrl` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `accessToken` (`access_token` TEXT NOT NULL, `refresh_token` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `playbackPositions` (`userId` INTEGER NOT NULL DEFAULT -1, `productId` INTEGER NOT NULL DEFAULT -1, `trackNumber` INTEGER NOT NULL DEFAULT -1, `trackPosition` INTEGER NOT NULL DEFAULT 0, `modifiedDate` TEXT NOT NULL DEFAULT '', `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `playbackTracking` (`accountId` INTEGER NOT NULL DEFAULT -1, `userId` INTEGER NOT NULL DEFAULT -1, `productId` INTEGER NOT NULL DEFAULT -1, `event` TEXT NOT NULL DEFAULT 'progress', `start` INTEGER NOT NULL DEFAULT 0, `end` INTEGER NOT NULL DEFAULT 0, `total` INTEGER NOT NULL DEFAULT 0, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `hlsKeys` (`key` TEXT NOT NULL DEFAULT '', `url` TEXT NOT NULL DEFAULT '', `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '432407fe44b7768b8ccad56960eccb04')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `tigerboxUser`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `tigerboxProfile`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `accessToken`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `playbackPositions`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `playbackTracking`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `hlsKeys`");
                if (TigerBoxDatabase_Impl.this.mCallbacks != null) {
                    int size = TigerBoxDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) TigerBoxDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (TigerBoxDatabase_Impl.this.mCallbacks != null) {
                    int size = TigerBoxDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) TigerBoxDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = TigerBoxDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                TigerBoxDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (TigerBoxDatabase_Impl.this.mCallbacks != null) {
                    int size = TigerBoxDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) TigerBoxDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(5);
                hashMap.put("profileId", new TableInfo.Column("profileId", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("accountId", new TableInfo.Column("accountId", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("activeProfileId", new TableInfo.Column("activeProfileId", "INTEGER", true, 0, (String) null, 1));
                hashMap.put(NotificationCompat.CATEGORY_EMAIL, new TableInfo.Column(NotificationCompat.CATEGORY_EMAIL, "TEXT", true, 0, (String) null, 1));
                hashMap.put("pin", new TableInfo.Column("pin", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("tigerboxUser", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "tigerboxUser");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "tigerboxUser(media.tiger.tigerbox.model.domain.TigerBoxUserDomain).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(7);
                hashMap2.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, (String) null, 1));
                hashMap2.put(NotificationCompat.CATEGORY_EMAIL, new TableInfo.Column(NotificationCompat.CATEGORY_EMAIL, "TEXT", true, 0, (String) null, 1));
                hashMap2.put("accountId", new TableInfo.Column("accountId", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("nickName", new TableInfo.Column("nickName", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("birthday", new TableInfo.Column("birthday", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("gender", new TableInfo.Column("gender", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("avatarUrl", new TableInfo.Column("avatarUrl", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("tigerboxProfile", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "tigerboxProfile");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "tigerboxProfile(media.tiger.tigerbox.model.domain.TigerBoxProfileDomain).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(3);
                hashMap3.put("access_token", new TableInfo.Column("access_token", "TEXT", true, 0, (String) null, 1));
                hashMap3.put("refresh_token", new TableInfo.Column("refresh_token", "TEXT", true, 0, (String) null, 1));
                hashMap3.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("accessToken", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "accessToken");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "accessToken(media.tiger.tigerbox.model.domain.AccessTokenDomain).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(6);
                hashMap4.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, "-1", 1));
                hashMap4.put("productId", new TableInfo.Column("productId", "INTEGER", true, 0, "-1", 1));
                hashMap4.put("trackNumber", new TableInfo.Column("trackNumber", "INTEGER", true, 0, "-1", 1));
                hashMap4.put("trackPosition", new TableInfo.Column("trackPosition", "INTEGER", true, 0, SessionDescription.SUPPORTED_SDP_VERSION, 1));
                hashMap4.put("modifiedDate", new TableInfo.Column("modifiedDate", "TEXT", true, 0, "''", 1));
                hashMap4.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, (String) null, 1));
                TableInfo tableInfo4 = new TableInfo("playbackPositions", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "playbackPositions");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "playbackPositions(media.tiger.tigerbox.model.domain.PlaybackPositionDomain).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(8);
                hashMap5.put("accountId", new TableInfo.Column("accountId", "INTEGER", true, 0, "-1", 1));
                hashMap5.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, "-1", 1));
                hashMap5.put("productId", new TableInfo.Column("productId", "INTEGER", true, 0, "-1", 1));
                hashMap5.put(NotificationCompat.CATEGORY_EVENT, new TableInfo.Column(NotificationCompat.CATEGORY_EVENT, "TEXT", true, 0, "'progress'", 1));
                hashMap5.put(TtmlNode.START, new TableInfo.Column(TtmlNode.START, "INTEGER", true, 0, SessionDescription.SUPPORTED_SDP_VERSION, 1));
                hashMap5.put(TtmlNode.END, new TableInfo.Column(TtmlNode.END, "INTEGER", true, 0, SessionDescription.SUPPORTED_SDP_VERSION, 1));
                hashMap5.put("total", new TableInfo.Column("total", "INTEGER", true, 0, SessionDescription.SUPPORTED_SDP_VERSION, 1));
                hashMap5.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, (String) null, 1));
                TableInfo tableInfo5 = new TableInfo("playbackTracking", hashMap5, new HashSet(0), new HashSet(0));
                TableInfo read5 = TableInfo.read(supportSQLiteDatabase2, "playbackTracking");
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "playbackTracking(media.tiger.tigerbox.model.domain.PlaybackTrackingDomain).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(3);
                hashMap6.put("key", new TableInfo.Column("key", "TEXT", true, 0, "''", 1));
                hashMap6.put("url", new TableInfo.Column("url", "TEXT", true, 0, "''", 1));
                hashMap6.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, (String) null, 1));
                TableInfo tableInfo6 = new TableInfo("hlsKeys", hashMap6, new HashSet(0), new HashSet(0));
                TableInfo read6 = TableInfo.read(supportSQLiteDatabase2, "hlsKeys");
                if (tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "hlsKeys(media.tiger.tigerbox.model.domain.HlsKeyDomain).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
            }
        }, "432407fe44b7768b8ccad56960eccb04", "69437cf985cc14aa96e1271e90b99f12")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "tigerboxUser", "tigerboxProfile", "accessToken", "playbackPositions", "playbackTracking", "hlsKeys");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `tigerboxUser`");
            writableDatabase.execSQL("DELETE FROM `tigerboxProfile`");
            writableDatabase.execSQL("DELETE FROM `accessToken`");
            writableDatabase.execSQL("DELETE FROM `playbackPositions`");
            writableDatabase.execSQL("DELETE FROM `playbackTracking`");
            writableDatabase.execSQL("DELETE FROM `hlsKeys`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(TigerBoxUserDao.class, TigerBoxUserDao_Impl.getRequiredConverters());
        hashMap.put(TigerBoxProfileDao.class, TigerBoxProfileDao_Impl.getRequiredConverters());
        hashMap.put(AccessTokenDao.class, AccessTokenDao_Impl.getRequiredConverters());
        hashMap.put(PlaybackPositionsDao.class, PlaybackPositionsDao_Impl.getRequiredConverters());
        hashMap.put(PlaybackTrackingDao.class, PlaybackTrackingDao_Impl.getRequiredConverters());
        hashMap.put(HlsKeysDao.class, HlsKeysDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public TigerBoxUserDao tigerBoxUserDao() {
        TigerBoxUserDao tigerBoxUserDao;
        if (this._tigerBoxUserDao != null) {
            return this._tigerBoxUserDao;
        }
        synchronized (this) {
            if (this._tigerBoxUserDao == null) {
                this._tigerBoxUserDao = new TigerBoxUserDao_Impl(this);
            }
            tigerBoxUserDao = this._tigerBoxUserDao;
        }
        return tigerBoxUserDao;
    }

    public TigerBoxProfileDao tigerBoxProfileDao() {
        TigerBoxProfileDao tigerBoxProfileDao;
        if (this._tigerBoxProfileDao != null) {
            return this._tigerBoxProfileDao;
        }
        synchronized (this) {
            if (this._tigerBoxProfileDao == null) {
                this._tigerBoxProfileDao = new TigerBoxProfileDao_Impl(this);
            }
            tigerBoxProfileDao = this._tigerBoxProfileDao;
        }
        return tigerBoxProfileDao;
    }

    public AccessTokenDao accessTokenDao() {
        AccessTokenDao accessTokenDao;
        if (this._accessTokenDao != null) {
            return this._accessTokenDao;
        }
        synchronized (this) {
            if (this._accessTokenDao == null) {
                this._accessTokenDao = new AccessTokenDao_Impl(this);
            }
            accessTokenDao = this._accessTokenDao;
        }
        return accessTokenDao;
    }

    public PlaybackPositionsDao playbackPositionsDao() {
        PlaybackPositionsDao playbackPositionsDao;
        if (this._playbackPositionsDao != null) {
            return this._playbackPositionsDao;
        }
        synchronized (this) {
            if (this._playbackPositionsDao == null) {
                this._playbackPositionsDao = new PlaybackPositionsDao_Impl(this);
            }
            playbackPositionsDao = this._playbackPositionsDao;
        }
        return playbackPositionsDao;
    }

    public PlaybackTrackingDao playbackTrackingDao() {
        PlaybackTrackingDao playbackTrackingDao;
        if (this._playbackTrackingDao != null) {
            return this._playbackTrackingDao;
        }
        synchronized (this) {
            if (this._playbackTrackingDao == null) {
                this._playbackTrackingDao = new PlaybackTrackingDao_Impl(this);
            }
            playbackTrackingDao = this._playbackTrackingDao;
        }
        return playbackTrackingDao;
    }

    public HlsKeysDao hlsKeysDao() {
        HlsKeysDao hlsKeysDao;
        if (this._hlsKeysDao != null) {
            return this._hlsKeysDao;
        }
        synchronized (this) {
            if (this._hlsKeysDao == null) {
                this._hlsKeysDao = new HlsKeysDao_Impl(this);
            }
            hlsKeysDao = this._hlsKeysDao;
        }
        return hlsKeysDao;
    }
}
