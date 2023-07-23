package media.tiger.tigerbox.webserver.certificate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.ExtensionsGenerator;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.operator.ContentSigner;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.pkcs.PKCS10CertificationRequest;
import org.spongycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.spongycastle.pkcs.jcajce.JcaPKCS10CertificationRequestBuilder;

@Metadata(mo33736d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/certificate/PKCS10CertificationRequestGenerator;", "Lorg/spongycastle/operator/ContentSigner;", "privateKey", "Ljava/security/PrivateKey;", "signingAlgorithm", "", "(Ljava/security/PrivateKey;Ljava/lang/String;)V", "outputStream", "Ljava/io/ByteArrayOutputStream;", "signAlgorithm", "signature", "Ljava/security/Signature;", "getSignature", "()Ljava/security/Signature;", "signature$delegate", "Lkotlin/Lazy;", "generateExtensions", "Lorg/spongycastle/asn1/x509/Extensions;", "fullyQualifiedDomainName", "generatePKCS10CertificationRequest", "Lorg/spongycastle/pkcs/PKCS10CertificationRequest;", "keyPair", "Ljava/security/KeyPair;", "deviceIdentifier", "deviceCredential", "getAlgorithmIdentifier", "Lorg/spongycastle/asn1/x509/AlgorithmIdentifier;", "getOutputStream", "Ljava/io/OutputStream;", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PKCS10CertificationRequestGenerator.kt */
public final class PKCS10CertificationRequestGenerator implements ContentSigner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_SIGNATURE_ALGORITHM = "SHA256withRSA";
    public static final int KEY_SIZE = 4096;
    private static final String SUBJECT_PATTERN = "C=DE, ST=Hamburg, O=Tiger Media Deutschland GmbH, CN=%s, SN=%s";
    private static final Map<String, AlgorithmIdentifier> algorithm;
    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final String signAlgorithm;
    private final Lazy signature$delegate;

    public PKCS10CertificationRequestGenerator(PrivateKey privateKey, String str) {
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        Intrinsics.checkNotNullParameter(str, "signingAlgorithm");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        this.signAlgorithm = lowerCase;
        this.signature$delegate = LazyKt.lazy(new PKCS10CertificationRequestGenerator$signature$2(str));
        try {
            getSignature().initSign(privateKey);
        } catch (GeneralSecurityException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private final Signature getSignature() {
        Object value = this.signature$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-signature>(...)");
        return (Signature) value;
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        AlgorithmIdentifier algorithmIdentifier = algorithm.get(this.signAlgorithm);
        if (algorithmIdentifier != null) {
            return algorithmIdentifier;
        }
        throw new IllegalArgumentException("Does not support algorithm: " + this.signAlgorithm);
    }

    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    /* renamed from: getSignature  reason: collision with other method in class */
    public byte[] m2574getSignature() {
        try {
            getSignature().update(this.outputStream.toByteArray());
            return getSignature().sign();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final Extensions generateExtensions(String str) {
        GeneralNames generalNames = new GeneralNames(new GeneralName(2, str));
        ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
        extensionsGenerator.addExtension(Extension.subjectAlternativeName, false, (ASN1Encodable) generalNames);
        Extensions generate = extensionsGenerator.generate();
        Intrinsics.checkNotNullExpressionValue(generate, "ExtensionsGenerator().ap…   )\n        }.generate()");
        return generate;
    }

    public final PKCS10CertificationRequest generatePKCS10CertificationRequest(KeyPair keyPair, String str, String str2) throws IOException, OperatorCreationException {
        Intrinsics.checkNotNullParameter(keyPair, "keyPair");
        Intrinsics.checkNotNullParameter(str, "deviceIdentifier");
        Intrinsics.checkNotNullParameter(str2, "deviceCredential");
        String str3 = str + "-tigerbox.local";
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(SUBJECT_PATTERN, Arrays.copyOf(new Object[]{str3, str2}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        PrivateKey privateKey = keyPair.getPrivate();
        Intrinsics.checkNotNullExpressionValue(privateKey, "keyPair.private");
        PKCS10CertificationRequestBuilder jcaPKCS10CertificationRequestBuilder = new JcaPKCS10CertificationRequestBuilder(new X500Name(format), keyPair.getPublic());
        jcaPKCS10CertificationRequestBuilder.addAttribute(PKCSObjectIdentifiers.pkcs_9_at_extensionRequest, (ASN1Encodable) generateExtensions(str3));
        PKCS10CertificationRequest build = jcaPKCS10CertificationRequestBuilder.build(new PKCS10CertificationRequestGenerator(privateKey, DEFAULT_SIGNATURE_ALGORITHM));
        Intrinsics.checkNotNullExpressionValue(build, "csrBuilder.build(signer)");
        return build;
    }

    @Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/certificate/PKCS10CertificationRequestGenerator$Companion;", "", "()V", "DEFAULT_SIGNATURE_ALGORITHM", "", "KEY_SIZE", "", "SUBJECT_PATTERN", "algorithm", "", "Lorg/spongycastle/asn1/x509/AlgorithmIdentifier;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: PKCS10CertificationRequestGenerator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Map<String, AlgorithmIdentifier> hashMap = new HashMap<>();
        algorithm = hashMap;
        String lowerCase = DEFAULT_SIGNATURE_ALGORITHM.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        hashMap.put(lowerCase, new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.2.840.113549.1.1.11")));
        String lowerCase2 = "SHA1withRSA".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        hashMap.put(lowerCase2, new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5")));
    }
}
