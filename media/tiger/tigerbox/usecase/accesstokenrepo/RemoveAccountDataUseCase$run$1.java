package media.tiger.tigerbox.usecase.accesstokenrepo;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase", mo34424f = "RemoveAccountDataUseCase.kt", mo34425i = {0}, mo34426l = {29, 30}, mo34427m = "run", mo34428n = {"this"}, mo34429s = {"L$0"})
/* compiled from: RemoveAccountDataUseCase.kt */
final class RemoveAccountDataUseCase$run$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoveAccountDataUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RemoveAccountDataUseCase$run$1(RemoveAccountDataUseCase removeAccountDataUseCase, Continuation<? super RemoveAccountDataUseCase$run$1> continuation) {
        super(continuation);
        this.this$0 = removeAccountDataUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((Unit) null, (Continuation<? super Either.Right<Unit>>) this);
    }
}
