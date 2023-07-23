package media.tiger.tigerbox.p016ui.settings.timersSetup;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentTimersSetupBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupViewModel;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0014H\u0016J\b\u0010(\u001a\u00020\u0014H\u0016J\u0010\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010,\u001a\u00020\u00142\u0006\u0010*\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010/H\u0002J\u0010\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u000202H\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0010X\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u00064"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenDialogFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentTimersSetupBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentTimersSetupBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentTimersSetupBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "items", "", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupItem;", "itemsList", "Lkotlin/Function0;", "onItemClicked", "Lkotlin/Function2;", "", "", "timersSetupViewModel", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel;", "getTimersSetupViewModel", "()Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel;", "timersSetupViewModel$delegate", "Lkotlin/Lazy;", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "showSetupLimitTimer", "item", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitItem;", "showSetupSleepTimer", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupSleepItem;", "showSetupWindowTimer", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupWindowItem;", "updateList", "viewState", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel$ViewState;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupFragment */
/* compiled from: TimersSetupFragment.kt */
public final class TimersSetupFragment extends Hilt_TimersSetupFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TimersSetupFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentTimersSetupBinding;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_TIME_WINDOWS_CNT = 2;
    public static final String REQUEST_KEY = "TIMER_SETUP_FRAGMENT_REQUEST_KEY";
    public static final String RESULT_KEY = "RESULT_KEY";
    private final AutoClearedValue binding$delegate;
    /* access modifiers changed from: private */
    public List<? extends TimersSetupItem> items = CollectionsKt.emptyList();
    private final Function0<List<TimersSetupItem>> itemsList = new TimersSetupFragment$itemsList$1(this);
    private final Function2<Integer, TimersSetupItem, Unit> onItemClicked = new TimersSetupFragment$onItemClicked$1(this);
    private final Lazy timersSetupViewModel$delegate;

    public TimersSetupFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 timersSetupFragment$special$$inlined$viewModels$default$1 = new TimersSetupFragment$special$$inlined$viewModels$default$1(fragment);
        this.timersSetupViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(TimersSetupViewModel.class), new TimersSetupFragment$special$$inlined$viewModels$default$2(timersSetupFragment$special$$inlined$viewModels$default$1), new TimersSetupFragment$special$$inlined$viewModels$default$3(timersSetupFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentTimersSetupBinding getBinding() {
        return (FragmentTimersSetupBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentTimersSetupBinding fragmentTimersSetupBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentTimersSetupBinding);
    }

    private final TimersSetupViewModel getTimersSetupViewModel() {
        return (TimersSetupViewModel) this.timersSetupViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentTimersSetupBinding inflate = FragmentTimersSetupBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getBinding().timersSetupRecyclerView.setAdapter(new TimersSetupAdapter(this.itemsList, this.onItemClicked));
        getTimersSetupViewModel().getViewState().observe(getViewLifecycleOwner(), new TimersSetupFragment$$ExternalSyntheticLambda1(this));
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m2552onCreateView$lambda0(TimersSetupFragment timersSetupFragment, TimersSetupViewModel.ViewState viewState) {
        Intrinsics.checkNotNullParameter(timersSetupFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(viewState, "viewState");
        timersSetupFragment.updateList(viewState);
    }

    public void onResume() {
        super.onResume();
        getTimersSetupViewModel().prepare();
        requireActivity().getSupportFragmentManager().setFragmentResultListener(REQUEST_KEY, this, new TimersSetupFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-2  reason: not valid java name */
    public static final void m2553onResume$lambda2(TimersSetupFragment timersSetupFragment, String str, Bundle bundle) {
        TimersSetupViewModel.ViewState value;
        Intrinsics.checkNotNullParameter(timersSetupFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (bundle.containsKey("RESULT_KEY") && (value = timersSetupFragment.getTimersSetupViewModel().getViewState().getValue()) != null) {
            timersSetupFragment.updateList(value);
        }
    }

    public void onPause() {
        super.onPause();
        getTimersSetupViewModel().exit();
        requireActivity().getSupportFragmentManager().clearFragmentResultListener(REQUEST_KEY);
    }

    private final void updateList(TimersSetupViewModel.ViewState viewState) {
        List<? extends TimersSetupItem> arrayList = new ArrayList<>();
        String string = getString(C2814R.string.settings_timers_setup_title_daily_use);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.setti…rs_setup_title_daily_use)");
        arrayList.add(new TimersSetupTitleItem(string));
        String string2 = getString(C2814R.string.settings_timers_setup_time_length);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.setti…timers_setup_time_length)");
        int initialLimitSeconds = viewState.getTimeLimit().getInitialLimitSeconds();
        TimersSetupViewModel timersSetupViewModel = getTimersSetupViewModel();
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        arrayList.add(new TimersSetupLimitItem(string2, initialLimitSeconds, timersSetupViewModel.timeLimitDescription(context)));
        String string3 = getString(C2814R.string.settings_timers_setup_title_sleeptimer);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.setti…s_setup_title_sleeptimer)");
        arrayList.add(new TimersSetupTitleItem(string3));
        String string4 = getString(C2814R.string.settings_timers_setup_time_length);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.setti…timers_setup_time_length)");
        int sleepTimeSeconds = viewState.getSleepTimeSeconds();
        TimersSetupViewModel timersSetupViewModel2 = getTimersSetupViewModel();
        Context context2 = getContext();
        Intrinsics.checkNotNull(context2);
        arrayList.add(new TimersSetupSleepItem(string4, sleepTimeSeconds, timersSetupViewModel2.sleepTimeDescription(context2)));
        String string5 = getString(C2814R.string.settings_timers_setup_title_timer_window_title);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.setti…title_timer_window_title)");
        arrayList.add(new TimersSetupTitleItem(string5));
        int size = viewState.getWindowedLimit().getLimits().size();
        int i = 0;
        while (i < size) {
            WindowedLimits.WindowedLimit windowedLimit = viewState.getWindowedLimit().getLimits().get(i);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string6 = getString(C2814R.string.settings_timers_window_title);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.settings_timers_window_title)");
            int i2 = i + 1;
            String format = String.format(string6, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            arrayList.add(new TimersSetupWindowItem(format, i, windowedLimit.getWindowStart(), windowedLimit.getWindowEnd()));
            i = i2;
        }
        if (viewState.getWindowedLimit().getLimits().size() < 2) {
            String string7 = getString(C2814R.string.settings_timers_setup_title_timer_window_add);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(R.string.setti…p_title_timer_window_add)");
            arrayList.add(new TimersSetupAddWindowItem(string7));
        }
        this.items = arrayList;
        RecyclerView.Adapter adapter = getBinding().timersSetupRecyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void showSetupLimitTimer(TimersSetupLimitItem timersSetupLimitItem) {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.action_timersSetup_to_limitEditFragment, BundleKt.bundleOf(TuplesKt.m475to("isSleepTimer", false)));
    }

    /* access modifiers changed from: private */
    public final void showSetupSleepTimer(TimersSetupSleepItem timersSetupSleepItem) {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.action_timersSetup_to_limitEditFragment, BundleKt.bundleOf(TuplesKt.m475to("isSleepTimer", true), TuplesKt.m475to("sleepSeconds", Integer.valueOf(timersSetupSleepItem.getSeconds()))));
    }

    /* access modifiers changed from: private */
    public final void showSetupWindowTimer(TimersSetupWindowItem timersSetupWindowItem) {
        boolean z;
        int i;
        String windowStart;
        if (timersSetupWindowItem == null || (windowStart = timersSetupWindowItem.getWindowStart()) == null) {
            z = false;
        } else {
            z = !(windowStart.length() == 0);
        }
        if (timersSetupWindowItem != null) {
            z = !(timersSetupWindowItem.getWindowStart().length() == 0);
            i = timersSetupWindowItem.getIdx();
        } else {
            i = 1;
        }
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), C2814R.C2817id.action_timersSetup_to_windowEditFragment, BundleKt.bundleOf(TuplesKt.m475to("isDeletable", Boolean.valueOf(z)), TuplesKt.m475to("index", Integer.valueOf(i))));
    }

    public ImageView getCloseButton() {
        ImageButton root = getBinding().fragmentCloseButton.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.fragmentCloseButton.root");
        return root;
    }

    public DialogViewModel getViewModel() {
        return getTimersSetupViewModel();
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupFragment$Companion;", "", "()V", "MAX_TIME_WINDOWS_CNT", "", "REQUEST_KEY", "", "RESULT_KEY", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupFragment$Companion */
    /* compiled from: TimersSetupFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
