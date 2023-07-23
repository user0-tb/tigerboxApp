package com.tigermedia.tigerbox.mdns;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J@\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0011"}, mo33737d2 = {"Lcom/tigermedia/tigerbox/mdns/MulticastDNS;", "", "prepareHostname", "", "domain", "", "identifier", "startServer", "Lcom/tigermedia/tigerbox/mdns/MulticastDNS$Status;", "serverName", "serverType", "ipAddress", "netHostname", "port", "", "stopServer", "Status", "mDns_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: MulticastDNS.kt */
public interface MulticastDNS {

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo33737d2 = {"Lcom/tigermedia/tigerbox/mdns/MulticastDNS$Status;", "", "(Ljava/lang/String;I)V", "CONNECTION_SUCCESSFUL", "CONNECTION_FAILED", "mDns_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: MulticastDNS.kt */
    public enum Status {
        CONNECTION_SUCCESSFUL,
        CONNECTION_FAILED
    }

    void prepareHostname(String str, String str2);

    Status startServer(String str, String str2, String str3, String str4, String str5, String str6, int i);

    void stopServer();
}
