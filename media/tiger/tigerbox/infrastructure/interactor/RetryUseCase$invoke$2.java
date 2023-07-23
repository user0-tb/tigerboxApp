package media.tiger.tigerbox.infrastructure.interactor;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0000\"\u0006\b\u0001\u0010\u0003 \u0001*\u00020\u0004H@"}, mo33737d2 = {"<anonymous>", "", "Params", "Type", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.infrastructure.interactor.RetryUseCase$invoke$2", mo34424f = "RetryUseCase.kt", mo34425i = {1}, mo34426l = {38, 41}, mo34427m = "invokeSuspend", mo34428n = {"attempts"}, mo34429s = {"I$0"})
/* compiled from: RetryUseCase.kt */
final class RetryUseCase$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Either<? extends Failure, ? extends Type>, Unit> $onResult;
    final /* synthetic */ Params $params;
    int I$0;
    int label;
    final /* synthetic */ RetryUseCase<Params, Type> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RetryUseCase$invoke$2(RetryUseCase<? super Params, ? extends Type> retryUseCase, Function1<? super Either<? extends Failure, ? extends Type>, Unit> function1, Params params, Continuation<? super RetryUseCase$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = retryUseCase;
        this.$onResult = function1;
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RetryUseCase$invoke$2(this.this$0, this.$onResult, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RetryUseCase$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r4) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            int r1 = r9.I$0
            kotlin.ResultKt.throwOnFailure(r10)
            r5 = r9
            goto L_0x0077
        L_0x0016:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0044
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r10)
            media.tiger.tigerbox.infrastructure.interactor.RetryUseCase<Params, Type> r10 = r9.this$0
            kotlinx.coroutines.CoroutineDispatcher r10 = r10.coroutineDispatcher
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            media.tiger.tigerbox.infrastructure.interactor.RetryUseCase$invoke$2$result$1 r1 = new media.tiger.tigerbox.infrastructure.interactor.RetryUseCase$invoke$2$result$1
            media.tiger.tigerbox.infrastructure.interactor.RetryUseCase<Params, Type> r5 = r9.this$0
            Params r6 = r9.$params
            r1.<init>(r5, r6, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r9.label = r4
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r1, r5)
            if (r10 != r0) goto L_0x0044
            return r0
        L_0x0044:
            media.tiger.tigerbox.infrastructure.functional.Either r10 = (media.tiger.tigerbox.infrastructure.functional.Either) r10
            r5 = r9
            r1 = 1
        L_0x0048:
            boolean r6 = r10.isLeft()
            if (r6 == 0) goto L_0x007b
            media.tiger.tigerbox.infrastructure.interactor.RetryUseCase<Params, Type> r6 = r5.this$0
            int r6 = r6.maxAttempts
            if (r1 >= r6) goto L_0x007b
            media.tiger.tigerbox.infrastructure.interactor.RetryUseCase<Params, Type> r10 = r5.this$0
            kotlinx.coroutines.CoroutineDispatcher r10 = r10.coroutineDispatcher
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            media.tiger.tigerbox.infrastructure.interactor.RetryUseCase$invoke$2$1 r6 = new media.tiger.tigerbox.infrastructure.interactor.RetryUseCase$invoke$2$1
            media.tiger.tigerbox.infrastructure.interactor.RetryUseCase<Params, Type> r7 = r5.this$0
            Params r8 = r5.$params
            r6.<init>(r7, r8, r2)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = r5
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r5.I$0 = r1
            r5.label = r3
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r6, r7)
            if (r10 != r0) goto L_0x0077
            return r0
        L_0x0077:
            media.tiger.tigerbox.infrastructure.functional.Either r10 = (media.tiger.tigerbox.infrastructure.functional.Either) r10
            int r1 = r1 + r4
            goto L_0x0048
        L_0x007b:
            kotlin.jvm.functions.Function1<media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, ? extends Type>, kotlin.Unit> r0 = r5.$onResult
            r0.invoke(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.infrastructure.interactor.RetryUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
