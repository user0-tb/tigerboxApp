package media.tiger.tigerbox.p016ui.main.multiproductcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.databinding.FragmentMainContentSeeMoreProductsBinding;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.p016ui.main.seemoreproducts.ProductListItem;
import media.tiger.tigerbox.p016ui.main.seemoreproducts.SeeMoreListAdapter;

@Metadata(mo33736d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010!\u001a\u00020\"H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006#"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/multiproductcard/MultiProductCardFragment;", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentMainContentSeeMoreProductsBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentMainContentSeeMoreProductsBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentMainContentSeeMoreProductsBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "multiProductCardListAdapter", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter;", "onBannerItemClick", "", "rowId", "", "ordinal", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onProductItemClick", "product", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "onViewCreated", "view", "supportsCardsMode", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.main.multiproductcard.MultiProductCardFragment */
/* compiled from: MultiProductCardFragment.kt */
public final class MultiProductCardFragment extends Hilt_MultiProductCardFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MultiProductCardFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentMainContentSeeMoreProductsBinding;", 0))};
    private final AutoClearedValue binding$delegate = AutoClearedValueKt.autoCleared(this);
    private SeeMoreListAdapter multiProductCardListAdapter;

    public void onBannerItemClick(int i, int i2) {
    }

    public boolean supportsCardsMode() {
        return true;
    }

    private final FragmentMainContentSeeMoreProductsBinding getBinding() {
        return (FragmentMainContentSeeMoreProductsBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentMainContentSeeMoreProductsBinding fragmentMainContentSeeMoreProductsBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentMainContentSeeMoreProductsBinding);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMainContentSeeMoreProductsBinding inflate = FragmentMainContentSeeMoreProductsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        this.multiProductCardListAdapter = new SeeMoreListAdapter(this, this, (String) null, 4, (DefaultConstructorMarker) null);
        RecyclerView recyclerView = getBinding().seeMoreRecyclerView;
        SeeMoreListAdapter seeMoreListAdapter = this.multiProductCardListAdapter;
        if (seeMoreListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiProductCardListAdapter");
            seeMoreListAdapter = null;
        }
        recyclerView.setAdapter(seeMoreListAdapter);
        recyclerView.setHasFixedSize(true);
        getProductContentViewModel().clearProductList();
        getProductContentViewModel().getProductList().observe(getViewLifecycleOwner(), new MultiProductCardFragment$$ExternalSyntheticLambda0(this));
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-2  reason: not valid java name */
    public static final void m2449onCreateView$lambda2(MultiProductCardFragment multiProductCardFragment, List list) {
        Intrinsics.checkNotNullParameter(multiProductCardFragment, "this$0");
        SeeMoreListAdapter seeMoreListAdapter = multiProductCardFragment.multiProductCardListAdapter;
        if (seeMoreListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiProductCardListAdapter");
            seeMoreListAdapter = null;
        }
        Intrinsics.checkNotNullExpressionValue(list, "it");
        Iterable<ProductDomain> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProductDomain productItem : iterable) {
            arrayList.add(new ProductListItem.ProductItem(productItem));
        }
        seeMoreListAdapter.submitList((List) arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0015, code lost:
        r2 = r2.getMultiTigercardVariant();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r2, android.os.Bundle r3) {
        /*
            r1 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            super.onViewCreated(r2, r3)
            r1.showHeaderCloseButton()
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel r2 = r1.getProductContentViewModel()
            media.tiger.tigerbox.services.interfaces.TigerCardDomain r2 = r2.getMultiProductTigerCard()
            if (r2 == 0) goto L_0x0020
            media.tiger.tigerbox.services.interfaces.TigerCardDomain$MultiTigercardVariantDomain r2 = r2.getMultiTigercardVariant()
            if (r2 == 0) goto L_0x0020
            java.lang.String r2 = r2.getName()
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r2 != 0) goto L_0x0025
            java.lang.String r2 = ""
        L_0x0025:
            r1.changeHeaderTitle(r2)
            r1.showMultiProductListInCardsMode()
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel r2 = r1.getProductContentViewModel()
            r2.showMultiProductList()
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel r2 = r1.getProductContentViewModel()
            androidx.lifecycle.LiveData r2 = r2.getFailure()
            androidx.lifecycle.LifecycleOwner r3 = r1.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.main.multiproductcard.MultiProductCardFragment$$ExternalSyntheticLambda1 r0 = new media.tiger.tigerbox.ui.main.multiproductcard.MultiProductCardFragment$$ExternalSyntheticLambda1
            r0.<init>(r1)
            r2.observe(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.multiproductcard.MultiProductCardFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m2450onViewCreated$lambda3(MultiProductCardFragment multiProductCardFragment, Failure failure) {
        Intrinsics.checkNotNullParameter(multiProductCardFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(failure, "failure");
        multiProductCardFragment.handleFailure(failure);
    }

    public void onDestroyView() {
        hideMultiProductListInCardsMode();
        super.onDestroyView();
    }

    public void onProductItemClick(ProductDomain productDomain, int i) {
        Intrinsics.checkNotNullParameter(productDomain, "product");
        getProductContentViewModel().playProduct(productDomain, -1);
    }
}
