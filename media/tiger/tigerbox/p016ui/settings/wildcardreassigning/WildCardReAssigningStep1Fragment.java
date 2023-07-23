package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

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
import media.tiger.tigerbox.databinding.FragmentWildcardReassigningStep1Binding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;

@Metadata(mo33736d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/WildCardReAssigningStep1Fragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentWildcardReassigningStep1Binding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentWildcardReassigningStep1Binding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentWildcardReassigningStep1Binding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "step1ViewModel", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/WildCardReAssigningStep1ViewModel;", "getStep1ViewModel", "()Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/WildCardReAssigningStep1ViewModel;", "step1ViewModel$delegate", "Lkotlin/Lazy;", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1Fragment */
/* compiled from: WildCardReAssigningStep1Fragment.kt */
public final class WildCardReAssigningStep1Fragment extends Hilt_WildCardReAssigningStep1Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(WildCardReAssigningStep1Fragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentWildcardReassigningStep1Binding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy step1ViewModel$delegate;

    public ImageView getCloseButton() {
        return null;
    }

    public WildCardReAssigningStep1Fragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 wildCardReAssigningStep1Fragment$special$$inlined$viewModels$default$1 = new C3040xbfd0f316(fragment);
        this.step1ViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(WildCardReAssigningStep1ViewModel.class), new C3041xbfd0f317(wildCardReAssigningStep1Fragment$special$$inlined$viewModels$default$1), new C3042xbfd0f318(wildCardReAssigningStep1Fragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentWildcardReassigningStep1Binding getBinding() {
        return (FragmentWildcardReassigningStep1Binding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentWildcardReassigningStep1Binding fragmentWildcardReassigningStep1Binding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentWildcardReassigningStep1Binding);
    }

    private final WildCardReAssigningStep1ViewModel getStep1ViewModel() {
        return (WildCardReAssigningStep1ViewModel) this.step1ViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentWildcardReassigningStep1Binding inflate = FragmentWildcardReassigningStep1Binding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().wildcardReassigningStep1CancelButton.setOnClickListener(new WildCardReAssigningStep1Fragment$$ExternalSyntheticLambda0(this));
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m2567onCreateView$lambda0(WildCardReAssigningStep1Fragment wildCardReAssigningStep1Fragment, View view) {
        Intrinsics.checkNotNullParameter(wildCardReAssigningStep1Fragment, "this$0");
        wildCardReAssigningStep1Fragment.getStep1ViewModel().cancelWildcardReassign();
    }

    public DialogViewModel getViewModel() {
        return getStep1ViewModel();
    }
}
