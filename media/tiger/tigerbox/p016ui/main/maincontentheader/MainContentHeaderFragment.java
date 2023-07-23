package media.tiger.tigerbox.p016ui.main.maincontentheader;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentHeaderBarBinding;
import media.tiger.tigerbox.extension.TimeKt;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.model.domain.ConnectionState;
import media.tiger.tigerbox.model.domain.SecurityMode;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.model.domain.WifiStrength;
import media.tiger.tigerbox.p016ui.main.MainContentActivity;
import media.tiger.tigerbox.services.implementations.timersController.LockedModeReason;
import media.tiger.tigerbox.utils.DateUtilsKt;
import org.spongycastle.i18n.MessageBundle;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0006\u0010\u0012\u001a\u00020\u0010J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\u0006\u0010\u001f\u001a\u00020\u0010J\u000e\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u0010H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006$"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontentheader/MainContentHeaderFragment;", "Lmedia/tiger/tigerbox/ui/main/maincontent/MainContentFragment;", "()V", "binding", "Lmedia/tiger/tigerbox/databinding/FragmentHeaderBarBinding;", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentHeaderBarBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentHeaderBarBinding;)V", "headerBarViewModel", "Lmedia/tiger/tigerbox/ui/main/maincontentheader/MainContentHeaderBarViewModel;", "getHeaderBarViewModel", "()Lmedia/tiger/tigerbox/ui/main/maincontentheader/MainContentHeaderBarViewModel;", "headerBarViewModel$delegate", "Lkotlin/Lazy;", "disableOfflineMode", "", "enableOfflineMode", "hideCloseButton", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "removeCurrentTimeAndDate", "showCloseButton", "showHeaderTitle", "title", "", "storeCurrentTimeAndDate", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderFragment */
/* compiled from: MainContentHeaderFragment.kt */
public final class MainContentHeaderFragment extends Hilt_MainContentHeaderFragment {
    public FragmentHeaderBarBinding binding;
    private final Lazy headerBarViewModel$delegate;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderFragment$WhenMappings */
    /* compiled from: MainContentHeaderFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LockedModeReason.values().length];
            iArr[LockedModeReason.USAGE_LIMIT.ordinal()] = 1;
            iArr[LockedModeReason.WINDOWED_LIMIT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MainContentHeaderFragment() {
        Fragment fragment = this;
        this.headerBarViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(MainContentHeaderBarViewModel.class), new C2965xd1d736f3(fragment), new C2966xd1d736f4(fragment));
    }

    public final FragmentHeaderBarBinding getBinding() {
        FragmentHeaderBarBinding fragmentHeaderBarBinding = this.binding;
        if (fragmentHeaderBarBinding != null) {
            return fragmentHeaderBarBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(FragmentHeaderBarBinding fragmentHeaderBarBinding) {
        Intrinsics.checkNotNullParameter(fragmentHeaderBarBinding, "<set-?>");
        this.binding = fragmentHeaderBarBinding;
    }

    private final MainContentHeaderBarViewModel getHeaderBarViewModel() {
        return (MainContentHeaderBarViewModel) this.headerBarViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentHeaderBarBinding inflate = FragmentHeaderBarBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        FragmentHeaderBarBinding binding2 = getBinding();
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type media.tiger.tigerbox.ui.main.MainContentActivity");
        binding2.setSettingsClickListener(((MainContentActivity) activity).getSettingsClickListener());
        FragmentHeaderBarBinding binding3 = getBinding();
        FragmentActivity activity2 = getActivity();
        Objects.requireNonNull(activity2, "null cannot be cast to non-null type media.tiger.tigerbox.ui.main.MainContentActivity");
        binding3.setUpdateAvailableClickListener(((MainContentActivity) activity2).getUpdateAvailableClickListener());
        getHeaderBarViewModel().getHeaderProvider().getOfflineMode().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda2(this));
        getHeaderBarViewModel().getHeaderProvider().getWifiSignalStrength().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda10(this));
        getHeaderBarViewModel().getHeaderProvider().getBatterySummary().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda9(this));
        getHeaderBarViewModel().getHeaderProvider().getDownloadsInProgress().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda4(this));
        getHeaderBarViewModel().getHeaderProvider().getFirmwareUpdateAvailable().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda6(this));
        getHeaderBarViewModel().getHeaderProvider().getSettingsOpened().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda3(this));
        getHeaderBarViewModel().getHeaderProvider().getMediaPlayerOpened().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda5(this));
        ((ConstraintLayout) getBinding().getRoot()).setOnClickListener(new MainContentHeaderFragment$$ExternalSyntheticLambda0(this));
        getHeaderBarViewModel().getHeaderProvider().getSleepTimeTick().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda8(this));
        getHeaderBarViewModel().getHeaderProvider().getTimeLimitTick().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda7(this));
        getHeaderBarViewModel().getHeaderProvider().getLockedMode().observe(getViewLifecycleOwner(), new MainContentHeaderFragment$$ExternalSyntheticLambda1(this));
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m2419onCreateView$lambda0(MainContentHeaderFragment mainContentHeaderFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "offline");
        if (bool.booleanValue() && !mainContentHeaderFragment.getHeaderBarViewModel().isCurrentlyInOfflineMode()) {
            mainContentHeaderFragment.enableOfflineMode();
        } else if (!bool.booleanValue() && mainContentHeaderFragment.getHeaderBarViewModel().isCurrentlyInOfflineMode()) {
            mainContentHeaderFragment.disableOfflineMode();
        }
        mainContentHeaderFragment.getHeaderBarViewModel().setCurrentlyInOfflineMode(bool.booleanValue());
        ConnectionState connectionState = bool.booleanValue() ? ConnectionState.NOT_CONNECTED : ConnectionState.CONNECTED;
        FragmentHeaderBarBinding binding2 = mainContentHeaderFragment.getBinding();
        WifiItem wifiItem = mainContentHeaderFragment.getBinding().getWifiItem();
        binding2.setWifiItem(wifiItem != null ? WifiItem.copy$default(wifiItem, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, connectionState, true, 15, (Object) null) : null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m2420onCreateView$lambda1(MainContentHeaderFragment mainContentHeaderFragment, WifiStrength wifiStrength) {
        WifiItem wifiItem;
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        ConnectionState connectionState = (wifiStrength == WifiStrength.NO_WIFI || mainContentHeaderFragment.getHeaderBarViewModel().isCurrentlyInOfflineMode()) ? ConnectionState.NOT_CONNECTED : ConnectionState.CONNECTED;
        if (mainContentHeaderFragment.getBinding().getWifiItem() == null) {
            FragmentHeaderBarBinding binding2 = mainContentHeaderFragment.getBinding();
            Intrinsics.checkNotNullExpressionValue(wifiStrength, "wifiStrength");
            binding2.setWifiItem(new WifiItem(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, "", wifiStrength, SecurityMode.OPEN, connectionState, false, 32, (DefaultConstructorMarker) null));
        }
        FragmentHeaderBarBinding binding3 = mainContentHeaderFragment.getBinding();
        WifiItem wifiItem2 = mainContentHeaderFragment.getBinding().getWifiItem();
        if (wifiItem2 != null) {
            Intrinsics.checkNotNullExpressionValue(wifiStrength, "wifiStrength");
            wifiItem = WifiItem.copy$default(wifiItem2, (String) null, (String) null, wifiStrength, (SecurityMode) null, connectionState, true, 11, (Object) null);
        } else {
            wifiItem = null;
        }
        binding3.setWifiItem(wifiItem);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-2  reason: not valid java name */
    public static final void m2423onCreateView$lambda2(MainContentHeaderFragment mainContentHeaderFragment, BatterySummary batterySummary) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        mainContentHeaderFragment.getBinding().setBatterySummary(batterySummary);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-3  reason: not valid java name */
    public static final void m2424onCreateView$lambda3(MainContentHeaderFragment mainContentHeaderFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        mainContentHeaderFragment.getBinding().setDownloadsInProgress(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-4  reason: not valid java name */
    public static final void m2425onCreateView$lambda4(MainContentHeaderFragment mainContentHeaderFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        mainContentHeaderFragment.getBinding().setFirmwareUpdateAvailable(bool);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-5  reason: not valid java name */
    public static final void m2426onCreateView$lambda5(MainContentHeaderFragment mainContentHeaderFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        mainContentHeaderFragment.getBinding().setSettingsOpened(bool);
        View view = mainContentHeaderFragment.getView();
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "opened");
            view.setVisibility(bool.booleanValue() ? 8 : 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-6  reason: not valid java name */
    public static final void m2427onCreateView$lambda6(MainContentHeaderFragment mainContentHeaderFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        View view = mainContentHeaderFragment.getView();
        if (view != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "opened");
            view.setVisibility(bool.booleanValue() ? 8 : 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-7  reason: not valid java name */
    public static final void m2428onCreateView$lambda7(MainContentHeaderFragment mainContentHeaderFragment, View view) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        NavController findNavController = FragmentKt.findNavController(mainContentHeaderFragment);
        if (findNavController.getBackQueue().size() > 2 && !Intrinsics.areEqual((Object) findNavController.getBackQueue().last().getDestination(), (Object) findNavController.findDestination((int) C2814R.C2817id.offlineModeFragment))) {
            findNavController.navigateUp();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-9  reason: not valid java name */
    public static final void m2429onCreateView$lambda9(MainContentHeaderFragment mainContentHeaderFragment, Integer num) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(num, "secondsUntilFinished");
        int secondsToMinutes = TimeKt.secondsToMinutes(num.intValue()) + 1;
        TextView textView = mainContentHeaderFragment.getBinding().headerCountDownTime;
        textView.setVisibility(num.intValue() == 0 ? 8 : 0);
        if (num.intValue() <= 0) {
            textView.setText("");
        } else if (secondsToMinutes > 1) {
            textView.setText(DateUtilsKt.toHumanHHMMorSSString(((long) secondsToMinutes) * ((long) 60) * ((long) 1000)));
        } else if (num.intValue() <= 60) {
            textView.setText(DateUtilsKt.toHumanHHMMorSSString(((long) num.intValue()) * ((long) 1000)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-12  reason: not valid java name */
    public static final void m2421onCreateView$lambda12(MainContentHeaderFragment mainContentHeaderFragment, Integer num) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        LinearLayout linearLayout = mainContentHeaderFragment.getBinding().headerLimitTimer;
        mainContentHeaderFragment.getBinding().headerLimitTimerText.setText(DateUtilsKt.toHumanHHMMorSSString(((long) num.intValue()) * ((long) 1000)));
        Intrinsics.checkNotNullExpressionValue(num, "remainingUsageTimeSeconds");
        linearLayout.setVisibility(num.intValue() <= 0 ? 8 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-13  reason: not valid java name */
    public static final void m2422onCreateView$lambda13(MainContentHeaderFragment mainContentHeaderFragment, LockedModeReason lockedModeReason) {
        Intrinsics.checkNotNullParameter(mainContentHeaderFragment, "this$0");
        int i = lockedModeReason == null ? -1 : WhenMappings.$EnumSwitchMapping$0[lockedModeReason.ordinal()];
        if (i == 1) {
            mainContentHeaderFragment.enableLockScreen(LockedModeReason.USAGE_LIMIT);
        } else if (i != 2) {
            mainContentHeaderFragment.disableLockScreen();
        } else {
            mainContentHeaderFragment.enableLockScreen(LockedModeReason.WINDOWED_LIMIT);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getHeaderBarViewModel().onViewPrepared();
    }

    public void onDestroyView() {
        super.onDestroyView();
        getHeaderBarViewModel().onViewDestroyed();
    }

    private final void disableOfflineMode() {
        disableOffline();
        removeCurrentTimeAndDate();
    }

    private final void enableOfflineMode() {
        storeCurrentTimeAndDate();
        enableOffline();
    }

    private final void storeCurrentTimeAndDate() {
        getHeaderBarViewModel().storeCurrentTimeAndDate();
    }

    private final void removeCurrentTimeAndDate() {
        getHeaderBarViewModel().removeCurrentTimeAndDate();
    }

    public final void showHeaderTitle(String str) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        getBinding().headerContentTitle.setText(str);
    }

    public final void hideCloseButton() {
        getBinding().headerCloseButton.setVisibility(8);
    }

    public final void showCloseButton() {
        getBinding().headerCloseButton.setVisibility(0);
    }
}
