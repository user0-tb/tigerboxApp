package media.tiger.tigerbox.databinding;

import android.text.Spanned;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public class FragmentTigerTicketInputPinBindingImpl extends FragmentTigerTicketInputPinBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback27;
    private final View.OnClickListener mCallback28;
    private final View.OnClickListener mCallback29;
    private final View.OnClickListener mCallback30;
    private final View.OnClickListener mCallback31;
    private final View.OnClickListener mCallback32;
    private final View.OnClickListener mCallback33;
    private final View.OnClickListener mCallback34;
    private final View.OnClickListener mCallback35;
    private final View.OnClickListener mCallback36;
    private final View.OnClickListener mCallback37;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1529fragmentclose_button, 15);
        sparseIntArray.put(C2814R.C2817id.f1582fragmenttigerCardinfo, 16);
        sparseIntArray.put(C2814R.C2817id.f1583fragmenttigerCardnumpad, 17);
    }

    public FragmentTigerTicketInputPinBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentTigerTicketInputPinBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[15] != null ? IncludeDialogCloseButtonBinding.bind(objArr[15]) : null, objArr[14], objArr[13], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8], objArr[9], objArr[10], objArr[11], objArr[12], objArr[1], objArr[16], objArr[17], objArr[3], objArr[2]);
        this.mDirtyFlags = -1;
        this.fragmentTigerCardBackSpace.setTag((Object) null);
        this.fragmentTigerCardButton0.setTag((Object) null);
        this.fragmentTigerCardButton1.setTag((Object) null);
        this.fragmentTigerCardButton2.setTag((Object) null);
        this.fragmentTigerCardButton3.setTag((Object) null);
        this.fragmentTigerCardButton4.setTag((Object) null);
        this.fragmentTigerCardButton5.setTag((Object) null);
        this.fragmentTigerCardButton6.setTag((Object) null);
        this.fragmentTigerCardButton7.setTag((Object) null);
        this.fragmentTigerCardButton8.setTag((Object) null);
        this.fragmentTigerCardButton9.setTag((Object) null);
        this.fragmentTigerCardError.setTag((Object) null);
        this.fragmentTigerCardPin.setTag((Object) null);
        this.fragmentTigerCardTitle.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        setRootTag(view);
        this.mCallback27 = new OnClickListener(this, 1);
        this.mCallback35 = new OnClickListener(this, 9);
        this.mCallback30 = new OnClickListener(this, 4);
        this.mCallback28 = new OnClickListener(this, 2);
        this.mCallback36 = new OnClickListener(this, 10);
        this.mCallback32 = new OnClickListener(this, 6);
        this.mCallback31 = new OnClickListener(this, 5);
        this.mCallback37 = new OnClickListener(this, 11);
        this.mCallback33 = new OnClickListener(this, 7);
        this.mCallback29 = new OnClickListener(this, 3);
        this.mCallback34 = new OnClickListener(this, 8);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32;
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
        if (34 == i) {
            setNumberClickListener((BindingClickListener) obj);
        } else if (3 == i) {
            setAttemptCount((Integer) obj);
        } else if (22 == i) {
            setHasError((Boolean) obj);
        } else if (6 == i) {
            setBackSpaceListener((UnTypedBindingClickListener) obj);
        } else if (36 != i) {
            return false;
        } else {
            setPinText((Spanned) obj);
        }
        return true;
    }

    public void setNumberClickListener(BindingClickListener<Character> bindingClickListener) {
        this.mNumberClickListener = bindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(34);
        super.requestRebind();
    }

    public void setAttemptCount(Integer num) {
        this.mAttemptCount = num;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    public void setHasError(Boolean bool) {
        this.mHasError = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    public void setBackSpaceListener(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mBackSpaceListener = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    public void setPinText(Spanned spanned) {
        this.mPinText = spanned;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(36);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r23 = this;
            r1 = r23
            monitor-enter(r23)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x0134 }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x0134 }
            monitor-exit(r23)     // Catch:{ all -> 0x0134 }
            media.tiger.tigerbox.ui.binding.BindingClickListener r0 = r1.mNumberClickListener
            java.lang.Integer r0 = r1.mAttemptCount
            java.lang.Boolean r6 = r1.mHasError
            media.tiger.tigerbox.ui.binding.UnTypedBindingClickListener r7 = r1.mBackSpaceListener
            android.text.Spanned r7 = r1.mPinText
            r8 = 38
            long r10 = r2 & r8
            r12 = 36
            r14 = 128(0x80, double:6.32E-322)
            r16 = 0
            int r17 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x004a
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r17 == 0) goto L_0x002f
            if (r6 == 0) goto L_0x002c
            long r2 = r2 | r14
            goto L_0x002f
        L_0x002c:
            r10 = 64
            long r2 = r2 | r10
        L_0x002f:
            long r10 = r2 & r12
            int r17 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x003d
            if (r6 == 0) goto L_0x003a
            r10 = 2048(0x800, double:1.0118E-320)
            goto L_0x003c
        L_0x003a:
            r10 = 1024(0x400, double:5.06E-321)
        L_0x003c:
            long r2 = r2 | r10
        L_0x003d:
            long r10 = r2 & r12
            int r17 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r17 == 0) goto L_0x0045
            if (r6 == 0) goto L_0x0047
        L_0x0045:
            r10 = 0
            goto L_0x004c
        L_0x0047:
            r10 = 8
            goto L_0x004c
        L_0x004a:
            r6 = 0
            goto L_0x0045
        L_0x004c:
            long r17 = r2 & r14
            r11 = 1
            r19 = 512(0x200, double:2.53E-321)
            int r21 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x006c
            int r17 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Integer) r0)
            if (r17 <= 0) goto L_0x005e
            r17 = 1
            goto L_0x0060
        L_0x005e:
            r17 = 0
        L_0x0060:
            if (r21 == 0) goto L_0x006e
            if (r17 == 0) goto L_0x0067
            long r2 = r2 | r19
            goto L_0x006e
        L_0x0067:
            r21 = 256(0x100, double:1.265E-321)
            long r2 = r2 | r21
            goto L_0x006e
        L_0x006c:
            r17 = 0
        L_0x006e:
            long r18 = r2 & r19
            r20 = 0
            int r21 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r21 == 0) goto L_0x008c
            android.widget.TextView r12 = r1.fragmentTigerCardTitle
            android.content.res.Resources r12 = r12.getResources()
            r13 = 2131952065(0x7f1301c1, float:1.9540562E38)
            java.lang.String r12 = r12.getString(r13)
            java.lang.Object[] r11 = new java.lang.Object[r11]
            r11[r16] = r0
            java.lang.String r0 = java.lang.String.format(r12, r11)
            goto L_0x008e
        L_0x008c:
            r0 = r20
        L_0x008e:
            long r11 = r2 & r14
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00a5
            if (r17 == 0) goto L_0x0097
            goto L_0x00a7
        L_0x0097:
            android.widget.TextView r0 = r1.fragmentTigerCardTitle
            android.content.res.Resources r0 = r0.getResources()
            r11 = 2131952066(0x7f1301c2, float:1.9540564E38)
            java.lang.String r0 = r0.getString(r11)
            goto L_0x00a7
        L_0x00a5:
            r0 = r20
        L_0x00a7:
            long r8 = r8 & r2
            int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x00be
            if (r6 == 0) goto L_0x00af
            goto L_0x00bc
        L_0x00af:
            android.widget.TextView r0 = r1.fragmentTigerCardTitle
            android.content.res.Resources r0 = r0.getResources()
            r6 = 2131952067(0x7f1301c3, float:1.9540566E38)
            java.lang.String r0 = r0.getString(r6)
        L_0x00bc:
            r20 = r0
        L_0x00be:
            r0 = r20
            r8 = 32
            long r8 = r8 & r2
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0114
            android.widget.ImageButton r6 = r1.fragmentTigerCardBackSpace
            android.view.View$OnClickListener r8 = r1.mCallback37
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton0
            android.view.View$OnClickListener r8 = r1.mCallback36
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton1
            android.view.View$OnClickListener r8 = r1.mCallback27
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton2
            android.view.View$OnClickListener r8 = r1.mCallback28
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton3
            android.view.View$OnClickListener r8 = r1.mCallback29
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton4
            android.view.View$OnClickListener r8 = r1.mCallback30
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton5
            android.view.View$OnClickListener r8 = r1.mCallback31
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton6
            android.view.View$OnClickListener r8 = r1.mCallback32
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton7
            android.view.View$OnClickListener r8 = r1.mCallback33
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton8
            android.view.View$OnClickListener r8 = r1.mCallback34
            r6.setOnClickListener(r8)
            android.widget.ImageButton r6 = r1.fragmentTigerCardButton9
            android.view.View$OnClickListener r8 = r1.mCallback35
            r6.setOnClickListener(r8)
        L_0x0114:
            r8 = 36
            long r8 = r8 & r2
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0120
            android.widget.TextView r6 = r1.fragmentTigerCardError
            r6.setVisibility(r10)
        L_0x0120:
            r8 = 48
            long r2 = r2 & r8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x012c
            android.widget.TextView r2 = r1.fragmentTigerCardPin
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r7)
        L_0x012c:
            if (r11 == 0) goto L_0x0133
            android.widget.TextView r2 = r1.fragmentTigerCardTitle
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r0)
        L_0x0133:
            return
        L_0x0134:
            r0 = move-exception
            monitor-exit(r23)     // Catch:{ all -> 0x0134 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.FragmentTigerTicketInputPinBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = true;
        switch (i) {
            case 1:
                BindingClickListener bindingClickListener = this.mNumberClickListener;
                if (bindingClickListener == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener.onClick('1');
                    return;
                }
                return;
            case 2:
                BindingClickListener bindingClickListener2 = this.mNumberClickListener;
                if (bindingClickListener2 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener2.onClick('2');
                    return;
                }
                return;
            case 3:
                BindingClickListener bindingClickListener3 = this.mNumberClickListener;
                if (bindingClickListener3 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener3.onClick('3');
                    return;
                }
                return;
            case 4:
                BindingClickListener bindingClickListener4 = this.mNumberClickListener;
                if (bindingClickListener4 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener4.onClick('4');
                    return;
                }
                return;
            case 5:
                BindingClickListener bindingClickListener5 = this.mNumberClickListener;
                if (bindingClickListener5 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener5.onClick('5');
                    return;
                }
                return;
            case 6:
                BindingClickListener bindingClickListener6 = this.mNumberClickListener;
                if (bindingClickListener6 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener6.onClick('6');
                    return;
                }
                return;
            case 7:
                BindingClickListener bindingClickListener7 = this.mNumberClickListener;
                if (bindingClickListener7 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener7.onClick('7');
                    return;
                }
                return;
            case 8:
                BindingClickListener bindingClickListener8 = this.mNumberClickListener;
                if (bindingClickListener8 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener8.onClick('8');
                    return;
                }
                return;
            case 9:
                BindingClickListener bindingClickListener9 = this.mNumberClickListener;
                if (bindingClickListener9 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener9.onClick('9');
                    return;
                }
                return;
            case 10:
                BindingClickListener bindingClickListener10 = this.mNumberClickListener;
                if (bindingClickListener10 == null) {
                    z = false;
                }
                if (z) {
                    bindingClickListener10.onClick('0');
                    return;
                }
                return;
            case 11:
                UnTypedBindingClickListener unTypedBindingClickListener = this.mBackSpaceListener;
                if (unTypedBindingClickListener == null) {
                    z = false;
                }
                if (z) {
                    unTypedBindingClickListener.onClick();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
