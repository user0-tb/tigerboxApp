package media.tiger.tigerbox.webserver;

import kotlin.Metadata;
import media.tiger.tigerbox.webserver.controller.RestController;
import p011fi.iki.elonen.NanoHTTPD;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u001c\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u00060\tj\u0002`\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\u000bH&J\b\u0010\u0012\u001a\u00020\u000bH&¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/WebServer;", "", "checkAuthentication", "", "session", "Lfi/iki/elonen/NanoHTTPD$IHTTPSession;", "getController", "Lmedia/tiger/tigerbox/webserver/controller/RestController;", "controllerClassName", "", "prepareBoxHostname", "", "registerController", "endpointPath", "Lmedia/tiger/tigerbox/webserver/controller/EndpointPath;", "restController", "restartWebServer", "startServer", "stopServer", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WebServer.kt */
public interface WebServer {
    boolean checkAuthentication(NanoHTTPD.IHTTPSession iHTTPSession);

    RestController getController(String str);

    void prepareBoxHostname();

    void registerController(String str, RestController restController);

    void restartWebServer();

    void startServer();

    void stopServer();
}
