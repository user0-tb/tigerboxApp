package androidx.room;

import androidx.sqlite.p006db.SupportSQLiteDatabase;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "invoke"}, mo33738k = 3, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* renamed from: androidx.room.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1 */
/* compiled from: AutoClosingRoomOpenHelper.kt */
final class C0698xf1df5ec0 extends Lambda implements Function1<SupportSQLiteDatabase, Object> {
    final /* synthetic */ Locale $locale;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0698xf1df5ec0(Locale locale) {
        super(1);
        this.$locale = locale;
    }

    public final Object invoke(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "db");
        supportSQLiteDatabase.setLocale(this.$locale);
        return null;
    }
}
