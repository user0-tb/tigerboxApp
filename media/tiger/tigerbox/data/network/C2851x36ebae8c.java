package media.tiger.tigerbox.data.network;

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
import media.tiger.tigerbox.model.domain.AccessTokenDomain;
import okhttp3.Request;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H@"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$1", mo34424f = "AuthenticationInterceptor.kt", mo34425i = {}, mo34426l = {183}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$1 */
/* compiled from: AuthenticationInterceptor.kt */
final class C2851x36ebae8c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Either<? extends Failure, ? extends AccessTokenDomain>>, Object> {
    final /* synthetic */ Request $request;
    int label;
    final /* synthetic */ AuthenticationInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2851x36ebae8c(Request request, AuthenticationInterceptor authenticationInterceptor, Continuation<? super C2851x36ebae8c> continuation) {
        super(2, continuation);
        this.$request = request;
        this.this$0 = authenticationInterceptor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C2851x36ebae8c(this.$request, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Either<? extends Failure, AccessTokenDomain>> continuation) {
        return ((C2851x36ebae8c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Tree tag = Timber.Forest.tag("AuthenticationInterceptor");
            tag.mo50217e("Start refreshing token - initiated by url: " + this.$request.url(), new Object[0]);
            this.label = 1;
            obj = this.this$0.requestReAuthAndStoreTokenUseCase.invoke(Unit.INSTANCE, this);
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
