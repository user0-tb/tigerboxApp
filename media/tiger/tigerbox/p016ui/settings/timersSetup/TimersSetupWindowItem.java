package media.tiger.tigerbox.p016ui.settings.timersSetup;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.spongycastle.i18n.MessageBundle;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowItem;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupItem;", "title", "", "idx", "", "windowStart", "windowEnd", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getIdx", "()I", "getTitle", "()Ljava/lang/String;", "getWindowEnd", "getWindowStart", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowItem */
/* compiled from: TimersSetupItem.kt */
public final class TimersSetupWindowItem extends TimersSetupItem {
    private final int idx;
    private final String title;
    private final String windowEnd;
    private final String windowStart;

    public static /* synthetic */ TimersSetupWindowItem copy$default(TimersSetupWindowItem timersSetupWindowItem, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = timersSetupWindowItem.getTitle();
        }
        if ((i2 & 2) != 0) {
            i = timersSetupWindowItem.idx;
        }
        if ((i2 & 4) != 0) {
            str2 = timersSetupWindowItem.windowStart;
        }
        if ((i2 & 8) != 0) {
            str3 = timersSetupWindowItem.windowEnd;
        }
        return timersSetupWindowItem.copy(str, i, str2, str3);
    }

    public final String component1() {
        return getTitle();
    }

    public final int component2() {
        return this.idx;
    }

    public final String component3() {
        return this.windowStart;
    }

    public final String component4() {
        return this.windowEnd;
    }

    public final TimersSetupWindowItem copy(String str, int i, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "windowStart");
        Intrinsics.checkNotNullParameter(str3, "windowEnd");
        return new TimersSetupWindowItem(str, i, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimersSetupWindowItem)) {
            return false;
        }
        TimersSetupWindowItem timersSetupWindowItem = (TimersSetupWindowItem) obj;
        return Intrinsics.areEqual((Object) getTitle(), (Object) timersSetupWindowItem.getTitle()) && this.idx == timersSetupWindowItem.idx && Intrinsics.areEqual((Object) this.windowStart, (Object) timersSetupWindowItem.windowStart) && Intrinsics.areEqual((Object) this.windowEnd, (Object) timersSetupWindowItem.windowEnd);
    }

    public int hashCode() {
        return (((((getTitle().hashCode() * 31) + this.idx) * 31) + this.windowStart.hashCode()) * 31) + this.windowEnd.hashCode();
    }

    public String toString() {
        return "TimersSetupWindowItem(title=" + getTitle() + ", idx=" + this.idx + ", windowStart=" + this.windowStart + ", windowEnd=" + this.windowEnd + ')';
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimersSetupWindowItem(String str, int i, String str2, String str3) {
        super(str, str2 + " - " + str3, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, "windowStart");
        Intrinsics.checkNotNullParameter(str3, "windowEnd");
        this.title = str;
        this.idx = i;
        this.windowStart = str2;
        this.windowEnd = str3;
    }

    public final int getIdx() {
        return this.idx;
    }

    public String getTitle() {
        return this.title;
    }

    public final String getWindowEnd() {
        return this.windowEnd;
    }

    public final String getWindowStart() {
        return this.windowStart;
    }
}
