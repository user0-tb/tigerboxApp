package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.model.domain.ProfilesItem;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public class FragmentMiniProfilesBindingImpl extends FragmentMiniProfilesBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback2;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public FragmentMiniProfilesBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private FragmentMiniProfilesBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[0]);
        this.mDirtyFlags = -1;
        this.profilesAvatar.setTag((Object) null);
        this.profilesContainer.setTag((Object) null);
        setRootTag(view);
        this.mCallback2 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, Object obj) {
        if (39 == i) {
            setProfile((ProfilesItem) obj);
        } else if (31 != i) {
            return false;
        } else {
            setNavigateListener((UnTypedBindingClickListener) obj);
        }
        return true;
    }

    public void setProfile(ProfilesItem profilesItem) {
        this.mProfile = profilesItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(39);
        super.requestRebind();
    }

    public void setNavigateListener(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mNavigateListener = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(31);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = null;
        ProfilesItem profilesItem = this.mProfile;
        UnTypedBindingClickListener unTypedBindingClickListener = this.mNavigateListener;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (!(i == 0 || profilesItem == null)) {
            str = profilesItem.getAvatarUrl();
        }
        if ((j & 4) != 0) {
            this.profilesAvatar.setOnClickListener(this.mCallback2);
        }
        if (i != 0) {
            BindingAdaptersKt.bindImageFromUrl(this.profilesAvatar, str);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        UnTypedBindingClickListener unTypedBindingClickListener = this.mNavigateListener;
        if (unTypedBindingClickListener != null) {
            unTypedBindingClickListener.onClick();
        }
    }
}
