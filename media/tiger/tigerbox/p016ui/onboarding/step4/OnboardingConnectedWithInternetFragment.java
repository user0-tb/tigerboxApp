package media.tiger.tigerbox.p016ui.onboarding.step4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentOnboardingConnectedWithInternetBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityKt;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0017"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingConnectedWithInternetFragment;", "Landroidx/fragment/app/Fragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentOnboardingConnectedWithInternetBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingConnectedWithInternetBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentOnboardingConnectedWithInternetBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingConnectedWithInternetFragment */
/* compiled from: OnboardingConnectedWithInternetFragment.kt */
public final class OnboardingConnectedWithInternetFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OnboardingConnectedWithInternetFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingConnectedWithInternetBinding;", 0))};
    private final AutoClearedValue binding$delegate = AutoClearedValueKt.autoCleared(this);

    private final FragmentOnboardingConnectedWithInternetBinding getBinding() {
        return (FragmentOnboardingConnectedWithInternetBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentOnboardingConnectedWithInternetBinding fragmentOnboardingConnectedWithInternetBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentOnboardingConnectedWithInternetBinding);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentOnboardingConnectedWithInternetBinding inflate = FragmentOnboardingConnectedWithInternetBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        ConstraintLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        getBinding().onboardingConnectedWithInternetLoginButton.setOnClickListener(new C3009xa5886654(this));
        getBinding().onboardingConnectedWithInternetRegistrationButton.setOnClickListener(new C3010xa5886655(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-0  reason: not valid java name */
    public static final void m2494onViewCreated$lambda0(OnboardingConnectedWithInternetFragment onboardingConnectedWithInternetFragment, View view) {
        Intrinsics.checkNotNullParameter(onboardingConnectedWithInternetFragment, "this$0");
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(onboardingConnectedWithInternetFragment), C2814R.C2817id.f582x785ea5fd, (Bundle) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m2495onViewCreated$lambda1(OnboardingConnectedWithInternetFragment onboardingConnectedWithInternetFragment, View view) {
        Intrinsics.checkNotNullParameter(onboardingConnectedWithInternetFragment, "this$0");
        OnboardingActivityKt.navigateActionSafe(FragmentKt.findNavController(onboardingConnectedWithInternetFragment), C2814R.C2817id.f583xea86ac85, (Bundle) null);
    }
}
