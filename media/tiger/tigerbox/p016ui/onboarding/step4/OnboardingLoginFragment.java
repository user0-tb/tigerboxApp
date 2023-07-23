package media.tiger.tigerbox.p016ui.onboarding.step4;

import android.os.Bundle;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentOnboardingLoginBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingViewModel;

@Metadata(mo33736d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingLoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentOnboardingLoginBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingLoginBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentOnboardingLoginBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "viewModel", "Lmedia/tiger/tigerbox/ui/onboarding/OnboardingViewModel;", "getViewModel", "()Lmedia/tiger/tigerbox/ui/onboarding/OnboardingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "dismissKeyboard", "", "windowToken", "Landroid/os/IBinder;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingLoginFragment */
/* compiled from: OnboardingLoginFragment.kt */
public final class OnboardingLoginFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OnboardingLoginFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingLoginBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy viewModel$delegate;

    public OnboardingLoginFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(OnboardingViewModel.class), new C3012x81be7b14(fragment), new C3013x81be7b15(fragment));
    }

    private final FragmentOnboardingLoginBinding getBinding() {
        return (FragmentOnboardingLoginBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentOnboardingLoginBinding fragmentOnboardingLoginBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentOnboardingLoginBinding);
    }

    private final OnboardingViewModel getViewModel() {
        return (OnboardingViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentOnboardingLoginBinding inflate = FragmentOnboardingLoginBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        boolean z;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        OnboardingViewModel viewModel = getViewModel();
        if (!getViewModel().getSessionTokenExpired()) {
            Bundle arguments = getArguments();
            Object obj = arguments != null ? arguments.get("sessionTokenExpired") : null;
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (!((Boolean) obj).booleanValue()) {
                z = false;
                viewModel.setSessionTokenExpired(z);
                getBinding().onboardingLoginButton.setOnClickListener(new OnboardingLoginFragment$$ExternalSyntheticLambda0(this));
            }
        }
        z = true;
        viewModel.setSessionTokenExpired(z);
        getBinding().onboardingLoginButton.setOnClickListener(new OnboardingLoginFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m2497onViewCreated$lambda0(OnboardingLoginFragment onboardingLoginFragment, View view) {
        Intrinsics.checkNotNullParameter(onboardingLoginFragment, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString("username", onboardingLoginFragment.getBinding().onboardingLoginUsernameEditText.getText().toString());
        bundle.putString("password", String.valueOf(onboardingLoginFragment.getBinding().onboardingLoginPasswordEditText.getText()));
        if (onboardingLoginFragment.getViewModel().getSessionTokenExpired()) {
            bundle.putBoolean("sessionTokenExpired", true);
        }
        IBinder windowToken = view.getWindowToken();
        Intrinsics.checkNotNullExpressionValue(windowToken, "it.windowToken");
        onboardingLoginFragment.dismissKeyboard(windowToken);
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(onboardingLoginFragment), C2814R.C2817id.f584x97d1efc7, bundle);
    }

    private final void dismissKeyboard(IBinder iBinder) {
        FragmentActivity activity = getActivity();
        InputMethodManager inputMethodManager = null;
        Object systemService = activity != null ? activity.getSystemService("input_method") : null;
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }
}
