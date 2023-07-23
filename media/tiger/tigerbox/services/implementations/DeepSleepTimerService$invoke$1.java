package media.tiger.tigerbox.services.implementations;

import android.os.CountDownTimer;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/DeepSleepTimerService$invoke$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DeepSleepTimerService.kt */
public final class DeepSleepTimerService$invoke$1 extends CountDownTimer {
    final /* synthetic */ DeepSleepTimerService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeepSleepTimerService$invoke$1(DeepSleepTimerService deepSleepTimerService, long j) {
        super(j, 1000);
        this.this$0 = deepSleepTimerService;
    }

    public void onTick(long j) {
        long j2 = j / ((long) 1000);
        if (((int) j2) % 5 == 0) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50214d("Deep sleep tick: [" + j2 + ']', new Object[0]);
        }
    }

    public void onFinish() {
        Timber.Forest.mo50214d("Deep sleep: engage", new Object[0]);
        this.this$0.engageDeepSleep.invoke();
    }
}
