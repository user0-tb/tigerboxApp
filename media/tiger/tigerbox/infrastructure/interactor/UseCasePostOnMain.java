package media.tiger.tigerbox.infrastructure.interactor;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\b\u001a\u00028\u0000HBø\u0001\u0000¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\b\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/interactor/UseCasePostOnMain;", "Params", "Type", "", "()V", "invoke", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "params", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "run", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: UseCasePostOnMain.kt */
public abstract class UseCasePostOnMain<Params, Type> {
    public abstract Object run(Params params, Continuation<? super Either<? extends Failure, ? extends Type>> continuation);

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A[Catch:{ Exception -> 0x0041 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(Params r8, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, ? extends Type>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$1 r0 = (media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$1 r0 = new media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r6) goto L_0x003d
            if (r2 == r5) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0080
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0067
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ Exception -> 0x0041 }
            goto L_0x004f
        L_0x0041:
            goto L_0x006a
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.label = r6     // Catch:{ Exception -> 0x0041 }
            java.lang.Object r9 = r7.run(r8, r0)     // Catch:{ Exception -> 0x0041 }
            if (r9 != r1) goto L_0x004f
            return r1
        L_0x004f:
            media.tiger.tigerbox.infrastructure.functional.Either r9 = (media.tiger.tigerbox.infrastructure.functional.Either) r9     // Catch:{ Exception -> 0x0041 }
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ Exception -> 0x0041 }
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8     // Catch:{ Exception -> 0x0041 }
            media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$2 r2 = new media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$2     // Catch:{ Exception -> 0x0041 }
            r2.<init>(r9, r3)     // Catch:{ Exception -> 0x0041 }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ Exception -> 0x0041 }
            r0.label = r5     // Catch:{ Exception -> 0x0041 }
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)     // Catch:{ Exception -> 0x0041 }
            if (r9 != r1) goto L_0x0067
            return r1
        L_0x0067:
            media.tiger.tigerbox.infrastructure.functional.Either r9 = (media.tiger.tigerbox.infrastructure.functional.Either) r9     // Catch:{ Exception -> 0x0041 }
            goto L_0x0082
        L_0x006a:
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$3 r9 = new media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain$invoke$3
            r9.<init>(r3)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r0.label = r4
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r8, r9, r0)
            if (r9 != r1) goto L_0x0080
            return r1
        L_0x0080:
            media.tiger.tigerbox.infrastructure.functional.Either r9 = (media.tiger.tigerbox.infrastructure.functional.Either) r9
        L_0x0082:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.infrastructure.interactor.UseCasePostOnMain.invoke(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
