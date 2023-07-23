package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.PemResponse;
import media.tiger.tigerbox.usecase.RequestPemCertificateUseCase;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.usecase.RequestPemCertificateUseCase", mo34424f = "RequestPemCertificateUseCase.kt", mo34425i = {0, 0}, mo34426l = {54}, mo34427m = "run", mo34428n = {"params", "certificateSigningRequest"}, mo34429s = {"L$0", "L$1"})
/* compiled from: RequestPemCertificateUseCase.kt */
final class RequestPemCertificateUseCase$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RequestPemCertificateUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RequestPemCertificateUseCase$run$1(RequestPemCertificateUseCase requestPemCertificateUseCase, Continuation<? super RequestPemCertificateUseCase$run$1> continuation) {
        super(continuation);
        this.this$0 = requestPemCertificateUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.run((RequestPemCertificateUseCase.RequestPemCertificateParams) null, (Continuation<? super Either<? extends Failure, ? extends PemResponse>>) this);
    }
}
