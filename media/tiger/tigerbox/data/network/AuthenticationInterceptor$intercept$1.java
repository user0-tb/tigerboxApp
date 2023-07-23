package media.tiger.tigerbox.data.network;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.network.AuthenticationInterceptor$intercept$1", mo34424f = "AuthenticationInterceptor.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: AuthenticationInterceptor.kt */
final class AuthenticationInterceptor$intercept$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Request> $newRequest;
    final /* synthetic */ Request $originalRequest;
    final /* synthetic */ Response $response;
    final /* synthetic */ AtomicBoolean $testForRefreshingToken;
    int label;
    final /* synthetic */ AuthenticationInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthenticationInterceptor$intercept$1(Request request, Response response, AuthenticationInterceptor authenticationInterceptor, Ref.ObjectRef<Request> objectRef, AtomicBoolean atomicBoolean, Continuation<? super AuthenticationInterceptor$intercept$1> continuation) {
        super(2, continuation);
        this.$originalRequest = request;
        this.$response = response;
        this.this$0 = authenticationInterceptor;
        this.$newRequest = objectRef;
        this.$testForRefreshingToken = atomicBoolean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthenticationInterceptor$intercept$1(this.$originalRequest, this.$response, this.this$0, this.$newRequest, this.$testForRefreshingToken, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthenticationInterceptor$intercept$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("..........START - RESPONSE IS UNAUTHORIZED " + this.$originalRequest.url() + " ................", new Object[0]);
            Timber.Forest forest2 = Timber.Forest;
            forest2.mo50217e("Response is: " + this.$response, new Object[0]);
            Timber.Forest forest3 = Timber.Forest;
            forest3.mo50217e("Original request: " + this.$originalRequest, new Object[0]);
            Timber.Forest forest4 = Timber.Forest;
            forest4.mo50217e("Original request body: " + this.$originalRequest.body(), new Object[0]);
            Timber.Forest forest5 = Timber.Forest;
            forest5.mo50217e("Original request headers: " + this.$originalRequest.headers(), new Object[0]);
            Timber.Forest forest6 = Timber.Forest;
            forest6.mo50217e("Original request access token: " + this.this$0.getRequestAccessToken(this.$originalRequest), new Object[0]);
            Timber.Forest forest7 = Timber.Forest;
            forest7.mo50217e("Current Access Token: " + this.this$0.getAccessTokenUseCase.invoke().getAccessToken(), new Object[0]);
            Timber.Forest.mo50217e("..........END - RESPONSE IS UNAUTHORIZED................", new Object[0]);
            Timber.Forest forest8 = Timber.Forest;
            forest8.mo50217e("Start refresh token - caused by original request: " + this.$originalRequest.url(), new Object[0]);
            try {
                this.$newRequest.element = this.this$0.attemptReauthorizationAndUpdateRequest(this.$originalRequest);
            } catch (Exception e) {
                this.$testForRefreshingToken.set(false);
                Timber.Tree tag = Timber.Forest.tag("AuthenticationInterceptor");
                tag.mo50217e("Re-authenticate exception " + e, new Object[0]);
                this.this$0.rollbackToLogin();
            }
            Timber.Forest forest9 = Timber.Forest;
            forest9.mo50217e("Finished refreshing token - caused by original request: " + this.$originalRequest.url(), new Object[0]);
            this.$testForRefreshingToken.set(false);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
