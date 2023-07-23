package media.tiger.tigerbox.p016ui.settings;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavArgsLazy;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentFullscreenSeekbarBinding;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;
import media.tiger.tigerbox.extension.TimeKt;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001DB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020 H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0016J$\u00101\u001a\u0002002\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u000107H\u0016J\"\u00108\u001a\u00020.2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020 H\u0016J\u0012\u0010=\u001a\u00020.2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0012\u0010>\u001a\u00020.2\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u001a\u0010?\u001a\u00020.2\u0006\u0010@\u001a\u0002002\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0017\u0010A\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\u0010CR\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128B@BX\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\bR\u000e\u0010#\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/FullScreenSeekBarFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenFragment;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/View$OnClickListener;", "()V", "_maxValue", "", "get_maxValue", "()I", "_maxValue$delegate", "Lkotlin/Lazy;", "args", "Lmedia/tiger/tigerbox/ui/settings/FullScreenSeekBarFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/settings/FullScreenSeekBarFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentFullscreenSeekbarBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentFullscreenSeekbarBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentFullscreenSeekbarBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "fullscreenSeekBarViewModel", "Lmedia/tiger/tigerbox/ui/settings/FullScreenSeekBarViewModel;", "getFullscreenSeekBarViewModel", "()Lmedia/tiger/tigerbox/ui/settings/FullScreenSeekBarViewModel;", "fullscreenSeekBarViewModel$delegate", "ignoreProgressChanged", "", "maxValue", "getMaxValue", "musicChangedFromListener", "musicChangedFromSeekBar", "getHeaderBinding", "Lmedia/tiger/tigerbox/databinding/IncludeDialogHeaderBarBinding;", "getProgress", "dialogType", "Lmedia/tiger/tigerbox/ui/settings/SeekBarDialogType;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "isAtTheEndOfTheProduct", "onClick", "", "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onProgressChanged", "seekBar", "Landroid/widget/SeekBar;", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "onViewCreated", "view", "parseSleepProgress", "sleepMinutes", "(Ljava/lang/Integer;)I", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.FullScreenSeekBarFragment */
/* compiled from: FullScreenSeekBarFragment.kt */
public final class FullScreenSeekBarFragment extends Hilt_FullScreenSeekBarFragment implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(FullScreenSeekBarFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentFullscreenSeekbarBinding;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int THUMB_OFFSET = 24;
    private static final int THUMB_OFFSET_SLEEP_TIMER = 60;
    private final Lazy _maxValue$delegate = LazyKt.lazy(new FullScreenSeekBarFragment$_maxValue$2(this));
    private final NavArgsLazy args$delegate;
    private final AutoClearedValue binding$delegate;
    private final Lazy fullscreenSeekBarViewModel$delegate;
    private boolean ignoreProgressChanged = true;
    private boolean musicChangedFromListener;
    private boolean musicChangedFromSeekBar;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.FullScreenSeekBarFragment$WhenMappings */
    /* compiled from: FullScreenSeekBarFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SeekBarDialogType.values().length];
            iArr[SeekBarDialogType.SLEEP_TIMER.ordinal()] = 1;
            iArr[SeekBarDialogType.VOLUME.ordinal()] = 2;
            iArr[SeekBarDialogType.SCREEN_BRIGHTNESS.ordinal()] = 3;
            iArr[SeekBarDialogType.TIGER_LIGHT_INTENSITY.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public FullScreenSeekBarFragment() {
        Fragment fragment = this;
        Function0 fullScreenSeekBarFragment$special$$inlined$viewModels$default$1 = new FullScreenSeekBarFragment$special$$inlined$viewModels$default$1(fragment);
        this.fullscreenSeekBarViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(FullScreenSeekBarViewModel.class), new FullScreenSeekBarFragment$special$$inlined$viewModels$default$2(fullScreenSeekBarFragment$special$$inlined$viewModels$default$1), new FullScreenSeekBarFragment$special$$inlined$viewModels$default$3(fullScreenSeekBarFragment$special$$inlined$viewModels$default$1, fragment));
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(FullScreenSeekBarFragmentArgs.class), new FullScreenSeekBarFragment$special$$inlined$navArgs$1(fragment));
    }

    private final FullScreenSeekBarViewModel getFullscreenSeekBarViewModel() {
        return (FullScreenSeekBarViewModel) this.fullscreenSeekBarViewModel$delegate.getValue();
    }

    private final FragmentFullscreenSeekbarBinding getBinding() {
        return (FragmentFullscreenSeekbarBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentFullscreenSeekbarBinding fragmentFullscreenSeekbarBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentFullscreenSeekbarBinding);
    }

    /* access modifiers changed from: private */
    public final FullScreenSeekBarFragmentArgs getArgs() {
        return (FullScreenSeekBarFragmentArgs) this.args$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentFullscreenSeekbarBinding inflate = FragmentFullscreenSeekbarBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Drawable drawable = AppCompatResources.getDrawable(view.getContext(), getArgs().getSeekBarType().getThumbId());
        if (drawable != null) {
            getBinding().settingsSeekbarSeekbar.setThumb(drawable);
        }
        getBinding().settingsSeekbarSeekbar.setMax(100);
        getBinding().settingsSeekbarSeekbar.setProgressDrawable(AppCompatResources.getDrawable(view.getContext(), getArgs().getSeekBarType().getBackgroundId()));
        getBinding().settingsSeekbarSeekbar.setProgress(getProgress(getArgs().getSeekBarType()));
        View.OnClickListener onClickListener = this;
        getBinding().settingsSeekbarContent.setOnClickListener(onClickListener);
        getBinding().settingsSeekbarButton.setOnClickListener(onClickListener);
        getBinding().settingsSeekbarSeekbar.setOnSeekBarChangeListener(this);
        if (WhenMappings.$EnumSwitchMapping$0[getArgs().getSeekBarType().ordinal()] == 1) {
            getBinding().settingsSeekbarSeekbar.setMax(getMaxValue());
            if (getBinding().settingsSeekbarSeekbar.getProgress() == 0) {
                View childAt = getBinding().settingsSeekbarSleepValue.getChildAt(0);
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
                BindingAdaptersKt.setImageTint((ImageView) childAt, getResources().getColor(C2814R.C2815color.main_theme_color));
            } else {
                View childAt2 = getBinding().settingsSeekbarSleepValue.getChildAt(getBinding().settingsSeekbarSeekbar.getProgress());
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) childAt2).setTextColor(getResources().getColor(C2814R.C2815color.main_theme_color));
            }
            SeekBar seekBar = getBinding().settingsSeekbarSeekbar;
            Intrinsics.checkNotNullExpressionValue(seekBar, "binding.settingsSeekbarSeekbar");
            seekBar.setPadding(100, 0, 100, 0);
            getBinding().settingsSeekbarSeekbar.setThumbOffset(60);
            getBinding().settingsSeekbarSleepValue.setVisibility(0);
            getBinding().settingsSeekbarButton.setVisibility(8);
            getBinding().settingsSeekbarButton.setChecked(isAtTheEndOfTheProduct());
            if (isAtTheEndOfTheProduct()) {
                getBinding().settingsSeekbarButton.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C2814R.C2816drawable.vector_wifi_status_connected, 0);
            }
            getBinding().settingsSeekbarButton.setOnCheckedChangeListener(new FullScreenSeekBarFragment$$ExternalSyntheticLambda0(this));
        } else {
            SeekBar seekBar2 = getBinding().settingsSeekbarSeekbar;
            Intrinsics.checkNotNullExpressionValue(seekBar2, "binding.settingsSeekbarSeekbar");
            seekBar2.setPadding(50, 0, 50, 0);
            getBinding().settingsSeekbarSeekbar.setThumbOffset(24);
            getBinding().settingsSeekbarSleepValue.setVisibility(8);
            getBinding().settingsSeekbarButton.setVisibility(8);
        }
        getFullscreenSeekBarViewModel().getHeaderProvider().getMaxVolumeChanged().observe(getViewLifecycleOwner(), new FullScreenSeekBarFragment$$ExternalSyntheticLambda2(this));
        getFullscreenSeekBarViewModel().getHeaderProvider().getMusicVolumeChanged().observe(getViewLifecycleOwner(), new FullScreenSeekBarFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m2500onViewCreated$lambda1(FullScreenSeekBarFragment fullScreenSeekBarFragment, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(fullScreenSeekBarFragment, "this$0");
        if (z) {
            compoundButton.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C2814R.C2816drawable.vector_wifi_status_connected, 0);
            fullScreenSeekBarFragment.getBinding().settingsSeekbarSeekbar.setProgress(0);
            compoundButton.setChecked(true);
            fullScreenSeekBarFragment.getFullscreenSeekBarViewModel().shutDownTimerServiceAtEndOfPlayback();
            return;
        }
        fullScreenSeekBarFragment.getFullscreenSeekBarViewModel().shutDownTimerServiceCancelTimer();
        compoundButton.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m2501onViewCreated$lambda2(FullScreenSeekBarFragment fullScreenSeekBarFragment, Integer num) {
        Intrinsics.checkNotNullParameter(fullScreenSeekBarFragment, "this$0");
        if (!fullScreenSeekBarFragment.musicChangedFromSeekBar) {
            fullScreenSeekBarFragment.getBinding().settingsSeekbarSeekbar.setProgress(fullScreenSeekBarFragment.getProgress(fullScreenSeekBarFragment.getArgs().getSeekBarType()));
            fullScreenSeekBarFragment.musicChangedFromListener = true;
        }
        fullScreenSeekBarFragment.musicChangedFromSeekBar = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-3  reason: not valid java name */
    public static final void m2502onViewCreated$lambda3(FullScreenSeekBarFragment fullScreenSeekBarFragment, Integer num) {
        Intrinsics.checkNotNullParameter(fullScreenSeekBarFragment, "this$0");
        if (!fullScreenSeekBarFragment.musicChangedFromSeekBar) {
            fullScreenSeekBarFragment.getBinding().settingsSeekbarSeekbar.setProgress(fullScreenSeekBarFragment.getProgress(fullScreenSeekBarFragment.getArgs().getSeekBarType()));
            fullScreenSeekBarFragment.musicChangedFromListener = true;
        }
        fullScreenSeekBarFragment.musicChangedFromSeekBar = false;
    }

    private final boolean isAtTheEndOfTheProduct() {
        return getFullscreenSeekBarViewModel().getShutDownTimerServiceAtEndOfProduct();
    }

    public DialogViewModel getViewModel() {
        return getFullscreenSeekBarViewModel();
    }

    public IncludeDialogHeaderBarBinding getHeaderBinding() {
        IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding = getBinding().fragmentHeaderBar;
        Intrinsics.checkNotNullExpressionValue(includeDialogHeaderBarBinding, "binding.fragmentHeaderBar");
        return includeDialogHeaderBarBinding;
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        if (view.getId() == C2814R.C2817id.f1767settingsseekbarcontent) {
            closeSafely();
        }
    }

    private final int get_maxValue() {
        return ((Number) this._maxValue$delegate.getValue()).intValue();
    }

    private final int getMaxValue() {
        if (WhenMappings.$EnumSwitchMapping$0[getArgs().getSeekBarType().ordinal()] == 2) {
            return getFullscreenSeekBarViewModel().getMetadataServiceMaxVolume();
        }
        return get_maxValue();
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        int i2;
        if (this.musicChangedFromListener) {
            this.musicChangedFromListener = false;
            return;
        }
        this.musicChangedFromSeekBar = true;
        int maxValue = (int) (((float) getMaxValue()) * (((float) i) / 100.0f));
        int i3 = WhenMappings.$EnumSwitchMapping$0[getArgs().getSeekBarType().ordinal()];
        if (i3 == 1) {
            int childCount = getBinding().settingsSeekbarSleepValue.getChildCount();
            for (int i4 = 1; i4 < childCount; i4++) {
                View childAt = getBinding().settingsSeekbarSleepValue.getChildAt(i4);
                Objects.requireNonNull(childAt, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) childAt).setTextColor(getResources().getColor(C2814R.C2815color.white));
            }
            View childAt2 = getBinding().settingsSeekbarSleepValue.getChildAt(0);
            Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.widget.ImageView");
            BindingAdaptersKt.setImageTint((ImageView) childAt2, getResources().getColor(C2814R.C2815color.white));
            if (i == 0) {
                View childAt3 = getBinding().settingsSeekbarSleepValue.getChildAt(0);
                Objects.requireNonNull(childAt3, "null cannot be cast to non-null type android.widget.ImageView");
                BindingAdaptersKt.setImageTint((ImageView) childAt3, getResources().getColor(C2814R.C2815color.main_theme_color));
                i2 = 0;
            } else {
                View childAt4 = getBinding().settingsSeekbarSleepValue.getChildAt(i);
                Objects.requireNonNull(childAt4, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) childAt4;
                textView.setTextColor(getResources().getColor(C2814R.C2815color.main_theme_color));
                i2 = TimeKt.minutesToSeconds(Integer.parseInt(textView.getText().toString()));
            }
            getBinding().settingsSeekbarButton.setChecked(false);
            if (!this.ignoreProgressChanged) {
                if (i != 0) {
                    getFullscreenSeekBarViewModel().shutDownTimerServiceStartTimer(i2);
                } else {
                    getFullscreenSeekBarViewModel().shutDownTimerServiceCancelTimer();
                }
            }
            this.ignoreProgressChanged = false;
        } else if (i3 == 2) {
            getFullscreenSeekBarViewModel().setMetadataServiceVolume(maxValue);
        } else if (i3 == 3) {
            getFullscreenSeekBarViewModel().setMetadataServiceScreenBrightness(maxValue);
        } else if (i3 == 4) {
            getFullscreenSeekBarViewModel().setLightControlServiceTigerLightIntensity(maxValue);
        }
    }

    private final int getProgress(SeekBarDialogType seekBarDialogType) {
        int i;
        int i2;
        int i3 = WhenMappings.$EnumSwitchMapping$0[seekBarDialogType.ordinal()];
        if (i3 == 1) {
            if (getFullscreenSeekBarViewModel().getShutDownTimerServiceCurrentShutDownTimeSeconds() <= 0) {
                i2 = 0;
            } else {
                i2 = TimeKt.secondsToMinutes(getFullscreenSeekBarViewModel().getShutDownTimerServiceCurrentShutDownTimeSeconds()) + 1;
            }
            i = parseSleepProgress(Integer.valueOf(i2));
        } else if (i3 == 2) {
            i = (int) (getFullscreenSeekBarViewModel().getStorageServiceVolume() * ((float) getMaxValue()));
        } else if (i3 == 3) {
            i = getFullscreenSeekBarViewModel().getMetadataServiceScreenBrightness();
        } else if (i3 == 4) {
            i = getFullscreenSeekBarViewModel().getLightControlServiceTigerLightIntensity();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (seekBarDialogType == SeekBarDialogType.SLEEP_TIMER) {
            return i;
        }
        return (int) ((((float) i) / ((float) getMaxValue())) * 100.0f);
    }

    private final int parseSleepProgress(Integer num) {
        if (num == null) {
            return 0;
        }
        int intValue = num.intValue();
        if (intValue >= 60) {
            return 8;
        }
        if (intValue >= 50) {
            return 7;
        }
        if (intValue >= 40) {
            return 6;
        }
        if (intValue >= 30) {
            return 5;
        }
        if (intValue >= 20) {
            return 4;
        }
        if (intValue >= 15) {
            return 3;
        }
        if (intValue >= 10) {
            return 2;
        }
        return intValue >= 1 ? 1 : 0;
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/FullScreenSeekBarFragment$Companion;", "", "()V", "THUMB_OFFSET", "", "THUMB_OFFSET_SLEEP_TIMER", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.FullScreenSeekBarFragment$Companion */
    /* compiled from: FullScreenSeekBarFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
