package media.tiger.tigerbox.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import media.tiger.tigerbox.C2814R;

public class IncludePlayerDeviceControlsBindingImpl extends IncludePlayerDeviceControlsBinding {
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
        sparseIntArray.put(C2814R.C2817id.f1642mediaPlayercontrolstrackControl, 2);
        sparseIntArray.put(C2814R.C2817id.f1644mediaPlayercontrolsvolumeControl, 3);
    }

    public IncludePlayerDeviceControlsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private IncludePlayerDeviceControlsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.mediaPlayerControlsLightControl.setTag((Object) null);
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
        if (30 != i) {
            return false;
        }
        setLightControlEnabled((Boolean) obj);
        return true;
    }

    public void setLightControlEnabled(Boolean bool) {
        this.mLightControlEnabled = bool;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(30);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        Context context;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Drawable drawable = null;
        Boolean bool = this.mLightControlEnabled;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i2 != 0) {
                j |= safeUnbox ? 8 : 4;
            }
            if (safeUnbox) {
                context = this.mediaPlayerControlsLightControl.getContext();
                i = C2814R.C2816drawable.vector_tiger_head_light_enabled;
            } else {
                context = this.mediaPlayerControlsLightControl.getContext();
                i = C2814R.C2816drawable.vector_tiger_head_light_disabled;
            }
            drawable = AppCompatResources.getDrawable(context, i);
        }
        if ((j & 3) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.mediaPlayerControlsLightControl, drawable);
        }
    }
}
