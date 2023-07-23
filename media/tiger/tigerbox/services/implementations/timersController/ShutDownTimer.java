package media.tiger.tigerbox.services.implementations.timersController;

import android.os.CountDownTimer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.extension.TimeKt;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimeListener;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;

@Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006'"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/timersController/ShutDownTimer;", "Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackListener;", "powerManagementService", "Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "(Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;)V", "currentShutDownTimeSeconds", "", "getCurrentShutDownTimeSeconds", "()I", "setCurrentShutDownTimeSeconds", "(I)V", "initialShutDownTimeSeconds", "getInitialShutDownTimeSeconds", "setInitialShutDownTimeSeconds", "shutDownTimeListenerSubscribers", "", "Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimeListener;", "timer", "Landroid/os/CountDownTimer;", "getTimer", "()Landroid/os/CountDownTimer;", "setTimer", "(Landroid/os/CountDownTimer;)V", "cancelTimer", "", "notifyChanged", "notifyTick", "onProductPlaybackEnd", "item", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "registerShutDownTimeListener", "listener", "shutDownAtTheEndOfPlayback", "startTimer", "sleepTimeSeconds", "unregisterShutDownTimeListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ShutDownTimer.kt */
public final class ShutDownTimer implements ShutDownTimerService, AudioPlaybackListener {
    private final AudioPlayerService audioPlayerService;
    private int currentShutDownTimeSeconds;
    private int initialShutDownTimeSeconds;
    /* access modifiers changed from: private */
    public final PowerManagementService powerManagementService;
    /* access modifiers changed from: private */
    public List<ShutDownTimeListener> shutDownTimeListenerSubscribers = new ArrayList();
    private CountDownTimer timer;

    public ShutDownTimer(PowerManagementService powerManagementService2, AudioPlayerService audioPlayerService2) {
        Intrinsics.checkNotNullParameter(powerManagementService2, "powerManagementService");
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        this.powerManagementService = powerManagementService2;
        this.audioPlayerService = audioPlayerService2;
        audioPlayerService2.registerListener(this);
    }

    public void onPlaybackBeginScrubbing(AudioItem audioItem, long j, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackBeginScrubbing(this, audioItem, j, i);
    }

    public void onPlaybackEndScrubbing(AudioItem audioItem, long j, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackEndScrubbing(this, audioItem, j, i);
    }

    public void onPlaybackItemChanged(AudioItem audioItem) {
        AudioPlaybackListener.DefaultImpls.onPlaybackItemChanged(this, audioItem);
    }

    public void onPlaybackPlaylistChangeReady() {
        AudioPlaybackListener.DefaultImpls.onPlaybackPlaylistChangeReady(this);
    }

    public void onPlaybackPlaylistWillChange() {
        AudioPlaybackListener.DefaultImpls.onPlaybackPlaylistWillChange(this);
    }

    public void onPlaybackStateChanged(AudioPlaybackState audioPlaybackState) {
        AudioPlaybackListener.DefaultImpls.onPlaybackStateChanged(this, audioPlaybackState);
    }

    public void onPlaybackTrackDidChange(AudioItem audioItem, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackDidChange(this, audioItem, i);
    }

    public void onPlaybackTrackPositionChanged(AudioItem audioItem, long j, int i, int i2) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackPositionChanged(this, audioItem, j, i, i2);
    }

    public void onPlaybackTrackWillChange(AudioItem audioItem, int i) {
        AudioPlaybackListener.DefaultImpls.onPlaybackTrackWillChange(this, audioItem, i);
    }

    public void onProductAcquisitionError(ProductAcquisitionService.ErrorCode errorCode) {
        AudioPlaybackListener.DefaultImpls.onProductAcquisitionError(this, errorCode);
    }

    public final CountDownTimer getTimer() {
        return this.timer;
    }

    public final void setTimer(CountDownTimer countDownTimer) {
        this.timer = countDownTimer;
    }

    public int getCurrentShutDownTimeSeconds() {
        return this.currentShutDownTimeSeconds;
    }

    public void setCurrentShutDownTimeSeconds(int i) {
        this.currentShutDownTimeSeconds = i;
    }

    public int getInitialShutDownTimeSeconds() {
        return this.initialShutDownTimeSeconds;
    }

    public void setInitialShutDownTimeSeconds(int i) {
        this.initialShutDownTimeSeconds = i;
    }

    public void registerShutDownTimeListener(ShutDownTimeListener shutDownTimeListener) {
        Intrinsics.checkNotNullParameter(shutDownTimeListener, "listener");
        if (!this.shutDownTimeListenerSubscribers.contains(shutDownTimeListener)) {
            this.shutDownTimeListenerSubscribers.add(shutDownTimeListener);
        }
    }

    public void unregisterShutDownTimeListener(ShutDownTimeListener shutDownTimeListener) {
        Intrinsics.checkNotNullParameter(shutDownTimeListener, "listener");
        this.shutDownTimeListenerSubscribers.remove(shutDownTimeListener);
    }

    public void startTimer(int i) {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        setInitialShutDownTimeSeconds(i);
        CountDownTimer shutDownTimer$startTimer$1 = new ShutDownTimer$startTimer$1(this, TimeKt.secondsToMillis(i));
        this.timer = shutDownTimer$startTimer$1;
        shutDownTimer$startTimer$1.start();
        notifyChanged();
    }

    public void cancelTimer() {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        setCurrentShutDownTimeSeconds(0);
        setInitialShutDownTimeSeconds(0);
        notifyTick(getCurrentShutDownTimeSeconds());
    }

    public void shutDownAtTheEndOfPlayback() {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        setCurrentShutDownTimeSeconds(-1);
        setInitialShutDownTimeSeconds(-1);
        notifyTick(getCurrentShutDownTimeSeconds());
        notifyChanged();
    }

    public void onProductPlaybackEnd(AudioItem audioItem) {
        if (getCurrentShutDownTimeSeconds() == -1) {
            this.powerManagementService.shutDown();
        }
    }

    /* access modifiers changed from: private */
    public final void notifyTick(int i) {
        for (ShutDownTimeListener onSleepTimeTick : this.shutDownTimeListenerSubscribers) {
            onSleepTimeTick.onSleepTimeTick(i);
        }
    }

    private final void notifyChanged() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new ShutDownTimer$notifyChanged$1(this, (Continuation<? super ShutDownTimer$notifyChanged$1>) null), 3, (Object) null);
    }
}
