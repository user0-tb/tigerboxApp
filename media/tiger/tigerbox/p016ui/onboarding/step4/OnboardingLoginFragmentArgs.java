package media.tiger.tigerbox.p016ui.onboarding.step4;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingLoginFragmentArgs;", "Landroidx/navigation/NavArgs;", "sessionTokenExpired", "", "(Z)V", "getSessionTokenExpired", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingLoginFragmentArgs */
/* compiled from: OnboardingLoginFragmentArgs.kt */
public final class OnboardingLoginFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean sessionTokenExpired;

    public OnboardingLoginFragmentArgs() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OnboardingLoginFragmentArgs copy$default(OnboardingLoginFragmentArgs onboardingLoginFragmentArgs, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = onboardingLoginFragmentArgs.sessionTokenExpired;
        }
        return onboardingLoginFragmentArgs.copy(z);
    }

    @JvmStatic
    public static final OnboardingLoginFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final OnboardingLoginFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final boolean component1() {
        return this.sessionTokenExpired;
    }

    public final OnboardingLoginFragmentArgs copy(boolean z) {
        return new OnboardingLoginFragmentArgs(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnboardingLoginFragmentArgs) && this.sessionTokenExpired == ((OnboardingLoginFragmentArgs) obj).sessionTokenExpired;
    }

    public int hashCode() {
        boolean z = this.sessionTokenExpired;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public String toString() {
        return "OnboardingLoginFragmentArgs(sessionTokenExpired=" + this.sessionTokenExpired + ')';
    }

    public OnboardingLoginFragmentArgs(boolean z) {
        this.sessionTokenExpired = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnboardingLoginFragmentArgs(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getSessionTokenExpired() {
        return this.sessionTokenExpired;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("sessionTokenExpired", this.sessionTokenExpired);
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("sessionTokenExpired", Boolean.valueOf(this.sessionTokenExpired));
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingLoginFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingLoginFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingLoginFragmentArgs$Companion */
    /* compiled from: OnboardingLoginFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OnboardingLoginFragmentArgs fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(OnboardingLoginFragmentArgs.class.getClassLoader());
            return new OnboardingLoginFragmentArgs(bundle.containsKey("sessionTokenExpired") ? bundle.getBoolean("sessionTokenExpired") : false);
        }

        @JvmStatic
        public final OnboardingLoginFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("sessionTokenExpired")) {
                bool = (Boolean) savedStateHandle.get("sessionTokenExpired");
                if (bool == null) {
                    throw new IllegalArgumentException("Argument \"sessionTokenExpired\" of type boolean does not support null values");
                }
            } else {
                bool = false;
            }
            return new OnboardingLoginFragmentArgs(bool.booleanValue());
        }
    }
}
