package net.sqlcipher.database;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteMisuseException;
import android.os.SystemClock;
import android.util.Log;
import net.sqlcipher.CursorWindow;

public class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "Cursor";
    private String[] mBindArgs;
    private Object[] mObjectBindArgs;
    private int mOffsetIndex;

    private final native int native_column_count();

    private final native String native_column_name(int i);

    private final native int native_fill_window(CursorWindow cursorWindow, int i, int i2, int i3, int i4, int i5);

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i, String[] strArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i;
        this.mBindArgs = strArr;
    }

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, int i, Object[] objArr) {
        super(sQLiteDatabase, str);
        this.mOffsetIndex = i;
        this.mObjectBindArgs = objArr;
        this.mBindArgs = new String[(objArr != null ? objArr.length : 0)];
    }

    /* access modifiers changed from: package-private */
    public int fillWindow(CursorWindow cursorWindow, int i, int i2) {
        int i3;
        SystemClock.uptimeMillis();
        this.mDatabase.lock();
        try {
            acquireReference();
            cursorWindow.acquireReference();
            i3 = native_fill_window(cursorWindow, cursorWindow.getStartPosition(), cursorWindow.getRequiredPosition(), this.mOffsetIndex, i, i2);
            if (SQLiteDebug.DEBUG_SQL_STATEMENTS) {
                Log.d(TAG, "fillWindow(): " + this.mSql);
            }
        } catch (IllegalStateException unused) {
            i3 = 0;
        } catch (SQLiteDatabaseCorruptException e) {
            this.mDatabase.onCorruption();
            throw e;
        } catch (Throwable th) {
            releaseReference();
            this.mDatabase.unlock();
            throw th;
        }
        cursorWindow.releaseReference();
        releaseReference();
        this.mDatabase.unlock();
        return i3;
    }

    /* access modifiers changed from: package-private */
    public int columnCountLocked() {
        acquireReference();
        try {
            return native_column_count();
        } finally {
            releaseReference();
        }
    }

    /* access modifiers changed from: package-private */
    public String columnNameLocked(int i) {
        acquireReference();
        try {
            return native_column_name(i);
        } finally {
            releaseReference();
        }
    }

    public String toString() {
        return "SQLiteQuery: " + this.mSql;
    }

    /* access modifiers changed from: package-private */
    public void requery() {
        String[] strArr = this.mBindArgs;
        if (strArr != null) {
            int length = strArr.length;
            try {
                Object[] objArr = this.mObjectBindArgs;
                if (objArr != null) {
                    bindArguments(objArr);
                    return;
                }
                int i = 0;
                while (i < length) {
                    int i2 = i + 1;
                    super.bindString(i2, this.mBindArgs[i]);
                    i = i2;
                }
            } catch (SQLiteMisuseException e) {
                StringBuilder sb = new StringBuilder("mSql " + this.mSql);
                for (int i3 = 0; i3 < length; i3++) {
                    sb.append(" ");
                    sb.append(this.mBindArgs[i3]);
                }
                sb.append(" ");
                throw new IllegalStateException(sb.toString(), e);
            }
        }
    }

    public void bindNull(int i) {
        this.mBindArgs[i - 1] = null;
        if (!this.mClosed) {
            super.bindNull(i);
        }
    }

    public void bindLong(int i, long j) {
        this.mBindArgs[i - 1] = Long.toString(j);
        if (!this.mClosed) {
            super.bindLong(i, j);
        }
    }

    public void bindDouble(int i, double d) {
        this.mBindArgs[i - 1] = Double.toString(d);
        if (!this.mClosed) {
            super.bindDouble(i, d);
        }
    }

    public void bindString(int i, String str) {
        this.mBindArgs[i - 1] = str;
        if (!this.mClosed) {
            super.bindString(i, str);
        }
    }

    public void bindArguments(Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (int i = 0; i < objArr.length; i++) {
                Double d = objArr[i];
                if (d == null) {
                    bindNull(i + 1);
                } else if (d instanceof Double) {
                    bindDouble(i + 1, d.doubleValue());
                } else if (d instanceof Float) {
                    bindDouble(i + 1, Double.valueOf((double) d.floatValue()).doubleValue());
                } else if (d instanceof Long) {
                    bindLong(i + 1, ((Long) d).longValue());
                } else if (d instanceof Integer) {
                    bindLong(i + 1, Long.valueOf((long) d.intValue()).longValue());
                } else if (d instanceof Boolean) {
                    bindLong(i + 1, ((Boolean) d).booleanValue() ? 1 : 0);
                } else if (d instanceof byte[]) {
                    bindBlob(i + 1, (byte[]) d);
                } else {
                    bindString(i + 1, d.toString());
                }
            }
        }
    }
}
