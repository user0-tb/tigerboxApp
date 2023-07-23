package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public class FragmentWifiEnterPasswordBindingImpl extends FragmentWifiEnterPasswordBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback23;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1797wifiEnterPswtitle, 4);
        sparseIntArray.put(C2814R.C2817id.f1798wifiEnterPswwifi_name, 5);
        sparseIntArray.put(C2814R.C2817id.f1796wifiEnterPsweditText_layout, 6);
        sparseIntArray.put(C2814R.C2817id.f1794wifiEnterPswconfirm_button, 7);
    }

    public FragmentWifiEnterPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 8, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentWifiEnterPasswordBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[1], objArr[3], objArr[7], objArr[2], objArr[6], objArr[4], objArr[5]);
        this.mDirtyFlags = -1;
        LinearLayout linearLayout = objArr[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag((Object) null);
        this.wifiEnterPasswordSsidName.setTag((Object) null);
        this.wifiEnterPswCancelButton.setTag((Object) null);
        this.wifiEnterPswEditText.setTag((Object) null);
        View view2 = view;
        setRootTag(view);
        this.mCallback23 = new OnClickListener(this, 1);
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
        if (35 == i) {
            setPassword((String) obj);
        } else if (16 == i) {
            setCloseHandler((UnTypedBindingClickListener) obj);
        } else if (60 != i) {
            return false;
        } else {
            setWifiName((String) obj);
        }
        return true;
    }

    public void setPassword(String str) {
        this.mPassword = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(35);
        super.requestRebind();
    }

    public void setCloseHandler(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mCloseHandler = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    public void setWifiName(String str) {
        this.mWifiName = str;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(60);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        String str = this.mPassword;
        UnTypedBindingClickListener unTypedBindingClickListener = this.mCloseHandler;
        String str2 = this.mWifiName;
        int i = ((9 & j) > 0 ? 1 : ((9 & j) == 0 ? 0 : -1));
        if ((12 & j) != 0) {
            TextViewBindingAdapter.setText(this.wifiEnterPasswordSsidName, str2);
        }
        if ((j & 8) != 0) {
            this.wifiEnterPswCancelButton.setOnClickListener(this.mCallback23);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.wifiEnterPswEditText, str);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        UnTypedBindingClickListener unTypedBindingClickListener = this.mCloseHandler;
        if (unTypedBindingClickListener != null) {
            unTypedBindingClickListener.onClick();
        }
    }
}
