package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo33736d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0011\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¨\u0006\t"}, mo33737d2 = {"media/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware$createDownloadListener$1", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "percent", "", "Lmedia/tiger/tigerbox/infrastructure/functional/DownloadListener;", "invoke", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware$createDownloadListener$1 */
/* compiled from: DownloadFirmware.kt */
public final class DownloadFirmware$createDownloadListener$1 implements Function1<Double, Unit> {
    final /* synthetic */ Function1<Double, Unit> $method;

    DownloadFirmware$createDownloadListener$1(Function1<? super Double, Unit> function1) {
        this.$method = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).doubleValue());
        return Unit.INSTANCE;
    }

    public void invoke(double d) {
        this.$method.invoke(Double.valueOf(d / ((double) 2.0f)));
    }
}
