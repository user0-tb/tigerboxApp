package media.tiger.tigerbox.services.implementations.audioPlayer;

import com.google.android.exoplayer2.upstream.DataSpec;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.audioPlayer.HlsKeyProviderService;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.audioPlayer.AudioHlsDataSource$open$1", mo34424f = "AudioHlsDataSource.kt", mo34425i = {}, mo34426l = {38}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: AudioHlsDataSource.kt */
final class AudioHlsDataSource$open$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DataSpec $dataSpec;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AudioHlsDataSource this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AudioHlsDataSource$open$1(AudioHlsDataSource audioHlsDataSource, DataSpec dataSpec, Continuation<? super AudioHlsDataSource$open$1> continuation) {
        super(2, continuation);
        this.this$0 = audioHlsDataSource;
        this.$dataSpec = dataSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AudioHlsDataSource$open$1 audioHlsDataSource$open$1 = new AudioHlsDataSource$open$1(this.this$0, this.$dataSpec, continuation);
        audioHlsDataSource$open$1.L$0 = obj;
        return audioHlsDataSource$open$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudioHlsDataSource$open$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AudioHlsDataSource audioHlsDataSource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AudioHlsDataSource audioHlsDataSource2 = this.this$0;
            DataSpec dataSpec = this.$dataSpec;
            Result.Companion companion = Result.Companion;
            HlsKeyProviderService access$getHlsService$p = audioHlsDataSource2.hlsService;
            String uri = dataSpec.uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "dataSpec.uri.toString()");
            TigerCardDomain access$getNfcInfo$p = audioHlsDataSource2.nfcInfo;
            this.L$0 = audioHlsDataSource2;
            this.label = 1;
            Object readHlsKeyFromUrl$default = HlsKeyProviderService.DefaultImpls.readHlsKeyFromUrl$default(access$getHlsService$p, uri, access$getNfcInfo$p, false, this, 4, (Object) null);
            if (readHlsKeyFromUrl$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            audioHlsDataSource = audioHlsDataSource2;
            obj = readHlsKeyFromUrl$default;
        } else if (i == 1) {
            audioHlsDataSource = (AudioHlsDataSource) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m772constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        audioHlsDataSource.finishedLoadingData((byte[]) obj);
        Result.m772constructorimpl(Unit.INSTANCE);
        return Unit.INSTANCE;
    }
}
