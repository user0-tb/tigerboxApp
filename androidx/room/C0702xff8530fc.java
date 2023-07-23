package androidx.room;

import androidx.sqlite.p006db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata(mo33738k = 3, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* renamed from: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1 */
/* compiled from: AutoClosingRoomOpenHelper.kt */
/* synthetic */ class C0702xff8530fc extends MutablePropertyReference1Impl {
    public static final C0702xff8530fc INSTANCE = new C0702xff8530fc();

    C0702xff8530fc() {
        super(SupportSQLiteDatabase.class, "version", "getVersion()I", 0);
    }

    public Object get(Object obj) {
        return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
    }

    public void set(Object obj, Object obj2) {
        ((SupportSQLiteDatabase) obj).setVersion(((Number) obj2).intValue());
    }
}
