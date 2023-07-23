package media.tiger.tigerbox.services.interfaces.audioPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u001a"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackListener;", "", "onPlaybackBeginScrubbing", "", "item", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioItem;", "trackPosition", "", "trackIndex", "", "onPlaybackEndScrubbing", "onPlaybackItemChanged", "onPlaybackPlaylistChangeReady", "onPlaybackPlaylistWillChange", "onPlaybackStateChanged", "state", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "onPlaybackTrackDidChange", "onPlaybackTrackPositionChanged", "seconds", "percent", "onPlaybackTrackWillChange", "onProductAcquisitionError", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "onProductPlaybackEnd", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlaybackListener.kt */
public interface AudioPlaybackListener {

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AudioPlaybackListener.kt */
    public static final class DefaultImpls {
        public static void onPlaybackBeginScrubbing(AudioPlaybackListener audioPlaybackListener, AudioItem audioItem, long j, int i) {
            Intrinsics.checkNotNullParameter(audioItem, "item");
        }

        public static void onPlaybackEndScrubbing(AudioPlaybackListener audioPlaybackListener, AudioItem audioItem, long j, int i) {
            Intrinsics.checkNotNullParameter(audioItem, "item");
        }

        public static void onPlaybackItemChanged(AudioPlaybackListener audioPlaybackListener, AudioItem audioItem) {
        }

        public static void onPlaybackPlaylistChangeReady(AudioPlaybackListener audioPlaybackListener) {
        }

        public static void onPlaybackPlaylistWillChange(AudioPlaybackListener audioPlaybackListener) {
        }

        public static void onPlaybackStateChanged(AudioPlaybackListener audioPlaybackListener, AudioPlaybackState audioPlaybackState) {
            Intrinsics.checkNotNullParameter(audioPlaybackState, "state");
        }

        public static void onPlaybackTrackDidChange(AudioPlaybackListener audioPlaybackListener, AudioItem audioItem, int i) {
            Intrinsics.checkNotNullParameter(audioItem, "item");
        }

        public static void onPlaybackTrackPositionChanged(AudioPlaybackListener audioPlaybackListener, AudioItem audioItem, long j, int i, int i2) {
            Intrinsics.checkNotNullParameter(audioItem, "item");
        }

        public static void onPlaybackTrackWillChange(AudioPlaybackListener audioPlaybackListener, AudioItem audioItem, int i) {
            Intrinsics.checkNotNullParameter(audioItem, "item");
        }

        public static void onProductAcquisitionError(AudioPlaybackListener audioPlaybackListener, ProductAcquisitionService.ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "error");
        }

        public static void onProductPlaybackEnd(AudioPlaybackListener audioPlaybackListener, AudioItem audioItem) {
        }
    }

    void onPlaybackBeginScrubbing(AudioItem audioItem, long j, int i);

    void onPlaybackEndScrubbing(AudioItem audioItem, long j, int i);

    void onPlaybackItemChanged(AudioItem audioItem);

    void onPlaybackPlaylistChangeReady();

    void onPlaybackPlaylistWillChange();

    void onPlaybackStateChanged(AudioPlaybackState audioPlaybackState);

    void onPlaybackTrackDidChange(AudioItem audioItem, int i);

    void onPlaybackTrackPositionChanged(AudioItem audioItem, long j, int i, int i2);

    void onPlaybackTrackWillChange(AudioItem audioItem, int i);

    void onProductAcquisitionError(ProductAcquisitionService.ErrorCode errorCode);

    void onProductPlaybackEnd(AudioItem audioItem);
}
