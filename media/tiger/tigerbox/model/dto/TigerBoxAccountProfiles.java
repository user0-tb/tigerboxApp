package media.tiger.tigerbox.model.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/TigerBoxAccountProfiles;", "", "_embedded", "Lmedia/tiger/tigerbox/model/dto/Embedded;", "(Lmedia/tiger/tigerbox/model/dto/Embedded;)V", "get_embedded", "()Lmedia/tiger/tigerbox/model/dto/Embedded;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUser.kt */
public final class TigerBoxAccountProfiles {
    private final Embedded _embedded;

    public static /* synthetic */ TigerBoxAccountProfiles copy$default(TigerBoxAccountProfiles tigerBoxAccountProfiles, Embedded embedded, int i, Object obj) {
        if ((i & 1) != 0) {
            embedded = tigerBoxAccountProfiles._embedded;
        }
        return tigerBoxAccountProfiles.copy(embedded);
    }

    public final Embedded component1() {
        return this._embedded;
    }

    public final TigerBoxAccountProfiles copy(Embedded embedded) {
        Intrinsics.checkNotNullParameter(embedded, "_embedded");
        return new TigerBoxAccountProfiles(embedded);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TigerBoxAccountProfiles) && Intrinsics.areEqual((Object) this._embedded, (Object) ((TigerBoxAccountProfiles) obj)._embedded);
    }

    public int hashCode() {
        return this._embedded.hashCode();
    }

    public String toString() {
        return "TigerBoxAccountProfiles(_embedded=" + this._embedded + ')';
    }

    public TigerBoxAccountProfiles(Embedded embedded) {
        Intrinsics.checkNotNullParameter(embedded, "_embedded");
        this._embedded = embedded;
    }

    public final Embedded get_embedded() {
        return this._embedded;
    }
}
