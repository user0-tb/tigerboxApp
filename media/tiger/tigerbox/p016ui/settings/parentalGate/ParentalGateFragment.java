package media.tiger.tigerbox.p016ui.settings.parentalGate;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannedString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.p003os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentParentalGateBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateViewModel;

@Metadata(mo33736d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007*\u0003\u0004\u0010\u0013\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.H\u0002J%\u0010/\u001a\u00020*2\u0006\u00100\u001a\u0002012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u001c03H\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020*H\u0002J\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u001cH\u0002J\u0010\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020\u001cH\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078B@BX\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006:"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "backSpaceHandler", "media/tiger/tigerbox/ui/settings/parentalGate/ParentalGateFragment$backSpaceHandler$1", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateFragment$backSpaceHandler$1;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentParentalGateBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentParentalGateBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentParentalGateBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "cancelClickHandler", "media/tiger/tigerbox/ui/settings/parentalGate/ParentalGateFragment$cancelClickHandler$1", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateFragment$cancelClickHandler$1;", "numberClickHandler", "media/tiger/tigerbox/ui/settings/parentalGate/ParentalGateFragment$numberClickHandler$1", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateFragment$numberClickHandler$1;", "parentalGateViewModel", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel;", "getParentalGateViewModel", "()Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateViewModel;", "parentalGateViewModel$delegate", "Lkotlin/Lazy;", "generateRandomPin", "", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "setUpObservers", "showError", "attempts", "", "showInfoDialog", "type", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "params", "", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;)V", "showSettings", "toPinDescription", "pin", "updatePin", "pinText", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateFragment */
/* compiled from: ParentalGateFragment.kt */
public final class ParentalGateFragment extends Hilt_ParentalGateFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ParentalGateFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentParentalGateBinding;", 0))};
    private final ParentalGateFragment$backSpaceHandler$1 backSpaceHandler = new ParentalGateFragment$backSpaceHandler$1(this);
    private final AutoClearedValue binding$delegate;
    private final ParentalGateFragment$cancelClickHandler$1 cancelClickHandler = new ParentalGateFragment$cancelClickHandler$1(this);
    private final ParentalGateFragment$numberClickHandler$1 numberClickHandler = new ParentalGateFragment$numberClickHandler$1(this);
    private final Lazy parentalGateViewModel$delegate;

    public ImageView getCloseButton() {
        return null;
    }

    public ParentalGateFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 parentalGateFragment$special$$inlined$viewModels$default$1 = new ParentalGateFragment$special$$inlined$viewModels$default$1(fragment);
        this.parentalGateViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ParentalGateViewModel.class), new ParentalGateFragment$special$$inlined$viewModels$default$2(parentalGateFragment$special$$inlined$viewModels$default$1), new ParentalGateFragment$special$$inlined$viewModels$default$3(parentalGateFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentParentalGateBinding getBinding() {
        return (FragmentParentalGateBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentParentalGateBinding fragmentParentalGateBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentParentalGateBinding);
    }

    /* access modifiers changed from: private */
    public final ParentalGateViewModel getParentalGateViewModel() {
        return (ParentalGateViewModel) this.parentalGateViewModel$delegate.getValue();
    }

    public DialogViewModel getViewModel() {
        return getParentalGateViewModel();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentParentalGateBinding inflate = FragmentParentalGateBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().setNumberClickListener(this.numberClickHandler);
        getBinding().setBackSpaceListener(this.backSpaceHandler);
        getBinding().setCancelListener(this.cancelClickHandler);
        setUpObservers();
        getParentalGateViewModel().prepare(generateRandomPin());
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onDestroy() {
        getParentalGateViewModel().removeObservers();
        super.onDestroy();
    }

    private final void setUpObservers() {
        getParentalGateViewModel().getViewState().observe(getViewLifecycleOwner(), new ParentalGateFragment$$ExternalSyntheticLambda3(this));
        getParentalGateViewModel().getAccountPin().observe(getViewLifecycleOwner(), new ParentalGateFragment$$ExternalSyntheticLambda1(this));
        getParentalGateViewModel().getAccountHasRandomPin().observe(getViewLifecycleOwner(), new ParentalGateFragment$$ExternalSyntheticLambda0(this));
        getParentalGateViewModel().getNavigationState().observe(getViewLifecycleOwner(), new ParentalGateFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpObservers$lambda-0  reason: not valid java name */
    public static final void m2542setUpObservers$lambda0(ParentalGateFragment parentalGateFragment, ParentalGateViewModel.ViewState viewState) {
        Intrinsics.checkNotNullParameter(parentalGateFragment, "this$0");
        if (viewState instanceof ParentalGateViewModel.ViewState.UpdatedPin) {
            parentalGateFragment.updatePin(((ParentalGateViewModel.ViewState.UpdatedPin) viewState).getPin());
        } else if (viewState instanceof ParentalGateViewModel.ViewState.InvalidPin) {
            parentalGateFragment.showError(((ParentalGateViewModel.ViewState.InvalidPin) viewState).getAttempts());
        } else if (viewState instanceof ParentalGateViewModel.ViewState.ValidatedPin) {
            parentalGateFragment.showSettings();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpObservers$lambda-1  reason: not valid java name */
    public static final void m2543setUpObservers$lambda1(ParentalGateFragment parentalGateFragment, String str) {
        Intrinsics.checkNotNullParameter(parentalGateFragment, "this$0");
        FragmentParentalGateBinding binding = parentalGateFragment.getBinding();
        Intrinsics.checkNotNullExpressionValue(str, "accountPin");
        SpannedString valueOf = SpannedString.valueOf(parentalGateFragment.toPinDescription(str));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(this)");
        binding.setAccountPin(valueOf);
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpObservers$lambda-2  reason: not valid java name */
    public static final void m2544setUpObservers$lambda2(ParentalGateFragment parentalGateFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(parentalGateFragment, "this$0");
        parentalGateFragment.getBinding().setHasRandomPin(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpObservers$lambda-3  reason: not valid java name */
    public static final void m2545setUpObservers$lambda3(ParentalGateFragment parentalGateFragment, ParentalGateViewModel.NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(parentalGateFragment, "this$0");
        if (navigationState instanceof ParentalGateViewModel.NavigationState.Cancel) {
            parentalGateFragment.closeSafely();
        }
    }

    private final String generateRandomPin() {
        int[] iArr = new int[3];
        for (int i = 0; i < 3; i++) {
            iArr[i] = RangesKt.random(new IntRange(0, 9), (Random) Random.Default);
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 3; i2++) {
            sb.append(String.valueOf(iArr[i2]));
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
        return sb2;
    }

    private final String toPinDescription(String str) {
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence = str;
        for (int i = 0; i < charSequence.length(); i++) {
            String valueOf = String.valueOf(charSequence.charAt(i));
            switch (valueOf.hashCode()) {
                case 48:
                    if (valueOf.equals(SessionDescription.SUPPORTED_SDP_VERSION)) {
                        sb.append(getString(C2814R.string.number_as_word_zero));
                        break;
                    } else {
                        break;
                    }
                case 49:
                    if (valueOf.equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE)) {
                        sb.append(getString(C2814R.string.number_as_word_one));
                        break;
                    } else {
                        break;
                    }
                case 50:
                    if (valueOf.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                        sb.append(getString(C2814R.string.number_as_word_two));
                        break;
                    } else {
                        break;
                    }
                case 51:
                    if (valueOf.equals(ExifInterface.GPS_MEASUREMENT_3D)) {
                        sb.append(getString(C2814R.string.number_as_word_three));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (valueOf.equals("4")) {
                        sb.append(getString(C2814R.string.number_as_word_four));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (valueOf.equals("5")) {
                        sb.append(getString(C2814R.string.number_as_word_five));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (valueOf.equals("6")) {
                        sb.append(getString(C2814R.string.number_as_word_six));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (valueOf.equals("7")) {
                        sb.append(getString(C2814R.string.number_as_word_seven));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (valueOf.equals("8")) {
                        sb.append(getString(C2814R.string.number_as_word_eight));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (valueOf.equals("9")) {
                        sb.append(getString(C2814R.string.number_as_word_nine));
                        break;
                    } else {
                        break;
                    }
            }
            sb.append(" ");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "result.toString()");
        return sb2;
    }

    private final void updatePin(String str) {
        getBinding().setPinText(Html.fromHtml(str));
    }

    private final void showError(int i) {
        getBinding().setHasError(true);
        if (Intrinsics.areEqual((Object) getParentalGateViewModel().getAccountHasRandomPin().getValue(), (Object) true)) {
            showInfoDialog(InfoDialogType.PARENTAL_GATE_WRONG_RANDOM_PIN, (String[]) ((Object[]) new String[0]));
        } else {
            showInfoDialog(InfoDialogType.PARENTAL_GATE_WRONG_CUSTOM_PIN, (String[]) ((Object[]) new String[0]));
        }
    }

    private final void showSettings() {
        closeSafely();
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_to_parentalSettings, (Bundle) null, 2, (Object) null);
    }

    private final void showInfoDialog(InfoDialogType infoDialogType, String[] strArr) {
        FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType), TuplesKt.m475to("messageFormatParams", strArr)));
    }

    static /* synthetic */ void showInfoDialog$default(ParentalGateFragment parentalGateFragment, InfoDialogType infoDialogType, String[] strArr, int i, Object obj) {
        if ((i & 2) != 0) {
            strArr = (String[]) ((Object[]) new String[0]);
        }
        parentalGateFragment.showInfoDialog(infoDialogType, strArr);
    }
}
