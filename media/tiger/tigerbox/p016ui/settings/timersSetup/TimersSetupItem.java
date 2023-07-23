package media.tiger.tigerbox.p016ui.settings.timersSetup;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupItem;", "", "title", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getValue", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupTitleItem;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitItem;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupSleepItem;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowItem;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupAddWindowItem;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupItem */
/* compiled from: TimersSetupItem.kt */
public abstract class TimersSetupItem {
    private final String title;
    private final String value;

    public /* synthetic */ TimersSetupItem(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    private TimersSetupItem(String str, String str2) {
        this.title = str;
        this.value = str2;
    }

    public String getTitle() {
        return this.title;
    }

    public String getValue() {
        return this.value;
    }
}
