package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\f\rJ0\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH&¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler;", "", "invoke", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result;", "createCall", "Lkotlin/Function0;", "Lretrofit2/Call;", "Lokhttp3/ResponseBody;", "logger", "Lkotlin/Function1;", "", "", "FailReason", "Result", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler */
/* compiled from: LargeDownloadHandler.kt */
public interface LargeDownloadHandler {

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$FailReason;", "", "(Ljava/lang/String;I)V", "DOWNLOAD_UNSUCCESSFUL", "FILE_NOT_FOUND", "TIMEOUT", "UNKNOWN", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$FailReason */
    /* compiled from: LargeDownloadHandler.kt */
    public enum FailReason {
        DOWNLOAD_UNSUCCESSFUL,
        FILE_NOT_FOUND,
        TIMEOUT,
        UNKNOWN
    }

    Result invoke(Function0<? extends Call<ResponseBody>> function0, Function1<? super String, Unit> function1);

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result;", "", "()V", "Complete", "Failure", "Success", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result$Failure;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result$Success;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result$Complete;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result */
    /* compiled from: LargeDownloadHandler.kt */
    public static abstract class Result {
        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result$Failure;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result;", "reason", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$FailReason;", "(Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$FailReason;)V", "getReason", "()Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$FailReason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result$Failure */
        /* compiled from: LargeDownloadHandler.kt */
        public static final class Failure extends Result {
            private final FailReason reason;

            public static /* synthetic */ Failure copy$default(Failure failure, FailReason failReason, int i, Object obj) {
                if ((i & 1) != 0) {
                    failReason = failure.reason;
                }
                return failure.copy(failReason);
            }

            public final FailReason component1() {
                return this.reason;
            }

            public final Failure copy(FailReason failReason) {
                Intrinsics.checkNotNullParameter(failReason, "reason");
                return new Failure(failReason);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Failure) && this.reason == ((Failure) obj).reason;
            }

            public int hashCode() {
                return this.reason.hashCode();
            }

            public String toString() {
                return "Failure(reason=" + this.reason + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Failure(FailReason failReason) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(failReason, "reason");
                this.reason = failReason;
            }

            public final FailReason getReason() {
                return this.reason;
            }
        }

        private Result() {
        }

        @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result$Success;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result;", "response", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "(Lretrofit2/Response;)V", "getResponse", "()Lretrofit2/Response;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result$Success */
        /* compiled from: LargeDownloadHandler.kt */
        public static final class Success extends Result {
            private final Response<ResponseBody> response;

            public static /* synthetic */ Success copy$default(Success success, Response<ResponseBody> response2, int i, Object obj) {
                if ((i & 1) != 0) {
                    response2 = success.response;
                }
                return success.copy(response2);
            }

            public final Response<ResponseBody> component1() {
                return this.response;
            }

            public final Success copy(Response<ResponseBody> response2) {
                Intrinsics.checkNotNullParameter(response2, "response");
                return new Success(response2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Success) && Intrinsics.areEqual((Object) this.response, (Object) ((Success) obj).response);
            }

            public int hashCode() {
                return this.response.hashCode();
            }

            public String toString() {
                return "Success(response=" + this.response + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(Response<ResponseBody> response2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(response2, "response");
                this.response = response2;
            }

            public final Response<ResponseBody> getResponse() {
                return this.response;
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result$Complete;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.LargeDownloadHandler$Result$Complete */
        /* compiled from: LargeDownloadHandler.kt */
        public static final class Complete extends Result {
            public static final Complete INSTANCE = new Complete();

            private Complete() {
                super((DefaultConstructorMarker) null);
            }
        }
    }
}
