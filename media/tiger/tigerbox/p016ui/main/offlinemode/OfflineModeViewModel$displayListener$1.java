package media.tiger.tigerbox.p016ui.main.offlinemode;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.HardwareEventSubscriber;

@Metadata(mo33736d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel$displayListener$1", "Lmedia/tiger/tigerbox/services/interfaces/HardwareEventSubscriber;", "Lmedia/tiger/tigerbox/services/implementations/DisplayService$DisplayState;", "", "onError", "error", "(Lkotlin/Unit;)V", "onReceive", "event", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel$displayListener$1 */
/* compiled from: OfflineModeViewModel.kt */
public final class OfflineModeViewModel$displayListener$1 implements HardwareEventSubscriber<DisplayService.DisplayState, Unit> {
    final /* synthetic */ OfflineModeViewModel this$0;

    public void onError(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "error");
    }

    OfflineModeViewModel$displayListener$1(OfflineModeViewModel offlineModeViewModel) {
        this.this$0 = offlineModeViewModel;
    }

    public void onReceive(DisplayService.DisplayState displayState) {
        Intrinsics.checkNotNullParameter(displayState, NotificationCompat.CATEGORY_EVENT);
        if (displayState == DisplayService.DisplayState.TIGERBOX_DISPLAY_ON) {
            this.this$0.checkOfflineTimeLimit();
        }
    }
}
