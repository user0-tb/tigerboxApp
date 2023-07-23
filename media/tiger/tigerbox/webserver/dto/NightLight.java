package media.tiger.tigerbox.webserver.dto;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010¨\u0006$"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/dto/NightLight;", "Ljava/io/Serializable;", "disableTime", "", "enableTime", "repeate", "", "enableTimer", "enabled", "intensity", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getDisableTime", "()Ljava/lang/String;", "getEnableTime", "getEnableTimer", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnabled", "getIntensity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRepeate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lmedia/tiger/tigerbox/webserver/dto/NightLight;", "equals", "other", "", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DeviceInfoDto.kt */
public final class NightLight implements Serializable {
    private final String disableTime;
    private final String enableTime;
    private final Boolean enableTimer;
    private final Boolean enabled;
    private final Integer intensity;
    private final Boolean repeate;

    public static /* synthetic */ NightLight copy$default(NightLight nightLight, String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nightLight.disableTime;
        }
        if ((i & 2) != 0) {
            str2 = nightLight.enableTime;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            bool = nightLight.repeate;
        }
        Boolean bool4 = bool;
        if ((i & 8) != 0) {
            bool2 = nightLight.enableTimer;
        }
        Boolean bool5 = bool2;
        if ((i & 16) != 0) {
            bool3 = nightLight.enabled;
        }
        Boolean bool6 = bool3;
        if ((i & 32) != 0) {
            num = nightLight.intensity;
        }
        return nightLight.copy(str, str3, bool4, bool5, bool6, num);
    }

    public final String component1() {
        return this.disableTime;
    }

    public final String component2() {
        return this.enableTime;
    }

    public final Boolean component3() {
        return this.repeate;
    }

    public final Boolean component4() {
        return this.enableTimer;
    }

    public final Boolean component5() {
        return this.enabled;
    }

    public final Integer component6() {
        return this.intensity;
    }

    public final NightLight copy(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
        return new NightLight(str, str2, bool, bool2, bool3, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NightLight)) {
            return false;
        }
        NightLight nightLight = (NightLight) obj;
        return Intrinsics.areEqual((Object) this.disableTime, (Object) nightLight.disableTime) && Intrinsics.areEqual((Object) this.enableTime, (Object) nightLight.enableTime) && Intrinsics.areEqual((Object) this.repeate, (Object) nightLight.repeate) && Intrinsics.areEqual((Object) this.enableTimer, (Object) nightLight.enableTimer) && Intrinsics.areEqual((Object) this.enabled, (Object) nightLight.enabled) && Intrinsics.areEqual((Object) this.intensity, (Object) nightLight.intensity);
    }

    public int hashCode() {
        String str = this.disableTime;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.enableTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.repeate;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.enableTimer;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.enabled;
        int hashCode5 = (hashCode4 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num = this.intensity;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "NightLight(disableTime=" + this.disableTime + ", enableTime=" + this.enableTime + ", repeate=" + this.repeate + ", enableTimer=" + this.enableTimer + ", enabled=" + this.enabled + ", intensity=" + this.intensity + ')';
    }

    public NightLight(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Integer num) {
        this.disableTime = str;
        this.enableTime = str2;
        this.repeate = bool;
        this.enableTimer = bool2;
        this.enabled = bool3;
        this.intensity = num;
    }

    public final String getDisableTime() {
        return this.disableTime;
    }

    public final String getEnableTime() {
        return this.enableTime;
    }

    public final Boolean getRepeate() {
        return this.repeate;
    }

    public final Boolean getEnableTimer() {
        return this.enableTimer;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final Integer getIntensity() {
        return this.intensity;
    }
}
