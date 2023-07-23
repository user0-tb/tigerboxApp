package media.tiger.tigerbox.p016ui.onboarding.step2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentOnboardingWifiListBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.common.InfoDialogFragment;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordFragment;
import media.tiger.tigerbox.p016ui.common.wifi.WifiListAdapter;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import timber.log.Timber;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\b\u0010'\u001a\u00020\u0019H\u0002J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*H\u0002J\u0016\u0010+\u001a\u00020\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030-H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0003H\u0002J\b\u00100\u001a\u00020\u0019H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u00061"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step2/OnboardingWifiListFragment;", "Landroidx/fragment/app/Fragment;", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "()V", "adapter", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiListAdapter;", "getAdapter", "()Lmedia/tiger/tigerbox/ui/common/wifi/WifiListAdapter;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentOnboardingWifiListBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingWifiListBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentOnboardingWifiListBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "onboardingWifiViewModel", "Lmedia/tiger/tigerbox/ui/onboarding/step2/OnboardingWifiViewModel;", "getOnboardingWifiViewModel", "()Lmedia/tiger/tigerbox/ui/onboarding/step2/OnboardingWifiViewModel;", "onboardingWifiViewModel$delegate", "Lkotlin/Lazy;", "disableContinueButton", "", "enableContinueButton", "onClick", "data", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "registerObservers", "showError", "error", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "showNetworks", "networkList", "", "showPasswordScreen", "wifiItem", "showUpdateScreen", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiListFragment */
/* compiled from: OnboardingWifiListFragment.kt */
public final class OnboardingWifiListFragment extends Hilt_OnboardingWifiListFragment implements BindingClickListener<WifiItem> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OnboardingWifiListFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingWifiListBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy onboardingWifiViewModel$delegate;

    public OnboardingWifiListFragment() {
        Fragment fragment = this;
        Function0 onboardingWifiListFragment$special$$inlined$viewModels$default$1 = new OnboardingWifiListFragment$special$$inlined$viewModels$default$1(fragment);
        this.onboardingWifiViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(OnboardingWifiViewModel.class), new OnboardingWifiListFragment$special$$inlined$viewModels$default$2(onboardingWifiListFragment$special$$inlined$viewModels$default$1), new OnboardingWifiListFragment$special$$inlined$viewModels$default$3(onboardingWifiListFragment$special$$inlined$viewModels$default$1, fragment));
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
    }

    /* access modifiers changed from: private */
    public final OnboardingWifiViewModel getOnboardingWifiViewModel() {
        return (OnboardingWifiViewModel) this.onboardingWifiViewModel$delegate.getValue();
    }

    private final FragmentOnboardingWifiListBinding getBinding() {
        return (FragmentOnboardingWifiListBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentOnboardingWifiListBinding fragmentOnboardingWifiListBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentOnboardingWifiListBinding);
    }

    private final WifiListAdapter getAdapter() {
        RecyclerView.Adapter adapter = getBinding().onboardingWifiListWifiList.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type media.tiger.tigerbox.ui.common.wifi.WifiListAdapter");
        return (WifiListAdapter) adapter;
    }

    private final void registerObservers() {
        getOnboardingWifiViewModel().getViewState().observe(getViewLifecycleOwner(), new OnboardingWifiListFragment$$ExternalSyntheticLambda3(this));
        getOnboardingWifiViewModel().getScanInProgress().observe(getViewLifecycleOwner(), new OnboardingWifiListFragment$$ExternalSyntheticLambda1(this));
        getOnboardingWifiViewModel().getNavigationEvent().observe(getViewLifecycleOwner(), new OnboardingWifiListFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservers$lambda-1  reason: not valid java name */
    public static final void m2481registerObservers$lambda1(OnboardingWifiListFragment onboardingWifiListFragment, WifiViewModel.ViewState viewState) {
        Intrinsics.checkNotNullParameter(onboardingWifiListFragment, "this$0");
        onboardingWifiListFragment.getBinding().onboardingWifiListContinue.setOnClickListener((View.OnClickListener) null);
        if (viewState instanceof WifiViewModel.ViewState.ShowNetworks) {
            onboardingWifiListFragment.showNetworks(((WifiViewModel.ViewState.ShowNetworks) viewState).getList());
        } else if (viewState instanceof WifiViewModel.ViewState.Connected) {
            onboardingWifiListFragment.showNetworks(((WifiViewModel.ViewState.Connected) viewState).getList());
            onboardingWifiListFragment.getBinding().onboardingWifiListWifiList.post(new OnboardingWifiListFragment$$ExternalSyntheticLambda4(onboardingWifiListFragment));
            onboardingWifiListFragment.enableContinueButton();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservers$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2482registerObservers$lambda1$lambda0(OnboardingWifiListFragment onboardingWifiListFragment) {
        Intrinsics.checkNotNullParameter(onboardingWifiListFragment, "this$0");
        try {
            onboardingWifiListFragment.getBinding().onboardingWifiListWifiList.scrollToPosition(0);
        } catch (IllegalStateException unused) {
            Timber.Forest.mo50217e("Cannot scroll, binding not available", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservers$lambda-2  reason: not valid java name */
    public static final void m2483registerObservers$lambda2(OnboardingWifiListFragment onboardingWifiListFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(onboardingWifiListFragment, "this$0");
        ProgressBar progressBar = onboardingWifiListFragment.getBinding().wifiListScanInProgress;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        progressBar.setVisibility(bool.booleanValue() ? 0 : 4);
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservers$lambda-3  reason: not valid java name */
    public static final void m2484registerObservers$lambda3(OnboardingWifiListFragment onboardingWifiListFragment, WifiViewModel.NavigationEvent navigationEvent) {
        Intrinsics.checkNotNullParameter(onboardingWifiListFragment, "this$0");
        if (navigationEvent instanceof WifiViewModel.NavigationEvent.ConnectionFailed) {
            onboardingWifiListFragment.showError(InfoDialogType.WIFI_CONNECTION_FAILED);
        } else if (navigationEvent instanceof WifiViewModel.NavigationEvent.IncorrectPassword) {
            onboardingWifiListFragment.showError(InfoDialogType.WRONG_PASSWORD);
        } else if (navigationEvent instanceof WifiViewModel.NavigationEvent.InternetConnectionFailed) {
            onboardingWifiListFragment.showError(InfoDialogType.INTERNET_CONNECTION_FAILED);
        } else if (navigationEvent instanceof WifiViewModel.NavigationEvent.AuthenticateNetwork) {
            onboardingWifiListFragment.showPasswordScreen(((WifiViewModel.NavigationEvent.AuthenticateNetwork) navigationEvent).getWifiItem());
        } else if (navigationEvent instanceof WifiViewModel.NavigationEvent.ShowUpdateScreen) {
            onboardingWifiListFragment.showUpdateScreen();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        getOnboardingWifiViewModel().setUpWifiManager();
        FragmentOnboardingWifiListBinding inflate = FragmentOnboardingWifiListBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        RecyclerView recyclerView = getBinding().onboardingWifiListWifiList;
        WifiListAdapter wifiListAdapter = new WifiListAdapter(this);
        wifiListAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        recyclerView.setAdapter(wifiListAdapter);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onResume() {
        super.onResume();
        registerObservers();
        getOnboardingWifiViewModel().viewPrepared();
        Fragment fragment = this;
        FragmentKt.setFragmentResultListener(fragment, InfoDialogFragment.REQUEST_KEY, new OnboardingWifiListFragment$onResume$1(this));
        FragmentKt.setFragmentResultListener(fragment, WifiEnterPasswordFragment.REQUEST_KEY, new OnboardingWifiListFragment$onResume$2(this));
    }

    public void onPause() {
        getOnboardingWifiViewModel().exitView();
        Fragment fragment = this;
        FragmentKt.clearFragmentResultListener(fragment, InfoDialogFragment.REQUEST_KEY);
        FragmentKt.clearFragmentResultListener(fragment, WifiEnterPasswordFragment.REQUEST_KEY);
        super.onPause();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showNetworks(java.util.List<media.tiger.tigerbox.model.domain.WifiItem> r5) {
        /*
            r4 = this;
            media.tiger.tigerbox.ui.common.wifi.WifiListAdapter r0 = r4.getAdapter()
            r0.submitList(r5)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            boolean r0 = r5 instanceof java.util.Collection
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001a
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001a
        L_0x0018:
            r1 = 0
            goto L_0x0037
        L_0x001a:
            java.util.Iterator r5 = r5.iterator()
        L_0x001e:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0018
            java.lang.Object r0 = r5.next()
            media.tiger.tigerbox.model.domain.WifiItem r0 = (media.tiger.tigerbox.model.domain.WifiItem) r0
            media.tiger.tigerbox.model.domain.ConnectionState r0 = r0.getConnectionState()
            media.tiger.tigerbox.model.domain.ConnectionState r3 = media.tiger.tigerbox.model.domain.ConnectionState.CONNECTED
            if (r0 != r3) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            if (r0 == 0) goto L_0x001e
        L_0x0037:
            if (r1 == 0) goto L_0x003d
            r4.enableContinueButton()
            goto L_0x0040
        L_0x003d:
            r4.disableContinueButton()
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.onboarding.step2.OnboardingWifiListFragment.showNetworks(java.util.List):void");
    }

    private final void showError(InfoDialogType infoDialogType) {
        OnboardingActivityKt.navigateActionSafe(androidx.navigation.fragment.FragmentKt.findNavController(this), C2814R.C2817id.action_onboardingWifiListFragment_to_onboardingErrorDialog, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType), TuplesKt.m475to("messageFormatParams", (Object[]) new String[0])));
    }

    public void onClick(WifiItem wifiItem) {
        Intrinsics.checkNotNullParameter(wifiItem, "data");
        getOnboardingWifiViewModel().networkSelected(wifiItem);
    }

    private final void disableContinueButton() {
        getBinding().onboardingWifiListContinue.setEnabled(false);
    }

    private final void enableContinueButton() {
        getBinding().onboardingWifiListContinue.setEnabled(true);
        getBinding().onboardingWifiListContinue.setOnClickListener(new OnboardingWifiListFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: enableContinueButton$lambda-6  reason: not valid java name */
    public static final void m2480enableContinueButton$lambda6(OnboardingWifiListFragment onboardingWifiListFragment, View view) {
        Intrinsics.checkNotNullParameter(onboardingWifiListFragment, "this$0");
        onboardingWifiListFragment.getOnboardingWifiViewModel().continueAction();
    }

    private final void showUpdateScreen() {
        androidx.navigation.fragment.FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.action_onboardingWifiListFragment_to_onboardingUpdateFragment);
    }

    private final void showPasswordScreen(WifiItem wifiItem) {
        androidx.navigation.fragment.FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.f586xc13459e7, BundleKt.bundleOf(TuplesKt.m475to("wifiName", wifiItem.getSsid())));
    }
}
