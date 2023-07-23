package media.tiger.tigerbox.data.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.core.app.NotificationCompat;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.p006db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import media.tiger.tigerbox.model.domain.PlaybackTrackingDomain;

public final class PlaybackTrackingDao_Impl implements PlaybackTrackingDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PlaybackTrackingDomain> __insertionAdapterOfPlaybackTrackingDomain;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllPlaybackTracking;
    private final SharedSQLiteStatement __preparedStmtOfDeletePlaybackTrackingEvent;

    public PlaybackTrackingDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPlaybackTrackingDomain = new EntityInsertionAdapter<PlaybackTrackingDomain>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `playbackTracking` (`accountId`,`userId`,`productId`,`event`,`start`,`end`,`total`,`id`) VALUES (?,?,?,?,?,?,?,nullif(?, 0))";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PlaybackTrackingDomain playbackTrackingDomain) {
                supportSQLiteStatement.bindLong(1, (long) playbackTrackingDomain.getAccountId());
                supportSQLiteStatement.bindLong(2, (long) playbackTrackingDomain.getUserId());
                supportSQLiteStatement.bindLong(3, (long) playbackTrackingDomain.getProductId());
                if (playbackTrackingDomain.getEvent() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, playbackTrackingDomain.getEvent());
                }
                supportSQLiteStatement.bindLong(5, (long) playbackTrackingDomain.getStart());
                supportSQLiteStatement.bindLong(6, (long) playbackTrackingDomain.getEnd());
                supportSQLiteStatement.bindLong(7, (long) playbackTrackingDomain.getTotal());
                supportSQLiteStatement.bindLong(8, (long) playbackTrackingDomain.getId());
            }
        };
        this.__preparedStmtOfDeleteAllPlaybackTracking = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM playbackTracking";
            }
        };
        this.__preparedStmtOfDeletePlaybackTrackingEvent = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM playbackTracking WHERE accountId=? AND userId=? AND productId=? AND event=? AND start=? AND end=? AND total=?";
            }
        };
    }

    public void insertPlaybackTrackEvent(PlaybackTrackingDomain playbackTrackingDomain) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPlaybackTrackingDomain.insert(playbackTrackingDomain);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAllPlaybackTracking() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllPlaybackTracking.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllPlaybackTracking.release(acquire);
        }
    }

    public void deletePlaybackTrackingEvent(int i, int i2, int i3, String str, int i4, int i5, int i6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeletePlaybackTrackingEvent.acquire();
        acquire.bindLong(1, (long) i);
        acquire.bindLong(2, (long) i2);
        acquire.bindLong(3, (long) i3);
        if (str == null) {
            acquire.bindNull(4);
        } else {
            acquire.bindString(4, str);
        }
        acquire.bindLong(5, (long) i4);
        acquire.bindLong(6, (long) i5);
        acquire.bindLong(7, (long) i6);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeletePlaybackTrackingEvent.release(acquire);
        }
    }

    public List<PlaybackTrackingDomain> getAllPlaybackTracking() {
        String str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM playbackTracking", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "accountId");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "userId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "productId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, NotificationCompat.CATEGORY_EVENT);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.START);
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.END);
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "total");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                int i2 = query.getInt(columnIndexOrThrow2);
                int i3 = query.getInt(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow4);
                }
                arrayList.add(new PlaybackTrackingDomain(i, i2, i3, str, query.getInt(columnIndexOrThrow5), query.getInt(columnIndexOrThrow6), query.getInt(columnIndexOrThrow7), query.getInt(columnIndexOrThrow8)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
