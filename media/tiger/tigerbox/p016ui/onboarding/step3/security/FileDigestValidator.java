package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J)\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J+\u0010\u001b\u001a\u00020\u000f2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f0\rH\u0016J+\u0010 \u001a\u00020\u000f2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u000f0\rH\u0016J\u0016\u0010!\u001a\u0004\u0018\u00010\"*\u00020\u00062\u0006\u0010#\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/FileDigestValidator;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DigestValidator;", "()V", "BUFFER_SIZE", "", "KEY_ALGORITHM", "", "PUBLIC_KEY_END", "PUBLIC_KEY_START", "PUBLIC_KEY_START_NEW_LINE", "SIGNATURE_ALGORITHM", "observers", "", "Lkotlin/Function1;", "", "", "invoke", "", "fileToValidate", "", "publicKeyString", "signatureFile", "base64Converter", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/Base64Converter;", "signatureAsString", "notify", "data", "subscribe", "listener", "Lkotlin/ParameterName;", "name", "percentComplete", "unsubscribe", "toX509PublicKey", "Ljava/security/PublicKey;", "converter", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.FileDigestValidator */
/* compiled from: FileDigestValidator.kt */
public final class FileDigestValidator implements DigestValidator {
    private static final int BUFFER_SIZE = 1048576;
    public static final FileDigestValidator INSTANCE = new FileDigestValidator();
    private static final String KEY_ALGORITHM = "RSA";
    private static final String PUBLIC_KEY_END = "-----END PUBLIC KEY-----";
    private static final String PUBLIC_KEY_START = "-----BEGIN PUBLIC KEY-----";
    private static final String PUBLIC_KEY_START_NEW_LINE = "-----BEGIN PUBLIC KEY-----\n";
    private static final String SIGNATURE_ALGORITHM = "SHA256WithRSA";
    private static final List<Function1<Double, Unit>> observers = new ArrayList();

    private FileDigestValidator() {
    }

    public /* bridge */ /* synthetic */ void notify(Object obj) {
        notify(((Number) obj).doubleValue());
    }

