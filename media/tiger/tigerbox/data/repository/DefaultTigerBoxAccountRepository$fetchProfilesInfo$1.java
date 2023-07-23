package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository", mo34424f = "TigerBoxUserRepository.kt", mo34425i = {0, 1}, mo34426l = {317, 349}, mo34427m = "fetchProfilesInfo", mo34428n = {"this", "this"}, mo34429s = {"L$0", "L$0"})
/* compiled from: TigerBoxUserRepository.kt */
final class DefaultTigerBoxAccountRepository$fetchProfilesInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultTigerBoxAccountRepository$fetchProfilesInfo$1(DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository, Continuation<? super DefaultTigerBoxAccountRepository$fetchProfilesInfo$1> continuation) {
        super(continuation);
        this.this$0 = defaultTigerBoxAccountRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchProfilesInfo(this);
    }
}
