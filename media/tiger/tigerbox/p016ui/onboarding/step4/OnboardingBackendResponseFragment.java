package media.tiger.tigerbox.p016ui.onboarding.step4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentOnboardingBackendResponseBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.services.interfaces.MetaDataService;

@AndroidEntryPoint
@Metadata(mo33736d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000¨\u0006'"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendResponseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBackendResponseBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBackendResponseBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBackendResponseBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "clickEvent", "Lkotlin/Function0;", "", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "getMetaDataService", "()Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "setMetaDataService", "(Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;)V", "onboardingBackendResponseViewModel", "Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendResponseViewModel;", "getOnboardingBackendResponseViewModel", "()Lmedia/tiger/tigerbox/ui/onboarding/step4/OnboardingBackendResponseViewModel;", "onboardingBackendResponseViewModel$delegate", "Lkotlin/Lazy;", "responseType", "Lmedia/tiger/tigerbox/ui/onboarding/step4/BackendResponseType;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseFragment */
/* compiled from: OnboardingBackendResponseFragment.kt */
public final class OnboardingBackendResponseFragment extends Hilt_OnboardingBackendResponseFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OnboardingBackendResponseFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentOnboardingBackendResponseBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    /* access modifiers changed from: private */
    public Function0<Unit> clickEvent = OnboardingBackendResponseFragment$clickEvent$1.INSTANCE;
    @Inject
    public MetaDataService metaDataService;
    private final Lazy onboardingBackendResponseViewModel$delegate;
    private BackendResponseType responseType;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseFragment$WhenMappings */
    /* compiled from: OnboardingBackendResponseFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BackendResponseType.values().length];
            iArr[BackendResponseType.BEARER_TOKEN.ordinal()] = 1;
            iArr[BackendResponseType.ACCOUNT_DATA.ordinal()] = 2;
            iArr[BackendResponseType.BOX_ACCOUNT_ASSIGN_FAILED.ordinal()] = 3;
            iArr[BackendResponseType.NO_INTERNET.ordinal()] = 4;
            iArr[BackendResponseType.SUCCESS.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public OnboardingBackendResponseFragment() {
        Fragment fragment = this;
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
        Function0 onboardingBackendResponseFragment$special$$inlined$viewModels$default$1 = new C3005x3220b1b1(fragment);
        this.onboardingBackendResponseViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(OnboardingBackendResponseViewModel.class), new C3006x3220b1b2(onboardingBackendResponseFragment$special$$inlined$viewModels$default$1), new C3007x3220b1b3(onboardingBackendResponseFragment$special$$inlined$viewModels$default$1, fragment));
    }

    private final FragmentOnboardingBackendResponseBinding getBinding() {
        return (FragmentOnboardingBackendResponseBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentOnboardingBackendResponseBinding fragmentOnboardingBackendResponseBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentOnboardingBackendResponseBinding);
    }

    /* access modifiers changed from: private */
    public final OnboardingBackendResponseViewModel getOnboardingBackendResponseViewModel() {
        return (OnboardingBackendResponseViewModel) this.onboardingBackendResponseViewModel$delegate.getValue();
    }

    public final MetaDataService getMetaDataService() {
        MetaDataService metaDataService2 = this.metaDataService;
        if (metaDataService2 != null) {
            return metaDataService2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("metaDataService");
        return null;
    }

    public final void setMetaDataService(MetaDataService metaDataService2) {
        Intrinsics.checkNotNullParameter(metaDataService2, "<set-?>");
        this.metaDataService = metaDataService2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentOnboardingBackendResponseBinding inflate = FragmentOnboardingBackendResponseBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        Bundle arguments = getArguments();
        BackendResponseType backendResponseType = null;
        Object obj = arguments != null ? arguments.get("responseType") : null;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type media.tiger.tigerbox.ui.onboarding.step4.BackendResponseType");
        BackendResponseType backendResponseType2 = (BackendResponseType) obj;
        this.responseType = backendResponseType2;
        if (backendResponseType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("responseType");
        } else {
            backendResponseType = backendResponseType2;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[backendResponseType.ordinal()];
        if (i == 1) {
            getBinding().onboardingBackendResponseTitle.setText(getString(C2814R.string.onboarding_box_data_not_found__title));
            getBinding().onboardingBackendResponseBody.setText(getString(C2814R.string.onboarding_login_error_content));
            getBinding().onboardingBackendResponseId.setVisibility(8);
            getBinding().onboardingBackendResponseButton.setText(getString(C2814R.string.onboarding_login_error_button_text));
            this.clickEvent = new OnboardingBackendResponseFragment$onCreateView$1(this);
        } else if (i == 2) {
            getBinding().onboardingBackendResponseTitle.setText(getString(C2814R.string.onboarding_box_data_not_found__title));
            getBinding().onboardingBackendResponseBody.setText(getString(C2814R.string.onboarding_account_data_not_found_content));
            getBinding().onboardingBackendResponseId.setVisibility(8);
            getBinding().onboardingBackendResponseButton.setText(getString(C2814R.string.onboarding_box_data_not_found_button_text));
            this.clickEvent = new OnboardingBackendResponseFragment$onCreateView$2(this);
        } else if (i == 3) {
            getBinding().onboardingBackendResponseTitle.setText(getString(C2814R.string.onboarding_box_data_not_found__title));
            getBinding().onboardingBackendResponseBody.setText(getString(C2814R.string.onboarding_box_data_not_found_content));
            getBinding().onboardingBackendResponseId.setVisibility(0);
            getBinding().onboardingBackendResponseId.setText(getMetaDataService().getCpuId());
            getBinding().onboardingBackendResponseButton.setText(getString(C2814R.string.onboarding_box_data_not_found_button_text));
            this.clickEvent = new OnboardingBackendResponseFragment$onCreateView$3(this);
        } else if (i == 4) {
            getBinding().onboardingBackendResponseTitle.setText(getString(C2814R.string.error_703_headline));
            getBinding().onboardingBackendResponseBody.setText(getString(C2814R.string.error_703_text));
            getBinding().onboardingBackendResponseButton.setText(getString(C2814R.string.error_703_button_text));
            getBinding().onboardingBackendResponseId.setVisibility(8);
            this.clickEvent = new OnboardingBackendResponseFragment$onCreateView$4(this);
        } else if (i == 5) {
            getBinding().onboardingBackendResponseTitle.setText(getString(C2814R.string.onboarding_success_title));
            getBinding().onboardingBackendResponseBody.setText(getString(C2814R.string.onboarding_success_content));
            getBinding().onboardingBackendResponseId.setVisibility(8);
            getBinding().onboardingBackendResponseButton.setText(getString(C2814R.string.onboarding_step1_buttonText));
            this.clickEvent = new OnboardingBackendResponseFragment$onCreateView$5(this);
        }
        getBinding().setClickListener(new OnboardingBackendResponseFragment$onCreateView$6(this));
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        BackendResponseType backendResponseType = BackendResponseType.ACCOUNT_DATA;
        BackendResponseType backendResponseType2 = this.responseType;
        BackendResponseType backendResponseType3 = null;
        if (backendResponseType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("responseType");
            backendResponseType2 = null;
        }
        boolean z = true;
        boolean z2 = backendResponseType == backendResponseType2;
        BackendResponseType backendResponseType4 = BackendResponseType.BOX_ACCOUNT_ASSIGN_FAILED;
        BackendResponseType backendResponseType5 = this.responseType;
        if (backendResponseType5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("responseType");
        } else {
            backendResponseType3 = backendResponseType5;
        }
        if (backendResponseType4 != backendResponseType3) {
            z = false;
        }
        if (z2 || z) {
            getOnboardingBackendResponseViewModel().removeStoredToken();
        }
    }
}
