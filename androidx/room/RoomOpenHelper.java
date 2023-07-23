package androidx.room;

import androidx.room.migration.Migration;
import androidx.sqlite.p006db.SupportSQLiteDatabase;
import androidx.sqlite.p006db.SupportSQLiteOpenHelper;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0017\u0018\u0000 \u00192\u00020\u0001:\u0003\u0019\u001a\u001bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo33737d2 = {"Landroidx/room/RoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "configuration", "Landroidx/room/DatabaseConfiguration;", "delegate", "Landroidx/room/RoomOpenHelper$Delegate;", "legacyHash", "", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;)V", "identityHash", "(Landroidx/room/DatabaseConfiguration;Landroidx/room/RoomOpenHelper$Delegate;Ljava/lang/String;Ljava/lang/String;)V", "checkIdentity", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "createMasterTableIfNotExists", "onConfigure", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "updateIdentity", "Companion", "Delegate", "ValidationResult", "room-runtime_release"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* compiled from: RoomOpenHelper.kt */
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private DatabaseConfiguration configuration;
    private final Delegate delegate;
    private final String identityHash;
    private final String legacyHash;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate2, String str, String str2) {
        super(delegate2.version);
        Intrinsics.checkNotNullParameter(databaseConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(delegate2, "delegate");
        Intrinsics.checkNotNullParameter(str, "identityHash");
        Intrinsics.checkNotNullParameter(str2, "legacyHash");
        this.configuration = databaseConfiguration;
        this.delegate = delegate2;
        this.identityHash = str;
        this.legacyHash = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate2, String str) {
        this(databaseConfiguration, delegate2, "", str);
        Intrinsics.checkNotNullParameter(databaseConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(delegate2, "delegate");
        Intrinsics.checkNotNullParameter(str, "legacyHash");
    }

    public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        super.onConfigure(supportSQLiteDatabase);
    }

    public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        boolean hasEmptySchema$room_runtime_release = Companion.hasEmptySchema$room_runtime_release(supportSQLiteDatabase);
        this.delegate.createAllTables(supportSQLiteDatabase);
        if (!hasEmptySchema$room_runtime_release) {
            ValidationResult onValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (!onValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + onValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(supportSQLiteDatabase);
        this.delegate.onCreate(supportSQLiteDatabase);
    }

    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        List<Migration> findMigrationPath;
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        DatabaseConfiguration databaseConfiguration = this.configuration;
        boolean z = false;
        if (!(databaseConfiguration == null || (findMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i, i2)) == null)) {
            this.delegate.onPreMigrate(supportSQLiteDatabase);
            for (Migration migrate : findMigrationPath) {
                migrate.migrate(supportSQLiteDatabase);
            }
            ValidationResult onValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (onValidateSchema.isValid) {
                this.delegate.onPostMigrate(supportSQLiteDatabase);
                updateIdentity(supportSQLiteDatabase);
                z = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + onValidateSchema.expectedFoundMsg);
            }
        }
        if (!z) {
            DatabaseConfiguration databaseConfiguration2 = this.configuration;
            if (databaseConfiguration2 == null || databaseConfiguration2.isMigrationRequired(i, i2)) {
                throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.delegate.dropAllTables(supportSQLiteDatabase);
            this.delegate.createAllTables(supportSQLiteDatabase);
        }
    }

    public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        onUpgrade(supportSQLiteDatabase, i, i2);
    }

    public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        super.onOpen(supportSQLiteDatabase);
        checkIdentity(supportSQLiteDatabase);
        this.delegate.onOpen(supportSQLiteDatabase);
        this.configuration = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkIdentity(androidx.sqlite.p006db.SupportSQLiteDatabase r5) {
        /*
            r4 = this;
            androidx.room.RoomOpenHelper$Companion r0 = Companion
            boolean r0 = r0.hasRoomMasterTable$room_runtime_release(r5)
            if (r0 == 0) goto L_0x0083
            androidx.sqlite.db.SimpleSQLiteQuery r0 = new androidx.sqlite.db.SimpleSQLiteQuery
            java.lang.String r1 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r0.<init>(r1)
            androidx.sqlite.db.SupportSQLiteQuery r0 = (androidx.sqlite.p006db.SupportSQLiteQuery) r0
            android.database.Cursor r5 = r5.query((androidx.sqlite.p006db.SupportSQLiteQuery) r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 15
            r2 = 0
            r3 = 0
            if (r0 <= r1) goto L_0x003b
            java.io.Closeable r5 = (java.io.Closeable) r5
            r0 = r5
            android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0034 }
            boolean r1 = r0.moveToFirst()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x002d
            java.lang.String r0 = r0.getString(r2)     // Catch:{ all -> 0x0034 }
            goto L_0x0030
        L_0x002d:
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0034 }
        L_0x0030:
            kotlin.p013io.CloseableKt.closeFinally(r5, r3)
            goto L_0x004c
        L_0x0034:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r1 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r5, r0)
            throw r1
        L_0x003b:
            boolean r0 = r5.moveToFirst()     // Catch:{ all -> 0x007e }
            if (r0 == 0) goto L_0x0046
            java.lang.String r0 = r5.getString(r2)     // Catch:{ all -> 0x007e }
            goto L_0x0049
        L_0x0046:
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x007e }
            r0 = r3
        L_0x0049:
            r5.close()
        L_0x004c:
            java.lang.String r5 = r4.identityHash
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r5 != 0) goto L_0x0095
            java.lang.String r5 = r4.legacyHash
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            if (r5 == 0) goto L_0x005d
            goto L_0x0095
        L_0x005d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r1.append(r2)
            java.lang.String r2 = r4.identityHash
            r1.append(r2)
            java.lang.String r2 = ", found: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.<init>(r0)
            throw r5
        L_0x007e:
            r0 = move-exception
            r5.close()
            throw r0
        L_0x0083:
            androidx.room.RoomOpenHelper$Delegate r0 = r4.delegate
            androidx.room.RoomOpenHelper$ValidationResult r0 = r0.onValidateSchema(r5)
            boolean r1 = r0.isValid
            if (r1 == 0) goto L_0x0096
            androidx.room.RoomOpenHelper$Delegate r0 = r4.delegate
            r0.onPostMigrate(r5)
            r4.updateIdentity(r5)
        L_0x0095:
            return
        L_0x0096:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r1.append(r2)
            java.lang.String r0 = r0.expectedFoundMsg
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.checkIdentity(androidx.sqlite.db.SupportSQLiteDatabase):void");
    }

    private final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0015R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo33737d2 = {"Landroidx/room/RoomOpenHelper$Delegate;", "", "version", "", "(I)V", "createAllTables", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "dropAllTables", "onCreate", "onOpen", "onPostMigrate", "onPreMigrate", "onValidateSchema", "Landroidx/room/RoomOpenHelper$ValidationResult;", "db", "validateMigration", "room-runtime_release"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    /* compiled from: RoomOpenHelper.kt */
    public static abstract class Delegate {
        public final int version;

        public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        }

        public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        }

        public Delegate(int i) {
            this.version = i;
        }

        /* access modifiers changed from: protected */
        @Deprecated(message = "Use [onValidateSchema(SupportSQLiteDatabase)]")
        public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        public ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
            validateMigration(supportSQLiteDatabase);
            return new ValidationResult(true, (String) null);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Landroidx/room/RoomOpenHelper$ValidationResult;", "", "isValid", "", "expectedFoundMsg", "", "(ZLjava/lang/String;)V", "room-runtime_release"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    /* compiled from: RoomOpenHelper.kt */
    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z, String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\t¨\u0006\n"}, mo33737d2 = {"Landroidx/room/RoomOpenHelper$Companion;", "", "()V", "hasEmptySchema", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "hasEmptySchema$room_runtime_release", "hasRoomMasterTable", "hasRoomMasterTable$room_runtime_release", "room-runtime_release"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    /* compiled from: RoomOpenHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
            kotlin.p013io.CloseableKt.closeFinally(r6, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean hasRoomMasterTable$room_runtime_release(androidx.sqlite.p006db.SupportSQLiteDatabase r6) {
            /*
                r5 = this;
                java.lang.String r0 = "db"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
                android.database.Cursor r6 = r6.query((java.lang.String) r0)
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 1
                r2 = 0
                r3 = 15
                if (r0 <= r3) goto L_0x0032
                java.io.Closeable r6 = (java.io.Closeable) r6
                r0 = 0
                r3 = r6
                android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x002b }
                boolean r4 = r3.moveToFirst()     // Catch:{ all -> 0x002b }
                if (r4 == 0) goto L_0x0026
                int r3 = r3.getInt(r2)     // Catch:{ all -> 0x002b }
                if (r3 == 0) goto L_0x0026
                goto L_0x0027
            L_0x0026:
                r1 = 0
            L_0x0027:
                kotlin.p013io.CloseableKt.closeFinally(r6, r0)
                return r1
            L_0x002b:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x002d }
            L_0x002d:
                r1 = move-exception
                kotlin.p013io.CloseableKt.closeFinally(r6, r0)
                throw r1
            L_0x0032:
                boolean r0 = r6.moveToFirst()     // Catch:{ all -> 0x0044 }
                if (r0 == 0) goto L_0x003f
                int r0 = r6.getInt(r2)     // Catch:{ all -> 0x0044 }
                if (r0 == 0) goto L_0x003f
                goto L_0x0040
            L_0x003f:
                r1 = 0
            L_0x0040:
                r6.close()
                return r1
            L_0x0044:
                r0 = move-exception
                r6.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.Companion.hasRoomMasterTable$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
            kotlin.p013io.CloseableKt.closeFinally(r6, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            throw r1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean hasEmptySchema$room_runtime_release(androidx.sqlite.p006db.SupportSQLiteDatabase r6) {
            /*
                r5 = this;
                java.lang.String r0 = "db"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
                android.database.Cursor r6 = r6.query((java.lang.String) r0)
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 1
                r2 = 0
                r3 = 15
                if (r0 <= r3) goto L_0x0032
                java.io.Closeable r6 = (java.io.Closeable) r6
                r0 = 0
                r3 = r6
                android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x002b }
                boolean r4 = r3.moveToFirst()     // Catch:{ all -> 0x002b }
                if (r4 == 0) goto L_0x0026
                int r3 = r3.getInt(r2)     // Catch:{ all -> 0x002b }
                if (r3 != 0) goto L_0x0026
                goto L_0x0027
            L_0x0026:
                r1 = 0
            L_0x0027:
                kotlin.p013io.CloseableKt.closeFinally(r6, r0)
                return r1
            L_0x002b:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x002d }
            L_0x002d:
                r1 = move-exception
                kotlin.p013io.CloseableKt.closeFinally(r6, r0)
                throw r1
            L_0x0032:
                boolean r0 = r6.moveToFirst()     // Catch:{ all -> 0x0044 }
                if (r0 == 0) goto L_0x003f
                int r0 = r6.getInt(r2)     // Catch:{ all -> 0x0044 }
                if (r0 != 0) goto L_0x003f
                goto L_0x0040
            L_0x003f:
                r1 = 0
            L_0x0040:
                r6.close()
                return r1
            L_0x0044:
                r0 = move-exception
                r6.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomOpenHelper.Companion.hasEmptySchema$room_runtime_release(androidx.sqlite.db.SupportSQLiteDatabase):boolean");
        }
    }
}
