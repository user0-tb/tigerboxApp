package media.tiger.tigerbox.p016ui.main;

import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.FlagChangeListener;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/MainContentActivity$flagChangedListener$1", "Lmedia/tiger/tigerbox/services/interfaces/FlagChangeListener;", "flagDidChanged", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.MainContentActivity$flagChangedListener$1 */
/* compiled from: MainContentActivity.kt */
public final class MainContentActivity$flagChangedListener$1 implements FlagChangeListener {
    final /* synthetic */ MainContentActivity this$0;

    MainContentActivity$flagChangedListener$1(MainContentActivity mainContentActivity) {
        this.this$0 = mainContentActivity;
    }

    public void flagDidChanged() {
        this.this$0.updateFlagBasedUIElements();
    }
}
