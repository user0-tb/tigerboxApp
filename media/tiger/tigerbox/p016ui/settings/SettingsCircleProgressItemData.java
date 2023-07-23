package media.tiger.tigerbox.p016ui.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsCircleProgressItemData;", "Lmedia/tiger/tigerbox/ui/settings/SettingsItemData;", "circleItemBottomText", "", "circleItemIcon", "(II)V", "getCircleItemBottomText", "()I", "getCircleItemIcon", "circleItemText", "", "getCircleItemText", "()Ljava/lang/String;", "setCircleItemText", "(Ljava/lang/String;)V", "progress", "getProgress", "setProgress", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsCircleProgressItemData */
/* compiled from: SettingsItemData.kt */
public final class SettingsCircleProgressItemData extends SettingsItemData {
    private final int circleItemBottomText;
    private final int circleItemIcon;
    private String circleItemText = " ";
    private int progress;

    public static /* synthetic */ SettingsCircleProgressItemData copy$default(SettingsCircleProgressItemData settingsCircleProgressItemData, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = settingsCircleProgressItemData.circleItemBottomText;
        }
        if ((i3 & 2) != 0) {
            i2 = settingsCircleProgressItemData.circleItemIcon;
        }
        return settingsCircleProgressItemData.copy(i, i2);
    }

    public final int component1() {
        return this.circleItemBottomText;
    }

    public final int component2() {
        return this.circleItemIcon;
    }

    public final SettingsCircleProgressItemData copy(int i, int i2) {
        return new SettingsCircleProgressItemData(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingsCircleProgressItemData)) {
            return false;
        }
        SettingsCircleProgressItemData settingsCircleProgressItemData = (SettingsCircleProgressItemData) obj;
        return this.circleItemBottomText == settingsCircleProgressItemData.circleItemBottomText && this.circleItemIcon == settingsCircleProgressItemData.circleItemIcon;
    }

    public int hashCode() {
        return (this.circleItemBottomText * 31) + this.circleItemIcon;
    }

    public String toString() {
        return "SettingsCircleProgressItemData(circleItemBottomText=" + this.circleItemBottomText + ", circleItemIcon=" + this.circleItemIcon + ')';
    }

    public final int getCircleItemBottomText() {
        return this.circleItemBottomText;
    }

    public final int getCircleItemIcon() {
        return this.circleItemIcon;
    }

    public SettingsCircleProgressItemData(int i, int i2) {
        super(i, i2);
        this.circleItemBottomText = i;
        this.circleItemIcon = i2;
    }

    public final String getCircleItemText() {
        return this.circleItemText;
    }

    public final void setCircleItemText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.circleItemText = str;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }
}
