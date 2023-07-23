package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/ReportInformation;", "", "id", "", "accountId", "activeProfileId", "(III)V", "getAccountId", "()I", "getActiveProfileId", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ReportInformation.kt */
public final class ReportInformation {
    private final int accountId;
    private final int activeProfileId;

    /* renamed from: id */
    private final int f631id;

    public static /* synthetic */ ReportInformation copy$default(ReportInformation reportInformation, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = reportInformation.f631id;
        }
        if ((i4 & 2) != 0) {
            i2 = reportInformation.accountId;
        }
        if ((i4 & 4) != 0) {
            i3 = reportInformation.activeProfileId;
        }
        return reportInformation.copy(i, i2, i3);
    }

    public final int component1() {
        return this.f631id;
    }

    public final int component2() {
        return this.accountId;
    }

    public final int component3() {
        return this.activeProfileId;
    }

    public final ReportInformation copy(int i, int i2, int i3) {
        return new ReportInformation(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportInformation)) {
            return false;
        }
        ReportInformation reportInformation = (ReportInformation) obj;
        return this.f631id == reportInformation.f631id && this.accountId == reportInformation.accountId && this.activeProfileId == reportInformation.activeProfileId;
    }

    public int hashCode() {
        return (((this.f631id * 31) + this.accountId) * 31) + this.activeProfileId;
    }

    public String toString() {
        return "ReportInformation(id=" + this.f631id + ", accountId=" + this.accountId + ", activeProfileId=" + this.activeProfileId + ')';
    }

    public ReportInformation(int i, int i2, int i3) {
        this.f631id = i;
        this.accountId = i2;
        this.activeProfileId = i3;
    }

    public final int getId() {
        return this.f631id;
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final int getActiveProfileId() {
        return this.activeProfileId;
    }
}
