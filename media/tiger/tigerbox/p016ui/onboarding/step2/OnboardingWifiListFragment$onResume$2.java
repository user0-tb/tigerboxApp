package media.tiger.tigerbox.p016ui.onboarding.step2;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordFragment;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Landroid/os/Bundle;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiListFragment$onResume$2 */
/* compiled from: OnboardingWifiListFragment.kt */
final class OnboardingWifiListFragment$onResume$2 extends Lambda implements Function2<String, Bundle, Unit> {
    final /* synthetic */ OnboardingWifiListFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnboardingWifiListFragment$onResume$2(OnboardingWifiListFragment onboardingWifiListFragment) {
        super(2);
        this.this$0 = onboardingWifiListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Bundle) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey(WifiEnterPasswordFragment.PASSWORD)) {
            this.this$0.getOnboardingWifiViewModel().passwordCaptured(bundle.getString(WifiEnterPasswordFragment.PASSWORD));
        }
    }
}
