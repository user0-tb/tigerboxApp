package media.tiger.tigerbox.data.network;

import kotlin.Metadata;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Tag;
import retrofit2.http.Url;

@Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/DownloadsWebService;", "", "downloadFileWithUrl", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "fileUrl", "", "value", "downloadPrivateFileWithUrl", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadsWebService.kt */
public interface DownloadsWebService {
    @Streaming
    @GET
    Call<ResponseBody> downloadFileWithUrl(@Url String str, @Tag String str2);

    @Streaming
    @GET
    Call<ResponseBody> downloadPrivateFileWithUrl(@Url String str);

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DownloadsWebService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Call downloadFileWithUrl$default(DownloadsWebService downloadsWebService, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = AuthenticationInterceptor.NO_AUTHORIZATION_TAG;
                }
                return downloadsWebService.downloadFileWithUrl(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFileWithUrl");
        }
    }
}
