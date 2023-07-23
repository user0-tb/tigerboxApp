package media.tiger.tigerbox.infrastructure.interactor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.infrastructure.exception.GeneratingCertificateFailure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0006\b\u0000\u0010\u0003 \u0000\"\u0006\b\u0001\u0010\u0004 \u0001*\u00020\u0005H@"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/infrastructure/functional/Either$Left;", "Lmedia/tiger/tigerbox/infrastructure/exception/GeneratingCertificateFailure$PemRequestFailure;", "Params", "Type", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$3", mo34424f = "UseCasePostOnMain.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: UseCasePostOnMain.kt */
final class UseCasePostOnMain$invoke$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either.Left<? extends GeneratingCertificateFailure.PemRequestFailure>>, Object> {
    int label;

    UseCasePostOnMain$invoke$3(Continuation<? super UseCasePostOnMain$invoke$3> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UseCasePostOnMain$invoke$3(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either.Left<GeneratingCertificateFailure.PemRequestFailure>> continuation) {
        return ((UseCasePostOnMain$invoke$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new Either.Left(GeneratingCertificateFailure.PemRequestFailure.INSTANCE);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
