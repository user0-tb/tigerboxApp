package media.tiger.tigerbox.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;
import media.tiger.tigerbox.p016ui.main.mediaplayer.OnMediaCoverImageClickListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;

public class MediaPlayerCoverBindingImpl extends MediaPlayerCoverBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public MediaPlayerCoverBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 3, sIncludes, sViewsWithIds));
    }

    private MediaPlayerCoverBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[1], objArr[2]);
        this.mDirtyFlags = -1;
        this.productConstraintLayout.setTag((Object) null);
        this.productImage.setTag((Object) null);
        this.productTitle.setTag((Object) null);
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

    public boolean setVariable(int i, Object obj) {
        if (5 == i) {
            setAudioProduct((AudioProductInfo) obj);
        } else if (4 != i) {
            return false;
        } else {
            setAudioCoverClickListener((OnMediaCoverImageClickListener) obj);
        }
        return true;
    }

    public void setAudioProduct(AudioProductInfo audioProductInfo) {
        this.mAudioProduct = audioProductInfo;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    public void setAudioCoverClickListener(OnMediaCoverImageClickListener onMediaCoverImageClickListener) {
        this.mAudioCoverClickListener = onMediaCoverImageClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        AudioProductInfo audioProductInfo = this.mAudioProduct;
        OnMediaCoverImageClickListener onMediaCoverImageClickListener = this.mAudioCoverClickListener;
        String str2 = null;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i == 0 || (j & 5) == 0 || audioProductInfo == null) {
            str = null;
        } else {
            String title = audioProductInfo.getTitle();
            str2 = audioProductInfo.getCoverPath();
            str = title;
        }
        if (i != 0) {
            BindingAdaptersKt.bindMediaCoverImageClickListener(this.productConstraintLayout, audioProductInfo, onMediaCoverImageClickListener);
        }
        if ((j & 5) != 0) {
            BindingAdaptersKt.bindImageFromUrl(this.productImage, str2);
            TextViewBindingAdapter.setText(this.productTitle, str);
        }
    }
}
