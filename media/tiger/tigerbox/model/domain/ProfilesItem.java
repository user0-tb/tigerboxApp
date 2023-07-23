package media.tiger.tigerbox.model.domain;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u001f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/ProfilesItem;", "", "id", "", "email", "", "nickName", "position", "avatarUrl", "isSelected", "", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "getAvatarUrl", "()Ljava/lang/String;", "getEmail", "getId", "()I", "()Z", "getNickName", "getPosition", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserDomain.kt */
public final class ProfilesItem {
    private final String avatarUrl;
    private final String email;

    /* renamed from: id */
    private final int f630id;
    private final boolean isSelected;
    private final String nickName;
    private final int position;

    public static /* synthetic */ ProfilesItem copy$default(ProfilesItem profilesItem, int i, String str, String str2, int i2, String str3, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = profilesItem.f630id;
        }
        if ((i3 & 2) != 0) {
            str = profilesItem.email;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            str2 = profilesItem.nickName;
        }
        String str5 = str2;
        if ((i3 & 8) != 0) {
            i2 = profilesItem.position;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            str3 = profilesItem.avatarUrl;
        }
        String str6 = str3;
        if ((i3 & 32) != 0) {
            z = profilesItem.isSelected;
        }
        return profilesItem.copy(i, str4, str5, i4, str6, z);
    }

    public final int component1() {
        return this.f630id;
    }

    public final String component2() {
        return this.email;
    }

    public final String component3() {
        return this.nickName;
    }

    public final int component4() {
        return this.position;
    }

    public final String component5() {
        return this.avatarUrl;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    public final ProfilesItem copy(int i, String str, String str2, int i2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkNotNullParameter(str2, "nickName");
        Intrinsics.checkNotNullParameter(str3, "avatarUrl");
        return new ProfilesItem(i, str, str2, i2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfilesItem)) {
            return false;
        }
        ProfilesItem profilesItem = (ProfilesItem) obj;
        return this.f630id == profilesItem.f630id && Intrinsics.areEqual((Object) this.email, (Object) profilesItem.email) && Intrinsics.areEqual((Object) this.nickName, (Object) profilesItem.nickName) && this.position == profilesItem.position && Intrinsics.areEqual((Object) this.avatarUrl, (Object) profilesItem.avatarUrl) && this.isSelected == profilesItem.isSelected;
    }

    public int hashCode() {
        int hashCode = ((((((((this.f630id * 31) + this.email.hashCode()) * 31) + this.nickName.hashCode()) * 31) + this.position) * 31) + this.avatarUrl.hashCode()) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "ProfilesItem(id=" + this.f630id + ", email=" + this.email + ", nickName=" + this.nickName + ", position=" + this.position + ", avatarUrl=" + this.avatarUrl + ", isSelected=" + this.isSelected + ')';
    }

    public ProfilesItem(int i, String str, String str2, int i2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics.checkNotNullParameter(str2, "nickName");
        Intrinsics.checkNotNullParameter(str3, "avatarUrl");
        this.f630id = i;
        this.email = str;
        this.nickName = str2;
        this.position = i2;
        this.avatarUrl = str3;
        this.isSelected = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProfilesItem(int i, String str, String str2, int i2, String str3, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, i2, str3, (i3 & 32) != 0 ? false : z);
    }

    public final int getId() {
        return this.f630id;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }
}
