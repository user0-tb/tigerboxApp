package media.tiger.tigerbox.webserver;

import android.content.Context;
import android.content.IntentFilter;
import com.tigermedia.tigerbox.mdns.DnsLibrary;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.webserver.controller.RestController;
import media.tiger.tigerbox.webserver.responses.ResponseFactory;
import p011fi.iki.elonen.NanoHTTPD;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0014\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010\u00102\u0006\u0010!\u001a\u00020\u000eH\u0016J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00102\b\u0010#\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010$\u001a\u00020%H\u0016J\u001c\u0010&\u001a\u00020%2\n\u0010'\u001a\u00060\u000ej\u0002`\u000f2\u0006\u0010(\u001a\u00020\u0010H\u0016J\b\u0010)\u001a\u00020%H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010,\u001a\u00020%H\u0016J\b\u0010-\u001a\u00020%H\u0016J\u0010\u0010.\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\b\u0012\u00060\u000ej\u0002`\u000f\u0012\u0004\u0012\u00020\u00100\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/TigerBoxWebServer;", "Lfi/iki/elonen/NanoHTTPD;", "Lmedia/tiger/tigerbox/webserver/WebServer;", "context", "Landroid/content/Context;", "serverPort", "", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "(Landroid/content/Context;ILmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;)V", "controllers", "", "", "Lmedia/tiger/tigerbox/webserver/controller/EndpointPath;", "Lmedia/tiger/tigerbox/webserver/controller/RestController;", "isServerStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "powerOffReceiver", "media/tiger/tigerbox/webserver/TigerBoxWebServer$powerOffReceiver$1", "Lmedia/tiger/tigerbox/webserver/TigerBoxWebServer$powerOffReceiver$1;", "serverName", "getServerName", "()Ljava/lang/String;", "serverName$delegate", "Lkotlin/Lazy;", "serverType", "checkAuthentication", "", "session", "Lfi/iki/elonen/NanoHTTPD$IHTTPSession;", "getController", "controllerClassName", "locateController", "requestUri", "prepareBoxHostname", "", "registerController", "endpointPath", "restController", "restartWebServer", "serve", "Lfi/iki/elonen/NanoHTTPD$Response;", "startServer", "stopServer", "formUri", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxWebServer.kt */
public final class TigerBoxWebServer extends NanoHTTPD implements WebServer {
    private final Context context;
    private final Map<String, RestController> controllers;
    private final AtomicBoolean isServerStarted;
    /* access modifiers changed from: private */
    public final MetaDataService metaDataService;
    private final TigerBoxWebServer$powerOffReceiver$1 powerOffReceiver;
    private final Lazy serverName$delegate;
    private final int serverPort;
    private final String serverType;
    private final StorageService storageService;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TigerBoxWebServer(Context context2, int i, StorageService storageService2, MetaDataService metaDataService2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, (i2 & 2) != 0 ? 443 : i, storageService2, metaDataService2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TigerBoxWebServer(Context context2, int i, StorageService storageService2, MetaDataService metaDataService2) {
        super(i);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        this.context = context2;
        this.serverPort = i;
        this.storageService = storageService2;
        this.metaDataService = metaDataService2;
        this.controllers = new LinkedHashMap();
        this.isServerStarted = new AtomicBoolean(false);
        this.serverName$delegate = LazyKt.lazy(new TigerBoxWebServer$serverName$2(this));
        this.serverType = "_tigerbox._tcp";
        TigerBoxWebServer$powerOffReceiver$1 tigerBoxWebServer$powerOffReceiver$1 = new TigerBoxWebServer$powerOffReceiver$1(this);
        this.powerOffReceiver = tigerBoxWebServer$powerOffReceiver$1;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_SHUTDOWN");
        Unit unit = Unit.INSTANCE;
        context2.registerReceiver(tigerBoxWebServer$powerOffReceiver$1, intentFilter);
    }

    private final String getServerName() {
        return (String) this.serverName$delegate.getValue();
    }

    public void prepareBoxHostname() {
        new DnsLibrary().prepareHostname(this.metaDataService.getDomain(), this.metaDataService.getCpuId());
    }

    public void startServer() {
        if (!this.isServerStarted.get()) {
            Timber.Forest.tag("Webserver").mo50214d("Webserver start", new Object[0]);
            setServerSocketFactory(new NanoHTTPD.SecureServerSocketFactory(NanoHTTPD.makeSSLSocketFactory(this.storageService.getKeyStore(), this.storageService.getKeyManagerFactory()), (String[]) null));
            new DnsLibrary().startServer(this.metaDataService.getDomain(), getServerName(), this.serverType, this.metaDataService.getCpuId(), this.metaDataService.getIpAddress(), this.metaDataService.getNetHostname(), this.serverPort);
            try {
                start(5000, false);
                this.isServerStarted.set(true);
            } catch (IOException e) {
                Timber.Forest.tag("Webserver").mo50218e(e);
                this.isServerStarted.set(true);
            }
        }
    }

    public void stopServer() {
        if (this.isServerStarted.get()) {
            Timber.Forest.tag("Webserver").mo50214d("Webserver stop", new Object[0]);
            stop();
            new DnsLibrary().stopServer();
            this.isServerStarted.set(false);
        }
    }

    public void restartWebServer() {
        Timber.Tree tag = Timber.Forest.tag("Webserver");
        StringBuilder sb = new StringBuilder();
        sb.append("Webserver restart ");
        DeviceInformation deviceInformation = this.storageService.getDeviceInformation();
        sb.append(deviceInformation != null ? deviceInformation.getDeviceApiKey() : null);
        tag.mo50214d(sb.toString(), new Object[0]);
        stopServer();
        startServer();
    }

    public RestController getController(String str) {
        Intrinsics.checkNotNullParameter(str, "controllerClassName");
        for (Map.Entry next : this.controllers.entrySet()) {
            String name = next.getValue().getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.value.javaClass.name");
            if (StringsKt.contains$default((CharSequence) name, (CharSequence) str, false, 2, (Object) null)) {
                return (RestController) next.getValue();
            }
        }
        return null;
    }

    public void registerController(String str, RestController restController) {
        Intrinsics.checkNotNullParameter(str, "endpointPath");
        Intrinsics.checkNotNullParameter(restController, "restController");
        this.controllers.put(str, restController);
    }

    public NanoHTTPD.Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        String str;
        if (iHTTPSession != null) {
            try {
                str = iHTTPSession.getUri();
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("WEBSERVER: Exception occurred: " + e, new Object[0]);
                return ResponseFactory.Companion.internalServerError();
            }
        } else {
            str = null;
        }
        String formUri = formUri(str);
        RestController locateController = locateController(formUri);
        if (locateController != null) {
            if (iHTTPSession == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (formUri == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (!locateController.requiresAuthentication() || checkAuthentication(iHTTPSession)) {
                return locateController.handleRequest(formUri, iHTTPSession);
            } else {
                Timber.Forest.mo50217e("WEBSERVER: Exception occurred, invalid authorization header", new Object[0]);
                return ResponseFactory.Companion.unauthorizedResponse("INVALID API KEY OR NO AUTHORIZATION HEADER", formUri);
            }
        } else if (formUri != null) {
            return ResponseFactory.Companion.notFoundResponse(formUri);
        } else {
            return ResponseFactory.Companion.notFoundResponse();
        }
    }

    private final String formUri(String str) {
        return (str == null || !StringsKt.endsWith$default(str, DownloadsManager.FOLDERS_SEPARATOR, false, 2, (Object) null) || str.length() == 1) ? str : StringsKt.substringBeforeLast$default(str, DownloadsManager.FOLDERS_SEPARATOR, (String) null, 2, (Object) null);
    }

    private final RestController locateController(String str) {
        if (str == null) {
            return null;
        }
        for (int length = str.length(); -1 < length; length--) {
            String substring = str.substring(0, length);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            RestController restController = this.controllers.get(substring);
            if (restController != null) {
                return restController;
            }
        }
        return null;
    }

    public boolean checkAuthentication(NanoHTTPD.IHTTPSession iHTTPSession) {
        String deviceApiKey;
        Intrinsics.checkNotNullParameter(iHTTPSession, "session");
        String str = iHTTPSession.getHeaders().get("authorization");
        DeviceInformation deviceInformation = this.storageService.getDeviceInformation();
        if (deviceInformation != null && (deviceApiKey = deviceInformation.getDeviceApiKey()) != null) {
            return Intrinsics.areEqual((Object) deviceApiKey, (Object) str);
        }
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder();
        sb.append("checkAuthentication ");
        sb.append(str);
        sb.append(" vs ");
        DeviceInformation deviceInformation2 = this.storageService.getDeviceInformation();
        sb.append(deviceInformation2 != null ? deviceInformation2.getDeviceApiKey() : null);
        forest.mo50221i(sb.toString(), new Object[0]);
        return false;
    }
}
