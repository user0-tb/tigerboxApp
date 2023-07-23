package media.tiger.tigerbox.data.network;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.model.domain.LastUsedMulticardProduct;
import media.tiger.tigerbox.model.domain.TigerTicketOrder;
import media.tiger.tigerbox.model.domain.TigerTicketPurchase;
import media.tiger.tigerbox.model.domain.TigerTicketValidationResponse;
import media.tiger.tigerbox.model.dto.AccessTokenDto;
import media.tiger.tigerbox.model.dto.Acquisition;
import media.tiger.tigerbox.model.dto.AcquisitionBody;
import media.tiger.tigerbox.model.dto.AssetProduct;
import media.tiger.tigerbox.model.dto.DeviceInformation;
import media.tiger.tigerbox.model.dto.MainContentItem;
import media.tiger.tigerbox.model.dto.PlayState;
import media.tiger.tigerbox.model.dto.PlaybackTrackingEvent;
import media.tiger.tigerbox.model.dto.ProductDetailsDto;
import media.tiger.tigerbox.model.dto.ProductList;
import media.tiger.tigerbox.model.dto.ProductPlayStates;
import media.tiger.tigerbox.model.dto.ReportInformationDto;
import media.tiger.tigerbox.model.dto.SubscriptionDto;
import media.tiger.tigerbox.model.dto.TigerBoxAccountProfiles;
import media.tiger.tigerbox.model.dto.TigerBoxUser;
import media.tiger.tigerbox.model.dto.TigerCardValidState;
import media.tiger.tigerbox.model.dto.TigerTicketAssignedProduct;
import media.tiger.tigerbox.usecase.ReportInformationRequestBody;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Tag;
import retrofit2.http.Url;

