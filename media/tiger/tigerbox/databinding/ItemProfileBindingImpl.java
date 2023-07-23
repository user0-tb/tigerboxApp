package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.model.domain.ProfilesItem;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

public class ItemProfileBindingImpl extends ItemProfileBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback17;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemProfileBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemProfileBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[1], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        this.productConstraintLayout.setTag((Object) null);
        this.profileImage.setTag((Object) null);
        this.profileImageSelection.setTag((Object) null);
        this.profileNickName.setTag((Object) null);
        setRootTag(view);
        this.mCallback17 = new OnClickListener(this, 1);
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
        if (40 == i) {
            setProfileClickListener((BindingClickListener) obj);
        } else if (41 != i) {
            return false;
        } else {
            setProfileItem((ProfilesItem) obj);
        }
        return true;
    }

    public void setProfileClickListener(BindingClickListener<ProfilesItem> bindingClickListener) {
        this.mProfileClickListener = bindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(40);
        super.requestRebind();
    }

    public void setProfileItem(ProfilesItem profilesItem) {
        this.mProfileItem = profilesItem;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(41);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        String str;
        String str2;
        boolean z;
        int i2;
        TextView textView;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        BindingClickListener bindingClickListener = this.mProfileClickListener;
        ProfilesItem profilesItem = this.mProfileItem;
        String str3 = null;
        int i3 = 0;
        int i4 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (profilesItem != null) {
                str3 = profilesItem.getNickName();
                str2 = profilesItem.getAvatarUrl();
                z = profilesItem.isSelected();
            } else {
                str2 = null;
                z = false;
            }
            if (i4 != 0) {
                if (z) {
                    j3 = j | 16;
                    j2 = 64;
                } else {
                    j3 = j | 8;
                    j2 = 32;
                }
                j = j3 | j2;
            }
            if (!z) {
                i3 = 8;
            }
            if (z) {
                textView = this.profileNickName;
                i2 = C2814R.C2815color.settings_item_title_selected_color;
            } else {
                textView = this.profileNickName;
                i2 = C2814R.C2815color.white;
            }
            String str4 = str2;
            i = getColorFromResource(textView, i2);
            str = str3;
            str3 = str4;
        } else {
            str = null;
            i = 0;
        }
        if ((4 & j) != 0) {
            this.productConstraintLayout.setOnClickListener(this.mCallback17);
        }
        if ((j & 6) != 0) {
            BindingAdaptersKt.bindImageFromUrl(this.profileImage, str3);
            this.profileImageSelection.setVisibility(i3);
            TextViewBindingAdapter.setText(this.profileNickName, str);
            this.profileNickName.setTextColor(i);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        BindingClickListener bindingClickListener = this.mProfileClickListener;
        ProfilesItem profilesItem = this.mProfileItem;
        if (bindingClickListener != null) {
            bindingClickListener.onClick(profilesItem);
        }
    }
}
