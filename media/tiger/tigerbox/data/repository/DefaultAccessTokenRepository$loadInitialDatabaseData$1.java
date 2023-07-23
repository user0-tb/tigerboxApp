package media.tiger.tigerbox.data.repository;

import android.util.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$loadInitialDatabaseData$1", mo34424f = "AccessTokenRepository.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: AccessTokenRepository.kt */
final class DefaultAccessTokenRepository$loadInitialDatabaseData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onDone;
    int label;
    final /* synthetic */ DefaultAccessTokenRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultAccessTokenRepository$loadInitialDatabaseData$1(DefaultAccessTokenRepository defaultAccessTokenRepository, Function0<Unit> function0, Continuation<? super DefaultAccessTokenRepository$loadInitialDatabaseData$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultAccessTokenRepository;
        this.$onDone = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultAccessTokenRepository$loadInitialDatabaseData$1(this.this$0, this.$onDone, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultAccessTokenRepository$loadInitialDatabaseData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AccessTokenDomain accessToken = this.this$0.tigerBoxDataBase.accessTokenDao().getAccessToken();
            if (accessToken != null) {
                this.this$0._accessToken.set(accessToken);
            }
            Log.d("TigerBoxUserRepository", "Initial read found tokens " + this.this$0._accessToken);
            this.this$0._loadDbInProgress.set(false);
            this.$onDone.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
