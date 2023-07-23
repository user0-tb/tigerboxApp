package media.tiger.tigerbox.model.dto;

import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ReleaseInformation;", "", "signature", "", "releases", "", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "(Ljava/lang/String;Ljava/util/List;)V", "getReleases", "()Ljava/util/List;", "getSignature", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Release", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ReleaseInformation.kt */
public final class ReleaseInformation {
    private final List<Release> releases;
    private final String signature;

    public static /* synthetic */ ReleaseInformation copy$default(ReleaseInformation releaseInformation, String str, List<Release> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = releaseInformation.signature;
        }
        if ((i & 2) != 0) {
            list = releaseInformation.releases;
        }
        return releaseInformation.copy(str, list);
    }

    public final String component1() {
        return this.signature;
    }

    public final List<Release> component2() {
        return this.releases;
    }

    public final ReleaseInformation copy(String str, List<Release> list) {
        Intrinsics.checkNotNullParameter(str, "signature");
        Intrinsics.checkNotNullParameter(list, "releases");
        return new ReleaseInformation(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReleaseInformation)) {
            return false;
        }
        ReleaseInformation releaseInformation = (ReleaseInformation) obj;
        return Intrinsics.areEqual((Object) this.signature, (Object) releaseInformation.signature) && Intrinsics.areEqual((Object) this.releases, (Object) releaseInformation.releases);
    }

    public int hashCode() {
        return (this.signature.hashCode() * 31) + this.releases.hashCode();
    }

    public String toString() {
        return "ReleaseInformation(signature=" + this.signature + ", releases=" + this.releases + ')';
    }

    @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0012Jj\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006,"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "", "version", "", "type", "released", "Ljava/util/Date;", "requires", "fileSize", "url", "signature", "key", "forced", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getFileSize", "()Ljava/lang/String;", "getForced", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKey", "getReleased", "()Ljava/util/Date;", "getRequires", "getSignature", "getType", "getUrl", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "equals", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ReleaseInformation.kt */
    public static final class Release {
        private final String fileSize;
        private final Boolean forced;
        private final String key;
        private final Date released;
        private final String requires;
        private final String signature;
        private final String type;
        private final String url;
        private final String version;

        public static /* synthetic */ Release copy$default(Release release, String str, String str2, Date date, String str3, String str4, String str5, String str6, String str7, Boolean bool, int i, Object obj) {
            Release release2 = release;
            int i2 = i;
            return release.copy((i2 & 1) != 0 ? release2.version : str, (i2 & 2) != 0 ? release2.type : str2, (i2 & 4) != 0 ? release2.released : date, (i2 & 8) != 0 ? release2.requires : str3, (i2 & 16) != 0 ? release2.fileSize : str4, (i2 & 32) != 0 ? release2.url : str5, (i2 & 64) != 0 ? release2.signature : str6, (i2 & 128) != 0 ? release2.key : str7, (i2 & 256) != 0 ? release2.forced : bool);
        }

        public final String component1() {
            return this.version;
        }

        public final String component2() {
            return this.type;
        }

        public final Date component3() {
            return this.released;
        }

        public final String component4() {
            return this.requires;
        }

        public final String component5() {
            return this.fileSize;
        }

        public final String component6() {
            return this.url;
        }

        public final String component7() {
            return this.signature;
        }

        public final String component8() {
            return this.key;
        }

        public final Boolean component9() {
            return this.forced;
        }

        public final Release copy(String str, String str2, Date date, String str3, String str4, String str5, String str6, String str7, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "version");
            Intrinsics.checkNotNullParameter(str2, SessionDescription.ATTR_TYPE);
            Intrinsics.checkNotNullParameter(date, "released");
            Intrinsics.checkNotNullParameter(str3, "requires");
            String str8 = str4;
            Intrinsics.checkNotNullParameter(str8, "fileSize");
            String str9 = str5;
            Intrinsics.checkNotNullParameter(str9, "url");
            String str10 = str6;
            Intrinsics.checkNotNullParameter(str10, "signature");
            String str11 = str7;
            Intrinsics.checkNotNullParameter(str11, "key");
            return new Release(str, str2, date, str3, str8, str9, str10, str11, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Release)) {
                return false;
            }
            Release release = (Release) obj;
            return Intrinsics.areEqual((Object) this.version, (Object) release.version) && Intrinsics.areEqual((Object) this.type, (Object) release.type) && Intrinsics.areEqual((Object) this.released, (Object) release.released) && Intrinsics.areEqual((Object) this.requires, (Object) release.requires) && Intrinsics.areEqual((Object) this.fileSize, (Object) release.fileSize) && Intrinsics.areEqual((Object) this.url, (Object) release.url) && Intrinsics.areEqual((Object) this.signature, (Object) release.signature) && Intrinsics.areEqual((Object) this.key, (Object) release.key) && Intrinsics.areEqual((Object) this.forced, (Object) release.forced);
        }

        public int hashCode() {
            int hashCode = ((((((((((((((this.version.hashCode() * 31) + this.type.hashCode()) * 31) + this.released.hashCode()) * 31) + this.requires.hashCode()) * 31) + this.fileSize.hashCode()) * 31) + this.url.hashCode()) * 31) + this.signature.hashCode()) * 31) + this.key.hashCode()) * 31;
            Boolean bool = this.forced;
            return hashCode + (bool == null ? 0 : bool.hashCode());
        }

        public String toString() {
            return "Release(version=" + this.version + ", type=" + this.type + ", released=" + this.released + ", requires=" + this.requires + ", fileSize=" + this.fileSize + ", url=" + this.url + ", signature=" + this.signature + ", key=" + this.key + ", forced=" + this.forced + ')';
        }

        public Release(String str, String str2, Date date, String str3, String str4, String str5, String str6, String str7, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "version");
            Intrinsics.checkNotNullParameter(str2, SessionDescription.ATTR_TYPE);
            Intrinsics.checkNotNullParameter(date, "released");
            Intrinsics.checkNotNullParameter(str3, "requires");
            Intrinsics.checkNotNullParameter(str4, "fileSize");
            Intrinsics.checkNotNullParameter(str5, "url");
            Intrinsics.checkNotNullParameter(str6, "signature");
            Intrinsics.checkNotNullParameter(str7, "key");
            this.version = str;
            this.type = str2;
            this.released = date;
            this.requires = str3;
            this.fileSize = str4;
            this.url = str5;
            this.signature = str6;
            this.key = str7;
            this.forced = bool;
        }

        public final String getVersion() {
            return this.version;
        }

        public final String getType() {
            return this.type;
        }

        public final Date getReleased() {
            return this.released;
        }

        public final String getRequires() {
            return this.requires;
        }

        public final String getFileSize() {
            return this.fileSize;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final String getKey() {
            return this.key;
        }

        public final Boolean getForced() {
            return this.forced;
        }
    }

    public ReleaseInformation(String str, List<Release> list) {
        Intrinsics.checkNotNullParameter(str, "signature");
        Intrinsics.checkNotNullParameter(list, "releases");
        this.signature = str;
        this.releases = list;
    }

    public final List<Release> getReleases() {
        return this.releases;
    }

    public final String getSignature() {
        return this.signature;
    }
}
