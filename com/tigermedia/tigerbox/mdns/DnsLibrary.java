package com.tigermedia.tigerbox.mdns;

import com.tigermedia.tigerbox.mdns.MulticastDNS;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H JM\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0004H J\t\u0010\u000e\u001a\u00020\u0004H J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J@\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016¨\u0006\u0016"}, mo33737d2 = {"Lcom/tigermedia/tigerbox/mdns/DnsLibrary;", "Lcom/tigermedia/tigerbox/mdns/MulticastDNS;", "()V", "mDnsPrepareHostname", "", "domain", "", "identifier", "mDnsStart", "serverName", "serverType", "ipAddress", "netHostName", "port", "mDnsStop", "prepareHostname", "", "startServer", "Lcom/tigermedia/tigerbox/mdns/MulticastDNS$Status;", "ipAdress", "stopServer", "Companion", "mDns_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DnsLibrary.kt */
public final class DnsLibrary implements MulticastDNS {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int SUCCESS = 0;

    private final native int mDnsPrepareHostname(String str, String str2);

    private final native int mDnsStart(String str, String str2, String str3, String str4, String str5, String str6, int i);

    private final native int mDnsStop();

    public void prepareHostname(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "domain");
        Intrinsics.checkNotNullParameter(str2, "identifier");
        mDnsPrepareHostname(str, str2);
    }

    public MulticastDNS.Status startServer(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        Intrinsics.checkNotNullParameter(str, "domain");
        Intrinsics.checkNotNullParameter(str2, "serverName");
        Intrinsics.checkNotNullParameter(str3, "serverType");
        Intrinsics.checkNotNullParameter(str4, "identifier");
        Intrinsics.checkNotNullParameter(str5, "ipAdress");
        Intrinsics.checkNotNullParameter(str6, "netHostName");
        return mDnsStart(str, str2, str3, str4, str5, str6, i) == 0 ? MulticastDNS.Status.CONNECTION_SUCCESSFUL : MulticastDNS.Status.CONNECTION_FAILED;
    }

    public void stopServer() {
        mDnsStop();
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lcom/tigermedia/tigerbox/mdns/DnsLibrary$Companion;", "", "()V", "SUCCESS", "", "mDns_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DnsLibrary.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        System.loadLibrary("mdnssd");
        System.loadLibrary("dns-sd");
    }
}
