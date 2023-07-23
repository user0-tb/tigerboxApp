package media.tiger.tigerbox.infrastructure.interactor;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ@\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2 \b\u0002\u0010\u000e\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0004\u0012\u00020\n0\u000fH\u0002¢\u0006\u0002\u0010\u0012J%\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00028\u00010\u00102\u0006\u0010\u000b\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/interactor/RetryUseCase;", "Params", "Type", "", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "maxAttempts", "", "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "invoke", "", "params", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onResult", "Lkotlin/Function1;", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "(Ljava/lang/Object;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;)V", "run", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RetryUseCase.kt */
public abstract class RetryUseCase<Params, Type> {
    /* access modifiers changed from: private */
    public final CoroutineDispatcher coroutineDispatcher;
    /* access modifiers changed from: private */
    public final int maxAttempts;

    public abstract Object run(Params params, Continuation<? super Either<? extends Failure, ? extends Type>> continuation);

    public RetryUseCase(CoroutineDispatcher coroutineDispatcher2, int i) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "coroutineDispatcher");
        this.coroutineDispatcher = coroutineDispatcher2;
        this.maxAttempts = i;
    }

    public static /* synthetic */ void invoke$default(RetryUseCase retryUseCase, Object obj, CoroutineScope coroutineScope, Function1 function1, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 4) != 0) {
                function1 = RetryUseCase$invoke$1.INSTANCE;
            }
            retryUseCase.invoke(obj, coroutineScope, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
    }

    public final void invoke(Params params, CoroutineScope coroutineScope, Function1<? super Either<? extends Failure, ? extends Type>, Unit> function1) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function1, "onResult");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new RetryUseCase$invoke$2(this, function1, params, (Continuation<? super RetryUseCase$invoke$2>) null), 2, (Object) null);
    }
}
