package media.tiger.tigerbox.data.repository;

import java.util.List;
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
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0005H@"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "", "Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestUpdatedProfilesInfoFromServer$1$deferred$1", mo34424f = "TigerBoxUserRepository.kt", mo34425i = {}, mo34426l = {378}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestUpdatedProfilesInfoFromServer$1$deferred$1 */
/* compiled from: TigerBoxUserRepository.kt */
final class C2858x8aee6df8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Failure, ? extends List<? extends TigerBoxProfileDomain>>>, Object> {
    int label;
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2858x8aee6df8(DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository, Continuation<? super C2858x8aee6df8> continuation) {
        super(2, continuation);
        this.this$0 = defaultTigerBoxAccountRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C2858x8aee6df8(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<? extends Failure, ? extends List<TigerBoxProfileDomain>>> continuation) {
        return ((C2858x8aee6df8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.fetchProfilesInfo(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
