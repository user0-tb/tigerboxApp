package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.ResponseBody;
import retrofit2.Call;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$downloadFirmware$response$1 */
/* compiled from: DownloadFirmware.kt */
final class DownloadFirmware$downloadFirmware$response$1 extends Lambda implements Function0<Call<ResponseBody>> {
    final /* synthetic */ String $url;
    final /* synthetic */ DownloadFirmware this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DownloadFirmware$downloadFirmware$response$1(DownloadFirmware downloadFirmware, String str) {
        super(0);
        this.this$0 = downloadFirmware;
        this.$url = str;
    }

    public final Call<ResponseBody> invoke() {
        return this.this$0.otaWebService.downloadFile(this.$url);
    }
}
