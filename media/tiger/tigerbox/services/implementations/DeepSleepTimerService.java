package media.tiger.tigerbox.services.implementations;

import android.os.CountDownTimer;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.EngageDeepSleep;
import media.tiger.tigerbox.RestartServicesSafely;
import media.tiger.tigerbox.extension.TimeKt;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/DeepSleepTimerService;", "", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "engageDeepSleep", "Lmedia/tiger/tigerbox/EngageDeepSleep;", "restartServicesSafely", "Lmedia/tiger/tigerbox/RestartServicesSafely;", "(Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lmedia/tiger/tigerbox/EngageDeepSleep;Lmedia/tiger/tigerbox/RestartServicesSafely;)V", "timeoutSeconds", "", "getTimeoutSeconds", "()I", "timeoutSeconds$delegate", "Lkotlin/Lazy;", "timer", "Landroid/os/CountDownTimer;", "invoke", "", "stop", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DeepSleepTimerService.kt */
public final class DeepSleepTimerService {
    /* access modifiers changed from: private */
    public final EngageDeepSleep engageDeepSleep;
    private final RestartServicesSafely restartServicesSafely;
    private final Lazy timeoutSeconds$delegate;
    private CountDownTimer timer;

    @Inject
    public DeepSleepTimerService(ConfigurationProperties configurationProperties, EngageDeepSleep engageDeepSleep2, RestartServicesSafely restartServicesSafely2) {
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        Intrinsics.checkNotNullParameter(engageDeepSleep2, "engageDeepSleep");
        Intrinsics.checkNotNullParameter(restartServicesSafely2, "restartServicesSafely");
        this.engageDeepSleep = engageDeepSleep2;
        this.restartServicesSafely = restartServicesSafely2;
        this.timeoutSeconds$delegate = LazyKt.lazy(new DeepSleepTimerService$timeoutSeconds$2(configurationProperties));
    }

    private final int getTimeoutSeconds() {
        return ((Number) this.timeoutSeconds$delegate.getValue()).intValue();
    }

    public final void invoke() {
        if (this.timer == null) {
            Timber.Forest.mo50214d("Deep sleep: Timer started", new Object[0]);
            CountDownTimer deepSleepTimerService$invoke$1 = new DeepSleepTimerService$invoke$1(this, TimeKt.secondsToMillis(getTimeoutSeconds()));
            this.timer = deepSleepTimerService$invoke$1;
            deepSleepTimerService$invoke$1.start();
        }
    }

    public final void stop() {
        this.restartServicesSafely.invoke();
        Timber.Forest.mo50214d("Deep sleep: timer cancelled", new Object[0]);
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.timer = null;
    }
}
