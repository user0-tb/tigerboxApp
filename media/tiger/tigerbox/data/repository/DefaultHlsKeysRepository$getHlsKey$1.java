package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultHlsKeysRepository", mo34424f = "HlsKeysRepository.kt", mo34425i = {0, 0}, mo34426l = {45}, mo34427m = "getHlsKey$suspendImpl", mo34428n = {"url", "stringRepresentation"}, mo34429s = {"L$0", "L$1"})
/* compiled from: HlsKeysRepository.kt */
final class DefaultHlsKeysRepository$getHlsKey$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultHlsKeysRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultHlsKeysRepository$getHlsKey$1(DefaultHlsKeysRepository defaultHlsKeysRepository, Continuation<? super DefaultHlsKeysRepository$getHlsKey$1> continuation) {
        super(continuation);
        this.this$0 = defaultHlsKeysRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DefaultHlsKeysRepository.getHlsKey$suspendImpl(this.this$0, (String) null, this);
    }
}
