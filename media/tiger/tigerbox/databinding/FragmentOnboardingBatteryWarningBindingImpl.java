package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;

public class FragmentOnboardingBatteryWarningBindingImpl extends FragmentOnboardingBatteryWarningBinding {
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
        sparseIntArray.put(C2814R.C2817id.f1669onboardingbatteryWarningtitle, 2);
        sparseIntArray.put(C2814R.C2817id.f1668onboardingbatteryWarningimage, 3);
        sparseIntArray.put(C2814R.C2817id.f1667onboardingbatteryWarningbutton, 4);
    }

    public FragmentOnboardingBatteryWarningBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private FragmentOnboardingBatteryWarningBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[4], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.onboardingBatteryWarningBody.setTag((Object) null);
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
        if (25 == i) {
            setIsCharging((Boolean) obj);
        } else if (7 != i) {
            return false;
        } else {
            setBatteryPercent((Integer) obj);
        }
        return true;
    }

    public void setIsCharging(Boolean bool) {
        this.mIsCharging = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    public void setBatteryPercent(Integer num) {
        this.mBatteryPercent = num;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Boolean bool = this.mIsCharging;
        Integer num = this.mBatteryPercent;
        boolean z = false;
        int i2 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i2 != 0) {
            z = ViewDataBinding.safeUnbox(bool);
            i = ViewDataBinding.safeUnbox(num);
        } else {
            i = 0;
        }
        if (i2 != 0) {
            BindingAdaptersKt.connectedStateString(this.onboardingBatteryWarningBody, z, i);
        }
    }
}
