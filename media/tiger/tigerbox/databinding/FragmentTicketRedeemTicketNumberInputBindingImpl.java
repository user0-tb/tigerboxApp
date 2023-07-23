package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public class FragmentTicketRedeemTicketNumberInputBindingImpl extends FragmentTicketRedeemTicketNumberInputBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback38;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1586fragmenttigerTicketRedeemguideline, 2);
        sparseIntArray.put(C2814R.C2817id.f1784tigerTicketRedeemtitle, 3);
        sparseIntArray.put(C2814R.C2817id.f1783tigerTicketRedeemmessage, 4);
        sparseIntArray.put(C2814R.C2817id.f1782tigerTicketRedeeminputTitle, 5);
        sparseIntArray.put(C2814R.C2817id.f1781tigerTicketRedeemeditText_layout, 6);
        sparseIntArray.put(C2814R.C2817id.f1780tigerTicketRedeemeditText, 7);
        sparseIntArray.put(C2814R.C2817id.f1779tigerTicketRedeemconfirm_button, 8);
    }

    public FragmentTicketRedeemTicketNumberInputBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 9, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentTicketRedeemTicketNumberInputBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[1], objArr[8], objArr[7], objArr[6], objArr[5], objArr[4], objArr[3]);
        this.mDirtyFlags = -1;
        NestedScrollView nestedScrollView = objArr[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag((Object) null);
        this.tigerTicketRedeemCancelButton.setTag((Object) null);
        setRootTag(view);
        this.mCallback38 = new OnClickListener(this, 1);
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
        if (16 != i) {
            return false;
        }
        setCloseHandler((UnTypedBindingClickListener) obj);
        return true;
    }

    public void setCloseHandler(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mCloseHandler = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UnTypedBindingClickListener unTypedBindingClickListener = this.mCloseHandler;
        if ((j & 2) != 0) {
            this.tigerTicketRedeemCancelButton.setOnClickListener(this.mCallback38);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        UnTypedBindingClickListener unTypedBindingClickListener = this.mCloseHandler;
        if (unTypedBindingClickListener != null) {
            unTypedBindingClickListener.onClick();
        }
    }
}
