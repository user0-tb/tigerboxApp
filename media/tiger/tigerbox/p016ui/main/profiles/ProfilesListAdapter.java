package media.tiger.tigerbox.p016ui.main.profiles;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.databinding.ItemProfileBinding;
import media.tiger.tigerbox.model.domain.ProfilesItem;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lmedia/tiger/tigerbox/model/domain/ProfilesItem;", "Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesListAdapter$ProfilesListViewHolder;", "profilesClickListener", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "(Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "list", "", "ProfilesListViewHolder", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesListAdapter */
/* compiled from: ProfilesListAdapter.kt */
public final class ProfilesListAdapter extends ListAdapter<ProfilesItem, ProfilesListViewHolder> {
    private final BindingClickListener<ProfilesItem> profilesClickListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfilesListAdapter(BindingClickListener<ProfilesItem> bindingClickListener) {
        super(ProfileRowDiffCallback.INSTANCE);
        Intrinsics.checkNotNullParameter(bindingClickListener, "profilesClickListener");
        this.profilesClickListener = bindingClickListener;
    }

    public void submitList(List<ProfilesItem> list) {
        super.submitList(list != null ? new ArrayList(list) : null);
    }

    public ProfilesListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return ProfilesListViewHolder.Companion.createFrom(viewGroup, this.profilesClickListener);
    }

    public void onBindViewHolder(ProfilesListViewHolder profilesListViewHolder, int i) {
        Intrinsics.checkNotNullParameter(profilesListViewHolder, "holder");
        Object item = getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        profilesListViewHolder.bind((ProfilesItem) item);
    }

    @Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesListAdapter$ProfilesListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lmedia/tiger/tigerbox/databinding/ItemProfileBinding;", "profilesClickListener", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "Lmedia/tiger/tigerbox/model/domain/ProfilesItem;", "(Lmedia/tiger/tigerbox/databinding/ItemProfileBinding;Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;)V", "bind", "", "item", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesListAdapter$ProfilesListViewHolder */
    /* compiled from: ProfilesListAdapter.kt */
    public static final class ProfilesListViewHolder extends RecyclerView.ViewHolder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ItemProfileBinding binding;
        private final BindingClickListener<ProfilesItem> profilesClickListener;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProfilesListViewHolder(ItemProfileBinding itemProfileBinding, BindingClickListener<ProfilesItem> bindingClickListener) {
            super(itemProfileBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemProfileBinding, "binding");
            Intrinsics.checkNotNullParameter(bindingClickListener, "profilesClickListener");
            this.binding = itemProfileBinding;
            this.profilesClickListener = bindingClickListener;
        }

        @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesListAdapter$ProfilesListViewHolder$Companion;", "", "()V", "createFrom", "Lmedia/tiger/tigerbox/ui/main/profiles/ProfilesListAdapter$ProfilesListViewHolder;", "parent", "Landroid/view/ViewGroup;", "chapterClickListener", "Lmedia/tiger/tigerbox/ui/binding/BindingClickListener;", "Lmedia/tiger/tigerbox/model/domain/ProfilesItem;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesListAdapter$ProfilesListViewHolder$Companion */
        /* compiled from: ProfilesListAdapter.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ProfilesListViewHolder createFrom(ViewGroup viewGroup, BindingClickListener<ProfilesItem> bindingClickListener) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                Intrinsics.checkNotNullParameter(bindingClickListener, "chapterClickListener");
                ItemProfileBinding inflate = ItemProfileBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
                return new ProfilesListViewHolder(inflate, bindingClickListener);
            }
        }

        public final void bind(ProfilesItem profilesItem) {
            Intrinsics.checkNotNullParameter(profilesItem, "item");
            this.binding.setProfileClickListener(this.profilesClickListener);
            this.binding.setProfileItem(profilesItem);
        }
    }
}
