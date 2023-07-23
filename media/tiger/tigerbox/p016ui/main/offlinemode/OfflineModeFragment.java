package media.tiger.tigerbox.p016ui.main.offlinemode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentOfflineModeBinding;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.p016ui.common.InfoDialogFragment;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.common.InfoDialogTypeResult;
import media.tiger.tigerbox.p016ui.main.maincontent.OnItemLongClickListener;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductContentFragment;
import media.tiger.tigerbox.p016ui.main.seemoreproducts.SeeMoreListAdapter;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;

@Metadata(mo33736d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\u0018\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010%\u001a\u00020\u0011H\u0002J\u0006\u0010&\u001a\u00020\u0011R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006'"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/offlinemode/OfflineModeFragment;", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentFragment;", "()V", "_binding", "Lmedia/tiger/tigerbox/databinding/FragmentOfflineModeBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentOfflineModeBinding;", "offlineListAdapter", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter;", "offlineModeViewModel", "Lmedia/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel;", "getOfflineModeViewModel", "()Lmedia/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel;", "offlineModeViewModel$delegate", "Lkotlin/Lazy;", "onBannerItemClick", "", "rowId", "", "ordinal", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onProductItemClick", "product", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "onResume", "onViewCreated", "view", "prepareView", "showWifiList", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeFragment */
/* compiled from: OfflineModeFragment.kt */
public final class OfflineModeFragment extends Hilt_OfflineModeFragment {
    private FragmentOfflineModeBinding _binding;
    private SeeMoreListAdapter offlineListAdapter;
    private final Lazy offlineModeViewModel$delegate;

    public void onBannerItemClick(int i, int i2) {
    }

    public OfflineModeFragment() {
        Fragment fragment = this;
        Function0 offlineModeFragment$special$$inlined$viewModels$default$1 = new OfflineModeFragment$special$$inlined$viewModels$default$1(fragment);
        this.offlineModeViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(OfflineModeViewModel.class), new OfflineModeFragment$special$$inlined$viewModels$default$2(offlineModeFragment$special$$inlined$viewModels$default$1), new OfflineModeFragment$special$$inlined$viewModels$default$3(offlineModeFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentOfflineModeBinding getBinding() {
        FragmentOfflineModeBinding fragmentOfflineModeBinding = this._binding;
        Intrinsics.checkNotNull(fragmentOfflineModeBinding);
        return fragmentOfflineModeBinding;
    }

    private final OfflineModeViewModel getOfflineModeViewModel() {
        return (OfflineModeViewModel) this.offlineModeViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        boolean z = false;
        this._binding = FragmentOfflineModeBinding.inflate(layoutInflater, viewGroup, false);
        CharSequence offlineRowTitle = getProductContentViewModel().getOfflineRowTitle();
        if (offlineRowTitle.length() == 0) {
            z = true;
        }
        if (z) {
            offlineRowTitle = getString(C2814R.string.offline_row_title);
            Intrinsics.checkNotNullExpressionValue(offlineRowTitle, "getString(R.string.offline_row_title)");
        }
        SeeMoreListAdapter seeMoreListAdapter = null;
        this.offlineListAdapter = new SeeMoreListAdapter(this, (OnItemLongClickListener) null, (String) offlineRowTitle);
        RecyclerView recyclerView = getBinding().offlineModeParentRecyclerView;
        SeeMoreListAdapter seeMoreListAdapter2 = this.offlineListAdapter;
        if (seeMoreListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineListAdapter");
        } else {
            seeMoreListAdapter = seeMoreListAdapter2;
        }
        recyclerView.setAdapter(seeMoreListAdapter);
        getBinding().offlineModeParentRecyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        getBinding().offlineModeParentRecyclerView.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new OfflineModeFragment$onCreateView$1());
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getProductContentViewModel().getDeviceName().observe(getViewLifecycleOwner(), new OfflineModeFragment$$ExternalSyntheticLambda1(this));
        getOfflineModeViewModel().getTimeLimitError().observe(getViewLifecycleOwner(), new OfflineModeFragment$$ExternalSyntheticLambda3(this));
        getOfflineModeViewModel().registerListeners();
        getOfflineModeViewModel().getDownloadedContent().observe(getViewLifecycleOwner(), new OfflineModeFragment$$ExternalSyntheticLambda2(this));
        SeeMoreListAdapter seeMoreListAdapter = this.offlineListAdapter;
        if (seeMoreListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineListAdapter");
            seeMoreListAdapter = null;
        }
        seeMoreListAdapter.addHeaderAndSubmitList(getOfflineModeViewModel().getDownloaded());
        prepareView();
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m2454onViewCreated$lambda1(OfflineModeFragment offlineModeFragment, String str) {
        Intrinsics.checkNotNullParameter(offlineModeFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(str, "name");
        offlineModeFragment.changeHeaderTitle(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m2455onViewCreated$lambda3(OfflineModeFragment offlineModeFragment, InfoDialogType infoDialogType) {
        Intrinsics.checkNotNullParameter(offlineModeFragment, "this$0");
        if (infoDialogType != null) {
            if (infoDialogType == InfoDialogType.FINAL_SYNC_WARNING) {
                SeeMoreListAdapter seeMoreListAdapter = offlineModeFragment.offlineListAdapter;
                if (seeMoreListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offlineListAdapter");
                    seeMoreListAdapter = null;
                }
                seeMoreListAdapter.submitList(CollectionsKt.emptyList());
                offlineModeFragment.getBinding().offlineModeOfflineModeContainer.setVisibility(0);
            }
            if (offlineModeFragment.getOfflineModeViewModel().getShouldDisplayTimeWarningDialog()) {
                ProductContentFragment.showInfoDialog$default(offlineModeFragment, infoDialogType, (String[]) null, (String[]) null, 6, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m2456onViewCreated$lambda4(OfflineModeFragment offlineModeFragment, List list) {
        Intrinsics.checkNotNullParameter(offlineModeFragment, "this$0");
        SeeMoreListAdapter seeMoreListAdapter = offlineModeFragment.offlineListAdapter;
        if (seeMoreListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineListAdapter");
            seeMoreListAdapter = null;
        }
        Intrinsics.checkNotNullExpressionValue(list, "it");
        seeMoreListAdapter.addHeaderAndSubmitList(list);
        offlineModeFragment.prepareView();
    }

    public void onResume() {
        super.onResume();
        requireActivity().getSupportFragmentManager().setFragmentResultListener(InfoDialogFragment.REQUEST_KEY, this, new OfflineModeFragment$$ExternalSyntheticLambda0(this));
        getOfflineModeViewModel().checkOfflineTimeLimit();
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-5  reason: not valid java name */
    public static final void m2453onResume$lambda5(OfflineModeFragment offlineModeFragment, String str, Bundle bundle) {
        boolean z;
        Intrinsics.checkNotNullParameter(offlineModeFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey("RESULT_KEY")) {
            String string = bundle.getString("RESULT_KEY");
            if (string == null) {
                string = "";
            }
            boolean z2 = true;
            if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.CONFIRM_SYNC.getText())) {
                z = true;
            } else {
                z = Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.SELECT_WIFI_NETWORKS.getText());
            }
            if (!z) {
                z2 = Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.CONFIRM_SYNC_FINAL.getText());
            }
            if (z2) {
                offlineModeFragment.getOfflineModeViewModel().enableWifi();
            }
        }
    }

    public void onPause() {
        super.onPause();
        requireActivity().getSupportFragmentManager().clearFragmentResultListener(InfoDialogFragment.REQUEST_KEY);
    }

    public void onDestroyView() {
        super.onDestroyView();
        getOfflineModeViewModel().unregisterListeners();
        getBinding().offlineModeParentRecyclerView.setAdapter((RecyclerView.Adapter) null);
        this._binding = null;
    }

    public void onProductItemClick(ProductDomain productDomain, int i) {
        Intrinsics.checkNotNullParameter(productDomain, "product");
        getProductContentViewModel().playProduct(productDomain, 1000);
    }

    private final void prepareView() {
        hideHeaderCloseButton();
        hideProgressBar();
        LinearLayout linearLayout = getBinding().offlineModeOfflineModeContainer;
        SeeMoreListAdapter seeMoreListAdapter = this.offlineListAdapter;
        if (seeMoreListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineListAdapter");
            seeMoreListAdapter = null;
        }
        linearLayout.setVisibility(seeMoreListAdapter.getCurrentList().isEmpty() ? 0 : 8);
    }

    public final void showWifiList() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_offlineModeFragment_to_settingsWifiListFragment, (Bundle) null, 2, (Object) null);
    }
}
