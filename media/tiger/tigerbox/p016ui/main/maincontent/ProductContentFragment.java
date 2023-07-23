package media.tiger.tigerbox.p016ui.main.maincontent;

import android.os.Bundle;
import android.view.View;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.exception.ShopLayoutFailure;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepType;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;
import timber.log.Timber;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b'\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004J\b\u0010\u0010\u001a\u00020\fH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\u001a\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0002J3\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068DX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentFragment;", "Lmedia/tiger/tigerbox/ui/main/maincontent/MainContentFragment;", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemLongClickListener;", "Lmedia/tiger/tigerbox/ui/main/maincontent/OnItemClickListener;", "()V", "productContentViewModel", "Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel;", "getProductContentViewModel", "()Lmedia/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel;", "productContentViewModel$delegate", "Lkotlin/Lazy;", "closeMultiProductCard", "", "handleFailure", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "navigateToMultiProductCard", "onDestroyView", "onItemLongClickListener", "", "product", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openMediaPlayer", "removeDownloadedProduct", "removeInfoDialogueIfPresent", "showInfoDialog", "type", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "titleArgs", "", "", "messageArgs", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;[Ljava/lang/String;)V", "startDownloadOfProduct", "supportsCardsMode", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentFragment */
/* compiled from: ProductContentFragment.kt */
public abstract class ProductContentFragment extends Hilt_ProductContentFragment implements OnItemLongClickListener, OnItemClickListener {
    private final Lazy productContentViewModel$delegate;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentFragment$WhenMappings */
    /* compiled from: ProductContentFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TigerTicketStepType.values().length];
            iArr[TigerTicketStepType.TIGER_TICKET_STEP_REMOVE_CARD.ordinal()] = 1;
            iArr[TigerTicketStepType.TIGER_TICKET_STEP_INPUT_PIN.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public boolean onItemLongClickListener(ProductDomain productDomain) {
        Intrinsics.checkNotNullParameter(productDomain, "product");
        return true;
    }

    public boolean supportsCardsMode() {
        return false;
    }

    public ProductContentFragment() {
        Fragment fragment = this;
        this.productContentViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ProductContentViewModel.class), new C2944xca4cacd0(fragment), new C2945xca4cacd1(fragment));
    }

    /* access modifiers changed from: protected */
    public final ProductContentViewModel getProductContentViewModel() {
        return (ProductContentViewModel) this.productContentViewModel$delegate.getValue();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Timber.Forest.mo50221i("ProductContentFragment onViewCreated", new Object[0]);
        getProductContentViewModel().registerListeners();
        getProductContentViewModel().getCloseMediaPlayer().observe(getViewLifecycleOwner(), new ProductContentFragment$$ExternalSyntheticLambda1(this));
        getProductContentViewModel().getMultiCardInserted().observe(getViewLifecycleOwner(), new ProductContentFragment$$ExternalSyntheticLambda0(this));
        getProductContentViewModel().getActiveError().observe(getViewLifecycleOwner(), new ProductContentFragment$$ExternalSyntheticLambda4(this));
        getProductContentViewModel().getActiveTigerTicketStep().observe(getViewLifecycleOwner(), new ProductContentFragment$$ExternalSyntheticLambda2(this));
        getProductContentViewModel().getStartedAudioProduct().observe(getViewLifecycleOwner(), new ProductContentFragment$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m2395onViewCreated$lambda0(ProductContentFragment productContentFragment, Unit unit) {
        Intrinsics.checkNotNullParameter(productContentFragment, "this$0");
        Fragment fragment = productContentFragment;
        if (Intrinsics.areEqual((Object) FragmentKt.findNavController(fragment).getBackQueue().last().getDestination(), (Object) FragmentKt.findNavController(fragment).findDestination((int) C2814R.C2817id.mainContentMediaPlayer))) {
            FragmentKt.findNavController(fragment).navigateUp();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m2396onViewCreated$lambda1(ProductContentFragment productContentFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(productContentFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        if (bool.booleanValue()) {
            productContentFragment.navigateToMultiProductCard();
        } else {
            productContentFragment.closeMultiProductCard();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m2397onViewCreated$lambda3(ProductContentFragment productContentFragment, InfoDialogType infoDialogType) {
        String[] strArr;
        Intrinsics.checkNotNullParameter(productContentFragment, "this$0");
        if (infoDialogType == null) {
            productContentFragment.removeInfoDialogueIfPresent();
        }
        if (infoDialogType == null) {
            return;
        }
        if (infoDialogType == InfoDialogType.NO_WIRELESS_SIGNAL) {
            showInfoDialog$default(productContentFragment, InfoDialogType.INTERNET_CONNECTION_FAILED_SINGLE_BUTTON, (String[]) null, (String[]) null, 6, (Object) null);
            return;
        }
        if (productContentFragment.getProductContentViewModel().getActiveErrorMessage() != null) {
            String activeErrorMessage = productContentFragment.getProductContentViewModel().getActiveErrorMessage();
            Intrinsics.checkNotNull(activeErrorMessage);
            strArr = new String[]{activeErrorMessage};
        } else {
            strArr = (String[]) ((Object[]) new String[0]);
        }
        productContentFragment.showInfoDialog(infoDialogType, (String[]) ((Object[]) new String[0]), strArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-5  reason: not valid java name */
    public static final void m2398onViewCreated$lambda5(ProductContentFragment productContentFragment, TigerTicketStepDomain tigerTicketStepDomain) {
        Intrinsics.checkNotNullParameter(productContentFragment, "this$0");
        if (tigerTicketStepDomain != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[tigerTicketStepDomain.getStep().ordinal()];
            if (i == 1) {
                OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(productContentFragment), C2814R.C2817id.action_mainContent_to_tigerTicketValid, (Bundle) null, 2, (Object) null);
            } else if (i == 2) {
                OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(productContentFragment), C2814R.C2817id.action_tigetTicketValid_to_tigerTicketPin, BundleKt.bundleOf(TuplesKt.m475to("tigerTicketStepDomain", tigerTicketStepDomain)));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-7  reason: not valid java name */
    public static final void m2399onViewCreated$lambda7(ProductContentFragment productContentFragment, AudioProductInfo audioProductInfo) {
        Intrinsics.checkNotNullParameter(productContentFragment, "this$0");
        if (audioProductInfo != null) {
            productContentFragment.openMediaPlayer();
        }
    }

    public void onResume() {
        super.onResume();
        Timber.Forest.mo50221i("ProductContentFragment onResume", new Object[0]);
    }

    private final void removeInfoDialogueIfPresent() {
        Fragment fragment = this;
        if (Intrinsics.areEqual((Object) FragmentKt.findNavController(fragment).getBackQueue().last().getDestination(), (Object) FragmentKt.findNavController(fragment).findDestination((int) C2814R.C2817id.infoDialogFragment))) {
            FragmentKt.findNavController(fragment).popBackStack();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        getProductContentViewModel().unsubscribeFromContentRefresh();
    }

    public void startDownloadOfProduct(ProductDomain productDomain) {
        Intrinsics.checkNotNullParameter(productDomain, "product");
        getProductContentViewModel().downloadProduct(productDomain);
    }

    public void removeDownloadedProduct(ProductDomain productDomain) {
        Intrinsics.checkNotNullParameter(productDomain, "product");
        getProductContentViewModel().removeDownloadedProduct(productDomain);
    }

    private final void openMediaPlayer() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_to_MediaPlayer, (Bundle) null, 2, (Object) null);
        maximizeMiniPlayer();
    }

    private final void navigateToMultiProductCard() {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), ProductListMainContentFragmentDirections.Companion.actionToMultiProductCard());
    }

    private final void closeMultiProductCard() {
        Object obj;
        NavController findNavController = FragmentKt.findNavController(this);
        NavDestination findDestination = findNavController.findDestination((int) C2814R.C2817id.offlineModeFragment);
        Iterator it = findNavController.getBackQueue().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((NavBackStackEntry) obj).getDestination(), (Object) findDestination)) {
                break;
            }
        }
        if (obj != null) {
            OnboardingActivityKt.navigateActionSafe(findNavController, ProductListMainContentFragmentDirections.Companion.actionToOfflineMode());
        } else if (!Intrinsics.areEqual((Object) findNavController.getBackQueue().last().getDestination(), (Object) findNavController.findDestination((int) C2814R.C2817id.mainContentProductList))) {
            OnboardingActivityKt.navigateActionSafe(findNavController, ProductListMainContentFragmentDirections.Companion.actionToMainContentProductList());
        }
    }

    /* access modifiers changed from: protected */
    public final void handleFailure(Failure failure) {
        Intrinsics.checkNotNullParameter(failure, "failure");
        hideProgressBar();
        if (failure instanceof Failure.NetworkConnection) {
            getProductContentViewModel().confirmOfflineMode();
            return;
        }
        if (failure instanceof ShopLayoutFailure.GetProductListNotSuccessful ? true : failure instanceof ShopLayoutFailure.ShopLayoutNotSuccessful) {
            showInfoDialog$default(this, InfoDialogType.PRODUCT_LIST_ERROR, (String[]) null, (String[]) null, 6, (Object) null);
            return;
        }
        Timber.Forest forest = Timber.Forest;
        forest.mo50217e("ProductContentFragment " + failure, new Object[0]);
    }

    public final void showInfoDialog(InfoDialogType infoDialogType, String[] strArr, String[] strArr2) {
        Intrinsics.checkNotNullParameter(infoDialogType, SessionDescription.ATTR_TYPE);
        Intrinsics.checkNotNullParameter(strArr, "titleArgs");
        Intrinsics.checkNotNullParameter(strArr2, "messageArgs");
        FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType), TuplesKt.m475to("titleFormatParams", strArr), TuplesKt.m475to("messageFormatParams", strArr2)));
    }

    public static /* synthetic */ void showInfoDialog$default(ProductContentFragment productContentFragment, InfoDialogType infoDialogType, String[] strArr, String[] strArr2, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                strArr = (String[]) ((Object[]) new String[0]);
            }
            if ((i & 4) != 0) {
                strArr2 = (String[]) ((Object[]) new String[0]);
            }
            productContentFragment.showInfoDialog(infoDialogType, strArr, strArr2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInfoDialog");
    }
}
