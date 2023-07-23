package media.tiger.tigerbox.p016ui.onboarding.step3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentOnboardingBatteryWarningBinding;
import media.tiger.tigerbox.databinding.FragmentOnboardingUpdateScreenBinding;
import media.tiger.tigerbox.databinding.FragmentOnboardingUpdateStartBinding;
import media.tiger.tigerbox.databinding.FragmentOtaNoUpdateBinding;
import media.tiger.tigerbox.databinding.FragmentOtaUpdateInProgressBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.p016ui.onboarding.step3.OnboardingUpdateViewModel;
import media.tiger.tigerbox.p016ui.update.UpdateActivity;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateStep;
import timber.log.Timber;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00106\u001a\u000207H\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J$\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u000207H\u0016J\u001a\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020=2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J \u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0002J\b\u0010M\u001a\u000207H\u0002J\b\u0010N\u001a\u000207H\u0002J\b\u0010O\u001a\u000207H\u0002J\b\u0010P\u001a\u000207H\u0002J\u0010\u0010Q\u001a\u0002072\u0006\u0010L\u001a\u00020KH\u0002J\u001c\u0010R\u001a\u0002072\b\b\u0002\u0010S\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020IH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00128B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00198B@BX\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R+\u0010)\u001a\u00020(2\u0006\u0010\t\u001a\u00020(8B@BX\u0002¢\u0006\u0012\n\u0004\b.\u0010\u0011\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R+\u00100\u001a\u00020/2\u0006\u0010\t\u001a\u00020/8B@BX\u0002¢\u0006\u0012\n\u0004\b5\u0010\u0011\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006T"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateFragment;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBatteryWarningBinding;", "batteryView", "getBatteryView", "()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBatteryWarningBinding;", "setBatteryView", "(Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBatteryWarningBinding;)V", "batteryView$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "Lmedia/tiger/tigerbox/databinding/FragmentOnboardingUpdateScreenBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingUpdateScreenBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentOnboardingUpdateScreenBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/databinding/FragmentOtaNoUpdateBinding;", "noUpdateView", "getNoUpdateView", "()Lmedia/tiger/tigerbox/databinding/FragmentOtaNoUpdateBinding;", "setNoUpdateView", "(Lmedia/tiger/tigerbox/databinding/FragmentOtaNoUpdateBinding;)V", "noUpdateView$delegate", "onCloseClicked", "Landroid/view/View$OnClickListener;", "onboardingUpdateViewModel", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel;", "getOnboardingUpdateViewModel", "()Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel;", "onboardingUpdateViewModel$delegate", "Lkotlin/Lazy;", "Lmedia/tiger/tigerbox/databinding/FragmentOtaUpdateInProgressBinding;", "updateProgressView", "getUpdateProgressView", "()Lmedia/tiger/tigerbox/databinding/FragmentOtaUpdateInProgressBinding;", "setUpdateProgressView", "(Lmedia/tiger/tigerbox/databinding/FragmentOtaUpdateInProgressBinding;)V", "updateProgressView$delegate", "Lmedia/tiger/tigerbox/databinding/FragmentOnboardingUpdateStartBinding;", "updateStartView", "getUpdateStartView", "()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingUpdateStartBinding;", "setUpdateStartView", "(Lmedia/tiger/tigerbox/databinding/FragmentOnboardingUpdateStartBinding;)V", "updateStartView$delegate", "closeScreen", "", "getStringFor", "", "step", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateStep;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "showChargeRequired", "percent", "", "isCharging", "", "isCancellable", "showCheckingForUpdate", "showErrorScreen", "showNextOnboardingScreen", "showNoUpdateAvailable", "showReadyToUpdate", "showUpdateProgress", "updateStep", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateFragment */
/* compiled from: OnboardingUpdateFragment.kt */
public final class OnboardingUpdateFragment extends Hilt_OnboardingUpdateFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final NavArgsLazy args$delegate;
    private final AutoClearedValue batteryView$delegate;
    private final AutoClearedValue binding$delegate;
    private final AutoClearedValue noUpdateView$delegate;
    private final View.OnClickListener onCloseClicked = new OnboardingUpdateFragment$$ExternalSyntheticLambda1(this);
    private final Lazy onboardingUpdateViewModel$delegate;
    private final AutoClearedValue updateProgressView$delegate;
    private final AutoClearedValue updateStartView$delegate;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateFragment$WhenMappings */
    /* compiled from: OnboardingUpdateFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FirmwareUpdateStep.values().length];
            iArr[FirmwareUpdateStep.DOWNLOAD_FIRMWARE.ordinal()] = 1;
            iArr[FirmwareUpdateStep.FIRMWARE_DECRYPT.ordinal()] = 2;
            iArr[FirmwareUpdateStep.COMPLETE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public OnboardingUpdateFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.batteryView$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.updateStartView$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.updateProgressView$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.noUpdateView$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(OnboardingUpdateFragmentArgs.class), new OnboardingUpdateFragment$special$$inlined$navArgs$1(fragment));
        Function0 onboardingUpdateFragment$special$$inlined$viewModels$default$1 = new OnboardingUpdateFragment$special$$inlined$viewModels$default$1(fragment);
        this.onboardingUpdateViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(OnboardingUpdateViewModel.class), new OnboardingUpdateFragment$special$$inlined$viewModels$default$2(onboardingUpdateFragment$special$$inlined$viewModels$default$1), new OnboardingUpdateFragment$special$$inlined$viewModels$default$3(onboardingUpdateFragment$special$$inlined$viewModels$default$1, fragment));
    }

    static {
        Class<OnboardingUpdateFragment> cls = OnboardingUpdateFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingUpdateScreenBinding;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "batteryView", "getBatteryView()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBatteryWarningBinding;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "updateStartView", "getUpdateStartView()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingUpdateStartBinding;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "updateProgressView", "getUpdateProgressView()Lmedia/tiger/tigerbox/databinding/FragmentOtaUpdateInProgressBinding;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "noUpdateView", "getNoUpdateView()Lmedia/tiger/tigerbox/databinding/FragmentOtaNoUpdateBinding;", 0))};
    }

    private final FragmentOnboardingUpdateScreenBinding getBinding() {
        return (FragmentOnboardingUpdateScreenBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentOnboardingUpdateScreenBinding fragmentOnboardingUpdateScreenBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentOnboardingUpdateScreenBinding);
    }

    private final FragmentOnboardingBatteryWarningBinding getBatteryView() {
        return (FragmentOnboardingBatteryWarningBinding) this.batteryView$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    private final void setBatteryView(FragmentOnboardingBatteryWarningBinding fragmentOnboardingBatteryWarningBinding) {
        this.batteryView$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[1], fragmentOnboardingBatteryWarningBinding);
    }

    private final FragmentOnboardingUpdateStartBinding getUpdateStartView() {
        return (FragmentOnboardingUpdateStartBinding) this.updateStartView$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[2]);
    }

    private final void setUpdateStartView(FragmentOnboardingUpdateStartBinding fragmentOnboardingUpdateStartBinding) {
        this.updateStartView$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[2], fragmentOnboardingUpdateStartBinding);
    }

    private final FragmentOtaUpdateInProgressBinding getUpdateProgressView() {
        return (FragmentOtaUpdateInProgressBinding) this.updateProgressView$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[3]);
    }

    private final void setUpdateProgressView(FragmentOtaUpdateInProgressBinding fragmentOtaUpdateInProgressBinding) {
        this.updateProgressView$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[3], fragmentOtaUpdateInProgressBinding);
    }

    private final FragmentOtaNoUpdateBinding getNoUpdateView() {
        return (FragmentOtaNoUpdateBinding) this.noUpdateView$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[4]);
    }

    private final void setNoUpdateView(FragmentOtaNoUpdateBinding fragmentOtaNoUpdateBinding) {
        this.noUpdateView$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[4], fragmentOtaNoUpdateBinding);
    }

    private final OnboardingUpdateFragmentArgs getArgs() {
        return (OnboardingUpdateFragmentArgs) this.args$delegate.getValue();
    }

    private final OnboardingUpdateViewModel getOnboardingUpdateViewModel() {
        return (OnboardingUpdateViewModel) this.onboardingUpdateViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentOnboardingUpdateScreenBinding inflate = FragmentOnboardingUpdateScreenBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        FragmentOnboardingBatteryWarningBinding fragmentOnboardingBatteryWarningBinding = getBinding().onboardingUpdateScreenBatteryWarning;
        Intrinsics.checkNotNullExpressionValue(fragmentOnboardingBatteryWarningBinding, "binding.onboardingUpdateScreenBatteryWarning");
        setBatteryView(fragmentOnboardingBatteryWarningBinding);
        FragmentOnboardingUpdateStartBinding fragmentOnboardingUpdateStartBinding = getBinding().onboardingUpdateScreenStartUpdate;
        Intrinsics.checkNotNullExpressionValue(fragmentOnboardingUpdateStartBinding, "binding.onboardingUpdateScreenStartUpdate");
        setUpdateStartView(fragmentOnboardingUpdateStartBinding);
        FragmentOtaUpdateInProgressBinding fragmentOtaUpdateInProgressBinding = getBinding().onboardingUpdateScreenInProgress;
        Intrinsics.checkNotNullExpressionValue(fragmentOtaUpdateInProgressBinding, "binding.onboardingUpdateScreenInProgress");
        setUpdateProgressView(fragmentOtaUpdateInProgressBinding);
        FragmentOtaNoUpdateBinding fragmentOtaNoUpdateBinding = getBinding().onboardingUpdateScreenNoUpdate;
        Intrinsics.checkNotNullExpressionValue(fragmentOtaNoUpdateBinding, "binding.onboardingUpdateScreenNoUpdate");
        setNoUpdateView(fragmentOtaNoUpdateBinding);
        FrameLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onResume() {
        super.onResume();
        getOnboardingUpdateViewModel().viewPrepared(UpdateSource.valueOf(getArgs().getSource()));
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("Onboarding update fragment cancelable " + getOnboardingUpdateViewModel().isCancellable() + " txt " + getContext(), new Object[0]);
        FragmentActivity activity = getActivity();
        Boolean bool = null;
        UpdateActivity updateActivity = activity instanceof UpdateActivity ? (UpdateActivity) activity : null;
        if (updateActivity != null) {
            updateActivity.setCanFinishOnTigerButton(getOnboardingUpdateViewModel().isCancellable());
        }
        Timber.Forest forest2 = Timber.Forest;
        StringBuilder sb = new StringBuilder();
        sb.append("UpdateActivity canFinishOnTigerButton ");
        FragmentActivity activity2 = getActivity();
        UpdateActivity updateActivity2 = activity2 instanceof UpdateActivity ? (UpdateActivity) activity2 : null;
        if (updateActivity2 != null) {
            bool = Boolean.valueOf(updateActivity2.getCanFinishOnTigerButton());
        }
        sb.append(bool);
        forest2.mo50221i(sb.toString(), new Object[0]);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getOnboardingUpdateViewModel().getViewState().observe(getViewLifecycleOwner(), new OnboardingUpdateFragment$$ExternalSyntheticLambda3(this));
        getOnboardingUpdateViewModel().getNavigationEvent().observe(getViewLifecycleOwner(), new OnboardingUpdateFragment$$ExternalSyntheticLambda2(this));
        getUpdateStartView().onboardingStartUpdateButton.setOnClickListener(new OnboardingUpdateFragment$$ExternalSyntheticLambda0(this));
        getUpdateStartView().onboardingCancelButton.setOnClickListener(this.onCloseClicked);
        getNoUpdateView().otaNoUpdateButton.setOnClickListener(this.onCloseClicked);
        getBatteryView().onboardingBatteryWarningButton.setOnClickListener(this.onCloseClicked);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m2487onViewCreated$lambda0(OnboardingUpdateFragment onboardingUpdateFragment, OnboardingUpdateViewModel.ViewState viewState) {
        Intrinsics.checkNotNullParameter(onboardingUpdateFragment, "this$0");
        if (viewState instanceof OnboardingUpdateViewModel.ViewState.BatteryInsufficient) {
            OnboardingUpdateViewModel.ViewState.BatteryInsufficient batteryInsufficient = (OnboardingUpdateViewModel.ViewState.BatteryInsufficient) viewState;
            onboardingUpdateFragment.showChargeRequired(batteryInsufficient.getPercent(), batteryInsufficient.isCharging(), batteryInsufficient.isCancellable());
        } else if (Intrinsics.areEqual((Object) viewState, (Object) OnboardingUpdateViewModel.ViewState.ShowProgress.INSTANCE)) {
            showUpdateProgress$default(onboardingUpdateFragment, (FirmwareUpdateStep) null, 0, 3, (Object) null);
        } else if (viewState instanceof OnboardingUpdateViewModel.ViewState.AllowUpdate) {
            onboardingUpdateFragment.showReadyToUpdate(((OnboardingUpdateViewModel.ViewState.AllowUpdate) viewState).isCancellable());
        } else if (viewState instanceof OnboardingUpdateViewModel.ViewState.ShowUpdateProgress) {
            OnboardingUpdateViewModel.ViewState.ShowUpdateProgress showUpdateProgress = (OnboardingUpdateViewModel.ViewState.ShowUpdateProgress) viewState;
            onboardingUpdateFragment.showUpdateProgress(showUpdateProgress.getUpdateStep(), showUpdateProgress.getPercent());
        } else if (Intrinsics.areEqual((Object) viewState, (Object) OnboardingUpdateViewModel.ViewState.CheckingForUpdate.INSTANCE)) {
            onboardingUpdateFragment.showCheckingForUpdate();
        } else if (Intrinsics.areEqual((Object) viewState, (Object) OnboardingUpdateViewModel.ViewState.NoUpdate.INSTANCE)) {
            onboardingUpdateFragment.showNoUpdateAvailable();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m2488onViewCreated$lambda1(OnboardingUpdateFragment onboardingUpdateFragment, OnboardingUpdateViewModel.NavigationEvent navigationEvent) {
        Intrinsics.checkNotNullParameter(onboardingUpdateFragment, "this$0");
        if (Intrinsics.areEqual((Object) navigationEvent, (Object) OnboardingUpdateViewModel.NavigationEvent.ShowError.INSTANCE)) {
            onboardingUpdateFragment.showErrorScreen();
        } else if (Intrinsics.areEqual((Object) navigationEvent, (Object) OnboardingUpdateViewModel.NavigationEvent.ShowLoginScreen.INSTANCE)) {
            onboardingUpdateFragment.showNextOnboardingScreen();
        } else if (Intrinsics.areEqual((Object) navigationEvent, (Object) OnboardingUpdateViewModel.NavigationEvent.Close.INSTANCE)) {
            onboardingUpdateFragment.closeScreen();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m2489onViewCreated$lambda2(OnboardingUpdateFragment onboardingUpdateFragment, View view) {
        Intrinsics.checkNotNullParameter(onboardingUpdateFragment, "this$0");
        onboardingUpdateFragment.getOnboardingUpdateViewModel().startUpdate();
    }

    private final void showChargeRequired(int i, boolean z, boolean z2) {
        int i2 = 8;
        getUpdateStartView().getRoot().setVisibility(8);
        getUpdateProgressView().getRoot().setVisibility(8);
        getNoUpdateView().getRoot().setVisibility(8);
        getBinding().updateLoadingSpinner.setVisibility(8);
        getBatteryView().setBatteryPercent(Integer.valueOf(i));
        getBatteryView().setIsCharging(Boolean.valueOf(z));
        getBatteryView().getRoot().setVisibility(0);
        Button button = getBatteryView().onboardingBatteryWarningButton;
        if (z2) {
            i2 = 0;
        }
        button.setVisibility(i2);
    }

    private final void showReadyToUpdate(boolean z) {
        getBatteryView().getRoot().setVisibility(8);
        getUpdateProgressView().getRoot().setVisibility(8);
        getNoUpdateView().getRoot().setVisibility(8);
        getBinding().updateLoadingSpinner.setVisibility(8);
        boolean z2 = false;
        getUpdateStartView().getRoot().setVisibility(0);
        FragmentOnboardingUpdateStartBinding updateStartView = getUpdateStartView();
        if (!getOnboardingUpdateViewModel().isForced() && z) {
            z2 = true;
        }
        updateStartView.setCancellable(z2);
    }

    static /* synthetic */ void showUpdateProgress$default(OnboardingUpdateFragment onboardingUpdateFragment, FirmwareUpdateStep firmwareUpdateStep, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            firmwareUpdateStep = FirmwareUpdateStep.DOWNLOAD_FIRMWARE;
        }
        if ((i2 & 2) != 0) {
            i = -1;
        }
        onboardingUpdateFragment.showUpdateProgress(firmwareUpdateStep, i);
    }

    private final void showUpdateProgress(FirmwareUpdateStep firmwareUpdateStep, int i) {
        getUpdateStartView().getRoot().setVisibility(8);
        getBatteryView().getRoot().setVisibility(8);
        getNoUpdateView().getRoot().setVisibility(8);
        getBinding().updateLoadingSpinner.setVisibility(8);
        getUpdateProgressView().getRoot().setVisibility(0);
        if (i != -1) {
            getUpdateProgressView().setUpdatePercent(Integer.valueOf(i));
        }
        getUpdateProgressView().setUpdateLabel(getStringFor(firmwareUpdateStep));
    }

    private final void showCheckingForUpdate() {
        getUpdateStartView().getRoot().setVisibility(8);
        getBatteryView().getRoot().setVisibility(8);
        getUpdateProgressView().getRoot().setVisibility(8);
        getNoUpdateView().getRoot().setVisibility(8);
        getBinding().updateLoadingSpinner.setVisibility(0);
    }

    private final void showNoUpdateAvailable() {
        getUpdateStartView().getRoot().setVisibility(8);
        getBatteryView().getRoot().setVisibility(8);
        getUpdateProgressView().getRoot().setVisibility(8);
        getBinding().updateLoadingSpinner.setVisibility(8);
        getNoUpdateView().getRoot().setVisibility(0);
    }

    private final void showNextOnboardingScreen() {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.action_updateFragment_to_onboardingConnectedWithInternetFragment, (Bundle) null);
    }

    private final void showErrorScreen() {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.action_updateFragment_to_onboardingErrorDialog, BundleKt.bundleOf(TuplesKt.m475to("dialogType", InfoDialogType.FIRMWARE_ERROR)));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCloseClicked$lambda-3  reason: not valid java name */
    public static final void m2486onCloseClicked$lambda3(OnboardingUpdateFragment onboardingUpdateFragment, View view) {
        Intrinsics.checkNotNullParameter(onboardingUpdateFragment, "this$0");
        onboardingUpdateFragment.closeScreen();
    }

    private final void closeScreen() {
        requireActivity().finish();
        getOnboardingUpdateViewModel().reset();
    }

    private final String getStringFor(FirmwareUpdateStep firmwareUpdateStep) {
        int i;
        int i2 = WhenMappings.$EnumSwitchMapping$0[firmwareUpdateStep.ordinal()];
        if (i2 == 1) {
            i = C2814R.string.ota_progress_downloading;
        } else if (i2 == 2) {
            i = C2814R.string.ota_progress_verifying;
        } else if (i2 == 3) {
            i = C2814R.string.ota_progress_preparing;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        String string = getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(\n        when …preparing\n        }\n    )");
        return string;
    }
}
