package media.tiger.tigerbox.webserver.controller;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.webserver.WebServer;
import media.tiger.tigerbox.webserver.responses.ResponseFactory;
import p011fi.iki.elonen.NanoHTTPD;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)BM\u0012\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012 \u0010\u000b\u001a\u001c\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00110\f¢\u0006\u0002\u0010\u0012J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0014J\b\u0010#\u001a\u00020$H\u0016J$\u0010%\u001a\u00020\u00102\n\u0010&\u001a\u00060\rj\u0002`\u000e2\u0010\u0010'\u001a\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u0011J\u0012\u0010(\u001a\u00020\u00102\n\u0010&\u001a\u00060\rj\u0002`\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u001c\u0012\b\u0012\u00060\rj\u0002`\u000e\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00100\u000fj\u0002`\u00110\fX\u0004¢\u0006\u0002\n\u0000RU\u0010\u0013\u001a=\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012/\u0012-\u0012\u0004\u0012\u00020\u0015\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u00160\u0014j\u0002`\u001c0\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/controller/ProfilesRestController;", "Lmedia/tiger/tigerbox/webserver/controller/RestController;", "endpointMappingUrl", "", "Lmedia/tiger/tigerbox/webserver/controller/EndpointPath;", "webServer", "Lmedia/tiger/tigerbox/webserver/WebServer;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "contentUpdateSubscribers", "", "", "Lmedia/tiger/tigerbox/webserver/controller/Subscriber;", "Lkotlin/Function0;", "", "Lmedia/tiger/tigerbox/webserver/controller/SubscriberAction;", "(Ljava/lang/String;Lmedia/tiger/tigerbox/webserver/WebServer;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Ljava/util/Map;)V", "endpointHandlers", "", "Lfi/iki/elonen/NanoHTTPD$Method;", "Lkotlin/Function1;", "Lfi/iki/elonen/NanoHTTPD$IHTTPSession;", "Lkotlin/ParameterName;", "name", "session", "Lfi/iki/elonen/NanoHTTPD$Response;", "Lmedia/tiger/tigerbox/webserver/controller/EndpointHandler;", "getEndpointHandlers", "()Ljava/util/Map;", "setEndpointHandlers", "(Ljava/util/Map;)V", "refreshProfile", "registerEndpoints", "requiresAuthentication", "", "subscribeToContentRefresh", "subscriber", "subscriberAction", "unsubscribeToContentRefresh", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProfilesRestController.kt */
public final class ProfilesRestController extends RestController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOGGING_TAG = "[WEBSERVER]";
    private final TigerBoxAccountRepository accountRepository;
    private final Map<Object, Function0<Unit>> contentUpdateSubscribers;
    protected Map<String, ? extends Map<NanoHTTPD.Method, ? extends Function1<? super NanoHTTPD.IHTTPSession, ? extends NanoHTTPD.Response>>> endpointHandlers;
    private final MetaDataService metaDataService;

    public boolean requiresAuthentication() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProfilesRestController(String str, WebServer webServer, TigerBoxAccountRepository tigerBoxAccountRepository, MetaDataService metaDataService2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "/profiles" : str, webServer, tigerBoxAccountRepository, metaDataService2, map);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfilesRestController(String str, WebServer webServer, TigerBoxAccountRepository tigerBoxAccountRepository, MetaDataService metaDataService2, Map<Object, Function0<Unit>> map) {
        super(str, webServer);
        Intrinsics.checkNotNullParameter(str, "endpointMappingUrl");
        Intrinsics.checkNotNullParameter(webServer, "webServer");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(map, "contentUpdateSubscribers");
        this.accountRepository = tigerBoxAccountRepository;
        this.metaDataService = metaDataService2;
        this.contentUpdateSubscribers = map;
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/controller/ProfilesRestController$Companion;", "", "()V", "LOGGING_TAG", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ProfilesRestController.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
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
        setEndpointHandlers(MapsKt.mapOf(TuplesKt.m475to(getEndpointMappingUrl() + "/refresh", MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.POST, new ProfilesRestController$registerEndpoints$1(this))))));
    }

    public final void subscribeToContentRefresh(Object obj, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(obj, "subscriber");
        Intrinsics.checkNotNullParameter(function0, "subscriberAction");
        this.contentUpdateSubscribers.put(obj, function0);
    }

    public final void unsubscribeToContentRefresh(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "subscriber");
        this.contentUpdateSubscribers.remove(obj);
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response refreshProfile(NanoHTTPD.IHTTPSession iHTTPSession) {
        try {
            this.accountRepository.requestUpdatedProfilesInfoFromServer(ProfilesRestController$refreshProfile$1.INSTANCE);
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("[WEBSERVER]: Unable to invoke action " + e.getLocalizedMessage(), new Object[0]);
        }
        return ResponseFactory.Companion.okResponse();
    }
}
