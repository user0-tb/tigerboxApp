package media.tiger.tigerbox.model.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B#\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/HlsKeyDomain;", "", "()V", "key", "", "url", "id", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getId", "()I", "getKey", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HlsKeyDomain.kt */
public final class HlsKeyDomain {

    /* renamed from: id */
    private final int f624id;
    private final String key;
    private final String url;

    public static /* synthetic */ HlsKeyDomain copy$default(HlsKeyDomain hlsKeyDomain, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = hlsKeyDomain.key;
        }
        if ((i2 & 2) != 0) {
            str2 = hlsKeyDomain.url;
        }
        if ((i2 & 4) != 0) {
            i = hlsKeyDomain.f624id;
        }
        return hlsKeyDomain.copy(str, str2, i);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.url;
    }

    public final int component3() {
        return this.f624id;
    }

    public final HlsKeyDomain copy(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "url");
        return new HlsKeyDomain(str, str2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HlsKeyDomain)) {
            return false;
        }
        HlsKeyDomain hlsKeyDomain = (HlsKeyDomain) obj;
        return Intrinsics.areEqual((Object) this.key, (Object) hlsKeyDomain.key) && Intrinsics.areEqual((Object) this.url, (Object) hlsKeyDomain.url) && this.f624id == hlsKeyDomain.f624id;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.url.hashCode()) * 31) + this.f624id;
    }

    public String toString() {
        return "HlsKeyDomain(key=" + this.key + ", url=" + this.url + ", id=" + this.f624id + ')';
    }

    public HlsKeyDomain(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "url");
        this.key = str;
        this.url = str2;
        this.f624id = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HlsKeyDomain(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getId() {
        return this.f624id;
    }

    public HlsKeyDomain() {
        this("", "", 0, 4, (DefaultConstructorMarker) null);
    }
}
