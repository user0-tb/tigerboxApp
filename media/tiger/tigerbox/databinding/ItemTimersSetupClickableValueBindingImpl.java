package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupItem;

public class ItemTimersSetupClickableValueBindingImpl extends ItemTimersSetupClickableValueBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1785timersSetupItemguideline, 3);
    }

    public ItemTimersSetupClickableValueBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private ItemTimersSetupClickableValueBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.timersSetupItemLength.setTag((Object) null);
        this.timersSetupItemTitle.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2;
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
        if (50 != i) {
            return false;
        }
        setTimersSetupItem((TimersSetupItem) obj);
        return true;
    }

    public void setTimersSetupItem(TimersSetupItem timersSetupItem) {
        this.mTimersSetupItem = timersSetupItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(50);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        String str;
        String str2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        TimersSetupItem timersSetupItem = this.mTimersSetupItem;
        String str3 = null;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i != 0) {
            if (timersSetupItem != null) {
                str2 = timersSetupItem.getValue();
                str3 = timersSetupItem.getTitle();
            } else {
                str2 = null;
            }
            str3 = str2;
            str = str3 + ":";
        } else {
            str = null;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.timersSetupItemLength, str3);
            TextViewBindingAdapter.setText(this.timersSetupItemTitle, str);
        }
    }
}
