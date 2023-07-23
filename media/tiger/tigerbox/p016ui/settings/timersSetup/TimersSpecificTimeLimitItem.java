package media.tiger.tigerbox.p016ui.settings.timersSetup;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSpecificTimeLimitItem;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersTimeLimitItem;", "title", "", "selected", "", "(IZ)V", "getSelected", "()Z", "setSelected", "(Z)V", "getTitle", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSpecificTimeLimitItem */
/* compiled from: TimersSetupItem.kt */
public final class TimersSpecificTimeLimitItem extends TimersTimeLimitItem {
    private boolean selected;
    private final int title;

    public static /* synthetic */ TimersSpecificTimeLimitItem copy$default(TimersSpecificTimeLimitItem timersSpecificTimeLimitItem, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = timersSpecificTimeLimitItem.getTitle();
        }
        if ((i2 & 2) != 0) {
            z = timersSpecificTimeLimitItem.getSelected();
        }
        return timersSpecificTimeLimitItem.copy(i, z);
    }

    public final int component1() {
        return getTitle();
    }

    public final boolean component2() {
        return getSelected();
    }

    public final TimersSpecificTimeLimitItem copy(int i, boolean z) {
        return new TimersSpecificTimeLimitItem(i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimersSpecificTimeLimitItem)) {
            return false;
        }
        TimersSpecificTimeLimitItem timersSpecificTimeLimitItem = (TimersSpecificTimeLimitItem) obj;
        return getTitle() == timersSpecificTimeLimitItem.getTitle() && getSelected() == timersSpecificTimeLimitItem.getSelected();
    }

    public int hashCode() {
        int title2 = getTitle() * 31;
        boolean selected2 = getSelected();
        if (selected2) {
            selected2 = true;
        }
        return title2 + (selected2 ? 1 : 0);
    }

    public String toString() {
        return "TimersSpecificTimeLimitItem(title=" + getTitle() + ", selected=" + getSelected() + ')';
    }

    public TimersSpecificTimeLimitItem(int i, boolean z) {
        super(i, z, (DefaultConstructorMarker) null);
        this.title = i;
        this.selected = z;
    }

    public boolean getSelected() {
        return this.selected;
    }

    public int getTitle() {
        return this.title;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }
}
