package media.tiger.tigerbox.webserver.responses;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;
import media.tiger.tigerbox.webserver.dto.DeviceInfoDto;
import media.tiger.tigerbox.webserver.dto.OfflineProductDto;
import media.tiger.tigerbox.webserver.dto.PlaybackDto;
import media.tiger.tigerbox.webserver.responses.DefaultResponses;
import p011fi.iki.elonen.NanoHTTPD;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/responses/ResponseFactory;", "", "()V", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ResponseFactory.kt */
public final class ResponseFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    private ResponseFactory() {
    }

    @Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\u0013\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cJ\u0014\u0010\u001d\u001a\u00020\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0015J\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\""}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/responses/ResponseFactory$Companion;", "", "()V", "badRequestResponse", "Lfi/iki/elonen/NanoHTTPD$Response;", "message", "", "resource", "createdResponse", "currentPlaybackResponse", "playbackDto", "Lmedia/tiger/tigerbox/webserver/dto/PlaybackDto;", "getDeviceInfoResponse", "deviceInfoDto", "Lmedia/tiger/tigerbox/webserver/dto/DeviceInfoDto;", "internalServerError", "noContentResponse", "notAllowedResponse", "notFoundResponse", "offlineProductsResponse", "products", "", "Lmedia/tiger/tigerbox/webserver/dto/OfflineProductDto;", "okResponse", "okResponseWithBody", "body", "profilesActiveResponse", "profileId", "", "profilesResponse", "profiles", "Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "requestedMethodNotSupportedResponse", "unauthorizedResponse", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ResponseFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NanoHTTPD.Response okResponse() {
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, (String) null, (String) null);
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(N…se.Status.OK, null, null)");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response okResponseWithBody(String str) {
            Intrinsics.checkNotNullParameter(str, TtmlNode.TAG_BODY);
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, DefaultResponses.JSON_RESPONSE_TYPE, str);
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…       body\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response createdResponse() {
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.CREATED, (String) null, (String) null);
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(N…atus.CREATED, null, null)");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response noContentResponse() {
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NO_CONTENT, (String) null, (String) null);
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(N…s.NO_CONTENT, null, null)");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response profilesResponse(List<TigerBoxProfileDomain> list) {
            Intrinsics.checkNotNullParameter(list, "profiles");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.SuccessResponses.INSTANCE.profilesContentResponse(list));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…e(profiles)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response profilesActiveResponse(int i) {
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.SuccessResponses.INSTANCE.profilesActiveResponse(i));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…(profileId)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response offlineProductsResponse(List<OfflineProductDto> list) {
            Intrinsics.checkNotNullParameter(list, "products");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.SuccessResponses.INSTANCE.offlineAvailableContentResponse(list));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…e(products)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response currentPlaybackResponse(PlaybackDto playbackDto) {
            Intrinsics.checkNotNullParameter(playbackDto, "playbackDto");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.SuccessResponses.INSTANCE.currentPlaybackResponse(playbackDto));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…laybackDto)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response getDeviceInfoResponse(DeviceInfoDto deviceInfoDto) {
            Intrinsics.checkNotNullParameter(deviceInfoDto, "deviceInfoDto");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.SuccessResponses.INSTANCE.getDeviceInfoResponse(deviceInfoDto));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…iceInfoDto)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response badRequestResponse(String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.BAD_REQUEST, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ClientErrorResponses.INSTANCE.badRequestResponse(str));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…se(message)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response badRequestResponse(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(str2, "resource");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.BAD_REQUEST, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ClientErrorResponses.INSTANCE.badRequestResponse(str, str2));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…, resource)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response unauthorizedResponse(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(str2, "resource");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.UNAUTHORIZED, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ClientErrorResponses.INSTANCE.unauthorizedResponse(str, str2));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…, resource)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response notAllowedResponse(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(str2, "resource");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.FORBIDDEN, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ClientErrorResponses.INSTANCE.notAllowedResponse(str, str2));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…ponse(message, resource))");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response notFoundResponse() {
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_FOUND, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ClientErrorResponses.INSTANCE.notFoundDefaultResponse());
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…tResponse()\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response notFoundResponse(String str) {
            Intrinsics.checkNotNullParameter(str, "resource");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_FOUND, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ClientErrorResponses.INSTANCE.notFoundDefaultResponse(str));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…e(resource)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response notFoundResponse(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "message");
            Intrinsics.checkNotNullParameter(str2, "resource");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_FOUND, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ClientErrorResponses.INSTANCE.notFoundResponse(str, str2));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…, resource)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response requestedMethodNotSupportedResponse() {
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.METHOD_NOT_ALLOWED, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ClientErrorResponses.INSTANCE.methodNotAllowedResponse());
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…dResponse()\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response requestedMethodNotSupportedResponse(String str) {
            Intrinsics.checkNotNullParameter(str, "resource");
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.METHOD_NOT_ALLOWED, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ClientErrorResponses.INSTANCE.methodNotAllowedResponse(str));
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…e(resource)\n            )");
            return newFixedLengthResponse;
        }

        public final NanoHTTPD.Response internalServerError() {
            NanoHTTPD.Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.INTERNAL_ERROR, DefaultResponses.JSON_RESPONSE_TYPE, DefaultResponses.ServerErrorResponses.INSTANCE.internalServerErrorResponse());
            Intrinsics.checkNotNullExpressionValue(newFixedLengthResponse, "newFixedLengthResponse(\n…rResponse()\n            )");
            return newFixedLengthResponse;
        }
    }
}
