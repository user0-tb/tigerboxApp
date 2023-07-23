package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public class FragmentOnboardingBackendResponseBindingImpl extends FragmentOnboardingBackendResponseBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback22;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1665onboardingbackendResponsetitle, 2);
        sparseIntArray.put(C2814R.C2817id.f1662onboardingbackendResponsebody, 3);
        sparseIntArray.put(C2814R.C2817id.f1664onboardingbackendResponseid, 4);
    }

    public FragmentOnboardingBackendResponseBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private FragmentOnboardingBackendResponseBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[1], objArr[4], objArr[2]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.onboardingBackendResponseButton.setTag((Object) null);
        setRootTag(view);
        this.mCallback22 = new OnClickListener(this, 1);
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
        if (14 != i) {
            return false;
        }
        setClickListener((UnTypedBindingClickListener) obj);
        return true;
    }

    public void setClickListener(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mClickListener = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UnTypedBindingClickListener unTypedBindingClickListener = this.mClickListener;
        if ((j & 2) != 0) {
            this.onboardingBackendResponseButton.setOnClickListener(this.mCallback22);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        UnTypedBindingClickListener unTypedBindingClickListener = this.mClickListener;
        if (unTypedBindingClickListener != null) {
            unTypedBindingClickListener.onClick();
        }
    }
}
