package media.tiger.tigerbox.services.implementations;

import android.content.res.AssetManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.AssetService;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/AndroidAssetService;", "Lmedia/tiger/tigerbox/services/interfaces/AssetService;", "assetManager", "Landroid/content/res/AssetManager;", "(Landroid/content/res/AssetManager;)V", "otaPrivateKey", "", "getOtaPrivateKey", "()Ljava/lang/String;", "otaPublicKey", "getOtaPublicKey", "loadAssetFile", "fileReference", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AndroidAssetService.kt */
public final class AndroidAssetService implements AssetService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String OTA_PRIVATE_KEY = "ota/client_private_pk8.pem";
    public static final String OTA_PUBLIC_KEY = "ota/public.key";
    private final AssetManager assetManager;

    public AndroidAssetService(AssetManager assetManager2) {
        Intrinsics.checkNotNullParameter(assetManager2, "assetManager");
        this.assetManager = assetManager2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String loadAssetFile(java.lang.String r4) {
        /*
            r3 = this;
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0022 }
            android.content.res.AssetManager r1 = r3.assetManager     // Catch:{ Exception -> 0x0022 }
            java.io.InputStream r4 = r1.open(r4)     // Catch:{ Exception -> 0x0022 }
            r0.<init>(r4)     // Catch:{ Exception -> 0x0022 }
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ Exception -> 0x0022 }
            r4 = 0
            r1 = r0
            java.io.InputStreamReader r1 = (java.io.InputStreamReader) r1     // Catch:{ all -> 0x001b }
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ all -> 0x001b }
            java.lang.String r1 = kotlin.p013io.TextStreamsKt.readText(r1)     // Catch:{ all -> 0x001b }
            kotlin.p013io.CloseableKt.closeFinally(r0, r4)     // Catch:{ Exception -> 0x0022 }
            goto L_0x003e
        L_0x001b:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x001d }
        L_0x001d:
            r1 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r0, r4)     // Catch:{ Exception -> 0x0022 }
            throw r1     // Catch:{ Exception -> 0x0022 }
        L_0x0022:
            r4 = move-exception
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "OtaPublicKeyReader: OtaPublicKeyReader read: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.mo50217e(r4, r1)
            java.lang.String r1 = ""
        L_0x003e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.AndroidAssetService.loadAssetFile(java.lang.String):java.lang.String");
    }

    public String getOtaPublicKey() {
        return loadAssetFile(OTA_PUBLIC_KEY);
    }

    public String getOtaPrivateKey() {
        return loadAssetFile(OTA_PRIVATE_KEY);
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/AndroidAssetService$Companion;", "", "()V", "OTA_PRIVATE_KEY", "", "OTA_PUBLIC_KEY", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AndroidAssetService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
