package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.dto.DeviceInformation;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.usecase.AssignBoxToAccountUseCase", mo34424f = "AssignBoxToAccountUseCase.kt", mo34425i = {0}, mo34426l = {24}, mo34427m = "run", mo34428n = {"this"}, mo34429s = {"L$0"})
/* compiled from: AssignBoxToAccountUseCase.kt */
final class AssignBoxToAccountUseCase$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AssignBoxToAccountUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssignBoxToAccountUseCase$run$1(AssignBoxToAccountUseCase assignBoxToAccountUseCase, Continuation<? super AssignBoxToAccountUseCase$run$1> continuation) {
        super(continuation);
        this.this$0 = assignBoxToAccountUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((AssignBoxToAccountParameters) null, (Continuation<? super Either<? extends Failure, DeviceInformation>>) this);
    }
}
