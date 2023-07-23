package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.ProductDomain;

public class ItemProductBindingImpl extends ItemProductBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_product_action"}, new int[]{5}, new int[]{C2814R.C2819layout.item_product_action});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.ripple, 6);
    }

    public ItemProductBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 7, sIncludes, sViewsWithIds));
    }

    private ItemProductBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, objArr[5], objArr[0], objArr[2], objArr[3], objArr[1], objArr[4], objArr[6]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.productAction);
        this.productConstraintLayout.setTag((Object) null);
        this.productDlStateDlBackground.setTag((Object) null);
        this.productDlStateIcon.setTag((Object) null);
        this.productImage.setTag((Object) null);
        this.productTitle.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        this.productAction.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.productAction.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0018 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            media.tiger.tigerbox.databinding.ItemProductActionBinding r0 = r6.productAction
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.ItemProductBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i, Object obj) {
        if (9 != i) {
            return false;
        }
        setBindingProduct((ProductDomain) obj);
        return true;
    }

    public void setBindingProduct(ProductDomain productDomain) {
        this.mBindingProduct = productDomain;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(9);
        super.requestRebind();
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.productAction.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeProductAction((ItemProductActionBinding) obj, i2);
    }

    private boolean onChangeProductAction(ItemProductActionBinding itemProductActionBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [media.tiger.tigerbox.model.domain.OfflineAvailabilityState] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r17 = this;
            r1 = r17
            monitor-enter(r17)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00a8 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00a8 }
            monitor-exit(r17)     // Catch:{ all -> 0x00a8 }
            media.tiger.tigerbox.model.domain.ProductDomain r0 = r1.mBindingProduct
            r6 = 6
            long r8 = r2 & r6
            r10 = 0
            r11 = 0
            int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x0081
            if (r0 == 0) goto L_0x002a
            java.lang.String r10 = r0.getTitle()
            java.lang.String r8 = r0.getImageUrl()
            media.tiger.tigerbox.model.domain.OfflineAvailabilityState r0 = r0.getOfflineAvailabilityState()
            r16 = r10
            r10 = r0
            r0 = r16
            goto L_0x002c
        L_0x002a:
            r0 = r10
            r8 = r0
        L_0x002c:
            media.tiger.tigerbox.model.domain.OfflineAvailabilityState r9 = media.tiger.tigerbox.model.domain.OfflineAvailabilityState.IN_PROGRESS
            r13 = 1
            if (r10 != r9) goto L_0x0033
            r9 = 1
            goto L_0x0034
        L_0x0033:
            r9 = 0
        L_0x0034:
            media.tiger.tigerbox.model.domain.OfflineAvailabilityState r14 = media.tiger.tigerbox.model.domain.OfflineAvailabilityState.NOT_AVAILABLE
            if (r10 != r14) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r13 = 0
        L_0x003a:
            if (r12 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x0044
            r14 = 16
            long r2 = r2 | r14
            r14 = 256(0x100, double:1.265E-321)
            goto L_0x0049
        L_0x0044:
            r14 = 8
            long r2 = r2 | r14
            r14 = 128(0x80, double:6.32E-322)
        L_0x0049:
            long r2 = r2 | r14
        L_0x004a:
            long r14 = r2 & r6
            int r10 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x0058
            if (r13 == 0) goto L_0x0055
            r14 = 64
            goto L_0x0057
        L_0x0055:
            r14 = 32
        L_0x0057:
            long r2 = r2 | r14
        L_0x0058:
            r10 = 8
            if (r9 == 0) goto L_0x005e
            r12 = 0
            goto L_0x0060
        L_0x005e:
            r12 = 8
        L_0x0060:
            if (r9 == 0) goto L_0x006c
            android.widget.ImageView r9 = r1.productDlStateIcon
            android.content.Context r9 = r9.getContext()
            r14 = 2131230976(0x7f080100, float:1.807802E38)
            goto L_0x0075
        L_0x006c:
            android.widget.ImageView r9 = r1.productDlStateIcon
            android.content.Context r9 = r9.getContext()
            r14 = 2131230975(0x7f0800ff, float:1.8078018E38)
        L_0x0075:
            android.graphics.drawable.Drawable r9 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r9, r14)
            if (r13 == 0) goto L_0x007d
            r11 = 8
        L_0x007d:
            r10 = r9
            r9 = r11
            r11 = r12
            goto L_0x0084
        L_0x0081:
            r0 = r10
            r8 = r0
            r9 = 0
        L_0x0084:
            long r2 = r2 & r6
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00a2
            android.view.View r2 = r1.productDlStateDlBackground
            r2.setVisibility(r11)
            android.widget.ImageView r2 = r1.productDlStateIcon
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(r2, r10)
            android.widget.ImageView r2 = r1.productDlStateIcon
            r2.setVisibility(r9)
            android.widget.ImageView r2 = r1.productImage
            media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt.bindImageFromUrl(r2, r8)
            android.widget.TextView r2 = r1.productTitle
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r0)
        L_0x00a2:
            media.tiger.tigerbox.databinding.ItemProductActionBinding r0 = r1.productAction
            executeBindingsOn(r0)
            return
        L_0x00a8:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x00a8 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.ItemProductBindingImpl.executeBindings():void");
    }
}
