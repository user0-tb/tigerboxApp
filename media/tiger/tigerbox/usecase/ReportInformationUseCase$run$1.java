package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.ReportInformation;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.usecase.ReportInformationUseCase", mo34424f = "ReportInformationUseCase.kt", mo34425i = {0}, mo34426l = {30}, mo34427m = "run", mo34428n = {"this"}, mo34429s = {"L$0"})
/* compiled from: ReportInformationUseCase.kt */
final class ReportInformationUseCase$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReportInformationUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReportInformationUseCase$run$1(ReportInformationUseCase reportInformationUseCase, Continuation<? super ReportInformationUseCase$run$1> continuation) {
        super(continuation);
        this.this$0 = reportInformationUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((ReportInformationRequestBody) null, (Continuation<? super Either<? extends Failure, ReportInformation>>) this);
    }
}
