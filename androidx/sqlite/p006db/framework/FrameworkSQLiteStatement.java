package androidx.sqlite.p006db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.p006db.SupportSQLiteStatement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo33737d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteStatement;", "Landroidx/sqlite/db/framework/FrameworkSQLiteProgram;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "delegate", "Landroid/database/sqlite/SQLiteStatement;", "(Landroid/database/sqlite/SQLiteStatement;)V", "execute", "", "executeInsert", "", "executeUpdateDelete", "", "simpleQueryForLong", "simpleQueryForString", "", "sqlite-framework_release"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* renamed from: androidx.sqlite.db.framework.FrameworkSQLiteStatement */
/* compiled from: FrameworkSQLiteStatement.kt */
public final class FrameworkSQLiteStatement extends FrameworkSQLiteProgram implements SupportSQLiteStatement {
    private final SQLiteStatement delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteStatement(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        Intrinsics.checkNotNullParameter(sQLiteStatement, "delegate");
        this.delegate = sQLiteStatement;
    }

    public void execute() {
        this.delegate.execute();
    }

    public int executeUpdateDelete() {
        return this.delegate.executeUpdateDelete();
    }

    public long executeInsert() {
        return this.delegate.executeInsert();
    }

    public long simpleQueryForLong() {
        return this.delegate.simpleQueryForLong();
    }

    public String simpleQueryForString() {
        return this.delegate.simpleQueryForString();
    }
}
