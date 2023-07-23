package media.tiger.tigerbox.data.database;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.p006db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;

public final class AccessTokenDao_Impl implements AccessTokenDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AccessTokenDomain> __deletionAdapterOfAccessTokenDomain;
    private final EntityInsertionAdapter<AccessTokenDomain> __insertionAdapterOfAccessTokenDomain;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllAccessToken;

    public AccessTokenDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfAccessTokenDomain = new EntityInsertionAdapter<AccessTokenDomain>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `accessToken` (`access_token`,`refresh_token`,`id`) VALUES (?,?,nullif(?, 0))";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, AccessTokenDomain accessTokenDomain) {
                if (accessTokenDomain.getAccessToken() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, accessTokenDomain.getAccessToken());
                }
                if (accessTokenDomain.getRefreshToken() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, accessTokenDomain.getRefreshToken());
                }
                supportSQLiteStatement.bindLong(3, (long) accessTokenDomain.getId());
            }
        };
        this.__deletionAdapterOfAccessTokenDomain = new EntityDeletionOrUpdateAdapter<AccessTokenDomain>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `accessToken` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, AccessTokenDomain accessTokenDomain) {
                supportSQLiteStatement.bindLong(1, (long) accessTokenDomain.getId());
            }
        };
        this.__preparedStmtOfDeleteAllAccessToken = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM accessToken";
            }
        };
    }

    public void insertAccessToken(AccessTokenDomain accessTokenDomain) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAccessTokenDomain.insert(accessTokenDomain);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAccessToken(AccessTokenDomain accessTokenDomain) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfAccessTokenDomain.handle(accessTokenDomain);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAllAccessToken() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllAccessToken.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllAccessToken.release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: media.tiger.tigerbox.model.domain.AccessTokenDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public media.tiger.tigerbox.model.domain.AccessTokenDomain getAccessToken() {
        /*
            r7 = this;
            java.lang.String r0 = "SELECT * FROM accessToken"
            r1 = 0
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            androidx.room.RoomDatabase r2 = r7.__db
            r2.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r2 = r7.__db
            r3 = 0
            android.database.Cursor r1 = androidx.room.util.DBUtil.query(r2, r0, r1, r3)
            java.lang.String r2 = "access_token"
            int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r2)     // Catch:{ all -> 0x0053 }
            java.lang.String r4 = "refresh_token"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r4)     // Catch:{ all -> 0x0053 }
            java.lang.String r5 = "id"
            int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r1, r5)     // Catch:{ all -> 0x0053 }
            boolean r6 = r1.moveToFirst()     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x004c
            boolean r6 = r1.isNull(r2)     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x0033
            r2 = r3
            goto L_0x0037
        L_0x0033:
            java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x0053 }
        L_0x0037:
            boolean r6 = r1.isNull(r4)     // Catch:{ all -> 0x0053 }
            if (r6 == 0) goto L_0x003e
            goto L_0x0042
        L_0x003e:
            java.lang.String r3 = r1.getString(r4)     // Catch:{ all -> 0x0053 }
        L_0x0042:
            int r4 = r1.getInt(r5)     // Catch:{ all -> 0x0053 }
            media.tiger.tigerbox.model.domain.AccessTokenDomain r5 = new media.tiger.tigerbox.model.domain.AccessTokenDomain     // Catch:{ all -> 0x0053 }
            r5.<init>(r2, r3, r4)     // Catch:{ all -> 0x0053 }
            r3 = r5
        L_0x004c:
            r1.close()
            r0.release()
            return r3
        L_0x0053:
            r2 = move-exception
            r1.close()
            r0.release()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.database.AccessTokenDao_Impl.getAccessToken():media.tiger.tigerbox.model.domain.AccessTokenDomain");
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
