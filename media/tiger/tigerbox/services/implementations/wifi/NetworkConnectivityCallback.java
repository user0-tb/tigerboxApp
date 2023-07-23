package media.tiger.tigerbox.services.implementations.wifi;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/wifi/NetworkConnectivityCallback;", "Landroid/net/ConnectivityManager$NetworkCallback;", "connectionCallback", "Lmedia/tiger/tigerbox/services/implementations/wifi/ConnectionCallback;", "(Lmedia/tiger/tigerbox/services/implementations/wifi/ConnectionCallback;)V", "validNetworks", "", "Landroid/net/Network;", "onAvailable", "", "network", "onCapabilitiesChanged", "networkCapabilities", "Landroid/net/NetworkCapabilities;", "onLost", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NetworkConnectivityCallback.kt */
public final class NetworkConnectivityCallback extends ConnectivityManager.NetworkCallback {
    /* access modifiers changed from: private */
    public final ConnectionCallback connectionCallback;
    /* access modifiers changed from: private */
    public final Set<Network> validNetworks = new HashSet();

    public NetworkConnectivityCallback(ConnectionCallback connectionCallback2) {
        Intrinsics.checkNotNullParameter(connectionCallback2, "connectionCallback");
        this.connectionCallback = connectionCallback2;
    }

    public void onAvailable(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new NetworkConnectivityCallback$onAvailable$1(this, network, (Continuation<? super NetworkConnectivityCallback$onAvailable$1>) null), 3, (Object) null);
    }

    public void onLost(Network network) {
        Intrinsics.checkNotNullParameter(network, "network");
        this.validNetworks.remove(network);
        this.connectionCallback.onConnectionLost();
    }

    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.checkNotNullParameter(network, "network");
        Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
        Timber.Tree tag = Timber.Forest.tag("Tiger WiFi:");
        tag.mo50214d("onCapabilitiesChanged: " + networkCapabilities, new Object[0]);
    }
}
