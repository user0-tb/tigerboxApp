package media.tiger.tigerbox.usecase;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.dto.Acquisition;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.usecase.CheckAcquisitionsUseCase", mo34424f = "CheckAcquisitionsUseCase.kt", mo34425i = {}, mo34426l = {21}, mo34427m = "run", mo34428n = {}, mo34429s = {})
/* compiled from: CheckAcquisitionsUseCase.kt */
final class CheckAcquisitionsUseCase$run$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CheckAcquisitionsUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckAcquisitionsUseCase$run$1(CheckAcquisitionsUseCase checkAcquisitionsUseCase, Continuation<? super CheckAcquisitionsUseCase$run$1> continuation) {
        super(continuation);
        this.this$0 = checkAcquisitionsUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((CheckAcquisitionsParameters) null, (Continuation<? super Either<? extends Failure, ? extends List<Acquisition>>>) this);
    }
}
