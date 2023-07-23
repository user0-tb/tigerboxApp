package media.tiger.tigerbox.services.implementations.timersController;

import android.os.CountDownTimer;
import kotlin.Metadata;
import media.tiger.tigerbox.extension.TimeKt;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/timersController/ShutDownTimer$startTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ShutDownTimer.kt */
public final class ShutDownTimer$startTimer$1 extends CountDownTimer {
    final /* synthetic */ ShutDownTimer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShutDownTimer$startTimer$1(ShutDownTimer shutDownTimer, long j) {
        super(j, 1000);
        this.this$0 = shutDownTimer;
    }

    public void onTick(long j) {
        this.this$0.setCurrentShutDownTimeSeconds(TimeKt.millisToSeconds(j));
        ShutDownTimer shutDownTimer = this.this$0;
        shutDownTimer.notifyTick(shutDownTimer.getCurrentShutDownTimeSeconds());
    }

    public void onFinish() {
        this.this$0.setCurrentShutDownTimeSeconds(0);
        this.this$0.setInitialShutDownTimeSeconds(0);
        this.this$0.powerManagementService.shutDown();
    }
}
