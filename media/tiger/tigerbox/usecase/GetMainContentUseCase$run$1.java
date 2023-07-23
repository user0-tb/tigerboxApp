package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.usecase.GetMainContentUseCase", mo34424f = "GetMainContentUseCase.kt", mo34425i = {}, mo34426l = {30}, mo34427m = "run", mo34428n = {}, mo34429s = {})
/* compiled from: GetMainContentUseCase.kt */
final class GetMainContentUseCase$run$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetMainContentUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetMainContentUseCase$run$1(GetMainContentUseCase getMainContentUseCase, Continuation<? super GetMainContentUseCase$run$1> continuation) {
        super(continuation);
        this.this$0 = getMainContentUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((Object) null, this);
    }
}
