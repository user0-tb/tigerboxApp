package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersTimeLimitItem;

public class ItemTimersLimitsSpecificBindingImpl extends ItemTimersLimitsSpecificBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemTimersLimitsSpecificBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 2, sIncludes, sViewsWithIds));
    }

    private ItemTimersLimitsSpecificBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.timersSetupItemTitle.setTag((Object) null);
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
        if (51 != i) {
            return false;
        }
        setTimersTimeLimitItem((TimersTimeLimitItem) obj);
        return true;
    }

    public void setTimersTimeLimitItem(TimersTimeLimitItem timersTimeLimitItem) {
        this.mTimersTimeLimitItem = timersTimeLimitItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(51);
        super.requestRebind();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: boolean} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r12 = this;
            monitor-enter(r12)
            long r0 = r12.mDirtyFlags     // Catch:{ all -> 0x004e }
            r2 = 0
            r12.mDirtyFlags = r2     // Catch:{ all -> 0x004e }
            monitor-exit(r12)     // Catch:{ all -> 0x004e }
            media.tiger.tigerbox.ui.settings.timersSetup.TimersTimeLimitItem r4 = r12.mTimersTimeLimitItem
            r5 = 3
            long r7 = r0 & r5
            r9 = 0
            int r10 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r10 == 0) goto L_0x003d
            if (r4 == 0) goto L_0x001e
            boolean r9 = r4.getSelected()
            int r4 = r4.getTitle()
            goto L_0x001f
        L_0x001e:
            r4 = 0
        L_0x001f:
            if (r10 == 0) goto L_0x0029
            if (r9 == 0) goto L_0x0026
            r7 = 8
            goto L_0x0028
        L_0x0026:
            r7 = 4
        L_0x0028:
            long r0 = r0 | r7
        L_0x0029:
            android.widget.TextView r7 = r12.timersSetupItemTitle
            if (r9 == 0) goto L_0x0031
            r8 = 2131100279(0x7f060277, float:1.7812935E38)
            goto L_0x0034
        L_0x0031:
            r8 = 2131099742(0x7f06005e, float:1.7811846E38)
        L_0x0034:
            int r7 = getColorFromResource(r7, r8)
            r9 = r7
            r11 = r9
            r9 = r4
            r4 = r11
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            long r0 = r0 & r5
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x004d
            android.widget.TextView r0 = r12.timersSetupItemTitle
            r0.setText(r9)
            android.widget.TextView r0 = r12.timersSetupItemTitle
            r0.setTextColor(r4)
        L_0x004d:
            return
        L_0x004e:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x004e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.ItemTimersLimitsSpecificBindingImpl.executeBindings():void");
    }
}
