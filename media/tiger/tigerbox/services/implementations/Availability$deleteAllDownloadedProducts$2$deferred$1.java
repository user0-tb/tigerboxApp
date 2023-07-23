package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.services.interfaces.DeleteType;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$deleteAllDownloadedProducts$2$deferred$1", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Availability.kt */
final class Availability$deleteAllDownloadedProducts$2$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeleteType $type;
    int label;
    final /* synthetic */ Availability this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$deleteAllDownloadedProducts$2$deferred$1(Availability availability, DeleteType deleteType, Continuation<? super Availability$deleteAllDownloadedProducts$2$deferred$1> continuation) {
        super(2, continuation);
        this.this$0 = availability;
        this.$type = deleteType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Availability$deleteAllDownloadedProducts$2$deferred$1(this.this$0, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Availability$deleteAllDownloadedProducts$2$deferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        if (r1.isProductFolderBelongingToAnyNonDefaultProfile(r8) == false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r10.label
            if (r0 != 0) goto L_0x0077
            kotlin.ResultKt.throwOnFailure(r11)
            java.io.File r11 = new java.io.File
            media.tiger.tigerbox.services.implementations.Availability r0 = r10.this$0
            media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService r0 = r0.dlService
            java.lang.String r0 = r0.getDownloadsFolder()
            r11.<init>(r0)
            java.lang.String[] r11 = r11.list()
            if (r11 == 0) goto L_0x0075
            media.tiger.tigerbox.services.interfaces.DeleteType r0 = r10.$type
            media.tiger.tigerbox.services.implementations.Availability r1 = r10.this$0
            int r2 = r11.length
            r3 = 0
            r4 = 0
        L_0x0026:
            if (r4 >= r2) goto L_0x0072
            r5 = r11[r4]
            media.tiger.tigerbox.services.interfaces.DeleteType r6 = media.tiger.tigerbox.services.interfaces.DeleteType.DELETE_ALL
            r7 = 1
            if (r0 != r6) goto L_0x0031
            r6 = 1
            goto L_0x0032
        L_0x0031:
            r6 = 0
        L_0x0032:
            media.tiger.tigerbox.services.interfaces.DeleteType r8 = media.tiger.tigerbox.services.interfaces.DeleteType.DELETE_ONLY_FOR_CURRENT_PROFILE
            if (r0 != r8) goto L_0x004d
            java.lang.String r8 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)
            int r8 = java.lang.Integer.parseInt(r5)
            java.lang.String r9 = r1.getCurrentProfileId()
            r1.removeProfileFromAudioProductFolder(r8, r9)
            boolean r8 = r1.isProductFolderBelongingToAnyNonDefaultProfile(r8)
            if (r8 != 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r7 = r6
        L_0x004e:
            if (r7 == 0) goto L_0x006f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService r7 = r1.dlService
            java.lang.String r7 = r7.getDownloadsFolder()
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            boolean unused = r1.deleteFileOrDirectory(r6)
        L_0x006f:
            int r4 = r4 + 1
            goto L_0x0026
        L_0x0072:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            goto L_0x0076
        L_0x0075:
            r11 = 0
        L_0x0076:
            return r11
        L_0x0077:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability$deleteAllDownloadedProducts$2$deferred$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
