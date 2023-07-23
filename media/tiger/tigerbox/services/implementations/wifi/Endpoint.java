package media.tiger.tigerbox.services.implementations.wifi;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/wifi/Endpoint;", "", "url", "", "port", "", "(Ljava/lang/String;I)V", "getPort", "()I", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Endpoint.kt */
public final class Endpoint {
    private final int port;
    private final String url;

    public static /* synthetic */ Endpoint copy$default(Endpoint endpoint, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = endpoint.url;
        }
        if ((i2 & 2) != 0) {
            i = endpoint.port;
        }
        return endpoint.copy(str, i);
    }

    public final String component1() {
        return this.url;
    }

    public final int component2() {
        return this.port;
    }

    public final Endpoint copy(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new Endpoint(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Endpoint)) {
            return false;
        }
        Endpoint endpoint = (Endpoint) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) endpoint.url) && this.port == endpoint.port;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.port;
    }

    public String toString() {
        return "Endpoint(url=" + this.url + ", port=" + this.port + ')';
    }

    public Endpoint(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
        this.port = i;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getPort() {
        return this.port;
    }
}
