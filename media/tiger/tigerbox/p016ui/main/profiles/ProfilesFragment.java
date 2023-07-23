package media.tiger.tigerbox.p016ui.main.profiles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import media.tiger.tigerbox.databinding.FragmentProfilesBinding;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;
import media.tiger.tigerbox.model.domain.ProfilesItem;
import media.tiger.tigerbox.p016ui.common.DialogViewModel;
import media.tiger.tigerbox.p016ui.common.FullScreenFragment;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenFragment;", "()V", "binding", "Lmedia/tiger/tigerbox/databinding/FragmentProfilesBinding;", "profilesListAdapter", "Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesListAdapter;", "profilesViewModel", "Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesViewModel;", "getProfilesViewModel", "()Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesViewModel;", "profilesViewModel$delegate", "Lkotlin/Lazy;", "getHeaderBinding", "Lmedia/tiger/tigerbox/databinding/IncludeDialogHeaderBarBinding;", "getViewModel", "Lmedia/tiger/tigerbox/ui/common/DialogViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesFragment */
/* compiled from: ProfilesFragment.kt */
public final class ProfilesFragment extends FullScreenFragment {
    private FragmentProfilesBinding binding;
    private ProfilesListAdapter profilesListAdapter;
    private final Lazy profilesViewModel$delegate;

    public ProfilesFragment() {
        Fragment fragment = this;
        this.profilesViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ProfilesViewModel.class), new ProfilesFragment$special$$inlined$activityViewModels$default$1(fragment), new ProfilesFragment$special$$inlined$activityViewModels$default$2(fragment));
    }

    /* access modifiers changed from: private */
    public final ProfilesViewModel getProfilesViewModel() {
        return (ProfilesViewModel) this.profilesViewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentProfilesBinding inflate = FragmentProfilesBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        FragmentProfilesBinding fragmentProfilesBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        inflate.setLifecycleOwner(getViewLifecycleOwner());
        this.profilesListAdapter = new ProfilesListAdapter(new ProfilesFragment$onCreateView$1(this));
        FragmentProfilesBinding fragmentProfilesBinding2 = this.binding;
        if (fragmentProfilesBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentProfilesBinding2 = null;
        }
        RecyclerView recyclerView = fragmentProfilesBinding2.profilesContent.profilesInnerRecyclerView;
        ProfilesListAdapter profilesListAdapter2 = this.profilesListAdapter;
        if (profilesListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profilesListAdapter");
            profilesListAdapter2 = null;
        }
        recyclerView.setAdapter(profilesListAdapter2);
        getProfilesViewModel().getProfilesList().observe(getViewLifecycleOwner(), new ProfilesFragment$$ExternalSyntheticLambda0(this));
        getProfilesViewModel().updateData();
        getProfilesViewModel().registerListeners();
        FragmentProfilesBinding fragmentProfilesBinding3 = this.binding;
        if (fragmentProfilesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentProfilesBinding = fragmentProfilesBinding3;
        }
        View root = fragmentProfilesBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-1  reason: not valid java name */
    public static final void m2465onCreateView$lambda1(ProfilesFragment profilesFragment, List list) {
        Intrinsics.checkNotNullParameter(profilesFragment, "this$0");
        ProfilesListAdapter profilesListAdapter2 = profilesFragment.profilesListAdapter;
        FragmentProfilesBinding fragmentProfilesBinding = null;
        if (profilesListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("profilesListAdapter");
            profilesListAdapter2 = null;
        }
        profilesListAdapter2.submitList(list);
        try {
            Intrinsics.checkNotNullExpressionValue(list, "profilesList");
            for (Object next : list) {
                if (((ProfilesItem) next).isSelected()) {
                    ProfilesItem profilesItem = (ProfilesItem) next;
                    FragmentProfilesBinding fragmentProfilesBinding2 = profilesFragment.binding;
                    if (fragmentProfilesBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        fragmentProfilesBinding = fragmentProfilesBinding2;
                    }
                    fragmentProfilesBinding.profilesContent.profilesInnerRecyclerView.scrollToPosition(list.indexOf(profilesItem));
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (NoSuchElementException e) {
            Timber.Forest.mo50217e("ProfilesFragment: " + e.getMessage(), new Object[0]);
        }
    }

    public DialogViewModel getViewModel() {
        return getProfilesViewModel();
    }

    public IncludeDialogHeaderBarBinding getHeaderBinding() {
        FragmentProfilesBinding fragmentProfilesBinding = this.binding;
        if (fragmentProfilesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentProfilesBinding = null;
        }
        IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding = fragmentProfilesBinding.fragmentHeaderBar;
        Intrinsics.checkNotNullExpressionValue(includeDialogHeaderBarBinding, "binding.fragmentHeaderBar");
        return includeDialogHeaderBarBinding;
    }

    public void onDestroy() {
        getProfilesViewModel().onViewExit();
        super.onDestroy();
    }
}
