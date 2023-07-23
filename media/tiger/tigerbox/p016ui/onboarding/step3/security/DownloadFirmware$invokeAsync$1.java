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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DownloadFirmware;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "validationResult", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$ValidationResult;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$invokeAsync$1 */
/* compiled from: DownloadFirmware.kt */
final class DownloadFirmware$invokeAsync$1 extends Lambda implements Function1<DownloadFirmware.ValidationResult, Unit> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Function1<DownloadFirmware.FailReason, Unit> $onFail;
    final /* synthetic */ Function0<Unit> $onSuccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DownloadFirmware$invokeAsync$1(CoroutineScope coroutineScope, Function0<Unit> function0, Function1<? super DownloadFirmware.FailReason, Unit> function1) {
        super(1);
        this.$coroutineScope = coroutineScope;
        this.$onSuccess = function0;
        this.$onFail = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DownloadFirmware.ValidationResult) obj);
        return Unit.INSTANCE;
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$invokeAsync$1$1", mo34424f = "DownloadFirmware.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$invokeAsync$1$1 */
    /* compiled from: DownloadFirmware.kt */
    static final class C29901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29901(validationResult, function0, function1, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DownloadFirmware.ValidationResult validationResult = validationResult;
                if (Intrinsics.areEqual((Object) validationResult, (Object) DownloadFirmware.ValidationResult.Success.INSTANCE)) {
                    function0.invoke();
                } else if (validationResult instanceof DownloadFirmware.ValidationResult.Failure) {
                    function1.invoke(((DownloadFirmware.ValidationResult.Failure) validationResult).getFailReason());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void invoke(final DownloadFirmware.ValidationResult validationResult) {
        Intrinsics.checkNotNullParameter(validationResult, "validationResult");
        final Function0<Unit> function0 = this.$onSuccess;
        final Function1<DownloadFirmware.FailReason, Unit> function1 = this.$onFail;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.$coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new C29901((Continuation<? super C29901>) null), 2, (Object) null);
    }
}
