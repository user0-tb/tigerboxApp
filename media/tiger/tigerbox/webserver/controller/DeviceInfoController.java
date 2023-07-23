package media.tiger.tigerbox.webserver.controller;

import com.google.gson.Gson;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.webserver.WebServer;
import media.tiger.tigerbox.webserver.dto.DeviceInfoDtoKt;
import media.tiger.tigerbox.webserver.dto.UpdateDeviceInfoDto;
import media.tiger.tigerbox.webserver.exception.BadRequestException;
import media.tiger.tigerbox.webserver.responses.ResponseFactory;
import p011fi.iki.elonen.NanoHTTPD;

@Metadata(mo33736d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B#\u0012\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0016RU\u0010\n\u001a=\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012/\u0012-\u0012\u0004\u0012\u00020\f\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r0\u000bj\u0002`\u00130\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/controller/DeviceInfoController;", "Lmedia/tiger/tigerbox/webserver/controller/RestController;", "endpointMappingUrl", "", "Lmedia/tiger/tigerbox/webserver/controller/EndpointPath;", "webServer", "Lmedia/tiger/tigerbox/webserver/WebServer;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "(Ljava/lang/String;Lmedia/tiger/tigerbox/webserver/WebServer;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;)V", "endpointHandlers", "", "Lfi/iki/elonen/NanoHTTPD$Method;", "Lkotlin/Function1;", "Lfi/iki/elonen/NanoHTTPD$IHTTPSession;", "Lkotlin/ParameterName;", "name", "session", "Lfi/iki/elonen/NanoHTTPD$Response;", "Lmedia/tiger/tigerbox/webserver/controller/EndpointHandler;", "getEndpointHandlers", "()Ljava/util/Map;", "setEndpointHandlers", "(Ljava/util/Map;)V", "changeDeviceConfigurationHandler", "getDeviceInfoHandler", "registerEndpoints", "", "requiresAuthentication", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DeviceInfoController.kt */
public final class DeviceInfoController extends RestController {
    protected Map<String, ? extends Map<NanoHTTPD.Method, ? extends Function1<? super NanoHTTPD.IHTTPSession, ? extends NanoHTTPD.Response>>> endpointHandlers;
    private final MetaDataService metaDataService;

    public boolean requiresAuthentication() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceInfoController(String str, WebServer webServer, MetaDataService metaDataService2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "/deviceInfo" : str, webServer, metaDataService2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceInfoController(String str, WebServer webServer, MetaDataService metaDataService2) {
        super(str, webServer);
        Intrinsics.checkNotNullParameter(str, "endpointMappingUrl");
        Intrinsics.checkNotNullParameter(webServer, "webServer");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
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
        setEndpointHandlers(MapsKt.mapOf(TuplesKt.m475to(getEndpointMappingUrl(), MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.GET, new DeviceInfoController$registerEndpoints$1(this)), TuplesKt.m475to(NanoHTTPD.Method.PATCH, new DeviceInfoController$registerEndpoints$2(this))))));
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response getDeviceInfoHandler(NanoHTTPD.IHTTPSession iHTTPSession) {
        return ResponseFactory.Companion.getDeviceInfoResponse(this.metaDataService.getDeviceInfo());
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response changeDeviceConfigurationHandler(NanoHTTPD.IHTTPSession iHTTPSession) {
        try {
            Object fromJson = new Gson().fromJson(extractBodyFromPatchRequest(iHTTPSession), UpdateDeviceInfoDto.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(extractB…eviceInfoDto::class.java)");
            this.metaDataService.updateDeviceInfo(DeviceInfoDtoKt.validateAndSanitize((UpdateDeviceInfoDto) fromJson));
            return ResponseFactory.Companion.okResponse();
        } catch (BadRequestException e) {
            throw e;
        } catch (Exception unused) {
            throw new BadRequestException("Unable to parse body, please check your content.");
        }
    }
}