    private final PublicKey toX509PublicKey(String str, Base64Converter base64Converter) {
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(base64Converter.invoke(FileDigestValidatorKt.replace(str, TuplesKt.m475to(PUBLIC_KEY_START_NEW_LINE, ""), TuplesKt.m475to(PUBLIC_KEY_START, ""), TuplesKt.m475to(PUBLIC_KEY_END, ""))));
            KeyFactory instance = KeyFactory.getInstance(KEY_ALGORITHM);
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(KEY_ALGORITHM)");
            return instance.generatePublic(x509EncodedKeySpec);
        } catch (InvalidKeySpecException e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("ValidateReleasesDigest: Invalid Key Spec exception: [" + e + ']', new Object[0]);
            return null;
        }
    }

    public boolean invoke(byte[] bArr, String str, byte[] bArr2, Base64Converter base64Converter) {
        Intrinsics.checkNotNullParameter(bArr, "fileToValidate");
        Intrinsics.checkNotNullParameter(str, "publicKeyString");
        Intrinsics.checkNotNullParameter(bArr2, "signatureFile");
        Intrinsics.checkNotNullParameter(base64Converter, "base64Converter");
        PublicKey x509PublicKey = toX509PublicKey(str, base64Converter);
        if (x509PublicKey == null) {
            return false;
        }
        try {
            Signature instance = Signature.getInstance(SIGNATURE_ALGORITHM);
            instance.initVerify(x509PublicKey);
            instance.update(bArr);
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(SIGNATURE_AL…ToValidate)\n            }");
            return instance.verify(bArr2);
        } catch (SignatureException e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("ValidateReleasesDigest: Signature exception: [" + e + ']', new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00cc, code lost:
        if (r6 != null) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0115, code lost:
        if (r6 != null) goto L_0x00ce;
     */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f4 A[Catch:{ SignatureException -> 0x00f5, FileNotFoundException -> 0x00d2, Exception -> 0x00ac, all -> 0x00a7, all -> 0x0119 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011c A[SYNTHETIC, Splitter:B:66:0x011c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:54:0x00d5=Splitter:B:54:0x00d5, B:47:0x00af=Splitter:B:47:0x00af} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean invoke(java.lang.String r19, java.lang.String r20, java.lang.String r21, media.tiger.tigerbox.p016ui.onboarding.step3.security.Base64Converter r22) {
        /*
            r18 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.String r4 = "fileToValidate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            java.lang.String r4 = "publicKeyString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "signatureAsString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "base64Converter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            r4 = r18
            java.security.PublicKey r1 = r4.toX509PublicKey(r1, r3)
            r5 = 0
            if (r1 != 0) goto L_0x0026
            return r5
        L_0x0026:
            java.io.File r8 = new java.io.File     // Catch:{ SignatureException -> 0x00f5, FileNotFoundException -> 0x00d2, Exception -> 0x00ac, all -> 0x00a7 }
            r8.<init>(r0)     // Catch:{ SignatureException -> 0x00f5, FileNotFoundException -> 0x00d2, Exception -> 0x00ac, all -> 0x00a7 }
            boolean r0 = r8.exists()     // Catch:{ SignatureException -> 0x00f5, FileNotFoundException -> 0x00d2, Exception -> 0x00ac, all -> 0x00a7 }
            if (r0 != 0) goto L_0x0032
            return r5
        L_0x0032:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ SignatureException -> 0x00f5, FileNotFoundException -> 0x00d2, Exception -> 0x00ac, all -> 0x00a7 }
            r9.<init>(r8)     // Catch:{ SignatureException -> 0x00f5, FileNotFoundException -> 0x00d2, Exception -> 0x00ac, all -> 0x00a7 }
            java.lang.String r0 = "SHA256WithRSA"
            java.security.Signature r0 = java.security.Signature.getInstance(r0)     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            r0.initVerify(r1)     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            java.lang.String r1 = "getInstance(SIGNATURE_AL…(publicKey)\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            r1 = 1048576(0x100000, float:1.469368E-39)
            byte[] r8 = new byte[r1]     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            int r10 = r9.available()     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            double r10 = (double) r10     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            r12 = r9
            java.io.InputStream r12 = (java.io.InputStream) r12     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            boolean r13 = r12 instanceof java.io.BufferedInputStream     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            if (r13 == 0) goto L_0x0058
            java.io.BufferedInputStream r12 = (java.io.BufferedInputStream) r12     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            goto L_0x005e
        L_0x0058:
            java.io.BufferedInputStream r13 = new java.io.BufferedInputStream     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            r13.<init>(r12, r1)     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            r12 = r13
        L_0x005e:
            java.io.Closeable r12 = (java.io.Closeable) r12     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            r1 = r12
            java.io.BufferedInputStream r1 = (java.io.BufferedInputStream) r1     // Catch:{ all -> 0x0091 }
            int r13 = r1.read(r8)     // Catch:{ all -> 0x0091 }
            r14 = 0
        L_0x0068:
            if (r13 <= 0) goto L_0x007e
            int r14 = r14 + r13
            media.tiger.tigerbox.ui.onboarding.step3.security.FileDigestValidator r15 = INSTANCE     // Catch:{ all -> 0x0091 }
            double r6 = (double) r14     // Catch:{ all -> 0x0091 }
            double r6 = r6 / r10
            r16 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r6 = r6 * r16
            r15.notify((double) r6)     // Catch:{ all -> 0x0091 }
            r0.update(r8, r5, r13)     // Catch:{ all -> 0x0091 }
            int r13 = r1.read(r8)     // Catch:{ all -> 0x0091 }
            goto L_0x0068
        L_0x007e:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0091 }
            r1 = 0
            kotlin.p013io.CloseableKt.closeFinally(r12, r1)     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            byte[] r1 = r3.invoke(r2)     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            boolean r5 = r0.verify(r1)     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            r9.close()     // Catch:{ Exception -> 0x0118 }
            goto L_0x0118
        L_0x0091:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x0094 }
        L_0x0094:
            r0 = move-exception
            r2 = r0
            kotlin.p013io.CloseableKt.closeFinally(r12, r1)     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
            throw r2     // Catch:{ SignatureException -> 0x00a4, FileNotFoundException -> 0x00a1, Exception -> 0x009e, all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            r6 = r9
            goto L_0x011a
        L_0x009e:
            r0 = move-exception
            r6 = r9
            goto L_0x00af
        L_0x00a1:
            r0 = move-exception
            r6 = r9
            goto L_0x00d5
        L_0x00a4:
            r0 = move-exception
            r6 = r9
            goto L_0x00f8
        L_0x00a7:
            r0 = move-exception
            r1 = 0
            r6 = r1
            goto L_0x011a
        L_0x00ac:
            r0 = move-exception
            r1 = 0
            r6 = r1
        L_0x00af:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x0119 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            r2.<init>()     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = "ValidateReleasesDigest: Unknown exception: ["
            r2.append(r3)     // Catch:{ all -> 0x0119 }
            r2.append(r0)     // Catch:{ all -> 0x0119 }
            r3 = 93
            r2.append(r3)     // Catch:{ all -> 0x0119 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0119 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x0119 }
            r1.mo50217e(r0, r2)     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x0118
        L_0x00ce:
            r6.close()     // Catch:{ Exception -> 0x0118 }
            goto L_0x0118
        L_0x00d2:
            r0 = move-exception
            r1 = 0
            r6 = r1
        L_0x00d5:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x0119 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            r2.<init>()     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = "ValidateReleasesDigest: File not found exception: ["
            r2.append(r3)     // Catch:{ all -> 0x0119 }
            r2.append(r0)     // Catch:{ all -> 0x0119 }
            r3 = 93
            r2.append(r3)     // Catch:{ all -> 0x0119 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0119 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x0119 }
            r1.mo50217e(r0, r2)     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x0118
            goto L_0x00ce
        L_0x00f5:
            r0 = move-exception
            r1 = 0
            r6 = r1
        L_0x00f8:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x0119 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            r2.<init>()     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = "ValidateReleasesDigest: Signature exception: ["
            r2.append(r3)     // Catch:{ all -> 0x0119 }
            r2.append(r0)     // Catch:{ all -> 0x0119 }
            r3 = 93
            r2.append(r3)     // Catch:{ all -> 0x0119 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0119 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x0119 }
            r1.mo50217e(r0, r2)     // Catch:{ all -> 0x0119 }
            if (r6 == 0) goto L_0x0118
            goto L_0x00ce
        L_0x0118:
            return r5
        L_0x0119:
            r0 = move-exception
        L_0x011a:
            if (r6 == 0) goto L_0x011f
            r6.close()     // Catch:{ Exception -> 0x011f }
        L_0x011f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.onboarding.step3.security.FileDigestValidator.invoke(java.lang.String, java.lang.String, java.lang.String, media.tiger.tigerbox.ui.onboarding.step3.security.Base64Converter):boolean");
    }

    public void subscribe(Function1<? super Double, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        List<Function1<Double, Unit>> list = observers;
        if (!list.contains(function1)) {
            list.add(function1);
        }
    }

    public void unsubscribe(Function1<? super Double, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        List<Function1<Double, Unit>> list = observers;
        if (list.contains(function1)) {
            list.remove(function1);
        }
    }

    public void notify(double d) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50214d("ValidateReleasesDigest: loading encoded firmware: " + d + "% file read complete", new Object[0]);
        for (Function1 invoke : observers) {
            invoke.invoke(Double.valueOf(d));
        }
    }
}
