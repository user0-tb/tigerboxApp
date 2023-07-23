package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;

public class IncludeMediaPlayerBindingImpl extends IncludeMediaPlayerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"media_player_cover", "include_media_player_controls"}, new int[]{4, 5}, new int[]{C2814R.C2819layout.media_player_cover, C2814R.C2819layout.include_media_player_controls});
    }

    public IncludeMediaPlayerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private IncludeMediaPlayerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, objArr[5], objArr[1], objArr[4], objArr[2], objArr[3]);
        this.mDirtyFlags = -1;
        ConstraintLayout constraintLayout = objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag((Object) null);
        setContainedBinding(this.mediaPlayerControls);
        this.mediaPlayerCurrentProgress.setTag((Object) null);
        setContainedBinding(this.mediaPlayerProduct);
        this.mediaPlayerProgressSeekBar.setTag((Object) null);
        this.mediaPlayerTimeRemaining.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64;
        }
        this.mediaPlayerProduct.invalidateAll();
        this.mediaPlayerControls.invalidateAll();
        requestRebind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r6.mediaPlayerControls.hasPendingBindings() == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        if (r6.mediaPlayerProduct.hasPendingBindings() == false) goto L_0x0016;
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
            media.tiger.tigerbox.databinding.MediaPlayerCoverBinding r0 = r6.mediaPlayerProduct
            boolean r0 = r0.hasPendingBindings()
            if (r0 == 0) goto L_0x0016
            return r4
        L_0x0016:
            media.tiger.tigerbox.databinding.IncludeMediaPlayerControlsBinding r0 = r6.mediaPlayerControls
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
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.databinding.IncludeMediaPlayerBindingImpl.hasPendingBindings():boolean");
    }

    public boolean setVariable(int i, Object obj) {
        if (54 == i) {
            setTrackProgress(((Integer) obj).intValue());
        } else if (37 == i) {
            setPlaying((Boolean) obj);
        } else if (53 == i) {
            setTrackPosition(((Long) obj).longValue());
        } else if (55 != i) {
            return false;
        } else {
            setTrackRemaining(((Long) obj).longValue());
        }
        return true;
    }

    public void setTrackProgress(int i) {
        this.mTrackProgress = i;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(54);
        super.requestRebind();
    }

    public void setPlaying(Boolean bool) {
        this.mPlaying = bool;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(37);
        super.requestRebind();
    }

    public void setTrackPosition(long j) {
        this.mTrackPosition = j;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(53);
        super.requestRebind();
    }

    public void setTrackRemaining(long j) {
        this.mTrackRemaining = j;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(55);
        super.requestRebind();
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mediaPlayerProduct.setLifecycleOwner(lifecycleOwner);
        this.mediaPlayerControls.setLifecycleOwner(lifecycleOwner);
    }

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeMediaPlayerProduct((MediaPlayerCoverBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeMediaPlayerControls((IncludeMediaPlayerControlsBinding) obj, i2);
    }

    private boolean onChangeMediaPlayerProduct(MediaPlayerCoverBinding mediaPlayerCoverBinding, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeMediaPlayerControls(IncludeMediaPlayerControlsBinding includeMediaPlayerControlsBinding, int i) {
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
        int i = this.mTrackProgress;
        Boolean bool = this.mPlaying;
        long j2 = this.mTrackPosition;
        long j3 = this.mTrackRemaining;
        int i2 = ((68 & j) > 0 ? 1 : ((68 & j) == 0 ? 0 : -1));
        int i3 = ((80 & j) > 0 ? 1 : ((80 & j) == 0 ? 0 : -1));
        int i4 = ((j & 96) > 0 ? 1 : ((j & 96) == 0 ? 0 : -1));
        if ((72 & j) != 0) {
            this.mediaPlayerControls.setPlaying(bool);
        }
        if (i3 != 0) {
            BindingAdaptersKt.displayTime(this.mediaPlayerCurrentProgress, j2);
        }
        if (i2 != 0) {
            BindingAdaptersKt.mediaPlayerSeekBarProgress(this.mediaPlayerProgressSeekBar, i);
        }
        if (i4 != 0) {
            BindingAdaptersKt.displayTime(this.mediaPlayerTimeRemaining, j3);
        }
        executeBindingsOn(this.mediaPlayerProduct);
        executeBindingsOn(this.mediaPlayerControls);
    }
}
