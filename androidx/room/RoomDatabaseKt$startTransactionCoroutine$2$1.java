package androidx.room;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "", "R", "run"}, mo33738k = 3, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* compiled from: RoomDatabaseExt.kt */
final class RoomDatabaseKt$startTransactionCoroutine$2$1 implements Runnable {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ CancellableContinuation<R> $continuation;
    final /* synthetic */ RoomDatabase $this_startTransactionCoroutine;
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super R>, Object> $transactionBlock;

    RoomDatabaseKt$startTransactionCoroutine$2$1(CoroutineContext coroutineContext, CancellableContinuation<? super R> cancellableContinuation, RoomDatabase roomDatabase, Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2) {
        this.$context = coroutineContext;
        this.$continuation = cancellableContinuation;
        this.$this_startTransactionCoroutine = roomDatabase;
        this.$transactionBlock = function2;
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, mo33737d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1", mo34424f = "RoomDatabaseExt.kt", mo34425i = {}, mo34426l = {97}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: androidx.room.RoomDatabaseKt$startTransactionCoroutine$2$1$1 */
    /* compiled from: RoomDatabaseExt.kt */
    static final class C07171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07171 r0 = new C07171(roomDatabase, cancellableContinuation, function2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Continuation continuation;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineContext.Element element = ((CoroutineScope) this.L$0).getCoroutineContext().get(ContinuationInterceptor.Key);
                Intrinsics.checkNotNull(element);
                CoroutineContext access$createTransactionContext = RoomDatabaseKt.createTransactionContext(roomDatabase, (ContinuationInterceptor) element);
                Continuation continuation2 = cancellableContinuation;
                this.L$0 = continuation2;
                this.label = 1;
                obj = BuildersKt.withContext(access$createTransactionContext, function2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                continuation = continuation2;
            } else if (i == 1) {
                continuation = (Continuation) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m772constructorimpl(obj));
            return Unit.INSTANCE;
        }
    }

    public final void run() {
        try {
            CoroutineContext minusKey = this.$context.minusKey(ContinuationInterceptor.Key);
            final RoomDatabase roomDatabase = this.$this_startTransactionCoroutine;
            final CancellableContinuation<R> cancellableContinuation = this.$continuation;
            final Function2<CoroutineScope, Continuation<? super R>, Object> function2 = this.$transactionBlock;
            BuildersKt.runBlocking(minusKey, new C07171((Continuation<? super C07171>) null));
        } catch (Throwable th) {
            this.$continuation.cancel(th);
        }
    }
}
