package media.tiger.tigerbox.p016ui.settings.timersSetup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavArgsLazy;
import androidx.navigation.fragment.FragmentKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentTimersWindowBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;

@Metadata(mo33736d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010+\u001a\u00020 H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenDialogFragment;", "()V", "args", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentTimersWindowBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentTimersWindowBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentTimersWindowBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "model", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupViewModel;", "getModel", "()Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowSetupViewModel;", "model$delegate", "Lkotlin/Lazy;", "onDeleteClicked", "Landroid/view/View$OnClickListener;", "onSubmitClicked", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "refreshAndNavigateUp", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupFragment */
/* compiled from: TimersSetupWindowSetupFragment.kt */
public final class TimersSetupWindowSetupFragment extends Hilt_TimersSetupWindowSetupFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TimersSetupWindowSetupFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentTimersWindowBinding;", 0))};
    private final NavArgsLazy args$delegate;
    private final AutoClearedValue binding$delegate;
    private final Lazy model$delegate;
    private final View.OnClickListener onDeleteClicked = new TimersSetupWindowSetupFragment$$ExternalSyntheticLambda1(this);
    private final View.OnClickListener onSubmitClicked = new TimersSetupWindowSetupFragment$$ExternalSyntheticLambda0(this);

    public TimersSetupWindowSetupFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 timersSetupWindowSetupFragment$special$$inlined$viewModels$default$1 = new C3029x5bcdff35(fragment);
        this.model$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(TimersSetupWindowSetupViewModel.class), new C3030x5bcdff36(timersSetupWindowSetupFragment$special$$inlined$viewModels$default$1), new C3031x5bcdff37(timersSetupWindowSetupFragment$special$$inlined$viewModels$default$1, fragment));
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(TimersSetupWindowSetupFragmentArgs.class), new TimersSetupWindowSetupFragment$special$$inlined$navArgs$1(fragment));
    }

    private final FragmentTimersWindowBinding getBinding() {
        return (FragmentTimersWindowBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentTimersWindowBinding fragmentTimersWindowBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentTimersWindowBinding);
    }

    private final TimersSetupWindowSetupViewModel getModel() {
        return (TimersSetupWindowSetupViewModel) this.model$delegate.getValue();
    }

    private final TimersSetupWindowSetupFragmentArgs getArgs() {
        return (TimersSetupWindowSetupFragmentArgs) this.args$delegate.getValue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, C2814R.C2823style.FullscreenDialogThemeNoFloating);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTimersWindowBinding inflate = FragmentTimersWindowBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().startPicker.setIs24HourView(true);
        getBinding().endPicker.setIs24HourView(true);
        getBinding().submitButton.setOnClickListener(this.onSubmitClicked);
        getBinding().deleteButton.setOnClickListener(this.onDeleteClicked);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getModel().setWindowIdx(getArgs().getIndex());
        getBinding().setLayoutTitleIdx(Integer.valueOf(getModel().getWindowIdx() + 1));
        getBinding().deleteButton.setVisibility(getArgs().isDeletable() ? 0 : 8);
        getBinding().startPicker.setCurrentHour(Integer.valueOf(getModel().getStartWindowHour()));
        getBinding().startPicker.setCurrentMinute(Integer.valueOf(getModel().getStartWindowMinute()));
        getBinding().endPicker.setCurrentHour(Integer.valueOf(getModel().getEndWindowHour()));
        getBinding().endPicker.setCurrentMinute(Integer.valueOf(getModel().getEndWindowMinute()));
    }

    /* access modifiers changed from: private */
    /* renamed from: onSubmitClicked$lambda-0  reason: not valid java name */
    public static final void m2560onSubmitClicked$lambda0(TimersSetupWindowSetupFragment timersSetupWindowSetupFragment, View view) {
        Intrinsics.checkNotNullParameter(timersSetupWindowSetupFragment, "this$0");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{timersSetupWindowSetupFragment.getBinding().startPicker.getCurrentHour(), timersSetupWindowSetupFragment.getBinding().startPicker.getCurrentMinute()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{timersSetupWindowSetupFragment.getBinding().endPicker.getCurrentHour(), timersSetupWindowSetupFragment.getBinding().endPicker.getCurrentMinute()}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        timersSetupWindowSetupFragment.getModel().setTimeWindow(format, format2);
        timersSetupWindowSetupFragment.refreshAndNavigateUp();
    }

    /* access modifiers changed from: private */
    /* renamed from: onDeleteClicked$lambda-1  reason: not valid java name */
    public static final void m2559onDeleteClicked$lambda1(TimersSetupWindowSetupFragment timersSetupWindowSetupFragment, View view) {
        Intrinsics.checkNotNullParameter(timersSetupWindowSetupFragment, "this$0");
        timersSetupWindowSetupFragment.getModel().deleteTimeWindow();
        timersSetupWindowSetupFragment.refreshAndNavigateUp();
    }

    private final void refreshAndNavigateUp() {
        requireActivity().getSupportFragmentManager().setFragmentResult(TimersSetupFragment.REQUEST_KEY, BundleKt.bundleOf(TuplesKt.m475to("RESULT_KEY", " ")));
        FragmentKt.findNavController(this).navigateUp();
    }

    public ImageView getCloseButton() {
        ImageButton root = getBinding().fragmentCloseButton.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.fragmentCloseButton.root");
        return root;
    }

    public DialogViewModel getViewModel() {
        return getModel();
    }
}
