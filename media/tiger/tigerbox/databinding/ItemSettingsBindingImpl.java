package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;
import media.tiger.tigerbox.p016ui.settings.SettingsItemData;

public class ItemSettingsBindingImpl extends ItemSettingsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        this.itemIcon.setTag((Object) null);
        this.itemTitle.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        setRootTag(view);
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
        if (27 == i) {
            setItem((SettingsItemData) obj);
        } else if (42 != i) {
            return false;
        } else {
            setSelected((Boolean) obj);
        }
        return true;
    }

    public void setItem(SettingsItemData settingsItemData) {
        this.mItem = settingsItemData;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(27);
        super.requestRebind();
    }

    public void setSelected(Boolean bool) {
        this.mSelected = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(42);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        TextView textView;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        SettingsItemData settingsItemData = this.mItem;
        Boolean bool = this.mSelected;
        int i2 = 0;
        int bottomText = ((j & 5) == 0 || settingsItemData == null) ? 0 : settingsItemData.getBottomText();
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j |= safeUnbox ? 16 : 8;
            }
            if (safeUnbox) {
                textView = this.itemTitle;
                i = C2814R.C2815color.settings_item_title_selected_color;
            } else {
                textView = this.itemTitle;
                i = C2814R.C2815color.settings_item_title_color;
            }
            i2 = getColorFromResource(textView, i);
        }
        if ((j & 5) != 0) {
            BindingAdaptersKt.drawableIcon(this.itemIcon, settingsItemData);
            this.itemTitle.setText(bottomText);
        }
        if ((j & 6) != 0) {
            this.itemTitle.setTextColor(i2);
        }
    }
}
