package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0013"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/audioPlayer/PlaybackTracking$audioListener$1", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackListener;", "onPlaybackBeginScrubbing", "", "item", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "trackPosition", "", "trackIndex", "", "onPlaybackPlaylistWillChange", "onPlaybackStateChanged", "state", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "onPlaybackTrackDidChange", "onPlaybackTrackPositionChanged", "seconds", "percent", "onPlaybackTrackWillChange", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PlaybackTracking.kt */
public final class PlaybackTracking$audioListener$1 implements AudioPlaybackListener {
    final /* synthetic */ PlaybackTracking this$0;

    public void onPlaybackTrackDidChange(AudioItem audioItem, int i) {
        Intrinsics.checkNotNullParameter(audioItem, "item");
    }

    PlaybackTracking$audioListener$1(PlaybackTracking playbackTracking) {
        this.this$0 = playbackTracking;
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

    public void onProductAcquisitionError(ProductAcquisitionService.ErrorCode errorCode) {
        AudioPlaybackListener.DefaultImpls.onProductAcquisitionError(this, errorCode);
    }

    public void onProductPlaybackEnd(AudioItem audioItem) {
        AudioPlaybackListener.DefaultImpls.onProductPlaybackEnd(this, audioItem);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r2 = r2.getProduct();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPlaybackPlaylistWillChange() {
        /*
            r3 = this;
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "PlaybackTracking onPlaybackPlaylistWillChange "
            r1.append(r2)
            media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackTracking r2 = r3.this$0
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r2 = r2.audioService
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r2 = r2.getCurrentItem()
            if (r2 == 0) goto L_0x0027
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r2 = r2.getProduct()
            if (r2 == 0) goto L_0x0027
            int r2 = r2.getId()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.mo50217e(r1, r2)
            media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackTracking r0 = r3.this$0
            r0.endTrackEvent()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackTracking$audioListener$1.onPlaybackPlaylistWillChange():void");
    }

    public void onPlaybackStateChanged(AudioPlaybackState audioPlaybackState) {
        AudioProductInfo product;
        AudioProductInfo product2;
        Intrinsics.checkNotNullParameter(audioPlaybackState, "state");
        Integer num = null;
        if (audioPlaybackState == AudioPlaybackState.STOPPED || audioPlaybackState == AudioPlaybackState.PAUSED) {
            this.this$0.currentPlayerState = AudioPlaybackState.STOPPED;
            Timber.Forest forest = Timber.Forest;
            StringBuilder sb = new StringBuilder();
            sb.append("PlaybackTracking state STOPPED or PAUSED ");
            AudioItem currentItem = this.this$0.audioService.getCurrentItem();
            if (!(currentItem == null || (product = currentItem.getProduct()) == null)) {
                num = Integer.valueOf(product.getId());
            }
            sb.append(num);
            forest.mo50217e(sb.toString(), new Object[0]);
            this.this$0.endTrackEvent();
        } else if (audioPlaybackState == AudioPlaybackState.PLAYING) {
            this.this$0.currentPlayerState = AudioPlaybackState.PLAYING;
            Timber.Forest forest2 = Timber.Forest;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("PlaybackTracking state PLAYING ");
            AudioItem currentItem2 = this.this$0.audioService.getCurrentItem();
            if (!(currentItem2 == null || (product2 = currentItem2.getProduct()) == null)) {
                num = Integer.valueOf(product2.getId());
            }
            sb2.append(num);
            forest2.mo50217e(sb2.toString(), new Object[0]);
            this.this$0.beginTrackEvent();
        }
    }

    public void onPlaybackTrackPositionChanged(AudioItem audioItem, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(audioItem, "item");
        if (this.this$0.hadScrub) {
            this.this$0.beginTrackEvent();
            this.this$0.hadScrub = false;
        }
        this.this$0.updateTrackEvent();
    }

    public void onPlaybackTrackWillChange(AudioItem audioItem, int i) {
        Intrinsics.checkNotNullParameter(audioItem, "item");
        Timber.Forest forest = Timber.Forest;
        forest.mo50217e("PlaybackTracking trackWillChange " + i, new Object[0]);
        this.this$0.endTrackEvent();
    }

    public void onPlaybackBeginScrubbing(AudioItem audioItem, long j, int i) {
        Intrinsics.checkNotNullParameter(audioItem, "item");
        Timber.Forest forest = Timber.Forest;
        forest.mo50217e("PlaybackTracking beginScrubbing " + i, new Object[0]);
        this.this$0.hadScrub = true;
        this.this$0.endTrackEvent();
    }
}
