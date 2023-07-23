package media.tiger.tigerbox.services.implementations.wifi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/wifi/PingTask;", "", "socket", "Ljava/net/Socket;", "endpoint", "Lmedia/tiger/tigerbox/services/implementations/wifi/Endpoint;", "(Ljava/net/Socket;Lmedia/tiger/tigerbox/services/implementations/wifi/Endpoint;)V", "invoke", "", "removeHttpsFromUrl", "", "url", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: PingTask.kt */
public final class PingTask {
    private final Endpoint endpoint;
    private final Socket socket;

    public PingTask(Socket socket2, Endpoint endpoint2) {
        Intrinsics.checkNotNullParameter(socket2, "socket");
        Intrinsics.checkNotNullParameter(endpoint2, "endpoint");
        this.socket = socket2;
        this.endpoint = endpoint2;
    }

    public final boolean invoke() {
        try {
            this.socket.connect(new InetSocketAddress(removeHttpsFromUrl(this.endpoint.getUrl()), this.endpoint.getPort()), PingTaskKt.PING_TIMEOUT);
            this.socket.close();
            Timber.Forest.tag("Ping:").mo50214d("Ping connection succeeded", new Object[0]);
            return true;
        } catch (IOException unused) {
            Timber.Forest.tag("Ping:").mo50217e("Ping connection failed", new Object[0]);
            return false;
        }
    }

    private final String removeHttpsFromUrl(String str) {
        return StringsKt.replace$default(str, "https://", "", false, 4, (Object) null);
    }
}
