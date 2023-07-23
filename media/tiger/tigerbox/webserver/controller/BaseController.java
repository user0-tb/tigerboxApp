package media.tiger.tigerbox.webserver.controller;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.WakeService;
import media.tiger.tigerbox.webserver.WebServer;
import media.tiger.tigerbox.webserver.dto.IsAliveDto;
import media.tiger.tigerbox.webserver.responses.DefaultResponses;
import media.tiger.tigerbox.webserver.responses.ResponseFactory;
import p011fi.iki.elonen.NanoHTTPD;

@Metadata(mo33736d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B3\u0012\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020$H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000RU\u0010\u000e\u001a=\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012/\u0012-\u0012\u0004\u0012\u00020\u0010\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u00110\u000fj\u0002`\u00170\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/controller/BaseController;", "Lmedia/tiger/tigerbox/webserver/controller/RestController;", "endpointMappingUrl", "", "Lmedia/tiger/tigerbox/webserver/controller/EndpointPath;", "webServer", "Lmedia/tiger/tigerbox/webserver/WebServer;", "wakeService", "Lmedia/tiger/tigerbox/services/interfaces/WakeService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "(Ljava/lang/String;Lmedia/tiger/tigerbox/webserver/WebServer;Lmedia/tiger/tigerbox/services/interfaces/WakeService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;)V", "endpointHandlers", "", "Lfi/iki/elonen/NanoHTTPD$Method;", "Lkotlin/Function1;", "Lfi/iki/elonen/NanoHTTPD$IHTTPSession;", "Lkotlin/ParameterName;", "name", "session", "Lfi/iki/elonen/NanoHTTPD$Response;", "Lmedia/tiger/tigerbox/webserver/controller/EndpointHandler;", "getEndpointHandlers", "()Ljava/util/Map;", "setEndpointHandlers", "(Ljava/util/Map;)V", "extractKeepAliveTimeParam", "", "uri", "(Ljava/lang/String;)Ljava/lang/Integer;", "isAliveHandler", "keepAliveHandler", "keepAliveHandlerWithTimeParam", "registerEndpoints", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: BaseController.kt */
public final class BaseController extends RestController {
    private final ConfigurationProperties configurationProperties;
    protected Map<String, ? extends Map<NanoHTTPD.Method, ? extends Function1<? super NanoHTTPD.IHTTPSession, ? extends NanoHTTPD.Response>>> endpointHandlers;
    private final MetaDataService metaDataService;
    private final WakeService wakeService;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseController(String str, WebServer webServer, WakeService wakeService2, ConfigurationProperties configurationProperties2, MetaDataService metaDataService2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DownloadsManager.FOLDERS_SEPARATOR : str, webServer, wakeService2, configurationProperties2, metaDataService2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseController(String str, WebServer webServer, WakeService wakeService2, ConfigurationProperties configurationProperties2, MetaDataService metaDataService2) {
        super(str, webServer);
        Intrinsics.checkNotNullParameter(str, "endpointMappingUrl");
        Intrinsics.checkNotNullParameter(webServer, "webServer");
        Intrinsics.checkNotNullParameter(wakeService2, "wakeService");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        this.wakeService = wakeService2;
        this.configurationProperties = configurationProperties2;
        this.metaDataService = metaDataService2;
    }

    /* access modifiers changed from: protected */
    public Map<String, Map<NanoHTTPD.Method, Function1<NanoHTTPD.IHTTPSession, NanoHTTPD.Response>>> getEndpointHandlers() {
        Map<String, ? extends Map<NanoHTTPD.Method, ? extends Function1<? super NanoHTTPD.IHTTPSession, ? extends NanoHTTPD.Response>>> map = this.endpointHandlers;
        if (map != null) {
            return map;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endpointHandlers");
        return null;
    }

    /* access modifiers changed from: protected */
    public void setEndpointHandlers(Map<String, ? extends Map<NanoHTTPD.Method, ? extends Function1<? super NanoHTTPD.IHTTPSession, ? extends NanoHTTPD.Response>>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.endpointHandlers = map;
    }

    /* access modifiers changed from: protected */
    public void registerEndpoints() {
        setEndpointHandlers(MapsKt.mapOf(TuplesKt.m475to(getEndpointMappingUrl() + "keepAlive", MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.GET, new BaseController$registerEndpoints$1(this)))), TuplesKt.m475to(getEndpointMappingUrl() + "keepAlive/{time}", MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.GET, new BaseController$registerEndpoints$2(this)))), TuplesKt.m475to(getEndpointMappingUrl() + "isAlive", MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.GET, new BaseController$registerEndpoints$3(this))))));
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response keepAliveHandler(NanoHTTPD.IHTTPSession iHTTPSession) {
        this.wakeService.keepAlive(Integer.parseInt(this.configurationProperties.getProperty("default.keep.alive.duration.minutes")));
        return ResponseFactory.Companion.createdResponse();
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response keepAliveHandlerWithTimeParam(NanoHTTPD.IHTTPSession iHTTPSession) {
        String uri = iHTTPSession.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "session.uri");
        Integer extractKeepAliveTimeParam = extractKeepAliveTimeParam(uri);
        if (extractKeepAliveTimeParam != null) {
            this.wakeService.keepAlive(extractKeepAliveTimeParam.intValue());
            return ResponseFactory.Companion.createdResponse();
        }
        ResponseFactory.Companion companion = ResponseFactory.Companion;
        String uri2 = iHTTPSession.getUri();
        Intrinsics.checkNotNullExpressionValue(uri2, "session.uri");
        return companion.badRequestResponse("Invalid keep alive time format", uri2);
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response isAliveHandler(NanoHTTPD.IHTTPSession iHTTPSession) {
        return ResponseFactory.Companion.okResponseWithBody(DefaultResponses.SuccessResponses.INSTANCE.getDeviceIdentifierResponse(new IsAliveDto(this.metaDataService.getCpuId(), this.metaDataService.getNetHostname())));
    }

    private final Integer extractKeepAliveTimeParam(String str) {
        int i;
        Integer intOrNull = StringsKt.toIntOrNull(StringsKt.substringAfterLast$default(str, DownloadsManager.FOLDERS_SEPARATOR, (String) null, 2, (Object) null));
        int parseInt = Integer.parseInt(this.configurationProperties.getProperty("default.keep.alive.duration.minutes"));
        if (intOrNull == null) {
            return null;
        }
        if (intOrNull.intValue() < parseInt) {
            i = Integer.parseInt(this.configurationProperties.getProperty("default.keep.alive.duration.minutes"));
        } else {
            i = intOrNull.intValue();
        }
        return Integer.valueOf(i);
    }
}
