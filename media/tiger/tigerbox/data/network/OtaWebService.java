package media.tiger.tigerbox.data.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\t\u001a\u00020\nH'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/OtaWebService;", "", "checkForUpdate", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "Lmedia/tiger/tigerbox/model/dto/ReleaseInformation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "fileUrl", "", "getReleaseRaw", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: OtaWebService.kt */
public interface OtaWebService {
    @GET("/releases.json")
    Object checkForUpdate(Continuation<? super ApiResponse<ReleaseInformation>> continuation);

    @Streaming
    @GET
    Call<ResponseBody> downloadFile(@Url String str);

    @GET("/releases.json")
    Call<ResponseBody> getReleaseRaw();
}
