package media.tiger.tigerbox.infrastructure.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0016\u0017\u0018\u0019\u001a\u001bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0001\u0006\u001c\u001d\u001e\u001f !¨\u0006\""}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "", "()V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "exception", "", "getException", "()Ljava/lang/Throwable;", "setException", "(Ljava/lang/Throwable;)V", "toString", "DefaultError", "EmptyError", "FeatureFailure", "NetworkConnection", "RequestMappingError", "ServerError", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$NetworkConnection;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$ServerError;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$EmptyError;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$DefaultError;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$RequestMappingError;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Failure.kt */
public abstract class Failure {
    private int errorCode;
    private String errorMessage;
    private Throwable exception;

    public /* synthetic */ Failure(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/Failure$NetworkConnection;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class NetworkConnection extends Failure {
        public static final NetworkConnection INSTANCE = new NetworkConnection();

        private NetworkConnection() {
            super((DefaultConstructorMarker) null);
        }
    }

    private Failure() {
        this.errorCode = -1;
        this.errorMessage = "";
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/Failure$ServerError;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class ServerError extends Failure {
        public static final ServerError INSTANCE = new ServerError();

        private ServerError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/Failure$EmptyError;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class EmptyError extends Failure {
        public static final EmptyError INSTANCE = new EmptyError();

        private EmptyError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/Failure$DefaultError;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class DefaultError extends Failure {
        public static final DefaultError INSTANCE = new DefaultError();

        private DefaultError() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/Failure$RequestMappingError;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class RequestMappingError extends Failure {
        public static final RequestMappingError INSTANCE = new RequestMappingError();

        private RequestMappingError() {
            super((DefaultConstructorMarker) null);
        }
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMessage = str;
    }

    public final Throwable getException() {
        return this.exception;
    }

    public final void setException(Throwable th) {
        this.exception = th;
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static abstract class FeatureFailure extends Failure {
        public FeatureFailure() {
            super((DefaultConstructorMarker) null);
        }
    }

    public String toString() {
        return "[\n\t" + getClass().getSimpleName() + "]\n\terrorCode: " + this.errorCode + "\n\terrorMessage: " + this.errorMessage + "\n\texception: " + this.exception;
    }
}
