package media.tiger.tigerbox.model.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b5\b\b\u0018\u00002\u00020\u0001:\u0002LMB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u0010HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\t\u0010<\u001a\u00020\bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\t\u0010?\u001a\u00020\bHÆ\u0003J\t\u0010@\u001a\u00020\bHÆ\u0003J\t\u0010A\u001a\u00020\bHÆ\u0003J\t\u0010B\u001a\u00020\u0004HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010#J\t\u0010E\u001a\u00020\bHÆ\u0003JÊ\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0004HÖ\u0001J\t\u0010K\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0014\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0015\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\u0016\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0011\u0010\u0017\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u0012\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006N"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "", "()V", "id", "", "enabled", "", "deviceIdentifier", "", "currentVersion", "deviceType", "accountId", "currentUserId", "currentProfileId", "displayName", "production", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Production;", "deviceApiKey", "localIpAddress", "localIpAddressReportingDate", "createdBy", "createdDate", "lastModifiedBy", "lastModifiedDate", "_links", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Links;", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Production;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Links;)V", "get_links", "()Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Links;", "getAccountId", "()I", "getCreatedBy", "()Ljava/lang/String;", "getCreatedDate", "getCurrentProfileId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCurrentUserId", "getCurrentVersion", "getDeviceApiKey", "getDeviceIdentifier", "getDeviceType", "getDisplayName", "getEnabled", "()Z", "getId", "getLastModifiedBy", "getLastModifiedDate", "getLocalIpAddress", "getLocalIpAddressReportingDate", "getProduction", "()Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Production;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Production;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Links;)Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "equals", "other", "hashCode", "toString", "Links", "Production", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DeviceInformation.kt */
public final class DeviceInformation {
    private final Links _links;
    private final int accountId;
    private final String createdBy;
    private final String createdDate;
    private final Integer currentProfileId;
    private final Integer currentUserId;
    private final String currentVersion;
    private final String deviceApiKey;
    private final String deviceIdentifier;
    private final String deviceType;
    private final String displayName;
    private final boolean enabled;

    /* renamed from: id */
    private final int f637id;
    private final String lastModifiedBy;
    private final String lastModifiedDate;
    private final String localIpAddress;
    private final String localIpAddressReportingDate;
    private final Production production;

    public static /* synthetic */ DeviceInformation copy$default(DeviceInformation deviceInformation, int i, boolean z, String str, String str2, String str3, int i2, Integer num, Integer num2, String str4, Production production2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Links links, int i3, Object obj) {
        DeviceInformation deviceInformation2 = deviceInformation;
        int i4 = i3;
        return deviceInformation.copy((i4 & 1) != 0 ? deviceInformation2.f637id : i, (i4 & 2) != 0 ? deviceInformation2.enabled : z, (i4 & 4) != 0 ? deviceInformation2.deviceIdentifier : str, (i4 & 8) != 0 ? deviceInformation2.currentVersion : str2, (i4 & 16) != 0 ? deviceInformation2.deviceType : str3, (i4 & 32) != 0 ? deviceInformation2.accountId : i2, (i4 & 64) != 0 ? deviceInformation2.currentUserId : num, (i4 & 128) != 0 ? deviceInformation2.currentProfileId : num2, (i4 & 256) != 0 ? deviceInformation2.displayName : str4, (i4 & 512) != 0 ? deviceInformation2.production : production2, (i4 & 1024) != 0 ? deviceInformation2.deviceApiKey : str5, (i4 & 2048) != 0 ? deviceInformation2.localIpAddress : str6, (i4 & 4096) != 0 ? deviceInformation2.localIpAddressReportingDate : str7, (i4 & 8192) != 0 ? deviceInformation2.createdBy : str8, (i4 & 16384) != 0 ? deviceInformation2.createdDate : str9, (i4 & 32768) != 0 ? deviceInformation2.lastModifiedBy : str10, (i4 & 65536) != 0 ? deviceInformation2.lastModifiedDate : str11, (i4 & 131072) != 0 ? deviceInformation2._links : links);
    }

    public final int component1() {
        return this.f637id;
    }

    public final Production component10() {
        return this.production;
    }

    public final String component11() {
        return this.deviceApiKey;
    }

