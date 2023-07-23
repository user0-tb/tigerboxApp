package media.tiger.tigerbox.webserver.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/dto/WindowedTimerDto;", "", "windowedStart", "", "windowedEnd", "(Ljava/lang/String;Ljava/lang/String;)V", "getWindowedEnd", "()Ljava/lang/String;", "getWindowedStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WindowedTimerDto.kt */
public final class WindowedTimerDto {
    private final String windowedEnd;
    private final String windowedStart;

    public static /* synthetic */ WindowedTimerDto copy$default(WindowedTimerDto windowedTimerDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = windowedTimerDto.windowedStart;
        }
        if ((i & 2) != 0) {
            str2 = windowedTimerDto.windowedEnd;
        }
        return windowedTimerDto.copy(str, str2);
    }

    public final String component1() {
        return this.windowedStart;
    }

    public final String component2() {
        return this.windowedEnd;
    }

    public final WindowedTimerDto copy(String str, String str2) {
        return new WindowedTimerDto(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowedTimerDto)) {
            return false;
        }
        WindowedTimerDto windowedTimerDto = (WindowedTimerDto) obj;
        return Intrinsics.areEqual((Object) this.windowedStart, (Object) windowedTimerDto.windowedStart) && Intrinsics.areEqual((Object) this.windowedEnd, (Object) windowedTimerDto.windowedEnd);
    }

    public int hashCode() {
        String str = this.windowedStart;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.windowedEnd;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "WindowedTimerDto(windowedStart=" + this.windowedStart + ", windowedEnd=" + this.windowedEnd + ')';
    }

    public WindowedTimerDto(String str, String str2) {
        this.windowedStart = str;
        this.windowedEnd = str2;
    }

    public final String getWindowedStart() {
        return this.windowedStart;
    }

    public final String getWindowedEnd() {
        return this.windowedEnd;
    }
}
