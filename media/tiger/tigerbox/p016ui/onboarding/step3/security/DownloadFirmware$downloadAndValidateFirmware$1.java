package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DownloadFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "downloadResponse", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/LargeDownloadHandler$Result;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$downloadAndValidateFirmware$1 */
/* compiled from: DownloadFirmware.kt */
final class DownloadFirmware$downloadAndValidateFirmware$1 extends Lambda implements Function1<LargeDownloadHandler.Result, Unit> {
    final /* synthetic */ Function1<DownloadFirmware.ValidationResult, Unit> $onComplete;
    final /* synthetic */ Function1<Double, Unit> $progressUpdate;
    final /* synthetic */ ReleaseInformation.Release $release;
    final /* synthetic */ DownloadFirmware this$0;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$downloadAndValidateFirmware$1$WhenMappings */
    /* compiled from: DownloadFirmware.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LargeDownloadHandler.FailReason.values().length];
            iArr[LargeDownloadHandler.FailReason.DOWNLOAD_UNSUCCESSFUL.ordinal()] = 1;
            iArr[LargeDownloadHandler.FailReason.FILE_NOT_FOUND.ordinal()] = 2;
            iArr[LargeDownloadHandler.FailReason.TIMEOUT.ordinal()] = 3;
            iArr[LargeDownloadHandler.FailReason.UNKNOWN.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DownloadFirmware$downloadAndValidateFirmware$1(Function1<? super DownloadFirmware.ValidationResult, Unit> function1, DownloadFirmware downloadFirmware, ReleaseInformation.Release release, Function1<? super Double, Unit> function12) {
        super(1);
        this.$onComplete = function1;
        this.this$0 = downloadFirmware;
        this.$release = release;
        this.$progressUpdate = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LargeDownloadHandler.Result) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LargeDownloadHandler.Result result) {
        DownloadFirmware.ValidationResult.Failure failure;
        Intrinsics.checkNotNullParameter(result, "downloadResponse");
        if (result instanceof LargeDownloadHandler.Result.Failure) {
            Function1<DownloadFirmware.ValidationResult, Unit> function1 = this.$onComplete;
            int i = WhenMappings.$EnumSwitchMapping$0[((LargeDownloadHandler.Result.Failure) result).getReason().ordinal()];
            if (i == 1) {
                failure = new DownloadFirmware.ValidationResult.Failure(DownloadFirmware.FailReason.DOWNLOAD_UNSUCCESSFUL);
            } else if (i == 2) {
                failure = new DownloadFirmware.ValidationResult.Failure(DownloadFirmware.FailReason.FILE_NOT_FOUND);
            } else if (i == 3) {
                failure = new DownloadFirmware.ValidationResult.Failure(DownloadFirmware.FailReason.TIMEOUT);
            } else if (i == 4) {
                failure = new DownloadFirmware.ValidationResult.Failure(DownloadFirmware.FailReason.DOWNLOAD_UNSUCCESSFUL);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            function1.invoke(failure);
            return;
        }
        this.$onComplete.invoke(this.this$0.validateFirmware(this.$release, this.$progressUpdate));
    }
}
