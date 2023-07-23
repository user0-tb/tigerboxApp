package media.tiger.tigerbox.p016ui;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HardwareEventSubscriber;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo33737d2 = {"media/tiger/tigerbox/ui/TigerBoxActivityViewModel$resetButtonListener$1", "Lmedia/tiger/tigerbox/services/interfaces/HardwareEventSubscriber;", "Lmedia/tiger/tigerbox/services/implementations/ButtonService$ButtonEvent;", "", "onError", "error", "(Lkotlin/Unit;)V", "onReceive", "event", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.TigerBoxActivityViewModel$resetButtonListener$1 */
/* compiled from: TigerBoxActivityViewModel.kt */
public final class TigerBoxActivityViewModel$resetButtonListener$1 implements HardwareEventSubscriber<ButtonService.ButtonEvent, Unit> {
    final /* synthetic */ TigerBoxActivityViewModel this$0;

    public void onError(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "error");
    }

    TigerBoxActivityViewModel$resetButtonListener$1(TigerBoxActivityViewModel tigerBoxActivityViewModel) {
        this.this$0 = tigerBoxActivityViewModel;
    }

    public void onReceive(ButtonService.ButtonEvent buttonEvent) {
        Intrinsics.checkNotNullParameter(buttonEvent, NotificationCompat.CATEGORY_EVENT);
        if (buttonEvent == ButtonService.ButtonEvent.RESET_BUTTON_LONG_DOWN) {
            Timber.Forest.mo50221i("Reset button long pressed", new Object[0]);
            this.this$0.get_resetButtonLongPressedEvent().call();
        }
    }
}
