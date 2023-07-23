package media.tiger.tigerbox.p016ui.common;

import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;
import media.tiger.tigerbox.extension.TimeKt;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.model.domain.ConnectionState;
import media.tiger.tigerbox.model.domain.SecurityMode;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.model.domain.WifiStrength;
import media.tiger.tigerbox.p016ui.settings.SettingsFragment;
import media.tiger.tigerbox.utils.DateUtilsKt;

@Metadata(mo33736d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u001a\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/FullScreenFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "uniqueIdentifier", "", "kotlin.jvm.PlatformType", "canShowSettings", "", "closeSafely", "", "getHeaderBinding", "Lmedia/tiger/tigerbox/databinding/IncludeDialogHeaderBarBinding;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onDestroy", "onStart", "onViewCreated", "view", "Landroid/view/View;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.FullScreenFragment */
/* compiled from: FullScreenFragment.kt */
public abstract class FullScreenFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FULLSCREEN_FRAGMENT_DID_CLOSE_RESULT_KEY = "FULLSCREEN_FRAGMENT_DID_CLOSE_RESULT_KEY";
    private final String uniqueIdentifier = getClass().getSimpleName();

    public boolean canShowSettings() {
        return true;
    }

    public abstract IncludeDialogHeaderBarBinding getHeaderBinding();

    public abstract DialogViewModel getViewModel();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, C2814R.C2823style.FullscreenTheme);
        setCancelable(false);
    }

    public void onDestroy() {
        super.onDestroy();
        DialogViewModel viewModel = getViewModel();
        if (viewModel != null) {
            viewModel.onViewExit();
        }
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setLayout(-1, -1);
        }
        IncludeDialogHeaderBarBinding headerBinding = getHeaderBinding();
        ConstraintLayout constraintLayout = null;
        KeyEvent.Callback root = headerBinding != null ? headerBinding.getRoot() : null;
        if (root instanceof ConstraintLayout) {
            constraintLayout = (ConstraintLayout) root;
        }
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new FullScreenFragment$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onStart$lambda-0  reason: not valid java name */
    public static final void m2361onStart$lambda0(FullScreenFragment fullScreenFragment, View view) {
        Intrinsics.checkNotNullParameter(fullScreenFragment, "this$0");
        fullScreenFragment.closeSafely();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        FullScreenFragment$onCreateDialog$dialog$1 fullScreenFragment$onCreateDialog$dialog$1 = new FullScreenFragment$onCreateDialog$dialog$1(this, requireContext(), getTheme());
        if (this instanceof SettingsFragment) {
            Window window = fullScreenFragment$onCreateDialog$dialog$1.getWindow();
            WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
            if (attributes != null) {
                attributes.windowAnimations = C2814R.C2823style.DialogAnimation;
            }
        }
        return fullScreenFragment$onCreateDialog$dialog$1;
    }

    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding] */
    /* JADX WARNING: type inference failed for: r0v3, types: [media.tiger.tigerbox.ui.binding.UnTypedBindingClickListener] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r12, android.os.Bundle r13) {
        /*
            r11 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            super.onViewCreated(r12, r13)
            media.tiger.tigerbox.ui.common.DialogViewModel r12 = r11.getViewModel()
            boolean r13 = r12 instanceof media.tiger.tigerbox.p016ui.common.FullScreenViewModel
            r0 = 0
            if (r13 == 0) goto L_0x0014
            media.tiger.tigerbox.ui.common.FullScreenViewModel r12 = (media.tiger.tigerbox.p016ui.common.FullScreenViewModel) r12
            goto L_0x0015
        L_0x0014:
            r12 = r0
        L_0x0015:
            if (r12 == 0) goto L_0x010d
            r12.onViewPrepared()
            media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding r13 = r11.getHeaderBinding()
            if (r13 == 0) goto L_0x006d
            media.tiger.tigerbox.model.domain.WifiItem r10 = new media.tiger.tigerbox.model.domain.WifiItem
            media.tiger.tigerbox.model.domain.WifiStrength r4 = media.tiger.tigerbox.model.domain.WifiStrength.WIFI_MEDIUM
            media.tiger.tigerbox.model.domain.SecurityMode r5 = media.tiger.tigerbox.model.domain.SecurityMode.OPEN
            r6 = 0
            r7 = 1
            r8 = 16
            r9 = 0
            java.lang.String r2 = "1"
            java.lang.String r3 = ""
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r13.setWifiItem(r10)
            media.tiger.tigerbox.model.domain.BatterySummary r1 = new media.tiger.tigerbox.model.domain.BatterySummary
            r2 = 0
            r3 = 0
            r1.<init>(r2, r3, r3)
            r13.setBatterySummary(r1)
            androidx.fragment.app.FragmentActivity r1 = r11.getActivity()
            boolean r2 = r1 instanceof media.tiger.tigerbox.p016ui.main.MainContentActivity
            if (r2 == 0) goto L_0x004b
            media.tiger.tigerbox.ui.main.MainContentActivity r1 = (media.tiger.tigerbox.p016ui.main.MainContentActivity) r1
            goto L_0x004c
        L_0x004b:
            r1 = r0
        L_0x004c:
            if (r1 == 0) goto L_0x0053
            media.tiger.tigerbox.ui.binding.BindingClickListener r1 = r1.getSettingsClickListener()
            goto L_0x0054
        L_0x0053:
            r1 = r0
        L_0x0054:
            r13.setSettingsClickListener(r1)
            androidx.fragment.app.FragmentActivity r1 = r11.getActivity()
            boolean r2 = r1 instanceof media.tiger.tigerbox.p016ui.main.MainContentActivity
            if (r2 == 0) goto L_0x0062
            media.tiger.tigerbox.ui.main.MainContentActivity r1 = (media.tiger.tigerbox.p016ui.main.MainContentActivity) r1
            goto L_0x0063
        L_0x0062:
            r1 = r0
        L_0x0063:
            if (r1 == 0) goto L_0x0069
            media.tiger.tigerbox.ui.binding.UnTypedBindingClickListener r0 = r1.getUpdateAvailableClickListener()
        L_0x0069:
            r13.setUpdateAvailableClickListener(r0)
            r0 = r13
        L_0x006d:
            media.tiger.tigerbox.services.interfaces.HeaderProvider r13 = r12.getHeaderProvider()
            androidx.lifecycle.LiveData r13 = r13.getWifiSignalStrength()
            androidx.lifecycle.LifecycleOwner r1 = r11.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda8 r2 = new media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda8
            r2.<init>(r12, r0)
            r13.observe(r1, r2)
            media.tiger.tigerbox.services.interfaces.HeaderProvider r13 = r12.getHeaderProvider()
            androidx.lifecycle.LiveData r13 = r13.getBatterySummary()
            androidx.lifecycle.LifecycleOwner r1 = r11.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda7 r2 = new media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda7
            r2.<init>(r0)
            r13.observe(r1, r2)
            media.tiger.tigerbox.services.interfaces.HeaderProvider r13 = r12.getHeaderProvider()
            androidx.lifecycle.LiveData r13 = r13.getDownloadsInProgress()
            androidx.lifecycle.LifecycleOwner r1 = r11.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda1 r2 = new media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda1
            r2.<init>(r0)
            r13.observe(r1, r2)
            media.tiger.tigerbox.services.interfaces.HeaderProvider r13 = r12.getHeaderProvider()
            androidx.lifecycle.LiveData r13 = r13.getFirmwareUpdateAvailable()
            androidx.lifecycle.LifecycleOwner r1 = r11.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda4 r2 = new media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda4
            r2.<init>(r0)
            r13.observe(r1, r2)
            media.tiger.tigerbox.services.interfaces.HeaderProvider r13 = r12.getHeaderProvider()
            androidx.lifecycle.MutableLiveData r13 = r13.getSettingsOpened()
            androidx.lifecycle.LifecycleOwner r1 = r11.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda3 r2 = new media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda3
            r2.<init>(r0)
            r13.observe(r1, r2)
            media.tiger.tigerbox.services.interfaces.HeaderProvider r13 = r12.getHeaderProvider()
            androidx.lifecycle.LiveData r13 = r13.getOfflineMode()
            androidx.lifecycle.LifecycleOwner r1 = r11.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda2 r2 = new media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda2
            r2.<init>(r0)
            r13.observe(r1, r2)
            media.tiger.tigerbox.services.interfaces.HeaderProvider r13 = r12.getHeaderProvider()
            androidx.lifecycle.LiveData r13 = r13.getSleepTimeTick()
            androidx.lifecycle.LifecycleOwner r1 = r11.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda6 r2 = new media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda6
            r2.<init>(r0)
            r13.observe(r1, r2)
            media.tiger.tigerbox.services.interfaces.HeaderProvider r12 = r12.getHeaderProvider()
            androidx.lifecycle.LiveData r12 = r12.getTimeLimitTick()
            androidx.lifecycle.LifecycleOwner r13 = r11.getViewLifecycleOwner()
            media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda5 r1 = new media.tiger.tigerbox.ui.common.FullScreenFragment$$ExternalSyntheticLambda5
            r1.<init>(r0)
            r12.observe(r13, r1)
        L_0x010d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.common.FullScreenFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14$lambda-2  reason: not valid java name */
    public static final void m2364onViewCreated$lambda14$lambda2(FullScreenViewModel fullScreenViewModel, IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, WifiStrength wifiStrength) {
        Intrinsics.checkNotNullParameter(fullScreenViewModel, "$viewModel");
        ConnectionState connectionState = (wifiStrength == WifiStrength.NO_WIFI || Intrinsics.areEqual((Object) fullScreenViewModel.getHeaderProvider().getOfflineMode().getValue(), (Object) true)) ? ConnectionState.NOT_CONNECTED : ConnectionState.CONNECTED;
        WifiItem wifiItem = null;
        if ((includeDialogHeaderBarBinding != null ? includeDialogHeaderBarBinding.getWifiItem() : null) == null && includeDialogHeaderBarBinding != null) {
            Intrinsics.checkNotNullExpressionValue(wifiStrength, "wifiStrength");
            includeDialogHeaderBarBinding.setWifiItem(new WifiItem(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, "", wifiStrength, SecurityMode.OPEN, connectionState, false, 32, (DefaultConstructorMarker) null));
        }
        if (includeDialogHeaderBarBinding != null) {
            WifiItem wifiItem2 = includeDialogHeaderBarBinding.getWifiItem();
            if (wifiItem2 != null) {
                Intrinsics.checkNotNullExpressionValue(wifiStrength, "wifiStrength");
                wifiItem = WifiItem.copy$default(wifiItem2, (String) null, (String) null, wifiStrength, (SecurityMode) null, connectionState, true, 11, (Object) null);
            }
            includeDialogHeaderBarBinding.setWifiItem(wifiItem);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14$lambda-3  reason: not valid java name */
    public static final void m2365onViewCreated$lambda14$lambda3(IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, BatterySummary batterySummary) {
        if (includeDialogHeaderBarBinding != null) {
            includeDialogHeaderBarBinding.setBatterySummary(batterySummary);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14$lambda-4  reason: not valid java name */
    public static final void m2366onViewCreated$lambda14$lambda4(IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, Boolean bool) {
        if (includeDialogHeaderBarBinding != null) {
            includeDialogHeaderBarBinding.setDownloadsInProgress(bool);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14$lambda-5  reason: not valid java name */
    public static final void m2367onViewCreated$lambda14$lambda5(IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, Boolean bool) {
        if (includeDialogHeaderBarBinding != null) {
            includeDialogHeaderBarBinding.setFirmwareUpdateAvailable(bool);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14$lambda-6  reason: not valid java name */
    public static final void m2368onViewCreated$lambda14$lambda6(IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, Boolean bool) {
        if (includeDialogHeaderBarBinding != null) {
            includeDialogHeaderBarBinding.setSettingsOpened(bool);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14$lambda-8  reason: not valid java name */
    public static final void m2369onViewCreated$lambda14$lambda8(IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, Boolean bool) {
        WifiItem wifiItem;
        if (includeDialogHeaderBarBinding != null) {
            Intrinsics.checkNotNullExpressionValue(bool, "offline");
            ConnectionState connectionState = bool.booleanValue() ? ConnectionState.NOT_CONNECTED : ConnectionState.CONNECTED;
            WifiItem wifiItem2 = includeDialogHeaderBarBinding.getWifiItem();
            if (wifiItem2 != null) {
                Intrinsics.checkNotNullExpressionValue(wifiItem2, "wifiItem");
                wifiItem = WifiItem.copy$default(wifiItem2, (String) null, (String) null, (WifiStrength) null, (SecurityMode) null, connectionState, true, 15, (Object) null);
            } else {
                wifiItem = null;
            }
            includeDialogHeaderBarBinding.setWifiItem(wifiItem);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14$lambda-10  reason: not valid java name */
    public static final void m2362onViewCreated$lambda14$lambda10(IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, Integer num) {
        TextView textView;
        Intrinsics.checkNotNullExpressionValue(num, "secondsUntilFinished");
        int secondsToMinutes = TimeKt.secondsToMinutes(num.intValue()) + 1;
        if (includeDialogHeaderBarBinding != null && (textView = includeDialogHeaderBarBinding.includeHeaderCountDownTime) != null) {
            textView.setVisibility(num.intValue() == 0 ? 8 : 0);
            if (num.intValue() <= 0) {
                textView.setText("");
            } else if (secondsToMinutes > 1) {
                textView.setText(DateUtilsKt.toHumanHHMMorSSString(((long) secondsToMinutes) * ((long) 60) * ((long) 1000)));
            } else if (num.intValue() <= 60) {
                textView.setText(DateUtilsKt.toHumanHHMMorSSString(((long) num.intValue()) * ((long) 1000)));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-14$lambda-13  reason: not valid java name */
    public static final void m2363onViewCreated$lambda14$lambda13(IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, Integer num) {
        LinearLayout linearLayout;
        if (includeDialogHeaderBarBinding != null && (linearLayout = includeDialogHeaderBarBinding.headerLimitTimer) != null) {
            includeDialogHeaderBarBinding.headerLimitTimerText.setText(DateUtilsKt.toHumanHHMMorSSString(((long) num.intValue()) * ((long) 1000)));
            int i = 8;
            if (num == null || num.intValue() != -1) {
                Intrinsics.checkNotNullExpressionValue(num, "remainingUsageTimeSeconds");
                if (num.intValue() > 0) {
                    i = 0;
                }
            }
            linearLayout.setVisibility(i);
        }
    }

    public void closeSafely() {
        FragmentKt.findNavController(this).navigateUp();
        requireActivity().getSupportFragmentManager().setFragmentResult(FULLSCREEN_FRAGMENT_DID_CLOSE_RESULT_KEY, BundleKt.bundleOf(TuplesKt.m475to("", "")));
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/FullScreenFragment$Companion;", "", "()V", "FULLSCREEN_FRAGMENT_DID_CLOSE_RESULT_KEY", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.FullScreenFragment$Companion */
    /* compiled from: FullScreenFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
