package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.timersController.LockedModeListener;
import media.tiger.tigerbox.services.implementations.timersController.LockedModeReason;

@Metadata(mo33736d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/HeaderBarProvider$lockedModeListener$1", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeListener;", "onDisableLockScreen", "", "onEnableLockScreen", "reason", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "onTimeLimitTick", "remainingSeconds", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeaderBarProvider.kt */
public final class HeaderBarProvider$lockedModeListener$1 implements LockedModeListener {
    final /* synthetic */ HeaderBarProvider this$0;

    HeaderBarProvider$lockedModeListener$1(HeaderBarProvider headerBarProvider) {
        this.this$0 = headerBarProvider;
    }

    public void onEnableLockScreen(LockedModeReason lockedModeReason) {
        Intrinsics.checkNotNullParameter(lockedModeReason, "reason");
        this.this$0.audioPlayerService.stop();
        this.this$0._lockedMode.postValue(lockedModeReason);
    }

    public void onDisableLockScreen() {
        this.this$0._lockedMode.postValue(LockedModeReason.NONE);
    }

    public void onTimeLimitTick(int i) {
        this.this$0._timeLimitTick.postValue(Integer.valueOf(i));
    }
}
