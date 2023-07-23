package p012io.shipbook.shipbooksdk.Models;

import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0001#BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J[\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020!H\u0016J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006$"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/User;", "Lio/shipbook/shipbooksdk/Models/BaseObj;", "userId", "", "userName", "fullName", "email", "phoneNumber", "additionalInfo", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAdditionalInfo", "()Ljava/util/Map;", "getEmail", "()Ljava/lang/String;", "getFullName", "getPhoneNumber", "getUserId", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.User */
/* compiled from: User.kt */
public final class User implements BaseObj {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Map<String, String> additionalInfo;
    private final String email;
    private final String fullName;
    private final String phoneNumber;
    private final String userId;
    private final String userName;

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, String str4, String str5, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = user.userId;
        }
        if ((i & 2) != 0) {
            str2 = user.userName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = user.fullName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = user.email;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = user.phoneNumber;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            map = user.additionalInfo;
        }
        return user.copy(str, str6, str7, str8, str9, map);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.userName;
    }

    public final String component3() {
        return this.fullName;
    }

    public final String component4() {
        return this.email;
    }

    public final String component5() {
        return this.phoneNumber;
    }

    public final Map<String, String> component6() {
        return this.additionalInfo;
    }

    public final User copy(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "userId");
        return new User(str, str2, str3, str4, str5, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) user.userId) && Intrinsics.areEqual((Object) this.userName, (Object) user.userName) && Intrinsics.areEqual((Object) this.fullName, (Object) user.fullName) && Intrinsics.areEqual((Object) this.email, (Object) user.email) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) user.phoneNumber) && Intrinsics.areEqual((Object) this.additionalInfo, (Object) user.additionalInfo);
    }

    public int hashCode() {
        int hashCode = this.userId.hashCode() * 31;
        String str = this.userName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fullName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.email;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.phoneNumber;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Map<String, String> map = this.additionalInfo;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "User(userId=" + this.userId + ", userName=" + this.userName + ", fullName=" + this.fullName + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", additionalInfo=" + this.additionalInfo + ')';
    }

    public User(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "userId");
        this.userId = str;
        this.userName = str2;
        this.fullName = str3;
        this.email = str4;
        this.phoneNumber = str5;
        this.additionalInfo = map;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ User(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.util.Map r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r6 = this;
            r0 = r13 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r8
        L_0x0008:
            r2 = r13 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r9
        L_0x000f:
            r3 = r13 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r10
        L_0x0016:
            r4 = r13 & 16
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x001d
        L_0x001c:
            r4 = r11
        L_0x001d:
            r5 = r13 & 32
            if (r5 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r12
        L_0x0023:
            r8 = r6
            r9 = r7
            r10 = r0
            r11 = r2
            r12 = r3
            r13 = r4
            r14 = r1
            r8.<init>(r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p012io.shipbook.shipbooksdk.Models.User.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final Map<String, String> getAdditionalInfo() {
        return this.additionalInfo;
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/User$Companion;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Models/User;", "json", "Lorg/json/JSONObject;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.User$Companion */
    /* compiled from: User.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final User create(JSONObject jSONObject) {
            Map map;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = jSONObject.optString("userId");
            String optString2 = jSONObject.optString("userName", (String) null);
            String optString3 = jSONObject.optString("fullName", (String) null);
            String optString4 = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL, (String) null);
            String optString5 = jSONObject.optString("phoneNumber", (String) null);
            JSONObject optJSONObject = jSONObject.optJSONObject("additionalInfo");
            if (optJSONObject != null) {
                Map linkedHashMap = new LinkedHashMap();
                Iterator<String> keys = optJSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "additionalInfoObject.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    Intrinsics.checkNotNullExpressionValue(next, "it");
                    String optString6 = optJSONObject.optString(next);
                    Intrinsics.checkNotNullExpressionValue(optString6, "additionalInfoObject.optString(it)");
                    linkedHashMap.put(next, optString6);
                }
                map = linkedHashMap;
            } else {
                map = null;
            }
            Intrinsics.checkNotNullExpressionValue(optString, "userId");
            return new User(optString, optString2, optString3, optString4, optString5, map);
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("userId", this.userId);
        jSONObject.putOpt("userName", this.userName);
        jSONObject.putOpt("fullName", this.fullName);
        jSONObject.putOpt(NotificationCompat.CATEGORY_EMAIL, this.email);
        jSONObject.putOpt("phoneNumber", this.phoneNumber);
        if (this.additionalInfo != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry : this.additionalInfo.entrySet()) {
                jSONObject2.put((String) entry.getKey(), entry.getValue());
            }
            jSONObject.putOpt("additionalInfo", jSONObject2);
        }
        return jSONObject;
    }
}
