package media.tiger.tigerbox.usecase;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.infrastructure.interactor.UseCaseWithReturn;
import media.tiger.tigerbox.services.interfaces.StorageService;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\u0006\u0010\u000b\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/OnboardingCompletedUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/UseCaseWithReturn;", "", "", "preferenceStorage", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either$Right;", "params", "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: OnboardingCompletedUseCase.kt */
public class OnboardingCompletedUseCase extends UseCaseWithReturn<Unit, Boolean> {
    private final StorageService preferenceStorage;

    public Object run(Unit unit, Continuation<? super Either.Right<Boolean>> continuation) {
        return run$suspendImpl(this, unit, continuation);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public OnboardingCompletedUseCase(StorageService storageService, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(storageService, "preferenceStorage");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.preferenceStorage = storageService;
    }

    static /* synthetic */ Object run$suspendImpl(OnboardingCompletedUseCase onboardingCompletedUseCase, Unit unit, Continuation continuation) {
        return new Either.Right(Boxing.boxBoolean(onboardingCompletedUseCase.preferenceStorage.getOnboardingCompleted()));
    }
}
