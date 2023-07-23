package media.tiger.tigerbox.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;
import media.tiger.tigerbox.p016ui.binding.UnTypedBindingClickListener;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;

public class FragmentMiniPlayerBindingImpl extends FragmentMiniPlayerBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback40;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C2814R.C2817id.f1655miniPlayervolume_button, 3);
    }

    public FragmentMiniPlayerBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    private FragmentMiniPlayerBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[0], objArr[2], objArr[1], objArr[3]);
        this.mDirtyFlags = -1;
        this.miniPlayerContainer.setTag((Object) null);
        this.miniPlayerPlayPauseButton.setTag((Object) null);
        this.miniPlayerProductCover.setTag((Object) null);
        setRootTag(view);
        this.mCallback40 = new OnClickListener(this, 1);
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
        if (32 == i) {
            setNavigateToMediaPlayer((UnTypedBindingClickListener) obj);
        } else if (26 == i) {
            setIsPlaying((Boolean) obj);
        } else if (5 != i) {
            return false;
        } else {
            setAudioProduct((AudioProductInfo) obj);
        }
        return true;
    }

    public void setNavigateToMediaPlayer(UnTypedBindingClickListener unTypedBindingClickListener) {
        this.mNavigateToMediaPlayer = unTypedBindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(32);
        super.requestRebind();
    }

    public void setIsPlaying(Boolean bool) {
        this.mIsPlaying = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(26);
        super.requestRebind();
    }

    public void setAudioProduct(AudioProductInfo audioProductInfo) {
        this.mAudioProduct = audioProductInfo;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(5);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        Drawable drawable;
        int i;
        Context context;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        UnTypedBindingClickListener unTypedBindingClickListener = this.mNavigateToMediaPlayer;
        Boolean bool = this.mIsPlaying;
        AudioProductInfo audioProductInfo = this.mAudioProduct;
        String str = null;
        int i2 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i2 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i2 != 0) {
                j |= safeUnbox ? 32 : 16;
            }
            if (safeUnbox) {
                context = this.miniPlayerPlayPauseButton.getContext();
                i = C2814R.C2816drawable.media_player_pause;
            } else {
                context = this.miniPlayerPlayPauseButton.getContext();
                i = C2814R.C2816drawable.media_player_play;
            }
            drawable = AppCompatResources.getDrawable(context, i);
        } else {
            drawable = null;
        }
        int i3 = ((12 & j) > 0 ? 1 : ((12 & j) == 0 ? 0 : -1));
        if (!(i3 == 0 || audioProductInfo == null)) {
            str = audioProductInfo.getCoverPath();
        }
        if ((j & 10) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.miniPlayerPlayPauseButton, drawable);
        }
        if ((j & 8) != 0) {
            this.miniPlayerProductCover.setOnClickListener(this.mCallback40);
        }
        if (i3 != 0) {
            BindingAdaptersKt.bindImageFromUrl(this.miniPlayerProductCover, str);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        UnTypedBindingClickListener unTypedBindingClickListener = this.mNavigateToMediaPlayer;
        if (unTypedBindingClickListener != null) {
            unTypedBindingClickListener.onClick();
        }
    }
}
