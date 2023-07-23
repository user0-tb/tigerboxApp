package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.services.implementations.Availability;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$parseEncodingPlaylists$3", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {1083}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Availability.kt */
final class Availability$parseEncodingPlaylists$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Availability.AudioDownload $download;
    final /* synthetic */ Ref.ObjectRef<String> $keyUri;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Availability this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$parseEncodingPlaylists$3(Availability availability, Ref.ObjectRef<String> objectRef, Availability.AudioDownload audioDownload, Continuation<? super Availability$parseEncodingPlaylists$3> continuation) {
        super(2, continuation);
        this.this$0 = availability;
        this.$keyUri = objectRef;
        this.$download = audioDownload;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Availability$parseEncodingPlaylists$3 availability$parseEncodingPlaylists$3 = new Availability$parseEncodingPlaylists$3(this.this$0, this.$keyUri, this.$download, continuation);
        availability$parseEncodingPlaylists$3.L$0 = obj;
        return availability$parseEncodingPlaylists$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Availability$parseEncodingPlaylists$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Availability availability = this.this$0;
            Ref.ObjectRef<String> objectRef = this.$keyUri;
            Availability.AudioDownload audioDownload = this.$download;
            Result.Companion companion = Result.Companion;
            TigerCardDomain nfc = audioDownload.getNfc();
            this.label = 1;
            obj = availability.hlsService.readHlsKeyFromUrl((String) objectRef.element, nfc, false, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m772constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result.m772constructorimpl((byte[]) obj);
        return Unit.INSTANCE;
    }
}
