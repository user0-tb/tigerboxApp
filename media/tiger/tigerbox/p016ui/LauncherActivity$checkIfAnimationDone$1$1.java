package media.tiger.tigerbox.p016ui;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.p016ui.LaunchNavigationAction;
import media.tiger.tigerbox.p016ui.main.MainContentActivity;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivity;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "", "destination", "Lmedia/tiger/tigerbox/ui/LaunchNavigationAction;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.LauncherActivity$checkIfAnimationDone$1$1 */
/* compiled from: LauncherActivity.kt */
final class LauncherActivity$checkIfAnimationDone$1$1 extends Lambda implements Function1<LaunchNavigationAction, Unit> {
    final /* synthetic */ LauncherActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LauncherActivity$checkIfAnimationDone$1$1(LauncherActivity launcherActivity) {
        super(1);
        this.this$0 = launcherActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LaunchNavigationAction) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LaunchNavigationAction launchNavigationAction) {
        Intrinsics.checkNotNullParameter(launchNavigationAction, "destination");
        if (launchNavigationAction instanceof LaunchNavigationAction.NavigateToMainActivityAction) {
            this.this$0.startActivity(new Intent(this.this$0, MainContentActivity.class));
        } else if (launchNavigationAction instanceof LaunchNavigationAction.NavigateToOnboardingAction) {
            this.this$0.startActivity(new Intent(this.this$0, OnboardingActivity.class));
        }
        this.this$0.finish();
    }
}
