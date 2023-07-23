package media.tiger.tigerbox.infrastructure.interactor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\n\u001a\u00028\u0000HBø\u0001\u0000¢\u0006\u0002\u0010\u000bJ%\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\n\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/interactor/UseCaseWithReturn;", "Params", "Type", "", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "invoke", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "run", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: UseCaseWithReturn.kt */
public abstract class UseCaseWithReturn<Params, Type> {
    private final CoroutineDispatcher coroutineDispatcher;

    public abstract Object run(Params params, Continuation<? super Either<? extends Failure, ? extends Type>> continuation);

    public UseCaseWithReturn(CoroutineDispatcher coroutineDispatcher2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "coroutineDispatcher");
        this.coroutineDispatcher = coroutineDispatcher2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(Params r6, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, ? extends Type>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn$invoke$1 r0 = (media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn$invoke$1 r0 = new media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn$invoke$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x004d }
            goto L_0x004a
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CoroutineDispatcher r7 = r5.coroutineDispatcher     // Catch:{ Exception -> 0x004d }
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7     // Catch:{ Exception -> 0x004d }
            media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn$invoke$2 r2 = new media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn$invoke$2     // Catch:{ Exception -> 0x004d }
            r4 = 0
            r2.<init>(r5, r6, r4)     // Catch:{ Exception -> 0x004d }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ Exception -> 0x004d }
            r0.label = r3     // Catch:{ Exception -> 0x004d }
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)     // Catch:{ Exception -> 0x004d }
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            media.tiger.tigerbox.infrastructure.functional.Either r7 = (media.tiger.tigerbox.infrastructure.functional.Either) r7     // Catch:{ Exception -> 0x004d }
            goto L_0x0057
        L_0x004d:
            media.tiger.tigerbox.infrastructure.functional.Either$Left r6 = new media.tiger.tigerbox.infrastructure.functional.Either$Left
            media.tiger.tigerbox.infrastructure.exception.Failure$DefaultError r7 = media.tiger.tigerbox.infrastructure.exception.Failure.DefaultError.INSTANCE
            r6.<init>(r7)
            r7 = r6
            media.tiger.tigerbox.infrastructure.functional.Either r7 = (media.tiger.tigerbox.infrastructure.functional.Either) r7
        L_0x0057:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn.invoke(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
