package androidx.sqlite.p006db;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0006¢\u0006\u0002\b\u0007H\bø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, mo33737d2 = {"transaction", "T", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "exclusive", "", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sqlite-ktx_release"}, mo33738k = 2, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* renamed from: androidx.sqlite.db.SupportSQLiteDatabaseKt */
/* compiled from: SupportSQLiteDatabaseExt.kt */
public final class SupportSQLiteDatabaseKt {
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r0.endTransaction();
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object transaction$default(androidx.sqlite.p006db.SupportSQLiteDatabase r0, boolean r1, kotlin.jvm.functions.Function1 r2, int r3, java.lang.Object r4) {
        /*
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0005
            r1 = 1
        L_0x0005:
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r3 = "body"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            if (r1 == 0) goto L_0x0015
            r0.beginTransaction()
            goto L_0x0018
        L_0x0015:
            r0.beginTransactionNonExclusive()
        L_0x0018:
            java.lang.Object r1 = r2.invoke(r0)     // Catch:{ all -> 0x0029 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            r0.setTransactionSuccessful()
            r0.endTransaction()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            return r1
        L_0x0029:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002b }
        L_0x002b:
            r1 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
            r0.endTransaction()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.p006db.SupportSQLiteDatabaseKt.transaction$default(androidx.sqlite.db.SupportSQLiteDatabase, boolean, kotlin.jvm.functions.Function1, int, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        r1.endTransaction();
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T transaction(androidx.sqlite.p006db.SupportSQLiteDatabase r1, boolean r2, kotlin.jvm.functions.Function1<? super androidx.sqlite.p006db.SupportSQLiteDatabase, ? extends T> r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "body"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r2 == 0) goto L_0x0010
            r1.beginTransaction()
            goto L_0x0013
        L_0x0010:
            r1.beginTransactionNonExclusive()
        L_0x0013:
            r2 = 1
            java.lang.Object r3 = r3.invoke(r1)     // Catch:{ all -> 0x0025 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r1.setTransactionSuccessful()
            r1.endTransaction()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            return r3
        L_0x0025:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r3 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            r1.endTransaction()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.p006db.SupportSQLiteDatabaseKt.transaction(androidx.sqlite.db.SupportSQLiteDatabase, boolean, kotlin.jvm.functions.Function1):java.lang.Object");
    }
}
