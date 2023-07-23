package media.tiger.tigerbox.data.repository;

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
import media.tiger.tigerbox.model.dto.DeviceInformation;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H@"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$1$deferred$1", mo34424f = "TigerBoxUserRepository.kt", mo34425i = {}, mo34426l = {405}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$1$deferred$1 */
/* compiled from: TigerBoxUserRepository.kt */
final class C2861xf778e2fd extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Failure, ? extends DeviceInformation>>, Object> {
    int label;
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2861xf778e2fd(DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository, Continuation<? super C2861xf778e2fd> continuation) {
        super(2, continuation);
        this.this$0 = defaultTigerBoxAccountRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C2861xf778e2fd(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<? extends Failure, DeviceInformation>> continuation) {
        return ((C2861xf778e2fd) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository = this.this$0;
            DeviceInformation deviceInformation = defaultTigerBoxAccountRepository.storageService.getDeviceInformation();
            if (deviceInformation == null || (str = deviceInformation.getDeviceIdentifier()) == null) {
                str = "";
            }
            this.label = 1;
            obj = defaultTigerBoxAccountRepository.requestDeviceInformation(str, this);
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
