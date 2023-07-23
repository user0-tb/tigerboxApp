package media.tiger.tigerbox.data.repository;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$4$1", mo34424f = "TigerBoxUserRepository.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: TigerBoxUserRepository.kt */
final class DefaultTigerBoxAccountRepository$fetchAccountInfo$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultTigerBoxAccountRepository$fetchAccountInfo$4$1(DefaultTigerBoxAccountRepository defaultTigerBoxAccountRepository, Continuation<? super DefaultTigerBoxAccountRepository$fetchAccountInfo$4$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultTigerBoxAccountRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultTigerBoxAccountRepository$fetchAccountInfo$4$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultTigerBoxAccountRepository$fetchAccountInfo$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Iterator it = this.this$0.listeners.iterator();
            while (it.hasNext()) {
                ((ProfileChangeListener) it.next()).didUpdateProfilesInfo();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
