package media.tiger.tigerbox.services.implementations.audioPlayer;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.model.domain.PlaybackTrackingDomain;
import media.tiger.tigerbox.model.dto.PlaybackTrackingEvent;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackTracking$postUnsentEvents$1", mo34424f = "PlaybackTracking.kt", mo34425i = {}, mo34426l = {176}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: PlaybackTracking.kt */
final class PlaybackTracking$postUnsentEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PlaybackTracking this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaybackTracking$postUnsentEvents$1(PlaybackTracking playbackTracking, Continuation<? super PlaybackTracking$postUnsentEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = playbackTracking;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlaybackTracking$postUnsentEvents$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlaybackTracking$postUnsentEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.playbackTrackingRepository.getPlaybackTracking(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        for (PlaybackTrackingDomain playbackTrackingDomain : (List) obj) {
            Job unused = this.this$0.postEvent(new PlaybackTrackingEvent(playbackTrackingDomain.getAccountId(), playbackTrackingDomain.getUserId(), playbackTrackingDomain.getProductId(), new PlaybackTrackingEvent.EventData(playbackTrackingDomain.getStart(), playbackTrackingDomain.getEnd(), playbackTrackingDomain.getTotal(), this.this$0.getDeviceId()), playbackTrackingDomain.getEvent()), false);
        }
        return Unit.INSTANCE;
    }
}
