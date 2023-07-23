package media.tiger.tigerbox.p016ui.main.card;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.p003os.BundleKt;
import androidx.core.view.ViewCompat;
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
import kotlin.text.StringsKt;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentTigerTicketInputPinBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogFragment;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.common.InfoDialogTypeResult;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0002\n\u0018\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020&H\u0016J$\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00102\u001a\u000200H\u0002J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u000200H\u0002J\u0010\u00105\u001a\u0002002\u0006\u00106\u001a\u000207H\u0002J1\u00108\u001a\u0002002\u0006\u00109\u001a\u00020:2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00160<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00160<H\u0002¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u0002002\u0006\u0010\"\u001a\u00020\u0016H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006@"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "args", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "backSpaceHandler", "media/tiger/tigerbox/ui/main/card/TigerTicketInputPinFragment$backSpaceHandler$1", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinFragment$backSpaceHandler$1;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentTigerTicketInputPinBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentTigerTicketInputPinBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentTigerTicketInputPinBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "currentPin", "", "numberClickHandler", "media/tiger/tigerbox/ui/main/card/TigerTicketInputPinFragment$numberClickHandler$1", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinFragment$numberClickHandler$1;", "tigerTicketInputPinViewModel", "Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel;", "getTigerTicketInputPinViewModel", "()Lmedia/tiger/tigerbox/ui/main/card/TigerTicketInputPinViewModel;", "tigerTicketInputPinViewModel$delegate", "Lkotlin/Lazy;", "colorCodedPinText", "Landroid/text/Spanned;", "pinText", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "onResume", "setUpObservers", "setUpPin", "showConnectionFailed", "showError", "attempts", "", "showInfoDialog", "type", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "titleArgs", "", "messageArgs", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;[Ljava/lang/String;)V", "updatePin", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinFragment */
/* compiled from: TigerTicketInputPinFragment.kt */
public final class TigerTicketInputPinFragment extends Hilt_TigerTicketInputPinFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TigerTicketInputPinFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentTigerTicketInputPinBinding;", 0))};
    private final NavArgsLazy args$delegate;
    private final TigerTicketInputPinFragment$backSpaceHandler$1 backSpaceHandler = new TigerTicketInputPinFragment$backSpaceHandler$1(this);
    private final AutoClearedValue binding$delegate;
    private String currentPin = "";
    private final TigerTicketInputPinFragment$numberClickHandler$1 numberClickHandler = new TigerTicketInputPinFragment$numberClickHandler$1(this);
    private final Lazy tigerTicketInputPinViewModel$delegate;

    public TigerTicketInputPinFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(TigerTicketInputPinFragmentArgs.class), new TigerTicketInputPinFragment$special$$inlined$navArgs$1(fragment));
        Function0 tigerTicketInputPinFragment$special$$inlined$viewModels$default$1 = new C2927xc1d9408d(fragment);
        this.tigerTicketInputPinViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(TigerTicketInputPinViewModel.class), new C2928xc1d9408e(tigerTicketInputPinFragment$special$$inlined$viewModels$default$1), new C2929xc1d9408f(tigerTicketInputPinFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentTigerTicketInputPinBinding getBinding() {
        return (FragmentTigerTicketInputPinBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentTigerTicketInputPinBinding fragmentTigerTicketInputPinBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentTigerTicketInputPinBinding);
    }

    private final TigerTicketInputPinFragmentArgs getArgs() {
        return (TigerTicketInputPinFragmentArgs) this.args$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final TigerTicketInputPinViewModel getTigerTicketInputPinViewModel() {
        return (TigerTicketInputPinViewModel) this.tigerTicketInputPinViewModel$delegate.getValue();
    }

    public ImageView getCloseButton() {
        ImageButton root = getBinding().fragmentCloseButton.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.fragmentCloseButton.root");
        return root;
    }

    public DialogViewModel getViewModel() {
        return getTigerTicketInputPinViewModel();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTigerTicketInputPinBinding inflate = FragmentTigerTicketInputPinBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().setNumberClickListener(this.numberClickHandler);
        getBinding().setBackSpaceListener(this.backSpaceHandler);
        String upPin = setUpPin();
        this.currentPin = upPin;
        updatePin(upPin);
        getTigerTicketInputPinViewModel().setTigerTicketStepDomain(getArgs().getTigerTicketStepDomain());
        setUpObservers();
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onResume() {
        super.onResume();
        requireActivity().getSupportFragmentManager().setFragmentResultListener(InfoDialogFragment.REQUEST_KEY, this, new TigerTicketInputPinFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-1  reason: not valid java name */
    public static final void m2388onResume$lambda1(TigerTicketInputPinFragment tigerTicketInputPinFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(tigerTicketInputPinFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey("RESULT_KEY")) {
            String string = bundle.getString("RESULT_KEY");
            if (string == null) {
                string = "";
            }
            if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.TIGER_TICKET_REDEEM_CONFIRMED.getText())) {
                if (tigerTicketInputPinFragment.getTigerTicketInputPinViewModel().getTigerTicketStepDomain() != null) {
                    OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(tigerTicketInputPinFragment), C2814R.C2817id.action_tigetTicketPin_to_tigerTicketPurchase, BundleKt.bundleOf(TuplesKt.m475to("tigerTicketCode", tigerTicketInputPinFragment.getTigerTicketInputPinViewModel().getTicketCode()), TuplesKt.m475to("tigerTicketPin", tigerTicketInputPinFragment.getTigerTicketInputPinViewModel().getCurrentPin())));
                }
            } else if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.TIGER_TICKET_REDEEM_CANCELED.getText())) {
                tigerTicketInputPinFragment.closeSafely();
            }
        }
    }

    public void onPause() {
        super.onPause();
        requireActivity().getSupportFragmentManager().clearFragmentResultListener(InfoDialogFragment.REQUEST_KEY);
    }

    private final void setUpObservers() {
        getTigerTicketInputPinViewModel().getViewState().observe(getViewLifecycleOwner(), new TigerTicketInputPinFragment$$ExternalSyntheticLambda2(this));
        getTigerTicketInputPinViewModel().getNavigationState().observe(getViewLifecycleOwner(), new TigerTicketInputPinFragment$$ExternalSyntheticLambda1(this));
    }

    /* JADX WARNING: type inference failed for: r6v7, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r6v11, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r6v15, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r6v19, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r6v23, types: [java.lang.Object[]] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: setUpObservers$lambda-2  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2389setUpObservers$lambda2(media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinFragment r5, media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r6 instanceof media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ConnectionFailure
            if (r0 == 0) goto L_0x000e
            r5.showConnectionFailed()
            goto L_0x010e
        L_0x000e:
            boolean r0 = r6 instanceof media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialog403
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x003c
            r5.closeSafely()
            media.tiger.tigerbox.ui.common.InfoDialogType r0 = media.tiger.tigerbox.p016ui.common.InfoDialogType.TIGERTICKET_403_ERROR
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            java.lang.String[] r3 = (java.lang.String[]) r3
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog403 r6 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialog403) r6
            java.lang.String r4 = r6.getRetryAfter()
            if (r4 == 0) goto L_0x0030
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r6 = r6.getRetryAfter()
            r1[r2] = r6
            goto L_0x0037
        L_0x0030:
            java.lang.String[] r6 = new java.lang.String[r2]
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            r1 = r6
            java.lang.String[] r1 = (java.lang.String[]) r1
        L_0x0037:
            r5.showInfoDialog(r0, r3, r1)
            goto L_0x010e
        L_0x003c:
            boolean r0 = r6 instanceof media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialog404
            if (r0 == 0) goto L_0x0068
            r5.closeSafely()
            media.tiger.tigerbox.ui.common.InfoDialogType r0 = media.tiger.tigerbox.p016ui.common.InfoDialogType.TIGERTICKET_404_ERROR
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            java.lang.String[] r3 = (java.lang.String[]) r3
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog404 r6 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialog404) r6
            java.lang.String r4 = r6.getRetryAfter()
            if (r4 == 0) goto L_0x005c
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r6 = r6.getRetryAfter()
            r1[r2] = r6
            goto L_0x0063
        L_0x005c:
            java.lang.String[] r6 = new java.lang.String[r2]
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            r1 = r6
            java.lang.String[] r1 = (java.lang.String[]) r1
        L_0x0063:
            r5.showInfoDialog(r0, r3, r1)
            goto L_0x010e
        L_0x0068:
            boolean r0 = r6 instanceof media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialog410
            if (r0 == 0) goto L_0x0094
            r5.closeSafely()
            media.tiger.tigerbox.ui.common.InfoDialogType r0 = media.tiger.tigerbox.p016ui.common.InfoDialogType.TIGERTICKET_410_ERROR
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            java.lang.String[] r3 = (java.lang.String[]) r3
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog410 r6 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialog410) r6
            java.lang.String r4 = r6.getRetryAfter()
            if (r4 == 0) goto L_0x0088
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r6 = r6.getRetryAfter()
            r1[r2] = r6
            goto L_0x008f
        L_0x0088:
            java.lang.String[] r6 = new java.lang.String[r2]
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            r1 = r6
            java.lang.String[] r1 = (java.lang.String[]) r1
        L_0x008f:
            r5.showInfoDialog(r0, r3, r1)
            goto L_0x010e
        L_0x0094:
            boolean r0 = r6 instanceof media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialog429
            if (r0 == 0) goto L_0x00bf
            r5.closeSafely()
            media.tiger.tigerbox.ui.common.InfoDialogType r0 = media.tiger.tigerbox.p016ui.common.InfoDialogType.TIGERTICKET_429_ERROR
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            java.lang.String[] r3 = (java.lang.String[]) r3
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialog429 r6 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialog429) r6
            java.lang.String r4 = r6.getRetryAfter()
            if (r4 == 0) goto L_0x00b4
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r6 = r6.getRetryAfter()
            r1[r2] = r6
            goto L_0x00bb
        L_0x00b4:
            java.lang.String[] r6 = new java.lang.String[r2]
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            r1 = r6
            java.lang.String[] r1 = (java.lang.String[]) r1
        L_0x00bb:
            r5.showInfoDialog(r0, r3, r1)
            goto L_0x010e
        L_0x00bf:
            boolean r0 = r6 instanceof media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialogGeneral
            if (r0 == 0) goto L_0x00f3
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.String r4 = "TigerTicketInputPinViewModel.ViewState.ErrorDialogGeneral"
            r0.mo50221i(r4, r3)
            r5.closeSafely()
            media.tiger.tigerbox.ui.common.InfoDialogType r0 = media.tiger.tigerbox.p016ui.common.InfoDialogType.GENERAL_ERROR
            java.lang.String[] r3 = new java.lang.String[r2]
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            java.lang.String[] r3 = (java.lang.String[]) r3
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$ErrorDialogGeneral r6 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.ErrorDialogGeneral) r6
            java.lang.String r4 = r6.getRetryAfter()
            if (r4 == 0) goto L_0x00e8
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.String r6 = r6.getRetryAfter()
            r1[r2] = r6
            goto L_0x00ef
        L_0x00e8:
            java.lang.String[] r6 = new java.lang.String[r2]
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            r1 = r6
            java.lang.String[] r1 = (java.lang.String[]) r1
        L_0x00ef:
            r5.showInfoDialog(r0, r3, r1)
            goto L_0x010e
        L_0x00f3:
            boolean r0 = r6 instanceof media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.CurrentPin
            if (r0 == 0) goto L_0x0101
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$CurrentPin r6 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.CurrentPin) r6
            java.lang.String r6 = r6.getPin()
            r5.updatePin(r6)
            goto L_0x010e
        L_0x0101:
            boolean r0 = r6 instanceof media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.InvalidPin
            if (r0 == 0) goto L_0x010e
            media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState$InvalidPin r6 = (media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel.ViewState.InvalidPin) r6
            int r6 = r6.getAttempts()
            r5.showError(r6)
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinFragment.m2389setUpObservers$lambda2(media.tiger.tigerbox.ui.main.card.TigerTicketInputPinFragment, media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel$ViewState):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: setUpObservers$lambda-3  reason: not valid java name */
    public static final void m2390setUpObservers$lambda3(TigerTicketInputPinFragment tigerTicketInputPinFragment, TigerTicketInputPinViewModel.NavigationState navigationState) {
        Intrinsics.checkNotNullParameter(tigerTicketInputPinFragment, "this$0");
        if (navigationState instanceof TigerTicketInputPinViewModel.NavigationState.Cancel) {
            tigerTicketInputPinFragment.closeSafely();
        } else if (navigationState instanceof TigerTicketInputPinViewModel.NavigationState.Validated) {
            Timber.Forest forest = Timber.Forest;
            StringBuilder sb = new StringBuilder();
            sb.append("show REEDED ");
            TigerTicketInputPinViewModel.NavigationState.Validated validated = (TigerTicketInputPinViewModel.NavigationState.Validated) navigationState;
            sb.append(validated.getQuantity());
            sb.append(", ");
            sb.append(validated.getTimeunit());
            sb.append(", ");
            sb.append(validated.getNewEndDate());
            forest.mo50217e(sb.toString(), new Object[0]);
            tigerTicketInputPinFragment.showInfoDialog(InfoDialogType.TIGERTICKET_REDEEM, (String[]) ((Object[]) new String[0]), new String[]{validated.getQuantity(), validated.getTimeunit(), validated.getNewEndDate()});
        }
    }

    private final Spanned colorCodedPinText(String str) {
        if (Intrinsics.areEqual((Object) getBinding().getHasError(), (Object) true)) {
            str = StringsKt.replace$default(str, "_", "<font color=" + ('#' + Integer.toHexString(ContextCompat.getColor(requireActivity(), C2814R.C2815color.error_red) & ViewCompat.MEASURED_SIZE_MASK)) + ">_</font>", false, 4, (Object) null);
        }
        Spanned fromHtml = Html.fromHtml(str);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(coloredText)");
        return fromHtml;
    }

    private final void updatePin(String str) {
        this.currentPin = str;
        getBinding().setPinText(colorCodedPinText(str));
    }

    private final void showInfoDialog(InfoDialogType infoDialogType, String[] strArr, String[] strArr2) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("TigerTicketInputPinFragment showInfoDianlog titleArgs " + strArr + " messageArgs " + strArr2, new Object[0]);
        FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType), TuplesKt.m475to("titleFormatParams", strArr), TuplesKt.m475to("messageFormatParams", strArr2)));
    }

    private final void showError(int i) {
        getBinding().setHasError(true);
        if (i >= 0) {
            getBinding().setAttemptCount(Integer.valueOf(i));
        }
        updatePin(this.currentPin);
    }

    private final void showConnectionFailed() {
        getBinding().setHasError(true);
        updatePin(this.currentPin);
    }

    private final String setUpPin() {
        TigerTicketInputPinViewModel.ViewState value = getTigerTicketInputPinViewModel().getViewState().getValue();
        return value instanceof TigerTicketInputPinViewModel.ViewState.CurrentPin ? ((TigerTicketInputPinViewModel.ViewState.CurrentPin) value).getPin() : TigerTicketInputPinViewModel.DEFAULT_TEXT_STATE;
    }
}
