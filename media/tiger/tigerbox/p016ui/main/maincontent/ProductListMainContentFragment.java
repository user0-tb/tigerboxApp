package media.tiger.tigerbox.p016ui.main.maincontent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.databinding.FragmentMainContentBinding;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.common.InfoDialogFragment;
import media.tiger.tigerbox.p016ui.common.InfoDialogTypeResult;
import media.tiger.tigerbox.p016ui.common.ScrollStateHolder;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.utils.ViewExtensionsKt;

@Metadata(mo33736d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u000fH\u0016J\u001a\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006'"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductListMainContentFragment;", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentFragment;", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "", "()V", "_binding", "Lmedia/tiger/tigerbox/databinding/FragmentMainContentBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentMainContentBinding;", "outerProductListAdapter", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductRowListAdapter;", "scrollStateHolder", "Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder;", "getContent", "", "navigateToSeeMoreProducts", "rowId", "ordinal", "onBannerItemClick", "onClick", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onPause", "onProductItemClick", "product", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "onResume", "onViewCreated", "view", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductListMainContentFragment */
/* compiled from: ProductListMainContentFragment.kt */
public final class ProductListMainContentFragment extends Hilt_ProductListMainContentFragment implements BindingClickListener<Integer> {
    private FragmentMainContentBinding _binding;
    private ProductRowListAdapter outerProductListAdapter;
    private ScrollStateHolder scrollStateHolder;

    public /* bridge */ /* synthetic */ void onClick(Object obj) {
        onClick(((Number) obj).intValue());
    }

    private final FragmentMainContentBinding getBinding() {
        FragmentMainContentBinding fragmentMainContentBinding = this._binding;
        Intrinsics.checkNotNull(fragmentMainContentBinding);
        return fragmentMainContentBinding;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.scrollStateHolder = new ScrollStateHolder();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this._binding = FragmentMainContentBinding.inflate(layoutInflater, viewGroup, false);
        OnItemClickListener onItemClickListener = this;
        OnItemLongClickListener onItemLongClickListener = this;
        BindingClickListener bindingClickListener = this;
        ScrollStateHolder scrollStateHolder2 = this.scrollStateHolder;
        ProductRowListAdapter productRowListAdapter = null;
        if (scrollStateHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollStateHolder");
            scrollStateHolder2 = null;
        }
        this.outerProductListAdapter = new ProductRowListAdapter(onItemClickListener, onItemLongClickListener, bindingClickListener, scrollStateHolder2);
        RecyclerView recyclerView = getBinding().mainContentOuterRecyclerView;
        ProductRowListAdapter productRowListAdapter2 = this.outerProductListAdapter;
        if (productRowListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerProductListAdapter");
        } else {
            productRowListAdapter = productRowListAdapter2;
        }
        recyclerView.setAdapter(productRowListAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(4);
        Intrinsics.checkNotNullExpressionValue(recyclerView, "");
        ViewExtensionsKt.enforceSingleScrollDirection(recyclerView);
        getProductContentViewModel().getMainContent().observe(getViewLifecycleOwner(), new ProductListMainContentFragment$$ExternalSyntheticLambda2(this));
        getProductContentViewModel().playBatteryBelow5PercentIfNeeded();
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m2406onCreateView$lambda1(ProductListMainContentFragment productListMainContentFragment, List list) {
        Intrinsics.checkNotNullParameter(productListMainContentFragment, "this$0");
        ProductRowListAdapter productRowListAdapter = productListMainContentFragment.outerProductListAdapter;
        if (productRowListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outerProductListAdapter");
            productRowListAdapter = null;
        }
        productRowListAdapter.submitList(list);
        productListMainContentFragment.hideProgressBar();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        hideHeaderCloseButton();
        getProductContentViewModel().clearProductList();
        getProductContentViewModel().getDeviceName().observe(getViewLifecycleOwner(), new ProductListMainContentFragment$$ExternalSyntheticLambda1(this));
        getProductContentViewModel().getFailure().observe(getViewLifecycleOwner(), new ProductListMainContentFragment$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m2408onViewCreated$lambda2(ProductListMainContentFragment productListMainContentFragment, String str) {
        Intrinsics.checkNotNullParameter(productListMainContentFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(str, "name");
        productListMainContentFragment.changeHeaderTitle(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m2409onViewCreated$lambda3(ProductListMainContentFragment productListMainContentFragment, Failure failure) {
        Intrinsics.checkNotNullParameter(productListMainContentFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(failure, "failure");
        productListMainContentFragment.handleFailure(failure);
    }

    public void onResume() {
        super.onResume();
        getContent();
        requireActivity().getSupportFragmentManager().setFragmentResultListener(InfoDialogFragment.REQUEST_KEY, this, new ProductListMainContentFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-4  reason: not valid java name */
    public static final void m2407onResume$lambda4(ProductListMainContentFragment productListMainContentFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(productListMainContentFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey("RESULT_KEY")) {
            String string = bundle.getString("RESULT_KEY");
            if (string == null) {
                string = "";
            }
            if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.PRODUCT_LIST_ERROR.getText())) {
                productListMainContentFragment.getContent();
            } else if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.NO_INTERNET_ERROR.getText())) {
                productListMainContentFragment.getProductContentViewModel().confirmOfflineMode();
            }
        }
    }

    public void onPause() {
        super.onPause();
        requireActivity().getSupportFragmentManager().clearFragmentResultListener(InfoDialogFragment.REQUEST_KEY);
    }

    public void onDestroyView() {
        super.onDestroyView();
        getBinding().mainContentOuterRecyclerView.setAdapter((RecyclerView.Adapter) null);
        this._binding = null;
    }

    private final void getContent() {
        Collection value = getProductContentViewModel().getMainContent().getValue();
        if (value == null || value.isEmpty()) {
            showProgressBar();
        }
        getProductContentViewModel().getMainContent();
    }

    public void onProductItemClick(ProductDomain productDomain, int i) {
        Intrinsics.checkNotNullParameter(productDomain, "product");
        getProductContentViewModel().playProduct(productDomain, i);
    }

    public void onClick(int i) {
        navigateToSeeMoreProducts(i, -1);
    }

    public void onBannerItemClick(int i, int i2) {
        navigateToSeeMoreProducts(i, i2);
    }

    private final void navigateToSeeMoreProducts(int i, int i2) {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), ProductListMainContentFragmentDirections.Companion.actionProductListMainContentToSeeMoreProducts(i, i2));
    }
}
