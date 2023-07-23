package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.ProductDomain;

public class ItemProductActionBindingImpl extends ItemProductActionBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final TextView mboundView2;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1733productActiondownload_box_image, 4);
    }

    public ItemProductActionBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 5, sIncludes, sViewsWithIds));
    }

    private ItemProductActionBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[0], objArr[4], objArr[1]);
        this.mDirtyFlags = -1;
        TextView textView = objArr[2];
        this.mboundView2 = textView;
        textView.setTag((Object) null);
        this.productActionAcceptButton.setTag((Object) null);
        this.productActionContainer.setTag((Object) null);
        this.productActionExitButton.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
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
        if (1 == i) {
            setAcceptButtonListener((View.OnClickListener) obj);
            return true;
        } else if (9 == i) {
            setBindingProduct((ProductDomain) obj);
            return true;
        } else if (18 != i) {
            return false;
        } else {
            setExitButtonListener((View.OnClickListener) obj);
            return true;
        }
    }

    public void setAcceptButtonListener(View.OnClickListener onClickListener) {
        this.mAcceptButtonListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    public void setBindingProduct(ProductDomain productDomain) {
        this.mBindingProduct = productDomain;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    public void setExitButtonListener(View.OnClickListener onClickListener) {
        this.mExitButtonListener = onClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    /* JADX WARNING: type inference failed for: r12v8, types: [media.tiger.tigerbox.model.domain.OfflineAvailabilityState] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0097 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0097 }
            monitor-exit(r17)     // Catch:{ all -> 0x0097 }
            android.view.View$OnClickListener r0 = r1.mAcceptButtonListener
            media.tiger.tigerbox.model.domain.ProductDomain r6 = r1.mBindingProduct
            android.view.View$OnClickListener r7 = r1.mExitButtonListener
            r8 = 10
            long r10 = r2 & r8
            r12 = 0
            r13 = 0
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x0069
            if (r6 == 0) goto L_0x0029
            boolean r10 = r6.isSelected()
            media.tiger.tigerbox.model.domain.OfflineAvailabilityState r12 = r6.getOfflineAvailabilityState()
            java.lang.String r6 = r6.getTitle()
            goto L_0x002b
        L_0x0029:
            r6 = r12
            r10 = 0
        L_0x002b:
            if (r14 == 0) goto L_0x0035
            if (r10 == 0) goto L_0x0032
            r14 = 128(0x80, double:6.32E-322)
            goto L_0x0034
        L_0x0032:
            r14 = 64
        L_0x0034:
            long r2 = r2 | r14
        L_0x0035:
            if (r10 == 0) goto L_0x0039
            r10 = 0
            goto L_0x003b
        L_0x0039:
            r10 = 8
        L_0x003b:
            media.tiger.tigerbox.model.domain.OfflineAvailabilityState r11 = media.tiger.tigerbox.model.domain.OfflineAvailabilityState.AVAILABLE
            if (r12 != r11) goto L_0x0040
            r13 = 1
        L_0x0040:
            long r11 = r2 & r8
            int r14 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x004e
            if (r13 == 0) goto L_0x004b
            r11 = 32
            goto L_0x004d
        L_0x004b:
            r11 = 16
        L_0x004d:
            long r2 = r2 | r11
        L_0x004e:
            android.widget.Button r11 = r1.productActionAcceptButton
            android.content.res.Resources r11 = r11.getResources()
            if (r13 == 0) goto L_0x005a
            r12 = 2131951811(0x7f1300c3, float:1.9540047E38)
            goto L_0x005d
        L_0x005a:
            r12 = 2131951810(0x7f1300c2, float:1.9540045E38)
        L_0x005d:
            java.lang.String r11 = r11.getString(r12)
            r12 = r11
            r13 = r10
            r16 = r12
            r12 = r6
            r6 = r16
            goto L_0x006a
        L_0x0069:
            r6 = r12
        L_0x006a:
            r10 = 12
            long r10 = r10 & r2
            int r14 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            long r8 = r8 & r2
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0083
            android.widget.TextView r8 = r1.mboundView2
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r8, r12)
            android.widget.Button r8 = r1.productActionAcceptButton
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r8, r6)
            androidx.constraintlayout.widget.ConstraintLayout r6 = r1.productActionContainer
            r6.setVisibility(r13)
        L_0x0083:
            r8 = 9
            long r2 = r2 & r8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x008f
            android.widget.Button r2 = r1.productActionAcceptButton
            r2.setOnClickListener(r0)
        L_0x008f:
            if (r14 == 0) goto L_0x0096
            android.widget.ImageView r0 = r1.productActionExitButton
            r0.setOnClickListener(r7)
        L_0x0096:
            return
        L_0x0097:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x0097 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.ItemProductActionBindingImpl.executeBindings():void");
    }
}
