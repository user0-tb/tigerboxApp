package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$invoke$1", mo34424f = "ValidateUpdateSignature.kt", mo34425i = {}, mo34426l = {104}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$invoke$1 */
/* compiled from: ValidateUpdateSignature.kt */
final class ValidateUpdateSignature$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ValidateUpdateSignature.FailReason, Unit> $onFail;
    final /* synthetic */ Function1<ReleaseInformation.Release, Unit> $onSuccess;
    int label;
    final /* synthetic */ ValidateUpdateSignature this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ValidateUpdateSignature$invoke$1(ValidateUpdateSignature validateUpdateSignature, Function1<? super ReleaseInformation.Release, Unit> function1, Function1<? super ValidateUpdateSignature.FailReason, Unit> function12, Continuation<? super ValidateUpdateSignature$invoke$1> continuation) {
        super(2, continuation);
        this.this$0 = validateUpdateSignature;
        this.$onSuccess = function1;
        this.$onFail = function12;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ValidateUpdateSignature$invoke$1(this.this$0, this.$onSuccess, this.$onFail, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ValidateUpdateSignature$invoke$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final ValidateUpdateSignature.ValidationResult access$validateSignature = this.this$0.validateSignature();
            final Function1<ReleaseInformation.Release, Unit> function1 = this.$onSuccess;
            final Function1<ValidateUpdateSignature.FailReason, Unit> function12 = this.$onFail;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C29911((Continuation<? super C29911>) null), this) == coroutine_suspended) {
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
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$invoke$1$1", mo34424f = "ValidateUpdateSignature.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature$invoke$1$1 */
    /* compiled from: ValidateUpdateSignature.kt */
    static final class C29911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29911(access$validateSignature, function1, function12, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ValidateUpdateSignature.ValidationResult validationResult = access$validateSignature;
                if (validationResult instanceof ValidateUpdateSignature.ValidationResult.Success) {
                    function1.invoke(((ValidateUpdateSignature.ValidationResult.Success) validationResult).getRelease());
                } else if (validationResult instanceof ValidateUpdateSignature.ValidationResult.Failure) {
                    function12.invoke(((ValidateUpdateSignature.ValidationResult.Failure) validationResult).getFailReason());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
