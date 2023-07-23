package media.tiger.tigerbox.data.repository;

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
import media.tiger.tigerbox.model.dto.DeviceInformation;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$1", mo34424f = "TigerBoxUserRepository.kt", mo34425i = {}, mo34426l = {409}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$1 */
/* compiled from: TigerBoxUserRepository.kt */
final class C2859x7c118af3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Either<? extends Failure, DeviceInformation>, Unit> $onDeviceInformationResult;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2859x7c118af3(DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository, Function1<? super Either<? extends Failure, DeviceInformation>, Unit> function1, Continuation<? super C2859x7c118af3> continuation) {
        super(2, continuation);
        this.this$0 = defaultTigerBoxAccountRepository;
        this.$onDeviceInformationResult = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        C2859x7c118af3 defaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$1 = new C2859x7c118af3(this.this$0, this.$onDeviceInformationResult, continuation);
        defaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$1.L$0 = obj;
        return defaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((C2859x7c118af3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Deferred async$default = BuildersKt__Builders_commonKt.async$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new C2861xf778e2fd(this.this$0, (Continuation<? super C2861xf778e2fd>) null), 3, (Object) null);
            final Function1<Either<? extends Failure, DeviceInformation>, Unit> function1 = this.$onDeviceInformationResult;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C28601((Continuation<? super C28601>) null), this) == coroutine_suspended) {
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
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$1$1", mo34424f = "TigerBoxUserRepository.kt", mo34425i = {}, mo34426l = {410}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$updateActiveProfileForCurrentDevice$1$1 */
    /* compiled from: TigerBoxUserRepository.kt */
    static final class C28601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28601(function1, async$default, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Function1<Either<? extends Failure, DeviceInformation>, Unit> function1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Either<? extends Failure, DeviceInformation>, Unit> function12 = function1;
                this.L$0 = function12;
                this.label = 1;
                Object await = async$default.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function1 = function12;
                obj = await;
            } else if (i == 1) {
                function1 = (Function1) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1.invoke(obj);
            return Unit.INSTANCE;
        }
    }
}
