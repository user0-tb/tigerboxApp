package media.tiger.tigerbox.infrastructure.exception;

import kotlin.Metadata;
import media.tiger.tigerbox.infrastructure.exception.Failure;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/GeneratingCertificateFailure;", "", "()V", "PemRequestFailure", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Failure.kt */
public final class GeneratingCertificateFailure {

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/exception/GeneratingCertificateFailure$PemRequestFailure;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure$FeatureFailure;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Failure.kt */
    public static final class PemRequestFailure extends Failure.FeatureFailure {
        public static final PemRequestFailure INSTANCE = new PemRequestFailure();

        private PemRequestFailure() {
        }
    }
}
