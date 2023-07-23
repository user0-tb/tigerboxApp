package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;

public class FragmentOnboardingLoginBindingImpl extends FragmentOnboardingLoginBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private InverseBindingListener onboardingLoginPasswordEditTextandroidTextAttrChanged;
    private InverseBindingListener onboardingLoginUsernameEditTextandroidTextAttrChanged;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static /* synthetic */ long access$078(FragmentOnboardingLoginBindingImpl fragmentOnboardingLoginBindingImpl, long j) {
        long j2 = j | fragmentOnboardingLoginBindingImpl.mDirtyFlags;
        fragmentOnboardingLoginBindingImpl.mDirtyFlags = j2;
        return j2;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1682onboardinglogintitle, 2);
        sparseIntArray.put(C2814R.C2817id.f1676onboardingloginbody, 3);
        sparseIntArray.put(C2814R.C2817id.f1684onboardingloginusername_textView, 4);
        sparseIntArray.put(C2814R.C2817id.f1683onboardingloginusername_editText, 5);
        sparseIntArray.put(C2814R.C2817id.f1681onboardingloginpassword_textView, 6);
        sparseIntArray.put(C2814R.C2817id.f1680onboardingloginpassword_editTextlayout, 7);
        sparseIntArray.put(C2814R.C2817id.f1679onboardingloginpassword_editText, 8);
        sparseIntArray.put(C2814R.C2817id.f1678onboardingloginguideline_horizontal, 9);
    }

    public FragmentOnboardingLoginBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentOnboardingLoginBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[1], objArr[9], objArr[8], objArr[7], objArr[6], objArr[2], objArr[5], objArr[4]);
        this.onboardingLoginPasswordEditTextandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                synchronized (FragmentOnboardingLoginBindingImpl.this) {
                    FragmentOnboardingLoginBindingImpl.access$078(FragmentOnboardingLoginBindingImpl.this, 2);
                }
                FragmentOnboardingLoginBindingImpl.this.requestRebind();
            }
        };
        this.onboardingLoginUsernameEditTextandroidTextAttrChanged = new InverseBindingListener() {
            public void onChange() {
                synchronized (FragmentOnboardingLoginBindingImpl.this) {
                    FragmentOnboardingLoginBindingImpl.access$078(FragmentOnboardingLoginBindingImpl.this, 1);
                }
                FragmentOnboardingLoginBindingImpl.this.requestRebind();
            }
        };
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.onboardingLoginButton.setTag((Object) null);
        setRootTag(view);
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

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r7 > 0) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.mDirtyFlags     // Catch:{ all -> 0x0077 }
            r2 = 0
            r14.mDirtyFlags = r2     // Catch:{ all -> 0x0077 }
            monitor-exit(r14)     // Catch:{ all -> 0x0077 }
            r4 = 7
            long r6 = r0 & r4
            r8 = 1
            r9 = 16
            r11 = 0
            int r12 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0031
            android.widget.EditText r6 = r14.onboardingLoginUsernameEditText
            android.text.Editable r6 = r6.getText()
            if (r6 == 0) goto L_0x0021
            int r6 = r6.length()
            goto L_0x0022
        L_0x0021:
            r6 = 0
        L_0x0022:
            if (r6 <= 0) goto L_0x0026
            r6 = 1
            goto L_0x0027
        L_0x0026:
            r6 = 0
        L_0x0027:
            if (r12 == 0) goto L_0x0032
            if (r6 == 0) goto L_0x002d
            long r0 = r0 | r9
            goto L_0x0032
        L_0x002d:
            r12 = 8
            long r0 = r0 | r12
            goto L_0x0032
        L_0x0031:
            r6 = 0
        L_0x0032:
            long r9 = r9 & r0
            int r7 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x0048
            com.google.android.material.textfield.TextInputEditText r7 = r14.onboardingLoginPasswordEditText
            android.text.Editable r7 = r7.getText()
            if (r7 == 0) goto L_0x0044
            int r7 = r7.length()
            goto L_0x0045
        L_0x0044:
            r7 = 0
        L_0x0045:
            if (r7 <= 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r8 = 0
        L_0x0049:
            long r4 = r4 & r0
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x0051
            if (r6 == 0) goto L_0x0051
            r11 = r8
        L_0x0051:
            if (r7 == 0) goto L_0x0058
            android.widget.Button r4 = r14.onboardingLoginButton
            r4.setEnabled(r11)
        L_0x0058:
            r4 = 4
            long r0 = r0 & r4
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0076
            com.google.android.material.textfield.TextInputEditText r0 = r14.onboardingLoginPasswordEditText
            r1 = 0
            r2 = r1
            androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged r2 = (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged) r2
            r3 = r1
            androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged r3 = (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged) r3
            androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged r1 = (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged) r1
            androidx.databinding.InverseBindingListener r4 = r14.onboardingLoginPasswordEditTextandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r0, r2, r3, r1, r4)
            android.widget.EditText r0 = r14.onboardingLoginUsernameEditText
            androidx.databinding.InverseBindingListener r4 = r14.onboardingLoginUsernameEditTextandroidTextAttrChanged
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(r0, r2, r3, r1, r4)
        L_0x0076:
            return
        L_0x0077:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x0077 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.FragmentOnboardingLoginBindingImpl.executeBindings():void");
    }
}
