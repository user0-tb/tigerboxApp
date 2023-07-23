package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.model.domain.PlaybackTrackingDomain;
import media.tiger.tigerbox.model.dto.PlaybackTrackingEvent;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackTracking$removeEventFromDatabase$1", mo34424f = "PlaybackTracking.kt", mo34425i = {}, mo34426l = {169}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: PlaybackTracking.kt */
final class PlaybackTracking$removeEventFromDatabase$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlaybackTrackingEvent $event;
    int label;
    final /* synthetic */ PlaybackTracking this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaybackTracking$removeEventFromDatabase$1(PlaybackTrackingEvent playbackTrackingEvent, PlaybackTracking playbackTracking, Continuation<? super PlaybackTracking$removeEventFromDatabase$1> continuation) {
        super(2, continuation);
        this.$event = playbackTrackingEvent;
        this.this$0 = playbackTracking;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlaybackTracking$removeEventFromDatabase$1(this.$event, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlaybackTracking$removeEventFromDatabase$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PlaybackTrackingDomain playbackTrackingDomain = new PlaybackTrackingDomain(this.$event.getAccountId(), this.$event.getUserId(), this.$event.getProductId(), this.$event.getEvent(), this.$event.getData().getStart(), this.$event.getData().getEnd(), this.$event.getData().getTotal(), 0, 128, (DefaultConstructorMarker) null);
            this.label = 1;
            if (this.this$0.playbackTrackingRepository.deletePlaybackTrackingEvent(playbackTrackingDomain, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("PlaybackTracking: Exception removeEventFromDatabase " + e, new Object[0]);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
