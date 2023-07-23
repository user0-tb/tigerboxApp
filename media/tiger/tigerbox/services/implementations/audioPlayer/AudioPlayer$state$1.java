package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackState;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlaybackState;", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.AudioPlayer$state$1", mo34424f = "AudioPlayer.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: AudioPlayer.kt */
final class AudioPlayer$state$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AudioPlaybackState>, Object> {
    int label;
    final /* synthetic */ AudioPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AudioPlayer$state$1(AudioPlayer audioPlayer, Continuation<? super AudioPlayer$state$1> continuation) {
        super(2, continuation);
        this.this$0 = audioPlayer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioPlayer$state$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AudioPlaybackState> continuation) {
        return ((AudioPlayer$state$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0._isPreparingItem || this.this$0._isPreparingPlaylist) {
                return AudioPlaybackState.PREPARING;
            }
            if (this.this$0.getPlayerHasError()) {
                return AudioPlaybackState.ERROR;
            }
            if (3 == this.this$0.getMExoPlayer().getPlaybackState()) {
                if (this.this$0.getMExoPlayer().isPlaying()) {
                    return AudioPlaybackState.PLAYING;
                }
                return AudioPlaybackState.PAUSED;
            } else if (2 == this.this$0.getMExoPlayer().getPlaybackState()) {
                return AudioPlaybackState.BUFFERING;
            } else {
                if (4 == this.this$0.getMExoPlayer().getPlaybackState() || 1 == this.this$0.getMExoPlayer().getPlaybackState()) {
                    return AudioPlaybackState.STOPPED;
                }
                return AudioPlaybackState.STOPPED;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
