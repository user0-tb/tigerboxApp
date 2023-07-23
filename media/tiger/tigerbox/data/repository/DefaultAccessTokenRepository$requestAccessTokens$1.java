package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.usecase.accesstokenrepo.GetTokenParameters;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository", mo34424f = "AccessTokenRepository.kt", mo34425i = {0}, mo34426l = {120}, mo34427m = "requestAccessTokens$suspendImpl", mo34428n = {"this"}, mo34429s = {"L$0"})
/* compiled from: AccessTokenRepository.kt */
final class DefaultAccessTokenRepository$requestAccessTokens$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultAccessTokenRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultAccessTokenRepository$requestAccessTokens$1(DefaultAccessTokenRepository defaultAccessTokenRepository, Continuation<? super DefaultAccessTokenRepository$requestAccessTokens$1> continuation) {
        super(continuation);
        this.this$0 = defaultAccessTokenRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DefaultAccessTokenRepository.requestAccessTokens$suspendImpl(this.this$0, (GetTokenParameters) null, this);
    }
}
