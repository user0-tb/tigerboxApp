package androidx.room;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@Target(allowedTargets = {})
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Target({})
@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB8\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\tR\u000f\u0010\u0007\u001a\u00020\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\nR\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000bR\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\fR\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\r¨\u0006\u000f"}, mo33737d2 = {"Landroidx/room/Index;", "", "value", "", "", "orders", "Landroidx/room/Index$Order;", "name", "unique", "", "()Ljava/lang/String;", "()[Landroidx/room/Index$Order;", "()Z", "()[Ljava/lang/String;", "Order", "room-common"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
/* compiled from: Index.kt */
public @interface Index {

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo33737d2 = {"Landroidx/room/Index$Order;", "", "(Ljava/lang/String;I)V", "ASC", "DESC", "room-common"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    /* compiled from: Index.kt */
    public enum Order {
        ASC,
        DESC
    }

    String name() default "";

    Order[] orders() default {};

    boolean unique() default false;

    String[] value();
}
