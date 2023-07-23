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
import media.tiger.tigerbox.model.domain.PlaybackPositionDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/PlaybackPositionDomain;", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1$deferred$1", mo34424f = "PlaybackPosition.kt", mo34425i = {}, mo34426l = {138}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1$deferred$1 */
/* compiled from: PlaybackPosition.kt */
final class C2908x72efc98a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PlaybackPositionDomain>, Object> {
    final /* synthetic */ int $productId;
    int label;
    final /* synthetic */ PlaybackPosition this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2908x72efc98a(PlaybackPosition playbackPosition, int i, Continuation<? super C2908x72efc98a> continuation) {
        super(2, continuation);
        this.this$0 = playbackPosition;
        this.$productId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C2908x72efc98a(this.this$0, this.$productId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PlaybackPositionDomain> continuation) {
        return ((C2908x72efc98a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.localPlaybackPosition(this.$productId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
