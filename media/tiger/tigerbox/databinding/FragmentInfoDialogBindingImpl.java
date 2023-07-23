package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public class FragmentInfoDialogBindingImpl extends FragmentInfoDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1675onboardingerrorDialogcontent, 2);
        sparseIntArray.put(C2814R.C2817id.f1607infoDialogtitle, 3);
        sparseIntArray.put(C2814R.C2817id.f1603infoDialogerror_icon, 4);
        sparseIntArray.put(C2814R.C2817id.f1601infoDialogbody, 5);
        sparseIntArray.put(C2814R.C2817id.f1602infoDialogcancel_button, 6);
        sparseIntArray.put(C2814R.C2817id.f1605infoDialogsubmit_button, 7);
        sparseIntArray.put(C2814R.C2817id.f1604infoDialogguideline, 8);
        sparseIntArray.put(C2814R.C2817id.f1606infoDialogswipe_indicator, 9);
    }

    public FragmentInfoDialogBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentInfoDialogBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[5], objArr[6], objArr[4], objArr[8], objArr[7], objArr[9], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        this.closeButton.setTag((Object) null);
        RelativeLayout relativeLayout = objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag((Object) null);
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
        if (15 == i) {
            setCloseButtonVisible(((Boolean) obj).booleanValue());
        } else if (52 != i) {
            return false;
        } else {
            setTitleVisible(((Boolean) obj).booleanValue());
        }
        return true;
    }

    public void setCloseButtonVisible(boolean z) {
        this.mCloseButtonVisible = z;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    public void setTitleVisible(boolean z) {
        this.mTitleVisible = z;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        boolean z = this.mCloseButtonVisible;
        int i = 0;
        int i2 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (i2 != 0) {
                j |= z ? 16 : 8;
            }
            if (!z) {
                i = 8;
            }
        }
        if ((j & 5) != 0) {
            this.closeButton.setVisibility(i);
        }
    }
}
