package media.tiger.tigerbox.infrastructure.exception;

import kotlin.Metadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/LoginFailure;", "", "()V", "AssociationOfBoxAndAccountNotSuccessful", "BearerTokenNotSuccessful", "GetDeviceInfoFailure", "GetUserInfoFailure", "RequestAccountDataNotSuccessful", "SendProfileOfBoxNotSuccessful", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Failure.kt */
public final class LoginFailure {

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/LoginFailure$BearerTokenNotSuccessful;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class BearerTokenNotSuccessful extends Failure.FeatureFailure {
        public static final BearerTokenNotSuccessful INSTANCE = new BearerTokenNotSuccessful();

        private BearerTokenNotSuccessful() {
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/LoginFailure$RequestAccountDataNotSuccessful;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class RequestAccountDataNotSuccessful extends Failure.FeatureFailure {
        public static final RequestAccountDataNotSuccessful INSTANCE = new RequestAccountDataNotSuccessful();

        private RequestAccountDataNotSuccessful() {
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/LoginFailure$AssociationOfBoxAndAccountNotSuccessful;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class AssociationOfBoxAndAccountNotSuccessful extends Failure.FeatureFailure {
        public static final AssociationOfBoxAndAccountNotSuccessful INSTANCE = new AssociationOfBoxAndAccountNotSuccessful();

        private AssociationOfBoxAndAccountNotSuccessful() {
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/LoginFailure$SendProfileOfBoxNotSuccessful;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class SendProfileOfBoxNotSuccessful extends Failure.FeatureFailure {
        public static final SendProfileOfBoxNotSuccessful INSTANCE = new SendProfileOfBoxNotSuccessful();

        private SendProfileOfBoxNotSuccessful() {
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/LoginFailure$GetUserInfoFailure;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class GetUserInfoFailure extends Failure.FeatureFailure {
        public static final GetUserInfoFailure INSTANCE = new GetUserInfoFailure();

        private GetUserInfoFailure() {
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/LoginFailure$GetDeviceInfoFailure;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class GetDeviceInfoFailure extends Failure.FeatureFailure {
        public static final GetDeviceInfoFailure INSTANCE = new GetDeviceInfoFailure();

        private GetDeviceInfoFailure() {
        }
    }
}
