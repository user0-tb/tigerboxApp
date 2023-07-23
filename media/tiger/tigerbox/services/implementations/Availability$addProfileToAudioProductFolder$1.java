package media.tiger.tigerbox.services.implementations;

import java.io.File;
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
import media.tiger.tigerbox.services.implementations.Availability;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$addProfileToAudioProductFolder$1", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Availability.kt */
final class Availability$addProfileToAudioProductFolder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Availability.AudioDownload $download;
    final /* synthetic */ String $profile;
    int label;
    final /* synthetic */ Availability this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$addProfileToAudioProductFolder$1(Availability.AudioDownload audioDownload, Availability availability, String str, Continuation<? super Availability$addProfileToAudioProductFolder$1> continuation) {
        super(2, continuation);
        this.$download = audioDownload;
        this.this$0 = availability;
        this.$profile = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Availability$addProfileToAudioProductFolder$1(this.$download, this.this$0, this.$profile, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Availability$addProfileToAudioProductFolder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$download.getNfc() != null) {
                return Unit.INSTANCE;
            }
            try {
                new File(this.this$0.pathForProductProfileFile(this.$download.getProduct().getId(), this.$profile)).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
