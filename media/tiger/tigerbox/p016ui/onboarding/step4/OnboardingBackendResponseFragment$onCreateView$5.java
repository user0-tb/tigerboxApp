package media.tiger.tigerbox.p016ui.onboarding.step4;

import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseFragment$onCreateView$5 */
/* compiled from: OnboardingBackendResponseFragment.kt */
final class OnboardingBackendResponseFragment$onCreateView$5 extends Lambda implements Function0<Unit> {
    final /* synthetic */ OnboardingBackendResponseFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OnboardingBackendResponseFragment$onCreateView$5(OnboardingBackendResponseFragment onboardingBackendResponseFragment) {
        super(0);
        this.this$0 = onboardingBackendResponseFragment;
    }

    public final void invoke() {
        this.this$0.getOnboardingBackendResponseViewModel().stopContinuousScan();
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this.this$0), OnboardingBackendResponseFragmentDirections.Companion.actionOnboardingBackendResponseFragmentToMainContentActivity());
        this.this$0.requireActivity().finish();
    }
}
