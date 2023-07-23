package media.tiger.tigerbox.model.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/EmbeddedX;", "", "preferences", "", "(Ljava/util/List;)V", "getPreferences", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUser.kt */
public final class EmbeddedX {
    private final List<Object> preferences;

    public static /* synthetic */ EmbeddedX copy$default(EmbeddedX embeddedX, List<Object> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = embeddedX.preferences;
        }
        return embeddedX.copy(list);
    }

    public final List<Object> component1() {
        return this.preferences;
    }

    public final EmbeddedX copy(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "preferences");
        return new EmbeddedX(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EmbeddedX) && Intrinsics.areEqual((Object) this.preferences, (Object) ((EmbeddedX) obj).preferences);
    }

    public int hashCode() {
        return this.preferences.hashCode();
    }

    public String toString() {
        return "EmbeddedX(preferences=" + this.preferences + ')';
    }

    public EmbeddedX(List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "preferences");
        this.preferences = list;
    }

    public final List<Object> getPreferences() {
        return this.preferences;
    }
}
