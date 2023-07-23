package media.tiger.tigerbox.databinding;

import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.Spanned;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public class FragmentParentalGateBindingImpl extends FragmentParentalGateBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback10;
    private final View.OnClickListener mCallback11;
    private final View.OnClickListener mCallback12;
    private final View.OnClickListener mCallback13;
    private final View.OnClickListener mCallback14;
    private final View.OnClickListener mCallback15;
    private final View.OnClickListener mCallback16;
    private final View.OnClickListener mCallback5;
    private final View.OnClickListener mCallback6;
    private final View.OnClickListener mCallback7;
    private final View.OnClickListener mCallback8;
    private final View.OnClickListener mCallback9;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1554fragmentparentalGateguideline, 17);
        sparseIntArray.put(C2814R.C2817id.f1555fragmentparentalGateinfoArea, 18);
        sparseIntArray.put(C2814R.C2817id.f1560fragmentparentalGatetitle, 19);
        sparseIntArray.put(C2814R.C2817id.f1556fragmentparentalGatenumpad, 20);
    }

    public FragmentParentalGateBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private FragmentParentalGateBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[16], objArr[15], objArr[6], objArr[7], objArr[8], objArr[9], objArr[10], objArr[11], objArr[12], objArr[13], objArr[14], objArr[5], objArr[3], objArr[17], objArr[18], objArr[20], objArr[4], objArr[2], objArr[1], objArr[19]);
        this.mDirtyFlags = -1;
        this.fragmentParentalGateBackSpace.setTag((Object) null);
        this.fragmentParentalGateButton0.setTag((Object) null);
        this.fragmentParentalGateButton1.setTag((Object) null);
        this.fragmentParentalGateButton2.setTag((Object) null);
        this.fragmentParentalGateButton3.setTag((Object) null);
        this.fragmentParentalGateButton4.setTag((Object) null);
        this.fragmentParentalGateButton5.setTag((Object) null);
        this.fragmentParentalGateButton6.setTag((Object) null);
        this.fragmentParentalGateButton7.setTag((Object) null);
        this.fragmentParentalGateButton8.setTag((Object) null);
        this.fragmentParentalGateButton9.setTag((Object) null);
        this.fragmentParentalGateCancel.setTag((Object) null);
        this.fragmentParentalGateCustomPinDescription.setTag((Object) null);
        this.fragmentParentalGatePin.setTag((Object) null);
        this.fragmentParentalGateRandomPinAsText.setTag((Object) null);
        this.fragmentParentalGateRandomPinDescription.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        setRootTag(view);
        this.mCallback15 = new OnClickListener(this, 11);
        this.mCallback13 = new OnClickListener(this, 9);
        this.mCallback11 = new OnClickListener(this, 7);
        this.mCallback8 = new OnClickListener(this, 4);
        this.mCallback6 = new OnClickListener(this, 2);
        this.mCallback16 = new OnClickListener(this, 12);
        this.mCallback14 = new OnClickListener(this, 10);
        this.mCallback12 = new OnClickListener(this, 8);
        this.mCallback10 = new OnClickListener(this, 6);
        this.mCallback9 = new OnClickListener(this, 5);
        this.mCallback7 = new OnClickListener(this, 3);
        this.mCallback5 = new OnClickListener(this, 1);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 128;
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
        if (10 == i) {
            setCancelListener((UnTypedBindingClickListener) obj);
        } else if (36 == i) {
            setPinText((Spanned) obj);
        } else if (34 == i) {
            setNumberClickListener((BindingClickListener) obj);
        } else if (23 == i) {
            setHasRandomPin((Boolean) obj);
        } else if (22 == i) {
            setHasError((Boolean) obj);
        } else if (2 == i) {
            setAccountPin((Spanned) obj);
        } else if (6 != i) {
            return false;
        } else {
            setBackSpaceListener((UnTypedBindingClickListener) obj);
        }
        return true;
    }

    public void setCancelListener(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mCancelListener = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    public void setPinText(Spanned spanned) {
        this.mPinText = spanned;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    public void setNumberClickListener(BindingClickListener<Character> bindingClickListener) {
        this.mNumberClickListener = bindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(34);
        super.requestRebind();
    }

    public void setHasRandomPin(Boolean bool) {
        this.mHasRandomPin = bool;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(23);
        super.requestRebind();
    }

    public void setHasError(Boolean bool) {
        this.mHasError = bool;
    }

    public void setAccountPin(Spanned spanned) {
        this.mAccountPin = spanned;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    public void setBackSpaceListener(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mBackSpaceListener = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UnTypedBindingClickListener unTypedBindingClickListener = this.mCancelListener;
        Spanned spanned = this.mPinText;
        BindingClickListener bindingClickListener = this.mNumberClickListener;
        Boolean bool = this.mHasRandomPin;
        Spanned spanned2 = this.mAccountPin;
        UnTypedBindingClickListener unTypedBindingClickListener2 = this.mBackSpaceListener;
        int i2 = 0;
        int i3 = ((j & 136) > 0 ? 1 : ((j & 136) == 0 ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                if (safeUnbox) {
                    j3 = j | 512;
                    j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                } else {
                    j3 = j | 256;
                    j2 = 1024;
                }
                j = j3 | j2;
            }
            i = safeUnbox ? 0 : 8;
            if (safeUnbox) {
                i2 = 8;
            }
        } else {
            i = 0;
        }
        int i4 = ((160 & j) > 0 ? 1 : ((160 & j) == 0 ? 0 : -1));
        if ((128 & j) != 0) {
            this.fragmentParentalGateBackSpace.setOnClickListener(this.mCallback16);
            this.fragmentParentalGateButton0.setOnClickListener(this.mCallback15);
            this.fragmentParentalGateButton1.setOnClickListener(this.mCallback6);
            this.fragmentParentalGateButton2.setOnClickListener(this.mCallback7);
            this.fragmentParentalGateButton3.setOnClickListener(this.mCallback8);
            this.fragmentParentalGateButton4.setOnClickListener(this.mCallback9);
            this.fragmentParentalGateButton5.setOnClickListener(this.mCallback10);
            this.fragmentParentalGateButton6.setOnClickListener(this.mCallback11);
            this.fragmentParentalGateButton7.setOnClickListener(this.mCallback12);
            this.fragmentParentalGateButton8.setOnClickListener(this.mCallback13);
            this.fragmentParentalGateButton9.setOnClickListener(this.mCallback14);
            this.fragmentParentalGateCancel.setOnClickListener(this.mCallback5);
        }
        if ((136 & j) != 0) {
            this.fragmentParentalGateCustomPinDescription.setVisibility(i2);
            this.fragmentParentalGateRandomPinAsText.setVisibility(i);
            this.fragmentParentalGateRandomPinDescription.setVisibility(i);
        }
        if ((j & 130) != 0) {
            TextViewBindingAdapter.setText(this.fragmentParentalGatePin, spanned);
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.fragmentParentalGateRandomPinAsText, spanned2);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = true;
        switch (i) {
            case 1:
                UnTypedBindingClickListener unTypedBindingClickListener = this.mCancelListener;
                if (unTypedBindingClickListener == null) {
                    z = false;
                }
                if (z) {
                    unTypedBindingClickListener.onClick();
                    return;
                }
                return;
            case 2:
                BindingClickListener bindingClickListener = this.mNumberClickListener;
                if (bindingClickListener == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener.onClick('1');
                    return;
                }
                return;
            case 3:
                BindingClickListener bindingClickListener2 = this.mNumberClickListener;
                if (bindingClickListener2 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener2.onClick('2');
                    return;
                }
                return;
            case 4:
                BindingClickListener bindingClickListener3 = this.mNumberClickListener;
                if (bindingClickListener3 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener3.onClick('3');
                    return;
                }
                return;
            case 5:
                BindingClickListener bindingClickListener4 = this.mNumberClickListener;
                if (bindingClickListener4 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener4.onClick('4');
                    return;
                }
                return;
            case 6:
                BindingClickListener bindingClickListener5 = this.mNumberClickListener;
                if (bindingClickListener5 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener5.onClick('5');
                    return;
                }
                return;
            case 7:
                BindingClickListener bindingClickListener6 = this.mNumberClickListener;
                if (bindingClickListener6 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener6.onClick('6');
                    return;
                }
                return;
            case 8:
                BindingClickListener bindingClickListener7 = this.mNumberClickListener;
                if (bindingClickListener7 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener7.onClick('7');
                    return;
                }
                return;
            case 9:
                BindingClickListener bindingClickListener8 = this.mNumberClickListener;
                if (bindingClickListener8 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener8.onClick('8');
                    return;
                }
                return;
            case 10:
                BindingClickListener bindingClickListener9 = this.mNumberClickListener;
                if (bindingClickListener9 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener9.onClick('9');
                    return;
                }
                return;
            case 11:
                BindingClickListener bindingClickListener10 = this.mNumberClickListener;
                if (bindingClickListener10 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener10.onClick('0');
                    return;
                }
                return;
            case 12:
                UnTypedBindingClickListener unTypedBindingClickListener2 = this.mBackSpaceListener;
                if (unTypedBindingClickListener2 == null) {
                    z = false;
                }
                if (z) {
                    unTypedBindingClickListener2.onClick();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
