package media.tiger.tigerbox.p016ui.settings.parentalGate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.databinding.FragmentParentalGateEnableStepBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;

@Metadata(mo33736d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u000e\u001a\u00020\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateEnableStepFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentParentalGateEnableStepBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentParentalGateEnableStepBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentParentalGateEnableStepBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "viewModel", "Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateEnableDisableStepViewModel;", "getViewModel", "()Lmedia/tiger/tigerbox/ui/settings/parentalGate/ParentalGateEnableDisableStepViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getCloseButton", "Landroid/widget/ImageView;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableStepFragment */
/* compiled from: ParentalGateEnableStepFragment.kt */
public final class ParentalGateEnableStepFragment extends Hilt_ParentalGateEnableStepFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ParentalGateEnableStepFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentParentalGateEnableStepBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy viewModel$delegate;

    public ImageView getCloseButton() {
        return null;
    }

    public ParentalGateEnableStepFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 parentalGateEnableStepFragment$special$$inlined$viewModels$default$1 = new C3021xb98369a6(fragment);
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ParentalGateEnableDisableStepViewModel.class), new C3022xb98369a7(parentalGateEnableStepFragment$special$$inlined$viewModels$default$1), new C3023xb98369a8(parentalGateEnableStepFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentParentalGateEnableStepBinding getBinding() {
        return (FragmentParentalGateEnableStepBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentParentalGateEnableStepBinding fragmentParentalGateEnableStepBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentParentalGateEnableStepBinding);
    }

    private final ParentalGateEnableDisableStepViewModel getViewModel() {
        return (ParentalGateEnableDisableStepViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentParentalGateEnableStepBinding inflate = FragmentParentalGateEnableStepBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().fragmentParentalGateEnableStepOkButton.setOnClickListener(new ParentalGateEnableStepFragment$$ExternalSyntheticLambda1(this));
        getBinding().fragmentParentalGateEnableStepCancelButton.setOnClickListener(new ParentalGateEnableStepFragment$$ExternalSyntheticLambda0(this));
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m2538onCreateView$lambda0(ParentalGateEnableStepFragment parentalGateEnableStepFragment, View view) {
        Intrinsics.checkNotNullParameter(parentalGateEnableStepFragment, "this$0");
        parentalGateEnableStepFragment.getViewModel().setParentalGateState(true);
        parentalGateEnableStepFragment.closeSafely();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m2539onCreateView$lambda1(ParentalGateEnableStepFragment parentalGateEnableStepFragment, View view) {
        Intrinsics.checkNotNullParameter(parentalGateEnableStepFragment, "this$0");
        parentalGateEnableStepFragment.closeSafely();
    }

    /* renamed from: getViewModel  reason: collision with other method in class */
    public DialogViewModel m2540getViewModel() {
        return getViewModel();
    }
}
