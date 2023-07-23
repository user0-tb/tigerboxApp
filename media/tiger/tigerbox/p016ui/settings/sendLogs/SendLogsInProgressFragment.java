package media.tiger.tigerbox.p016ui.settings.sendLogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentSendLogsInProgressBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsInProgressViewModel;

@Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u000e\u001a\u00020\u0014H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/sendLogs/SendLogsInProgressFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentSendLogsInProgressBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentSendLogsInProgressBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentSendLogsInProgressBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "viewModel", "Lmedia/tiger/tigerbox/ui/settings/sendLogs/SendLogsInProgressViewModel;", "getViewModel", "()Lmedia/tiger/tigerbox/ui/settings/sendLogs/SendLogsInProgressViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getCloseButton", "Landroid/widget/ImageView;", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "onViewCreated", "view", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressFragment */
/* compiled from: SendLogsInProgressFragment.kt */
public final class SendLogsInProgressFragment extends Hilt_SendLogsInProgressFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(SendLogsInProgressFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentSendLogsInProgressBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy viewModel$delegate;

    public ImageView getCloseButton() {
        return null;
    }

    public SendLogsInProgressFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 sendLogsInProgressFragment$special$$inlined$viewModels$default$1 = new SendLogsInProgressFragment$special$$inlined$viewModels$default$1(fragment);
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(SendLogsInProgressViewModel.class), new SendLogsInProgressFragment$special$$inlined$viewModels$default$2(sendLogsInProgressFragment$special$$inlined$viewModels$default$1), new SendLogsInProgressFragment$special$$inlined$viewModels$default$3(sendLogsInProgressFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentSendLogsInProgressBinding getBinding() {
        return (FragmentSendLogsInProgressBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentSendLogsInProgressBinding fragmentSendLogsInProgressBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentSendLogsInProgressBinding);
    }

    private final SendLogsInProgressViewModel getViewModel() {
        return (SendLogsInProgressViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentSendLogsInProgressBinding inflate = FragmentSendLogsInProgressBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getViewModel().getViewState().observe(getViewLifecycleOwner(), new SendLogsInProgressFragment$$ExternalSyntheticLambda0(this));
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m2547onCreateView$lambda0(SendLogsInProgressFragment sendLogsInProgressFragment, SendLogsInProgressViewModel.ViewState viewState) {
        Intrinsics.checkNotNullParameter(sendLogsInProgressFragment, "this$0");
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(sendLogsInProgressFragment), C2814R.C2817id.action_send_logs_in_progress_to_finished, (Bundle) null, 2, (Object) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
    }

    public void onResume() {
        super.onResume();
        getViewModel().sendLogs();
    }

    /* renamed from: getViewModel  reason: collision with other method in class */
    public DialogViewModel m2548getViewModel() {
        return getViewModel();
    }
}
