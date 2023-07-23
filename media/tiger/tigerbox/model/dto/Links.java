package media.tiger.tigerbox.model.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/Links;", "", "self", "Lmedia/tiger/tigerbox/model/dto/Self;", "(Lmedia/tiger/tigerbox/model/dto/Self;)V", "getSelf", "()Lmedia/tiger/tigerbox/model/dto/Self;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUser.kt */
public final class Links {
    private final Self self;

    public static /* synthetic */ Links copy$default(Links links, Self self2, int i, Object obj) {
        if ((i & 1) != 0) {
            self2 = links.self;
        }
        return links.copy(self2);
    }

    public final Self component1() {
        return this.self;
    }

    public final Links copy(Self self2) {
        Intrinsics.checkNotNullParameter(self2, "self");
        return new Links(self2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Links) && Intrinsics.areEqual((Object) this.self, (Object) ((Links) obj).self);
    }

    public int hashCode() {
        return this.self.hashCode();
    }

    public String toString() {
        return "Links(self=" + this.self + ')';
    }

    public Links(Self self2) {
        Intrinsics.checkNotNullParameter(self2, "self");
        this.self = self2;
    }

    public final Self getSelf() {
        return this.self;
    }
}
