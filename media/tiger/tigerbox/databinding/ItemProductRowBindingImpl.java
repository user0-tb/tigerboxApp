package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.ProductRowDomain;

public class ItemProductRowBindingImpl extends ItemProductRowBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1618mainContentinner_recycler_view, 2);
    }

    public ItemProductRowBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private ItemProductRowBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[0], objArr[1]);
        this.mDirtyFlags = -1;
        this.mainContentProductRowContainer.setTag((Object) null);
        this.mainContentTitle.setTag((Object) null);
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
        if (38 != i) {
            return false;
        }
        setProductRow((ProductRowDomain) obj);
        return true;
    }

    public void setProductRow(ProductRowDomain productRowDomain) {
        this.mProductRow = productRowDomain;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(38);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = null;
        ProductRowDomain productRowDomain = this.mProductRow;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (!(i == 0 || productRowDomain == null)) {
            str = productRowDomain.getTitle();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.mainContentTitle, str);
        }
    }
}
