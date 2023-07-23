package media.tiger.tigerbox.p016ui.common.wifi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.p003os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.NavArgsLazy;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import dagger.hilt.android.AndroidEntryPoint;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentWifiEnterPasswordBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0013\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010,\u001a\u00020\u001cH\u0002J\b\u0010-\u001a\u00020\u001cH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8B@BX\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiEnterPasswordFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenDialogFragment;", "()V", "args", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiEnterPasswordFragmentArgs;", "getArgs", "()Lmedia/tiger/tigerbox/ui/common/wifi/WifiEnterPasswordFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentWifiEnterPasswordBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentWifiEnterPasswordBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentWifiEnterPasswordBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "closeHandler", "media/tiger/tigerbox/ui/common/wifi/WifiEnterPasswordFragment$closeHandler$1", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiEnterPasswordFragment$closeHandler$1;", "wifiEnterPasswordViewModel", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiEnterPasswordViewModel;", "getWifiEnterPasswordViewModel", "()Lmedia/tiger/tigerbox/ui/common/wifi/WifiEnterPasswordViewModel;", "wifiEnterPasswordViewModel$delegate", "Lkotlin/Lazy;", "closeSafely", "", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "passwordConfirmed", "setupObservers", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordFragment */
/* compiled from: WifiEnterPasswordFragment.kt */
public final class WifiEnterPasswordFragment extends Hilt_WifiEnterPasswordFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(WifiEnterPasswordFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentWifiEnterPasswordBinding;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PASSWORD = "PASSWORD";
    public static final String REQUEST_KEY = "WIFI_ENTER_PASSWORD_FRAGMENT_REQUEST_KEY";
    private final NavArgsLazy args$delegate;
    private final AutoClearedValue binding$delegate;
    private final WifiEnterPasswordFragment$closeHandler$1 closeHandler = new WifiEnterPasswordFragment$closeHandler$1(this);
    private final Lazy wifiEnterPasswordViewModel$delegate;

    public ImageView getCloseButton() {
        return null;
    }

    public WifiEnterPasswordFragment() {
        Fragment fragment = this;
        Function0 wifiEnterPasswordFragment$special$$inlined$viewModels$default$1 = new WifiEnterPasswordFragment$special$$inlined$viewModels$default$1(fragment);
        this.wifiEnterPasswordViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(WifiEnterPasswordViewModel.class), new WifiEnterPasswordFragment$special$$inlined$viewModels$default$2(wifiEnterPasswordFragment$special$$inlined$viewModels$default$1), new WifiEnterPasswordFragment$special$$inlined$viewModels$default$3(wifiEnterPasswordFragment$special$$inlined$viewModels$default$1, fragment));
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.args$delegate = new NavArgsLazy(Reflection.getOrCreateKotlinClass(WifiEnterPasswordFragmentArgs.class), new WifiEnterPasswordFragment$special$$inlined$navArgs$1(fragment));
    }

    private final WifiEnterPasswordViewModel getWifiEnterPasswordViewModel() {
        return (WifiEnterPasswordViewModel) this.wifiEnterPasswordViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final FragmentWifiEnterPasswordBinding getBinding() {
        return (FragmentWifiEnterPasswordBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentWifiEnterPasswordBinding fragmentWifiEnterPasswordBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentWifiEnterPasswordBinding);
    }

    private final WifiEnterPasswordFragmentArgs getArgs() {
        return (WifiEnterPasswordFragmentArgs) this.args$delegate.getValue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, C2814R.C2823style.FullscreenDialogThemeNoFloating);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentWifiEnterPasswordBinding inflate = FragmentWifiEnterPasswordBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        inflate.wifiEnterPswConfirmButton.setOnClickListener(new WifiEnterPasswordFragment$$ExternalSyntheticLambda0(this));
        TextInputEditText textInputEditText = inflate.wifiEnterPswEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "wifiEnterPswEditText");
        textInputEditText.addTextChangedListener(new C2923x19805837(inflate, this));
        setBinding(inflate);
        getBinding().setCloseHandler(this.closeHandler);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-2$lambda-0  reason: not valid java name */
    public static final void m2381onCreateView$lambda2$lambda0(WifiEnterPasswordFragment wifiEnterPasswordFragment, View view) {
        Intrinsics.checkNotNullParameter(wifiEnterPasswordFragment, "this$0");
        wifiEnterPasswordFragment.passwordConfirmed();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getBinding().setWifiName(getArgs().getWifiName());
        setupObservers();
        getWifiEnterPasswordViewModel().viewPrepared(getArgs().getWifiName());
    }

    public DialogViewModel getViewModel() {
        return getWifiEnterPasswordViewModel();
    }

    public void closeSafely() {
        this.closeHandler.onClick();
    }

    private final void setupObservers() {
        getWifiEnterPasswordViewModel().getPassword().observe(getViewLifecycleOwner(), new WifiEnterPasswordFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupObservers$lambda-3  reason: not valid java name */
    public static final void m2382setupObservers$lambda3(WifiEnterPasswordFragment wifiEnterPasswordFragment, String str) {
        Intrinsics.checkNotNullParameter(wifiEnterPasswordFragment, "this$0");
        wifiEnterPasswordFragment.getBinding().setPassword(str);
        TextInputLayout textInputLayout = wifiEnterPasswordFragment.getBinding().wifiEnterPswEditTextLayout;
        Intrinsics.checkNotNullExpressionValue(str, "password");
        textInputLayout.setPasswordVisibilityToggleEnabled(StringsKt.isBlank(str));
    }

    private final void passwordConfirmed() {
        Fragment fragment = this;
        FragmentKt.setFragmentResult(fragment, REQUEST_KEY, BundleKt.bundleOf(TuplesKt.m475to(PASSWORD, String.valueOf(getBinding().wifiEnterPswEditText.getText()))));
        androidx.navigation.fragment.FragmentKt.findNavController(fragment).navigateUp();
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/wifi/WifiEnterPasswordFragment$Companion;", "", "()V", "PASSWORD", "", "REQUEST_KEY", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordFragment$Companion */
    /* compiled from: WifiEnterPasswordFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
