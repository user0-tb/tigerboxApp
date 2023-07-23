package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.model.dto.Acquisition;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.SharedPreferencesStorageService$saveAcquisitions$1", mo34424f = "SharedPreferencesStorageService.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: SharedPreferencesStorageService.kt */
final class SharedPreferencesStorageService$saveAcquisitions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Acquisition> $acquisitions;
    final /* synthetic */ int $productId;
    int label;
    final /* synthetic */ SharedPreferencesStorageService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SharedPreferencesStorageService$saveAcquisitions$1(int i, List<Acquisition> list, SharedPreferencesStorageService sharedPreferencesStorageService, Continuation<? super SharedPreferencesStorageService$saveAcquisitions$1> continuation) {
        super(2, continuation);
        this.$productId = i;
        this.$acquisitions = list;
        this.this$0 = sharedPreferencesStorageService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SharedPreferencesStorageService$saveAcquisitions$1(this.$productId, this.$acquisitions, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SharedPreferencesStorageService$saveAcquisitions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final String str = "ACQUISITIONS_" + this.$productId;
            final String json = new Gson().toJson((Object) this.$acquisitions);
            SharedPreferencesStorageServiceKt.save(this.this$0.encryptedSharedPreferences, new Function1<SharedPreferences.Editor, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SharedPreferences.Editor) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(SharedPreferences.Editor editor) {
                    Intrinsics.checkNotNullParameter(editor, "it");
                    editor.putString(str, json);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
