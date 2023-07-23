package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import android.os.Bundle;
import android.os.IBinder;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
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
import media.tiger.tigerbox.databinding.FragmentTicketRedeemTicketNumberInputBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J1\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002¢\u0006\u0002\u0010-J1\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002¢\u0006\u0002\u0010-R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u00060"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberDialogFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentTicketRedeemTicketNumberInputBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentTicketRedeemTicketNumberInputBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentTicketRedeemTicketNumberInputBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "ticketRedeemTicketNumberDialogViewModel", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel;", "getTicketRedeemTicketNumberDialogViewModel", "()Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/TicketRedeemTicketNumberViewModel;", "ticketRedeemTicketNumberDialogViewModel$delegate", "Lkotlin/Lazy;", "closeSafely", "", "dismissKeyboard", "windowToken", "Landroid/os/IBinder;", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "navigateToTicketPinInput", "ticketStep", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "showErrorDialog", "infoDialogType", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "titleArgs", "", "", "messageArgs", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;[Ljava/lang/String;)V", "showInfoDialog", "type", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberDialogFragment */
/* compiled from: TicketRedeemTicketNumberDialogFragment.kt */
public final class TicketRedeemTicketNumberDialogFragment extends Hilt_TicketRedeemTicketNumberDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TicketRedeemTicketNumberDialogFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentTicketRedeemTicketNumberInputBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy ticketRedeemTicketNumberDialogViewModel$delegate;

    public ImageView getCloseButton() {
        return null;
    }

    public TicketRedeemTicketNumberDialogFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 ticketRedeemTicketNumberDialogFragment$special$$inlined$viewModels$default$1 = new C3033xba4b505c(fragment);
        this.ticketRedeemTicketNumberDialogViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(TicketRedeemTicketNumberViewModel.class), new C3034xba4b505d(ticketRedeemTicketNumberDialogFragment$special$$inlined$viewModels$default$1), new C3035xba4b505e(ticketRedeemTicketNumberDialogFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentTicketRedeemTicketNumberInputBinding getBinding() {
        return (FragmentTicketRedeemTicketNumberInputBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentTicketRedeemTicketNumberInputBinding fragmentTicketRedeemTicketNumberInputBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentTicketRedeemTicketNumberInputBinding);
    }

    private final TicketRedeemTicketNumberViewModel getTicketRedeemTicketNumberDialogViewModel() {
        return (TicketRedeemTicketNumberViewModel) this.ticketRedeemTicketNumberDialogViewModel$delegate.getValue();
    }

    public DialogViewModel getViewModel() {
        return getTicketRedeemTicketNumberDialogViewModel();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        getTicketRedeemTicketNumberDialogViewModel().registerListeners();
        getTicketRedeemTicketNumberDialogViewModel().getViewState().observe(getViewLifecycleOwner(), new TicketRedeemTicketNumberDialogFragment$$ExternalSyntheticLambda2(this));
        FragmentTicketRedeemTicketNumberInputBinding inflate = FragmentTicketRedeemTicketNumberInputBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        inflate.tigerTicketRedeemConfirmButton.setOnClickListener(new TicketRedeemTicketNumberDialogFragment$$ExternalSyntheticLambda1(this));
        inflate.tigerTicketRedeemEditText.post(new TicketRedeemTicketNumberDialogFragment$$ExternalSyntheticLambda3(this));
        setBinding(inflate);
        getBinding().setCloseHandler(new TicketRedeemTicketNumberDialogFragment$onCreateView$3(this));
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [java.lang.Object[]] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m2563onCreateView$lambda1(media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberDialogFragment r4, media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState r5) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r5 instanceof media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.CurrentTicket
            if (r0 == 0) goto L_0x0014
            media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$CurrentTicket r5 = (media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.CurrentTicket) r5
            media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain r5 = r5.getTicketStepDomain()
            r4.navigateToTicketPinInput(r5)
            goto L_0x00be
        L_0x0014:
            boolean r0 = r5 instanceof media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.TicketInserted
            if (r0 == 0) goto L_0x003d
            media.tiger.tigerbox.databinding.FragmentTicketRedeemTicketNumberInputBinding r0 = r4.getBinding()
            com.google.android.material.textfield.TextInputEditText r0 = r0.tigerTicketRedeemEditText
            media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$TicketInserted r5 = (media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.TicketInserted) r5
            java.lang.String r5 = r5.getTicketNr()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r0.setText(r5)
            android.view.View r5 = r4.getView()
            if (r5 == 0) goto L_0x00be
            android.os.IBinder r5 = r5.getWindowToken()
            java.lang.String r0 = "it.windowToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            r4.dismissKeyboard(r5)
            goto L_0x00be
        L_0x003d:
            boolean r0 = r5 instanceof media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.ErrorDialog403
            r1 = 0
            if (r0 == 0) goto L_0x0054
            media.tiger.tigerbox.ui.common.InfoDialogType r5 = media.tiger.tigerbox.p016ui.common.InfoDialogType.TIGERTICKET_403_ERROR
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.lang.String[] r1 = (java.lang.String[]) r1
            r4.showErrorDialog(r5, r0, r1)
            goto L_0x00be
        L_0x0054:
            boolean r0 = r5 instanceof media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.ErrorDialog404
            if (r0 == 0) goto L_0x006a
            media.tiger.tigerbox.ui.common.InfoDialogType r5 = media.tiger.tigerbox.p016ui.common.InfoDialogType.TIGERTICKET_404_ERROR
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.lang.String[] r1 = (java.lang.String[]) r1
            r4.showErrorDialog(r5, r0, r1)
            goto L_0x00be
        L_0x006a:
            boolean r0 = r5 instanceof media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.ErrorDialog410
            if (r0 == 0) goto L_0x0080
            media.tiger.tigerbox.ui.common.InfoDialogType r5 = media.tiger.tigerbox.p016ui.common.InfoDialogType.TIGERTICKET_410_ERROR
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.lang.String[] r1 = (java.lang.String[]) r1
            r4.showErrorDialog(r5, r0, r1)
            goto L_0x00be
        L_0x0080:
            boolean r0 = r5 instanceof media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.ErrorDialog429
            if (r0 == 0) goto L_0x00a9
            media.tiger.tigerbox.ui.common.InfoDialogType r0 = media.tiger.tigerbox.p016ui.common.InfoDialogType.TIGERTICKET_429_ERROR
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            java.lang.String[] r2 = (java.lang.String[]) r2
            media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState$ErrorDialog429 r5 = (media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.ErrorDialog429) r5
            java.lang.String r3 = r5.getRetryAfter()
            if (r3 == 0) goto L_0x009e
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.String r5 = r5.getRetryAfter()
            r3[r1] = r5
            goto L_0x00a5
        L_0x009e:
            java.lang.String[] r5 = new java.lang.String[r1]
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            r3 = r5
            java.lang.String[] r3 = (java.lang.String[]) r3
        L_0x00a5:
            r4.showErrorDialog(r0, r2, r3)
            goto L_0x00be
        L_0x00a9:
            boolean r5 = r5 instanceof media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel.ViewState.ErrorDialogGeneral
            if (r5 == 0) goto L_0x00be
            media.tiger.tigerbox.ui.common.InfoDialogType r5 = media.tiger.tigerbox.p016ui.common.InfoDialogType.GENERAL_ERROR
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.String[] r0 = (java.lang.String[]) r0
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.lang.String[] r1 = (java.lang.String[]) r1
            r4.showErrorDialog(r5, r0, r1)
        L_0x00be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberDialogFragment.m2563onCreateView$lambda1(media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberDialogFragment, media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel$ViewState):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-5$lambda-2  reason: not valid java name */
    public static final void m2564onCreateView$lambda5$lambda2(TicketRedeemTicketNumberDialogFragment ticketRedeemTicketNumberDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(ticketRedeemTicketNumberDialogFragment, "this$0");
        ticketRedeemTicketNumberDialogFragment.getTicketRedeemTicketNumberDialogViewModel().getTicketProduct(String.valueOf(ticketRedeemTicketNumberDialogFragment.getBinding().tigerTicketRedeemEditText.getText()));
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-5$lambda-4  reason: not valid java name */
    public static final void m2565onCreateView$lambda5$lambda4(TicketRedeemTicketNumberDialogFragment ticketRedeemTicketNumberDialogFragment) {
        Intrinsics.checkNotNullParameter(ticketRedeemTicketNumberDialogFragment, "this$0");
        ticketRedeemTicketNumberDialogFragment.getBinding().tigerTicketRedeemEditText.requestFocus();
        FragmentActivity activity = ticketRedeemTicketNumberDialogFragment.getActivity();
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(ticketRedeemTicketNumberDialogFragment.getBinding().tigerTicketRedeemEditText, 1);
        ticketRedeemTicketNumberDialogFragment.getBinding().tigerTicketRedeemEditText.setFilters(new InputFilter[]{TicketRedeemTicketNumberDialogFragment$$ExternalSyntheticLambda0.INSTANCE, new InputFilter.LengthFilter(30)});
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-5$lambda-4$lambda-3  reason: not valid java name */
    public static final CharSequence m2566onCreateView$lambda5$lambda4$lambda3(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        while (i < i2) {
            if (!Character.isLetterOrDigit(charSequence.charAt(i)) && charSequence.charAt(i) != '-') {
                return "";
            }
            i++;
        }
        return null;
    }

    private final void navigateToTicketPinInput(TigerTicketStepDomain tigerTicketStepDomain) {
        if (tigerTicketStepDomain != null) {
            OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.action_to_tigerTicketPinInput, BundleKt.bundleOf(TuplesKt.m475to("tigerTicketStepDomain", tigerTicketStepDomain)));
        }
    }

    private final void showErrorDialog(InfoDialogType infoDialogType, String[] strArr, String[] strArr2) {
        closeSafely();
        showInfoDialog(infoDialogType, strArr, strArr2);
    }

    private final void showInfoDialog(InfoDialogType infoDialogType, String[] strArr, String[] strArr2) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("TicketRedeemTicketNumberDialogFragment showInfoDialog " + infoDialogType, new Object[0]);
        FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType), TuplesKt.m475to("titleFormatParams", strArr), TuplesKt.m475to("messageFormatParams", strArr2)));
    }

    private final void dismissKeyboard(IBinder iBinder) {
        FragmentActivity activity = getActivity();
        InputMethodManager inputMethodManager = null;
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    public void closeSafely() {
        getTicketRedeemTicketNumberDialogViewModel().unregisterListeners();
        FragmentKt.findNavController(this).navigateUp();
    }
}
