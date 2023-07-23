package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/AssignBoxToAccountParameters;", "", "accessToken", "", "deviceId", "deviceCredential", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getDeviceCredential", "getDeviceId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AssignBoxToAccountUseCase.kt */
public final class AssignBoxToAccountParameters {
    private final String accessToken;
    private final String deviceCredential;
    private final String deviceId;

    public static /* synthetic */ AssignBoxToAccountParameters copy$default(AssignBoxToAccountParameters assignBoxToAccountParameters, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = assignBoxToAccountParameters.accessToken;
        }
        if ((i & 2) != 0) {
            str2 = assignBoxToAccountParameters.deviceId;
        }
        if ((i & 4) != 0) {
            str3 = assignBoxToAccountParameters.deviceCredential;
        }
        return assignBoxToAccountParameters.copy(str, str2, str3);
    }

    public final String component1() {
        return this.accessToken;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.deviceCredential;
    }

    public final AssignBoxToAccountParameters copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "deviceId");
        Intrinsics.checkNotNullParameter(str3, "deviceCredential");
        return new AssignBoxToAccountParameters(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AssignBoxToAccountParameters)) {
            return false;
        }
        AssignBoxToAccountParameters assignBoxToAccountParameters = (AssignBoxToAccountParameters) obj;
        return Intrinsics.areEqual((Object) this.accessToken, (Object) assignBoxToAccountParameters.accessToken) && Intrinsics.areEqual((Object) this.deviceId, (Object) assignBoxToAccountParameters.deviceId) && Intrinsics.areEqual((Object) this.deviceCredential, (Object) assignBoxToAccountParameters.deviceCredential);
    }

    public int hashCode() {
        return (((this.accessToken.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.deviceCredential.hashCode();
    }

    public String toString() {
        return "AssignBoxToAccountParameters(accessToken=" + this.accessToken + ", deviceId=" + this.deviceId + ", deviceCredential=" + this.deviceCredential + ')';
    }

    public AssignBoxToAccountParameters(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(str2, "deviceId");
        Intrinsics.checkNotNullParameter(str3, "deviceCredential");
        this.accessToken = str;
        this.deviceId = str2;
        this.deviceCredential = str3;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getDeviceCredential() {
        return this.deviceCredential;
    }
}
