package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import media.tiger.tigerbox.C2814R;

public class IncludeMediaPlayerControlsBindingImpl extends IncludeMediaPlayerControlsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"include_player_track_controls", "include_player_device_controls"}, new int[]{1, 2}, new int[]{C2814R.C2819layout.include_player_track_controls, C2814R.C2819layout.include_player_device_controls});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1637mediaPlayercontrolsguideline, 3);
    }

    public IncludeMediaPlayerControlsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private IncludeMediaPlayerControlsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, objArr[2], objArr[3], objArr[1]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        setContainedBinding(this.mediaPlayerControlsDeviceControls);
        setContainedBinding(this.mediaPlayerControlsTrackControls);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8;
        }
        this.mediaPlayerControlsTrackControls.invalidateAll();
        this.mediaPlayerControlsDeviceControls.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.mediaPlayerControlsDeviceControls.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.mediaPlayerControlsTrackControls.hasPendingBindings() == false) goto L_0x0016;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean hasPendingBindings() {
        /*
            r6 = this;
            monitor-enter(r6)
            long r0 = r6.mDirtyFlags     // Catch:{ all -> 0x0021 }
            r2 = 0
            r4 = 1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x000c
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            return r4
        L_0x000c:
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            media.tiger.tigerbox.databinding.IncludePlayerTrackControlsBinding r0 = r6.mediaPlayerControlsTrackControls
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            media.tiger.tigerbox.databinding.IncludePlayerDeviceControlsBinding r0 = r6.mediaPlayerControlsDeviceControls
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x001f
            return r4
        L_0x001f:
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0021 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.IncludeMediaPlayerControlsBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i, Object obj) {
        if (37 != i) {
            return false;
        }
        setPlaying((Boolean) obj);
        return true;
    }

    public void setPlaying(Boolean bool) {
        this.mPlaying = bool;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mediaPlayerControlsTrackControls.setLifecycleOwner(lifecycleOwner);
        this.mediaPlayerControlsDeviceControls.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeMediaPlayerControlsDeviceControls((IncludePlayerDeviceControlsBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeMediaPlayerControlsTrackControls((IncludePlayerTrackControlsBinding) obj, i2);
    }

    private boolean onChangeMediaPlayerControlsDeviceControls(IncludePlayerDeviceControlsBinding includePlayerDeviceControlsBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeMediaPlayerControlsTrackControls(IncludePlayerTrackControlsBinding includePlayerTrackControlsBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        Boolean bool = this.mPlaying;
        if ((j & 12) != 0) {
            this.mediaPlayerControlsTrackControls.setPlaying(bool);
        }
        executeBindingsOn(this.mediaPlayerControlsTrackControls);
        executeBindingsOn(this.mediaPlayerControlsDeviceControls);
    }
}
