package media.tiger.tigerbox.p016ui.onboarding.step4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import media.tiger.tigerbox.databinding.FragmentOnboardingBackendCommunicationBinding;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.exception.LoginFailure;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;

@Metadata(mo33736d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendCommunicationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBackendCommunicationBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBackendCommunicationBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBackendCommunicationBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "onboardingBackendCommunicationViewModel", "Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendCommunicationViewModel;", "getOnboardingBackendCommunicationViewModel", "()Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendCommunicationViewModel;", "onboardingBackendCommunicationViewModel$delegate", "Lkotlin/Lazy;", "handleFailure", "", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "navigateToBackendResponseFragment", "responseType", "Lmedia/tiger/tigerbox/ui/onboarding/step4/BackendResponseType;", "navigateToMainContent", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@AndroidEntryPoint
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationFragment */
/* compiled from: OnboardingBackendCommunicationFragment.kt */
public final class OnboardingBackendCommunicationFragment extends Hilt_OnboardingBackendCommunicationFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OnboardingBackendCommunicationFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBackendCommunicationBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy onboardingBackendCommunicationViewModel$delegate;

    public OnboardingBackendCommunicationFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 onboardingBackendCommunicationFragment$special$$inlined$viewModels$default$1 = new C2994x1d05e5b4(fragment);
        this.onboardingBackendCommunicationViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(OnboardingBackendCommunicationViewModel.class), new C2995x1d05e5b5(onboardingBackendCommunicationFragment$special$$inlined$viewModels$default$1), new C2996x1d05e5b6(onboardingBackendCommunicationFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentOnboardingBackendCommunicationBinding getBinding() {
        return (FragmentOnboardingBackendCommunicationBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentOnboardingBackendCommunicationBinding fragmentOnboardingBackendCommunicationBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentOnboardingBackendCommunicationBinding);
    }

    private final OnboardingBackendCommunicationViewModel getOnboardingBackendCommunicationViewModel() {
        return (OnboardingBackendCommunicationViewModel) this.onboardingBackendCommunicationViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentOnboardingBackendCommunicationBinding inflate = FragmentOnboardingBackendCommunicationBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        boolean z = false;
        boolean z2 = arguments != null ? arguments.getBoolean("sessionTokenExpired") : false;
        if (arguments != null) {
            String string = arguments.getString("username");
            String string2 = arguments.getString("password");
            CharSequence charSequence = string;
            if (charSequence == null || charSequence.length() == 0) {
                CharSequence charSequence2 = string2;
                if (charSequence2 == null || charSequence2.length() == 0) {
                    z = true;
                }
                if (z) {
                    navigateToBackendResponseFragment(BackendResponseType.BEARER_TOKEN);
                }
            }
            OnboardingBackendCommunicationViewModel onboardingBackendCommunicationViewModel = getOnboardingBackendCommunicationViewModel();
            Intrinsics.checkNotNull(string);
            Intrinsics.checkNotNull(string2);
            onboardingBackendCommunicationViewModel.getToken(string, string2);
        } else {
            navigateToBackendResponseFragment(BackendResponseType.BEARER_TOKEN);
        }
        getOnboardingBackendCommunicationViewModel().getBackendCommunicationInProgress().observe(getViewLifecycleOwner(), new OnboardingBackendCommunicationFragment$$ExternalSyntheticLambda1(z2, this));
        getOnboardingBackendCommunicationViewModel().getFailure().observe(getViewLifecycleOwner(), new OnboardingBackendCommunicationFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m2491onViewCreated$lambda0(boolean z, OnboardingBackendCommunicationFragment onboardingBackendCommunicationFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(onboardingBackendCommunicationFragment, "this$0");
        if (z) {
            onboardingBackendCommunicationFragment.navigateToMainContent();
        } else if (Intrinsics.areEqual((Object) bool, (Object) false)) {
            onboardingBackendCommunicationFragment.navigateToBackendResponseFragment(BackendResponseType.SUCCESS);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m2492onViewCreated$lambda1(OnboardingBackendCommunicationFragment onboardingBackendCommunicationFragment, Failure failure) {
        Intrinsics.checkNotNullParameter(onboardingBackendCommunicationFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(failure, "it");
        onboardingBackendCommunicationFragment.handleFailure(failure);
    }

    private final void navigateToBackendResponseFragment(BackendResponseType backendResponseType) {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), OnboardingBackendCommunicationFragmentDirections.Companion.mo40242x5d8ed5ec(backendResponseType));
    }

    private final void navigateToMainContent() {
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(this), OnboardingBackendCommunicationFragmentDirections.Companion.mo40241xdfbaa551());
        requireActivity().finish();
    }

    private final void handleFailure(Failure failure) {
        if (failure instanceof LoginFailure.BearerTokenNotSuccessful) {
            navigateToBackendResponseFragment(BackendResponseType.BEARER_TOKEN);
        } else if (failure instanceof LoginFailure.RequestAccountDataNotSuccessful) {
            navigateToBackendResponseFragment(BackendResponseType.ACCOUNT_DATA);
        } else if (failure instanceof LoginFailure.AssociationOfBoxAndAccountNotSuccessful) {
            navigateToBackendResponseFragment(BackendResponseType.BOX_ACCOUNT_ASSIGN_FAILED);
        } else if (failure instanceof Failure.NetworkConnection) {
            navigateToBackendResponseFragment(BackendResponseType.NO_INTERNET);
        } else {
            navigateToBackendResponseFragment(BackendResponseType.BEARER_TOKEN);
        }
    }
}
