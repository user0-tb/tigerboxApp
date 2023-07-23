package media.tiger.tigerbox.data.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.core.app.NotificationCompat;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
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
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;

public final class TigerBoxProfileDao_Impl implements TigerBoxProfileDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<TigerBoxProfileDomain> __deletionAdapterOfTigerBoxProfileDomain;
    /* access modifiers changed from: private */
    public final EntityInsertionAdapter<TigerBoxProfileDomain> __insertionAdapterOfTigerBoxProfileDomain;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllProfiles;

    public TigerBoxProfileDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfTigerBoxProfileDomain = new EntityInsertionAdapter<TigerBoxProfileDomain>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `tigerboxProfile` (`id`,`email`,`accountId`,`nickName`,`birthday`,`gender`,`avatarUrl`) VALUES (?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TigerBoxProfileDomain tigerBoxProfileDomain) {
                supportSQLiteStatement.bindLong(1, (long) tigerBoxProfileDomain.getId());
                if (tigerBoxProfileDomain.getEmail() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, tigerBoxProfileDomain.getEmail());
                }
                supportSQLiteStatement.bindLong(3, (long) tigerBoxProfileDomain.getAccountId());
                if (tigerBoxProfileDomain.getNickName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, tigerBoxProfileDomain.getNickName());
                }
                if (tigerBoxProfileDomain.getBirthday() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, tigerBoxProfileDomain.getBirthday());
                }
                if (tigerBoxProfileDomain.getGender() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, tigerBoxProfileDomain.getGender());
                }
                if (tigerBoxProfileDomain.getAvatarUrl() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, tigerBoxProfileDomain.getAvatarUrl());
                }
            }
        };
        this.__deletionAdapterOfTigerBoxProfileDomain = new EntityDeletionOrUpdateAdapter<TigerBoxProfileDomain>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `tigerboxProfile` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, TigerBoxProfileDomain tigerBoxProfileDomain) {
                supportSQLiteStatement.bindLong(1, (long) tigerBoxProfileDomain.getId());
            }
        };
        this.__preparedStmtOfDeleteAllProfiles = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM tigerboxProfile";
            }
        };
    }

    public Object insertProfile(final TigerBoxProfileDomain tigerBoxProfileDomain, Continuation<? super Unit> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() {
            public Unit call() throws Exception {
                TigerBoxProfileDao_Impl.this.__db.beginTransaction();
                try {
                    TigerBoxProfileDao_Impl.this.__insertionAdapterOfTigerBoxProfileDomain.insert(tigerBoxProfileDomain);
                    TigerBoxProfileDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    TigerBoxProfileDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    public void deleteTigerboxProfile(TigerBoxProfileDomain tigerBoxProfileDomain) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfTigerBoxProfileDomain.handle(tigerBoxProfileDomain);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void deleteAllProfiles() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAllProfiles.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllProfiles.release(acquire);
        }
    }

    public List<TigerBoxProfileDomain> getProfiles() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM tigerboxProfile", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, NotificationCompat.CATEGORY_EMAIL);
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "accountId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "nickName");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "birthday");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "gender");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "avatarUrl");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                int i = query.getInt(columnIndexOrThrow);
                if (query.isNull(columnIndexOrThrow2)) {
                    str = null;
                } else {
                    str = query.getString(columnIndexOrThrow2);
                }
                int i2 = query.getInt(columnIndexOrThrow3);
                if (query.isNull(columnIndexOrThrow4)) {
                    str2 = null;
                } else {
                    str2 = query.getString(columnIndexOrThrow4);
                }
                if (query.isNull(columnIndexOrThrow5)) {
                    str3 = null;
                } else {
                    str3 = query.getString(columnIndexOrThrow5);
                }
                if (query.isNull(columnIndexOrThrow6)) {
                    str4 = null;
                } else {
                    str4 = query.getString(columnIndexOrThrow6);
                }
                if (query.isNull(columnIndexOrThrow7)) {
                    str5 = null;
                } else {
                    str5 = query.getString(columnIndexOrThrow7);
                }
                arrayList.add(new TigerBoxProfileDomain(i, str, i2, str2, str3, str4, str5));
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
