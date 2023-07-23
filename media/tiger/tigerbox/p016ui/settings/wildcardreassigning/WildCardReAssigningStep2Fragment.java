package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentWildcardReassigningStep2Binding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;

@Metadata(mo33736d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/WildCardReAssigningStep2Fragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentWildcardReassigningStep2Binding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentWildcardReassigningStep2Binding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentWildcardReassigningStep2Binding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "step2ViewModel", "Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/WildCardReAssigningStep2ViewModel;", "getStep2ViewModel", "()Lmedia/tiger/tigerbox/ui/settings/wildcardreassigning/WildCardReAssigningStep2ViewModel;", "step2ViewModel$delegate", "Lkotlin/Lazy;", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep2Fragment */
/* compiled from: WildCardReAssigningStep2Fragment.kt */
public final class WildCardReAssigningStep2Fragment extends Hilt_WildCardReAssigningStep2Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(WildCardReAssigningStep2Fragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentWildcardReassigningStep2Binding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy step2ViewModel$delegate;

    public ImageView getCloseButton() {
        return null;
    }

    public WildCardReAssigningStep2Fragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 wildCardReAssigningStep2Fragment$special$$inlined$viewModels$default$1 = new C3044x354b1957(fragment);
        this.step2ViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(WildCardReAssigningStep2ViewModel.class), new C3045x354b1958(wildCardReAssigningStep2Fragment$special$$inlined$viewModels$default$1), new C3046x354b1959(wildCardReAssigningStep2Fragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentWildcardReassigningStep2Binding getBinding() {
        return (FragmentWildcardReassigningStep2Binding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentWildcardReassigningStep2Binding fragmentWildcardReassigningStep2Binding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentWildcardReassigningStep2Binding);
    }

    private final WildCardReAssigningStep2ViewModel getStep2ViewModel() {
        return (WildCardReAssigningStep2ViewModel) this.step2ViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentWildcardReassigningStep2Binding inflate = FragmentWildcardReassigningStep2Binding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().wildcardReassigningStep2OkButton.setOnClickListener(new WildCardReAssigningStep2Fragment$$ExternalSyntheticLambda1(this));
        getBinding().wildcardReassigningStep2CancelButton.setOnClickListener(new WildCardReAssigningStep2Fragment$$ExternalSyntheticLambda0(this));
        TextView textView = getBinding().wildcardReassigningStep2Text;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getString(C2814R.string.wildcard_reassigning_screen2_text1);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.wildc…eassigning_screen2_text1)");
        String format = String.format(string, Arrays.copyOf(new Object[]{getStep2ViewModel().getAccountEmail()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m2569onCreateView$lambda0(WildCardReAssigningStep2Fragment wildCardReAssigningStep2Fragment, View view) {
        Intrinsics.checkNotNullParameter(wildCardReAssigningStep2Fragment, "this$0");
        wildCardReAssigningStep2Fragment.getStep2ViewModel().continueToStep3();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m2570onCreateView$lambda1(WildCardReAssigningStep2Fragment wildCardReAssigningStep2Fragment, View view) {
        Intrinsics.checkNotNullParameter(wildCardReAssigningStep2Fragment, "this$0");
        wildCardReAssigningStep2Fragment.getStep2ViewModel().cancelWildcardReassign();
    }

    public DialogViewModel getViewModel() {
        return getStep2ViewModel();
    }
}
