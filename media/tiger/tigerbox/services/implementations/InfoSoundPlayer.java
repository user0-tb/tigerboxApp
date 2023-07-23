package media.tiger.tigerbox.services.implementations;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.SystemSoundEnabledListener;

@Metadata(mo33736d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0002J\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\bH\u0016J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00108V@VX\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\u00020\u001a*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/InfoSoundPlayer;", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "context", "Landroid/content/Context;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/services/interfaces/StorageService;)V", "currentSoundType", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService$SoundType;", "exoPlayer", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "getExoPlayer", "()Lcom/google/android/exoplayer2/SimpleExoPlayer;", "exoPlayer$delegate", "Lkotlin/Lazy;", "value", "", "systemSoundEnabled", "getSystemSoundEnabled", "()Z", "setSystemSoundEnabled", "(Z)V", "systemSoundEnabledListeners", "", "Lmedia/tiger/tigerbox/services/interfaces/SystemSoundEnabledListener;", "soundId", "", "getSoundId", "(Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService$SoundType;)I", "alertSystemSoundSubscribers", "", "buildRawMediaSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "soundType", "playSound", "registerSystemSoundEnabledListener", "listener", "stop", "unregisterSystemSoundEnabledListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: InfoSoundPlayer.kt */
public final class InfoSoundPlayer implements InfoSoundService {
    /* access modifiers changed from: private */
    public final Context context;
    private InfoSoundService.SoundType currentSoundType;
    private final Lazy exoPlayer$delegate = LazyKt.lazy(new InfoSoundPlayer$exoPlayer$2(this));
    private final StorageService storageService;
    private final List<SystemSoundEnabledListener> systemSoundEnabledListeners = new ArrayList();

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: InfoSoundPlayer.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InfoSoundService.SoundType.values().length];
            iArr[InfoSoundService.SoundType.NEW_WIFI_SUCCESS.ordinal()] = 1;
            iArr[InfoSoundService.SoundType.WIFI_CONNECTION_FAIL.ordinal()] = 2;
            iArr[InfoSoundService.SoundType.LOW_BATTERY_5.ordinal()] = 3;
            iArr[InfoSoundService.SoundType.LOW_BATTERY_5_SWITCH_ON.ordinal()] = 4;
            iArr[InfoSoundService.SoundType.LOW_BATTERY_20.ordinal()] = 5;
            iArr[InfoSoundService.SoundType.WELCOME.ordinal()] = 6;
            iArr[InfoSoundService.SoundType.SWITCH_OFF.ordinal()] = 7;
            iArr[InfoSoundService.SoundType.SWITCH_ON.ordinal()] = 8;
            iArr[InfoSoundService.SoundType.USER_RESET_CONFIRM.ordinal()] = 9;
            iArr[InfoSoundService.SoundType.USER_RESET_WAIT.ordinal()] = 10;
            iArr[InfoSoundService.SoundType.CABLE_PLUGGED_IN.ordinal()] = 11;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public InfoSoundPlayer(Context context2, StorageService storageService2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        this.context = context2;
        this.storageService = storageService2;
    }

    private final SimpleExoPlayer getExoPlayer() {
        return (SimpleExoPlayer) this.exoPlayer$delegate.getValue();
    }

    public boolean getSystemSoundEnabled() {
        return !this.storageService.isMuted();
    }

    public void setSystemSoundEnabled(boolean z) {
        this.storageService.setMuted(!z);
        alertSystemSoundSubscribers();
    }

    private final void alertSystemSoundSubscribers() {
        for (SystemSoundEnabledListener onSystemSoundChanged : this.systemSoundEnabledListeners) {
            onSystemSoundChanged.onSystemSoundChanged(getSystemSoundEnabled());
        }
    }

    public void registerSystemSoundEnabledListener(SystemSoundEnabledListener systemSoundEnabledListener) {
        Intrinsics.checkNotNullParameter(systemSoundEnabledListener, "listener");
        this.systemSoundEnabledListeners.add(systemSoundEnabledListener);
    }

    public void unregisterSystemSoundEnabledListener(SystemSoundEnabledListener systemSoundEnabledListener) {
        Intrinsics.checkNotNullParameter(systemSoundEnabledListener, "listener");
        if (this.systemSoundEnabledListeners.contains(systemSoundEnabledListener)) {
            this.systemSoundEnabledListeners.remove(systemSoundEnabledListener);
        }
    }

    public void playSound(InfoSoundService.SoundType soundType) {
        Intrinsics.checkNotNullParameter(soundType, "soundType");
        if (getSystemSoundEnabled()) {
            new Handler(Looper.getMainLooper()).post(new InfoSoundPlayer$$ExternalSyntheticLambda2(this, soundType));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playSound$lambda-2  reason: not valid java name */
    public static final void m2346playSound$lambda2(InfoSoundPlayer infoSoundPlayer, InfoSoundService.SoundType soundType) {
        Intrinsics.checkNotNullParameter(infoSoundPlayer, "this$0");
        Intrinsics.checkNotNullParameter(soundType, "$soundType");
        SimpleExoPlayer exoPlayer = infoSoundPlayer.getExoPlayer();
        infoSoundPlayer.currentSoundType = soundType;
        exoPlayer.setMediaSource(infoSoundPlayer.buildRawMediaSource(soundType));
        exoPlayer.setPlayWhenReady(true);
        exoPlayer.prepare();
    }

    public void stop() {
        new Handler(Looper.getMainLooper()).post(new InfoSoundPlayer$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: stop$lambda-4  reason: not valid java name */
    public static final void m2347stop$lambda4(InfoSoundPlayer infoSoundPlayer) {
        Intrinsics.checkNotNullParameter(infoSoundPlayer, "this$0");
        infoSoundPlayer.getExoPlayer().stop();
    }

    private final MediaSource buildRawMediaSource(InfoSoundService.SoundType soundType) {
        RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.context);
        rawResourceDataSource.open(new DataSpec(RawResourceDataSource.buildRawResourceUri(getSoundId(soundType))));
        Uri uri = rawResourceDataSource.getUri();
        Intrinsics.checkNotNull(uri);
        MediaItem fromUri = MediaItem.fromUri(uri);
        Intrinsics.checkNotNullExpressionValue(fromUri, "fromUri(rawDataSource.uri!!)");
        ProgressiveMediaSource createMediaSource = new ProgressiveMediaSource.Factory(new InfoSoundPlayer$$ExternalSyntheticLambda0(rawResourceDataSource)).createMediaSource(fromUri);
        Intrinsics.checkNotNullExpressionValue(createMediaSource, "Factory { rawDataSource …ateMediaSource(mediaItem)");
        return createMediaSource;
    }

    /* access modifiers changed from: private */
    /* renamed from: buildRawMediaSource$lambda-5  reason: not valid java name */
    public static final DataSource m2345buildRawMediaSource$lambda5(RawResourceDataSource rawResourceDataSource) {
        Intrinsics.checkNotNullParameter(rawResourceDataSource, "$rawDataSource");
        return rawResourceDataSource;
    }

    private final int getSoundId(InfoSoundService.SoundType soundType) {
        switch (WhenMappings.$EnumSwitchMapping$0[soundType.ordinal()]) {
            case 1:
                return C2814R.C2822raw.connect_new_wifi;
            case 2:
                return C2814R.C2822raw.connect_new_wifi_fail;
            case 3:
                return C2814R.C2822raw.low_battery_5;
            case 4:
                return C2814R.C2822raw.low_battery_5_switch_on;
            case 5:
                return C2814R.C2822raw.low_battery_20;
            case 6:
                return C2814R.C2822raw.welcome;
            case 7:
                return C2814R.C2822raw.switch_off;
            case 8:
                return C2814R.C2822raw.box_start_nanana;
            case 9:
                return C2814R.C2822raw.reset_factory_setting_confirm;
            case 10:
                return C2814R.C2822raw.reset_factory_setting_wait;
            case 11:
                return C2814R.C2822raw.positive_sound;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
