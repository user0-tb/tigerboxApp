package media.tiger.tigerbox.model.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b>\b\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010:J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010G\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010/J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0015HÆ\u0003J\t\u0010J\u001a\u00020\u0017HÆ\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019HÆ\u0003J\t\u0010L\u001a\u00020\u001bHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u001dHÆ\u0003J\t\u0010O\u001a\u00020\u001fHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\bHÆ\u0003J\t\u0010S\u001a\u00020\bHÆ\u0003J\t\u0010T\u001a\u00020\bHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003Jò\u0001\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001fHÆ\u0001¢\u0006\u0002\u0010XJ\u0013\u0010Y\u001a\u00020\u00112\b\u0010Z\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010[\u001a\u00020\bHÖ\u0001J\t\u0010\\\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010&R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010*R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010*R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010*R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010*R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u00100\u001a\u0004\b@\u0010/R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010&¨\u0006]"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/User;", "", "createdBy", "", "createdDate", "lastModifiedBy", "lastModifiedDate", "version", "", "id", "accountId", "nickName", "birthday", "gender", "points", "avatar", "enabled", "", "shopAccess", "lastAccessDate", "metaData", "Lmedia/tiger/tigerbox/model/dto/MetaData;", "settings", "Lmedia/tiger/tigerbox/model/dto/Settings;", "preferences", "", "ageRange", "Lmedia/tiger/tigerbox/model/dto/AgeRange;", "_links", "Lmedia/tiger/tigerbox/model/dto/Links;", "_embedded", "Lmedia/tiger/tigerbox/model/dto/EmbeddedX;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/MetaData;Lmedia/tiger/tigerbox/model/dto/Settings;Ljava/util/List;Lmedia/tiger/tigerbox/model/dto/AgeRange;Lmedia/tiger/tigerbox/model/dto/Links;Lmedia/tiger/tigerbox/model/dto/EmbeddedX;)V", "get_embedded", "()Lmedia/tiger/tigerbox/model/dto/EmbeddedX;", "get_links", "()Lmedia/tiger/tigerbox/model/dto/Links;", "getAccountId", "()I", "getAgeRange", "()Lmedia/tiger/tigerbox/model/dto/AgeRange;", "getAvatar", "()Ljava/lang/String;", "getBirthday", "getCreatedBy", "getCreatedDate", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGender", "getId", "getLastAccessDate", "getLastModifiedBy", "getLastModifiedDate", "getMetaData", "()Lmedia/tiger/tigerbox/model/dto/MetaData;", "getNickName", "getPoints", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreferences", "()Ljava/util/List;", "getSettings", "()Lmedia/tiger/tigerbox/model/dto/Settings;", "getShopAccess", "getVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/MetaData;Lmedia/tiger/tigerbox/model/dto/Settings;Ljava/util/List;Lmedia/tiger/tigerbox/model/dto/AgeRange;Lmedia/tiger/tigerbox/model/dto/Links;Lmedia/tiger/tigerbox/model/dto/EmbeddedX;)Lmedia/tiger/tigerbox/model/dto/User;", "equals", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUser.kt */
public final class User {
    private final EmbeddedX _embedded;
    private final Links _links;
    private final int accountId;
    private final AgeRange ageRange;
    private final String avatar;
    private final String birthday;
    private final String createdBy;
    private final String createdDate;
    private final Boolean enabled;
    private final String gender;

