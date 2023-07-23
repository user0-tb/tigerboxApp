package media.tiger.tigerbox.model.domain;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003JU\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006#"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "", "()V", "id", "", "email", "", "accountId", "nickName", "birthday", "gender", "avatarUrl", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccountId", "()I", "getAvatarUrl", "()Ljava/lang/String;", "getBirthday", "getEmail", "getGender", "getId", "getNickName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserDomain.kt */
public final class TigerBoxProfileDomain {
    private final int accountId;
    private final String avatarUrl;
    private final String birthday;
    private final String email;
    private final String gender;

    /* renamed from: id */
    private final int f632id;
    private final String nickName;

    public static /* synthetic */ TigerBoxProfileDomain copy$default(TigerBoxProfileDomain tigerBoxProfileDomain, int i, String str, int i2, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = tigerBoxProfileDomain.f632id;
        }
        if ((i3 & 2) != 0) {
            str = tigerBoxProfileDomain.email;
        }
        String str6 = str;
        if ((i3 & 4) != 0) {
            i2 = tigerBoxProfileDomain.accountId;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str2 = tigerBoxProfileDomain.nickName;
        }
        String str7 = str2;
        if ((i3 & 16) != 0) {
            str3 = tigerBoxProfileDomain.birthday;
        }
        String str8 = str3;
        if ((i3 & 32) != 0) {
            str4 = tigerBoxProfileDomain.gender;
        }
        String str9 = str4;
        if ((i3 & 64) != 0) {
            str5 = tigerBoxProfileDomain.avatarUrl;
        }
        return tigerBoxProfileDomain.copy(i, str6, i4, str7, str8, str9, str5);
    }

    public final int component1() {
        return this.f632id;
    }

    public final String component2() {
        return this.email;
    }

    public final int component3() {
        return this.accountId;
    }

    public final String component4() {
        return this.nickName;
    }

    public final String component5() {
        return this.birthday;
    }

    public final String component6() {
        return this.gender;
    }

    public final String component7() {
        return this.avatarUrl;
    }

    public final TigerBoxProfileDomain copy(int i, String str, int i2, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkNotNullParameter(str2, "nickName");
        return new TigerBoxProfileDomain(i, str, i2, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TigerBoxProfileDomain)) {
            return false;
        }
        TigerBoxProfileDomain tigerBoxProfileDomain = (TigerBoxProfileDomain) obj;
        return this.f632id == tigerBoxProfileDomain.f632id && Intrinsics.areEqual((Object) this.email, (Object) tigerBoxProfileDomain.email) && this.accountId == tigerBoxProfileDomain.accountId && Intrinsics.areEqual((Object) this.nickName, (Object) tigerBoxProfileDomain.nickName) && Intrinsics.areEqual((Object) this.birthday, (Object) tigerBoxProfileDomain.birthday) && Intrinsics.areEqual((Object) this.gender, (Object) tigerBoxProfileDomain.gender) && Intrinsics.areEqual((Object) this.avatarUrl, (Object) tigerBoxProfileDomain.avatarUrl);
    }

    public int hashCode() {
        int hashCode = ((((((this.f632id * 31) + this.email.hashCode()) * 31) + this.accountId) * 31) + this.nickName.hashCode()) * 31;
        String str = this.birthday;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.gender;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.avatarUrl;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "TigerBoxProfileDomain(id=" + this.f632id + ", email=" + this.email + ", accountId=" + this.accountId + ", nickName=" + this.nickName + ", birthday=" + this.birthday + ", gender=" + this.gender + ", avatarUrl=" + this.avatarUrl + ')';
    }

    public TigerBoxProfileDomain(int i, String str, int i2, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkNotNullParameter(str2, "nickName");
        this.f632id = i;
        this.email = str;
        this.accountId = i2;
        this.nickName = str2;
        this.birthday = str3;
        this.gender = str4;
        this.avatarUrl = str5;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TigerBoxProfileDomain(int i, String str, int i2, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? -1 : i2, (i3 & 8) != 0 ? "" : str2, str3, str4, str5);
    }

    public final int getId() {
        return this.f632id;
    }

    public final String getEmail() {
        return this.email;
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getBirthday() {
        return this.birthday;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public TigerBoxProfileDomain() {
        this(-1, "", -1, "", (String) null, (String) null, (String) null);
    }
}
