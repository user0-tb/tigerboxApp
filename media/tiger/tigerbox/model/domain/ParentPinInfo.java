package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/ParentPinInfo;", "", "pin", "", "isRandom", "", "(Ljava/lang/String;Z)V", "()Z", "getPin", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ParentPinInfo.kt */
public final class ParentPinInfo {
    private final boolean isRandom;
    private final String pin;

    public static /* synthetic */ ParentPinInfo copy$default(ParentPinInfo parentPinInfo, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parentPinInfo.pin;
        }
        if ((i & 2) != 0) {
            z = parentPinInfo.isRandom;
        }
        return parentPinInfo.copy(str, z);
    }

    public final String component1() {
        return this.pin;
    }

    public final boolean component2() {
        return this.isRandom;
    }

    public final ParentPinInfo copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "pin");
        return new ParentPinInfo(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParentPinInfo)) {
            return false;
        }
        ParentPinInfo parentPinInfo = (ParentPinInfo) obj;
        return Intrinsics.areEqual((Object) this.pin, (Object) parentPinInfo.pin) && this.isRandom == parentPinInfo.isRandom;
    }

    public int hashCode() {
        int hashCode = this.pin.hashCode() * 31;
        boolean z = this.isRandom;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "ParentPinInfo(pin=" + this.pin + ", isRandom=" + this.isRandom + ')';
    }

    public ParentPinInfo(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "pin");
        this.pin = str;
        this.isRandom = z;
    }

    public final String getPin() {
        return this.pin;
    }

    public final boolean isRandom() {
        return this.isRandom;
    }
}
