package media.tiger.tigerbox.data.database;

import androidx.room.migration.Migration;
import androidx.sqlite.p006db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/data/database/TigerBoxDatabaseKt$MIGRATION_TIGERBOX_DATABASE_2_3$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxDatabase.kt */
public final class TigerBoxDatabaseKt$MIGRATION_TIGERBOX_DATABASE_2_3$1 extends Migration {
    TigerBoxDatabaseKt$MIGRATION_TIGERBOX_DATABASE_2_3$1() {
        super(2, 3);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `playbackPositions` (`trackPosition` INTEGER NOT NULL DEFAULT 0, `modifiedDate` TEXT NOT NULL DEFAULT '', `id` INTEGER NOT NULL, `userId` INTEGER NOT NULL DEFAULT -1, `productId` INTEGER NOT NULL DEFAULT -1, `trackNumber` INTEGER NOT NULL DEFAULT -1, PRIMARY KEY (`id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `playbackTracking` (`id` INTEGER NOT NULL, `accountId` INTEGER NOT NULL DEFAULT -1, `userId` INTEGER NOT NULL DEFAULT -1, `productId` INTEGER NOT NULL DEFAULT -1, `event` TEXT NOT NULL DEFAULT 'progress', `start` INTEGER NOT NULL DEFAULT 0, `end` INTEGER NOT NULL DEFAULT 0, `total` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY (`id`))");
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `hlsKeys` (`id` INTEGER NOT NULL, `key` TEXT NOT NULL DEFAULT '', `url` TEXT NOT NULL DEFAULT '', PRIMARY KEY (`id`))");
    }
}
