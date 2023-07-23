package media.tiger.tigerbox.infrastructure.interactor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000\"\u0006\b\u0001\u0010\u0003 \u0001*\u00020\u0004H@"}, mo33737d2 = {"<anonymous>", "", "Params", "Type", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.infrastructure.interactor.UseCase$invoke$2", mo34424f = "UseCase.kt", mo34425i = {}, mo34426l = {37}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: UseCase.kt */
final class UseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Either<? extends Failure, ? extends Type>, Unit> $onResult;
    final /* synthetic */ Params $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UseCase<Params, Type> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UseCase$invoke$2(UseCase<? super Params, ? extends Type> useCase, Function1<? super Either<? extends Failure, ? extends Type>, Unit> function1, Params params, Continuation<? super UseCase$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = useCase;
        this.$onResult = function1;
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UseCase$invoke$2 useCase$invoke$2 = new UseCase$invoke$2(this.this$0, this.$onResult, this.$params, continuation);
        useCase$invoke$2.L$0 = obj;
        return useCase$invoke$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Function1<Either<? extends Failure, ? extends Type>, Unit> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, this.this$0.coroutineDispatcher, (CoroutineStart) null, new UseCase$invoke$2$deferred$1(this.this$0, this.$params, (Continuation<? super UseCase$invoke$2$deferred$1>) null), 2, (Object) null);
            Function1<Either<? extends Failure, ? extends Type>, Unit> function12 = this.$onResult;
            this.L$0 = function12;
            this.label = 1;
            obj = async$default.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            function1 = function12;
        } else if (i == 1) {
            function1 = (Function1) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function1.invoke(obj);
        return Unit.INSTANCE;
    }
}
