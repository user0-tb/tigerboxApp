package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.model.domain.DownloadReason;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$changeDownloadReasonForProduct$1", mo34424f = "Availability.kt", mo34425i = {0}, mo34426l = {545}, mo34427m = "invokeSuspend", mo34428n = {"writer"}, mo34429s = {"L$0"})
/* compiled from: Availability.kt */
final class Availability$changeDownloadReasonForProduct$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $onDone;
    final /* synthetic */ int $productId;
    final /* synthetic */ DownloadReason $reason;
    Object L$0;
    int label;
    final /* synthetic */ Availability this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$changeDownloadReasonForProduct$1(Availability availability, int i, DownloadReason downloadReason, Function1<? super Boolean, Unit> function1, Continuation<? super Availability$changeDownloadReasonForProduct$1> continuation) {
        super(2, continuation);
        this.this$0 = availability;
        this.$productId = i;
        this.$reason = downloadReason;
        this.$onDone = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Availability$changeDownloadReasonForProduct$1(this.this$0, this.$productId, this.$reason, this.$onDone, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Availability$changeDownloadReasonForProduct$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.FileWriter} */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x008b, code lost:
        if (r2 != null) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b2, code lost:
        if (r2 != null) goto L_0x008d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ba A[SYNTHETIC, Splitter:B:43:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bf A[Catch:{ Exception -> 0x00c2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            java.lang.Object r0 = r13.L$0
            r2 = r0
            java.io.FileWriter r2 = (java.io.FileWriter) r2
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ Exception -> 0x0093 }
            goto L_0x0086
        L_0x0016:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r14)
            media.tiger.tigerbox.services.implementations.Availability r14 = r13.this$0     // Catch:{ Exception -> 0x0093 }
            int r1 = r13.$productId     // Catch:{ Exception -> 0x0093 }
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r4 = r14.audioProductInfoForProductId(r1)     // Catch:{ Exception -> 0x0093 }
            if (r4 == 0) goto L_0x0086
            media.tiger.tigerbox.model.domain.DownloadReason r14 = r4.getDownloadReason()     // Catch:{ Exception -> 0x0093 }
            media.tiger.tigerbox.model.domain.DownloadReason r1 = media.tiger.tigerbox.model.domain.DownloadReason.NONE     // Catch:{ Exception -> 0x0093 }
            if (r14 == r1) goto L_0x0086
            media.tiger.tigerbox.model.domain.DownloadReason r14 = r4.getDownloadReason()     // Catch:{ Exception -> 0x0093 }
            media.tiger.tigerbox.model.domain.DownloadReason r10 = r13.$reason     // Catch:{ Exception -> 0x0093 }
            if (r14 == r10) goto L_0x0086
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 31
            r12 = 0
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r14 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo.copy$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0093 }
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch:{ Exception -> 0x0093 }
            media.tiger.tigerbox.services.implementations.Availability r4 = r13.this$0     // Catch:{ Exception -> 0x0093 }
            int r5 = r13.$productId     // Catch:{ Exception -> 0x0093 }
            java.lang.String r4 = r4.pathForAudioProductInfo(r5)     // Catch:{ Exception -> 0x0093 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0093 }
            com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r4.<init>()     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r5 = r1
            java.lang.Appendable r5 = (java.lang.Appendable) r5     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r4.toJson((java.lang.Object) r14, (java.lang.Appendable) r5)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            kotlinx.coroutines.MainCoroutineDispatcher r14 = kotlinx.coroutines.Dispatchers.getMain()     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            kotlin.coroutines.CoroutineContext r14 = (kotlin.coroutines.CoroutineContext) r14     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            media.tiger.tigerbox.services.implementations.Availability$changeDownloadReasonForProduct$1$1 r4 = new media.tiger.tigerbox.services.implementations.Availability$changeDownloadReasonForProduct$1$1     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r5 = r13.$onDone     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            media.tiger.tigerbox.services.implementations.Availability r6 = r13.this$0     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r4.<init>(r5, r6, r2)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r2 = r13
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r13.L$0 = r1     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            r13.label = r3     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r4, r2)     // Catch:{ Exception -> 0x0083, all -> 0x0080 }
            if (r14 != r0) goto L_0x007e
            return r0
        L_0x007e:
            r2 = r1
            goto L_0x0086
        L_0x0080:
            r14 = move-exception
            r2 = r1
            goto L_0x00b8
        L_0x0083:
            r14 = move-exception
            r2 = r1
            goto L_0x0094
        L_0x0086:
            if (r2 == 0) goto L_0x008b
            r2.flush()     // Catch:{ Exception -> 0x00b5 }
        L_0x008b:
            if (r2 == 0) goto L_0x00b5
        L_0x008d:
            r2.close()     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00b5
        L_0x0091:
            r14 = move-exception
            goto L_0x00b8
        L_0x0093:
            r14 = move-exception
        L_0x0094:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest     // Catch:{ all -> 0x0091 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r1.<init>()     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "Availability: Exception flushAudioProductInfoToDisk: "
            r1.append(r3)     // Catch:{ all -> 0x0091 }
            r1.append(r14)     // Catch:{ all -> 0x0091 }
            java.lang.String r14 = r1.toString()     // Catch:{ all -> 0x0091 }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0091 }
            r0.mo50217e(r14, r1)     // Catch:{ all -> 0x0091 }
            if (r2 == 0) goto L_0x00b2
            r2.flush()     // Catch:{ Exception -> 0x00b5 }
        L_0x00b2:
            if (r2 == 0) goto L_0x00b5
            goto L_0x008d
        L_0x00b5:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00b8:
            if (r2 == 0) goto L_0x00bd
            r2.flush()     // Catch:{ Exception -> 0x00c2 }
        L_0x00bd:
            if (r2 == 0) goto L_0x00c2
            r2.close()     // Catch:{ Exception -> 0x00c2 }
        L_0x00c2:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability$changeDownloadReasonForProduct$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
