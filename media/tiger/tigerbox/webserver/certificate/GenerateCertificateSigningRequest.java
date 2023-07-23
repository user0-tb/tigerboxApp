package media.tiger.tigerbox.webserver.certificate;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/certificate/GenerateCertificateSigningRequest;", "", "()V", "invoke", "", "keyPair", "Ljava/security/KeyPair;", "deviceIdentifier", "deviceCredential", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GenerateCertificateSigningRequest.kt */
public final class GenerateCertificateSigningRequest {
    public static final GenerateCertificateSigningRequest INSTANCE = new GenerateCertificateSigningRequest();

    private GenerateCertificateSigningRequest() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0063, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0060, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r6, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke(java.security.KeyPair r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            java.lang.String r0 = "keyPair"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "deviceIdentifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "deviceCredential"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.security.PrivateKey r0 = r4.getPrivate()
            media.tiger.tigerbox.webserver.certificate.PKCS10CertificationRequestGenerator r1 = new media.tiger.tigerbox.webserver.certificate.PKCS10CertificationRequestGenerator
            java.lang.String r2 = "privateKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.String r2 = "SHA256withRSA"
            r1.<init>(r0, r2)
            org.spongycastle.pkcs.PKCS10CertificationRequest r4 = r1.generatePKCS10CertificationRequest(r4, r5, r6)
            byte[] r4 = r4.getEncoded()
            java.lang.String r5 = "PKCS10CertificationReque…\n                .encoded"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.io.StringWriter r5 = new java.io.StringWriter
            r5.<init>()
            org.spongycastle.util.io.pem.PemWriter r6 = new org.spongycastle.util.io.pem.PemWriter
            r0 = r5
            java.io.Writer r0 = (java.io.Writer) r0
            r6.<init>(r0)
            java.io.Closeable r6 = (java.io.Closeable) r6
            r0 = r6
            org.spongycastle.util.io.pem.PemWriter r0 = (org.spongycastle.util.p033io.pem.PemWriter) r0     // Catch:{ all -> 0x005d }
            org.spongycastle.util.io.pem.PemObject r1 = new org.spongycastle.util.io.pem.PemObject     // Catch:{ all -> 0x005d }
            java.lang.String r2 = "CERTIFICATE REQUEST"
            r1.<init>(r2, r4)     // Catch:{ all -> 0x005d }
            org.spongycastle.util.io.pem.PemObjectGenerator r1 = (org.spongycastle.util.p033io.pem.PemObjectGenerator) r1     // Catch:{ all -> 0x005d }
            r0.writeObject(r1)     // Catch:{ all -> 0x005d }
            r0.flush()     // Catch:{ all -> 0x005d }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005d }
            r4 = 0
            kotlin.p013io.CloseableKt.closeFinally(r6, r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = "writer.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            return r4
        L_0x005d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x005f }
        L_0x005f:
            r5 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r6, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.webserver.certificate.GenerateCertificateSigningRequest.invoke(java.security.KeyPair, java.lang.String, java.lang.String):java.lang.String");
    }
}
