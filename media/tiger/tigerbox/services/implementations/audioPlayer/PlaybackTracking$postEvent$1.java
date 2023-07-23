package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.dto.PlaybackTrackingEvent;
import media.tiger.tigerbox.usecase.PostTrackingEventParameters;
import media.tiger.tigerbox.usecase.PostTrackingEventUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackTracking$postEvent$1", mo34424f = "PlaybackTracking.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: PlaybackTracking.kt */
final class PlaybackTracking$postEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlaybackTrackingEvent $event;
    final /* synthetic */ boolean $isNewEvent;
    int label;
    final /* synthetic */ PlaybackTracking this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaybackTracking$postEvent$1(PlaybackTrackingEvent playbackTrackingEvent, boolean z, PlaybackTracking playbackTracking, Continuation<? super PlaybackTracking$postEvent$1> continuation) {
        super(2, continuation);
        this.$event = playbackTrackingEvent;
        this.$isNewEvent = z;
        this.this$0 = playbackTracking;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlaybackTracking$postEvent$1(this.$event, this.$isNewEvent, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlaybackTracking$postEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest forest = Timber.Forest;
            forest.mo50236w("PlaybackTracking postEvent " + this.$event + " isNew " + this.$isNewEvent, new Object[0]);
            PostTrackingEventUseCase access$getPostTrackingEventUseCase$p = this.this$0.postTrackingEventUseCase;
            PostTrackingEventParameters postTrackingEventParameters = new PostTrackingEventParameters(this.$event, this.$isNewEvent);
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
            final PlaybackTracking playbackTracking = this.this$0;
            final PlaybackTrackingEvent playbackTrackingEvent = this.$event;
            final boolean z = this.$isNewEvent;
            access$getPostTrackingEventUseCase$p.invoke(postTrackingEventParameters, CoroutineScope, new Function1<Either<? extends Failure, ? extends PlaybackTrackingEvent>, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Either<? extends Failure, PlaybackTrackingEvent>) (Either) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Either<? extends Failure, PlaybackTrackingEvent> either) {
                    Intrinsics.checkNotNullParameter(either, "it");
                    final PlaybackTracking playbackTracking = playbackTracking;
                    final PlaybackTrackingEvent playbackTrackingEvent = playbackTrackingEvent;
                    final boolean z = z;
                    final PlaybackTracking playbackTracking2 = playbackTracking;
                    final PlaybackTrackingEvent playbackTrackingEvent2 = playbackTrackingEvent;
                    final boolean z2 = z;
                    either.fold(new Function1<Failure, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Failure) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Failure failure) {
                            Intrinsics.checkNotNullParameter(failure, "it");
                            playbackTracking.handlePostReqFailure(playbackTrackingEvent, z);
                        }
                    }, new Function1<PlaybackTrackingEvent, Unit>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PlaybackTrackingEvent) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PlaybackTrackingEvent playbackTrackingEvent) {
                            playbackTracking2.handlePostReqSuccess(playbackTrackingEvent2, z2);
                        }
                    });
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
