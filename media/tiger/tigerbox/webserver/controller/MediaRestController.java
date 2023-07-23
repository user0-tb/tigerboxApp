package media.tiger.tigerbox.webserver.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.model.domain.DownloadReason;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import media.tiger.tigerbox.services.interfaces.AcquisitionReason;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionDelegate;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.webserver.WebServer;
import media.tiger.tigerbox.webserver.dto.OfflineProductDto;
import media.tiger.tigerbox.webserver.dto.PlaybackDto;
import media.tiger.tigerbox.webserver.responses.ResponseFactory;
import p011fi.iki.elonen.NanoHTTPD;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00015BU\u0012\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012 \u0010\r\u001a\u001c\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u00130\u000e¢\u0006\u0002\u0010\u0014J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0017\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0012H\u0014J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J$\u00101\u001a\u00020\u00122\n\u00102\u001a\u00060\u000fj\u0002`\u00102\u0010\u00103\u001a\f\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u0013J\u0012\u00104\u001a\u00020\u00122\n\u00102\u001a\u00060\u000fj\u0002`\u0010R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R(\u0010\r\u001a\u001c\u0012\b\u0012\u00060\u000fj\u0002`\u0010\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00120\u0011j\u0002`\u00130\u000eX\u0004¢\u0006\u0002\n\u0000RU\u0010\u0015\u001a=\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012/\u0012-\u0012\u0004\u0012\u00020\u0017\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u00180\u0016j\u0002`\u001e0\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u00066"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/controller/MediaRestController;", "Lmedia/tiger/tigerbox/webserver/controller/RestController;", "endpointMappingUrl", "", "Lmedia/tiger/tigerbox/webserver/controller/EndpointPath;", "webServer", "Lmedia/tiger/tigerbox/webserver/WebServer;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "audioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "productAcquisitionService", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "contentUpdateSubscribers", "", "", "Lmedia/tiger/tigerbox/webserver/controller/Subscriber;", "Lkotlin/Function0;", "", "Lmedia/tiger/tigerbox/webserver/controller/SubscriberAction;", "(Ljava/lang/String;Lmedia/tiger/tigerbox/webserver/WebServer;Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;Ljava/util/Map;)V", "endpointHandlers", "", "Lfi/iki/elonen/NanoHTTPD$Method;", "Lkotlin/Function1;", "Lfi/iki/elonen/NanoHTTPD$IHTTPSession;", "Lkotlin/ParameterName;", "name", "session", "Lfi/iki/elonen/NanoHTTPD$Response;", "Lmedia/tiger/tigerbox/webserver/controller/EndpointHandler;", "getEndpointHandlers", "()Ljava/util/Map;", "setEndpointHandlers", "(Ljava/util/Map;)V", "deleteOfflineContent", "extractProductPathParam", "", "uri", "(Ljava/lang/String;)Ljava/lang/Integer;", "getAllOfflineAvailableProducts", "getCurrentProduct", "pausePlayback", "registerEndpoints", "reloadMainContent", "requiresAuthentication", "", "startDownload", "startPlayback", "subscribeToContentRefresh", "subscriber", "subscriberAction", "unsubscribeToContentRefresh", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: MediaRestController.kt */
public final class MediaRestController extends RestController {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOGGING_TAG = "[WEBSERVER]";
    /* access modifiers changed from: private */
    public final AudioPlayerService audioPlayerService;
    private final AvailabilityService availabilityService;
    private final Map<Object, Function0<Unit>> contentUpdateSubscribers;
    protected Map<String, ? extends Map<NanoHTTPD.Method, ? extends Function1<? super NanoHTTPD.IHTTPSession, ? extends NanoHTTPD.Response>>> endpointHandlers;
    private final ProductAcquisitionService productAcquisitionService;

    public boolean requiresAuthentication() {
        return true;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaRestController(String str, WebServer webServer, AvailabilityService availabilityService2, AudioPlayerService audioPlayerService2, ProductAcquisitionService productAcquisitionService2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "/media" : str, webServer, availabilityService2, audioPlayerService2, productAcquisitionService2, map);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaRestController(String str, WebServer webServer, AvailabilityService availabilityService2, AudioPlayerService audioPlayerService2, ProductAcquisitionService productAcquisitionService2, Map<Object, Function0<Unit>> map) {
        super(str, webServer);
        Intrinsics.checkNotNullParameter(str, "endpointMappingUrl");
        Intrinsics.checkNotNullParameter(webServer, "webServer");
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        Intrinsics.checkNotNullParameter(productAcquisitionService2, "productAcquisitionService");
        Intrinsics.checkNotNullParameter(map, "contentUpdateSubscribers");
        this.availabilityService = availabilityService2;
        this.audioPlayerService = audioPlayerService2;
        this.productAcquisitionService = productAcquisitionService2;
        this.contentUpdateSubscribers = map;
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/controller/MediaRestController$Companion;", "", "()V", "LOGGING_TAG", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: MediaRestController.kt */
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
        setEndpointHandlers(MapsKt.mapOf(TuplesKt.m475to(getEndpointMappingUrl(), MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.GET, new MediaRestController$registerEndpoints$1(this)))), TuplesKt.m475to(getEndpointMappingUrl() + "/play", MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.POST, new MediaRestController$registerEndpoints$2(this)), TuplesKt.m475to(NanoHTTPD.Method.GET, new MediaRestController$registerEndpoints$3(this)))), TuplesKt.m475to(getEndpointMappingUrl() + "/pause", MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.POST, new MediaRestController$registerEndpoints$4(this)))), TuplesKt.m475to(getEndpointMappingUrl() + "/{productId}", MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.POST, new MediaRestController$registerEndpoints$5(this)), TuplesKt.m475to(NanoHTTPD.Method.DELETE, new MediaRestController$registerEndpoints$6(this)))), TuplesKt.m475to(getEndpointMappingUrl() + "/reload", MapsKt.mapOf(TuplesKt.m475to(NanoHTTPD.Method.POST, new MediaRestController$registerEndpoints$7(this))))));
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
    public final NanoHTTPD.Response getAllOfflineAvailableProducts(NanoHTTPD.IHTTPSession iHTTPSession) {
        try {
            Iterable<ProductDomain> downloadedProducts = this.availabilityService.downloadedProducts();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(downloadedProducts, 10));
            for (ProductDomain id : downloadedProducts) {
                arrayList.add(new OfflineProductDto(id.getId()));
            }
            return ResponseFactory.Companion.offlineProductsResponse((List) arrayList);
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("[WEBSERVER]: Unable to get downloaded products " + e.getLocalizedMessage(), new Object[0]);
            return ResponseFactory.Companion.internalServerError();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p011fi.iki.elonen.NanoHTTPD.Response startPlayback(p011fi.iki.elonen.NanoHTTPD.IHTTPSession r20) {
        /*
            r19 = this;
            java.lang.String r1 = ""
            java.lang.String r2 = "session.uri"
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            java.util.concurrent.CountDownLatch r0 = new java.util.concurrent.CountDownLatch
            r3 = 1
            r0.<init>(r3)
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            media.tiger.tigerbox.webserver.responses.ResponseFactory$Companion r4 = media.tiger.tigerbox.webserver.responses.ResponseFactory.Companion
            fi.iki.elonen.NanoHTTPD$Response r4 = r4.okResponse()
            r9.element = r4
            com.google.gson.Gson r4 = new com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            r4.<init>()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.String r5 = r19.extractBody(r20)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.Class<media.tiger.tigerbox.webserver.dto.TonesPlaybackDto> r7 = media.tiger.tigerbox.webserver.dto.TonesPlaybackDto.class
            java.lang.Object r4 = r4.fromJson((java.lang.String) r5, r7)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.String r5 = "Gson()\n                .…sPlaybackDto::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r4 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r4     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r4 = media.tiger.tigerbox.webserver.dto.PlaybackDtoKt.validateAndSanitize(r4)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            r6.element = r4     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            r4 = -1
            r7 = -1
            T r5 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r5 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r5     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.Integer r5 = r5.getTrackNumber()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            if (r5 == 0) goto L_0x005c
            r4 = 0
            T r5 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r5 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r5     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.Integer r5 = r5.getTrackNumber()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            int r5 = r5.intValue()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            int r5 = r5 - r3
            int r4 = java.lang.Math.max(r4, r5)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            r12 = r4
            goto L_0x005d
        L_0x005c:
            r12 = -1
        L_0x005d:
            T r3 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r3 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r3     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.Long r3 = r3.getTrackPosition()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            if (r3 == 0) goto L_0x007c
            r3 = 0
            T r5 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r5 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r5     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.Long r5 = r5.getTrackPosition()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            long r7 = r5.longValue()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            long r7 = java.lang.Math.max(r3, r7)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
        L_0x007c:
            r13 = r7
            media.tiger.tigerbox.webserver.dto.PlaybackDto r3 = new media.tiger.tigerbox.webserver.dto.PlaybackDto     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            T r4 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r4 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r4     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            int r11 = r4.getProductId()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            T r4 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r4 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r4     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.String r15 = r4.getCoverUrl()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            T r4 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r4 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r4     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.String r16 = r4.getTitle()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            T r4 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r4 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r4     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.String r17 = r4.getAuthor()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            T r4 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r4 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r4     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.lang.Boolean r18 = r4.isPaused()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            r10 = r3
            r10.<init>((int) r11, (int) r12, (long) r13, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.Boolean) r18)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist$Companion r4 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist.Companion     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r3)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            T r5 = r6.element     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.webserver.dto.TonesPlaybackDto r5 = (media.tiger.tigerbox.webserver.dto.TonesPlaybackDto) r5     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            int r5 = r5.getProductId()     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason r7 = media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaybackReason.WEBSERVER_INITIATED     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            r8 = 0
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlaylist r10 = r4.create(r3, r5, r7, r8)     // Catch:{ JsonSyntaxException -> 0x0104, BadRequestException -> 0x00eb, Exception -> 0x00e7 }
            r11 = r19
            media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService r12 = r11.audioPlayerService     // Catch:{ JsonSyntaxException -> 0x00e5, BadRequestException -> 0x00e3, Exception -> 0x00e1 }
            media.tiger.tigerbox.webserver.controller.MediaRestController$startPlayback$1 r13 = new media.tiger.tigerbox.webserver.controller.MediaRestController$startPlayback$1     // Catch:{ JsonSyntaxException -> 0x00e5, BadRequestException -> 0x00e3, Exception -> 0x00e1 }
            r3 = r13
            r4 = r19
            r5 = r9
            r7 = r20
            r8 = r0
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ JsonSyntaxException -> 0x00e5, BadRequestException -> 0x00e3, Exception -> 0x00e1 }
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13     // Catch:{ JsonSyntaxException -> 0x00e5, BadRequestException -> 0x00e3, Exception -> 0x00e1 }
            r12.streamPlaylist(r10, r13)     // Catch:{ JsonSyntaxException -> 0x00e5, BadRequestException -> 0x00e3, Exception -> 0x00e1 }
            r1 = 10
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
            r0.await(r1, r3)
            T r0 = r9.element
            fi.iki.elonen.NanoHTTPD$Response r0 = (p011fi.iki.elonen.NanoHTTPD.Response) r0
            return r0
        L_0x00e1:
            r0 = move-exception
            goto L_0x00ea
        L_0x00e3:
            r0 = move-exception
            goto L_0x00ee
        L_0x00e5:
            r0 = move-exception
            goto L_0x0107
        L_0x00e7:
            r0 = move-exception
            r11 = r19
        L_0x00ea:
            throw r0
        L_0x00eb:
            r0 = move-exception
            r11 = r19
        L_0x00ee:
            media.tiger.tigerbox.webserver.responses.ResponseFactory$Companion r3 = media.tiger.tigerbox.webserver.responses.ResponseFactory.Companion
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x00f7
            goto L_0x00f8
        L_0x00f7:
            r1 = r0
        L_0x00f8:
            java.lang.String r0 = r20.getUri()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            fi.iki.elonen.NanoHTTPD$Response r0 = r3.badRequestResponse(r1, r0)
            return r0
        L_0x0104:
            r0 = move-exception
            r11 = r19
        L_0x0107:
            media.tiger.tigerbox.webserver.responses.ResponseFactory$Companion r3 = media.tiger.tigerbox.webserver.responses.ResponseFactory.Companion
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x0110
            goto L_0x0111
        L_0x0110:
            r1 = r0
        L_0x0111:
            java.lang.String r0 = r20.getUri()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            fi.iki.elonen.NanoHTTPD$Response r0 = r3.badRequestResponse(r1, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.webserver.controller.MediaRestController.startPlayback(fi.iki.elonen.NanoHTTPD$IHTTPSession):fi.iki.elonen.NanoHTTPD$Response");
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response pausePlayback(NanoHTTPD.IHTTPSession iHTTPSession) {
        this.audioPlayerService.pause();
        return ResponseFactory.Companion.okResponse();
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response startDownload(NanoHTTPD.IHTTPSession iHTTPSession) {
        String uri = iHTTPSession.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "session.uri");
        Integer extractProductPathParam = extractProductPathParam(uri);
        if (extractProductPathParam != null) {
            int intValue = extractProductPathParam.intValue();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = ResponseFactory.Companion.okResponse();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                if (this.availabilityService.offlineAvailabilityReason(intValue) == DownloadReason.AUTOMATIC_BY_NFC_CARD) {
                    this.availabilityService.changeDownloadReasonForProduct(intValue, DownloadReason.WEBSERVER_INITIATED, new MediaRestController$startDownload$1(countDownLatch));
                    countDownLatch.await(10, TimeUnit.SECONDS);
                    return (NanoHTTPD.Response) objectRef.element;
                }
                this.productAcquisitionService.downloadProduct(intValue, AcquisitionReason.WEBSERVER, (ProductAcquisitionDelegate) null, new MediaRestController$startDownload$2(objectRef, intValue, iHTTPSession, countDownLatch));
                countDownLatch.await(10, TimeUnit.SECONDS);
                return (NanoHTTPD.Response) objectRef.element;
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("[WEBSERVER]: Unable to initiate download " + e.getLocalizedMessage(), new Object[0]);
                return ResponseFactory.Companion.internalServerError();
            }
        } else {
            ResponseFactory.Companion companion = ResponseFactory.Companion;
            String uri2 = iHTTPSession.getUri();
            Intrinsics.checkNotNullExpressionValue(uri2, "session.uri");
            return companion.badRequestResponse("Invalid format of id", uri2);
        }
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response deleteOfflineContent(NanoHTTPD.IHTTPSession iHTTPSession) {
        String uri = iHTTPSession.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "session.uri");
        Integer extractProductPathParam = extractProductPathParam(uri);
        if (extractProductPathParam != null) {
            int intValue = extractProductPathParam.intValue();
            try {
                if (this.availabilityService.downloadedProducts().isEmpty()) {
                    ResponseFactory.Companion companion = ResponseFactory.Companion;
                    String str = "Product [" + intValue + "] not found";
                    String uri2 = iHTTPSession.getUri();
                    Intrinsics.checkNotNullExpressionValue(uri2, "session.uri");
                    return companion.notFoundResponse(str, uri2);
                } else if (this.availabilityService.removeProduct(intValue)) {
                    return ResponseFactory.Companion.noContentResponse();
                } else {
                    ResponseFactory.Companion companion2 = ResponseFactory.Companion;
                    String str2 = "Product [" + intValue + "] not found";
                    String uri3 = iHTTPSession.getUri();
                    Intrinsics.checkNotNullExpressionValue(uri3, "session.uri");
                    return companion2.notFoundResponse(str2, uri3);
                }
            } catch (Exception e) {
                Timber.Forest.mo50217e("[WEBSERVER]: Unable to remove product [" + intValue + "] " + e.getLocalizedMessage(), new Object[0]);
                return ResponseFactory.Companion.internalServerError();
            }
        } else {
            ResponseFactory.Companion companion3 = ResponseFactory.Companion;
            String uri4 = iHTTPSession.getUri();
            Intrinsics.checkNotNullExpressionValue(uri4, "session.uri");
            return companion3.badRequestResponse("Invalid format of id", uri4);
        }
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response getCurrentProduct(NanoHTTPD.IHTTPSession iHTTPSession) {
        PlaybackDto playbackDto;
        PlaybackDto playbackDto2 = this.audioPlayerService.getPlaybackDto();
        if (playbackDto2 != null) {
            playbackDto = playbackDto2.getTrackNumber() < 1 ? PlaybackDto.copy$default(playbackDto2, 0, 1, 0, (String) null, (String) null, (String) null, (Boolean) null, 125, (Object) null) : PlaybackDto.copy$default(playbackDto2, 0, playbackDto2.getTrackNumber() + 1, 0, (String) null, (String) null, (String) null, (Boolean) null, 125, (Object) null);
        } else {
            playbackDto = null;
        }
        if (playbackDto != null) {
            return ResponseFactory.Companion.currentPlaybackResponse(playbackDto);
        }
        return ResponseFactory.Companion.noContentResponse();
    }

    /* access modifiers changed from: private */
    public final NanoHTTPD.Response reloadMainContent(NanoHTTPD.IHTTPSession iHTTPSession) {
        try {
            for (Map.Entry<Object, Function0<Unit>> value : this.contentUpdateSubscribers.entrySet()) {
                ((Function0) value.getValue()).invoke();
            }
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("[WEBSERVER]: Unable to invoke action " + e.getLocalizedMessage(), new Object[0]);
        }
        return ResponseFactory.Companion.okResponse();
    }

    private final Integer extractProductPathParam(String str) {
        Integer intOrNull = StringsKt.toIntOrNull(StringsKt.substringAfterLast$default(str, DownloadsManager.FOLDERS_SEPARATOR, (String) null, 2, (Object) null));
        if (intOrNull == null || intOrNull.intValue() <= 0) {
            return null;
        }
        return intOrNull;
    }
}
