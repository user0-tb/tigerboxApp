package p012io.shipbook.shipbooksdk.Models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0016"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/RefreshToken;", "Lio/shipbook/shipbooksdk/Models/BaseObj;", "token", "", "appKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppKey", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.RefreshToken */
/* compiled from: RefreshToken.kt */
public final class RefreshToken implements BaseObj {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String appKey;
    private final String token;

    public static /* synthetic */ RefreshToken copy$default(RefreshToken refreshToken, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = refreshToken.token;
        }
        if ((i & 2) != 0) {
            str2 = refreshToken.appKey;
        }
        return refreshToken.copy(str, str2);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.appKey;
    }

    public final RefreshToken copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "appKey");
        return new RefreshToken(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RefreshToken)) {
            return false;
        }
        RefreshToken refreshToken = (RefreshToken) obj;
        return Intrinsics.areEqual((Object) this.token, (Object) refreshToken.token) && Intrinsics.areEqual((Object) this.appKey, (Object) refreshToken.appKey);
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.appKey.hashCode();
    }

    public String toString() {
        return "RefreshToken(token=" + this.token + ", appKey=" + this.appKey + ')';
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/RefreshToken$Companion;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Models/RefreshToken;", "json", "Lorg/json/JSONObject;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.RefreshToken$Companion */
    /* compiled from: RefreshToken.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RefreshToken create(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = jSONObject.optString("token");
            String optString2 = jSONObject.optString("appKey");
            Intrinsics.checkNotNullExpressionValue(optString, "token");
            Intrinsics.checkNotNullExpressionValue(optString2, "appKey");
            return new RefreshToken(optString, optString2);
        }
    }

    public RefreshToken(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(str2, "appKey");
        this.token = str;
        this.appKey = str2;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getToken() {
        return this.token;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", this.token);
        jSONObject.put("appKey", this.appKey);
        return jSONObject;
    }
}
