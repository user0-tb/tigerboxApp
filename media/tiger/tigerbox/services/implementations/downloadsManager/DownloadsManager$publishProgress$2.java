package media.tiger.tigerbox.services.implementations.downloadsManager;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerListener;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager$publishProgress$2", mo34424f = "DownloadsManager.kt", mo34425i = {}, mo34426l = {392}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: DownloadsManager.kt */
final class DownloadsManager$publishProgress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadJobImpl $request;
    int label;
    final /* synthetic */ DownloadsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DownloadsManager$publishProgress$2(DownloadsManager downloadsManager, DownloadJobImpl downloadJobImpl, Continuation<? super DownloadsManager$publishProgress$2> continuation) {
        super(2, continuation);
        this.this$0 = downloadsManager;
        this.$request = downloadJobImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadsManager$publishProgress$2(this.this$0, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadsManager$publishProgress$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    @DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager$publishProgress$2$1", mo34424f = "DownloadsManager.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
    /* renamed from: media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager$publishProgress$2$1 */
    /* compiled from: DownloadsManager.kt */
    static final class C29161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29161(downloadsManager, downloadJobImpl, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Iterator it = downloadsManager.listeners.iterator();
                while (it.hasNext()) {
                    ((DownloadsManagerListener) it.next()).downloadRequestProgressed(downloadJobImpl);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final DownloadsManager downloadsManager = this.this$0;
            final DownloadJobImpl downloadJobImpl = this.$request;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C29161((Continuation<? super C29161>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
