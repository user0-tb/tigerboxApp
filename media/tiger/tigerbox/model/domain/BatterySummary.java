package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\n¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/BatterySummary;", "", "batteryPercent", "", "isCharging", "", "isPlugged", "(FZZ)V", "getBatteryPercent", "()F", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: BatterySummary.kt */
public final class BatterySummary {
    private final float batteryPercent;
    private final boolean isCharging;
    private final boolean isPlugged;

    public static /* synthetic */ BatterySummary copy$default(BatterySummary batterySummary, float f, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = batterySummary.batteryPercent;
        }
        if ((i & 2) != 0) {
            z = batterySummary.isCharging;
        }
        if ((i & 4) != 0) {
            z2 = batterySummary.isPlugged;
        }
        return batterySummary.copy(f, z, z2);
    }

    public final float component1() {
        return this.batteryPercent;
    }

    public final boolean component2() {
        return this.isCharging;
    }

    public final boolean component3() {
        return this.isPlugged;
    }

    public final BatterySummary copy(float f, boolean z, boolean z2) {
        return new BatterySummary(f, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BatterySummary)) {
            return false;
        }
        BatterySummary batterySummary = (BatterySummary) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(this.batteryPercent), (Object) Float.valueOf(batterySummary.batteryPercent)) && this.isCharging == batterySummary.isCharging && this.isPlugged == batterySummary.isPlugged;
    }

    public int hashCode() {
        int floatToIntBits = Float.floatToIntBits(this.batteryPercent) * 31;
        boolean z = this.isCharging;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (floatToIntBits + (z ? 1 : 0)) * 31;
        boolean z3 = this.isPlugged;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "BatterySummary(batteryPercent=" + this.batteryPercent + ", isCharging=" + this.isCharging + ", isPlugged=" + this.isPlugged + ')';
    }

    public BatterySummary(float f, boolean z, boolean z2) {
        this.batteryPercent = f;
        this.isCharging = z;
        this.isPlugged = z2;
    }

    public final float getBatteryPercent() {
        return this.batteryPercent;
    }

    public final boolean isCharging() {
        return this.isCharging;
    }

    public final boolean isPlugged() {
        return this.isPlugged;
    }
}
