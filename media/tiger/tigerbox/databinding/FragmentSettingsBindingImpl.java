package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import media.tiger.tigerbox.C2814R;

public class FragmentSettingsBindingImpl extends FragmentSettingsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"include_dialog_header_bar"}, new int[]{3}, new int[]{C2814R.C2819layout.include_dialog_header_bar});
    }

    public FragmentSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private FragmentSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, objArr[3], objArr[0], objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        setContainedBinding(this.fragmentHeaderBar);
        this.settingsContainer.setTag((Object) null);
        this.settingsRecyclerView.setTag((Object) null);
        this.settingsSubscriptionInfo.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
        }
        this.fragmentHeaderBar.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.fragmentHeaderBar.hasPendingBindings() == false) goto L_0x0016;
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
            media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding r0 = r6.fragmentHeaderBar
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
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.FragmentSettingsBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i, Object obj) {
        if (46 == i) {
            setSubscriptionEndDate((String) obj);
        } else if (45 == i) {
            setSubscriptionAboutToExpired((Boolean) obj);
        } else if (48 == i) {
            setSubscriptionVisible((Boolean) obj);
        } else if (47 != i) {
            return false;
        } else {
            setSubscriptionExpired((Boolean) obj);
        }
        return true;
    }

    public void setSubscriptionEndDate(String str) {
        this.mSubscriptionEndDate = str;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(46);
        super.requestRebind();
    }

    public void setSubscriptionAboutToExpired(Boolean bool) {
        this.mSubscriptionAboutToExpired = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(45);
        super.requestRebind();
    }

    public void setSubscriptionVisible(Boolean bool) {
        this.mSubscriptionVisible = bool;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(48);
        super.requestRebind();
    }

    public void setSubscriptionExpired(Boolean bool) {
        this.mSubscriptionExpired = bool;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(47);
        super.requestRebind();
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.fragmentHeaderBar.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeFragmentHeaderBar((IncludeDialogHeaderBarBinding) obj, i2);
    }

    private boolean onChangeFragmentHeaderBar(IncludeDialogHeaderBarBinding includeDialogHeaderBarBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r23 = this;
            r1 = r23
            monitor-enter(r23)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0100 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0100 }
            monitor-exit(r23)     // Catch:{ all -> 0x0100 }
            java.lang.String r0 = r1.mSubscriptionEndDate
            java.lang.Boolean r6 = r1.mSubscriptionAboutToExpired
            java.lang.Boolean r7 = r1.mSubscriptionVisible
            java.lang.Boolean r8 = r1.mSubscriptionExpired
            r9 = 40
            long r11 = r2 & r9
            r13 = 0
            int r14 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x002e
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            if (r14 == 0) goto L_0x0029
            if (r7 == 0) goto L_0x0026
            r11 = 512(0x200, double:2.53E-321)
            goto L_0x0028
        L_0x0026:
            r11 = 256(0x100, double:1.265E-321)
        L_0x0028:
            long r2 = r2 | r11
        L_0x0029:
            if (r7 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r7 = 4
            goto L_0x002f
        L_0x002e:
            r7 = 0
        L_0x002f:
            r11 = 54
            long r11 = r11 & r2
            r14 = 50
            r16 = 64
            r18 = 52
            r20 = 1024(0x400, double:5.06E-321)
            int r22 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x005f
            boolean r8 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r8)
            long r11 = r2 & r18
            int r22 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x0050
            if (r8 == 0) goto L_0x004e
            r11 = 128(0x80, double:6.32E-322)
            long r2 = r2 | r11
            goto L_0x0050
        L_0x004e:
            long r2 = r2 | r16
        L_0x0050:
            long r11 = r2 & r14
            int r22 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r22 == 0) goto L_0x0060
            if (r8 == 0) goto L_0x005c
            r11 = 2048(0x800, double:1.0118E-320)
            long r2 = r2 | r11
            goto L_0x0060
        L_0x005c:
            long r2 = r2 | r20
            goto L_0x0060
        L_0x005f:
            r8 = 0
        L_0x0060:
            long r11 = r2 & r20
            r20 = 0
            int r21 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x007f
            android.widget.TextView r11 = r1.settingsSubscriptionInfo
            android.content.res.Resources r11 = r11.getResources()
            r12 = 2131951974(0x7f130166, float:1.9540378E38)
            java.lang.String r11 = r11.getString(r12)
            r12 = 1
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r12[r13] = r0
            java.lang.String r0 = java.lang.String.format(r11, r12)
            goto L_0x0081
        L_0x007f:
            r0 = r20
        L_0x0081:
            long r11 = r2 & r16
            int r16 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00a7
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r16 == 0) goto L_0x0095
            if (r6 == 0) goto L_0x0092
            r11 = 8192(0x2000, double:4.0474E-320)
            goto L_0x0094
        L_0x0092:
            r11 = 4096(0x1000, double:2.0237E-320)
        L_0x0094:
            long r2 = r2 | r11
        L_0x0095:
            if (r6 == 0) goto L_0x009d
            android.widget.TextView r6 = r1.settingsSubscriptionInfo
            r11 = 2131100279(0x7f060277, float:1.7812935E38)
            goto L_0x00a2
        L_0x009d:
            android.widget.TextView r6 = r1.settingsSubscriptionInfo
            r11 = 2131100281(0x7f060279, float:1.781294E38)
        L_0x00a2:
            int r6 = getColorFromResource(r6, r11)
            goto L_0x00a8
        L_0x00a7:
            r6 = 0
        L_0x00a8:
            long r11 = r2 & r18
            int r16 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x00ba
            if (r8 == 0) goto L_0x00b9
            android.widget.TextView r6 = r1.settingsSubscriptionInfo
            r11 = 2131100280(0x7f060278, float:1.7812937E38)
            int r6 = getColorFromResource(r6, r11)
        L_0x00b9:
            r13 = r6
        L_0x00ba:
            long r11 = r2 & r14
            int r6 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00d0
            if (r8 == 0) goto L_0x00d2
            android.widget.TextView r0 = r1.settingsSubscriptionInfo
            android.content.res.Resources r0 = r0.getResources()
            r8 = 2131951973(0x7f130165, float:1.9540376E38)
            java.lang.String r0 = r0.getString(r8)
            goto L_0x00d2
        L_0x00d0:
            r0 = r20
        L_0x00d2:
            r11 = 32
            long r11 = r11 & r2
            int r8 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00e2
            androidx.recyclerview.widget.RecyclerView r8 = r1.settingsRecyclerView
            r11 = r20
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r11 = (androidx.recyclerview.widget.RecyclerView.ItemAnimator) r11
            r8.setItemAnimator(r11)
        L_0x00e2:
            if (r6 == 0) goto L_0x00e9
            android.widget.TextView r6 = r1.settingsSubscriptionInfo
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r6, r0)
        L_0x00e9:
            if (r16 == 0) goto L_0x00f0
            android.widget.TextView r0 = r1.settingsSubscriptionInfo
            r0.setTextColor(r13)
        L_0x00f0:
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00fa
            android.widget.TextView r0 = r1.settingsSubscriptionInfo
            r0.setVisibility(r7)
        L_0x00fa:
            media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding r0 = r1.fragmentHeaderBar
            executeBindingsOn(r0)
            return
        L_0x0100:
            r0 = move-exception
            monitor-exit(r23)     // Catch:{ all -> 0x0100 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.FragmentSettingsBindingImpl.executeBindings():void");
    }
}
