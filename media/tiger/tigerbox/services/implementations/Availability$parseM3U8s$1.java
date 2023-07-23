package media.tiger.tigerbox.services.implementations;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.Availability$parseM3U8s$1", mo34424f = "Availability.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: Availability.kt */
final class Availability$parseM3U8s$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ Ref.ObjectRef<String> $localFileContent;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Availability$parseM3U8s$1(File file, Ref.ObjectRef<String> objectRef, Continuation<? super Availability$parseM3U8s$1> continuation) {
        super(2, continuation);
        this.$file = file;
        this.$localFileContent = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Availability$parseM3U8s$1(this.$file, this.$localFileContent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Availability$parseM3U8s$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0061, code lost:
        if (r0 != null) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005e A[SYNTHETIC, Splitter:B:24:0x005e] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a A[SYNTHETIC, Splitter:B:32:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006f A[Catch:{ Exception -> 0x0072 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            if (r0 != 0) goto L_0x0073
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
            java.io.FileWriter r0 = new java.io.FileWriter     // Catch:{ Exception -> 0x003f, all -> 0x003a }
            java.io.File r1 = r6.$file     // Catch:{ Exception -> 0x003f, all -> 0x003a }
            java.io.File r1 = r1.getAbsoluteFile()     // Catch:{ Exception -> 0x003f, all -> 0x003a }
            r0.<init>(r1)     // Catch:{ Exception -> 0x003f, all -> 0x003a }
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            r2 = r0
            java.io.Writer r2 = (java.io.Writer) r2     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r7 = r6.$localFileContent     // Catch:{ Exception -> 0x002e }
            T r7 = r7.element     // Catch:{ Exception -> 0x002e }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x002e }
            r1.write(r7)     // Catch:{ Exception -> 0x002e }
            r1.close()     // Catch:{ Exception -> 0x0064 }
        L_0x002a:
            r0.close()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0064
        L_0x002e:
            r7 = move-exception
            goto L_0x0043
        L_0x0030:
            r1 = move-exception
            r5 = r1
            r1 = r7
            r7 = r5
            goto L_0x0068
        L_0x0035:
            r1 = move-exception
            r5 = r1
            r1 = r7
            r7 = r5
            goto L_0x0043
        L_0x003a:
            r0 = move-exception
            r1 = r7
            r7 = r0
            r0 = r1
            goto L_0x0068
        L_0x003f:
            r0 = move-exception
            r1 = r7
            r7 = r0
            r0 = r1
        L_0x0043:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest     // Catch:{ all -> 0x0067 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r3.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r4 = "Availability exception parseM3U8s: "
            r3.append(r4)     // Catch:{ all -> 0x0067 }
            r3.append(r7)     // Catch:{ all -> 0x0067 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0067 }
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0067 }
            r2.mo50217e(r7, r3)     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0061
            r1.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0061:
            if (r0 == 0) goto L_0x0064
            goto L_0x002a
        L_0x0064:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0067:
            r7 = move-exception
        L_0x0068:
            if (r1 == 0) goto L_0x006d
            r1.close()     // Catch:{ Exception -> 0x0072 }
        L_0x006d:
            if (r0 == 0) goto L_0x0072
            r0.close()     // Catch:{ Exception -> 0x0072 }
        L_0x0072:
            throw r7
        L_0x0073:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.Availability$parseM3U8s$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
