package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public class FragmentSendLogsNoneBindingImpl extends FragmentSendLogsNoneBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback4;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1568fragmentsendLogsNoneguideline, 2);
        sparseIntArray.put(C2814R.C2817id.f1762sendLogsNonetitle, 3);
        sparseIntArray.put(C2814R.C2817id.f1569fragmentsendLogsNoneh_guideline, 4);
        sparseIntArray.put(C2814R.C2817id.f1760sendLogsNoneicon, 5);
        sparseIntArray.put(C2814R.C2817id.f1761sendLogsNonemessage, 6);
    }

    public FragmentSendLogsNoneBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private FragmentSendLogsNoneBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[4], objArr[1], objArr[5], objArr[6], objArr[3]);
        this.mDirtyFlags = -1;
        NestedScrollView nestedScrollView = objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag((Object) null);
        this.sendLogsNoneConfirmButton.setTag((Object) null);
        setRootTag(view);
        this.mCallback4 = new OnClickListener(this, 1);
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
        if (16 != i) {
            return false;
        }
        setCloseHandler((UnTypedBindingClickListener) obj);
        return true;
    }

    public void setCloseHandler(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mCloseHandler = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UnTypedBindingClickListener unTypedBindingClickListener = this.mCloseHandler;
        if ((j & 2) != 0) {
            this.sendLogsNoneConfirmButton.setOnClickListener(this.mCallback4);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        UnTypedBindingClickListener unTypedBindingClickListener = this.mCloseHandler;
        if (unTypedBindingClickListener != null) {
            unTypedBindingClickListener.onClick();
        }
    }
}