@Metadata(mo33736d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 b2\u00020\u0001:\u0001bJ+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J)\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000f0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J'\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u000f0\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J-\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u00062\b\b\u0001\u0010\u0012\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ;\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u000f0\u00032\b\b\u0001\u0010$\u001a\u00020\u00062\b\b\u0001\u0010%\u001a\u00020\u00062\b\b\u0001\u0010&\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010'J!\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u00032\b\b\u0001\u0010$\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J?\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u00032\b\b\u0001\u0010.\u001a\u00020\u00062\b\b\u0001\u0010/\u001a\u00020\u00062\b\b\u0003\u00100\u001a\u00020\u00062\b\b\u0003\u00101\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u00102JI\u00103\u001a\b\u0012\u0004\u0012\u00020-0\u00032\b\b\u0001\u0010.\u001a\u00020\u00062\b\b\u0001\u00104\u001a\u00020\u00062\b\b\u0001\u00105\u001a\u00020\u00062\b\b\u0001\u00100\u001a\u00020\u00062\b\b\u0001\u00106\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u00107J5\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00032\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u0010%\u001a\u00020\u00062\b\b\u0001\u0010\u001f\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010'J!\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00032\b\b\u0001\u0010<\u001a\u00020=H§@ø\u0001\u0000¢\u0006\u0002\u0010>J!\u0010?\u001a\b\u0012\u0004\u0012\u00020;0\u00032\b\b\u0001\u0010@\u001a\u00020AH§@ø\u0001\u0000¢\u0006\u0002\u0010BJ!\u0010C\u001a\b\u0012\u0004\u0012\u00020D0\u00032\b\b\u0001\u0010&\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u00032\b\b\u0001\u0010G\u001a\u00020HH§@ø\u0001\u0000¢\u0006\u0002\u0010IJ+\u0010J\u001a\b\u0012\u0004\u0012\u0002090\u00032\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u0010%\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ!\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u00032\b\b\u0001\u0010K\u001a\u00020MH§@ø\u0001\u0000¢\u0006\u0002\u0010NJ+\u0010O\u001a\b\u0012\u0004\u0012\u00020;0\u00032\b\b\u0001\u0010P\u001a\u00020\u00062\b\b\u0001\u0010Q\u001a\u00020RH§@ø\u0001\u0000¢\u0006\u0002\u0010SJ+\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010U\u001a\u00020VH§@ø\u0001\u0000¢\u0006\u0002\u0010WJ!\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0017JI\u0010Z\u001a\b\u0012\u0004\u0012\u00020;0\u00032\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\b2\u000e\b\u0001\u0010[\u001a\b\u0012\u0004\u0012\u00020\\0\u000f2\b\b\u0003\u0010]\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010^J+\u0010_\u001a\b\u0012\u0004\u0012\u00020`0\u00032\b\b\u0001\u0010&\u001a\u00020\u00062\b\b\u0001\u0010a\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006c"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "", "assignCurrentProfileToAccount", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "url", "", "params", "Lokhttp3/RequestBody;", "(Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assignDeviceToAccount", "deviceIdentifier", "deviceCredential", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAcquisitions", "", "Lmedia/tiger/tigerbox/model/dto/Acquisition;", "account_id", "productId", "checkConnection", "Lokhttp3/ResponseBody;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deviceSearchWithIdentifier", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountSubscriptions", "Lmedia/tiger/tigerbox/model/dto/SubscriptionDto;", "getHlsKey", "getLoggedUserInfo", "Lmedia/tiger/tigerbox/model/dto/TigerBoxUser;", "getMainContent", "Lmedia/tiger/tigerbox/model/dto/MainContentItem;", "userId", "getPlayStates", "Lmedia/tiger/tigerbox/model/dto/ProductPlayStates;", "getProductAssets", "Lmedia/tiger/tigerbox/model/dto/AssetProduct;", "product_id", "uid", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductDetails", "Lmedia/tiger/tigerbox/model/dto/ProductDetailsDto;", "getProfilesInfo", "Lmedia/tiger/tigerbox/model/dto/TigerBoxAccountProfiles;", "getRefreshToken", "Lmedia/tiger/tigerbox/model/dto/AccessTokenDto;", "authHeader", "refreshToken", "grantType", "scope", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "username", "password", "deviceId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getValidTigerCard", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState;", "postPlayState", "", "productPlayState", "Lmedia/tiger/tigerbox/model/dto/PlayState;", "(Lmedia/tiger/tigerbox/model/dto/PlayState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postTrackingEvent", "event", "Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;", "(Lmedia/tiger/tigerbox/model/dto/PlaybackTrackingEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "previewTicketOrder", "Lmedia/tiger/tigerbox/model/dto/TigerTicketAssignedProduct;", "purchaseTicket", "Lmedia/tiger/tigerbox/model/domain/TigerTicketPurchase;", "order", "Lmedia/tiger/tigerbox/model/domain/TigerTicketOrder;", "(Lmedia/tiger/tigerbox/model/domain/TigerTicketOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reassignWildcard", "reportInformation", "Lmedia/tiger/tigerbox/model/dto/ReportInformationDto;", "Lmedia/tiger/tigerbox/usecase/ReportInformationRequestBody;", "(Lmedia/tiger/tigerbox/usecase/ReportInformationRequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportLastUsedCardProduct", "reportUrl", "cart", "Lmedia/tiger/tigerbox/model/domain/LastUsedMulticardProduct;", "(Ljava/lang/String;Lmedia/tiger/tigerbox/model/domain/LastUsedMulticardProduct;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAcquisition", "acquisitionBody", "Lmedia/tiger/tigerbox/model/dto/AcquisitionBody;", "(Ljava/lang/String;Lmedia/tiger/tigerbox/model/dto/AcquisitionBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendCompleteURLRequest", "Lmedia/tiger/tigerbox/model/dto/ProductList;", "uploadLogFiles", "logfiles", "Lokhttp3/MultipartBody$Part;", "value", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateTicket", "Lmedia/tiger/tigerbox/model/domain/TigerTicketValidationResponse;", "pin", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxWebService.kt */
public interface TigerBoxWebService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @PATCH
    @Headers({"Accept: application/json"})
    Object assignCurrentProfileToAccount(@Url String str, @Body RequestBody requestBody, Continuation<? super ApiResponse<DeviceInformation>> continuation);

    @POST("/api/devices/connect-account")
    Object assignDeviceToAccount(@Query("device_identifier") String str, @Query("device_credential") String str2, Continuation<? super ApiResponse<DeviceInformation>> continuation);

    @GET("/api/accounts/{account_id}/acquisitions")
    @Headers({"Accept: application/vnd.tigerbooks.v1+json"})
    Object checkAcquisitions(@Path(encoded = true, value = "account_id") String str, @Query("productId") String str2, Continuation<? super ApiResponse<? extends List<Acquisition>>> continuation);

    @GET("/")
    Object checkConnection(Continuation<? super ApiResponse<? extends ResponseBody>> continuation);

    @GET("api/devices/search/withDeviceIdentifier")
    Object deviceSearchWithIdentifier(@Query("deviceIdentifier") String str, Continuation<? super ApiResponse<DeviceInformation>> continuation);

    @GET("/api/accounts/{account_id}/subscriptions")
    Object getAccountSubscriptions(@Path(encoded = true, value = "account_id") String str, Continuation<? super ApiResponse<? extends List<SubscriptionDto>>> continuation);

    @GET
    @Headers({"Accept: application/octet-stream"})
    Object getHlsKey(@Url String str, Continuation<? super ResponseBody> continuation);

    @GET("/api/me")
    @Headers({"Accept: application/json"})
    Object getLoggedUserInfo(Continuation<? super ApiResponse<TigerBoxUser>> continuation);

    @GET("/api/shopLayouts/?view=shop")
    Object getMainContent(@Query("userId") String str, Continuation<? super ApiResponse<? extends List<MainContentItem>>> continuation);

    @GET("/api/playstates/")
    @Headers({"Accept: application/vnd.tigerbooks.v1+json"})
    Object getPlayStates(@Query("userId") String str, @Query("productId") String str2, Continuation<? super ApiResponse<ProductPlayStates>> continuation);

    @GET("/api/products/{product_id}/assets?view=withContentLink")
    @Headers({"Accept: application/vnd.tigerbooks.v1+json"})
    Object getProductAssets(@Path(encoded = true, value = "product_id") String str, @Query("uid") String str2, @Query("code") String str3, Continuation<? super ApiResponse<? extends List<AssetProduct>>> continuation);

    @GET("/api/products/{product_id}")
    @Headers({"Accept: application/vnd.tigerbooks.v1+json"})
    Object getProductDetails(@Path(encoded = true, value = "product_id") String str, Continuation<? super ApiResponse<ProductDetailsDto>> continuation);

    @GET("/api/accounts/{account_id}/profiles")
    @Headers({"Accept: application/hal+json"})
    Object getProfilesInfo(@Path(encoded = true, value = "account_id") String str, Continuation<? super ApiResponse<TigerBoxAccountProfiles>> continuation);

    @FormUrlEncoded
    @POST("/oauth/token")
    Object getRefreshToken(@Header("Authorization") String str, @Field("refresh_token") String str2, @Field("grant_type") String str3, @Field("scope") String str4, Continuation<? super ApiResponse<AccessTokenDto>> continuation);

    @FormUrlEncoded
    @POST("/oauth/token")
    Object getToken(@Header("Authorization") String str, @Field("username") String str2, @Field("password") String str3, @Field("grant_type") String str4, @Field("device_id") String str5, Continuation<? super ApiResponse<AccessTokenDto>> continuation);

    @GET("/api/cards/validate")
    @Headers({"Accept: application/hal+json"})
    Object getValidTigerCard(@Query("code") String str, @Query("uid") String str2, @Query("userId") String str3, Continuation<? super ApiResponse<TigerCardValidState>> continuation);

    @POST("/api/playstates/")
    @Headers({"Accept: application/vnd.tigerbooks.v1+json"})
    Object postPlayState(@Body PlayState playState, Continuation<? super ApiResponse<Unit>> continuation);

    @POST("/api/tracks/")
    @Headers({"Accept: application/json"})
    Object postTrackingEvent(@Body PlaybackTrackingEvent playbackTrackingEvent, Continuation<? super ApiResponse<Unit>> continuation);

    @GET("/api/purchases/tickets/preview")
    @Headers({"Accept: application/vnd.tigerbooks.v1+json"})
    Object previewTicketOrder(@Query("code") String str, Continuation<? super ApiResponse<TigerTicketAssignedProduct>> continuation);

    @POST("/api/purchases/tickets/submit-order")
    Object purchaseTicket(@Body TigerTicketOrder tigerTicketOrder, Continuation<? super ApiResponse<TigerTicketPurchase>> continuation);

    @POST("/api/cards/assign-account-with-code-and-uid")
    Object reassignWildcard(@Query("code") String str, @Query("uid") String str2, Continuation<? super ApiResponse<TigerCardValidState>> continuation);

    @POST("/api/devices/report-information")
    Object reportInformation(@Body ReportInformationRequestBody reportInformationRequestBody, Continuation<? super ApiResponse<ReportInformationDto>> continuation);

    @POST
    @Headers({"Accept: application/json"})
    Object reportLastUsedCardProduct(@Url String str, @Body LastUsedMulticardProduct lastUsedMulticardProduct, Continuation<? super ApiResponse<Unit>> continuation);

    @POST("/api/accounts/{account_id}/acquisitions")
    Object requestAcquisition(@Path(encoded = true, value = "account_id") String str, @Body AcquisitionBody acquisitionBody, Continuation<? super ApiResponse<Acquisition>> continuation);

    @GET
    @Headers({"Accept: application/vnd.tigerbooks.v1+json"})
    Object sendCompleteURLRequest(@Url String str, Continuation<? super ApiResponse<ProductList>> continuation);

    @POST("/api/devices/upload-crashlogs")
    @Multipart
    Object uploadLogFiles(@Part("deviceIdentifier") RequestBody requestBody, @Part("deviceCredential") RequestBody requestBody2, @Part List<MultipartBody.Part> list, @Tag String str, Continuation<? super ApiResponse<Unit>> continuation);

    @GET("/api/purchases/tickets/validate")
    @Headers({"Accept: application/vnd.tigerbooks.v1+json"})
    Object validateTicket(@Query("code") String str, @Query("pin") String str2, Continuation<? super ApiResponse<TigerTicketValidationResponse>> continuation);

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/TigerBoxWebService$Companion;", "", "()V", "REFRESH_DEFAULT_GRANT_TYPE", "", "REFRESH_DEFAULT_SCOPE", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerBoxWebService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String REFRESH_DEFAULT_GRANT_TYPE = "refresh_token";
        private static final String REFRESH_DEFAULT_SCOPE = "read write";

        private Companion() {
        }
    }

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerBoxWebService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getRefreshToken$default(TigerBoxWebService tigerBoxWebService, String str, String str2, String str3, String str4, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = "refresh_token";
                }
                String str5 = str3;
                if ((i & 8) != 0) {
                    str4 = "read write";
                }
                return tigerBoxWebService.getRefreshToken(str, str2, str5, str4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRefreshToken");
        }

        public static /* synthetic */ Object uploadLogFiles$default(TigerBoxWebService tigerBoxWebService, RequestBody requestBody, RequestBody requestBody2, List list, String str, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    str = AuthenticationInterceptor.NO_AUTHORIZATION_TAG;
                }
                return tigerBoxWebService.uploadLogFiles(requestBody, requestBody2, list, str, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadLogFiles");
        }
    }
}
