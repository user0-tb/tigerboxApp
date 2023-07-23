package media.tiger.tigerbox.p016ui.main.card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentTigerTicketPurchaseBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketPurchaseViewModel;

@Metadata(mo33736d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0002J1\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020(2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002¢\u0006\u0002\u0010/J\b\u00100\u001a\u00020%H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u00061"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "args", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentTigerTicketPurchaseBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentTigerTicketPurchaseBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentTigerTicketPurchaseBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "tigerTicketPurchaseViewModel", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel;", "getTigerTicketPurchaseViewModel", "()Lmedia/tiger/tigerbox/ui/main/card/TigerTicketPurchaseViewModel;", "tigerTicketPurchaseViewModel$delegate", "Lkotlin/Lazy;", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setUpObservers", "", "showErrorDialog", "infoDialogType", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "showInfoDialog", "type", "titleArgs", "", "", "messageArgs", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;[Ljava/lang/String;)V", "showPremiumAccessReady", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseFragment */
/* compiled from: TigerTicketPurchaseFragment.kt */
public final class TigerTicketPurchaseFragment extends Hilt_TigerTicketPurchaseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TigerTicketPurchaseFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentTigerTicketPurchaseBinding;", 0))};
    private final NavArgsLazy args$delegate;
    private final AutoClearedValue binding$delegate;
    private final Lazy tigerTicketPurchaseViewModel$delegate;

    public ImageView getCloseButton() {
        return null;
    }

    public TigerTicketPurchaseFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(TigerTicketPurchaseFragmentArgs.class), new TigerTicketPurchaseFragment$special$$inlined$navArgs$1(fragment));
        Function0 tigerTicketPurchaseFragment$special$$inlined$viewModels$default$1 = new C2934xb5ec19a3(fragment);
        this.tigerTicketPurchaseViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(TigerTicketPurchaseViewModel.class), new C2935xb5ec19a4(tigerTicketPurchaseFragment$special$$inlined$viewModels$default$1), new C2936xb5ec19a5(tigerTicketPurchaseFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentTigerTicketPurchaseBinding getBinding() {
        return (FragmentTigerTicketPurchaseBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentTigerTicketPurchaseBinding fragmentTigerTicketPurchaseBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentTigerTicketPurchaseBinding);
    }

    private final TigerTicketPurchaseFragmentArgs getArgs() {
        return (TigerTicketPurchaseFragmentArgs) this.args$delegate.getValue();
    }

    private final TigerTicketPurchaseViewModel getTigerTicketPurchaseViewModel() {
        return (TigerTicketPurchaseViewModel) this.tigerTicketPurchaseViewModel$delegate.getValue();
    }

    public DialogViewModel getViewModel() {
        return getTigerTicketPurchaseViewModel();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTigerTicketPurchaseBinding inflate = FragmentTigerTicketPurchaseBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        setUpObservers();
        getTigerTicketPurchaseViewModel().purchase(getArgs().getTigerTicketCode(), getArgs().getTigerTicketPin());
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setUpObservers() {
        getTigerTicketPurchaseViewModel().getViewState().observe(getViewLifecycleOwner(), new TigerTicketPurchaseFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpObservers$lambda-0  reason: not valid java name */
    public static final void m2391setUpObservers$lambda0(TigerTicketPurchaseFragment tigerTicketPurchaseFragment, TigerTicketPurchaseViewModel.ViewState viewState) {
        Intrinsics.checkNotNullParameter(tigerTicketPurchaseFragment, "this$0");
        if (viewState instanceof TigerTicketPurchaseViewModel.ViewState.PremiumAccessReady) {
            tigerTicketPurchaseFragment.showPremiumAccessReady();
        } else if (viewState instanceof TigerTicketPurchaseViewModel.ViewState.ErrorDialog403) {
            tigerTicketPurchaseFragment.showErrorDialog(InfoDialogType.TIGERTICKET_403_ERROR);
        } else if (viewState instanceof TigerTicketPurchaseViewModel.ViewState.ErrorDialog404) {
            tigerTicketPurchaseFragment.showErrorDialog(InfoDialogType.TIGERTICKET_404_ERROR);
        } else if (viewState instanceof TigerTicketPurchaseViewModel.ViewState.ErrorDialog410) {
            tigerTicketPurchaseFragment.showErrorDialog(InfoDialogType.TIGERTICKET_410_ERROR);
        } else if (viewState instanceof TigerTicketPurchaseViewModel.ViewState.ErrorDialog429) {
            InfoDialogType infoDialogType = InfoDialogType.TIGERTICKET_429_ERROR;
            String[] strArr = (String[]) ((Object[]) new String[0]);
            String[] strArr2 = new String[1];
            String retryAfter = ((TigerTicketPurchaseViewModel.ViewState.ErrorDialog429) viewState).getRetryAfter();
            if (retryAfter == null) {
                retryAfter = "";
            }
            strArr2[0] = retryAfter;
            tigerTicketPurchaseFragment.showInfoDialog(infoDialogType, strArr, strArr2);
        } else if (viewState instanceof TigerTicketPurchaseViewModel.ViewState.ErrorDialogGeneral) {
            tigerTicketPurchaseFragment.showErrorDialog(InfoDialogType.GENERAL_ERROR);
        }
    }

    private final void showPremiumAccessReady() {
        closeSafely();
        showInfoDialog(InfoDialogType.PREMIUM_ACCESS_READY, (String[]) ((Object[]) new String[0]), (String[]) ((Object[]) new String[0]));
    }

    private final void showErrorDialog(InfoDialogType infoDialogType) {
        closeSafely();
        showInfoDialog(infoDialogType, (String[]) ((Object[]) new String[0]), (String[]) ((Object[]) new String[0]));
    }

    private final void showInfoDialog(InfoDialogType infoDialogType, String[] strArr, String[] strArr2) {
        FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType), TuplesKt.m475to("titleFormatParams", strArr), TuplesKt.m475to("messageFormatParams", strArr2)));
    }
}
