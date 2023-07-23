package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.HlsKeysRepository;
import media.tiger.tigerbox.services.interfaces.audioPlayer.HlsKeyProviderService;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J-\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/audioPlayer/HlsKeyProvider;", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;", "webService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "hlsKeysRepository", "Lmedia/tiger/tigerbox/data/repository/HlsKeysRepository;", "(Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lmedia/tiger/tigerbox/data/repository/HlsKeysRepository;)V", "readHlsKeyFromUrl", "", "localUrl", "", "nfcInfo", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "overwrite", "", "(Ljava/lang/String;Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HlsKeyProvider.kt */
public final class HlsKeyProvider implements HlsKeyProviderService {
    /* access modifiers changed from: private */
    public final HlsKeysRepository hlsKeysRepository;
    private final TigerBoxWebService webService;

    public HlsKeyProvider(TigerBoxWebService tigerBoxWebService, HlsKeysRepository hlsKeysRepository2) {
        Intrinsics.checkNotNullParameter(tigerBoxWebService, "webService");
        Intrinsics.checkNotNullParameter(hlsKeysRepository2, "hlsKeysRepository");
        this.webService = tigerBoxWebService;
        this.hlsKeysRepository = hlsKeysRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00de A[Catch:{ all -> 0x013d, IllegalStateException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0166 A[Catch:{ all -> 0x013d, IllegalStateException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object readHlsKeyFromUrl(java.lang.String r18, media.tiger.tigerbox.services.interfaces.TigerCardDomain r19, boolean r20, kotlin.coroutines.Continuation<? super byte[]> r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r21
            boolean r2 = r0 instanceof media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$1 r2 = (media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$1 r2 = new media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x004c
            if (r4 != r7) goto L_0x0044
            java.lang.Object r3 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r2.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r2.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r2.L$0
            media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider r2 = (media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ IllegalStateException -> 0x0041 }
            goto L_0x00d9
        L_0x0041:
            r0 = move-exception
            goto L_0x0181
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r0)
            r11 = 0
            r12 = 4
            r13 = 0
            java.lang.String r9 = "local://"
            java.lang.String r10 = "https://"
            r8 = r18
            java.lang.String r8 = kotlin.text.StringsKt.replace$default((java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (boolean) r11, (int) r12, (java.lang.Object) r13)
            if (r20 != 0) goto L_0x0095
            media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$hlsKeyString$1 r0 = new media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$hlsKeyString$1     // Catch:{ IllegalStateException -> 0x0041 }
            r0.<init>(r1, r8, r5)     // Catch:{ IllegalStateException -> 0x0041 }
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(r5, r0, r7, r5)     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IllegalStateException -> 0x0041 }
            if (r0 == 0) goto L_0x0095
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ IllegalStateException -> 0x0041 }
            int r4 = r4.length()     // Catch:{ IllegalStateException -> 0x0041 }
            if (r4 <= 0) goto L_0x0078
            r4 = 1
            goto L_0x0079
        L_0x0078:
            r4 = 0
        L_0x0079:
            if (r4 == 0) goto L_0x0095
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r9 = "ISO_8859_1"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)     // Catch:{ IllegalStateException -> 0x0041 }
            byte[] r0 = r0.getBytes(r4)     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r4 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ IllegalStateException -> 0x0041 }
            int r4 = r0.length     // Catch:{ IllegalStateException -> 0x0041 }
            if (r4 != 0) goto L_0x0090
            r4 = 1
            goto L_0x0091
        L_0x0090:
            r4 = 0
        L_0x0091:
            r4 = r4 ^ r7
            if (r4 == 0) goto L_0x0095
            return r0
        L_0x0095:
            if (r19 == 0) goto L_0x00bd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0041 }
            r0.<init>()     // Catch:{ IllegalStateException -> 0x0041 }
            r0.append(r8)     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r4 = "?code="
            r0.append(r4)     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r4 = r19.getCode()     // Catch:{ IllegalStateException -> 0x0041 }
            r0.append(r4)     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r4 = "&uid="
            r0.append(r4)     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r4 = r19.getUid()     // Catch:{ IllegalStateException -> 0x0041 }
            r0.append(r4)     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r0 = r0.toString()     // Catch:{ IllegalStateException -> 0x0041 }
            r4 = r0
            goto L_0x00be
        L_0x00bd:
            r4 = r8
        L_0x00be:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ IllegalStateException -> 0x0041 }
            r0.<init>()     // Catch:{ IllegalStateException -> 0x0041 }
            media.tiger.tigerbox.data.network.TigerBoxWebService r9 = r1.webService     // Catch:{ IllegalStateException -> 0x0041 }
            r2.L$0 = r1     // Catch:{ IllegalStateException -> 0x0041 }
            r2.L$1 = r8     // Catch:{ IllegalStateException -> 0x0041 }
            r2.L$2 = r4     // Catch:{ IllegalStateException -> 0x0041 }
            r2.L$3 = r0     // Catch:{ IllegalStateException -> 0x0041 }
            r2.label = r7     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.Object r2 = r9.getHlsKey(r4, r2)     // Catch:{ IllegalStateException -> 0x0041 }
            if (r2 != r3) goto L_0x00d6
            return r3
        L_0x00d6:
            r3 = r0
            r0 = r2
            r2 = r1
        L_0x00d9:
            r9 = r0
            okhttp3.ResponseBody r9 = (okhttp3.ResponseBody) r9     // Catch:{ IllegalStateException -> 0x0041 }
            if (r9 == 0) goto L_0x0166
            java.io.InputStream r10 = r9.byteStream()     // Catch:{ IllegalStateException -> 0x0041 }
            long r11 = r9.contentLength()     // Catch:{ Exception -> 0x013f }
            int r0 = (int) r11     // Catch:{ Exception -> 0x013f }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x013f }
            r3.element = r0     // Catch:{ Exception -> 0x013f }
        L_0x00eb:
            T r0 = r3.element     // Catch:{ Exception -> 0x013f }
            byte[] r0 = (byte[]) r0     // Catch:{ Exception -> 0x013f }
            int r0 = r10.read(r0)     // Catch:{ Exception -> 0x013f }
            r11 = -1
            if (r0 != r11) goto L_0x00eb
            T r0 = r3.element     // Catch:{ Exception -> 0x013f }
            byte[] r0 = (byte[]) r0     // Catch:{ Exception -> 0x013f }
            int r0 = r0.length     // Catch:{ Exception -> 0x013f }
            if (r0 != 0) goto L_0x00ff
            r0 = 1
            goto L_0x0100
        L_0x00ff:
            r0 = 0
        L_0x0100:
            r0 = r0 ^ r7
            if (r0 == 0) goto L_0x011e
            kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x013f }
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch:{ Exception -> 0x013f }
            kotlinx.coroutines.CoroutineScope r11 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r0)     // Catch:{ Exception -> 0x013f }
            r12 = 0
            r13 = 0
            media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$3 r0 = new media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider$readHlsKeyFromUrl$3     // Catch:{ Exception -> 0x013f }
            r0.<init>(r3, r2, r8, r5)     // Catch:{ Exception -> 0x013f }
            r14 = r0
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14     // Catch:{ Exception -> 0x013f }
            r15 = 3
            r16 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x013f }
            goto L_0x0136
        L_0x011e:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest     // Catch:{ Exception -> 0x013f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013f }
            r2.<init>()     // Catch:{ Exception -> 0x013f }
            java.lang.String r7 = "Hls key is empty: "
            r2.append(r7)     // Catch:{ Exception -> 0x013f }
            r2.append(r4)     // Catch:{ Exception -> 0x013f }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x013f }
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x013f }
            r0.mo50217e(r2, r4)     // Catch:{ Exception -> 0x013f }
        L_0x0136:
            r10.close()     // Catch:{ IllegalStateException -> 0x0041 }
        L_0x0139:
            r9.close()     // Catch:{ IllegalStateException -> 0x0041 }
            goto L_0x017e
        L_0x013d:
            r0 = move-exception
            goto L_0x015f
        L_0x013f:
            r0 = move-exception
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest     // Catch:{ all -> 0x013d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x013d }
            r4.<init>()     // Catch:{ all -> 0x013d }
            java.lang.String r7 = "Did catch exception fro hls key: "
            r4.append(r7)     // Catch:{ all -> 0x013d }
            r4.append(r0)     // Catch:{ all -> 0x013d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x013d }
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x013d }
            r2.mo50217e(r4, r7)     // Catch:{ all -> 0x013d }
            r0.printStackTrace()     // Catch:{ all -> 0x013d }
            r10.close()     // Catch:{ IllegalStateException -> 0x0041 }
            goto L_0x0139
        L_0x015f:
            r10.close()     // Catch:{ IllegalStateException -> 0x0041 }
            r9.close()     // Catch:{ IllegalStateException -> 0x0041 }
            throw r0     // Catch:{ IllegalStateException -> 0x0041 }
        L_0x0166:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x0041 }
            r2.<init>()     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r7 = "No BODY from hls key: "
            r2.append(r7)     // Catch:{ IllegalStateException -> 0x0041 }
            r2.append(r4)     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.String r2 = r2.toString()     // Catch:{ IllegalStateException -> 0x0041 }
            java.lang.Object[] r4 = new java.lang.Object[r6]     // Catch:{ IllegalStateException -> 0x0041 }
            r0.mo50217e(r2, r4)     // Catch:{ IllegalStateException -> 0x0041 }
        L_0x017e:
            T r0 = r3.element     // Catch:{ IllegalStateException -> 0x0041 }
            return r0
        L_0x0181:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "HlsDataSource: IllegalStateException "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r2.mo50217e(r0, r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider.readHlsKeyFromUrl(java.lang.String, media.tiger.tigerbox.services.interfaces.TigerCardDomain, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
