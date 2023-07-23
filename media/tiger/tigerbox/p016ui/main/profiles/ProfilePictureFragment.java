package media.tiger.tigerbox.p016ui.main.profiles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.databinding.FragmentProfilePictureBinding;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValue;
import media.tiger.tigerbox.infrastructure.functional.AutoClearedValueKt;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.FullScreenNoHeaderFragment;

@Metadata(mo33736d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u0017H\u0016R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilePictureFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "<set-?>", "Lmedia/tiger/tigerbox/databinding/FragmentProfilePictureBinding;", "binding", "getBinding", "()Lmedia/tiger/tigerbox/databinding/FragmentProfilePictureBinding;", "setBinding", "(Lmedia/tiger/tigerbox/databinding/FragmentProfilePictureBinding;)V", "binding$delegate", "Lmedia/tiger/tigerbox/infrastructure/functional/AutoClearedValue;", "profilePictureViewModel", "Lmedia/tiger/tigerbox/ui/main/profiles/ProfilePictureViewModel;", "getProfilePictureViewModel", "()Lmedia/tiger/tigerbox/ui/main/profiles/ProfilePictureViewModel;", "profilePictureViewModel$delegate", "Lkotlin/Lazy;", "getCloseButton", "Landroid/widget/ImageView;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onStart", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureFragment */
/* compiled from: ProfilePictureFragment.kt */
public final class ProfilePictureFragment extends FullScreenNoHeaderFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ProfilePictureFragment.class, "binding", "getBinding()Lmedia/tiger/tigerbox/databinding/FragmentProfilePictureBinding;", 0))};
    private final AutoClearedValue binding$delegate;
    private final Lazy profilePictureViewModel$delegate;

    public DialogViewModel getViewModel() {
        return null;
    }

    public ProfilePictureFragment() {
        Fragment fragment = this;
        this.profilePictureViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ProfilePictureViewModel.class), new C2974xe7ddfd1b(fragment), new C2975xe7ddfd1c(fragment));
        this.binding$delegate = AutoClearedValueKt.autoCleared(fragment);
    }

    private final ProfilePictureViewModel getProfilePictureViewModel() {
        return (ProfilePictureViewModel) this.profilePictureViewModel$delegate.getValue();
    }

    private final FragmentProfilePictureBinding getBinding() {
        return (FragmentProfilePictureBinding) this.binding$delegate.getValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final void setBinding(FragmentProfilePictureBinding fragmentProfilePictureBinding) {
        this.binding$delegate.setValue((Fragment) this, (KProperty<?>) $$delegatedProperties[0], fragmentProfilePictureBinding);
    }

    public ImageView getCloseButton() {
        ImageButton root = getBinding().fragmentCloseButton.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.fragmentCloseButton.root");
        return root;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, C2814R.C2823style.FullscreenTheme);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentProfilePictureBinding inflate = FragmentProfilePictureBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        setBinding(inflate);
        getProfilePictureViewModel().getProfilePictureUrl().observe(getViewLifecycleOwner(), new ProfilePictureFragment$$ExternalSyntheticLambda2(this));
        getProfilePictureViewModel().getProfileNickname().observe(getViewLifecycleOwner(), new ProfilePictureFragment$$ExternalSyntheticLambda1(this));
        getProfilePictureViewModel().updateData();
        getProfilePictureViewModel().registerListeners();
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m2461onCreateView$lambda0(ProfilePictureFragment profilePictureFragment, String str) {
        Intrinsics.checkNotNullParameter(profilePictureFragment, "this$0");
        profilePictureFragment.getBinding().setImageUrl(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m2462onCreateView$lambda1(ProfilePictureFragment profilePictureFragment, String str) {
        Intrinsics.checkNotNullParameter(profilePictureFragment, "this$0");
        profilePictureFragment.getBinding().setNickName(str);
    }

    public void onStart() {
        super.onStart();
        getBinding().profilePicture.setOnClickListener(new ProfilePictureFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onStart$lambda-2  reason: not valid java name */
    public static final void m2463onStart$lambda2(ProfilePictureFragment profilePictureFragment, View view) {
        Intrinsics.checkNotNullParameter(profilePictureFragment, "this$0");
        FragmentKt.findNavController(profilePictureFragment).navigateUp();
    }

    public void onDestroy() {
        getProfilePictureViewModel().onViewExit();
        getProfilePictureViewModel().unregisterListeners();
        super.onDestroy();
    }
}