    /* renamed from: id */
    private final int f651id;
    private final String lastAccessDate;
    private final String lastModifiedBy;
    private final String lastModifiedDate;
    private final MetaData metaData;
    private final String nickName;
    private final Integer points;
    private final List<Object> preferences;
    private final Settings settings;
    private final Boolean shopAccess;
    private final int version;

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, String str6, String str7, Integer num, String str8, Boolean bool, Boolean bool2, String str9, MetaData metaData2, Settings settings2, List list, AgeRange ageRange2, Links links, EmbeddedX embeddedX, int i4, Object obj) {
        User user2 = user;
        int i5 = i4;
        return user.copy((i5 & 1) != 0 ? user2.createdBy : str, (i5 & 2) != 0 ? user2.createdDate : str2, (i5 & 4) != 0 ? user2.lastModifiedBy : str3, (i5 & 8) != 0 ? user2.lastModifiedDate : str4, (i5 & 16) != 0 ? user2.version : i, (i5 & 32) != 0 ? user2.f651id : i2, (i5 & 64) != 0 ? user2.accountId : i3, (i5 & 128) != 0 ? user2.nickName : str5, (i5 & 256) != 0 ? user2.birthday : str6, (i5 & 512) != 0 ? user2.gender : str7, (i5 & 1024) != 0 ? user2.points : num, (i5 & 2048) != 0 ? user2.avatar : str8, (i5 & 4096) != 0 ? user2.enabled : bool, (i5 & 8192) != 0 ? user2.shopAccess : bool2, (i5 & 16384) != 0 ? user2.lastAccessDate : str9, (i5 & 32768) != 0 ? user2.metaData : metaData2, (i5 & 65536) != 0 ? user2.settings : settings2, (i5 & 131072) != 0 ? user2.preferences : list, (i5 & 262144) != 0 ? user2.ageRange : ageRange2, (i5 & 524288) != 0 ? user2._links : links, (i5 & 1048576) != 0 ? user2._embedded : embeddedX);
    }

    public final String component1() {
        return this.createdBy;
    }

    public final String component10() {
        return this.gender;
    }

    public final Integer component11() {
        return this.points;
    }

    public final String component12() {
        return this.avatar;
    }

    public final Boolean component13() {
        return this.enabled;
    }

    public final Boolean component14() {
        return this.shopAccess;
    }

    public final String component15() {
        return this.lastAccessDate;
    }

    public final MetaData component16() {
        return this.metaData;
    }

    public final Settings component17() {
        return this.settings;
    }

    public final List<Object> component18() {
        return this.preferences;
    }

    public final AgeRange component19() {
        return this.ageRange;
    }

    public final String component2() {
        return this.createdDate;
    }

    public final Links component20() {
        return this._links;
    }

    public final EmbeddedX component21() {
        return this._embedded;
    }

    public final String component3() {
        return this.lastModifiedBy;
    }

    public final String component4() {
        return this.lastModifiedDate;
    }

    public final int component5() {
        return this.version;
    }

    public final int component6() {
        return this.f651id;
    }

    public final int component7() {
        return this.accountId;
    }

    public final String component8() {
        return this.nickName;
    }

    public final String component9() {
        return this.birthday;
    }

    public final User copy(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, String str6, String str7, Integer num, String str8, Boolean bool, Boolean bool2, String str9, MetaData metaData2, Settings settings2, List<? extends Object> list, AgeRange ageRange2, Links links, EmbeddedX embeddedX) {
        String str10 = str;
        Intrinsics.checkNotNullParameter(str10, "createdBy");
        Intrinsics.checkNotNullParameter(str2, "createdDate");
        Intrinsics.checkNotNullParameter(str4, "lastModifiedDate");
        Intrinsics.checkNotNullParameter(str6, "birthday");
        Intrinsics.checkNotNullParameter(str7, "gender");
        Intrinsics.checkNotNullParameter(str9, "lastAccessDate");
        Intrinsics.checkNotNullParameter(metaData2, "metaData");
        Intrinsics.checkNotNullParameter(settings2, "settings");
        Intrinsics.checkNotNullParameter(list, "preferences");
        Intrinsics.checkNotNullParameter(ageRange2, "ageRange");
        Intrinsics.checkNotNullParameter(links, "_links");
        Intrinsics.checkNotNullParameter(embeddedX, "_embedded");
        return new User(str10, str2, str3, str4, i, i2, i3, str5, str6, str7, num, str8, bool, bool2, str9, metaData2, settings2, list, ageRange2, links, embeddedX);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return Intrinsics.areEqual((Object) this.createdBy, (Object) user.createdBy) && Intrinsics.areEqual((Object) this.createdDate, (Object) user.createdDate) && Intrinsics.areEqual((Object) this.lastModifiedBy, (Object) user.lastModifiedBy) && Intrinsics.areEqual((Object) this.lastModifiedDate, (Object) user.lastModifiedDate) && this.version == user.version && this.f651id == user.f651id && this.accountId == user.accountId && Intrinsics.areEqual((Object) this.nickName, (Object) user.nickName) && Intrinsics.areEqual((Object) this.birthday, (Object) user.birthday) && Intrinsics.areEqual((Object) this.gender, (Object) user.gender) && Intrinsics.areEqual((Object) this.points, (Object) user.points) && Intrinsics.areEqual((Object) this.avatar, (Object) user.avatar) && Intrinsics.areEqual((Object) this.enabled, (Object) user.enabled) && Intrinsics.areEqual((Object) this.shopAccess, (Object) user.shopAccess) && Intrinsics.areEqual((Object) this.lastAccessDate, (Object) user.lastAccessDate) && Intrinsics.areEqual((Object) this.metaData, (Object) user.metaData) && Intrinsics.areEqual((Object) this.settings, (Object) user.settings) && Intrinsics.areEqual((Object) this.preferences, (Object) user.preferences) && Intrinsics.areEqual((Object) this.ageRange, (Object) user.ageRange) && Intrinsics.areEqual((Object) this._links, (Object) user._links) && Intrinsics.areEqual((Object) this._embedded, (Object) user._embedded);
    }

    public int hashCode() {
        int hashCode = ((this.createdBy.hashCode() * 31) + this.createdDate.hashCode()) * 31;
        String str = this.lastModifiedBy;
        int i = 0;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.lastModifiedDate.hashCode()) * 31) + this.version) * 31) + this.f651id) * 31) + this.accountId) * 31;
        String str2 = this.nickName;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.birthday.hashCode()) * 31) + this.gender.hashCode()) * 31;
        Integer num = this.points;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.avatar;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.enabled;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.shopAccess;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return ((((((((((((((hashCode6 + i) * 31) + this.lastAccessDate.hashCode()) * 31) + this.metaData.hashCode()) * 31) + this.settings.hashCode()) * 31) + this.preferences.hashCode()) * 31) + this.ageRange.hashCode()) * 31) + this._links.hashCode()) * 31) + this._embedded.hashCode();
    }

    public String toString() {
        return "User(createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy=" + this.lastModifiedBy + ", lastModifiedDate=" + this.lastModifiedDate + ", version=" + this.version + ", id=" + this.f651id + ", accountId=" + this.accountId + ", nickName=" + this.nickName + ", birthday=" + this.birthday + ", gender=" + this.gender + ", points=" + this.points + ", avatar=" + this.avatar + ", enabled=" + this.enabled + ", shopAccess=" + this.shopAccess + ", lastAccessDate=" + this.lastAccessDate + ", metaData=" + this.metaData + ", settings=" + this.settings + ", preferences=" + this.preferences + ", ageRange=" + this.ageRange + ", _links=" + this._links + ", _embedded=" + this._embedded + ')';
    }

    public User(String str, String str2, String str3, String str4, int i, int i2, int i3, String str5, String str6, String str7, Integer num, String str8, Boolean bool, Boolean bool2, String str9, MetaData metaData2, Settings settings2, List<? extends Object> list, AgeRange ageRange2, Links links, EmbeddedX embeddedX) {
        String str10 = str2;
        String str11 = str4;
        String str12 = str6;
        String str13 = str7;
        String str14 = str9;
        MetaData metaData3 = metaData2;
        Settings settings3 = settings2;
        List<? extends Object> list2 = list;
        AgeRange ageRange3 = ageRange2;
        Links links2 = links;
        EmbeddedX embeddedX2 = embeddedX;
        Intrinsics.checkNotNullParameter(str, "createdBy");
        Intrinsics.checkNotNullParameter(str10, "createdDate");
        Intrinsics.checkNotNullParameter(str11, "lastModifiedDate");
        Intrinsics.checkNotNullParameter(str12, "birthday");
        Intrinsics.checkNotNullParameter(str13, "gender");
        Intrinsics.checkNotNullParameter(str14, "lastAccessDate");
        Intrinsics.checkNotNullParameter(metaData3, "metaData");
        Intrinsics.checkNotNullParameter(settings3, "settings");
        Intrinsics.checkNotNullParameter(list2, "preferences");
        Intrinsics.checkNotNullParameter(ageRange3, "ageRange");
        Intrinsics.checkNotNullParameter(links2, "_links");
        Intrinsics.checkNotNullParameter(embeddedX2, "_embedded");
        this.createdBy = str;
        this.createdDate = str10;
        this.lastModifiedBy = str3;
        this.lastModifiedDate = str11;
        this.version = i;
        this.f651id = i2;
        this.accountId = i3;
        this.nickName = str5;
        this.birthday = str12;
        this.gender = str13;
        this.points = num;
        this.avatar = str8;
        this.enabled = bool;
        this.shopAccess = bool2;
        this.lastAccessDate = str14;
        this.metaData = metaData3;
        this.settings = settings3;
        this.preferences = list2;
        this.ageRange = ageRange3;
        this._links = links2;
        this._embedded = embeddedX2;
    }

    public final String getCreatedBy() {
        return this.createdBy;
    }

    public final String getCreatedDate() {
        return this.createdDate;
    }

    public final String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public final String getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public final int getVersion() {
        return this.version;
    }

    public final int getId() {
        return this.f651id;
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

    public final Integer getPoints() {
        return this.points;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final Boolean getShopAccess() {
        return this.shopAccess;
    }

    public final String getLastAccessDate() {
        return this.lastAccessDate;
    }

    public final MetaData getMetaData() {
        return this.metaData;
    }

    public final Settings getSettings() {
        return this.settings;
    }

    public final List<Object> getPreferences() {
        return this.preferences;
    }

    public final AgeRange getAgeRange() {
        return this.ageRange;
    }

    public final Links get_links() {
        return this._links;
    }

    public final EmbeddedX get_embedded() {
        return this._embedded;
    }
}
