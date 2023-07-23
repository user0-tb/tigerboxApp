package media.tiger.tigerbox.data.repository;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestUpdatedProfilesInfoFromServer$1", mo34424f = "TigerBoxUserRepository.kt", mo34425i = {}, mo34426l = {381}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestUpdatedProfilesInfoFromServer$1 */
/* compiled from: TigerBoxUserRepository.kt */
final class C2856xa4450ed8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Either<? extends Failure, ? extends List<TigerBoxProfileDomain>>, Unit> $onResult;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2856xa4450ed8(DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository, Function1<? super Either<? extends Failure, ? extends List<TigerBoxProfileDomain>>, Unit> function1, Continuation<? super C2856xa4450ed8> continuation) {
        super(2, continuation);
        this.this$0 = defaultTigerBoxAccountRepository;
        this.$onResult = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C2856xa4450ed8 defaultTigerBoxAccountRepository$requestUpdatedProfilesInfoFromServer$1 = new C2856xa4450ed8(this.this$0, this.$onResult, continuation);
        defaultTigerBoxAccountRepository$requestUpdatedProfilesInfoFromServer$1.L$0 = obj;
        return defaultTigerBoxAccountRepository$requestUpdatedProfilesInfoFromServer$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C2856xa4450ed8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Deferred async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new C2858x8aee6df8(this.this$0, (Continuation<? super C2858x8aee6df8>) null), 3, (Object) null);
            final DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository = this.this$0;
            final Function1<Either<? extends Failure, ? extends List<TigerBoxProfileDomain>>, Unit> function1 = this.$onResult;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C28571((Continuation<? super C28571>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestUpdatedProfilesInfoFromServer$1$1", mo34424f = "TigerBoxUserRepository.kt", mo34425i = {}, mo34426l = {382}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestUpdatedProfilesInfoFromServer$1$1 */
    /* compiled from: TigerBoxUserRepository.kt */
    static final class C28571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28571(async$default, defaultTigerBoxAccountRepository, function1, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = async$default.await(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Either either = (Either) obj;
            defaultTigerBoxAccountRepository.updateActiveProfileForCurrentDevice();
            Function1<Either<? extends Failure, ? extends List<TigerBoxProfileDomain>>, Unit> function1 = function1;
            if (function1 != null) {
                function1.invoke(either);
            }
            return Unit.INSTANCE;
        }
    }
}
