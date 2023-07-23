package media.tiger.tigerbox.services.implementations;

import com.google.gson.Gson;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.model.domain.AccountSubscriptionDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.AccountSubscription$updateLocalInfo$1", mo34424f = "AccountSubscription.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: AccountSubscription.kt */
final class AccountSubscription$updateLocalInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AccountSubscriptionDomain $info;
    int label;
    final /* synthetic */ AccountSubscription this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountSubscription$updateLocalInfo$1(AccountSubscriptionDomain accountSubscriptionDomain, AccountSubscription accountSubscription, Continuation<? super AccountSubscription$updateLocalInfo$1> continuation) {
        super(2, continuation);
        this.$info = accountSubscriptionDomain;
        this.this$0 = accountSubscription;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountSubscription$updateLocalInfo$1(this.$info, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountSubscription$updateLocalInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                this.this$0.sharedPreferences.edit().putString("localAccountSubscriptionInfo", new Gson().toJson((Object) this.$info, new AccountSubscription$updateLocalInfo$1$statesType$1().getType())).apply();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
