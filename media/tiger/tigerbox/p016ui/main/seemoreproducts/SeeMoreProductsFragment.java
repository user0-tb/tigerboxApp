package media.tiger.tigerbox.p016ui.main.seemoreproducts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
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
import media.tiger.tigerbox.p016ui.common.InfoDialogFragment;
import media.tiger.tigerbox.p016ui.common.InfoDialogTypeResult;
import media.tiger.tigerbox.p016ui.main.seemoreproducts.ProductListItem;

@Metadata(mo33736d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006("}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreProductsFragment;", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentFragment;", "()V", "args", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreProductsFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreProductsFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentMainContentSeeMoreProductsBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentMainContentSeeMoreProductsBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentMainContentSeeMoreProductsBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "seeMoreListAdapter", "Lmedia/tiger/tigerbox/ui/main/seemoreproducts/SeeMoreListAdapter;", "navigateToMainContent", "", "onBannerItemClick", "rowId", "", "ordinal", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onProductItemClick", "product", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "onViewCreated", "view", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragment */
/* compiled from: SeeMoreProductsFragment.kt */
public final class SeeMoreProductsFragment extends Hilt_SeeMoreProductsFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SeeMoreProductsFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentMainContentSeeMoreProductsBinding;", 0))};
    private final NavArgsLazy args$delegate;
    private final AutoClearedValue binding$delegate;
    private SeeMoreListAdapter seeMoreListAdapter;

    public void onBannerItemClick(int i, int i2) {
    }

    public SeeMoreProductsFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(SeeMoreProductsFragmentArgs.class), new SeeMoreProductsFragment$special$$inlined$navArgs$1(fragment));
    }

    private final FragmentMainContentSeeMoreProductsBinding getBinding() {
        return (FragmentMainContentSeeMoreProductsBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentMainContentSeeMoreProductsBinding fragmentMainContentSeeMoreProductsBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentMainContentSeeMoreProductsBinding);
    }

    private final SeeMoreProductsFragmentArgs getArgs() {
        return (SeeMoreProductsFragmentArgs) this.args$delegate.getValue();
    }

    public void onProductItemClick(ProductDomain productDomain, int i) {
        Intrinsics.checkNotNullParameter(productDomain, "product");
        getProductContentViewModel().playProduct(productDomain, -1);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMainContentSeeMoreProductsBinding inflate = FragmentMainContentSeeMoreProductsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        this.seeMoreListAdapter = new SeeMoreListAdapter(this, this, (String) null, 4, (DefaultConstructorMarker) null);
        RecyclerView recyclerView = getBinding().seeMoreRecyclerView;
        SeeMoreListAdapter seeMoreListAdapter2 = this.seeMoreListAdapter;
        if (seeMoreListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seeMoreListAdapter");
            seeMoreListAdapter2 = null;
        }
        recyclerView.setAdapter(seeMoreListAdapter2);
        recyclerView.setHasFixedSize(true);
        getProductContentViewModel().clearProductList();
        getProductContentViewModel().getProductList().observe(getViewLifecycleOwner(), new SeeMoreProductsFragment$$ExternalSyntheticLambda2(this));
        getProductContentViewModel().getLoadingListInProgress().observe(getViewLifecycleOwner(), new SeeMoreProductsFragment$$ExternalSyntheticLambda1(this));
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-2  reason: not valid java name */
    public static final void m2469onCreateView$lambda2(SeeMoreProductsFragment seeMoreProductsFragment, List list) {
        Intrinsics.checkNotNullParameter(seeMoreProductsFragment, "this$0");
        SeeMoreListAdapter seeMoreListAdapter2 = seeMoreProductsFragment.seeMoreListAdapter;
        if (seeMoreListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("seeMoreListAdapter");
            seeMoreListAdapter2 = null;
        }
        Intrinsics.checkNotNullExpressionValue(list, "it");
        Iterable<ProductDomain> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProductDomain productItem : iterable) {
            arrayList.add(new ProductListItem.ProductItem(productItem));
        }
        seeMoreListAdapter2.submitList((List) arrayList);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-3  reason: not valid java name */
    public static final void m2470onCreateView$lambda3(SeeMoreProductsFragment seeMoreProductsFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(seeMoreProductsFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "loadInProgress");
        if (bool.booleanValue()) {
            seeMoreProductsFragment.showProgressBar();
        } else {
            seeMoreProductsFragment.hideProgressBar();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0072, code lost:
        if (r1 == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00aa, code lost:
        if (r1 == null) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r6, android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            super.onViewCreated(r6, r7)
            androidx.fragment.app.FragmentActivity r6 = r5.requireActivity()
            androidx.fragment.app.FragmentManager r6 = r6.getSupportFragmentManager()
            r7 = r5
            androidx.lifecycle.LifecycleOwner r7 = (androidx.lifecycle.LifecycleOwner) r7
            media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragment$$ExternalSyntheticLambda0 r0 = new media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragment$$ExternalSyntheticLambda0
            r0.<init>(r5)
            java.lang.String r1 = "ERROR_DIALOG_FRAGMENT_REQUEST_KEY"
            r6.setFragmentResultListener(r1, r7, r0)
            r5.showHeaderCloseButton()
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel r6 = r5.getProductContentViewModel()
            androidx.lifecycle.LiveData r6 = r6.getMainContent()
            java.lang.Object r6 = r6.getValue()
            java.util.List r6 = (java.util.List) r6
            r7 = 1
            r0 = 0
            r1 = 0
            if (r6 == 0) goto L_0x005e
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r6 = r6.iterator()
        L_0x0039:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x005a
            java.lang.Object r2 = r6.next()
            r3 = r2
            media.tiger.tigerbox.model.domain.ProductRowDomain r3 = (media.tiger.tigerbox.model.domain.ProductRowDomain) r3
            int r3 = r3.getId()
            media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragmentArgs r4 = r5.getArgs()
            int r4 = r4.getRowId()
            if (r3 != r4) goto L_0x0056
            r3 = 1
            goto L_0x0057
        L_0x0056:
            r3 = 0
        L_0x0057:
            if (r3 == 0) goto L_0x0039
            goto L_0x005b
        L_0x005a:
            r2 = r1
        L_0x005b:
            media.tiger.tigerbox.model.domain.ProductRowDomain r2 = (media.tiger.tigerbox.model.domain.ProductRowDomain) r2
            goto L_0x005f
        L_0x005e:
            r2 = r1
        L_0x005f:
            media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragmentArgs r6 = r5.getArgs()
            int r6 = r6.getOrdinal()
            r3 = -1
            java.lang.String r4 = ""
            if (r6 != r3) goto L_0x0077
            if (r2 == 0) goto L_0x0072
            java.lang.String r1 = r2.getTitle()
        L_0x0072:
            if (r1 != 0) goto L_0x0075
            goto L_0x00ac
        L_0x0075:
            r4 = r1
            goto L_0x00ac
        L_0x0077:
            if (r2 == 0) goto L_0x007e
            java.util.List r6 = r2.getBannerProducts()
            goto L_0x007f
        L_0x007e:
            r6 = r1
        L_0x007f:
            java.util.Collection r6 = (java.util.Collection) r6
            if (r6 == 0) goto L_0x008b
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r7 = 0
        L_0x008b:
            if (r7 == 0) goto L_0x008e
            goto L_0x00ac
        L_0x008e:
            if (r2 == 0) goto L_0x00aa
            java.util.List r6 = r2.getBannerProducts()
            if (r6 == 0) goto L_0x00aa
            media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragmentArgs r7 = r5.getArgs()
            int r7 = r7.getOrdinal()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.getOrNull(r6, r7)
            media.tiger.tigerbox.model.domain.BannerProductDomain r6 = (media.tiger.tigerbox.model.domain.BannerProductDomain) r6
            if (r6 == 0) goto L_0x00aa
            java.lang.String r1 = r6.getTitle()
        L_0x00aa:
            if (r1 != 0) goto L_0x0075
        L_0x00ac:
            r5.changeHeaderTitle(r4)
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel r6 = r5.getProductContentViewModel()
            media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragmentArgs r7 = r5.getArgs()
            int r7 = r7.getRowId()
            media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragmentArgs r0 = r5.getArgs()
            int r0 = r0.getOrdinal()
            r6.getProductList(r7, r0)
            media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel r6 = r5.getProductContentViewModel()
            androidx.lifecycle.LiveData r6 = r6.getFailure()
            androidx.lifecycle.LifecycleOwner r7 = r5.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragment$$ExternalSyntheticLambda3 r0 = new media.tiger.tigerbox.ui.main.seemoreproducts.SeeMoreProductsFragment$$ExternalSyntheticLambda3
            r0.<init>(r5)
            r6.observe(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.seemoreproducts.SeeMoreProductsFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-4  reason: not valid java name */
    public static final void m2471onViewCreated$lambda4(SeeMoreProductsFragment seeMoreProductsFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(seeMoreProductsFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey("RESULT_KEY")) {
            String string = bundle.getString("RESULT_KEY");
            if (string == null) {
                string = "";
            }
            if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.PRODUCT_LIST_ERROR.getText())) {
                seeMoreProductsFragment.navigateToMainContent();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-6  reason: not valid java name */
    public static final void m2472onViewCreated$lambda6(SeeMoreProductsFragment seeMoreProductsFragment, Failure failure) {
        Intrinsics.checkNotNullParameter(seeMoreProductsFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(failure, "failure");
        seeMoreProductsFragment.handleFailure(failure);
    }

    public void onPause() {
        super.onPause();
        requireActivity().getSupportFragmentManager().clearFragmentResultListener(InfoDialogFragment.REQUEST_KEY);
    }

    private final void navigateToMainContent() {
        FragmentKt.findNavController(this).navigateUp();
    }
}
