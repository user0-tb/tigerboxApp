package media.tiger.tigerbox.model.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/AccessTokenDto;", "", "()V", "access_token", "", "expires_in", "", "refresh_token", "scope", "token_type", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccess_token", "()Ljava/lang/String;", "getExpires_in", "()I", "getRefresh_token", "getScope", "getToken_type", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AccessTokenDto.kt */
public final class AccessTokenDto {
    private final String access_token;
    private final int expires_in;
    private final String refresh_token;
    private final String scope;
    private final String token_type;

    public static /* synthetic */ AccessTokenDto copy$default(AccessTokenDto accessTokenDto, String str, int i, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = accessTokenDto.access_token;
        }
        if ((i2 & 2) != 0) {
            i = accessTokenDto.expires_in;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = accessTokenDto.refresh_token;
        }
        String str5 = str2;
        if ((i2 & 8) != 0) {
            str3 = accessTokenDto.scope;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = accessTokenDto.token_type;
        }
        return accessTokenDto.copy(str, i3, str5, str6, str4);
    }

    public final String component1() {
        return this.access_token;
    }

    public final int component2() {
        return this.expires_in;
    }

    public final String component3() {
        return this.refresh_token;
    }

    public final String component4() {
        return this.scope;
    }

    public final String component5() {
        return this.token_type;
    }

    public final AccessTokenDto copy(String str, int i, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "access_token");
        Intrinsics.checkNotNullParameter(str2, "refresh_token");
        Intrinsics.checkNotNullParameter(str3, "scope");
        Intrinsics.checkNotNullParameter(str4, "token_type");
        return new AccessTokenDto(str, i, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccessTokenDto)) {
            return false;
        }
        AccessTokenDto accessTokenDto = (AccessTokenDto) obj;
        return Intrinsics.areEqual((Object) this.access_token, (Object) accessTokenDto.access_token) && this.expires_in == accessTokenDto.expires_in && Intrinsics.areEqual((Object) this.refresh_token, (Object) accessTokenDto.refresh_token) && Intrinsics.areEqual((Object) this.scope, (Object) accessTokenDto.scope) && Intrinsics.areEqual((Object) this.token_type, (Object) accessTokenDto.token_type);
    }

    public int hashCode() {
        return (((((((this.access_token.hashCode() * 31) + this.expires_in) * 31) + this.refresh_token.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.token_type.hashCode();
    }

    public String toString() {
        return "AccessTokenDto(access_token=" + this.access_token + ", expires_in=" + this.expires_in + ", refresh_token=" + this.refresh_token + ", scope=" + this.scope + ", token_type=" + this.token_type + ')';
    }

    public AccessTokenDto(String str, int i, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "access_token");
        Intrinsics.checkNotNullParameter(str2, "refresh_token");
        Intrinsics.checkNotNullParameter(str3, "scope");
        Intrinsics.checkNotNullParameter(str4, "token_type");
        this.access_token = str;
        this.expires_in = i;
        this.refresh_token = str2;
        this.scope = str3;
        this.token_type = str4;
    }

    public final String getAccess_token() {
        return this.access_token;
    }

    public final int getExpires_in() {
        return this.expires_in;
    }

    public final String getRefresh_token() {
        return this.refresh_token;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getToken_type() {
        return this.token_type;
    }

    public AccessTokenDto() {
        this("", 0, "", "", "");
    }
}
