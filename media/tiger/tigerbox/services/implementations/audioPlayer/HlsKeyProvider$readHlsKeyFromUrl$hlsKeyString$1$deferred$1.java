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
import media.tiger.tigerbox.model.domain.HlsKeyDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$hlsKeyString$1$deferred$1", mo34424f = "HlsKeyProvider.kt", mo34425i = {}, mo34426l = {29}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: HlsKeyProvider.kt */
final class HlsKeyProvider$readHlsKeyFromUrl$hlsKeyString$1$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $originalUrl;
    int label;
    final /* synthetic */ HlsKeyProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HlsKeyProvider$readHlsKeyFromUrl$hlsKeyString$1$deferred$1(HlsKeyProvider hlsKeyProvider, String str, Continuation<? super HlsKeyProvider$readHlsKeyFromUrl$hlsKeyString$1$deferred$1> continuation) {
        super(2, continuation);
        this.this$0 = hlsKeyProvider;
        this.$originalUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HlsKeyProvider$readHlsKeyFromUrl$hlsKeyString$1$deferred$1(this.this$0, this.$originalUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((HlsKeyProvider$readHlsKeyFromUrl$hlsKeyString$1$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.hlsKeysRepository.getHlsKey(this.$originalUrl, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HlsKeyDomain hlsKeyDomain = (HlsKeyDomain) obj;
        if (hlsKeyDomain != null) {
            return hlsKeyDomain.getKey();
        }
        return null;
    }
}
