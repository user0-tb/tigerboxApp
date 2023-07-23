package media.tiger.tigerbox.model.dto;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/AgeRange;", "", "max", "", "min", "(II)V", "getMax", "()I", "getMin", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUser.kt */
public final class AgeRange {
    private final int max;
    private final int min;

    public static /* synthetic */ AgeRange copy$default(AgeRange ageRange, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = ageRange.max;
        }
        if ((i3 & 2) != 0) {
            i2 = ageRange.min;
        }
        return ageRange.copy(i, i2);
    }

    public final int component1() {
        return this.max;
    }

    public final int component2() {
        return this.min;
    }

    public final AgeRange copy(int i, int i2) {
        return new AgeRange(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgeRange)) {
            return false;
        }
        AgeRange ageRange = (AgeRange) obj;
        return this.max == ageRange.max && this.min == ageRange.min;
    }

    public int hashCode() {
        return (this.max * 31) + this.min;
    }

    public String toString() {
        return "AgeRange(max=" + this.max + ", min=" + this.min + ')';
    }

    public AgeRange(int i, int i2) {
        this.max = i;
        this.min = i2;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }
}
