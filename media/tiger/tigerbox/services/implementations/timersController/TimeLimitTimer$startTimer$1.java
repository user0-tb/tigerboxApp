package media.tiger.tigerbox.services.implementations.timersController;

import android.os.CountDownTimer;
import kotlin.Metadata;
import media.tiger.tigerbox.extension.TimeKt;
import media.tiger.tigerbox.services.interfaces.StorageService;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/timersController/TimeLimitTimer$startTimer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TimeLimitTimer.kt */
public final class TimeLimitTimer$startTimer$1 extends CountDownTimer {
    final /* synthetic */ TimeLimitTimer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TimeLimitTimer$startTimer$1(TimeLimitTimer timeLimitTimer, long j) {
        super(j, 1000);
        this.this$0 = timeLimitTimer;
    }

    public void onTick(long j) {
        int millisToSeconds = TimeKt.millisToSeconds(j) % 60;
        if (millisToSeconds + ((((millisToSeconds ^ 60) & ((-millisToSeconds) | millisToSeconds)) >> 31) & 60) == 0) {
            StorageService storageService = this.this$0.getStorageService();
            TimeLimit timeLimit = this.this$0.getStorageService().getTimeLimit();
            String currentTime = this.this$0.getTimeService().getCurrentTime();
            if (currentTime == null) {
                currentTime = "";
            }
            storageService.setTimeLimit(TimeLimit.copy$default(timeLimit, currentTime, 0, TimeKt.millisToSeconds(j), 2, (Object) null));
        }
        this.this$0.remainingTimeLimitTimerSeconds = TimeKt.millisToSeconds(j);
        this.this$0.notifyTick();
    }

    public void onFinish() {
        this.this$0.goToLockScreen();
    }
}
