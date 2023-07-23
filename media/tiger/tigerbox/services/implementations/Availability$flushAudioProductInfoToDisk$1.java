package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$flushAudioProductInfoToDisk$1", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Availability.kt */
final class Availability$flushAudioProductInfoToDisk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AudioProductInfo $info;
    int label;
    final /* synthetic */ Availability this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$flushAudioProductInfoToDisk$1(Availability availability, AudioProductInfo audioProductInfo, Continuation<? super Availability$flushAudioProductInfoToDisk$1> continuation) {
        super(2, continuation);
        this.this$0 = availability;
        this.$info = audioProductInfo;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Availability$flushAudioProductInfoToDisk$1(this.this$0, this.$info, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Availability$flushAudioProductInfoToDisk$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        if (r6 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0076, code lost:
        if (r6 == null) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073 A[SYNTHETIC, Splitter:B:26:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007e A[SYNTHETIC, Splitter:B:33:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0083 A[Catch:{ Exception -> 0x0086 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            if (r0 != 0) goto L_0x0087
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = 0
            media.tiger.tigerbox.services.implementations.Availability r0 = r5.this$0     // Catch:{ Exception -> 0x0057 }
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r1 = r5.$info     // Catch:{ Exception -> 0x0057 }
            int r1 = r1.getId()     // Catch:{ Exception -> 0x0057 }
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r0 = r0.audioProductInfoForProductId(r1)     // Catch:{ Exception -> 0x0057 }
            if (r0 == 0) goto L_0x0021
            media.tiger.tigerbox.model.domain.DownloadReason r0 = r0.getDownloadReason()     // Catch:{ Exception -> 0x0057 }
            media.tiger.tigerbox.model.domain.DownloadReason r1 = media.tiger.tigerbox.model.domain.DownloadReason.NONE     // Catch:{ Exception -> 0x0057 }
            if (r0 != r1) goto L_0x0040
        L_0x0021:
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch:{ Exception -> 0x0057 }
            media.tiger.tigerbox.services.implementations.Availability r1 = r5.this$0     // Catch:{ Exception -> 0x0057 }
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r2 = r5.$info     // Catch:{ Exception -> 0x0057 }
            int r2 = r2.getId()     // Catch:{ Exception -> 0x0057 }
            java.lang.String r1 = r1.pathForAudioProductInfo(r2)     // Catch:{ Exception -> 0x0057 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0057 }
            com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r6.<init>()     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo r1 = r5.$info     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r2 = r0
            java.lang.Appendable r2 = (java.lang.Appendable) r2     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r6.toJson((java.lang.Object) r1, (java.lang.Appendable) r2)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r6 = r0
        L_0x0040:
            if (r6 == 0) goto L_0x0045
            r6.flush()     // Catch:{ Exception -> 0x0079 }
        L_0x0045:
            if (r6 == 0) goto L_0x0079
        L_0x0047:
            r6.close()     // Catch:{ Exception -> 0x0079 }
            goto L_0x0079
        L_0x004b:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x007c
        L_0x0050:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L_0x0058
        L_0x0055:
            r0 = move-exception
            goto L_0x007c
        L_0x0057:
            r0 = move-exception
        L_0x0058:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x0055 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r2.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r3 = "Availability: Exception flushAudioProductInfoToDisk: "
            r2.append(r3)     // Catch:{ all -> 0x0055 }
            r2.append(r0)     // Catch:{ all -> 0x0055 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0055 }
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0055 }
            r1.mo50217e(r0, r2)     // Catch:{ all -> 0x0055 }
            if (r6 == 0) goto L_0x0076
            r6.flush()     // Catch:{ Exception -> 0x0079 }
        L_0x0076:
            if (r6 == 0) goto L_0x0079
            goto L_0x0047
        L_0x0079:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x007c:
            if (r6 == 0) goto L_0x0081
            r6.flush()     // Catch:{ Exception -> 0x0086 }
        L_0x0081:
            if (r6 == 0) goto L_0x0086
            r6.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            throw r0
        L_0x0087:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability$flushAudioProductInfoToDisk$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
