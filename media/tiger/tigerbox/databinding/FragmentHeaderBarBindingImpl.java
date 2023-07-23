package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.model.domain.WifiItem;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;

public class FragmentHeaderBarBindingImpl extends FragmentHeaderBarBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback24;
    private final View.OnClickListener mCallback25;
    private final View.OnClickListener mCallback26;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1588headerclose_button, 6);
        sparseIntArray.put(C2814R.C2817id.f1589headercontent_title, 7);
        sparseIntArray.put(C2814R.C2817id.f1591headerlimit_timer, 8);
        sparseIntArray.put(C2814R.C2817id.f1592headerlimit_timer_text, 9);
        sparseIntArray.put(C2814R.C2817id.header_count_down_time, 10);
    }

    public FragmentHeaderBarBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private FragmentHeaderBarBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[5], objArr[6], objArr[7], objArr[10], objArr[3], objArr[8], objArr[9], objArr[4], objArr[2], objArr[1]);
        this.mDirtyFlags = -1;
        this.headerBatteryView.setTag((Object) null);
        this.headerDownloadMarker.setTag((Object) null);
        this.headerWifiCtrl.setTag((Object) null);
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        this.settingsIcon.setTag((Object) null);
        this.updateAvailableIcon.setTag((Object) null);
        setRootTag(view);
        this.mCallback25 = new OnClickListener(this, 2);
        this.mCallback26 = new OnClickListener(this, 3);
        this.mCallback24 = new OnClickListener(this, 1);
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
        if (56 == i) {
            setUpdateAvailableClickListener((UnTypedBindingClickListener) obj);
        } else if (19 == i) {
            setFirmwareUpdateAvailable((Boolean) obj);
        } else if (17 == i) {
            setDownloadsInProgress((Boolean) obj);
        } else if (44 == i) {
            setSettingsOpened((Boolean) obj);
        } else if (43 == i) {
            setSettingsClickListener((BindingClickListener) obj);
        } else if (8 == i) {
            setBatterySummary((BatterySummary) obj);
        } else if (59 != i) {
            return false;
        } else {
            setWifiItem((WifiItem) obj);
        }
        return true;
    }

    public void setUpdateAvailableClickListener(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mUpdateAvailableClickListener = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(56);
        super.requestRebind();
    }

    public void setFirmwareUpdateAvailable(Boolean bool) {
        this.mFirmwareUpdateAvailable = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(19);
        super.requestRebind();
    }

    public void setDownloadsInProgress(Boolean bool) {
        this.mDownloadsInProgress = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    public void setSettingsOpened(Boolean bool) {
        this.mSettingsOpened = bool;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(44);
        super.requestRebind();
    }

    public void setSettingsClickListener(BindingClickListener<Boolean> bindingClickListener) {
        this.mSettingsClickListener = bindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(43);
        super.requestRebind();
    }

    public void setBatterySummary(BatterySummary batterySummary) {
        this.mBatterySummary = batterySummary;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    public void setWifiItem(WifiItem wifiItem) {
        this.mWifiItem = wifiItem;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(59);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        if (r6 != false) goto L_0x0051;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.mDirtyFlags     // Catch:{ all -> 0x00ce }
            r4 = 0
            r1.mDirtyFlags = r4     // Catch:{ all -> 0x00ce }
            monitor-exit(r20)     // Catch:{ all -> 0x00ce }
            media.tiger.tigerbox.ui.binding.UnTypedBindingClickListener r0 = r1.mUpdateAvailableClickListener
            java.lang.Boolean r0 = r1.mFirmwareUpdateAvailable
            java.lang.Boolean r6 = r1.mDownloadsInProgress
            java.lang.Boolean r7 = r1.mSettingsOpened
            media.tiger.tigerbox.ui.binding.BindingClickListener r8 = r1.mSettingsClickListener
            media.tiger.tigerbox.model.domain.BatterySummary r8 = r1.mBatterySummary
            media.tiger.tigerbox.model.domain.WifiItem r9 = r1.mWifiItem
            r10 = 130(0x82, double:6.4E-322)
            long r12 = r2 & r10
            r14 = 8
            r15 = 0
            int r16 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0037
            boolean r0 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r0)
            if (r16 == 0) goto L_0x0031
            if (r0 == 0) goto L_0x002e
            r12 = 8192(0x2000, double:4.0474E-320)
            goto L_0x0030
        L_0x002e:
            r12 = 4096(0x1000, double:2.0237E-320)
        L_0x0030:
            long r2 = r2 | r12
        L_0x0031:
            if (r0 == 0) goto L_0x0034
            goto L_0x0037
        L_0x0034:
            r0 = 8
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            r12 = 132(0x84, double:6.5E-322)
            long r16 = r2 & r12
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x0051
            boolean r6 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r6)
            if (r18 == 0) goto L_0x004f
            if (r6 == 0) goto L_0x004b
            r16 = 2048(0x800, double:1.0118E-320)
            goto L_0x004d
        L_0x004b:
            r16 = 1024(0x400, double:5.06E-321)
        L_0x004d:
            long r2 = r2 | r16
        L_0x004f:
            if (r6 == 0) goto L_0x0052
        L_0x0051:
            r14 = 0
        L_0x0052:
            r16 = 136(0x88, double:6.7E-322)
            long r18 = r2 & r16
            int r6 = (r18 > r4 ? 1 : (r18 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0079
            boolean r7 = androidx.databinding.ViewDataBinding.safeUnbox((java.lang.Boolean) r7)
            if (r6 == 0) goto L_0x0069
            if (r7 == 0) goto L_0x0065
            r18 = 512(0x200, double:2.53E-321)
            goto L_0x0067
        L_0x0065:
            r18 = 256(0x100, double:1.265E-321)
        L_0x0067:
            long r2 = r2 | r18
        L_0x0069:
            android.widget.ImageView r6 = r1.settingsIcon
            if (r7 == 0) goto L_0x0071
            r7 = 2131100277(0x7f060275, float:1.781293E38)
            goto L_0x0074
        L_0x0071:
            r7 = 2131100276(0x7f060274, float:1.7812929E38)
        L_0x0074:
            int r6 = getColorFromResource(r6, r7)
            r15 = r6
        L_0x0079:
            r6 = 160(0xa0, double:7.9E-322)
            long r6 = r6 & r2
            int r18 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            r6 = 192(0xc0, double:9.5E-322)
            long r6 = r6 & r2
            int r19 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r18 == 0) goto L_0x008a
            media.tiger.tigerbox.ui.view.BatteryView r6 = r1.headerBatteryView
            media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt.bindBatteryView(r6, r8)
        L_0x008a:
            long r6 = r2 & r12
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x0095
            android.widget.ImageView r6 = r1.headerDownloadMarker
            r6.setVisibility(r14)
        L_0x0095:
            r6 = 128(0x80, double:6.32E-322)
            long r6 = r6 & r2
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00b1
            android.widget.ImageView r6 = r1.headerWifiCtrl
            android.view.View$OnClickListener r7 = r1.mCallback26
            r6.setOnClickListener(r7)
            android.widget.ImageView r6 = r1.settingsIcon
            android.view.View$OnClickListener r7 = r1.mCallback25
            r6.setOnClickListener(r7)
            android.widget.ImageView r6 = r1.updateAvailableIcon
            android.view.View$OnClickListener r7 = r1.mCallback24
            r6.setOnClickListener(r7)
        L_0x00b1:
            if (r19 == 0) goto L_0x00b8
            android.widget.ImageView r6 = r1.headerWifiCtrl
            media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt.wifiStrengthIcon(r6, r9)
        L_0x00b8:
            long r6 = r2 & r16
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00c3
            android.widget.ImageView r6 = r1.settingsIcon
            media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt.setImageTint(r6, r15)
        L_0x00c3:
            long r2 = r2 & r10
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00cd
            android.widget.ImageView r2 = r1.updateAvailableIcon
            r2.setVisibility(r0)
        L_0x00cd:
            return
        L_0x00ce:
            r0 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x00ce }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.FragmentHeaderBarBindingImpl.executeBindings():void");
    }

    public final void _internalCallbackOnClick(int i, View view) {
        boolean z = false;
        boolean z2 = true;
        if (i == 1) {
            UnTypedBindingClickListener unTypedBindingClickListener = this.mUpdateAvailableClickListener;
            if (unTypedBindingClickListener != null) {
                z = true;
            }
            if (z) {
                unTypedBindingClickListener.onClick();
            }
        } else if (i == 2) {
            BindingClickListener bindingClickListener = this.mSettingsClickListener;
            if (bindingClickListener == null) {
                z2 = false;
            }
            if (z2) {
                bindingClickListener.onClick(false);
            }
        } else if (i == 3) {
            BindingClickListener bindingClickListener2 = this.mSettingsClickListener;
            if (bindingClickListener2 != null) {
                z = true;
            }
            if (z) {
                bindingClickListener2.onClick(true);
            }
        }
    }
}
