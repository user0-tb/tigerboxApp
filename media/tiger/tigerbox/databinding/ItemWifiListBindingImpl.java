package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

public class ItemWifiListBindingImpl extends ItemWifiListBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback39;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1801wifiListItemicon_container, 3);
        sparseIntArray.put(C2814R.C2817id.f1800wifiListItemconnecting_icon, 4);
        sparseIntArray.put(C2814R.C2817id.f1799wifiListItemconnected_icon, 5);
    }

    public ItemWifiListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemWifiListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[5], objArr[4], objArr[3], objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.wifiListItemLevelIcon.setTag((Object) null);
        this.wifiListItemSsidName.setTag((Object) null);
        setRootTag(view);
        this.mCallback39 = new OnClickListener(this, 1);
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
        if (59 == i) {
            setWifiItem((WifiItem) obj);
        } else if (14 != i) {
            return false;
        } else {
            setClickListener((BindingClickListener) obj);
        }
        return true;
    }

    public void setWifiItem(WifiItem wifiItem) {
        this.mWifiItem = wifiItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(59);
        super.requestRebind();
    }

    public void setClickListener(BindingClickListener<WifiItem> bindingClickListener) {
        this.mClickListener = bindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        WifiItem wifiItem = this.mWifiItem;
        BindingClickListener bindingClickListener = this.mClickListener;
        String str = null;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if (!(i == 0 || wifiItem == null)) {
            str = wifiItem.getSsid();
        }
        if ((j & 4) != 0) {
            this.mboundView0.setOnClickListener(this.mCallback39);
        }
        if (i != 0) {
            BindingAdaptersKt.wifiStrengthIcon(this.wifiListItemLevelIcon, wifiItem);
            TextViewBindingAdapter.setText(this.wifiListItemSsidName, str);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        WifiItem wifiItem = this.mWifiItem;
        BindingClickListener bindingClickListener = this.mClickListener;
        if (bindingClickListener != null) {
            bindingClickListener.onClick(wifiItem);
        }
    }
}
