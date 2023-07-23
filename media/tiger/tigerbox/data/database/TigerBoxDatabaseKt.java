package media.tiger.tigerbox.data.database;

import androidx.room.migration.Migration;
import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, mo33737d2 = {"MIGRATION_TIGERBOX_DATABASE_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_TIGERBOX_DATABASE_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_TIGERBOX_DATABASE_2_3", "getMIGRATION_TIGERBOX_DATABASE_2_3", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxDatabase.kt */
public final class TigerBoxDatabaseKt {
    private static final Migration MIGRATION_TIGERBOX_DATABASE_1_2 = new TigerBoxDatabaseKt$MIGRATION_TIGERBOX_DATABASE_1_2$1();
    private static final Migration MIGRATION_TIGERBOX_DATABASE_2_3 = new TigerBoxDatabaseKt$MIGRATION_TIGERBOX_DATABASE_2_3$1();

    public static final Migration getMIGRATION_TIGERBOX_DATABASE_1_2() {
        return MIGRATION_TIGERBOX_DATABASE_1_2;
    }

    public static final Migration getMIGRATION_TIGERBOX_DATABASE_2_3() {
        return MIGRATION_TIGERBOX_DATABASE_2_3;
    }
}
