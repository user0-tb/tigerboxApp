package media.tiger.tigerbox.p016ui.onboarding.step3;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateFragmentArgs;", "Landroidx/navigation/NavArgs;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateFragmentArgs */
/* compiled from: OnboardingUpdateFragmentArgs.kt */
public final class OnboardingUpdateFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String source;

    public OnboardingUpdateFragmentArgs() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OnboardingUpdateFragmentArgs copy$default(OnboardingUpdateFragmentArgs onboardingUpdateFragmentArgs, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = onboardingUpdateFragmentArgs.source;
        }
        return onboardingUpdateFragmentArgs.copy(str);
    }

    @JvmStatic
    public static final OnboardingUpdateFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final OnboardingUpdateFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final String component1() {
        return this.source;
    }

    public final OnboardingUpdateFragmentArgs copy(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        return new OnboardingUpdateFragmentArgs(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnboardingUpdateFragmentArgs) && Intrinsics.areEqual((Object) this.source, (Object) ((OnboardingUpdateFragmentArgs) obj).source);
    }

    public int hashCode() {
        return this.source.hashCode();
    }

    public String toString() {
        return "OnboardingUpdateFragmentArgs(source=" + this.source + ')';
    }

    public OnboardingUpdateFragmentArgs(String str) {
        Intrinsics.checkNotNullParameter(str, "source");
        this.source = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnboardingUpdateFragmentArgs(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "ONBOARDING" : str);
    }

    public final String getSource() {
        return this.source;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("source", this.source);
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        savedStateHandle.set("source", this.source);
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateFragmentArgs$Companion */
    /* compiled from: OnboardingUpdateFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OnboardingUpdateFragmentArgs fromBundle(Bundle bundle) {
            String str;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(OnboardingUpdateFragmentArgs.class.getClassLoader());
            if (bundle.containsKey("source")) {
                str = bundle.getString("source");
                if (str == null) {
                    throw new IllegalArgumentException("Argument \"source\" is marked as non-null but was passed a null value.");
                }
            } else {
                str = "ONBOARDING";
            }
            return new OnboardingUpdateFragmentArgs(str);
        }

        @JvmStatic
        public final OnboardingUpdateFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
            String str;
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (savedStateHandle.contains("source")) {
                str = (String) savedStateHandle.get("source");
                if (str == null) {
                    throw new IllegalArgumentException("Argument \"source\" is marked as non-null but was passed a null value");
                }
            } else {
                str = "ONBOARDING";
            }
            return new OnboardingUpdateFragmentArgs(str);
        }
    }
}
