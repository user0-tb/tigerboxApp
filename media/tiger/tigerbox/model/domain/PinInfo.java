package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\r¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/PinInfo;", "", "isSuccess", "", "code", "", "attempts", "errorCode", "(ZIII)V", "getAttempts", "()I", "getCode", "getErrorCode", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PinInfo.kt */
public final class PinInfo {
    private final int attempts;
    private final int code;
    private final int errorCode;
    private final boolean isSuccess;

    public static /* synthetic */ PinInfo copy$default(PinInfo pinInfo, boolean z, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = pinInfo.isSuccess;
        }
        if ((i4 & 2) != 0) {
            i = pinInfo.code;
        }
        if ((i4 & 4) != 0) {
            i2 = pinInfo.attempts;
        }
        if ((i4 & 8) != 0) {
            i3 = pinInfo.errorCode;
        }
        return pinInfo.copy(z, i, i2, i3);
    }

    public final boolean component1() {
        return this.isSuccess;
    }

    public final int component2() {
        return this.code;
    }

    public final int component3() {
        return this.attempts;
    }

    public final int component4() {
        return this.errorCode;
    }

    public final PinInfo copy(boolean z, int i, int i2, int i3) {
        return new PinInfo(z, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PinInfo)) {
            return false;
        }
        PinInfo pinInfo = (PinInfo) obj;
        return this.isSuccess == pinInfo.isSuccess && this.code == pinInfo.code && this.attempts == pinInfo.attempts && this.errorCode == pinInfo.errorCode;
    }

    public int hashCode() {
        boolean z = this.isSuccess;
        if (z) {
            z = true;
        }
        return ((((((z ? 1 : 0) * true) + this.code) * 31) + this.attempts) * 31) + this.errorCode;
    }

    public String toString() {
        return "PinInfo(isSuccess=" + this.isSuccess + ", code=" + this.code + ", attempts=" + this.attempts + ", errorCode=" + this.errorCode + ')';
    }

    public PinInfo(boolean z, int i, int i2, int i3) {
        this.isSuccess = z;
        this.code = i;
        this.attempts = i2;
        this.errorCode = i3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PinInfo(boolean z, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public final int getAttempts() {
        return this.attempts;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }
}
