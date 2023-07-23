package okhttp3.internal.connection;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.Handshake;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "", "Ljava/security/cert/X509Certificate;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ConnectPlan.kt */
final class ConnectPlan$connectTls$1 extends Lambda implements Function0<List<? extends X509Certificate>> {
    final /* synthetic */ Handshake $handshake;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectPlan$connectTls$1(Handshake handshake) {
        super(0);
        this.$handshake = handshake;
    }

    public final List<X509Certificate> invoke() {
        Iterable<Certificate> peerCertificates = this.$handshake.peerCertificates();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(peerCertificates, 10));
        for (Certificate certificate : peerCertificates) {
            arrayList.add((X509Certificate) certificate);
        }
        return (List) arrayList;
    }
}
