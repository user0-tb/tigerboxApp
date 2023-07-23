package media.tiger.tigerbox.p016ui;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/LaunchNavigationAction;", "", "()V", "NavigateToMainActivityAction", "NavigateToOnboardingAction", "Lmedia/tiger/tigerbox/ui/LaunchNavigationAction$NavigateToOnboardingAction;", "Lmedia/tiger/tigerbox/ui/LaunchNavigationAction$NavigateToMainActivityAction;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.LaunchNavigationAction */
/* compiled from: LaunchViewModel.kt */
public abstract class LaunchNavigationAction {
    public /* synthetic */ LaunchNavigationAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/LaunchNavigationAction$NavigateToOnboardingAction;", "Lmedia/tiger/tigerbox/ui/LaunchNavigationAction;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.LaunchNavigationAction$NavigateToOnboardingAction */
    /* compiled from: LaunchViewModel.kt */
    public static final class NavigateToOnboardingAction extends LaunchNavigationAction {
        public static final NavigateToOnboardingAction INSTANCE = new NavigateToOnboardingAction();

        private NavigateToOnboardingAction() {
            super((DefaultConstructorMarker) null);
        }
    }

    private LaunchNavigationAction() {
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/LaunchNavigationAction$NavigateToMainActivityAction;", "Lmedia/tiger/tigerbox/ui/LaunchNavigationAction;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.LaunchNavigationAction$NavigateToMainActivityAction */
    /* compiled from: LaunchViewModel.kt */
    public static final class NavigateToMainActivityAction extends LaunchNavigationAction {
        public static final NavigateToMainActivityAction INSTANCE = new NavigateToMainActivityAction();

        private NavigateToMainActivityAction() {
            super((DefaultConstructorMarker) null);
        }
    }
}
