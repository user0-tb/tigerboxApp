package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "percent", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$invoke$1$validationResult$1 */
/* compiled from: DownloadFirmware.kt */
final class DownloadFirmware$invoke$1$validationResult$1 extends Lambda implements Function1<Double, Unit> {
    final /* synthetic */ Function1<Double, Unit> $update;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DownloadFirmware$invoke$1$validationResult$1(Function1<? super Double, Unit> function1) {
        super(1);
        this.$update = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).doubleValue());
        return Unit.INSTANCE;
    }

    public final void invoke(double d) {
        this.$update.invoke(Double.valueOf(d));
    }
}
