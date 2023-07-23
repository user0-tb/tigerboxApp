package media.tiger.tigerbox.p016ui.main.profiles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import media.tiger.tigerbox.databinding.FragmentMiniProfilesBinding;
import media.tiger.tigerbox.p016ui.main.MainContentActivity;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilesViewModel;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0017"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/MiniProfilesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lmedia/tiger/tigerbox/databinding/FragmentMiniProfilesBinding;", "profilesViewModel", "Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesViewModel;", "getProfilesViewModel", "()Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesViewModel;", "profilesViewModel$delegate", "Lkotlin/Lazy;", "attachObservers", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.profiles.MiniProfilesFragment */
/* compiled from: MiniProfilesFragment.kt */
public final class MiniProfilesFragment extends Fragment {
    private FragmentMiniProfilesBinding binding;
    private final Lazy profilesViewModel$delegate;

    public MiniProfilesFragment() {
        Fragment fragment = this;
        this.profilesViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ProfilesViewModel.class), new C2972x58a95667(fragment), new C2973x58a95668(fragment));
    }

    private final ProfilesViewModel getProfilesViewModel() {
        return (ProfilesViewModel) this.profilesViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentMiniProfilesBinding inflate = FragmentMiniProfilesBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        FragmentMiniProfilesBinding fragmentMiniProfilesBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type media.tiger.tigerbox.ui.main.MainContentActivity");
        inflate.setNavigateListener(((MainContentActivity) activity).getNavigateToProfiles());
        FragmentMiniProfilesBinding fragmentMiniProfilesBinding2 = this.binding;
        if (fragmentMiniProfilesBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentMiniProfilesBinding2 = null;
        }
        fragmentMiniProfilesBinding2.setLifecycleOwner(getViewLifecycleOwner());
        FragmentMiniProfilesBinding fragmentMiniProfilesBinding3 = this.binding;
        if (fragmentMiniProfilesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentMiniProfilesBinding = fragmentMiniProfilesBinding3;
        }
        View root = fragmentMiniProfilesBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void attachObservers() {
        getProfilesViewModel().getMiniViewState().observe(getViewLifecycleOwner(), new MiniProfilesFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: attachObservers$lambda-0  reason: not valid java name */
    public static final void m2458attachObservers$lambda0(MiniProfilesFragment miniProfilesFragment, ProfilesViewModel.MiniViewState miniViewState) {
        Intrinsics.checkNotNullParameter(miniProfilesFragment, "this$0");
        if (miniViewState.getProfile() != null) {
            FragmentMiniProfilesBinding fragmentMiniProfilesBinding = miniProfilesFragment.binding;
            if (fragmentMiniProfilesBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentMiniProfilesBinding = null;
            }
            fragmentMiniProfilesBinding.setProfile(miniViewState.getProfile());
        }
    }

    public void onResume() {
        super.onResume();
        attachObservers();
        getProfilesViewModel().updateData();
        getProfilesViewModel().registerListeners();
    }

    public void onDestroy() {
        getProfilesViewModel().unregisterListeners();
        getProfilesViewModel().onViewExit();
        super.onDestroy();
    }
}
