package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import media.tiger.tigerbox.C2814R;

public class FragmentTimersLimitBindingImpl extends FragmentTimersLimitBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ConstraintLayout mboundView1;
    private final TextView mboundView2;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1529fragmentclose_button, 3);
        sparseIntArray.put(C2814R.C2817id.guideline, 4);
        sparseIntArray.put(C2814R.C2817id.f1789timers_limitrecycler_view, 5);
        sparseIntArray.put(C2814R.C2817id.hm_picker_layout, 6);
        sparseIntArray.put(C2814R.C2817id.hm_picker, 7);
        sparseIntArray.put(C2814R.C2817id.submit_button, 8);
    }

    public FragmentTimersLimitBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentTimersLimitBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3] != null ? IncludeDialogCloseButtonBinding.bind(objArr[3]) : null, objArr[4], objArr[7], objArr[6], objArr[8], objArr[5]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag((Object) null);
        TextView textView = objArr[2];
        this.mboundView2 = textView;
        textView.setTag((Object) null);
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
        if (28 != i) {
            return false;
        }
        setLayoutTitle((String) obj);
        return true;
    }

    public void setLayoutTitle(String str) {
        this.mLayoutTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mLayoutTitle;
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.mboundView2, str);
        }
    }
}
