package media.tiger.tigerbox.data.database;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.p006db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import media.tiger.tigerbox.model.domain.PlaybackPositionDomain;

public final class PlaybackPositionsDao_Impl implements PlaybackPositionsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PlaybackPositionDomain> __insertionAdapterOfPlaybackPositionDomain;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllPlaybackPositions;
    private final SharedSQLiteStatement __preparedStmtOfUpdatePlaybackPosition;

    public PlaybackPositionsDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPlaybackPositionDomain = new EntityInsertionAdapter<PlaybackPositionDomain>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `playbackPositions` (`userId`,`productId`,`trackNumber`,`trackPosition`,`modifiedDate`,`id`) VALUES (?,?,?,?,?,nullif(?, 0))";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlaybackPositionDomain playbackPositionDomain) {
                supportSQLiteStatement.bindLong(1, (long) playbackPositionDomain.getUserId());
                supportSQLiteStatement.bindLong(2, (long) playbackPositionDomain.getProductId());
                supportSQLiteStatement.bindLong(3, (long) playbackPositionDomain.getTrackNumber());
                supportSQLiteStatement.bindLong(4, playbackPositionDomain.getTrackPosition());
                if (playbackPositionDomain.getModifiedDate() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, playbackPositionDomain.getModifiedDate());
                }
                supportSQLiteStatement.bindLong(6, (long) playbackPositionDomain.getId());
            }
        };
        this.__preparedStmtOfUpdatePlaybackPosition = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE playbackPositions SET trackNumber=?, trackPosition=?, modifiedDate=? WHERE userId=? AND productId=?";
            }
        };
        this.__preparedStmtOfDeleteAllPlaybackPositions = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM playbackPositions";
            }
        };
    }

    public void insertPlaybackPosition(PlaybackPositionDomain playbackPositionDomain) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPlaybackPositionDomain.insert(playbackPositionDomain);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void updatePlaybackPosition(int i, int i2, int i3, long j, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdatePlaybackPosition.acquire();
        acquire.bindLong(1, (long) i3);
        acquire.bindLong(2, j);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        acquire.bindLong(4, (long) i);
        acquire.bindLong(5, (long) i2);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdatePlaybackPosition.release(acquire);
        }
    }

    public void deleteAllPlaybackPositions() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllPlaybackPositions.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllPlaybackPositions.release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: media.tiger.tigerbox.model.domain.PlaybackPositionDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: media.tiger.tigerbox.model.domain.PlaybackPositionDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: media.tiger.tigerbox.model.domain.PlaybackPositionDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: media.tiger.tigerbox.model.domain.PlaybackPositionDomain} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: media.tiger.tigerbox.model.domain.PlaybackPositionDomain} */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public media.tiger.tigerbox.model.domain.PlaybackPositionDomain getPlaybackPosition(int r20, int r21) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "SELECT * FROM playbackPositions WHERE userId=? AND productId=?"
            r2 = 2
            androidx.room.RoomSQLiteQuery r3 = androidx.room.RoomSQLiteQuery.acquire(r0, r2)
            r0 = r20
            long r4 = (long) r0
            r0 = 1
            r3.bindLong(r0, r4)
            r0 = r21
            long r4 = (long) r0
            r3.bindLong(r2, r4)
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r2 = 0
            r4 = 0
            android.database.Cursor r2 = androidx.room.util.DBUtil.query(r0, r3, r2, r4)
            java.lang.String r0 = "userId"
            int r0 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r0)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = "productId"
            int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r5)     // Catch:{ all -> 0x007c }
            java.lang.String r6 = "trackNumber"
            int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r6)     // Catch:{ all -> 0x007c }
            java.lang.String r7 = "trackPosition"
            int r7 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r7)     // Catch:{ all -> 0x007c }
            java.lang.String r8 = "modifiedDate"
            int r8 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r8)     // Catch:{ all -> 0x007c }
            java.lang.String r9 = "id"
            int r9 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r2, r9)     // Catch:{ all -> 0x007c }
            boolean r10 = r2.moveToFirst()     // Catch:{ all -> 0x007c }
            if (r10 == 0) goto L_0x0075
            int r12 = r2.getInt(r0)     // Catch:{ all -> 0x007c }
            int r13 = r2.getInt(r5)     // Catch:{ all -> 0x007c }
            int r14 = r2.getInt(r6)     // Catch:{ all -> 0x007c }
            long r15 = r2.getLong(r7)     // Catch:{ all -> 0x007c }
            boolean r0 = r2.isNull(r8)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0066
        L_0x0063:
            r17 = r4
            goto L_0x006b
        L_0x0066:
            java.lang.String r4 = r2.getString(r8)     // Catch:{ all -> 0x007c }
            goto L_0x0063
        L_0x006b:
            int r18 = r2.getInt(r9)     // Catch:{ all -> 0x007c }
            media.tiger.tigerbox.model.domain.PlaybackPositionDomain r4 = new media.tiger.tigerbox.model.domain.PlaybackPositionDomain     // Catch:{ all -> 0x007c }
            r11 = r4
            r11.<init>(r12, r13, r14, r15, r17, r18)     // Catch:{ all -> 0x007c }
        L_0x0075:
            r2.close()
            r3.release()
            return r4
        L_0x007c:
            r0 = move-exception
            r2.close()
            r3.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.database.PlaybackPositionsDao_Impl.getPlaybackPosition(int, int):media.tiger.tigerbox.model.domain.PlaybackPositionDomain");
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
