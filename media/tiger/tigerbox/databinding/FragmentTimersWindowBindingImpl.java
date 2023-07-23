package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public class FragmentTimersWindowBindingImpl extends FragmentTimersWindowBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final ConstraintLayout mboundView1;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1529fragmentclose_button, 2);
        sparseIntArray.put(C2814R.C2817id.title, 3);
        sparseIntArray.put(C2814R.C2817id.guideline, 4);
        sparseIntArray.put(C2814R.C2817id.start_label, 5);
        sparseIntArray.put(C2814R.C2817id.end_label, 6);
        sparseIntArray.put(C2814R.C2817id.picker_layout, 7);
        sparseIntArray.put(C2814R.C2817id.guideline_2, 8);
        sparseIntArray.put(C2814R.C2817id.start_picker, 9);
        sparseIntArray.put(C2814R.C2817id.end_picker, 10);
        sparseIntArray.put(C2814R.C2817id.delete_button, 11);
        sparseIntArray.put(C2814R.C2817id.submit_button, 12);
    }

    public FragmentTimersWindowBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentTimersWindowBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[11], objArr[6], objArr[10], objArr[2] != null ? IncludeDialogCloseButtonBinding.bind(objArr[2]) : null, objArr[4], objArr[8], objArr[7], objArr[5], objArr[9], objArr[12], objArr[3]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag((Object) null);
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
        if (29 != i) {
            return false;
        }
        setLayoutTitleIdx((Integer) obj);
        return true;
    }

    public void setLayoutTitleIdx(Integer num) {
        this.mLayoutTitleIdx = num;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
