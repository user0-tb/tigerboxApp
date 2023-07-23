package media.tiger.tigerbox.p016ui.settings.systeminfo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/systeminfo/SystemInfoItem;", "", "label", "", "value", "", "(ILjava/lang/String;)V", "id", "getId", "()I", "getLabel", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoItem */
/* compiled from: SystemInfoItem.kt */
public final class SystemInfoItem {
    private final int label;
    private final String value;

    public static /* synthetic */ SystemInfoItem copy$default(SystemInfoItem systemInfoItem, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = systemInfoItem.label;
        }
        if ((i2 & 2) != 0) {
            str = systemInfoItem.value;
        }
        return systemInfoItem.copy(i, str);
    }

    public final int component1() {
        return this.label;
    }

    public final String component2() {
        return this.value;
    }

    public final SystemInfoItem copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new SystemInfoItem(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemInfoItem)) {
            return false;
        }
        SystemInfoItem systemInfoItem = (SystemInfoItem) obj;
        return this.label == systemInfoItem.label && Intrinsics.areEqual((Object) this.value, (Object) systemInfoItem.value);
    }

    public int hashCode() {
        return (this.label * 31) + this.value.hashCode();
    }

    public String toString() {
        return "SystemInfoItem(label=" + this.label + ", value=" + this.value + ')';
    }

    public SystemInfoItem(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.label = i;
        this.value = str;
    }

    public final int getLabel() {
        return this.label;
    }

    public final String getValue() {
        return this.value;
    }

    public final int getId() {
        return this.label;
    }
}
