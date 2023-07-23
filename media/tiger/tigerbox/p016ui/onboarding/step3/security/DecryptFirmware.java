package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.services.interfaces.AssetService;
import media.tiger.tigerbox.services.interfaces.StorageService;

@Metadata(mo33736d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0003+,-B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJK\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0012H\u0003J.\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001aH\u0002J^\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u00122\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00170\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00170&H\u0002J\u0014\u0010'\u001a\u00020\u001a*\u00020(2\u0006\u0010)\u001a\u00020\fH\u0002J\f\u0010*\u001a\u00020(*\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware;", "", "assetService", "Lmedia/tiger/tigerbox/services/interfaces/AssetService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "base64Converter", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/Base64Converter;", "(Lmedia/tiger/tigerbox/services/interfaces/AssetService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/ui/onboarding/step3/security/Base64Converter;)V", "decryptFirmware", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FirmwareDecryptionResult;", "rsaPrivateKey", "", "encodedFirmwareFileReference", "decodedFirmwareDestination", "release", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation$Release;", "onUpdate", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "percent", "", "evpBytesToKey", "", "", "keyLength", "", "ivLength", "salt", "data", "invoke", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onFail", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FailureReason;", "onSuccess", "Lkotlin/Function0;", "decryptAesKey", "Ljavax/crypto/Cipher;", "key", "toCipher", "Companion", "FailureReason", "FirmwareDecryptionResult", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware */
/* compiled from: DecryptFirmware.kt */
public final class DecryptFirmware {
    private static final int BUFFER_SIZE = 1024;
    private static final String CIPHER_TRANSFORMATION = "RSA/ECB/PKCS1Padding";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DECRYPTION_CIPHER_TRANSFORM = "AES/CBC/PKCS5Padding";
    private static final int HEADER_SIZE = 16;
    private static final String KEY_ALGORITHM = "RSA";
    private static final int KEY_SIZE_BITS = 256;
    private static final String MESSAGE_DIGEST_ALGORITHM = "MD5";
    private static final String PRIVATE_KEY_END = "-----END PRIVATE KEY-----";
    private static final String PRIVATE_KEY_START = "-----BEGIN PRIVATE KEY-----";
    private static final String PRIVATE_KEY_START_NEW_LINE = "-----BEGIN PRIVATE KEY-----\n";
    private static final int READ_BUFFER_SIZE = 1048576;
    private static final String SALTED = "Salted__";
    private static final int SALT_OFFSET = 8;
    private static final int SALT_SIZE = 8;
    private static final String SECRET_KEY_ALGORITHM = "AES";
    private static final String SECURITY_PROVIDER = "BC";
    /* access modifiers changed from: private */
    public final AssetService assetService;
    private final Base64Converter base64Converter;
    /* access modifiers changed from: private */
    public final StorageService storageService;

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FailureReason;", "", "(Ljava/lang/String;I)V", "NO_FIRMWARE_DOWNLOADED", "NO_FIRMWARE_HEADER", "FIRMWARE_NOT_SSL_ENCRYPTED", "CIPHER_OUTPUT_STREAM_IO_ERROR", "CIPHER_OUTPUT_STREAM_GENERAL_SECURITY_ERROR", "FILE_STREAM_CLOSE_ERROR", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason */
    /* compiled from: DecryptFirmware.kt */
    public enum FailureReason {
        NO_FIRMWARE_DOWNLOADED,
        NO_FIRMWARE_HEADER,
        FIRMWARE_NOT_SSL_ENCRYPTED,
        CIPHER_OUTPUT_STREAM_IO_ERROR,
        CIPHER_OUTPUT_STREAM_GENERAL_SECURITY_ERROR,
        FILE_STREAM_CLOSE_ERROR
    }

    @Inject
    public DecryptFirmware(AssetService assetService2, StorageService storageService2, Base64Converter base64Converter2) {
        Intrinsics.checkNotNullParameter(assetService2, "assetService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(base64Converter2, "base64Converter");
        this.assetService = assetService2;
        this.storageService = storageService2;
        this.base64Converter = base64Converter2;
    }

    public final void invoke(CoroutineScope coroutineScope, ReleaseInformation.Release release, Function1<? super Double, Unit> function1, Function1<? super FailureReason, Unit> function12, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(release, "release");
        Intrinsics.checkNotNullParameter(function1, "onUpdate");
        Intrinsics.checkNotNullParameter(function12, "onFail");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new DecryptFirmware$invoke$1(this, release, function1, function0, function12, (Continuation<? super DecryptFirmware$invoke$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0146 A[Catch:{ IOException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x014b A[Catch:{ IOException -> 0x0150 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0187 A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x018c A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01c8 A[Catch:{ IOException -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01cd A[Catch:{ IOException -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01e8 A[Catch:{ IOException -> 0x01f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01ed A[Catch:{ IOException -> 0x01f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:45:0x0120=Splitter:B:45:0x0120, B:57:0x0161=Splitter:B:57:0x0161, B:69:0x01a2=Splitter:B:69:0x01a2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult decryptFirmware(java.lang.String r10, java.lang.String r11, java.lang.String r12, media.tiger.tigerbox.model.dto.ReleaseInformation.Release r13, kotlin.jvm.functions.Function1<? super java.lang.Double, kotlin.Unit> r14) {
        /*
            r9 = this;
            java.lang.String r0 = "DecryptFirmware: IO Exception: Closing the encrypted firmware stream"
            java.io.File r1 = new java.io.File
            r1.<init>(r11)
            boolean r11 = r1.exists()
            if (r11 != 0) goto L_0x0017
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r11 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.NO_FIRMWARE_DOWNLOADED
            r10.<init>(r11)
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r10 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r10
            return r10
        L_0x0017:
            java.io.FileInputStream r11 = new java.io.FileInputStream
            r11.<init>(r1)
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Success r1 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult.Success.INSTANCE
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r1 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r1
            r1 = 0
            r2 = 0
            javax.crypto.Cipher r10 = r9.toCipher(r10)     // Catch:{ IOException -> 0x01a0, GeneralSecurityException -> 0x015f, Exception -> 0x011e, all -> 0x011a }
            java.lang.String r13 = r13.getKey()     // Catch:{ IOException -> 0x01a0, GeneralSecurityException -> 0x015f, Exception -> 0x011e, all -> 0x011a }
            byte[] r10 = r9.decryptAesKey(r10, r13)     // Catch:{ IOException -> 0x01a0, GeneralSecurityException -> 0x015f, Exception -> 0x011e, all -> 0x011a }
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x01a0, GeneralSecurityException -> 0x015f, Exception -> 0x011e, all -> 0x011a }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x01a0, GeneralSecurityException -> 0x015f, Exception -> 0x011e, all -> 0x011a }
            r3.<init>(r12)     // Catch:{ IOException -> 0x01a0, GeneralSecurityException -> 0x015f, Exception -> 0x011e, all -> 0x011a }
            r13.<init>(r3)     // Catch:{ IOException -> 0x01a0, GeneralSecurityException -> 0x015f, Exception -> 0x011e, all -> 0x011a }
            r12 = 16
            byte[] r3 = new byte[r12]     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            int r4 = r11.read(r3)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            if (r4 >= 0) goto L_0x004d
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r12 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.NO_FIRMWARE_HEADER     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r10.<init>(r12)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r10 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r10     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            goto L_0x00e2
        L_0x004d:
            java.lang.String r4 = "Salted__"
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            byte[] r4 = r4.getBytes(r5)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            java.lang.String r5 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r5 = 8
            byte[] r6 = kotlin.collections.ArraysKt.copyOfRange((byte[]) r3, (int) r2, (int) r5)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            boolean r4 = java.util.Arrays.equals(r4, r6)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            if (r4 != 0) goto L_0x0070
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r12 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.FIRMWARE_NOT_SSL_ENCRYPTED     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r10.<init>(r12)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r10 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r10     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            goto L_0x00e2
        L_0x0070:
            byte[] r12 = kotlin.collections.ArraysKt.copyOfRange((byte[]) r3, (int) r5, (int) r12)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            java.lang.String r3 = "AES/CBC/PKCS5Padding"
            java.lang.String r4 = "BC"
            java.security.Provider r4 = java.security.Security.getProvider(r4)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            javax.crypto.Cipher r3 = javax.crypto.Cipher.getInstance(r3, r4)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r4 = 32
            int r5 = r3.getBlockSize()     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            java.util.List r10 = r9.evpBytesToKey(r4, r5, r12, r10)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            javax.crypto.spec.SecretKeySpec r12 = new javax.crypto.spec.SecretKeySpec     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            java.lang.Object r4 = r10.get(r2)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            byte[] r4 = (byte[]) r4     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            java.lang.String r5 = "AES"
            r12.<init>(r4, r5)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            javax.crypto.spec.IvParameterSpec r4 = new javax.crypto.spec.IvParameterSpec     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r5 = 1
            java.lang.Object r10 = r10.get(r5)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            byte[] r10 = (byte[]) r10     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r4.<init>(r10)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r10 = 2
            java.security.Key r12 = (java.security.Key) r12     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            java.security.spec.AlgorithmParameterSpec r4 = (java.security.spec.AlgorithmParameterSpec) r4     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r3.init(r10, r12, r4)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            javax.crypto.CipherOutputStream r10 = new javax.crypto.CipherOutputStream     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r12 = r13
            java.io.OutputStream r12 = (java.io.OutputStream) r12     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            r10.<init>(r12, r3)     // Catch:{ IOException -> 0x0117, GeneralSecurityException -> 0x0115, Exception -> 0x0113 }
            int r12 = r11.available()     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            r1 = 1048576(0x100000, float:1.469368E-39)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            int r3 = r11.read(r1)     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            r4 = 0
        L_0x00c0:
            if (r3 <= 0) goto L_0x00d9
            int r4 = r4 + r3
            double r5 = (double) r4     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            double r7 = (double) r12     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            double r5 = r5 / r7
            r7 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r5 = r5 * r7
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            r14.invoke(r5)     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            r10.write(r1, r2, r3)     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            int r3 = r11.read(r1)     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            goto L_0x00c0
        L_0x00d9:
            r10.flush()     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Success r12 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult.Success.INSTANCE     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r12 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r12     // Catch:{ IOException -> 0x010e, GeneralSecurityException -> 0x010a, Exception -> 0x0106, all -> 0x0101 }
            r1 = r10
            r10 = r12
        L_0x00e2:
            r11.close()     // Catch:{ IOException -> 0x00ef }
            if (r1 == 0) goto L_0x00ea
            r1.close()     // Catch:{ IOException -> 0x00ef }
        L_0x00ea:
            r13.close()     // Catch:{ IOException -> 0x00ef }
            goto L_0x01e1
        L_0x00ef:
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.Object[] r11 = new java.lang.Object[r2]
            r10.mo50217e(r0, r11)
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r11 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.FILE_STREAM_CLOSE_ERROR
            r10.<init>(r11)
        L_0x00fd:
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r10 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r10
            goto L_0x01e1
        L_0x0101:
            r12 = move-exception
            r1 = r10
            r10 = r12
            goto L_0x01e3
        L_0x0106:
            r12 = move-exception
            r1 = r10
            r10 = r12
            goto L_0x0120
        L_0x010a:
            r12 = move-exception
            r1 = r10
            r10 = r12
            goto L_0x0161
        L_0x010e:
            r12 = move-exception
            r1 = r10
            r10 = r12
            goto L_0x01a2
        L_0x0113:
            r10 = move-exception
            goto L_0x0120
        L_0x0115:
            r10 = move-exception
            goto L_0x0161
        L_0x0117:
            r10 = move-exception
            goto L_0x01a2
        L_0x011a:
            r10 = move-exception
            r13 = r1
            goto L_0x01e3
        L_0x011e:
            r10 = move-exception
            r13 = r1
        L_0x0120:
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest     // Catch:{ all -> 0x01e2 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r14.<init>()     // Catch:{ all -> 0x01e2 }
            java.lang.String r3 = "DecryptFirmware: Unknown Exception: "
            r14.append(r3)     // Catch:{ all -> 0x01e2 }
            r14.append(r10)     // Catch:{ all -> 0x01e2 }
            java.lang.String r10 = r14.toString()     // Catch:{ all -> 0x01e2 }
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ all -> 0x01e2 }
            r12.mo50217e(r10, r14)     // Catch:{ all -> 0x01e2 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure     // Catch:{ all -> 0x01e2 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r12 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.CIPHER_OUTPUT_STREAM_IO_ERROR     // Catch:{ all -> 0x01e2 }
            r10.<init>(r12)     // Catch:{ all -> 0x01e2 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r10 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r10     // Catch:{ all -> 0x01e2 }
            r11.close()     // Catch:{ IOException -> 0x0150 }
            if (r1 == 0) goto L_0x0149
            r1.close()     // Catch:{ IOException -> 0x0150 }
        L_0x0149:
            if (r13 == 0) goto L_0x01e1
            r13.close()     // Catch:{ IOException -> 0x0150 }
            goto L_0x01e1
        L_0x0150:
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.Object[] r11 = new java.lang.Object[r2]
            r10.mo50217e(r0, r11)
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r11 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.FILE_STREAM_CLOSE_ERROR
            r10.<init>(r11)
            goto L_0x00fd
        L_0x015f:
            r10 = move-exception
            r13 = r1
        L_0x0161:
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest     // Catch:{ all -> 0x01e2 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r14.<init>()     // Catch:{ all -> 0x01e2 }
            java.lang.String r3 = "DecryptFirmware: General Security Exception: CipherOutputStream "
            r14.append(r3)     // Catch:{ all -> 0x01e2 }
            r14.append(r10)     // Catch:{ all -> 0x01e2 }
            java.lang.String r10 = r14.toString()     // Catch:{ all -> 0x01e2 }
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ all -> 0x01e2 }
            r12.mo50217e(r10, r14)     // Catch:{ all -> 0x01e2 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure     // Catch:{ all -> 0x01e2 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r12 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.CIPHER_OUTPUT_STREAM_GENERAL_SECURITY_ERROR     // Catch:{ all -> 0x01e2 }
            r10.<init>(r12)     // Catch:{ all -> 0x01e2 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r10 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r10     // Catch:{ all -> 0x01e2 }
            r11.close()     // Catch:{ IOException -> 0x0190 }
            if (r1 == 0) goto L_0x018a
            r1.close()     // Catch:{ IOException -> 0x0190 }
        L_0x018a:
            if (r13 == 0) goto L_0x01e1
            r13.close()     // Catch:{ IOException -> 0x0190 }
            goto L_0x01e1
        L_0x0190:
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.Object[] r11 = new java.lang.Object[r2]
            r10.mo50217e(r0, r11)
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r11 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.FILE_STREAM_CLOSE_ERROR
            r10.<init>(r11)
            goto L_0x00fd
        L_0x01a0:
            r10 = move-exception
            r13 = r1
        L_0x01a2:
            timber.log.Timber$Forest r12 = timber.log.Timber.Forest     // Catch:{ all -> 0x01e2 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r14.<init>()     // Catch:{ all -> 0x01e2 }
            java.lang.String r3 = "DecryptFirmware: IO Exception: CipherOutputStream "
            r14.append(r3)     // Catch:{ all -> 0x01e2 }
            r14.append(r10)     // Catch:{ all -> 0x01e2 }
            java.lang.String r10 = r14.toString()     // Catch:{ all -> 0x01e2 }
            java.lang.Object[] r14 = new java.lang.Object[r2]     // Catch:{ all -> 0x01e2 }
            r12.mo50217e(r10, r14)     // Catch:{ all -> 0x01e2 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure     // Catch:{ all -> 0x01e2 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r12 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.CIPHER_OUTPUT_STREAM_IO_ERROR     // Catch:{ all -> 0x01e2 }
            r10.<init>(r12)     // Catch:{ all -> 0x01e2 }
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r10 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r10     // Catch:{ all -> 0x01e2 }
            r11.close()     // Catch:{ IOException -> 0x01d1 }
            if (r1 == 0) goto L_0x01cb
            r1.close()     // Catch:{ IOException -> 0x01d1 }
        L_0x01cb:
            if (r13 == 0) goto L_0x01e1
            r13.close()     // Catch:{ IOException -> 0x01d1 }
            goto L_0x01e1
        L_0x01d1:
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.Object[] r11 = new java.lang.Object[r2]
            r10.mo50217e(r0, r11)
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r10 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r11 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.FILE_STREAM_CLOSE_ERROR
            r10.<init>(r11)
            goto L_0x00fd
        L_0x01e1:
            return r10
        L_0x01e2:
            r10 = move-exception
        L_0x01e3:
            r11.close()     // Catch:{ IOException -> 0x01f1 }
            if (r1 == 0) goto L_0x01eb
            r1.close()     // Catch:{ IOException -> 0x01f1 }
        L_0x01eb:
            if (r13 == 0) goto L_0x0201
            r13.close()     // Catch:{ IOException -> 0x01f1 }
            goto L_0x0201
        L_0x01f1:
            timber.log.Timber$Forest r11 = timber.log.Timber.Forest
            java.lang.Object[] r12 = new java.lang.Object[r2]
            r11.mo50217e(r0, r12)
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure r11 = new media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FailureReason r12 = media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FailureReason.FILE_STREAM_CLOSE_ERROR
            r11.<init>(r12)
            media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult r11 = (media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.FirmwareDecryptionResult) r11
        L_0x0201:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware.decryptFirmware(java.lang.String, java.lang.String, java.lang.String, media.tiger.tigerbox.model.dto.ReleaseInformation$Release, kotlin.jvm.functions.Function1):media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult");
    }

    private final Cipher toCipher(String str) {
        PrivateKey generatePrivate = KeyFactory.getInstance(KEY_ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(this.base64Converter.invoke(FileDigestValidatorKt.replace(str, TuplesKt.m475to(PRIVATE_KEY_START_NEW_LINE, ""), TuplesKt.m475to(PRIVATE_KEY_START, ""), TuplesKt.m475to(PRIVATE_KEY_END, "")))));
        Cipher instance = Cipher.getInstance(CIPHER_TRANSFORMATION);
        instance.init(2, generatePrivate);
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(CIPHER_TRANS…DE, privateKey)\n        }");
        return instance;
    }

    private final byte[] decryptAesKey(Cipher cipher, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.base64Converter.invoke(str));
        byte[] bArr = new byte[1024];
        for (int read = byteArrayInputStream.read(bArr); read > 0; read = byteArrayInputStream.read(bArr)) {
            cipherOutputStream.write(bArr, 0, read);
        }
        cipherOutputStream.flush();
        cipherOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "byteArrayOutputStream.toByteArray()");
        return byteArray;
    }

    private final List<byte[]> evpBytesToKey(int i, int i2, byte[] bArr, byte[] bArr2) {
        byte[] digest;
        MessageDigest instance = MessageDigest.getInstance(MESSAGE_DIGEST_ALGORITHM);
        int i3 = i;
        int i4 = i2;
        List<byte[]> listOf = CollectionsKt.listOf((Object[]) new byte[][]{new byte[i3], new byte[i4]});
        byte[] bArr3 = listOf.get(0);
        byte[] bArr4 = listOf.get(1);
        byte[] bArr5 = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            instance.reset();
            int i8 = i5 + 1;
            if (i5 > 0) {
                Intrinsics.checkNotNull(bArr5);
                instance.update(bArr5);
            }
            instance.update(bArr2);
            instance.update(bArr, 0, 8);
            digest = instance.digest();
            int i9 = 0;
            if (i3 > 0) {
                while (i3 != 0) {
                    Intrinsics.checkNotNull(digest);
                    if (i9 == digest.length) {
                        break;
                    }
                    bArr3[i6] = digest[i9];
                    i3--;
                    i9++;
                    i6++;
                }
            }
            if (i4 > 0) {
                Intrinsics.checkNotNull(digest);
                if (i9 != digest.length) {
                    while (i4 != 0 && i9 != digest.length) {
                        bArr4[i7] = digest[i9];
                        i4--;
                        i9++;
                        i7++;
                    }
                }
            }
            if (i3 == 0 && i4 == 0) {
                break;
            }
            bArr5 = digest;
            i5 = i8;
        }
        int i10 = 0;
        while (true) {
            Intrinsics.checkNotNull(digest);
            if (i10 >= digest.length) {
                return listOf;
            }
            digest[i10] = 0;
            i10++;
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FirmwareDecryptionResult;", "", "()V", "Failure", "Success", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FirmwareDecryptionResult$Success;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FirmwareDecryptionResult$Failure;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult */
    /* compiled from: DecryptFirmware.kt */
    public static abstract class FirmwareDecryptionResult {
        public /* synthetic */ FirmwareDecryptionResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FirmwareDecryptionResult$Success;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FirmwareDecryptionResult;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Success */
        /* compiled from: DecryptFirmware.kt */
        public static final class Success extends FirmwareDecryptionResult {
            public static final Success INSTANCE = new Success();

            private Success() {
                super((DefaultConstructorMarker) null);
            }
        }

        private FirmwareDecryptionResult() {
        }

        @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FirmwareDecryptionResult$Failure;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FirmwareDecryptionResult;", "failureReason", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FailureReason;", "(Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FailureReason;)V", "getFailureReason", "()Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$FailureReason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$FirmwareDecryptionResult$Failure */
        /* compiled from: DecryptFirmware.kt */
        public static final class Failure extends FirmwareDecryptionResult {
            private final FailureReason failureReason;

            public static /* synthetic */ Failure copy$default(Failure failure, FailureReason failureReason2, int i, Object obj) {
                if ((i & 1) != 0) {
                    failureReason2 = failure.failureReason;
                }
                return failure.copy(failureReason2);
            }

            public final FailureReason component1() {
                return this.failureReason;
            }

            public final Failure copy(FailureReason failureReason2) {
                Intrinsics.checkNotNullParameter(failureReason2, "failureReason");
                return new Failure(failureReason2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failure) && this.failureReason == ((Failure) obj).failureReason;
            }

            public int hashCode() {
                return this.failureReason.hashCode();
            }

            public String toString() {
                return "Failure(failureReason=" + this.failureReason + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failure(FailureReason failureReason2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(failureReason2, "failureReason");
                this.failureReason = failureReason2;
            }

            public final FailureReason getFailureReason() {
                return this.failureReason;
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware$Companion;", "", "()V", "BUFFER_SIZE", "", "CIPHER_TRANSFORMATION", "", "DECRYPTION_CIPHER_TRANSFORM", "HEADER_SIZE", "KEY_ALGORITHM", "KEY_SIZE_BITS", "MESSAGE_DIGEST_ALGORITHM", "PRIVATE_KEY_END", "PRIVATE_KEY_START", "PRIVATE_KEY_START_NEW_LINE", "READ_BUFFER_SIZE", "SALTED", "SALT_OFFSET", "SALT_SIZE", "SECRET_KEY_ALGORITHM", "SECURITY_PROVIDER", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware$Companion */
    /* compiled from: DecryptFirmware.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
