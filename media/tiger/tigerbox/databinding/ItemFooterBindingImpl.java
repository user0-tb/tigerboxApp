package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

public class ItemFooterBindingImpl extends ItemFooterBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback3;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemFooterBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, sIncludes, sViewsWithIds));
    }

    private ItemFooterBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0]);
        this.mDirtyFlags = -1;
        this.footerItem.setTag((Object) null);
        setRootTag(view);
        this.mCallback3 = new OnClickListener(this, 1);
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
        if (21 == i) {
            setFooterRowId((Integer) obj);
        } else if (20 != i) {
            return false;
        } else {
            setFooterClickListener((BindingClickListener) obj);
        }
        return true;
    }

    public void setFooterRowId(Integer num) {
        this.mFooterRowId = num;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    public void setFooterClickListener(BindingClickListener<Integer> bindingClickListener) {
        this.mFooterClickListener = bindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Integer num = this.mFooterRowId;
        BindingClickListener bindingClickListener = this.mFooterClickListener;
        if ((j & 4) != 0) {
            this.footerItem.setOnClickListener(this.mCallback3);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        Integer num = this.mFooterRowId;
        BindingClickListener bindingClickListener = this.mFooterClickListener;
        if (bindingClickListener != null) {
            bindingClickListener.onClick(num);
        }
    }
}
