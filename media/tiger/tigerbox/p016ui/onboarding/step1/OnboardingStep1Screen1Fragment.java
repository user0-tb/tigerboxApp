package media.tiger.tigerbox.p016ui.onboarding.step1;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
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
import media.tiger.tigerbox.databinding.FragmentOnboardingStep1Screen1Binding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen1ViewModel;

@Metadata(mo33736d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1Fragment;", "Landroidx/fragment/app/Fragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentOnboardingStep1Screen1Binding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingStep1Screen1Binding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentOnboardingStep1Screen1Binding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "onboardingStep1Screen1ViewModel", "Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel;", "getOnboardingStep1Screen1ViewModel", "()Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel;", "onboardingStep1Screen1ViewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "showLoginScreen", "showMainContentScreen", "showNextOnBoardingScreen", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1Fragment */
/* compiled from: OnboardingStep1Screen1Fragment.kt */
public final class OnboardingStep1Screen1Fragment extends Hilt_OnboardingStep1Screen1Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OnboardingStep1Screen1Fragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingStep1Screen1Binding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy onboardingStep1Screen1ViewModel$delegate;

    public OnboardingStep1Screen1Fragment() {
        Fragment fragment = this;
        Function0 onboardingStep1Screen1Fragment$special$$inlined$viewModels$default$1 = new C2983x82e85132(fragment);
        this.onboardingStep1Screen1ViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(OnboardingStep1Screen1ViewModel.class), new C2984x82e85133(onboardingStep1Screen1Fragment$special$$inlined$viewModels$default$1), new C2985x82e85134(onboardingStep1Screen1Fragment$special$$inlined$viewModels$default$1, fragment));
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
    }

    private final OnboardingStep1Screen1ViewModel getOnboardingStep1Screen1ViewModel() {
        return (OnboardingStep1Screen1ViewModel) this.onboardingStep1Screen1ViewModel$delegate.getValue();
    }

    private final FragmentOnboardingStep1Screen1Binding getBinding() {
        return (FragmentOnboardingStep1Screen1Binding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentOnboardingStep1Screen1Binding fragmentOnboardingStep1Screen1Binding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentOnboardingStep1Screen1Binding);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentOnboardingStep1Screen1Binding inflate = FragmentOnboardingStep1Screen1Binding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getOnboardingStep1Screen1ViewModel().getNavigationEvent().observe(getViewLifecycleOwner(), new OnboardingStep1Screen1Fragment$$ExternalSyntheticLambda1(this));
        getBinding().onboardingStep1Button.setOnClickListener(new OnboardingStep1Screen1Fragment$$ExternalSyntheticLambda0(this));
        FragmentActivity activity = getActivity();
        boolean z = false;
        if (!(activity == null || (intent = activity.getIntent()) == null)) {
            z = intent.getBooleanExtra("logged_out", false);
        }
        getOnboardingStep1Screen1ViewModel().onViewPrepared(z);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m2474onViewCreated$lambda0(OnboardingStep1Screen1Fragment onboardingStep1Screen1Fragment, OnboardingStep1Screen1ViewModel.NavigationEvent navigationEvent) {
        Intrinsics.checkNotNullParameter(onboardingStep1Screen1Fragment, "this$0");
        if (Intrinsics.areEqual((Object) navigationEvent, (Object) OnboardingStep1Screen1ViewModel.NavigationEvent.NavigateToMainContent.INSTANCE)) {
            onboardingStep1Screen1Fragment.showMainContentScreen();
        } else if (Intrinsics.areEqual((Object) navigationEvent, (Object) OnboardingStep1Screen1ViewModel.NavigationEvent.NavigateToLogin.INSTANCE)) {
            onboardingStep1Screen1Fragment.showLoginScreen();
        } else if (Intrinsics.areEqual((Object) navigationEvent, (Object) OnboardingStep1Screen1ViewModel.NavigationEvent.NavigateToNextOnboardingScreen.INSTANCE)) {
            onboardingStep1Screen1Fragment.showNextOnBoardingScreen();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m2475onViewCreated$lambda1(OnboardingStep1Screen1Fragment onboardingStep1Screen1Fragment, View view) {
        Intrinsics.checkNotNullParameter(onboardingStep1Screen1Fragment, "this$0");
        onboardingStep1Screen1Fragment.getOnboardingStep1Screen1ViewModel().showNextScreen();
    }

    private final void showMainContentScreen() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_onboardingStep1Fragment_to_main_content, (Bundle) null, 2, (Object) null);
        requireActivity().finish();
    }

    private final void showNextOnBoardingScreen() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_onboardingStep1Fragment_to_onboardingStep2Fragment, (Bundle) null, 2, (Object) null);
    }

    private final void showLoginScreen() {
        OnboardingActivityKt.navigateActionSafe$default(FragmentKt.findNavController(this), C2814R.C2817id.action_onboarding_move_to_login_from_start, (Bundle) null, 2, (Object) null);
    }
}
