package media.tiger.tigerbox.infrastructure.p015di;

import media.tiger.tigerbox.infrastructure.functional.DownloadProgressUpdate;
import okhttp3.Interceptor;
import okhttp3.Response;

/* renamed from: media.tiger.tigerbox.infrastructure.di.HttpClientModuleKt$$ExternalSyntheticLambda0 */
public final /* synthetic */ class HttpClientModuleKt$$ExternalSyntheticLambda0 implements Interceptor {
    public final /* synthetic */ DownloadProgressUpdate f$0;

    public /* synthetic */ HttpClientModuleKt$$ExternalSyntheticLambda0(DownloadProgressUpdate downloadProgressUpdate) {
        this.f$0 = downloadProgressUpdate;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return HttpClientModuleKt.m2333provideDownloadProgressInterceptor$lambda1(this.f$0, chain);
    }
}
