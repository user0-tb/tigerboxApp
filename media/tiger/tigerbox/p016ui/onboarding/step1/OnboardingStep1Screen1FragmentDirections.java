package media.tiger.tigerbox.p016ui.onboarding.step1;

import android.os.Bundle;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.OnboardingNavGraphDirections;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1FragmentDirections;", "", "()V", "ActionOnboardingMoveToLoginFromStart", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1FragmentDirections */
/* compiled from: OnboardingStep1Screen1FragmentDirections.kt */
public final class OnboardingStep1Screen1FragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo33736d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1FragmentDirections$ActionOnboardingMoveToLoginFromStart;", "Landroidx/navigation/NavDirections;", "sessionTokenExpired", "", "(Z)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getSessionTokenExpired", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1FragmentDirections$ActionOnboardingMoveToLoginFromStart */
    /* compiled from: OnboardingStep1Screen1FragmentDirections.kt */
    private static final class ActionOnboardingMoveToLoginFromStart implements NavDirections {
        private final int actionId;
        private final boolean sessionTokenExpired;

        public ActionOnboardingMoveToLoginFromStart() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ ActionOnboardingMoveToLoginFromStart copy$default(ActionOnboardingMoveToLoginFromStart actionOnboardingMoveToLoginFromStart, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = actionOnboardingMoveToLoginFromStart.sessionTokenExpired;
            }
            return actionOnboardingMoveToLoginFromStart.copy(z);
        }

        public final boolean component1() {
            return this.sessionTokenExpired;
        }

        public final ActionOnboardingMoveToLoginFromStart copy(boolean z) {
            return new ActionOnboardingMoveToLoginFromStart(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ActionOnboardingMoveToLoginFromStart) && this.sessionTokenExpired == ((ActionOnboardingMoveToLoginFromStart) obj).sessionTokenExpired;
        }

        public int hashCode() {
            boolean z = this.sessionTokenExpired;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "ActionOnboardingMoveToLoginFromStart(sessionTokenExpired=" + this.sessionTokenExpired + ')';
        }

        public ActionOnboardingMoveToLoginFromStart(boolean z) {
            this.sessionTokenExpired = z;
            this.actionId = C2814R.C2817id.action_onboarding_move_to_login_from_start;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ActionOnboardingMoveToLoginFromStart(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean getSessionTokenExpired() {
            return this.sessionTokenExpired;
        }

        public int getActionId() {
            return this.actionId;
        }

        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("sessionTokenExpired", this.sessionTokenExpired);
            return bundle;
        }
    }

    private OnboardingStep1Screen1FragmentDirections() {
    }

    @Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J7\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1FragmentDirections$Companion;", "", "()V", "actionOnboardingMoveToLoginFromStart", "Landroidx/navigation/NavDirections;", "sessionTokenExpired", "", "actionOnboardingStep1FragmentToMainContent", "actionOnboardingStep1FragmentToOnboardingStep2Fragment", "actionOnboardingToOnboardingErrorDialog", "dialogType", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "titleFormatParams", "", "", "messageFormatParams", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;[Ljava/lang/String;)Landroidx/navigation/NavDirections;", "actionOnboardingToResetDialog", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1FragmentDirections$Companion */
    /* compiled from: OnboardingStep1Screen1FragmentDirections.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavDirections actionOnboardingStep1FragmentToOnboardingStep2Fragment() {
            return new ActionOnlyNavDirections(C2814R.C2817id.action_onboardingStep1Fragment_to_onboardingStep2Fragment);
        }

        public static /* synthetic */ NavDirections actionOnboardingMoveToLoginFromStart$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.actionOnboardingMoveToLoginFromStart(z);
        }

        public final NavDirections actionOnboardingMoveToLoginFromStart(boolean z) {
            return new ActionOnboardingMoveToLoginFromStart(z);
        }

        public final NavDirections actionOnboardingStep1FragmentToMainContent() {
            return new ActionOnlyNavDirections(C2814R.C2817id.action_onboardingStep1Fragment_to_main_content);
        }

        public static /* synthetic */ NavDirections actionOnboardingToOnboardingErrorDialog$default(Companion companion, InfoDialogType infoDialogType, String[] strArr, String[] strArr2, int i, Object obj) {
            if ((i & 2) != 0) {
                strArr = null;
            }
            if ((i & 4) != 0) {
                strArr2 = null;
            }
            return companion.actionOnboardingToOnboardingErrorDialog(infoDialogType, strArr, strArr2);
        }

        public final NavDirections actionOnboardingToOnboardingErrorDialog(InfoDialogType infoDialogType, String[] strArr, String[] strArr2) {
            Intrinsics.checkNotNullParameter(infoDialogType, "dialogType");
            return OnboardingNavGraphDirections.Companion.actionOnboardingToOnboardingErrorDialog(infoDialogType, strArr, strArr2);
        }

        public final NavDirections actionOnboardingToResetDialog() {
            return OnboardingNavGraphDirections.Companion.actionOnboardingToResetDialog();
        }
    }
}
