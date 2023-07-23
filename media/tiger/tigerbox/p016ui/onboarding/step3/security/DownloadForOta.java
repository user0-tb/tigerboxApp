package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(mo33736d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\u0002J1\u0010\u000b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0002J\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadForOta;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler;", "()V", "MAX_NUMBER_RETRIES", "", "attemptDownload", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result;", "createCall", "Lkotlin/Function0;", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "invoke", "logger", "Lkotlin/Function1;", "", "", "isSuccessful", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadForOta */
/* compiled from: DownloadForOta.kt */
public final class DownloadForOta implements LargeDownloadHandler {
    public static final DownloadForOta INSTANCE = new DownloadForOta();
    private static final int MAX_NUMBER_RETRIES = 3;

    private DownloadForOta() {
    }

    public LargeDownloadHandler.Result invoke(Function0<? extends Call<ResponseBody>> function0, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "createCall");
        Intrinsics.checkNotNullParameter(function1, "logger");
        LargeDownloadHandler.Result attemptDownload = attemptDownload(function0);
        int i = 2;
        while (!isSuccessful(attemptDownload) && i > 0) {
            if (attemptDownload instanceof LargeDownloadHandler.Result.Success) {
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                LargeDownloadHandler.Result.Success success = (LargeDownloadHandler.Result.Success) attemptDownload;
                sb.append(success.getResponse().code());
                sb.append("] [");
                sb.append(success.getResponse().message());
                sb.append("] [");
                Object errorBody = success.getResponse().errorBody();
                if (errorBody == null) {
                    errorBody = "No error body";
                }
                sb.append(errorBody);
                sb.append(']');
                function1.invoke(sb.toString());
            } else {
                function1.invoke("[Request timed out]");
            }
            i--;
            attemptDownload = attemptDownload(function0);
        }
        if (attemptDownload instanceof LargeDownloadHandler.Result.Failure) {
            return new LargeDownloadHandler.Result.Failure(((LargeDownloadHandler.Result.Failure) attemptDownload).getReason());
        }
        if (attemptDownload instanceof LargeDownloadHandler.Result.Complete) {
            return LargeDownloadHandler.Result.Complete.INSTANCE;
        }
        if (attemptDownload instanceof LargeDownloadHandler.Result.Success) {
            LargeDownloadHandler.Result.Success success2 = (LargeDownloadHandler.Result.Success) attemptDownload;
            if (!success2.getResponse().isSuccessful()) {
                return new LargeDownloadHandler.Result.Failure(LargeDownloadHandler.FailReason.DOWNLOAD_UNSUCCESSFUL);
            }
            if (success2.getResponse().body() == null) {
                return new LargeDownloadHandler.Result.Failure(LargeDownloadHandler.FailReason.FILE_NOT_FOUND);
            }
            return new LargeDownloadHandler.Result.Success(success2.getResponse());
        }
        throw new NoWhenBranchMatchedException();
    }

    private final LargeDownloadHandler.Result attemptDownload(Function0<? extends Call<ResponseBody>> function0) {
        try {
            Response execute = ((Call) function0.invoke()).execute();
            Intrinsics.checkNotNullExpressionValue(execute, "downloadFileCall.execute()");
            return new LargeDownloadHandler.Result.Success(execute);
        } catch (SocketTimeoutException unused) {
            return new LargeDownloadHandler.Result.Failure(LargeDownloadHandler.FailReason.TIMEOUT);
        } catch (Exception unused2) {
            return new LargeDownloadHandler.Result.Failure(LargeDownloadHandler.FailReason.UNKNOWN);
        }
    }

    private final boolean isSuccessful(LargeDownloadHandler.Result result) {
        boolean z;
        if (result instanceof LargeDownloadHandler.Result.Failure) {
            z = true;
        } else {
            z = result instanceof LargeDownloadHandler.Result.Complete;
        }
        if (!z) {
            if (result instanceof LargeDownloadHandler.Result.Success) {
                LargeDownloadHandler.Result.Success success = (LargeDownloadHandler.Result.Success) result;
                if (!success.getResponse().isSuccessful() || success.getResponse().body() == null) {
                    return false;
                }
                return true;
            }
            throw new NoWhenBranchMatchedException();
        }
        return false;
    }
}
