package androidx.room.util;

import androidx.sqlite.p006db.SupportSQLiteDatabase;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo33737d2 = {"Landroidx/room/util/FtsTableInfo;", "", "name", "", "columns", "", "createSql", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V", "options", "(Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* compiled from: FtsTableInfo.kt */
public final class FtsTableInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    @JvmStatic
    public static final Set<String> parseOptions(String str) {
        return Companion.parseOptions(str);
    }

    @JvmStatic
    public static final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public FtsTableInfo(String str, Set<String> set, Set<String> set2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(set, "columns");
        Intrinsics.checkNotNullParameter(set2, "options");
        this.name = str;
        this.columns = set;
        this.options = set2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(String str, Set<String> set, String str2) {
        this(str, set, Companion.parseOptions(str2));
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(set, "columns");
        Intrinsics.checkNotNullParameter(str2, "createSql");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
        if (Intrinsics.areEqual((Object) this.name, (Object) ftsTableInfo.name) && Intrinsics.areEqual((Object) this.columns, (Object) ftsTableInfo.columns)) {
            return Intrinsics.areEqual((Object) this.options, (Object) ftsTableInfo.options);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Landroidx/room/util/FtsTableInfo$Companion;", "", "()V", "FTS_OPTIONS", "", "", "[Ljava/lang/String;", "parseOptions", "", "createStatement", "read", "Landroidx/room/util/FtsTableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readColumns", "readOptions", "room-runtime_release"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    /* compiled from: FtsTableInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
            Intrinsics.checkNotNullParameter(str, "tableName");
            return new FtsTableInfo(str, readColumns(supportSQLiteDatabase, str), readOptions(supportSQLiteDatabase, str));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
            kotlin.p013io.CloseableKt.closeFinally(r6, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.Set<java.lang.String> readColumns(androidx.sqlite.p006db.SupportSQLiteDatabase r6, java.lang.String r7) {
            /*
                r5 = this;
                java.util.Set r0 = kotlin.collections.SetsKt.createSetBuilder()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "PRAGMA table_info(`"
                r1.append(r2)
                r1.append(r7)
                java.lang.String r7 = "`)"
                r1.append(r7)
                java.lang.String r7 = r1.toString()
                android.database.Cursor r6 = r6.query((java.lang.String) r7)
                int r7 = android.os.Build.VERSION.SDK_INT
                java.lang.String r1 = "cursor.getString(nameIndex)"
                java.lang.String r2 = "name"
                r3 = 15
                if (r7 <= r3) goto L_0x0056
                java.io.Closeable r6 = (java.io.Closeable) r6
                r7 = 0
                r3 = r6
                android.database.Cursor r3 = (android.database.Cursor) r3     // Catch:{ all -> 0x004f }
                int r4 = r3.getColumnCount()     // Catch:{ all -> 0x004f }
                if (r4 <= 0) goto L_0x0049
                int r2 = r3.getColumnIndex(r2)     // Catch:{ all -> 0x004f }
            L_0x0038:
                boolean r4 = r3.moveToNext()     // Catch:{ all -> 0x004f }
                if (r4 == 0) goto L_0x0049
                java.lang.String r4 = r3.getString(r2)     // Catch:{ all -> 0x004f }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)     // Catch:{ all -> 0x004f }
                r0.add(r4)     // Catch:{ all -> 0x004f }
                goto L_0x0038
            L_0x0049:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004f }
                kotlin.p013io.CloseableKt.closeFinally(r6, r7)
                goto L_0x0076
            L_0x004f:
                r7 = move-exception
                throw r7     // Catch:{ all -> 0x0051 }
            L_0x0051:
                r0 = move-exception
                kotlin.p013io.CloseableKt.closeFinally(r6, r7)
                throw r0
            L_0x0056:
                int r7 = r6.getColumnCount()     // Catch:{ all -> 0x007b }
                if (r7 <= 0) goto L_0x0071
                int r7 = r6.getColumnIndex(r2)     // Catch:{ all -> 0x007b }
            L_0x0060:
                boolean r2 = r6.moveToNext()     // Catch:{ all -> 0x007b }
                if (r2 == 0) goto L_0x0071
                java.lang.String r2 = r6.getString(r7)     // Catch:{ all -> 0x007b }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)     // Catch:{ all -> 0x007b }
                r0.add(r2)     // Catch:{ all -> 0x007b }
                goto L_0x0060
            L_0x0071:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x007b }
                r6.close()
            L_0x0076:
                java.util.Set r6 = kotlin.collections.SetsKt.build(r0)
                return r6
            L_0x007b:
                r7 = move-exception
                r6.close()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.FtsTableInfo.Companion.readColumns(androidx.sqlite.db.SupportSQLiteDatabase, java.lang.String):java.util.Set");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
            kotlin.p013io.CloseableKt.closeFinally(r5, r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
            throw r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final java.util.Set<java.lang.String> readOptions(androidx.sqlite.p006db.SupportSQLiteDatabase r5, java.lang.String r6) {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "SELECT * FROM sqlite_master WHERE `name` = '"
                r0.append(r1)
                r0.append(r6)
                r6 = 39
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                android.database.Cursor r5 = r5.query((java.lang.String) r6)
                int r6 = android.os.Build.VERSION.SDK_INT
                java.lang.String r0 = ""
                java.lang.String r1 = "sql"
                r2 = 15
                if (r6 <= r2) goto L_0x0044
                java.io.Closeable r5 = (java.io.Closeable) r5
                r6 = 0
                r2 = r5
                android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x003d }
                boolean r3 = r2.moveToFirst()     // Catch:{ all -> 0x003d }
                if (r3 == 0) goto L_0x0039
                int r0 = r2.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x003d }
                java.lang.String r0 = r2.getString(r0)     // Catch:{ all -> 0x003d }
            L_0x0039:
                kotlin.p013io.CloseableKt.closeFinally(r5, r6)
                goto L_0x0055
            L_0x003d:
                r6 = move-exception
                throw r6     // Catch:{ all -> 0x003f }
            L_0x003f:
                r0 = move-exception
                kotlin.p013io.CloseableKt.closeFinally(r5, r6)
                throw r0
            L_0x0044:
                boolean r6 = r5.moveToFirst()     // Catch:{ all -> 0x005d }
                if (r6 == 0) goto L_0x0052
                int r6 = r5.getColumnIndexOrThrow(r1)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = r5.getString(r6)     // Catch:{ all -> 0x005d }
            L_0x0052:
                r5.close()
            L_0x0055:
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.util.Set r5 = r4.parseOptions(r0)
                return r5
            L_0x005d:
                r6 = move-exception
                r5.close()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.FtsTableInfo.Companion.readOptions(androidx.sqlite.db.SupportSQLiteDatabase, java.lang.String):java.util.Set");
        }

        @JvmStatic
        public final Set<String> parseOptions(String str) {
            boolean z;
            Character ch;
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "createStatement");
            CharSequence charSequence = str2;
            if (charSequence.length() == 0) {
                return SetsKt.emptySet();
            }
            String substring = str2.substring(StringsKt.indexOf$default(charSequence, '(', 0, false, 6, (Object) null) + 1, StringsKt.lastIndexOf$default(charSequence, ')', 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            List arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            CharSequence charSequence2 = substring;
            int i = -1;
            int i2 = 0;
            int i3 = 0;
            while (i2 < charSequence2.length()) {
                char charAt = charSequence2.charAt(i2);
                int i4 = i3 + 1;
                if ((charAt == '\'' || charAt == '\"') || charAt == '`') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(charAt));
                    } else {
                        Character ch2 = (Character) arrayDeque.peek();
                        if (ch2 != null && ch2.charValue() == charAt) {
                            arrayDeque.pop();
                        }
                    }
                } else if (charAt == '[') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(charAt));
                    }
                } else if (charAt == ']') {
                    if (!arrayDeque.isEmpty() && (ch = (Character) arrayDeque.peek()) != null && ch.charValue() == '[') {
                        arrayDeque.pop();
                    }
                } else if (charAt == ',' && arrayDeque.isEmpty()) {
                    String substring2 = substring.substring(i + 1, i3);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    CharSequence charSequence3 = substring2;
                    int length = charSequence3.length() - 1;
                    int i5 = 0;
                    boolean z2 = false;
                    while (i5 <= length) {
                        boolean z3 = Intrinsics.compare((int) charSequence3.charAt(!z2 ? i5 : length), 32) <= 0;
                        if (!z2) {
                            if (!z3) {
                                z2 = true;
                            } else {
                                i5++;
                            }
                        } else if (!z3) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    arrayList.add(charSequence3.subSequence(i5, length + 1).toString());
                    i = i3;
                }
                i2++;
                i3 = i4;
            }
            String substring3 = substring.substring(i + 1);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            arrayList.add(StringsKt.trim((CharSequence) substring3).toString());
            Collection arrayList2 = new ArrayList();
            for (Object next : arrayList) {
                String str3 = (String) next;
                String[] access$getFTS_OPTIONS$cp = FtsTableInfo.FTS_OPTIONS;
                int length2 = access$getFTS_OPTIONS$cp.length;
                int i6 = 0;
                while (true) {
                    if (i6 >= length2) {
                        z = false;
                        break;
                    } else if (StringsKt.startsWith$default(str3, access$getFTS_OPTIONS$cp[i6], false, 2, (Object) null)) {
                        z = true;
                        break;
                    } else {
                        i6++;
                    }
                }
                if (z) {
                    arrayList2.add(next);
                }
            }
            return CollectionsKt.toSet((List) arrayList2);
        }
    }
}
