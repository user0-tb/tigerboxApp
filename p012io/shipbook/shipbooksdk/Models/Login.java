package p012io.shipbook.shipbooksdk.Models;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p012io.shipbook.shipbooksdk.Models.User;
import p012io.shipbook.shipbooksdk.Networking.SessionManager;
import p012io.shipbook.shipbooksdk.Util.DateHelper;
import p012io.shipbook.shipbooksdk.Util.DateHelperKt;

@Metadata(mo33736d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 T2\u00020\u0001:\u0001TBÁ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u000eHÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0016HÆ\u0003J\t\u0010B\u001a\u00020\u0016HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\tHÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003JÉ\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010M\u001a\u00020\u00162\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\u000eHÖ\u0001J\b\u0010Q\u001a\u00020RH\u0016J\t\u0010S\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010!R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010,R\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010,R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001cR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b2\u0010#R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b3\u0010)R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001cR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006U"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/Login;", "Lio/shipbook/shipbooksdk/Models/BaseObj;", "appId", "", "appKey", "os", "appName", "udid", "time", "Ljava/util/Date;", "deviceTime", "osVersion", "appVersion", "appVersionCode", "", "sdkVersion", "sdkVersionCode", "manufacturer", "deviceModel", "deviceName", "language", "isDebug", "", "isObfuscated", "user", "Lio/shipbook/shipbooksdk/Models/User;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLio/shipbook/shipbooksdk/Models/User;)V", "getAppId", "()Ljava/lang/String;", "getAppKey", "getAppName", "getAppVersion", "setAppVersion", "(Ljava/lang/String;)V", "getAppVersionCode", "()I", "setAppVersionCode", "(I)V", "getDeviceModel", "getDeviceName", "getDeviceTime", "()Ljava/util/Date;", "setDeviceTime", "(Ljava/util/Date;)V", "()Z", "getLanguage", "getManufacturer", "getOs", "getOsVersion", "getSdkVersion", "getSdkVersionCode", "getTime", "getUdid", "getUser", "()Lio/shipbook/shipbooksdk/Models/User;", "setUser", "(Lio/shipbook/shipbooksdk/Models/User;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.Login */
/* compiled from: Login.kt */
public final class Login implements BaseObj {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String appId;
    private final String appKey;
    private final String appName;
    private String appVersion;
    private int appVersionCode;
    private final String deviceModel;
    private final String deviceName;
    private Date deviceTime;
    private final boolean isDebug;
    private final boolean isObfuscated;
    private final String language;
    private final String manufacturer;

    /* renamed from: os */
    private final String f545os;
    private final String osVersion;
    private final String sdkVersion;
    private final int sdkVersionCode;
    private final Date time;
    private final String udid;
    private User user;

    public static /* synthetic */ Login copy$default(Login login, String str, String str2, String str3, String str4, String str5, Date date, Date date2, String str6, String str7, int i, String str8, int i2, String str9, String str10, String str11, String str12, boolean z, boolean z2, User user2, int i3, Object obj) {
        Login login2 = login;
        int i4 = i3;
        return login.copy((i4 & 1) != 0 ? login2.appId : str, (i4 & 2) != 0 ? login2.appKey : str2, (i4 & 4) != 0 ? login2.f545os : str3, (i4 & 8) != 0 ? login2.appName : str4, (i4 & 16) != 0 ? login2.udid : str5, (i4 & 32) != 0 ? login2.time : date, (i4 & 64) != 0 ? login2.deviceTime : date2, (i4 & 128) != 0 ? login2.osVersion : str6, (i4 & 256) != 0 ? login2.appVersion : str7, (i4 & 512) != 0 ? login2.appVersionCode : i, (i4 & 1024) != 0 ? login2.sdkVersion : str8, (i4 & 2048) != 0 ? login2.sdkVersionCode : i2, (i4 & 4096) != 0 ? login2.manufacturer : str9, (i4 & 8192) != 0 ? login2.deviceModel : str10, (i4 & 16384) != 0 ? login2.deviceName : str11, (i4 & 32768) != 0 ? login2.language : str12, (i4 & 65536) != 0 ? login2.isDebug : z, (i4 & 131072) != 0 ? login2.isObfuscated : z2, (i4 & 262144) != 0 ? login2.user : user2);
    }

    public final String component1() {
        return this.appId;
    }

    public final int component10() {
        return this.appVersionCode;
    }

    public final String component11() {
        return this.sdkVersion;
    }

    public final int component12() {
        return this.sdkVersionCode;
    }

    public final String component13() {
        return this.manufacturer;
    }

    public final String component14() {
        return this.deviceModel;
    }

    public final String component15() {
        return this.deviceName;
    }

    public final String component16() {
        return this.language;
    }

    public final boolean component17() {
        return this.isDebug;
    }

    public final boolean component18() {
        return this.isObfuscated;
    }

    public final User component19() {
        return this.user;
    }

    public final String component2() {
        return this.appKey;
    }

    public final String component3() {
        return this.f545os;
    }

    public final String component4() {
        return this.appName;
    }

    public final String component5() {
        return this.udid;
    }

    public final Date component6() {
        return this.time;
    }

    public final Date component7() {
        return this.deviceTime;
    }

    public final String component8() {
        return this.osVersion;
    }

    public final String component9() {
        return this.appVersion;
    }

    public final Login copy(String str, String str2, String str3, String str4, String str5, Date date, Date date2, String str6, String str7, int i, String str8, int i2, String str9, String str10, String str11, String str12, boolean z, boolean z2, User user2) {
        String str13 = str;
        Intrinsics.checkNotNullParameter(str13, "appId");
        Intrinsics.checkNotNullParameter(str2, "appKey");
        Intrinsics.checkNotNullParameter(str3, "os");
        Intrinsics.checkNotNullParameter(str4, "appName");
        Intrinsics.checkNotNullParameter(str5, "udid");
        Intrinsics.checkNotNullParameter(date, "time");
        Intrinsics.checkNotNullParameter(date2, "deviceTime");
        Intrinsics.checkNotNullParameter(str6, "osVersion");
        Intrinsics.checkNotNullParameter(str7, "appVersion");
        Intrinsics.checkNotNullParameter(str8, "sdkVersion");
        Intrinsics.checkNotNullParameter(str9, "manufacturer");
        Intrinsics.checkNotNullParameter(str10, "deviceModel");
        Intrinsics.checkNotNullParameter(str11, "deviceName");
        Intrinsics.checkNotNullParameter(str12, "language");
        return new Login(str13, str2, str3, str4, str5, date, date2, str6, str7, i, str8, i2, str9, str10, str11, str12, z, z2, user2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Login)) {
            return false;
        }
        Login login = (Login) obj;
        return Intrinsics.areEqual((Object) this.appId, (Object) login.appId) && Intrinsics.areEqual((Object) this.appKey, (Object) login.appKey) && Intrinsics.areEqual((Object) this.f545os, (Object) login.f545os) && Intrinsics.areEqual((Object) this.appName, (Object) login.appName) && Intrinsics.areEqual((Object) this.udid, (Object) login.udid) && Intrinsics.areEqual((Object) this.time, (Object) login.time) && Intrinsics.areEqual((Object) this.deviceTime, (Object) login.deviceTime) && Intrinsics.areEqual((Object) this.osVersion, (Object) login.osVersion) && Intrinsics.areEqual((Object) this.appVersion, (Object) login.appVersion) && this.appVersionCode == login.appVersionCode && Intrinsics.areEqual((Object) this.sdkVersion, (Object) login.sdkVersion) && this.sdkVersionCode == login.sdkVersionCode && Intrinsics.areEqual((Object) this.manufacturer, (Object) login.manufacturer) && Intrinsics.areEqual((Object) this.deviceModel, (Object) login.deviceModel) && Intrinsics.areEqual((Object) this.deviceName, (Object) login.deviceName) && Intrinsics.areEqual((Object) this.language, (Object) login.language) && this.isDebug == login.isDebug && this.isObfuscated == login.isObfuscated && Intrinsics.areEqual((Object) this.user, (Object) login.user);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((((((((((((this.appId.hashCode() * 31) + this.appKey.hashCode()) * 31) + this.f545os.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.udid.hashCode()) * 31) + this.time.hashCode()) * 31) + this.deviceTime.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.appVersion.hashCode()) * 31) + this.appVersionCode) * 31) + this.sdkVersion.hashCode()) * 31) + this.sdkVersionCode) * 31) + this.manufacturer.hashCode()) * 31) + this.deviceModel.hashCode()) * 31) + this.deviceName.hashCode()) * 31) + this.language.hashCode()) * 31;
        boolean z = this.isDebug;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isObfuscated;
        if (!z3) {
            z2 = z3;
        }
        int i2 = (i + (z2 ? 1 : 0)) * 31;
        User user2 = this.user;
        return i2 + (user2 == null ? 0 : user2.hashCode());
    }

    public String toString() {
        return "Login(appId=" + this.appId + ", appKey=" + this.appKey + ", os=" + this.f545os + ", appName=" + this.appName + ", udid=" + this.udid + ", time=" + this.time + ", deviceTime=" + this.deviceTime + ", osVersion=" + this.osVersion + ", appVersion=" + this.appVersion + ", appVersionCode=" + this.appVersionCode + ", sdkVersion=" + this.sdkVersion + ", sdkVersionCode=" + this.sdkVersionCode + ", manufacturer=" + this.manufacturer + ", deviceModel=" + this.deviceModel + ", deviceName=" + this.deviceName + ", language=" + this.language + ", isDebug=" + this.isDebug + ", isObfuscated=" + this.isObfuscated + ", user=" + this.user + ')';
    }

    public Login(String str, String str2, String str3, String str4, String str5, Date date, Date date2, String str6, String str7, int i, String str8, int i2, String str9, String str10, String str11, String str12, boolean z, boolean z2, User user2) {
        String str13 = str;
        String str14 = str2;
        String str15 = str3;
        String str16 = str4;
        String str17 = str5;
        Date date3 = date;
        Date date4 = date2;
        String str18 = str6;
        String str19 = str7;
        String str20 = str8;
        String str21 = str9;
        String str22 = str10;
        String str23 = str11;
        String str24 = str12;
        Intrinsics.checkNotNullParameter(str13, "appId");
        Intrinsics.checkNotNullParameter(str14, "appKey");
        Intrinsics.checkNotNullParameter(str15, "os");
        Intrinsics.checkNotNullParameter(str16, "appName");
        Intrinsics.checkNotNullParameter(str17, "udid");
        Intrinsics.checkNotNullParameter(date3, "time");
        Intrinsics.checkNotNullParameter(date4, "deviceTime");
        Intrinsics.checkNotNullParameter(str18, "osVersion");
        Intrinsics.checkNotNullParameter(str19, "appVersion");
        Intrinsics.checkNotNullParameter(str20, "sdkVersion");
        Intrinsics.checkNotNullParameter(str21, "manufacturer");
        Intrinsics.checkNotNullParameter(str22, "deviceModel");
        Intrinsics.checkNotNullParameter(str23, "deviceName");
        Intrinsics.checkNotNullParameter(str24, "language");
        this.appId = str13;
        this.appKey = str14;
        this.f545os = str15;
        this.appName = str16;
        this.udid = str17;
        this.time = date3;
        this.deviceTime = date4;
        this.osVersion = str18;
        this.appVersion = str19;
        this.appVersionCode = i;
        this.sdkVersion = str20;
        this.sdkVersionCode = i2;
        this.manufacturer = str21;
        this.deviceModel = str22;
        this.deviceName = str23;
        this.language = str24;
        this.isDebug = z;
        this.isObfuscated = z2;
        this.user = user2;
        String str25 = "";
        if (Intrinsics.areEqual((Object) str19, (Object) str25)) {
            Context appContext = SessionManager.INSTANCE.getAppContext();
            Intrinsics.checkNotNull(appContext);
            PackageInfo packageInfo = appContext.getPackageManager().getPackageInfo(appContext.getPackageName(), 0);
            String str26 = packageInfo.versionName;
            this.appVersion = str26 != null ? str26 : str25;
            if (Build.VERSION.SDK_INT >= 28) {
                this.appVersionCode = (int) packageInfo.getLongVersionCode();
            } else {
                this.appVersionCode = packageInfo.versionCode;
            }
        }
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getOs() {
        return this.f545os;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Login(java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.util.Date r28, java.util.Date r29, java.lang.String r30, java.lang.String r31, int r32, java.lang.String r33, int r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, boolean r39, boolean r40, p012io.shipbook.shipbooksdk.Models.User r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r22 = this;
            r0 = r42
            r1 = r0 & 4
            if (r1 == 0) goto L_0x000a
            java.lang.String r1 = "android"
            r5 = r1
            goto L_0x000c
        L_0x000a:
            r5 = r25
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0026
            io.shipbook.shipbooksdk.Networking.SessionManager r1 = p012io.shipbook.shipbooksdk.Networking.SessionManager.INSTANCE
            android.content.Context r1 = r1.getAppContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo()
            java.lang.String r1 = r1.processName
            java.lang.String r2 = "SessionManager.appContex…plicationInfo.processName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r6 = r1
            goto L_0x0028
        L_0x0026:
            r6 = r26
        L_0x0028:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0045
            io.shipbook.shipbooksdk.Networking.SessionManager r1 = p012io.shipbook.shipbooksdk.Networking.SessionManager.INSTANCE
            android.content.Context r1 = r1.getAppContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.lang.String r2 = "android_id"
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r2)
            if (r1 != 0) goto L_0x0043
            java.lang.String r1 = "test_device"
        L_0x0043:
            r7 = r1
            goto L_0x0047
        L_0x0045:
            r7 = r27
        L_0x0047:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0052
            java.util.Date r1 = new java.util.Date
            r1.<init>()
            r8 = r1
            goto L_0x0054
        L_0x0052:
            r8 = r28
        L_0x0054:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x005a
            r9 = r8
            goto L_0x005c
        L_0x005a:
            r9 = r29
        L_0x005c:
            r1 = r0 & 128(0x80, float:1.794E-43)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0069
            java.lang.String r1 = android.os.Build.VERSION.RELEASE
            if (r1 != 0) goto L_0x0067
            r1 = r2
        L_0x0067:
            r10 = r1
            goto L_0x006b
        L_0x0069:
            r10 = r30
        L_0x006b:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0071
            r11 = r2
            goto L_0x0073
        L_0x0071:
            r11 = r31
        L_0x0073:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x007a
            r1 = -1
            r12 = -1
            goto L_0x007c
        L_0x007a:
            r12 = r32
        L_0x007c:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0084
            java.lang.String r1 = "1.7.0"
            r13 = r1
            goto L_0x0086
        L_0x0084:
            r13 = r33
        L_0x0086:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            r3 = 1
            if (r1 == 0) goto L_0x008d
            r14 = 1
            goto L_0x008f
        L_0x008d:
            r14 = r34
        L_0x008f:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x009a
            java.lang.String r1 = android.os.Build.MANUFACTURER
            if (r1 != 0) goto L_0x0098
            r1 = r2
        L_0x0098:
            r15 = r1
            goto L_0x009c
        L_0x009a:
            r15 = r35
        L_0x009c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x00a8
            java.lang.String r1 = android.os.Build.MODEL
            if (r1 != 0) goto L_0x00a5
            r1 = r2
        L_0x00a5:
            r16 = r1
            goto L_0x00aa
        L_0x00a8:
            r16 = r36
        L_0x00aa:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x00b6
            java.lang.String r1 = android.os.Build.DEVICE
            if (r1 != 0) goto L_0x00b3
            r1 = r2
        L_0x00b3:
            r17 = r1
            goto L_0x00b8
        L_0x00b6:
            r17 = r37
        L_0x00b8:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ce
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getLanguage()
            java.lang.String r2 = "getDefault().language"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r18 = r1
            goto L_0x00d0
        L_0x00ce:
            r18 = r38
        L_0x00d0:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00ee
            io.shipbook.shipbooksdk.Networking.SessionManager r1 = p012io.shipbook.shipbooksdk.Networking.SessionManager.INSTANCE
            android.content.Context r1 = r1.getAppContext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo()
            int r1 = r1.flags
            r1 = r1 & 2
            if (r1 == 0) goto L_0x00ea
            r1 = 1
            goto L_0x00eb
        L_0x00ea:
            r1 = 0
        L_0x00eb:
            r19 = r1
            goto L_0x00f0
        L_0x00ee:
            r19 = r39
        L_0x00f0:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0105
            java.lang.Class<io.shipbook.shipbooksdk.ShipBook> r1 = p012io.shipbook.shipbooksdk.ShipBook.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "io.shipbook.shipbooksdk.ShipBook"
            boolean r1 = r1.equals(r2)
            r1 = r1 ^ r3
            r20 = r1
            goto L_0x0107
        L_0x0105:
            r20 = r40
        L_0x0107:
            r1 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0110
            r0 = 0
            r21 = r0
            goto L_0x0112
        L_0x0110:
            r21 = r41
        L_0x0112:
            r2 = r22
            r3 = r23
            r4 = r24
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p012io.shipbook.shipbooksdk.Models.Login.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, io.shipbook.shipbooksdk.Models.User, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getUdid() {
        return this.udid;
    }

    public final Date getTime() {
        return this.time;
    }

    public final Date getDeviceTime() {
        return this.deviceTime;
    }

    public final void setDeviceTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.deviceTime = date;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appVersion = str;
    }

    public final int getAppVersionCode() {
        return this.appVersionCode;
    }

    public final void setAppVersionCode(int i) {
        this.appVersionCode = i;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final int getSdkVersionCode() {
        return this.sdkVersionCode;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final boolean isObfuscated() {
        return this.isObfuscated;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user2) {
        this.user = user2;
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/Login$Companion;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Models/Login;", "json", "Lorg/json/JSONObject;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.Login$Companion */
    /* compiled from: Login.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Login create(JSONObject jSONObject) {
            String str;
            User user;
            JSONObject jSONObject2 = jSONObject;
            Intrinsics.checkNotNullParameter(jSONObject2, "json");
            String optString = jSONObject2.optString("appId");
            String optString2 = jSONObject2.optString("appKey");
            String optString3 = jSONObject2.optString("os");
            String optString4 = jSONObject2.optString("appName");
            String optString5 = jSONObject2.optString("udid");
            DateHelper dateHelper = DateHelper.INSTANCE;
            String optString6 = jSONObject2.optString("time");
            Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"time\")");
            Date createDateStandard = dateHelper.createDateStandard(optString6);
            Intrinsics.checkNotNull(createDateStandard);
            DateHelper dateHelper2 = DateHelper.INSTANCE;
            String optString7 = jSONObject2.optString("deviceTime");
            Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(\"deviceTime\")");
            Date createDateStandard2 = dateHelper2.createDateStandard(optString7);
            Intrinsics.checkNotNull(createDateStandard2);
            String optString8 = jSONObject2.optString("osVersion");
            Date date = createDateStandard2;
            String optString9 = jSONObject2.optString("appVersion");
            String str2 = "appVersion";
            int i = jSONObject2.getInt("appVersionCode");
            Date date2 = createDateStandard;
            String optString10 = jSONObject2.optString("sdkVersion");
            String str3 = "sdkVersion";
            int i2 = jSONObject2.getInt("sdkVersionCode");
            String str4 = optString10;
            String optString11 = jSONObject2.optString("manufacturer");
            String str5 = optString9;
            String str6 = "deviceModel";
            String optString12 = jSONObject2.optString("deviceModel");
            String str7 = "deviceName";
            String optString13 = jSONObject2.optString("deviceName");
            String optString14 = jSONObject2.optString("language");
            String str8 = "manufacturer";
            boolean z = jSONObject2.getBoolean("isDebug");
            boolean z2 = jSONObject2.getBoolean("isObfuscated");
            if (jSONObject2.has("user")) {
                str = "language";
                User.Companion companion = User.Companion;
                JSONObject optJSONObject = jSONObject2.optJSONObject("user");
                Intrinsics.checkNotNullExpressionValue(optJSONObject, "json.optJSONObject(\"user\")");
                user = companion.create(optJSONObject);
            } else {
                str = "language";
                user = null;
            }
            User user2 = user;
            String str9 = str2;
            String str10 = optString14;
            Intrinsics.checkNotNullExpressionValue(optString, "appId");
            Intrinsics.checkNotNullExpressionValue(optString2, "appKey");
            Intrinsics.checkNotNullExpressionValue(optString3, "os");
            Intrinsics.checkNotNullExpressionValue(optString4, "appName");
            Intrinsics.checkNotNullExpressionValue(optString5, "udid");
            Intrinsics.checkNotNullExpressionValue(optString8, "osVersion");
            String str11 = str5;
            Intrinsics.checkNotNullExpressionValue(str11, str9);
            String str12 = str4;
            Intrinsics.checkNotNullExpressionValue(str12, str3);
            String str13 = optString11;
            Intrinsics.checkNotNullExpressionValue(str13, str8);
            String str14 = optString12;
            Intrinsics.checkNotNullExpressionValue(str14, str6);
            String str15 = optString13;
            Intrinsics.checkNotNullExpressionValue(str15, str7);
            String str16 = str10;
            Intrinsics.checkNotNullExpressionValue(str16, str);
            String str17 = str11;
            String str18 = str13;
            String str19 = str12;
            String str20 = str15;
            return new Login(optString, optString2, optString3, optString4, optString5, date2, date, optString8, str17, i, str19, i2, str18, str14, str20, str16, z, z2, user2);
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", this.appId);
        jSONObject.put("appKey", this.appKey);
        jSONObject.put("os", this.f545os);
        jSONObject.put("appName", this.appName);
        jSONObject.put("udid", this.udid);
        jSONObject.put("time", DateHelperKt.toStandardString(this.time));
        jSONObject.put("deviceTime", DateHelperKt.toStandardString(this.deviceTime));
        jSONObject.put("osVersion", this.osVersion);
        jSONObject.put("appVersion", this.appVersion);
        jSONObject.put("appVersionCode", this.appVersionCode);
        jSONObject.put("sdkVersion", this.sdkVersion);
        jSONObject.put("sdkVersionCode", this.sdkVersionCode);
        jSONObject.put("manufacturer", this.manufacturer);
        jSONObject.put("deviceModel", this.deviceModel);
        jSONObject.put("deviceName", this.deviceName);
        jSONObject.put("language", this.language);
        jSONObject.put("isDebug", this.isDebug);
        jSONObject.put("isObfuscated", this.isObfuscated);
        User user2 = this.user;
        jSONObject.putOpt("user", user2 == null ? null : user2.toJson());
        return jSONObject;
    }
}
