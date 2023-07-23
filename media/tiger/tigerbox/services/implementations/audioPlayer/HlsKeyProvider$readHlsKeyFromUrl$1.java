package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider", mo34424f = "HlsKeyProvider.kt", mo34425i = {0, 0, 0, 0}, mo34426l = {51}, mo34427m = "readHlsKeyFromUrl", mo34428n = {"this", "originalUrl", "url", "bytes"}, mo34429s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: HlsKeyProvider.kt */
final class HlsKeyProvider$readHlsKeyFromUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HlsKeyProvider this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HlsKeyProvider$readHlsKeyFromUrl$1(HlsKeyProvider hlsKeyProvider, Continuation<? super HlsKeyProvider$readHlsKeyFromUrl$1> continuation) {
        super(continuation);
        this.this$0 = hlsKeyProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.readHlsKeyFromUrl((String) null, (TigerCardDomain) null, false, this);
    }
}
