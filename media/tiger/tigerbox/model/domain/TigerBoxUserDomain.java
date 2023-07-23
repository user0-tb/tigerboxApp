package media.tiger.tigerbox.model.domain;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/TigerBoxUserDomain;", "", "()V", "profileId", "", "accountId", "activeProfileId", "email", "", "pin", "(IIILjava/lang/String;Ljava/lang/String;)V", "getAccountId", "()I", "getActiveProfileId", "getEmail", "()Ljava/lang/String;", "getPin", "getProfileId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserDomain.kt */
public final class TigerBoxUserDomain {
    private final int accountId;
    private final int activeProfileId;
    private final String email;
    private final String pin;
    private final int profileId;

    public static /* synthetic */ TigerBoxUserDomain copy$default(TigerBoxUserDomain tigerBoxUserDomain, int i, int i2, int i3, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = tigerBoxUserDomain.profileId;
        }
        if ((i4 & 2) != 0) {
            i2 = tigerBoxUserDomain.accountId;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = tigerBoxUserDomain.activeProfileId;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            str = tigerBoxUserDomain.email;
        }
        String str3 = str;
        if ((i4 & 16) != 0) {
            str2 = tigerBoxUserDomain.pin;
        }
        return tigerBoxUserDomain.copy(i, i5, i6, str3, str2);
    }

    public final int component1() {
        return this.profileId;
    }

    public final int component2() {
        return this.accountId;
    }

    public final int component3() {
        return this.activeProfileId;
    }

    public final String component4() {
        return this.email;
    }

    public final String component5() {
        return this.pin;
    }

    public final TigerBoxUserDomain copy(int i, int i2, int i3, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        return new TigerBoxUserDomain(i, i2, i3, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TigerBoxUserDomain)) {
            return false;
        }
        TigerBoxUserDomain tigerBoxUserDomain = (TigerBoxUserDomain) obj;
        return this.profileId == tigerBoxUserDomain.profileId && this.accountId == tigerBoxUserDomain.accountId && this.activeProfileId == tigerBoxUserDomain.activeProfileId && Intrinsics.areEqual((Object) this.email, (Object) tigerBoxUserDomain.email) && Intrinsics.areEqual((Object) this.pin, (Object) tigerBoxUserDomain.pin);
    }

    public int hashCode() {
        int hashCode = ((((((this.profileId * 31) + this.accountId) * 31) + this.activeProfileId) * 31) + this.email.hashCode()) * 31;
        String str = this.pin;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "TigerBoxUserDomain(profileId=" + this.profileId + ", accountId=" + this.accountId + ", activeProfileId=" + this.activeProfileId + ", email=" + this.email + ", pin=" + this.pin + ')';
    }

    public TigerBoxUserDomain(int i, int i2, int i3, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        this.profileId = i;
        this.accountId = i2;
        this.activeProfileId = i3;
        this.email = str;
        this.pin = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TigerBoxUserDomain(int r4, int r5, int r6, java.lang.String r7, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = -1
            if (r10 == 0) goto L_0x0007
            r10 = -1
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = -1
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = r6
        L_0x0015:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001b
            java.lang.String r7 = ""
        L_0x001b:
            r2 = r7
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0021
            r8 = 0
        L_0x0021:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r0
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.model.domain.TigerBoxUserDomain.<init>(int, int, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getProfileId() {
        return this.profileId;
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final int getActiveProfileId() {
        return this.activeProfileId;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPin() {
        return this.pin;
    }

    public TigerBoxUserDomain() {
        this(-1, -1, -1, "", (String) null);
    }
}
