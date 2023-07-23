package net.sqlcipher.database;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.io.File;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.database.SQLiteDatabase;

public abstract class SQLiteOpenHelper {
    private static final String TAG = "SQLiteOpenHelper";
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mDeferSetWriteAheadLoggingEnabled;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onCreate(SQLiteDatabase sQLiteDatabase);

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
    }

    public abstract void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(context, str, cursorFactory, i, (SQLiteDatabaseHook) null, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook) {
        this(context, str, cursorFactory, i, sQLiteDatabaseHook, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, SQLiteDatabaseHook sQLiteDatabaseHook, DatabaseErrorHandler databaseErrorHandler) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (i < 1) {
            throw new IllegalArgumentException("Version must be >= 1, was " + i);
        } else if (databaseErrorHandler != null) {
            this.mContext = context;
            this.mName = str;
            this.mFactory = cursorFactory;
            this.mNewVersion = i;
            this.mHook = sQLiteDatabaseHook;
            this.mErrorHandler = databaseErrorHandler;
        } else {
            throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
        }
    }

    public synchronized SQLiteDatabase getWritableDatabase(String str) {
        return getWritableDatabase(str == null ? null : str.toCharArray());
    }

    public synchronized SQLiteDatabase getWritableDatabase(char[] cArr) {
        return getWritableDatabase(cArr == null ? null : SQLiteDatabase.getBytes(cArr));
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00a0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized net.sqlcipher.database.SQLiteDatabase getWritableDatabase(byte[] r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x0017
            boolean r0 = r0.isOpen()     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x0017
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00c1 }
            boolean r0 = r0.isReadOnly()     // Catch:{ all -> 0x00c1 }
            if (r0 != 0) goto L_0x0017
            net.sqlcipher.database.SQLiteDatabase r7 = r6.mDatabase     // Catch:{ all -> 0x00c1 }
            monitor-exit(r6)
            return r7
        L_0x0017:
            boolean r0 = r6.mIsInitializing     // Catch:{ all -> 0x00c1 }
            if (r0 != 0) goto L_0x00b9
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x0022
            r0.lock()     // Catch:{ all -> 0x00c1 }
        L_0x0022:
            r0 = 1
            r1 = 0
            r2 = 0
            r6.mIsInitializing = r0     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r6.mName     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x0033
            java.lang.String r7 = ""
            net.sqlcipher.database.SQLiteDatabase r7 = net.sqlcipher.database.SQLiteDatabase.create((net.sqlcipher.database.SQLiteDatabase.CursorFactory) r2, (java.lang.String) r7)     // Catch:{ all -> 0x00a9 }
        L_0x0031:
            r2 = r7
            goto L_0x005a
        L_0x0033:
            android.content.Context r3 = r6.mContext     // Catch:{ all -> 0x00a9 }
            java.io.File r0 = r3.getDatabasePath(r0)     // Catch:{ all -> 0x00a9 }
            java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x00a9 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x00a9 }
            r3.<init>(r0)     // Catch:{ all -> 0x00a9 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x00a9 }
            if (r4 != 0) goto L_0x004f
            java.io.File r3 = r3.getParentFile()     // Catch:{ all -> 0x00a9 }
            r3.mkdirs()     // Catch:{ all -> 0x00a9 }
        L_0x004f:
            net.sqlcipher.database.SQLiteDatabase$CursorFactory r3 = r6.mFactory     // Catch:{ all -> 0x00a9 }
            net.sqlcipher.database.SQLiteDatabaseHook r4 = r6.mHook     // Catch:{ all -> 0x00a9 }
            net.sqlcipher.DatabaseErrorHandler r5 = r6.mErrorHandler     // Catch:{ all -> 0x00a9 }
            net.sqlcipher.database.SQLiteDatabase r7 = net.sqlcipher.database.SQLiteDatabase.openOrCreateDatabase((java.lang.String) r0, (byte[]) r7, (net.sqlcipher.database.SQLiteDatabase.CursorFactory) r3, (net.sqlcipher.database.SQLiteDatabaseHook) r4, (net.sqlcipher.DatabaseErrorHandler) r5)     // Catch:{ all -> 0x00a9 }
            goto L_0x0031
        L_0x005a:
            boolean r7 = r6.mDeferSetWriteAheadLoggingEnabled     // Catch:{ all -> 0x00a9 }
            if (r7 == 0) goto L_0x0064
            boolean r7 = r2.enableWriteAheadLogging()     // Catch:{ all -> 0x00a9 }
            r6.mEnableWriteAheadLogging = r7     // Catch:{ all -> 0x00a9 }
        L_0x0064:
            r6.onConfigure(r2)     // Catch:{ all -> 0x00a9 }
            int r7 = r2.getVersion()     // Catch:{ all -> 0x00a9 }
            int r0 = r6.mNewVersion     // Catch:{ all -> 0x00a9 }
            if (r7 == r0) goto L_0x0094
            r2.beginTransaction()     // Catch:{ all -> 0x00a9 }
            if (r7 != 0) goto L_0x0078
            r6.onCreate(r2)     // Catch:{ all -> 0x008f }
            goto L_0x0083
        L_0x0078:
            int r0 = r6.mNewVersion     // Catch:{ all -> 0x008f }
            if (r7 <= r0) goto L_0x0080
            r6.onDowngrade(r2, r7, r0)     // Catch:{ all -> 0x008f }
            goto L_0x0083
        L_0x0080:
            r6.onUpgrade(r2, r7, r0)     // Catch:{ all -> 0x008f }
        L_0x0083:
            int r7 = r6.mNewVersion     // Catch:{ all -> 0x008f }
            r2.setVersion(r7)     // Catch:{ all -> 0x008f }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x008f }
            r2.endTransaction()     // Catch:{ all -> 0x00a9 }
            goto L_0x0094
        L_0x008f:
            r7 = move-exception
            r2.endTransaction()     // Catch:{ all -> 0x00a9 }
            throw r7     // Catch:{ all -> 0x00a9 }
        L_0x0094:
            r6.onOpen(r2)     // Catch:{ all -> 0x00a9 }
            r6.mIsInitializing = r1     // Catch:{ all -> 0x00c1 }
            net.sqlcipher.database.SQLiteDatabase r7 = r6.mDatabase     // Catch:{ all -> 0x00c1 }
            if (r7 == 0) goto L_0x00a5
            r7.close()     // Catch:{ Exception -> 0x00a0 }
        L_0x00a0:
            net.sqlcipher.database.SQLiteDatabase r7 = r6.mDatabase     // Catch:{ all -> 0x00c1 }
            r7.unlock()     // Catch:{ all -> 0x00c1 }
        L_0x00a5:
            r6.mDatabase = r2     // Catch:{ all -> 0x00c1 }
            monitor-exit(r6)
            return r2
        L_0x00a9:
            r7 = move-exception
            r6.mIsInitializing = r1     // Catch:{ all -> 0x00c1 }
            net.sqlcipher.database.SQLiteDatabase r0 = r6.mDatabase     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x00b3
            r0.unlock()     // Catch:{ all -> 0x00c1 }
        L_0x00b3:
            if (r2 == 0) goto L_0x00b8
            r2.close()     // Catch:{ all -> 0x00c1 }
        L_0x00b8:
            throw r7     // Catch:{ all -> 0x00c1 }
        L_0x00b9:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c1 }
            java.lang.String r0 = "getWritableDatabase called recursively"
            r7.<init>(r0)     // Catch:{ all -> 0x00c1 }
            throw r7     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sqlcipher.database.SQLiteOpenHelper.getWritableDatabase(byte[]):net.sqlcipher.database.SQLiteDatabase");
    }

    public synchronized SQLiteDatabase getReadableDatabase(String str) {
        return getReadableDatabase(str == null ? null : str.toCharArray());
    }

    public synchronized SQLiteDatabase getReadableDatabase(char[] cArr) {
        return getReadableDatabase(cArr == null ? null : SQLiteDatabase.getBytes(cArr));
    }

    public synchronized SQLiteDatabase getReadableDatabase(byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = this.mDatabase;
        if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
            return this.mDatabase;
        } else if (!this.mIsInitializing) {
            try {
                return getWritableDatabase(bArr);
            } catch (SQLiteException e) {
                if (this.mName != null) {
                    String str = TAG;
                    Log.e(str, "Couldn't open " + this.mName + " for writing (will try read-only):", e);
                    sQLiteDatabase = null;
                    this.mIsInitializing = true;
                    String path = this.mContext.getDatabasePath(this.mName).getPath();
                    File file = new File(path);
                    File file2 = new File(this.mContext.getDatabasePath(this.mName).getParent());
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.exists()) {
                        this.mIsInitializing = false;
                        SQLiteDatabase writableDatabase = getWritableDatabase(bArr);
                        this.mIsInitializing = true;
                        writableDatabase.close();
                    }
                    sQLiteDatabase = SQLiteDatabase.openDatabase(path, bArr, this.mFactory, 1, this.mHook, this.mErrorHandler);
                    if (sQLiteDatabase.getVersion() == this.mNewVersion) {
                        onOpen(sQLiteDatabase);
                        Log.w(str, "Opened " + this.mName + " in read-only mode");
                        this.mDatabase = sQLiteDatabase;
                        this.mIsInitializing = false;
                        return sQLiteDatabase;
                    }
                    throw new SQLiteException("Can't upgrade read-only database from version " + sQLiteDatabase.getVersion() + " to " + this.mNewVersion + ": " + path);
                }
                throw e;
            } catch (Throwable th) {
                this.mIsInitializing = false;
                if (!(sQLiteDatabase == null || sQLiteDatabase == this.mDatabase)) {
                    sQLiteDatabase.close();
                }
                throw th;
            }
        } else {
            throw new IllegalStateException("getReadableDatabase called recursively");
        }
    }

    public synchronized void close() {
        if (!this.mIsInitializing) {
            SQLiteDatabase sQLiteDatabase = this.mDatabase;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDatabase.close();
                this.mDatabase = null;
            }
        } else {
            throw new IllegalStateException("Closed during initialization");
        }
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this) {
            if (this.mEnableWriteAheadLogging != z) {
                SQLiteDatabase sQLiteDatabase = this.mDatabase;
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || this.mDatabase.isReadOnly()) {
                    this.mDeferSetWriteAheadLoggingEnabled = z;
                } else {
                    if (z) {
                        this.mDatabase.enableWriteAheadLogging();
                    } else {
                        this.mDatabase.disableWriteAheadLogging();
                    }
                    this.mEnableWriteAheadLogging = z;
                }
            }
        }
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
    }
}
