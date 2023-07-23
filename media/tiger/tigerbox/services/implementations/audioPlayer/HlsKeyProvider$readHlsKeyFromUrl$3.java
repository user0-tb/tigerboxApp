package media.tiger.tigerbox.services.implementations.audioPlayer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
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
import media.tiger.tigerbox.model.domain.HlsKeyDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$3", mo34424f = "HlsKeyProvider.kt", mo34425i = {}, mo34426l = {63}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: HlsKeyProvider.kt */
final class HlsKeyProvider$readHlsKeyFromUrl$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<byte[]> $bytes;
    final /* synthetic */ String $originalUrl;
    int label;
    final /* synthetic */ HlsKeyProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HlsKeyProvider$readHlsKeyFromUrl$3(Ref.ObjectRef<byte[]> objectRef, HlsKeyProvider hlsKeyProvider, String str, Continuation<? super HlsKeyProvider$readHlsKeyFromUrl$3> continuation) {
        super(2, continuation);
        this.$bytes = objectRef;
        this.this$0 = hlsKeyProvider;
        this.$originalUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HlsKeyProvider$readHlsKeyFromUrl$3(this.$bytes, this.this$0, this.$originalUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HlsKeyProvider$readHlsKeyFromUrl$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Charset charset = StandardCharsets.ISO_8859_1;
            Intrinsics.checkNotNullExpressionValue(charset, "ISO_8859_1");
            String str = new String((byte[]) this.$bytes.element, charset);
            this.label = 1;
            if (this.this$0.hlsKeysRepository.insertHlsKey(new HlsKeyDomain(str, this.$originalUrl, 0, 4, (DefaultConstructorMarker) null), this) == coroutine_suspended) {
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
