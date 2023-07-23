package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/TigerTicketFail;", "", "code", "", "errorCode", "message", "", "(IILjava/lang/String;)V", "getCode", "()I", "getErrorCode", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerTicketFail.kt */
public final class TigerTicketFail {
    private final int code;
    private final int errorCode;
    private final String message;

    public static /* synthetic */ TigerTicketFail copy$default(TigerTicketFail tigerTicketFail, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tigerTicketFail.code;
        }
        if ((i3 & 2) != 0) {
            i2 = tigerTicketFail.errorCode;
        }
        if ((i3 & 4) != 0) {
            str = tigerTicketFail.message;
        }
        return tigerTicketFail.copy(i, i2, str);
    }

    public final int component1() {
        return this.code;
    }

    public final int component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.message;
    }

    public final TigerTicketFail copy(int i, int i2, String str) {
        return new TigerTicketFail(i, i2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TigerTicketFail)) {
            return false;
        }
        TigerTicketFail tigerTicketFail = (TigerTicketFail) obj;
        return this.code == tigerTicketFail.code && this.errorCode == tigerTicketFail.errorCode && Intrinsics.areEqual((Object) this.message, (Object) tigerTicketFail.message);
    }

    public int hashCode() {
        int i = ((this.code * 31) + this.errorCode) * 31;
        String str = this.message;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TigerTicketFail(code=" + this.code + ", errorCode=" + this.errorCode + ", message=" + this.message + ')';
    }

    public TigerTicketFail(int i, int i2, String str) {
        this.code = i;
        this.errorCode = i2;
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }
}
