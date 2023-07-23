package media.tiger.tigerbox.model.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/Profile;", "", "name", "", "id", "", "defaultProfile", "", "_links", "Lmedia/tiger/tigerbox/model/dto/Profile$Links;", "(Ljava/lang/String;IZLmedia/tiger/tigerbox/model/dto/Profile$Links;)V", "get_links", "()Lmedia/tiger/tigerbox/model/dto/Profile$Links;", "getDefaultProfile", "()Z", "getId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Links", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUser.kt */
public final class Profile {
    private final Links _links;
    private final boolean defaultProfile;

    /* renamed from: id */
    private final int f646id;
    private final String name;

    public static /* synthetic */ Profile copy$default(Profile profile, String str, int i, boolean z, Links links, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = profile.name;
        }
        if ((i2 & 2) != 0) {
            i = profile.f646id;
        }
        if ((i2 & 4) != 0) {
            z = profile.defaultProfile;
        }
        if ((i2 & 8) != 0) {
            links = profile._links;
        }
        return profile.copy(str, i, z, links);
    }

    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.f646id;
    }

    public final boolean component3() {
        return this.defaultProfile;
    }

    public final Links component4() {
        return this._links;
    }

    public final Profile copy(String str, int i, boolean z, Links links) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(links, "_links");
        return new Profile(str, i, z, links);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile profile = (Profile) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) profile.name) && this.f646id == profile.f646id && this.defaultProfile == profile.defaultProfile && Intrinsics.areEqual((Object) this._links, (Object) profile._links);
    }

    public int hashCode() {
        int hashCode = ((this.name.hashCode() * 31) + this.f646id) * 31;
        boolean z = this.defaultProfile;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this._links.hashCode();
    }

    public String toString() {
        return "Profile(name=" + this.name + ", id=" + this.f646id + ", defaultProfile=" + this.defaultProfile + ", _links=" + this._links + ')';
    }

    public Profile(String str, int i, boolean z, Links links) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(links, "_links");
        this.name = str;
        this.f646id = i;
        this.defaultProfile = z;
        this._links = links;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Profile(String str, int i, boolean z, Links links, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? false : z, links);
    }

    public final String getName() {
        return this.name;
    }

    public final int getId() {
        return this.f646id;
    }

    public final boolean getDefaultProfile() {
        return this.defaultProfile;
    }

    public final Links get_links() {
        return this._links;
    }

    @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/Profile$Links;", "", "avatar", "Lmedia/tiger/tigerbox/model/dto/Profile$Links$Link;", "(Lmedia/tiger/tigerbox/model/dto/Profile$Links$Link;)V", "getAvatar", "()Lmedia/tiger/tigerbox/model/dto/Profile$Links$Link;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Link", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerBoxUser.kt */
    public static final class Links {
        private final Link avatar;

        public Links() {
            this((Link) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Links copy$default(Links links, Link link, int i, Object obj) {
            if ((i & 1) != 0) {
                link = links.avatar;
            }
            return links.copy(link);
        }

        public final Link component1() {
            return this.avatar;
        }

        public final Links copy(Link link) {
            return new Links(link);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Links) && Intrinsics.areEqual((Object) this.avatar, (Object) ((Links) obj).avatar);
        }

        public int hashCode() {
            Link link = this.avatar;
            if (link == null) {
                return 0;
            }
            return link.hashCode();
        }

        public String toString() {
            return "Links(avatar=" + this.avatar + ')';
        }

        public Links(Link link) {
            this.avatar = link;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Links(Link link, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : link);
        }

        public final Link getAvatar() {
            return this.avatar;
        }

        @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/Profile$Links$Link;", "", "href", "", "(Ljava/lang/String;)V", "getHref", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: TigerBoxUser.kt */
        public static final class Link {
            private final String href;

            public Link() {
                this((String) null, 1, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Link copy$default(Link link, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = link.href;
                }
                return link.copy(str);
            }

            public final String component1() {
                return this.href;
            }

            public final Link copy(String str) {
                return new Link(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Link) && Intrinsics.areEqual((Object) this.href, (Object) ((Link) obj).href);
            }

            public int hashCode() {
                String str = this.href;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "Link(href=" + this.href + ')';
            }

            public Link(String str) {
                this.href = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Link(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }

            public final String getHref() {
                return this.href;
            }
        }
    }
}
