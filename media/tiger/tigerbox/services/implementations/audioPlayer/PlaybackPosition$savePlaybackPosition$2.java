package media.tiger.tigerbox.services.implementations.audioPlayer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.model.domain.PlaybackPositionDomain;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition$savePlaybackPosition$2", mo34424f = "PlaybackPosition.kt", mo34425i = {}, mo34426l = {109}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: PlaybackPosition.kt */
final class PlaybackPosition$savePlaybackPosition$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $position;
    final /* synthetic */ int $productId;
    final /* synthetic */ Ref.IntRef $trackIdx;
    int label;
    final /* synthetic */ PlaybackPosition this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaybackPosition$savePlaybackPosition$2(PlaybackPosition playbackPosition, int i, Ref.IntRef intRef, Ref.LongRef longRef, Continuation<? super PlaybackPosition$savePlaybackPosition$2> continuation) {
        super(2, continuation);
        this.this$0 = playbackPosition;
        this.$productId = i;
        this.$trackIdx = intRef;
        this.$position = longRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlaybackPosition$savePlaybackPosition$2(this.this$0, this.$productId, this.$trackIdx, this.$position, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlaybackPosition$savePlaybackPosition$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault()).format(new Date());
            int access$getActiveUserId = this.this$0.getActiveUserId();
            int i2 = this.$productId;
            int i3 = this.$trackIdx.element;
            long j = this.$position.element;
            Intrinsics.checkNotNullExpressionValue(format, "formattedDate");
            PlaybackPositionDomain playbackPositionDomain = new PlaybackPositionDomain(access$getActiveUserId, i2, i3, j, format, 0, 32, (DefaultConstructorMarker) null);
            this.label = 1;
            if (this.this$0.playbackPositionsRepository.insertPlaybackPosition(playbackPositionDomain, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("PlaybackPosition: Exception writing local states " + e, new Object[0]);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
