package media.tiger.tigerbox.webserver.certificate;

import java.security.Signature;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "Ljava/security/Signature;", "kotlin.jvm.PlatformType", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PKCS10CertificationRequestGenerator.kt */
final class PKCS10CertificationRequestGenerator$signature$2 extends Lambda implements Function0<Signature> {
    final /* synthetic */ String $signingAlgorithm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PKCS10CertificationRequestGenerator$signature$2(String str) {
        super(0);
        this.$signingAlgorithm = str;
    }

    public final Signature invoke() {
        return Signature.getInstance(this.$signingAlgorithm);
    }
}
