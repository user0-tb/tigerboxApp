package media.tiger.tigerbox.infrastructure.p015di;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.functional.DownloadProgressUpdate;
import media.tiger.tigerbox.infrastructure.functional.ProgressResponseBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(mo33736d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0002¢\u0006\u0002\u0010\u0007\u001a\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, mo33737d2 = {"createHttpClient", "Lokhttp3/OkHttpClient;", "allowHttpLog", "", "interceptors", "", "Lokhttp3/Interceptor;", "(Z[Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient;", "provideDownloadProgressInterceptor", "notifier", "Lmedia/tiger/tigerbox/infrastructure/functional/DownloadProgressUpdate;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.infrastructure.di.HttpClientModuleKt */
/* compiled from: HttpClientModule.kt */
public final class HttpClientModuleKt {
    /* access modifiers changed from: private */
    public static final OkHttpClient createHttpClient(boolean z, Interceptor... interceptorArr) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        for (Interceptor addInterceptor : interceptorArr) {
            builder.addInterceptor(addInterceptor);
        }
        builder.connectTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        if (z) {
            builder.addInterceptor(new HttpLoggingInterceptor((HttpLoggingInterceptor.Logger) null, 1, (DefaultConstructorMarker) null).setLevel(HttpLoggingInterceptor.Level.BASIC));
        }
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static final Interceptor provideDownloadProgressInterceptor(DownloadProgressUpdate downloadProgressUpdate) {
        return new HttpClientModuleKt$$ExternalSyntheticLambda0(downloadProgressUpdate);
    }

    /* access modifiers changed from: private */
    /* renamed from: provideDownloadProgressInterceptor$lambda-1  reason: not valid java name */
    public static final Response m2333provideDownloadProgressInterceptor$lambda1(DownloadProgressUpdate downloadProgressUpdate, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(downloadProgressUpdate, "$notifier");
        Intrinsics.checkNotNullParameter(chain, "it");
        Response proceed = chain.proceed(chain.request());
        Response.Builder newBuilder = proceed.newBuilder();
        ResponseBody body = proceed.body();
        Intrinsics.checkNotNull(body);
        return newBuilder.body(new ProgressResponseBody(body, downloadProgressUpdate)).build();
    }
}
