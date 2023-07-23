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
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentTimersLimitBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogFragment;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.p016ui.common.InfoDialogTypeResult;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupViewModel;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J$\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00103\u001a\u00020\u0019H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\u001a\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J%\u00107\u001a\u00020\u00192\u0006\u00108\u001a\u0002092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H\u0002¢\u0006\u0002\u0010=R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00190\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006>"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenDialogFragment;", "()V", "args", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentTimersLimitBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentTimersLimitBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentTimersLimitBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "itemsList", "Lkotlin/Function0;", "", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersTimeLimitItem;", "onItemClicked", "Lkotlin/Function2;", "", "", "onSubmitClicked", "Landroid/view/View$OnClickListener;", "timerLimitViewModel", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupViewModel;", "getTimerLimitViewModel", "()Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupViewModel;", "timerLimitViewModel$delegate", "Lkotlin/Lazy;", "changeTimeLimitAndClose", "aItem", "reset", "", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onPause", "onResume", "onViewCreated", "view", "showInfoDialog", "type", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "params", "", "", "(Lmedia/tiger/tigerbox/ui/common/InfoDialogType;[Ljava/lang/String;)V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupFragment */
/* compiled from: TimersSetupLimitSetupFragment.kt */
public final class TimersSetupLimitSetupFragment extends Hilt_TimersSetupLimitSetupFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TimersSetupLimitSetupFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentTimersLimitBinding;", 0))};
    private final NavArgsLazy args$delegate;
    private final AutoClearedValue binding$delegate;
    private final Function0<List<TimersTimeLimitItem>> itemsList = new TimersSetupLimitSetupFragment$itemsList$1(this);
    private final Function2<Integer, TimersTimeLimitItem, Unit> onItemClicked = new TimersSetupLimitSetupFragment$onItemClicked$1(this);
    private final View.OnClickListener onSubmitClicked = new TimersSetupLimitSetupFragment$$ExternalSyntheticLambda0(this);
    private final Lazy timerLimitViewModel$delegate;

    public TimersSetupLimitSetupFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 timersSetupLimitSetupFragment$special$$inlined$viewModels$default$1 = new C3025xf489a848(fragment);
        this.timerLimitViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(TimersSetupLimitSetupViewModel.class), new C3026xf489a849(timersSetupLimitSetupFragment$special$$inlined$viewModels$default$1), new C3027xf489a84a(timersSetupLimitSetupFragment$special$$inlined$viewModels$default$1, fragment));
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(TimersSetupLimitSetupFragmentArgs.class), new TimersSetupLimitSetupFragment$special$$inlined$navArgs$1(fragment));
    }

    /* access modifiers changed from: private */
    public final FragmentTimersLimitBinding getBinding() {
        return (FragmentTimersLimitBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentTimersLimitBinding fragmentTimersLimitBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentTimersLimitBinding);
    }

    /* access modifiers changed from: private */
    public final TimersSetupLimitSetupViewModel getTimerLimitViewModel() {
        return (TimersSetupLimitSetupViewModel) this.timerLimitViewModel$delegate.getValue();
    }

    private final TimersSetupLimitSetupFragmentArgs getArgs() {
        return (TimersSetupLimitSetupFragmentArgs) this.args$delegate.getValue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, C2814R.C2823style.FullscreenDialogThemeNoFloating);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTimersLimitBinding inflate = FragmentTimersLimitBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().hmPicker.setIs24HourView(true);
        getBinding().hmPicker.setVisibility(8);
        getBinding().submitButton.setOnClickListener(this.onSubmitClicked);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getTimerLimitViewModel().setSleepTimer(getArgs().isSleepTimer());
        getTimerLimitViewModel().setActiveSleepSeconds(getArgs().getSleepSeconds());
        getBinding().setLayoutTitle(getString(getArgs().isSleepTimer() ? C2814R.string.settings_timers_sleep_title : C2814R.string.settings_timers_limit_title));
        getBinding().timersLimitRecyclerView.setAdapter(new TimersSetupLimitsListAdapter(this.itemsList, this.onItemClicked));
        if (getTimerLimitViewModel().isCustomTime()) {
            TimersSetupLimitSetupViewModel.customHHMM customTime = getTimerLimitViewModel().customTime();
            getBinding().hmPicker.setCurrentHour(Integer.valueOf(customTime.getHour()));
            getBinding().hmPicker.setCurrentMinute(Integer.valueOf(customTime.getMinute()));
            getBinding().hmPicker.setVisibility(0);
        }
        RecyclerView.Adapter adapter = getBinding().timersLimitRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void onResume() {
        super.onResume();
        requireActivity().getSupportFragmentManager().setFragmentResultListener(InfoDialogFragment.REQUEST_KEY, this, new TimersSetupLimitSetupFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-2  reason: not valid java name */
    public static final void m2554onResume$lambda2(TimersSetupLimitSetupFragment timersSetupLimitSetupFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(timersSetupLimitSetupFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey("RESULT_KEY")) {
            String string = bundle.getString("RESULT_KEY");
            if (string == null) {
                string = "";
            }
            if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.TIME_LIMIT_RESET.getText())) {
                Timber.Forest.mo50221i("TIME LIMIT RESET", new Object[0]);
                TimersTimeLimitItem selectedItem = timersSetupLimitSetupFragment.getTimerLimitViewModel().getSelectedItem();
                if (selectedItem != null) {
                    timersSetupLimitSetupFragment.changeTimeLimitAndClose(selectedItem, true);
                }
            } else if (Intrinsics.areEqual((Object) string, (Object) InfoDialogTypeResult.TIME_LIMIT_ADJUST.getText())) {
                Timber.Forest.mo50221i("TIME LIMIT ADJUST", new Object[0]);
                TimersTimeLimitItem selectedItem2 = timersSetupLimitSetupFragment.getTimerLimitViewModel().getSelectedItem();
                if (selectedItem2 != null) {
                    timersSetupLimitSetupFragment.changeTimeLimitAndClose(selectedItem2, false);
                }
            }
        }
    }

    public void onPause() {
        super.onPause();
        requireActivity().getSupportFragmentManager().clearFragmentResultListener(InfoDialogFragment.REQUEST_KEY);
    }

    private final void showInfoDialog(InfoDialogType infoDialogType, String[] strArr) {
        FragmentKt.findNavController(this).navigate((int) C2814R.C2817id.infoDialogFragment, BundleKt.bundleOf(TuplesKt.m475to("dialogType", infoDialogType), TuplesKt.m475to("messageFormatParams", strArr)));
    }

    /* access modifiers changed from: private */
    /* renamed from: onSubmitClicked$lambda-4  reason: not valid java name */
    public static final void m2555onSubmitClicked$lambda4(TimersSetupLimitSetupFragment timersSetupLimitSetupFragment, View view) {
        Intrinsics.checkNotNullParameter(timersSetupLimitSetupFragment, "this$0");
        TimersTimeLimitItem selectedItem = timersSetupLimitSetupFragment.getTimerLimitViewModel().getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        if (timersSetupLimitSetupFragment.getTimerLimitViewModel().isSleepTimer() || !timersSetupLimitSetupFragment.getTimerLimitViewModel().hasTimeLimit() || selectedItem.getTitle() == C2814R.string.settings_timers_turn_off) {
            timersSetupLimitSetupFragment.changeTimeLimitAndClose(selectedItem, false);
        } else {
            showInfoDialog$default(timersSetupLimitSetupFragment, InfoDialogType.TIME_LIMIT_RESET_OR_ADJUST, (String[]) null, 2, (Object) null);
        }
    }

    private final void changeTimeLimitAndClose(TimersTimeLimitItem timersTimeLimitItem, boolean z) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("changeTimeLimitAndClose " + z, new Object[0]);
        TimersSetupLimitSetupViewModel timerLimitViewModel = getTimerLimitViewModel();
        Integer currentMinute = getBinding().hmPicker.getCurrentMinute();
        Intrinsics.checkNotNullExpressionValue(currentMinute, "binding.hmPicker.currentMinute");
        timerLimitViewModel.onSubmitClicked(timersTimeLimitItem, ((getBinding().hmPicker.getCurrentHour().intValue() * 60) + currentMinute.intValue()) * 60, z);
        requireActivity().getSupportFragmentManager().setFragmentResult(TimersSetupFragment.REQUEST_KEY, BundleKt.bundleOf(TuplesKt.m475to("RESULT_KEY", " ")));
        FragmentKt.findNavController(this).navigateUp();
    }

    public ImageView getCloseButton() {
        ImageButton root = getBinding().fragmentCloseButton.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.fragmentCloseButton.root");
        return root;
    }

    public DialogViewModel getViewModel() {
        return getTimerLimitViewModel();
    }

    static /* synthetic */ void showInfoDialog$default(TimersSetupLimitSetupFragment timersSetupLimitSetupFragment, InfoDialogType infoDialogType, String[] strArr, int i, Object obj) {
        if ((i & 2) != 0) {
            strArr = (String[]) ((Object[]) new String[0]);
        }
        timersSetupLimitSetupFragment.showInfoDialog(infoDialogType, strArr);
    }
}
