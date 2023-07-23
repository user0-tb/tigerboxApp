package media.tiger.tigerbox.infrastructure.exception;

import kotlin.Metadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/ShopLayoutFailure;", "", "()V", "GetProductListNotSuccessful", "InternalError", "ShopLayoutNotSuccessful", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Failure.kt */
public final class ShopLayoutFailure {

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/ShopLayoutFailure$ShopLayoutNotSuccessful;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class ShopLayoutNotSuccessful extends Failure.FeatureFailure {
        public static final ShopLayoutNotSuccessful INSTANCE = new ShopLayoutNotSuccessful();

        private ShopLayoutNotSuccessful() {
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/ShopLayoutFailure$GetProductListNotSuccessful;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class GetProductListNotSuccessful extends Failure.FeatureFailure {
        public static final GetProductListNotSuccessful INSTANCE = new GetProductListNotSuccessful();

        private GetProductListNotSuccessful() {
        }
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/ShopLayoutFailure$InternalError;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class InternalError extends Failure.FeatureFailure {
        public static final InternalError INSTANCE = new InternalError();

        private InternalError() {
        }
    }
}
