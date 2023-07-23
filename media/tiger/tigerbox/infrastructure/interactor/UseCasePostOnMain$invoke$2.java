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
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0006\b\u0000\u0010\u0004 \u0000\"\u0006\b\u0001\u0010\u0003 \u0001*\u00020\u0005H@"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Type", "Params", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$2", mo34424f = "UseCasePostOnMain.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: UseCasePostOnMain.kt */
final class UseCasePostOnMain$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Failure, ? extends Type>>, Object> {
    final /* synthetic */ Either<Failure, Type> $result;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UseCasePostOnMain$invoke$2(Either<? extends Failure, ? extends Type> either, Continuation<? super UseCasePostOnMain$invoke$2> continuation) {
        super(2, continuation);
        this.$result = either;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UseCasePostOnMain$invoke$2(this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<? extends Failure, ? extends Type>> continuation) {
        return ((UseCasePostOnMain$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$result;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
