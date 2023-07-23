package media.tiger.tigerbox.webserver.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/dto/LogoLight;", "", "enabled", "", "intensity", "", "(Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIntensity", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;)Lmedia/tiger/tigerbox/webserver/dto/LogoLight;", "equals", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DeviceInfoDto.kt */
public final class LogoLight {
    private final Boolean enabled;
    private final Integer intensity;

    public static /* synthetic */ LogoLight copy$default(LogoLight logoLight, Boolean bool, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = logoLight.enabled;
        }
        if ((i & 2) != 0) {
            num = logoLight.intensity;
        }
        return logoLight.copy(bool, num);
    }

    public final Boolean component1() {
        return this.enabled;
    }

    public final Integer component2() {
        return this.intensity;
    }

    public final LogoLight copy(Boolean bool, Integer num) {
        return new LogoLight(bool, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogoLight)) {
            return false;
        }
        LogoLight logoLight = (LogoLight) obj;
        return Intrinsics.areEqual((Object) this.enabled, (Object) logoLight.enabled) && Intrinsics.areEqual((Object) this.intensity, (Object) logoLight.intensity);
    }

    public int hashCode() {
        Boolean bool = this.enabled;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.intensity;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "LogoLight(enabled=" + this.enabled + ", intensity=" + this.intensity + ')';
    }

    public LogoLight(Boolean bool, Integer num) {
        this.enabled = bool;
        this.intensity = num;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final Integer getIntensity() {
        return this.intensity;
    }
}
