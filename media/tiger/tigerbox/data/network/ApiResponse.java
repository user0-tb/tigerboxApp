package media.tiger.tigerbox.data.network;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Response;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0006\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/ApiResponse;", "T", "", "()V", "ApiErrorResponse", "ApiNetworkErrorResponse", "ApiSuccessEmptyResponse", "ApiSuccessResponse", "ApiUnknownErrorResponse", "Companion", "Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiSuccessResponse;", "Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiSuccessEmptyResponse;", "Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiErrorResponse;", "Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiNetworkErrorResponse;", "Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiUnknownErrorResponse;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ApiResponse.kt */
public abstract class ApiResponse<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ ApiResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ApiResponse() {
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\t¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/ApiResponse$Companion;", "", "()V", "create", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "T", "throwable", "", "response", "Lretrofit2/Response;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ApiResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> ApiResponse<T> create(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            if (th instanceof IOException) {
                return new ApiNetworkErrorResponse((IOException) th);
            }
            return new ApiUnknownErrorResponse(th);
        }

        public final <T> ApiResponse<T> create(Response<T> response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccessful()) {
                T body = response.body();
                String str = response.headers().get(HttpHeaders.LINK);
                if (body == null || response.code() == 204) {
                    return new ApiSuccessEmptyResponse<>();
                }
                return new ApiSuccessResponse<>(body, str);
            }
            int code = response.code();
            ResponseBody errorBody = response.errorBody();
            String string = errorBody != null ? errorBody.string() : null;
            CharSequence charSequence = string;
            if (charSequence == null || charSequence.length() == 0) {
                string = response.message();
            }
            if (string == null) {
                string = "Unknown error";
            }
            return new ApiErrorResponse<>(string, code);
        }
    }

    @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0019\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiSuccessResponse;", "T", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "body", "link", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getLink", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/String;)Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiSuccessResponse;", "equals", "", "other", "", "hashCode", "", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ApiResponse.kt */
    public static final class ApiSuccessResponse<T> extends ApiResponse<T> {
        private final T body;
        private final String link;

        public static /* synthetic */ ApiSuccessResponse copy$default(ApiSuccessResponse apiSuccessResponse, T t, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                t = apiSuccessResponse.body;
            }
            if ((i & 2) != 0) {
                str = apiSuccessResponse.link;
            }
            return apiSuccessResponse.copy(t, str);
        }

        public final T component1() {
            return this.body;
        }

        public final String component2() {
            return this.link;
        }

        public final ApiSuccessResponse<T> copy(T t, String str) {
            return new ApiSuccessResponse<>(t, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApiSuccessResponse)) {
                return false;
            }
            ApiSuccessResponse apiSuccessResponse = (ApiSuccessResponse) obj;
            return Intrinsics.areEqual((Object) this.body, (Object) apiSuccessResponse.body) && Intrinsics.areEqual((Object) this.link, (Object) apiSuccessResponse.link);
        }

        public int hashCode() {
            T t = this.body;
            int i = 0;
            int hashCode = (t == null ? 0 : t.hashCode()) * 31;
            String str = this.link;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "ApiSuccessResponse(body=" + this.body + ", link=" + this.link + ')';
        }

        public ApiSuccessResponse(T t, String str) {
            super((DefaultConstructorMarker) null);
            this.body = t;
            this.link = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ApiSuccessResponse(Object obj, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, (i & 2) != 0 ? "" : str);
        }

        public final T getBody() {
            return this.body;
        }

        public final String getLink() {
            return this.link;
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiSuccessEmptyResponse;", "T", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ApiResponse.kt */
    public static final class ApiSuccessEmptyResponse<T> extends ApiResponse<T> {
        public ApiSuccessEmptyResponse() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiErrorResponse;", "T", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "errorMessage", "", "errorCode", "", "(Ljava/lang/String;I)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ApiResponse.kt */
    public static final class ApiErrorResponse<T> extends ApiResponse<T> {
        private final int errorCode;
        private final String errorMessage;

        public static /* synthetic */ ApiErrorResponse copy$default(ApiErrorResponse apiErrorResponse, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = apiErrorResponse.errorMessage;
            }
            if ((i2 & 2) != 0) {
                i = apiErrorResponse.errorCode;
            }
            return apiErrorResponse.copy(str, i);
        }

        public final String component1() {
            return this.errorMessage;
        }

        public final int component2() {
            return this.errorCode;
        }

        public final ApiErrorResponse<T> copy(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            return new ApiErrorResponse<>(str, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApiErrorResponse)) {
                return false;
            }
            ApiErrorResponse apiErrorResponse = (ApiErrorResponse) obj;
            return Intrinsics.areEqual((Object) this.errorMessage, (Object) apiErrorResponse.errorMessage) && this.errorCode == apiErrorResponse.errorCode;
        }

        public int hashCode() {
            return (this.errorMessage.hashCode() * 31) + this.errorCode;
        }

        public String toString() {
            return "ApiErrorResponse(errorMessage=" + this.errorMessage + ", errorCode=" + this.errorCode + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ApiErrorResponse(String str, int i) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            this.errorMessage = str;
            this.errorCode = i;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiNetworkErrorResponse;", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "", "exception", "Ljava/io/IOException;", "(Ljava/io/IOException;)V", "getException", "()Ljava/io/IOException;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ApiResponse.kt */
    public static final class ApiNetworkErrorResponse extends ApiResponse {
        private final IOException exception;

        public static /* synthetic */ ApiNetworkErrorResponse copy$default(ApiNetworkErrorResponse apiNetworkErrorResponse, IOException iOException, int i, Object obj) {
            if ((i & 1) != 0) {
                iOException = apiNetworkErrorResponse.exception;
            }
            return apiNetworkErrorResponse.copy(iOException);
        }

        public final IOException component1() {
            return this.exception;
        }

        public final ApiNetworkErrorResponse copy(IOException iOException) {
            Intrinsics.checkNotNullParameter(iOException, "exception");
            return new ApiNetworkErrorResponse(iOException);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApiNetworkErrorResponse) && Intrinsics.areEqual((Object) this.exception, (Object) ((ApiNetworkErrorResponse) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "ApiNetworkErrorResponse(exception=" + this.exception + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ApiNetworkErrorResponse(IOException iOException) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(iOException, "exception");
            this.exception = iOException;
        }

        public final IOException getException() {
            return this.exception;
        }
    }

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/ApiResponse$ApiUnknownErrorResponse;", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "", "exception", "", "(Ljava/lang/Throwable;)V", "getException", "()Ljava/lang/Throwable;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ApiResponse.kt */
    public static final class ApiUnknownErrorResponse extends ApiResponse {
        private final Throwable exception;

        public static /* synthetic */ ApiUnknownErrorResponse copy$default(ApiUnknownErrorResponse apiUnknownErrorResponse, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                th = apiUnknownErrorResponse.exception;
            }
            return apiUnknownErrorResponse.copy(th);
        }

        public final Throwable component1() {
            return this.exception;
        }

        public final ApiUnknownErrorResponse copy(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "exception");
            return new ApiUnknownErrorResponse(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ApiUnknownErrorResponse) && Intrinsics.areEqual((Object) this.exception, (Object) ((ApiUnknownErrorResponse) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "ApiUnknownErrorResponse(exception=" + this.exception + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ApiUnknownErrorResponse(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "exception");
            this.exception = th;
        }

        public final Throwable getException() {
            return this.exception;
        }
    }
}
