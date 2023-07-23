package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$invoke$1", mo34424f = "DecryptFirmware.kt", mo34425i = {}, mo34426l = {55}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$invoke$1 */
/* compiled from: DecryptFirmware.kt */
final class DecryptFirmware$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<DecryptFirmware.FailureReason, Unit> $onFail;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ Function1<Double, Unit> $onUpdate;
    final /* synthetic */ ReleaseInformation.Release $release;
    int label;
    final /* synthetic */ DecryptFirmware this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DecryptFirmware$invoke$1(DecryptFirmware decryptFirmware, ReleaseInformation.Release release, Function1<? super Double, Unit> function1, Function0<Unit> function0, Function1<? super DecryptFirmware.FailureReason, Unit> function12, Continuation<? super DecryptFirmware$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = decryptFirmware;
        this.$release = release;
        this.$onUpdate = function1;
        this.$onSuccess = function0;
        this.$onFail = function12;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DecryptFirmware$invoke$1(this.this$0, this.$release, this.$onUpdate, this.$onSuccess, this.$onFail, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DecryptFirmware$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DecryptFirmware decryptFirmware = this.this$0;
            final DecryptFirmware.FirmwareDecryptionResult access$decryptFirmware = decryptFirmware.decryptFirmware(decryptFirmware.assetService.getOtaPrivateKey(), this.this$0.storageService.getFirmwareDownloadPath(), this.this$0.storageService.getFirmwareInstallPath(), this.$release, this.$onUpdate);
            final Function0<Unit> function0 = this.$onSuccess;
            final Function1<DecryptFirmware.FailureReason, Unit> function1 = this.$onFail;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C29881((Continuation<? super C29881>) null), this) == coroutine_suspended) {
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
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$invoke$1$1", mo34424f = "DecryptFirmware.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$invoke$1$1 */
    /* compiled from: DecryptFirmware.kt */
    static final class C29881 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29881(access$decryptFirmware, function0, function1, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29881) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DecryptFirmware.FirmwareDecryptionResult firmwareDecryptionResult = access$decryptFirmware;
                if (Intrinsics.areEqual((Object) firmwareDecryptionResult, (Object) DecryptFirmware.FirmwareDecryptionResult.Success.INSTANCE)) {
                    function0.invoke();
                } else if (firmwareDecryptionResult instanceof DecryptFirmware.FirmwareDecryptionResult.Failure) {
                    function1.invoke(((DecryptFirmware.FirmwareDecryptionResult.Failure) access$decryptFirmware).getFailureReason());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
