package media.tiger.tigerbox.data.database;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.p006db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import media.tiger.tigerbox.model.domain.HlsKeyDomain;

public final class HlsKeysDao_Impl implements HlsKeysDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<HlsKeyDomain> __insertionAdapterOfHlsKeyDomain;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllKeys;

    public HlsKeysDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfHlsKeyDomain = new EntityInsertionAdapter<HlsKeyDomain>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `hlsKeys` (`key`,`url`,`id`) VALUES (?,?,nullif(?, 0))";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, HlsKeyDomain hlsKeyDomain) {
                if (hlsKeyDomain.getKey() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, hlsKeyDomain.getKey());
                }
                if (hlsKeyDomain.getUrl() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, hlsKeyDomain.getUrl());
                }
                supportSQLiteStatement.bindLong(3, (long) hlsKeyDomain.getId());
            }
        };
        this.__preparedStmtOfDeleteAllKeys = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM hlsKeys";
            }
        };
    }

    public void insertPlaybackPosition(HlsKeyDomain hlsKeyDomain) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfHlsKeyDomain.insert(hlsKeyDomain);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAllKeys() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllKeys.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllKeys.release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: media.tiger.tigerbox.model.domain.HlsKeyDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public media.tiger.tigerbox.model.domain.HlsKeyDomain getHlsKey(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "SELECT * FROM hlsKeys WHERE url=?"
            r1 = 1
            androidx.room.RoomSQLiteQuery r0 = androidx.room.RoomSQLiteQuery.acquire(r0, r1)
            if (r7 != 0) goto L_0x000d
            r0.bindNull(r1)
            goto L_0x0010
        L_0x000d:
            r0.bindString(r1, r7)
        L_0x0010:
            androidx.room.RoomDatabase r7 = r6.__db
            r7.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r7 = r6.__db
            r1 = 0
            r2 = 0
            android.database.Cursor r7 = androidx.room.util.DBUtil.query(r7, r0, r1, r2)
            java.lang.String r1 = "key"
            int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r7, r1)     // Catch:{ all -> 0x005d }
            java.lang.String r3 = "url"
            int r3 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r7, r3)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "id"
            int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r7, r4)     // Catch:{ all -> 0x005d }
            boolean r5 = r7.moveToFirst()     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x0056
            boolean r5 = r7.isNull(r1)     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x003d
            r1 = r2
            goto L_0x0041
        L_0x003d:
            java.lang.String r1 = r7.getString(r1)     // Catch:{ all -> 0x005d }
        L_0x0041:
            boolean r5 = r7.isNull(r3)     // Catch:{ all -> 0x005d }
            if (r5 == 0) goto L_0x0048
            goto L_0x004c
        L_0x0048:
            java.lang.String r2 = r7.getString(r3)     // Catch:{ all -> 0x005d }
        L_0x004c:
            int r3 = r7.getInt(r4)     // Catch:{ all -> 0x005d }
            media.tiger.tigerbox.model.domain.HlsKeyDomain r4 = new media.tiger.tigerbox.model.domain.HlsKeyDomain     // Catch:{ all -> 0x005d }
            r4.<init>(r1, r2, r3)     // Catch:{ all -> 0x005d }
            r2 = r4
        L_0x0056:
            r7.close()
            r0.release()
            return r2
        L_0x005d:
            r1 = move-exception
            r7.close()
            r0.release()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.database.HlsKeysDao_Impl.getHlsKey(java.lang.String):media.tiger.tigerbox.model.domain.HlsKeyDomain");
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
