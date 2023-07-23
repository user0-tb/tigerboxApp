package media.tiger.tigerbox.services.implementations.audioPlayer;

import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.services.implementations.audioPlayer.LastUsedProduct;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.LastUsedProduct$saveLastUsedProduct$1", mo34424f = "LastUsedProduct.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: LastUsedProduct.kt */
final class LastUsedProduct$saveLastUsedProduct$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $multicardCode;
    final /* synthetic */ int $productId;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ LastUsedProduct this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LastUsedProduct$saveLastUsedProduct$1(LastUsedProduct lastUsedProduct, String str, int i, String str2, Continuation<? super LastUsedProduct$saveLastUsedProduct$1> continuation) {
        super(2, continuation);
        this.this$0 = lastUsedProduct;
        this.$userId = str;
        this.$productId = i;
        this.$multicardCode = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LastUsedProduct$saveLastUsedProduct$1(this.this$0, this.$userId, this.$productId, this.$multicardCode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LastUsedProduct$saveLastUsedProduct$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            LastUsedProduct.LastUsedProductsPerUser access$localLastProductStates = this.this$0.localLastProductStates();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = access$localLastProductStates.getPerUserId().get(this.$userId);
            if (objectRef.element == null) {
                objectRef.element = new LastUsedProduct.CardOrDefault(this.this$0);
            }
            ((LastUsedProduct.CardOrDefault) objectRef.element).getCardOrDefautMap().put(LastUsedProduct.DEFAULT_LAST_USED_PRODUCT_KEY, Boxing.boxInt(this.$productId));
            String str = this.$multicardCode;
            if (str != null) {
                ((LastUsedProduct.CardOrDefault) objectRef.element).getCardOrDefautMap().put(str, Boxing.boxInt(this.$productId));
            }
            access$localLastProductStates.getPerUserId().put(this.$userId, objectRef.element);
            this.this$0.sharedPreferences.edit().putString(LastUsedProduct.USER_LAST_USED_PRODUCTS_KEY, new Gson().toJson((Object) access$localLastProductStates, new LastUsedProduct$saveLastUsedProduct$1$statesType$1().getType())).apply();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
