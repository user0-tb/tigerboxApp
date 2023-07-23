package media.tiger.tigerbox.data.database;

import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.p006db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.model.domain.TigerBoxUserDomain;

public final class TigerBoxUserDao_Impl implements TigerBoxUserDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<TigerBoxUserDomain> __deletionAdapterOfTigerBoxUserDomain;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<TigerBoxUserDomain> __insertionAdapterOfTigerBoxUserDomain;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllUsers;
    private final SharedSQLiteStatement __preparedStmtOfUpdate;

    public TigerBoxUserDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfTigerBoxUserDomain = new EntityInsertionAdapter<TigerBoxUserDomain>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `tigerboxUser` (`profileId`,`accountId`,`activeProfileId`,`email`,`pin`) VALUES (?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TigerBoxUserDomain tigerBoxUserDomain) {
                supportSQLiteStatement.bindLong(1, (long) tigerBoxUserDomain.getProfileId());
                supportSQLiteStatement.bindLong(2, (long) tigerBoxUserDomain.getAccountId());
                supportSQLiteStatement.bindLong(3, (long) tigerBoxUserDomain.getActiveProfileId());
                if (tigerBoxUserDomain.getEmail() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, tigerBoxUserDomain.getEmail());
                }
                if (tigerBoxUserDomain.getPin() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, tigerBoxUserDomain.getPin());
                }
            }
        };
        this.__deletionAdapterOfTigerBoxUserDomain = new EntityDeletionOrUpdateAdapter<TigerBoxUserDomain>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `tigerboxUser` WHERE `profileId` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TigerBoxUserDomain tigerBoxUserDomain) {
                supportSQLiteStatement.bindLong(1, (long) tigerBoxUserDomain.getProfileId());
            }
        };
        this.__preparedStmtOfUpdate = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE tigerboxUser SET activeProfileId=? WHERE accountId=?";
            }
        };
        this.__preparedStmtOfDeleteAllUsers = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM tigerboxUser";
            }
        };
    }

    public Object insertUser(final TigerBoxUserDomain tigerBoxUserDomain, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                TigerBoxUserDao_Impl.this.__db.beginTransaction();
                try {
                    TigerBoxUserDao_Impl.this.__insertionAdapterOfTigerBoxUserDomain.insert(tigerBoxUserDomain);
                    TigerBoxUserDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    TigerBoxUserDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public void deleteTigerboxUser(TigerBoxUserDomain tigerBoxUserDomain) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfTigerBoxUserDomain.handle(tigerBoxUserDomain);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(int i, int i2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdate.acquire();
        acquire.bindLong(1, (long) i);
        acquire.bindLong(2, (long) i2);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdate.release(acquire);
        }
    }

    public void deleteAllUsers() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllUsers.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllUsers.release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: media.tiger.tigerbox.model.domain.TigerBoxUserDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: media.tiger.tigerbox.model.domain.TigerBoxUserDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: media.tiger.tigerbox.model.domain.TigerBoxUserDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: media.tiger.tigerbox.model.domain.TigerBoxUserDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: media.tiger.tigerbox.model.domain.TigerBoxUserDomain} */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public media.tiger.tigerbox.model.domain.TigerBoxUserDomain getUser() {
        /*
            r15 = this;
            java.lang.String r0 = "SELECT * FROM tigerboxUser"
            r1 = 0
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            androidx.room.RoomDatabase r2 = r15.__db
            r2.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r2 = r15.__db
            r3 = 0
            android.database.Cursor r1 = androidx.room.util.DBUtil.query(r2, r0, r1, r3)
            java.lang.String r2 = "profileId"
            int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x006a }
            java.lang.String r4 = "accountId"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x006a }
            java.lang.String r5 = "activeProfileId"
            int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x006a }
            java.lang.String r6 = "email"
            int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r6)     // Catch:{ all -> 0x006a }
            java.lang.String r7 = "pin"
            int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r7)     // Catch:{ all -> 0x006a }
            boolean r8 = r1.moveToFirst()     // Catch:{ all -> 0x006a }
            if (r8 == 0) goto L_0x0063
            int r10 = r1.getInt(r2)     // Catch:{ all -> 0x006a }
            int r11 = r1.getInt(r4)     // Catch:{ all -> 0x006a }
            int r12 = r1.getInt(r5)     // Catch:{ all -> 0x006a }
            boolean r2 = r1.isNull(r6)     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x004b
            r13 = r3
            goto L_0x0050
        L_0x004b:
            java.lang.String r2 = r1.getString(r6)     // Catch:{ all -> 0x006a }
            r13 = r2
        L_0x0050:
            boolean r2 = r1.isNull(r7)     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0058
        L_0x0056:
            r14 = r3
            goto L_0x005d
        L_0x0058:
            java.lang.String r3 = r1.getString(r7)     // Catch:{ all -> 0x006a }
            goto L_0x0056
        L_0x005d:
            media.tiger.tigerbox.model.domain.TigerBoxUserDomain r3 = new media.tiger.tigerbox.model.domain.TigerBoxUserDomain     // Catch:{ all -> 0x006a }
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x006a }
        L_0x0063:
            r1.close()
            r0.release()
            return r3
        L_0x006a:
            r2 = move-exception
            r1.close()
            r0.release()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.database.TigerBoxUserDao_Impl.getUser():media.tiger.tigerbox.model.domain.TigerBoxUserDomain");
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
