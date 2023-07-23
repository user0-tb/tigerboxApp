package media.tiger.tigerbox.data.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

@Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/ScalarTigerBoxWebService;", "", "requestCertificate", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "", "deviceCredential", "Lokhttp3/MultipartBody$Part;", "certificateSigningRequest", "(Lokhttp3/MultipartBody$Part;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ScalarTigerBoxWebService.kt */
public interface ScalarTigerBoxWebService {
    @POST("/api/devices/activate")
    @Multipart
    Object requestCertificate(@Part MultipartBody.Part part, @Part MultipartBody.Part part2, Continuation<? super ApiResponse<String>> continuation);
}
