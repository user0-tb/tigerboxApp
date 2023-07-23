package media.tiger.tigerbox.usecase;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.infrastructure.interactor.UseCase;
import media.tiger.tigerbox.services.interfaces.StorageService;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/usecase/OnboardingCompleteActionUseCase;", "Lmedia/tiger/tigerbox/infrastructure/interactor/UseCase;", "", "preferenceStorage", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "run", "Lmedia/tiger/tigerbox/infrastructure/functional/Either$Right;", "params", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: OnboardingCompleteActionUseCase.kt */
public final class OnboardingCompleteActionUseCase extends UseCase<Boolean, Boolean> {
    private final StorageService preferenceStorage;

    public /* bridge */ /* synthetic */ Object run(Object obj, Continuation continuation) {
        return run(((Boolean) obj).booleanValue(), (Continuation<? super Either.Right<Boolean>>) continuation);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public OnboardingCompleteActionUseCase(StorageService storageService, CoroutineDispatcher coroutineDispatcher) {
        super(coroutineDispatcher);
        Intrinsics.checkNotNullParameter(storageService, "preferenceStorage");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.preferenceStorage = storageService;
    }

    public Object run(boolean z, Continuation<? super Either.Right<Boolean>> continuation) {
        return this.preferenceStorage.completeOnboarding(z, continuation);
    }
}
