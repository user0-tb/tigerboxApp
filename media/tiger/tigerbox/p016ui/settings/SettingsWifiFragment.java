package media.tiger.tigerbox.p016ui.settings;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
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
import media.tiger.tigerbox.databinding.FragmentSettingsWifiListBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogFragment;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordFragment;
import media.tiger.tigerbox.p016ui.common.wifi.WifiListAdapter;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020&H\u0016J\u001a\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010,\u001a\u00020&H\u0002J\u0010\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0002J\u0016\u00100\u001a\u00020&2\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\u0010\u00104\u001a\u00020&2\u0006\u00105\u001a\u000203H\u0002J\b\u00106\u001a\u00020&H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8B@BX\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u00067"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsWifiFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenDialogFragment;", "()V", "adapter", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiListAdapter;", "getAdapter", "()Lmedia/tiger/tigerbox/ui/common/wifi/WifiListAdapter;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentSettingsWifiListBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentSettingsWifiListBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentSettingsWifiListBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "onWifiItemClickHandler", "media/tiger/tigerbox/ui/settings/SettingsWifiFragment$onWifiItemClickHandler$1", "Lmedia/tiger/tigerbox/ui/settings/SettingsWifiFragment$onWifiItemClickHandler$1;", "settingsWifiViewModel", "Lmedia/tiger/tigerbox/ui/settings/SettingsWifiViewModel;", "getSettingsWifiViewModel", "()Lmedia/tiger/tigerbox/ui/settings/SettingsWifiViewModel;", "settingsWifiViewModel$delegate", "Lkotlin/Lazy;", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "", "dialog", "Landroid/content/DialogInterface;", "onResume", "onViewCreated", "view", "registerObservers", "showError", "error", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "showNetworks", "networkList", "", "Lmedia/tiger/tigerbox/model/domain/WifiItem;", "showPasswordScreen", "wifiItem", "unregisterObservers", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsWifiFragment */
/* compiled from: SettingsWifiFragment.kt */
public final class SettingsWifiFragment extends Hilt_SettingsWifiFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SettingsWifiFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentSettingsWifiListBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final SettingsWifiFragment$onWifiItemClickHandler$1 onWifiItemClickHandler = new SettingsWifiFragment$onWifiItemClickHandler$1(this);
    private final Lazy settingsWifiViewModel$delegate;

    public SettingsWifiFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 settingsWifiFragment$special$$inlined$viewModels$default$1 = new SettingsWifiFragment$special$$inlined$viewModels$default$1(fragment);
        this.settingsWifiViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SettingsWifiViewModel.class), new SettingsWifiFragment$special$$inlined$viewModels$default$2(settingsWifiFragment$special$$inlined$viewModels$default$1), new SettingsWifiFragment$special$$inlined$viewModels$default$3(settingsWifiFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentSettingsWifiListBinding getBinding() {
        return (FragmentSettingsWifiListBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentSettingsWifiListBinding fragmentSettingsWifiListBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentSettingsWifiListBinding);
    }

    /* access modifiers changed from: private */
    public final SettingsWifiViewModel getSettingsWifiViewModel() {
        return (SettingsWifiViewModel) this.settingsWifiViewModel$delegate.getValue();
    }

    private final WifiListAdapter getAdapter() {
        RecyclerView.Adapter adapter = getBinding().settingsWifiListList.getAdapter();
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type media.tiger.tigerbox.ui.common.wifi.WifiListAdapter");
        return (WifiListAdapter) adapter;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSettingsWifiListBinding inflate = FragmentSettingsWifiListBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        RecyclerView recyclerView = getBinding().settingsWifiListList;
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), 1));
        WifiListAdapter wifiListAdapter = new WifiListAdapter(this.onWifiItemClickHandler);
        wifiListAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        recyclerView.setAdapter(wifiListAdapter);
        LinearLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getSettingsWifiViewModel().startScanning();
    }

    public void onResume() {
        super.onResume();
        registerObservers();
        getSettingsWifiViewModel().viewPrepared();
        Fragment fragment = this;
        FragmentKt.setFragmentResultListener(fragment, InfoDialogFragment.REQUEST_KEY, new SettingsWifiFragment$onResume$1(this));
        FragmentKt.setFragmentResultListener(fragment, WifiEnterPasswordFragment.REQUEST_KEY, new SettingsWifiFragment$onResume$2(this));
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        getSettingsWifiViewModel().stopScanning();
        getSettingsWifiViewModel().exitView();
        unregisterObservers();
        Fragment fragment = this;
        FragmentKt.clearFragmentResultListener(fragment, InfoDialogFragment.REQUEST_KEY);
        FragmentKt.clearFragmentResultListener(fragment, WifiEnterPasswordFragment.REQUEST_KEY);
        super.onDismiss(dialogInterface);
    }

    public DialogViewModel getViewModel() {
        return getSettingsWifiViewModel();
    }

    public ImageView getCloseButton() {
        ImageButton root = getBinding().fragmentCloseButton.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.fragmentCloseButton.root");
        return root;
    }

    private final void showNetworks(List<WifiItem> list) {
        getAdapter().submitList(list);
    }

    private final void showPasswordScreen(WifiItem wifiItem) {
        OnboardingActivityKt.navigateActionSafe(androidx.navigation.fragment.FragmentKt.findNavController(this), C2814R.C2817id.action_settingsWifiListFragment_to_wifiEnterPasswordFragment, BundleKt.bundleOf(TuplesKt.m475to("wifiName", wifiItem.getSsid())));
    }

    private final void showError(InfoDialogType infoDialogType) {
        androidx.navigation.fragment.FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType), TuplesKt.m475to("messageFormatParams", (Object[]) new String[0])));
    }

    private final void registerObservers() {
        getSettingsWifiViewModel().getViewState().observe(getViewLifecycleOwner(), new SettingsWifiFragment$$ExternalSyntheticLambda2(this));
        getSettingsWifiViewModel().getScanInProgress().observe(getViewLifecycleOwner(), new SettingsWifiFragment$$ExternalSyntheticLambda0(this));
        getSettingsWifiViewModel().getNavigationEvent().observe(getViewLifecycleOwner(), new SettingsWifiFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservers$lambda-2  reason: not valid java name */
    public static final void m2531registerObservers$lambda2(SettingsWifiFragment settingsWifiFragment, WifiViewModel.ViewState viewState) {
        Intrinsics.checkNotNullParameter(settingsWifiFragment, "this$0");
        if (viewState instanceof WifiViewModel.ViewState.ShowNetworks) {
            settingsWifiFragment.showNetworks(((WifiViewModel.ViewState.ShowNetworks) viewState).getList());
        } else if (viewState instanceof WifiViewModel.ViewState.Connected) {
            settingsWifiFragment.showNetworks(((WifiViewModel.ViewState.Connected) viewState).getList());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservers$lambda-3  reason: not valid java name */
    public static final void m2532registerObservers$lambda3(SettingsWifiFragment settingsWifiFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(settingsWifiFragment, "this$0");
        ProgressBar progressBar = settingsWifiFragment.getBinding().wifiListScanInProgress;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        progressBar.setVisibility(bool.booleanValue() ? 0 : 4);
    }

    /* access modifiers changed from: private */
    /* renamed from: registerObservers$lambda-4  reason: not valid java name */
    public static final void m2533registerObservers$lambda4(SettingsWifiFragment settingsWifiFragment, WifiViewModel.NavigationEvent navigationEvent) {
        Intrinsics.checkNotNullParameter(settingsWifiFragment, "this$0");
        if (Intrinsics.areEqual((Object) navigationEvent, (Object) WifiViewModel.NavigationEvent.ConnectionFailed.INSTANCE)) {
            settingsWifiFragment.showError(InfoDialogType.WIFI_CONNECTION_FAILED);
        } else if (Intrinsics.areEqual((Object) navigationEvent, (Object) WifiViewModel.NavigationEvent.IncorrectPassword.INSTANCE)) {
            settingsWifiFragment.showError(InfoDialogType.WRONG_PASSWORD);
        } else if (Intrinsics.areEqual((Object) navigationEvent, (Object) WifiViewModel.NavigationEvent.InternetConnectionFailed.INSTANCE)) {
            settingsWifiFragment.showError(InfoDialogType.INTERNET_CONNECTION_FAILED);
        } else if (navigationEvent instanceof WifiViewModel.NavigationEvent.AuthenticateNetwork) {
            settingsWifiFragment.showPasswordScreen(((WifiViewModel.NavigationEvent.AuthenticateNetwork) navigationEvent).getWifiItem());
        } else if (Intrinsics.areEqual((Object) navigationEvent, (Object) WifiViewModel.NavigationEvent.ShowUpdateScreen.INSTANCE)) {
            Timber.Forest.mo50217e("SettingsWifiViewModel: UpdateRequired not used in SettingsWifiViewModel", new Object[0]);
            settingsWifiFragment.getSettingsWifiViewModel().sendDeviceInformation();
        }
    }

    private final void unregisterObservers() {
        getSettingsWifiViewModel().getViewState().removeObservers(getViewLifecycleOwner());
        getSettingsWifiViewModel().getNavigationEvent().removeObservers(getViewLifecycleOwner());
        getSettingsWifiViewModel().getScanInProgress().removeObservers(getViewLifecycleOwner());
    }
}
