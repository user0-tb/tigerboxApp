package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylistDelegate;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import media.tiger.tigerbox.webserver.dto.PlaybackDto;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "stepType", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$StepType;", "error", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService$ErrorCode;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlayer.kt */
final class AudioPlayer$preparePlaylistItem$1$2 extends Lambda implements Function2<ProductAcquisitionService.StepType, ProductAcquisitionService.ErrorCode, Unit> {
    final /* synthetic */ int $curActiveIdx;
    final /* synthetic */ AudioPlaylist $it;
    final /* synthetic */ Function1<ProductAcquisitionService.ErrorCode, Unit> $onStreamReady;
    final /* synthetic */ PlaybackDto $playbackDto;
    final /* synthetic */ int $productId;
    final /* synthetic */ Ref.BooleanRef $success;
    final /* synthetic */ boolean $useDtoPlayPosition;
    final /* synthetic */ AudioPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AudioPlayer$preparePlaylistItem$1$2(AudioPlayer audioPlayer, int i, Function1<? super ProductAcquisitionService.ErrorCode, Unit> function1, AudioPlaylist audioPlaylist, int i2, PlaybackDto playbackDto, boolean z, Ref.BooleanRef booleanRef) {
        super(2);
        this.this$0 = audioPlayer;
        this.$curActiveIdx = i;
        this.$onStreamReady = function1;
        this.$it = audioPlaylist;
        this.$productId = i2;
        this.$playbackDto = playbackDto;
        this.$useDtoPlayPosition = z;
        this.$success = booleanRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ProductAcquisitionService.StepType) obj, (ProductAcquisitionService.ErrorCode) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductAcquisitionService.StepType stepType, ProductAcquisitionService.ErrorCode errorCode) {
        boolean z;
        AudioProductInfo audioProductInfoForProductId;
        Intrinsics.checkNotNullParameter(stepType, "stepType");
        if (stepType != ProductAcquisitionService.StepType.ACQUISITION_FINISHED) {
            return;
        }
        if (!this.this$0.isAllowedToPlay()) {
            this.this$0.stop();
        } else if (errorCode != null) {
            AudioPlaylist access$get_playlist$p = this.this$0._playlist;
            if (access$get_playlist$p != null) {
                access$get_playlist$p.setActiveIdx(this.$curActiveIdx);
            }
            this.this$0.pause();
            Function1<ProductAcquisitionService.ErrorCode, Unit> function1 = this.$onStreamReady;
            if (function1 != null) {
                function1.invoke(errorCode);
            } else {
                this.this$0.notifyAllOnProductAcquisitionError(errorCode);
            }
        } else {
            if (this.$it.getDelegate() == null) {
                z = true;
            } else {
                AudioPlaylistDelegate delegate = this.$it.getDelegate();
                Intrinsics.checkNotNull(delegate);
                z = delegate.shouldBeginPlayback();
            }
            if (z && (audioProductInfoForProductId = this.this$0.availabilityService.audioProductInfoForProductId(this.$productId)) != null) {
                AudioPlaylist audioPlaylist = this.$it;
                AudioPlayer audioPlayer = this.this$0;
                PlaybackDto playbackDto = this.$playbackDto;
                boolean z2 = this.$useDtoPlayPosition;
                Ref.BooleanRef booleanRef = this.$success;
                Function1<ProductAcquisitionService.ErrorCode, Unit> function12 = this.$onStreamReady;
                AudioItemImpl create = AudioItemImpl.Companion.create(audioProductInfoForProductId, audioPlaylist.getNfc());
                int i = 0;
                boolean z3 = audioPlayer.getPlaybackReason() == AudioPlaybackReason.WEBSERVER_INITIATED;
                if (audioPlayer.getPlaybackReason() == AudioPlaybackReason.WEBSERVER_INITIATED) {
                    z3 = (playbackDto.getTrackNumber() == -1 || playbackDto.getTrackPosition() == -1) ? false : true;
                }
                create.setShouldResumePlayback(z2 && !z3);
                audioPlayer._notificationsEnabled = false;
                booleanRef.element = true;
                audioPlayer.prepare(create);
                audioPlayer.play();
                if (z2) {
                    i = playbackDto.getTrackNumber();
                }
                audioPlayer.setTrackIndex(i);
                audioPlayer.setCurrentTrackPosition(z2 ? playbackDto.getTrackPosition() : 0);
                audioPlayer._notificationsEnabled = true;
                if (audioPlayer._currentTrackIndex >= 0) {
                    if (function12 != null) {
                        audioPlayer.notifyAllOnPlaybackModelChanged();
                        audioPlayer.notifyAllOnPlaybackStateChanged();
                    } else {
                        audioPlayer.notifyAllOnPlaybackTrackDidChange(audioPlayer._currentTrackIndex);
                    }
                }
            }
            Function1<ProductAcquisitionService.ErrorCode, Unit> function13 = this.$onStreamReady;
            if (function13 != null) {
                function13.invoke(null);
            }
        }
    }
}