    public final String component12() {
        return this.localIpAddress;
    }

    public final String component13() {
        return this.localIpAddressReportingDate;
    }

    public final String component14() {
        return this.createdBy;
    }

    public final String component15() {
        return this.createdDate;
    }

    public final String component16() {
        return this.lastModifiedBy;
    }

    public final String component17() {
        return this.lastModifiedDate;
    }

    public final Links component18() {
        return this._links;
    }

    public final boolean component2() {
        return this.enabled;
    }

    public final String component3() {
        return this.deviceIdentifier;
    }

    public final String component4() {
        return this.currentVersion;
    }

    public final String component5() {
        return this.deviceType;
    }

    public final int component6() {
        return this.accountId;
    }

    public final Integer component7() {
        return this.currentUserId;
    }

    public final Integer component8() {
        return this.currentProfileId;
    }

    public final String component9() {
        return this.displayName;
    }

    public final DeviceInformation copy(int i, boolean z, String str, String str2, String str3, int i2, Integer num, Integer num2, String str4, Production production2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Links links) {
        int i3 = i;
        Intrinsics.checkNotNullParameter(str, "deviceIdentifier");
        Intrinsics.checkNotNullParameter(str2, "currentVersion");
        Intrinsics.checkNotNullParameter(str3, "deviceType");
        Intrinsics.checkNotNullParameter(str4, "displayName");
        Intrinsics.checkNotNullParameter(production2, "production");
        Intrinsics.checkNotNullParameter(str5, "deviceApiKey");
        Intrinsics.checkNotNullParameter(str6, "localIpAddress");
        Intrinsics.checkNotNullParameter(str8, "createdBy");
        Intrinsics.checkNotNullParameter(str9, "createdDate");
        Intrinsics.checkNotNullParameter(str10, "lastModifiedBy");
        Intrinsics.checkNotNullParameter(str11, "lastModifiedDate");
        return new DeviceInformation(i, z, str, str2, str3, i2, num, num2, str4, production2, str5, str6, str7, str8, str9, str10, str11, links);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInformation)) {
            return false;
        }
        DeviceInformation deviceInformation = (DeviceInformation) obj;
        return this.f637id == deviceInformation.f637id && this.enabled == deviceInformation.enabled && Intrinsics.areEqual((Object) this.deviceIdentifier, (Object) deviceInformation.deviceIdentifier) && Intrinsics.areEqual((Object) this.currentVersion, (Object) deviceInformation.currentVersion) && Intrinsics.areEqual((Object) this.deviceType, (Object) deviceInformation.deviceType) && this.accountId == deviceInformation.accountId && Intrinsics.areEqual((Object) this.currentUserId, (Object) deviceInformation.currentUserId) && Intrinsics.areEqual((Object) this.currentProfileId, (Object) deviceInformation.currentProfileId) && Intrinsics.areEqual((Object) this.displayName, (Object) deviceInformation.displayName) && Intrinsics.areEqual((Object) this.production, (Object) deviceInformation.production) && Intrinsics.areEqual((Object) this.deviceApiKey, (Object) deviceInformation.deviceApiKey) && Intrinsics.areEqual((Object) this.localIpAddress, (Object) deviceInformation.localIpAddress) && Intrinsics.areEqual((Object) this.localIpAddressReportingDate, (Object) deviceInformation.localIpAddressReportingDate) && Intrinsics.areEqual((Object) this.createdBy, (Object) deviceInformation.createdBy) && Intrinsics.areEqual((Object) this.createdDate, (Object) deviceInformation.createdDate) && Intrinsics.areEqual((Object) this.lastModifiedBy, (Object) deviceInformation.lastModifiedBy) && Intrinsics.areEqual((Object) this.lastModifiedDate, (Object) deviceInformation.lastModifiedDate) && Intrinsics.areEqual((Object) this._links, (Object) deviceInformation._links);
    }

    public int hashCode() {
        int i = this.f637id * 31;
        boolean z = this.enabled;
        if (z) {
            z = true;
        }
        int hashCode = (((((((((i + (z ? 1 : 0)) * 31) + this.deviceIdentifier.hashCode()) * 31) + this.currentVersion.hashCode()) * 31) + this.deviceType.hashCode()) * 31) + this.accountId) * 31;
        Integer num = this.currentUserId;
        int i2 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.currentProfileId;
        int hashCode3 = (((((((((hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31) + this.displayName.hashCode()) * 31) + this.production.hashCode()) * 31) + this.deviceApiKey.hashCode()) * 31) + this.localIpAddress.hashCode()) * 31;
        String str = this.localIpAddressReportingDate;
        int hashCode4 = (((((((((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.createdBy.hashCode()) * 31) + this.createdDate.hashCode()) * 31) + this.lastModifiedBy.hashCode()) * 31) + this.lastModifiedDate.hashCode()) * 31;
        Links links = this._links;
        if (links != null) {
            i2 = links.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return "DeviceInformation(id=" + this.f637id + ", enabled=" + this.enabled + ", deviceIdentifier=" + this.deviceIdentifier + ", currentVersion=" + this.currentVersion + ", deviceType=" + this.deviceType + ", accountId=" + this.accountId + ", currentUserId=" + this.currentUserId + ", currentProfileId=" + this.currentProfileId + ", displayName=" + this.displayName + ", production=" + this.production + ", deviceApiKey=" + this.deviceApiKey + ", localIpAddress=" + this.localIpAddress + ", localIpAddressReportingDate=" + this.localIpAddressReportingDate + ", createdBy=" + this.createdBy + ", createdDate=" + this.createdDate + ", lastModifiedBy=" + this.lastModifiedBy + ", lastModifiedDate=" + this.lastModifiedDate + ", _links=" + this._links + ')';
    }

    public DeviceInformation(int i, boolean z, String str, String str2, String str3, int i2, Integer num, Integer num2, String str4, Production production2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Links links) {
        String str12 = str;
        String str13 = str2;
        String str14 = str3;
        String str15 = str4;
        Production production3 = production2;
        String str16 = str5;
        String str17 = str6;
        String str18 = str8;
        String str19 = str9;
        String str20 = str10;
        String str21 = str11;
        Intrinsics.checkNotNullParameter(str12, "deviceIdentifier");
        Intrinsics.checkNotNullParameter(str13, "currentVersion");
        Intrinsics.checkNotNullParameter(str14, "deviceType");
        Intrinsics.checkNotNullParameter(str15, "displayName");
        Intrinsics.checkNotNullParameter(production3, "production");
        Intrinsics.checkNotNullParameter(str16, "deviceApiKey");
        Intrinsics.checkNotNullParameter(str17, "localIpAddress");
        Intrinsics.checkNotNullParameter(str18, "createdBy");
        Intrinsics.checkNotNullParameter(str19, "createdDate");
        Intrinsics.checkNotNullParameter(str20, "lastModifiedBy");
        Intrinsics.checkNotNullParameter(str21, "lastModifiedDate");
        this.f637id = i;
        this.enabled = z;
        this.deviceIdentifier = str12;
        this.currentVersion = str13;
        this.deviceType = str14;
        this.accountId = i2;
        this.currentUserId = num;
        this.currentProfileId = num2;
        this.displayName = str15;
        this.production = production3;
        this.deviceApiKey = str16;
        this.localIpAddress = str17;
        this.localIpAddressReportingDate = str7;
        this.createdBy = str18;
        this.createdDate = str19;
        this.lastModifiedBy = str20;
        this.lastModifiedDate = str21;
        this._links = links;
    }

    public final int getId() {
        return this.f637id;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final String getDeviceIdentifier() {
        return this.deviceIdentifier;
    }

    public final String getCurrentVersion() {
        return this.currentVersion;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final Integer getCurrentUserId() {
        return this.currentUserId;
    }

    public final Integer getCurrentProfileId() {
        return this.currentProfileId;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Production getProduction() {
        return this.production;
    }

    public final String getDeviceApiKey() {
        return this.deviceApiKey;
    }

    public final String getLocalIpAddress() {
        return this.localIpAddress;
    }

    public final String getLocalIpAddressReportingDate() {
        return this.localIpAddressReportingDate;
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

    public final Links get_links() {
        return this._links;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceInformation() {
        /*
            r19 = this;
            r0 = r19
            r1 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)
            r7 = r8
            media.tiger.tigerbox.model.dto.DeviceInformation$Production r2 = new media.tiger.tigerbox.model.dto.DeviceInformation$Production
            r10 = r2
            java.lang.String r3 = ""
            r2.<init>(r1, r3, r3)
            r2 = 0
            java.lang.String r3 = ""
            java.lang.String r4 = ""
            java.lang.String r5 = ""
            r6 = 0
            java.lang.String r9 = ""
            java.lang.String r11 = ""
            java.lang.String r12 = ""
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            java.lang.String r15 = ""
            java.lang.String r16 = ""
            java.lang.String r17 = ""
            r18 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.model.dto.DeviceInformation.<init>():void");
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Production;", "", "id", "", "importDate", "", "notes", "(ILjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getImportDate", "()Ljava/lang/String;", "getNotes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DeviceInformation.kt */
    public static final class Production {

        /* renamed from: id */
        private final int f638id;
        private final String importDate;
        private final String notes;

        public static /* synthetic */ Production copy$default(Production production, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = production.f638id;
            }
            if ((i2 & 2) != 0) {
                str = production.importDate;
            }
            if ((i2 & 4) != 0) {
                str2 = production.notes;
            }
            return production.copy(i, str, str2);
        }

        public final int component1() {
            return this.f638id;
        }

        public final String component2() {
            return this.importDate;
        }

        public final String component3() {
            return this.notes;
        }

        public final Production copy(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "importDate");
            Intrinsics.checkNotNullParameter(str2, "notes");
            return new Production(i, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Production)) {
                return false;
            }
            Production production = (Production) obj;
            return this.f638id == production.f638id && Intrinsics.areEqual((Object) this.importDate, (Object) production.importDate) && Intrinsics.areEqual((Object) this.notes, (Object) production.notes);
        }

        public int hashCode() {
            return (((this.f638id * 31) + this.importDate.hashCode()) * 31) + this.notes.hashCode();
        }

        public String toString() {
            return "Production(id=" + this.f638id + ", importDate=" + this.importDate + ", notes=" + this.notes + ')';
        }

        public Production(int i, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "importDate");
            Intrinsics.checkNotNullParameter(str2, "notes");
            this.f638id = i;
            this.importDate = str;
            this.notes = str2;
        }

        public final int getId() {
            return this.f638id;
        }

        public final String getImportDate() {
            return this.importDate;
        }

        public final String getNotes() {
            return this.notes;
        }
    }

    @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Links;", "", "self", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Links$Link;", "(Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Links$Link;)V", "getSelf", "()Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Links$Link;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Link", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DeviceInformation.kt */
    public static final class Links {
        private final Link self;

        public static /* synthetic */ Links copy$default(Links links, Link link, int i, Object obj) {
            if ((i & 1) != 0) {
                link = links.self;
            }
            return links.copy(link);
        }

        public final Link component1() {
            return this.self;
        }

        public final Links copy(Link link) {
            return new Links(link);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Links) && Intrinsics.areEqual((Object) this.self, (Object) ((Links) obj).self);
        }

        public int hashCode() {
            Link link = this.self;
            if (link == null) {
                return 0;
            }
            return link.hashCode();
        }

        public String toString() {
            return "Links(self=" + this.self + ')';
        }

        @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/DeviceInformation$Links$Link;", "", "href", "", "(Ljava/lang/String;)V", "getHref", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: DeviceInformation.kt */
        public static final class Link {
            private final String href;

            public static /* synthetic */ Link copy$default(Link link, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = link.href;
                }
                return link.copy(str);
            }

            public final String component1() {
                return this.href;
            }

            public final Link copy(String str) {
                Intrinsics.checkNotNullParameter(str, "href");
                return new Link(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Link) && Intrinsics.areEqual((Object) this.href, (Object) ((Link) obj).href);
            }

            public int hashCode() {
                return this.href.hashCode();
            }

            public String toString() {
                return "Link(href=" + this.href + ')';
            }

            public Link(String str) {
                Intrinsics.checkNotNullParameter(str, "href");
                this.href = str;
            }

            public final String getHref() {
                return this.href;
            }
        }

        public Links(Link link) {
            this.self = link;
        }

        public final Link getSelf() {
            return this.self;
        }
    }
}
