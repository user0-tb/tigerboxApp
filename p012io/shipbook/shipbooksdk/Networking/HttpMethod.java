package p012io.shipbook.shipbooksdk.Networking;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Networking/HttpMethod;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GET", "POST", "DELETE", "PUT", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Networking.HttpMethod */
/* compiled from: ConnectionClient.kt */
public enum HttpMethod {
    GET("GET"),
    POST("POST"),
    DELETE("DELETE"),
    PUT("PUT");
    
    private final String value;

    private HttpMethod(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
