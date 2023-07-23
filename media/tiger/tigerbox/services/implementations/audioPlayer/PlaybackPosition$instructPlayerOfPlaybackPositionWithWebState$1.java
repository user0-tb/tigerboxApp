package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import media.tiger.tigerbox.model.domain.PlaybackPositionDomain;
import media.tiger.tigerbox.model.dto.ProductPlayStates;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1", mo34424f = "PlaybackPosition.kt", mo34425i = {}, mo34426l = {141}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: PlaybackPosition.kt */
final class PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PlaybackPositionDomain> $localState;
    final /* synthetic */ int $productId;
    final /* synthetic */ ProductPlayStates.Embedded.Content $webState;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlaybackPosition this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1(PlaybackPosition playbackPosition, int i, Ref.ObjectRef<PlaybackPositionDomain> objectRef, ProductPlayStates.Embedded.Content content, Continuation<? super PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1> continuation) {
        super(2, continuation);
        this.this$0 = playbackPosition;
        this.$productId = i;
        this.$localState = objectRef;
        this.$webState = content;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1 playbackPosition$instructPlayerOfPlaybackPositionWithWebState$1 = new PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1(this.this$0, this.$productId, this.$localState, this.$webState, continuation);
        playbackPosition$instructPlayerOfPlaybackPositionWithWebState$1.L$0 = obj;
        return playbackPosition$instructPlayerOfPlaybackPositionWithWebState$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Deferred async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new C2908x72efc98a(this.this$0, this.$productId, (Continuation<? super C2908x72efc98a>) null), 3, (Object) null);
            final Ref.ObjectRef<PlaybackPositionDomain> objectRef = this.$localState;
            final ProductPlayStates.Embedded.Content content = this.$webState;
            final PlaybackPosition playbackPosition = this.this$0;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C29071((Continuation<? super C29071>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1$1", mo34424f = "PlaybackPosition.kt", mo34425i = {}, mo34426l = {142}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1$1 */
    /* compiled from: PlaybackPosition.kt */
    static final class C29071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29071(objectRef, async$default, content, playbackPosition, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d1, code lost:
            r1 = r1.getTracks();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(T r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r0 = r9.L$0
                kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
                kotlin.ResultKt.throwOnFailure(r10)
                goto L_0x0032
            L_0x0013:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001b:
                kotlin.ResultKt.throwOnFailure(r10)
                kotlin.jvm.internal.Ref$ObjectRef<media.tiger.tigerbox.model.domain.PlaybackPositionDomain> r10 = r11
                kotlinx.coroutines.Deferred<media.tiger.tigerbox.model.domain.PlaybackPositionDomain> r1 = r12
                r3 = r9
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r9.L$0 = r10
                r9.label = r2
                java.lang.Object r1 = r1.await(r3)
                if (r1 != r0) goto L_0x0030
                return r0
            L_0x0030:
                r0 = r10
                r10 = r1
            L_0x0032:
                r0.element = r10
                kotlin.jvm.internal.Ref$IntRef r10 = new kotlin.jvm.internal.Ref$IntRef
                r10.<init>()
                kotlin.jvm.internal.Ref$LongRef r0 = new kotlin.jvm.internal.Ref$LongRef
                r0.<init>()
                media.tiger.tigerbox.model.dto.ProductPlayStates$Embedded$Content r1 = r13
                java.lang.String r3 = "yyyy-MM-dd'T'HH:mm:ss"
                r4 = 0
                r5 = 0
                if (r1 == 0) goto L_0x0087
                java.lang.String r1 = r1.getLastModifiedDate()     // Catch:{ Exception -> 0x0064 }
                if (r1 == 0) goto L_0x0051
                java.util.Date r1 = media.tiger.tigerbox.utils.DateUtilsKt.toDate(r1, r3)     // Catch:{ Exception -> 0x0064 }
                r4 = r1
            L_0x0051:
                media.tiger.tigerbox.model.dto.ProductPlayStates$Embedded$Content r1 = r13     // Catch:{ Exception -> 0x0064 }
                int r1 = r1.getTrackNumber()     // Catch:{ Exception -> 0x0064 }
                int r1 = r1 - r2
                r10.element = r1     // Catch:{ Exception -> 0x0064 }
                media.tiger.tigerbox.model.dto.ProductPlayStates$Embedded$Content r1 = r13     // Catch:{ Exception -> 0x0064 }
                int r1 = r1.getTrackPosition()     // Catch:{ Exception -> 0x0064 }
                long r6 = (long) r1     // Catch:{ Exception -> 0x0064 }
                r0.element = r6     // Catch:{ Exception -> 0x0064 }
                goto L_0x0087
            L_0x0064:
                r1 = move-exception
                timber.log.Timber$Forest r6 = timber.log.Timber.Forest
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "PlaybackPosition: Exception parsing web state "
                r7.append(r8)
                r7.append(r1)
                java.lang.String r1 = " webState: "
                r7.append(r1)
                media.tiger.tigerbox.model.dto.ProductPlayStates$Embedded$Content r1 = r13
                r7.append(r1)
                java.lang.String r1 = r7.toString()
                java.lang.Object[] r7 = new java.lang.Object[r5]
                r6.mo50217e(r1, r7)
            L_0x0087:
                kotlin.jvm.internal.Ref$ObjectRef<media.tiger.tigerbox.model.domain.PlaybackPositionDomain> r1 = r11
                T r1 = r1.element
                media.tiger.tigerbox.model.domain.PlaybackPositionDomain r1 = (media.tiger.tigerbox.model.domain.PlaybackPositionDomain) r1
                if (r1 == 0) goto L_0x00c5
                java.lang.String r6 = r1.getModifiedDate()     // Catch:{ Exception -> 0x00ac }
                java.util.Date r3 = media.tiger.tigerbox.utils.DateUtilsKt.toDate(r6, r3)     // Catch:{ Exception -> 0x00ac }
                if (r4 == 0) goto L_0x009f
                int r3 = r3.compareTo(r4)     // Catch:{ Exception -> 0x00ac }
                if (r3 <= 0) goto L_0x00c5
            L_0x009f:
                int r3 = r1.getTrackNumber()     // Catch:{ Exception -> 0x00ac }
                r10.element = r3     // Catch:{ Exception -> 0x00ac }
                long r3 = r1.getTrackPosition()     // Catch:{ Exception -> 0x00ac }
                r0.element = r3     // Catch:{ Exception -> 0x00ac }
                goto L_0x00c5
            L_0x00ac:
                r1 = move-exception
                timber.log.Timber$Forest r3 = timber.log.Timber.Forest
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r6 = "PlaybackPosition: Exception parsing local state "
                r4.append(r6)
                r4.append(r1)
                java.lang.String r1 = r4.toString()
                java.lang.Object[] r4 = new java.lang.Object[r5]
                r3.mo50217e(r1, r4)
            L_0x00c5:
                media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition r1 = r14
                media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r1 = r1.audioService
                media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r1 = r1.getCurrentItem()
                if (r1 == 0) goto L_0x00dc
                java.util.ArrayList r1 = r1.getTracks()
                if (r1 == 0) goto L_0x00dc
                int r1 = r1.size()
                goto L_0x00dd
            L_0x00dc:
                r1 = 0
            L_0x00dd:
                int r3 = r10.element
                int r3 = kotlin.ranges.RangesKt.coerceAtLeast((int) r3, (int) r5)
                int r1 = r1 - r2
                int r1 = kotlin.ranges.RangesKt.coerceAtMost((int) r3, (int) r1)
                r10.element = r1
                media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition r1 = r14
                media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r1 = r1.audioService
                media.tiger.tigerbox.services.interfaces.audioPlayer.AudioItem r1 = r1.getCurrentItem()
                r2 = 0
                if (r1 == 0) goto L_0x00ff
                int r4 = r10.element
                long r4 = r1.durationOf(r4)
                goto L_0x0100
            L_0x00ff:
                r4 = r2
            L_0x0100:
                long r6 = r0.element
                int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r1 <= 0) goto L_0x0108
                r0.element = r2
            L_0x0108:
                media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition r1 = r14
                media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r1 = r1.audioService
                int r10 = r10.element
                r1.setTrackIndex(r10)
                media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition r10 = r14
                media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r10 = r10.audioService
                long r0 = r0.element
                long r0 = kotlin.ranges.RangesKt.coerceAtLeast((long) r0, (long) r2)
                r10.setCurrentTrackPosition(r0)
                kotlin.Unit r10 = kotlin.Unit.INSTANCE
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition$instructPlayerOfPlaybackPositionWithWebState$1.C29071.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
