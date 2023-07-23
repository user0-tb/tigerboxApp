package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import media.tiger.tigerbox.C2814R;

public class FragmentOtaUpdateInProgressBindingImpl extends FragmentOtaUpdateInProgressBinding {
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
        sparseIntArray.put(C2814R.C2817id.f1726otaUpdateInProgresstitle, 3);
        sparseIntArray.put(C2814R.C2817id.f1722otaUpdateInProgressbody, 4);
        sparseIntArray.put(C2814R.C2817id.f1723otaUpdateInProgressimage, 5);
    }

    public FragmentOtaUpdateInProgressBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private FragmentOtaUpdateInProgressBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[4], objArr[5], objArr[2], objArr[1], objArr[3]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.otaUpdateInProgressProgressBar.setTag((Object) null);
        this.otaUpdateInProgressProgressLabel.setTag((Object) null);
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
        if (57 == i) {
            setUpdateLabel((String) obj);
        } else if (58 != i) {
            return false;
        } else {
            setUpdatePercent((Integer) obj);
        }
        return true;
    }

    public void setUpdateLabel(String str) {
        this.mUpdateLabel = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(57);
        super.requestRebind();
    }

    public void setUpdatePercent(Integer num) {
        this.mUpdatePercent = num;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(58);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mUpdateLabel;
        Integer num = this.mUpdatePercent;
        int i = 0;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i3 != 0) {
            i = ViewDataBinding.safeUnbox(num);
        }
        if (i3 != 0) {
            this.otaUpdateInProgressProgressBar.setProgress(i);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.otaUpdateInProgressProgressLabel, str);
        }
    }
}
