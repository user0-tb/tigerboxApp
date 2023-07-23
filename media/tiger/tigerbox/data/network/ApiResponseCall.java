package media.tiger.tigerbox.data.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(mo33736d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00018\u00008\u00000\u0000H\u0016J\u001c\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\rH\u0016J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/ApiResponseCall;", "T", "", "Lretrofit2/Call;", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "delegate", "(Lretrofit2/Call;)V", "cancel", "", "clone", "kotlin.jvm.PlatformType", "enqueue", "callback", "Lretrofit2/Callback;", "execute", "Lretrofit2/Response;", "isCanceled", "", "isExecuted", "request", "Lokhttp3/Request;", "timeout", "Lokio/Timeout;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ApiResponseAdapter.kt */
public final class ApiResponseCall<T> implements Call<ApiResponse<? extends T>> {
    private final Call<T> delegate;

    public ApiResponseCall(Call<T> call) {
        Intrinsics.checkNotNullParameter(call, "delegate");
        this.delegate = call;
    }

    public void enqueue(Callback<ApiResponse<T>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.delegate.enqueue(new ApiResponseCall$enqueue$1(callback, this));
    }

    public boolean isExecuted() {
        return this.delegate.isExecuted();
    }

    public ApiResponseCall<T> clone() {
        Call<T> clone = this.delegate.clone();
        Intrinsics.checkNotNullExpressionValue(clone, "delegate.clone()");
        return new ApiResponseCall<>(clone);
    }

    public boolean isCanceled() {
        return this.delegate.isCanceled();
    }

    public void cancel() {
        this.delegate.cancel();
    }

    public Response<ApiResponse<T>> execute() {
        throw new UnsupportedOperationException("ApiResponseCall doesn't support execute");
    }

    public Request request() {
        Request request = this.delegate.request();
        Intrinsics.checkNotNullExpressionValue(request, "delegate.request()");
        return request;
    }

    public Timeout timeout() {
        Timeout timeout = this.delegate.timeout();
        Intrinsics.checkNotNullExpressionValue(timeout, "delegate.timeout()");
        return timeout;
    }
}
