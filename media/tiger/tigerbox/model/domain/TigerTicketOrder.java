package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/TigerTicketOrder;", "", "code", "", "pin", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getPin", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerTicketPurchase.kt */
public final class TigerTicketOrder {
    private final String code;
    private final String pin;

    public static /* synthetic */ TigerTicketOrder copy$default(TigerTicketOrder tigerTicketOrder, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tigerTicketOrder.code;
        }
        if ((i & 2) != 0) {
            str2 = tigerTicketOrder.pin;
        }
        return tigerTicketOrder.copy(str, str2);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.pin;
    }

    public final TigerTicketOrder copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "pin");
        return new TigerTicketOrder(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TigerTicketOrder)) {
            return false;
        }
        TigerTicketOrder tigerTicketOrder = (TigerTicketOrder) obj;
        return Intrinsics.areEqual((Object) this.code, (Object) tigerTicketOrder.code) && Intrinsics.areEqual((Object) this.pin, (Object) tigerTicketOrder.pin);
    }

    public int hashCode() {
        return (this.code.hashCode() * 31) + this.pin.hashCode();
    }

    public String toString() {
        return "TigerTicketOrder(code=" + this.code + ", pin=" + this.pin + ')';
    }

    public TigerTicketOrder(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "pin");
        this.code = str;
        this.pin = str2;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getPin() {
        return this.pin;
    }
}
