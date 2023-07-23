package media.tiger.tigerbox.p016ui.onboarding.step4;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.OnboardingNavGraphDirections;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;

@Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendCommunicationFragmentDirections;", "", "()V", "ActionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationFragmentDirections */
/* compiled from: OnboardingBackendCommunicationFragmentDirections.kt */
public final class OnboardingBackendCommunicationFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo33736d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendCommunicationFragmentDirections$ActionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment;", "Landroidx/navigation/NavDirections;", "responseType", "Lmedia/tiger/tigerbox/ui/onboarding/step4/BackendResponseType;", "(Lmedia/tiger/tigerbox/ui/onboarding/step4/BackendResponseType;)V", "actionId", "", "getActionId", "()I", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "getResponseType", "()Lmedia/tiger/tigerbox/ui/onboarding/step4/BackendResponseType;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationFragmentDirections$ActionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment */
    /* compiled from: OnboardingBackendCommunicationFragmentDirections.kt */
    private static final class C2997x78728dcc implements NavDirections {
        private final int actionId;
        private final BackendResponseType responseType;

        public C2997x78728dcc() {
            this((BackendResponseType) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ C2997x78728dcc copy$default(C2997x78728dcc actionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment, BackendResponseType backendResponseType, int i, Object obj) {
            if ((i & 1) != 0) {
                backendResponseType = actionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment.responseType;
            }
            return actionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment.copy(backendResponseType);
        }

        public final BackendResponseType component1() {
            return this.responseType;
        }

        public final C2997x78728dcc copy(BackendResponseType backendResponseType) {
            Intrinsics.checkNotNullParameter(backendResponseType, "responseType");
            return new C2997x78728dcc(backendResponseType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C2997x78728dcc) && this.responseType == ((C2997x78728dcc) obj).responseType;
        }

        public int hashCode() {
            return this.responseType.hashCode();
        }

        public String toString() {
            return "ActionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment(responseType=" + this.responseType + ')';
        }

        public C2997x78728dcc(BackendResponseType backendResponseType) {
            Intrinsics.checkNotNullParameter(backendResponseType, "responseType");
            this.responseType = backendResponseType;
            this.actionId = C2814R.C2817id.f578x88fff1af;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C2997x78728dcc(BackendResponseType backendResponseType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? BackendResponseType.BEARER_TOKEN : backendResponseType);
        }

        public final BackendResponseType getResponseType() {
            return this.responseType;
        }

        public int getActionId() {
            return this.actionId;
        }

        public Bundle getArguments() {
            Bundle bundle = new Bundle();
            if (Parcelable.class.isAssignableFrom(BackendResponseType.class)) {
                bundle.putParcelable("responseType", (Parcelable) this.responseType);
            } else if (Serializable.class.isAssignableFrom(BackendResponseType.class)) {
                bundle.putSerializable("responseType", this.responseType);
            }
            return bundle;
        }
    }

    private OnboardingBackendCommunicationFragmentDirections() {
    }

    @Metadata(mo33736d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007J7\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0004¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendCommunicationFragmentDirections$Companion;", "", "()V", "actionOnboardingBackendCommunicationFragmentToMainContentActivity", "Landroidx/navigation/NavDirections;", "actionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment", "responseType", "Lmedia/tiger/tigerbox/ui/onboarding/step4/BackendResponseType;", "actionOnboardingToOnboardingErrorDialog", "dialogType", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "titleFormatParams", "", "", "messageFormatParams", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;[Ljava/lang/String;)Landroidx/navigation/NavDirections;", "actionOnboardingToResetDialog", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationFragmentDirections$Companion */
    /* compiled from: OnboardingBackendCommunicationFragmentDirections.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: actionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment$default */
        public static /* synthetic */ NavDirections m500x86be4f89(Companion companion, BackendResponseType backendResponseType, int i, Object obj) {
            if ((i & 1) != 0) {
                backendResponseType = BackendResponseType.BEARER_TOKEN;
            }
            return companion.mo40242x5d8ed5ec(backendResponseType);
        }

        /* renamed from: actionOnboardingBackendCommunicationFragmentToOnboardingBackendResponseFragment */
        public final NavDirections mo40242x5d8ed5ec(BackendResponseType backendResponseType) {
            Intrinsics.checkNotNullParameter(backendResponseType, "responseType");
            return new C2997x78728dcc(backendResponseType);
        }

        /* renamed from: actionOnboardingBackendCommunicationFragmentToMainContentActivity */
        public final NavDirections mo40241xdfbaa551() {
            return new ActionOnlyNavDirections(C2814R.C2817id.f577x5e304254);
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
