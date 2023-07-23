package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@Target(allowedTargets = {AnnotationTarget.CLASS})
@Repeatable(Entries.class)
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Target({ElementType.TYPE})
@Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0006"}, mo33737d2 = {"Landroidx/room/DeleteTable;", "", "tableName", "", "()Ljava/lang/String;", "Entries", "room-common"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
/* compiled from: DeleteTable.kt */
public @interface DeleteTable {

    @Target(allowedTargets = {AnnotationTarget.CLASS})
    @Retention(AnnotationRetention.BINARY)
    @java.lang.annotation.Target({ElementType.TYPE})
    @Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, mo33737d2 = {"Landroidx/room/DeleteTable$Entries;", "", "value", "", "Landroidx/room/DeleteTable;", "()[Landroidx/room/DeleteTable;", "room-common"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    @java.lang.annotation.Retention(RetentionPolicy.CLASS)
    /* compiled from: DeleteTable.kt */
    public @interface Entries {
        DeleteTable[] value();
    }

    String tableName();
}
