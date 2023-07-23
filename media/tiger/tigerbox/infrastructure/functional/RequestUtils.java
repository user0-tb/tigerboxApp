package media.tiger.tigerbox.infrastructure.functional;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.network.ApiResponse;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;

@Metadata(mo33736d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jg\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\f\u001a\u0002H\u00062\b\b\u0002\u0010\r\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J_\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\t2\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u0002H\u00060\u00132\u0006\u0010\f\u001a\u0002H\u00062\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/functional/RequestUtils;", "", "()V", "requestMapper", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "R", "T", "response", "Lmedia/tiger/tigerbox/data/network/ApiResponse;", "transform", "Lkotlin/Function1;", "default", "errorResponse", "onError", "Lkotlin/Function0;", "", "(Lmedia/tiger/tigerbox/data/network/ApiResponse;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Lmedia/tiger/tigerbox/infrastructure/exception/Failure;Lkotlin/jvm/functions/Function0;)Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "requestMapperWithHeaderLink", "Lkotlin/Function2;", "", "(Lmedia/tiger/tigerbox/data/network/ApiResponse;Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lmedia/tiger/tigerbox/infrastructure/exception/Failure;)Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: RequestUtils.kt */
public final class RequestUtils {
    public static final RequestUtils INSTANCE = new RequestUtils();

    private RequestUtils() {
    }

    public static /* synthetic */ Either requestMapper$default(RequestUtils requestUtils, ApiResponse apiResponse, Function1 function1, Object obj, Failure failure, Function0 function0, int i, Object obj2) {
        if ((i & 8) != 0) {
            failure = Failure.DefaultError.INSTANCE;
        }
        Failure failure2 = failure;
        if ((i & 16) != 0) {
            function0 = RequestUtils$requestMapper$1.INSTANCE;
        }
        return requestUtils.requestMapper(apiResponse, function1, obj, failure2, function0);
    }

    public final <T, R> Either<Failure, R> requestMapper(ApiResponse<? extends T> apiResponse, Function1<? super T, ? extends R> function1, R r, Failure failure, Function0<Unit> function0) {
        boolean z;
        Either.Left left;
        Intrinsics.checkNotNullParameter(apiResponse, "response");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Intrinsics.checkNotNullParameter(failure, "errorResponse");
        Intrinsics.checkNotNullParameter(function0, "onError");
        try {
            if (apiResponse instanceof ApiResponse.ApiSuccessResponse) {
                R invoke = function1.invoke(((ApiResponse.ApiSuccessResponse) apiResponse).getBody());
                if (invoke != null) {
                    r = invoke;
                }
                return new Either.Right<>(r);
            } else if (apiResponse instanceof ApiResponse.ApiSuccessEmptyResponse) {
                function0.invoke();
                failure.setErrorMessage("ApiSuccessEmptyResponse");
                return new Either.Left<>(Failure.EmptyError.INSTANCE);
            } else if (apiResponse instanceof ApiResponse.ApiErrorResponse) {
                function0.invoke();
                failure.setErrorCode(((ApiResponse.ApiErrorResponse) apiResponse).getErrorCode());
                failure.setErrorMessage(((ApiResponse.ApiErrorResponse) apiResponse).getErrorMessage());
                return new Either.Left<>(failure);
            } else if (apiResponse instanceof ApiResponse.ApiNetworkErrorResponse) {
                function0.invoke();
                failure.setException(((ApiResponse.ApiNetworkErrorResponse) apiResponse).getException());
                IOException exception = ((ApiResponse.ApiNetworkErrorResponse) apiResponse).getException();
                boolean z2 = true;
                if (exception instanceof UnknownHostException) {
                    z = true;
                } else {
                    z = exception instanceof SocketTimeoutException;
                }
                if (!z) {
                    z2 = exception instanceof ConnectException;
                }
                if (z2) {
                    Failure.NetworkConnection networkConnection = Failure.NetworkConnection.INSTANCE;
                    networkConnection.setException(((ApiResponse.ApiNetworkErrorResponse) apiResponse).getException());
                    left = new Either.Left(networkConnection);
                } else {
                    left = new Either.Left(failure);
                }
                return left;
            } else if (apiResponse instanceof ApiResponse.ApiUnknownErrorResponse) {
                function0.invoke();
                failure.setErrorMessage("ApiUnknownErrorResponse");
                failure.setException(((ApiResponse.ApiUnknownErrorResponse) apiResponse).getException());
                return new Either.Left<>(failure);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } catch (Throwable th) {
            function0.invoke();
            Failure.RequestMappingError requestMappingError = Failure.RequestMappingError.INSTANCE;
            requestMappingError.setException(th);
            return new Either.Left<>(requestMappingError);
        }
    }

    public static /* synthetic */ Either requestMapperWithHeaderLink$default(RequestUtils requestUtils, ApiResponse apiResponse, Function2 function2, Object obj, Failure failure, int i, Object obj2) {
        if ((i & 8) != 0) {
            failure = Failure.DefaultError.INSTANCE;
        }
        return requestUtils.requestMapperWithHeaderLink(apiResponse, function2, obj, failure);
    }

    public final <T, R> Either<Failure, R> requestMapperWithHeaderLink(ApiResponse<? extends T> apiResponse, Function2<? super T, ? super String, ? extends R> function2, R r, Failure failure) {
        boolean z;
        Either.Left left;
        Intrinsics.checkNotNullParameter(apiResponse, "response");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Intrinsics.checkNotNullParameter(failure, "errorResponse");
        try {
            if (apiResponse instanceof ApiResponse.ApiSuccessResponse) {
                R invoke = function2.invoke(((ApiResponse.ApiSuccessResponse) apiResponse).getBody(), ((ApiResponse.ApiSuccessResponse) apiResponse).getLink());
                if (invoke != null) {
                    r = invoke;
                }
                return new Either.Right<>(r);
            } else if (apiResponse instanceof ApiResponse.ApiSuccessEmptyResponse) {
                failure.setErrorMessage("ApiSuccessEmptyResponse");
                return new Either.Left<>(Failure.EmptyError.INSTANCE);
            } else if (apiResponse instanceof ApiResponse.ApiErrorResponse) {
                failure.setErrorCode(((ApiResponse.ApiErrorResponse) apiResponse).getErrorCode());
                failure.setErrorMessage(((ApiResponse.ApiErrorResponse) apiResponse).getErrorMessage());
                return new Either.Left<>(failure);
            } else if (apiResponse instanceof ApiResponse.ApiNetworkErrorResponse) {
                failure.setException(((ApiResponse.ApiNetworkErrorResponse) apiResponse).getException());
                IOException exception = ((ApiResponse.ApiNetworkErrorResponse) apiResponse).getException();
                boolean z2 = true;
                if (exception instanceof UnknownHostException) {
                    z = true;
                } else {
                    z = exception instanceof SocketTimeoutException;
                }
                if (!z) {
                    z2 = exception instanceof ConnectException;
                }
                if (z2) {
                    Failure.NetworkConnection networkConnection = Failure.NetworkConnection.INSTANCE;
                    networkConnection.setException(((ApiResponse.ApiNetworkErrorResponse) apiResponse).getException());
                    left = new Either.Left(networkConnection);
                } else {
                    left = new Either.Left(failure);
                }
                return left;
            } else if (apiResponse instanceof ApiResponse.ApiUnknownErrorResponse) {
                failure.setErrorMessage("ApiUnknownErrorResponse");
                failure.setException(((ApiResponse.ApiUnknownErrorResponse) apiResponse).getException());
                return new Either.Left<>(failure);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } catch (Throwable th) {
            Failure.RequestMappingError requestMappingError = Failure.RequestMappingError.INSTANCE;
            requestMappingError.setException(th);
            return new Either.Left<>(requestMappingError);
        }
    }
}
