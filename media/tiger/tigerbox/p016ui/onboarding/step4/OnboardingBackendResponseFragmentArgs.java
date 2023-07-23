package media.tiger.tigerbox.p016ui.onboarding.step4;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendResponseFragmentArgs;", "Landroidx/navigation/NavArgs;", "responseType", "Lmedia/tiger/tigerbox/ui/onboarding/step4/BackendResponseType;", "(Lmedia/tiger/tigerbox/ui/onboarding/step4/BackendResponseType;)V", "getResponseType", "()Lmedia/tiger/tigerbox/ui/onboarding/step4/BackendResponseType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toBundle", "Landroid/os/Bundle;", "toSavedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "toString", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseFragmentArgs */
/* compiled from: OnboardingBackendResponseFragmentArgs.kt */
public final class OnboardingBackendResponseFragmentArgs implements NavArgs {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final BackendResponseType responseType;

    public OnboardingBackendResponseFragmentArgs() {
        this((BackendResponseType) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OnboardingBackendResponseFragmentArgs copy$default(OnboardingBackendResponseFragmentArgs onboardingBackendResponseFragmentArgs, BackendResponseType backendResponseType, int i, Object obj) {
        if ((i & 1) != 0) {
            backendResponseType = onboardingBackendResponseFragmentArgs.responseType;
        }
        return onboardingBackendResponseFragmentArgs.copy(backendResponseType);
    }

    @JvmStatic
    public static final OnboardingBackendResponseFragmentArgs fromBundle(Bundle bundle) {
        return Companion.fromBundle(bundle);
    }

    @JvmStatic
    public static final OnboardingBackendResponseFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
        return Companion.fromSavedStateHandle(savedStateHandle);
    }

    public final BackendResponseType component1() {
        return this.responseType;
    }

    public final OnboardingBackendResponseFragmentArgs copy(BackendResponseType backendResponseType) {
        Intrinsics.checkNotNullParameter(backendResponseType, "responseType");
        return new OnboardingBackendResponseFragmentArgs(backendResponseType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnboardingBackendResponseFragmentArgs) && this.responseType == ((OnboardingBackendResponseFragmentArgs) obj).responseType;
    }

    public int hashCode() {
        return this.responseType.hashCode();
    }

    public String toString() {
        return "OnboardingBackendResponseFragmentArgs(responseType=" + this.responseType + ')';
    }

    public OnboardingBackendResponseFragmentArgs(BackendResponseType backendResponseType) {
        Intrinsics.checkNotNullParameter(backendResponseType, "responseType");
        this.responseType = backendResponseType;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OnboardingBackendResponseFragmentArgs(BackendResponseType backendResponseType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? BackendResponseType.BEARER_TOKEN : backendResponseType);
    }

    public final BackendResponseType getResponseType() {
        return this.responseType;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        if (Parcelable.class.isAssignableFrom(BackendResponseType.class)) {
            bundle.putParcelable("responseType", (Parcelable) this.responseType);
        } else if (Serializable.class.isAssignableFrom(BackendResponseType.class)) {
            bundle.putSerializable("responseType", this.responseType);
        }
        return bundle;
    }

    public final SavedStateHandle toSavedStateHandle() {
        SavedStateHandle savedStateHandle = new SavedStateHandle();
        if (Parcelable.class.isAssignableFrom(BackendResponseType.class)) {
            savedStateHandle.set("responseType", (Parcelable) this.responseType);
        } else if (Serializable.class.isAssignableFrom(BackendResponseType.class)) {
            savedStateHandle.set("responseType", this.responseType);
        }
        return savedStateHandle;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendResponseFragmentArgs$Companion;", "", "()V", "fromBundle", "Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendResponseFragmentArgs;", "bundle", "Landroid/os/Bundle;", "fromSavedStateHandle", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseFragmentArgs$Companion */
    /* compiled from: OnboardingBackendResponseFragmentArgs.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OnboardingBackendResponseFragmentArgs fromBundle(Bundle bundle) {
            BackendResponseType backendResponseType;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.setClassLoader(OnboardingBackendResponseFragmentArgs.class.getClassLoader());
            if (!bundle.containsKey("responseType")) {
                backendResponseType = BackendResponseType.BEARER_TOKEN;
            } else if (Parcelable.class.isAssignableFrom(BackendResponseType.class) || Serializable.class.isAssignableFrom(BackendResponseType.class)) {
                backendResponseType = (BackendResponseType) bundle.get("responseType");
                if (backendResponseType == null) {
                    throw new IllegalArgumentException("Argument \"responseType\" is marked as non-null but was passed a null value.");
                }
            } else {
                throw new UnsupportedOperationException(BackendResponseType.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            return new OnboardingBackendResponseFragmentArgs(backendResponseType);
        }

        @JvmStatic
        public final OnboardingBackendResponseFragmentArgs fromSavedStateHandle(SavedStateHandle savedStateHandle) {
            BackendResponseType backendResponseType;
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            if (!savedStateHandle.contains("responseType")) {
                backendResponseType = BackendResponseType.BEARER_TOKEN;
            } else if (Parcelable.class.isAssignableFrom(BackendResponseType.class) || Serializable.class.isAssignableFrom(BackendResponseType.class)) {
                backendResponseType = (BackendResponseType) savedStateHandle.get("responseType");
                if (backendResponseType == null) {
                    throw new IllegalArgumentException("Argument \"responseType\" is marked as non-null but was passed a null value");
                }
            } else {
                throw new UnsupportedOperationException(BackendResponseType.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
            }
            return new OnboardingBackendResponseFragmentArgs(backendResponseType);
        }
    }
}
