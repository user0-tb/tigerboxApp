package media.tiger.tigerbox.model.domain;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/LatestRelease;", "", "versionName", "", "releaseDate", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;)V", "getReleaseDate", "()Ljava/util/Date;", "getVersionName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LatestRelease.kt */
public final class LatestRelease {
    private final Date releaseDate;
    private final String versionName;

    public static /* synthetic */ LatestRelease copy$default(LatestRelease latestRelease, String str, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = latestRelease.versionName;
        }
        if ((i & 2) != 0) {
            date = latestRelease.releaseDate;
        }
        return latestRelease.copy(str, date);
    }

    public final String component1() {
        return this.versionName;
    }

    public final Date component2() {
        return this.releaseDate;
    }

    public final LatestRelease copy(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "versionName");
        Intrinsics.checkNotNullParameter(date, "releaseDate");
        return new LatestRelease(str, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatestRelease)) {
            return false;
        }
        LatestRelease latestRelease = (LatestRelease) obj;
        return Intrinsics.areEqual((Object) this.versionName, (Object) latestRelease.versionName) && Intrinsics.areEqual((Object) this.releaseDate, (Object) latestRelease.releaseDate);
    }

    public int hashCode() {
        return (this.versionName.hashCode() * 31) + this.releaseDate.hashCode();
    }

    public String toString() {
        return "LatestRelease(versionName=" + this.versionName + ", releaseDate=" + this.releaseDate + ')';
    }

    public LatestRelease(String str, Date date) {
        Intrinsics.checkNotNullParameter(str, "versionName");
        Intrinsics.checkNotNullParameter(date, "releaseDate");
        this.versionName = str;
        this.releaseDate = date;
    }

    public final Date getReleaseDate() {
        return this.releaseDate;
    }

    public final String getVersionName() {
        return this.versionName;
    }
}
