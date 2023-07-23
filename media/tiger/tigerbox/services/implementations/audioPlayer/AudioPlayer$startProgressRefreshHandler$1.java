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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import media.tiger.tigerbox.model.domain.DownloadReason;
import media.tiger.tigerbox.p016ui.common.TimedRefreshHandler;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.AudioPlayer$startProgressRefreshHandler$1", mo34424f = "AudioPlayer.kt", mo34425i = {}, mo34426l = {896}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: AudioPlayer.kt */
final class AudioPlayer$startProgressRefreshHandler$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudioPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AudioPlayer$startProgressRefreshHandler$1(AudioPlayer audioPlayer, Continuation<? super AudioPlayer$startProgressRefreshHandler$1> continuation) {
        super(2, continuation);
        this.this$0 = audioPlayer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioPlayer$startProgressRefreshHandler$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudioPlayer$startProgressRefreshHandler$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.notifyAllOnPlaybackTrackPositionChanged();
            Flow startImmediately$default = TimedRefreshHandler.startImmediately$default(this.this$0.timedRefreshHandler, 1000, 0, 0, 6, (Object) null);
            final AudioPlayer audioPlayer = this.this$0;
            this.label = 1;
            if (startImmediately$default.collect(new FlowCollector() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(int i, Continuation<? super Unit> continuation) {
                    if (audioPlayer.getMExoPlayer().isPlaying()) {
                        audioPlayer.notifyAllOnPlaybackTrackPositionChanged();
                        AudioPlayer audioPlayer = audioPlayer;
                        audioPlayer.uninterruptedListeningSec = audioPlayer.uninterruptedListeningSec + 1000;
                        if (!audioPlayer.hasAskedToDownload && audioPlayer.uninterruptedListeningSec >= 60000) {
                            audioPlayer.downloadCurrentAudioItem(DownloadReason.AUTOMATIC_BY_PLAYER);
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
