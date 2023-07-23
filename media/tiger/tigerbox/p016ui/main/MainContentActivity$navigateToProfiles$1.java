package media.tiger.tigerbox.p016ui.main;

import android.os.Bundle;
import androidx.navigation.NavController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/MainContentActivity$navigateToProfiles$1", "Lmedia/tiger/tigerbox/ui/binding/UnTypedBindingClickListener;", "onClick", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.MainContentActivity$navigateToProfiles$1 */
/* compiled from: MainContentActivity.kt */
public final class MainContentActivity$navigateToProfiles$1 implements UnTypedBindingClickListener {
    final /* synthetic */ MainContentActivity this$0;

    MainContentActivity$navigateToProfiles$1(MainContentActivity mainContentActivity) {
        this.this$0 = mainContentActivity;
    }

    public void onClick() {
        if (this.this$0.getUseProfilesMainContentSwitch()) {
            NavController access$getNavController$p = this.this$0.navController;
            if (access$getNavController$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                access$getNavController$p = null;
            }
            OnboardingActivityKt.navigateActionSafe$default(access$getNavController$p, C2814R.C2817id.action_to_UserProfilesSwitching, (Bundle) null, 2, (Object) null);
            return;
        }
        NavController access$getNavController$p2 = this.this$0.navController;
        if (access$getNavController$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            access$getNavController$p2 = null;
        }
        OnboardingActivityKt.navigateActionSafe$default(access$getNavController$p2, C2814R.C2817id.action_to_ShowProfilePicture, (Bundle) null, 2, (Object) null);
    }
}
