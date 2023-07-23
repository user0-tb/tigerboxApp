package media.tiger.tigerbox.data.network;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(mo33736d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, mo33737d2 = {"media/tiger/tigerbox/data/network/ApiResponseCall$enqueue$1", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "throwable", "", "onResponse", "response", "Lretrofit2/Response;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ApiResponseAdapter.kt */
public final class ApiResponseCall$enqueue$1 implements Callback<T> {
    final /* synthetic */ Callback<ApiResponse<T>> $callback;
    final /* synthetic */ ApiResponseCall<T> this$0;

    ApiResponseCall$enqueue$1(Callback<ApiResponse<T>> callback, ApiResponseCall<T> apiResponseCall) {
        this.$callback = callback;
        this.this$0 = apiResponseCall;
    }

    public void onResponse(Call<T> call, Response<T> response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        this.$callback.onResponse(this.this$0, Response.success(ApiResponse.Companion.create(response)));
    }

    public void onFailure(Call<T> call, Throwable th) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(th, "throwable");
        this.$callback.onResponse(this.this$0, Response.success(ApiResponse.Companion.create(th)));
    }
}
