package media.tiger.tigerbox.databinding;

import android.support.p000v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.generated.callback.OnClickListener;
import media.tiger.tigerbox.model.domain.ChapterItem;
import media.tiger.tigerbox.p016ui.binding.BindingAdaptersKt;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

public class ItemChapterListBindingImpl extends ItemChapterListBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback1;
    private long mDirtyFlags;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public ItemChapterListBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ItemChapterListBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[2], objArr[0], objArr[4], objArr[1], objArr[3], objArr[5]);
        this.mDirtyFlags = -1;
        this.itemChapterListChapterNumber.setTag((Object) null);
        this.itemChapterListContainer.setTag((Object) null);
        this.itemChapterListProductCover.setTag((Object) null);
        this.itemChapterListSquare.setTag((Object) null);
        this.itemChapterListTime.setTag((Object) null);
        this.itemChapterListTitle.setTag((Object) null);
        setRootTag(view);
        this.mCallback1 = new OnClickListener(this, 1);
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
        if (13 == i) {
            setChapterItem((ChapterItem) obj);
        } else if (12 != i) {
            return false;
        } else {
            setChapterClickListener((BindingClickListener) obj);
        }
        return true;
    }

    public void setChapterItem(ChapterItem chapterItem) {
        this.mChapterItem = chapterItem;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    public void setChapterClickListener(BindingClickListener<ChapterItem> bindingClickListener) {
        this.mChapterClickListener = bindingClickListener;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(12);
        super.requestRebind();
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        long j;
        int i;
        boolean z;
        int i2;
        int i3;
        String str;
        int i4;
        String str2;
        String str3;
        boolean z2;
        int i5;
        String str4;
        long j2;
        long j3;
        long j4;
        long j5;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
        float f = 0.0f;
        ChapterItem chapterItem = this.mChapterItem;
        BindingClickListener bindingClickListener = this.mChapterClickListener;
        String str5 = null;
        int i6 = 0;
        int i7 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (chapterItem != null) {
                str5 = chapterItem.getDuration();
                str4 = chapterItem.getTitle();
                str = chapterItem.getCoverUrl();
                z2 = chapterItem.isProduct();
                z = chapterItem.isSelected();
                i5 = chapterItem.getPosition();
            } else {
                str4 = null;
                str = null;
                i5 = 0;
                z2 = false;
                z = false;
            }
            if (i7 != 0) {
                if (z2) {
                    j5 = j | 256 | 1024;
                    j4 = 16384;
                } else {
                    j5 = j | 128 | 512;
                    j4 = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                j = j5 | j4;
            }
            if ((j & 5) != 0) {
                if (z) {
                    j3 = j | 16 | 64;
                    j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                } else {
                    j3 = j | 8 | 32;
                    j2 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                }
                j = j3 | j2;
            }
            float dimension = this.itemChapterListContainer.getResources().getDimension(z2 ? C2814R.dimen.dp_0 : C2814R.dimen.dp_40);
            int i8 = z2 ? 8 : 0;
            if (!z2) {
                i6 = 8;
            }
            int colorFromResource = z ? getColorFromResource(this.itemChapterListTitle, C2814R.C2815color.main_theme_color) : getColorFromResource(this.itemChapterListTitle, C2814R.C2815color.media_controls_track_item_unselected);
            TextView textView = this.itemChapterListTime;
            int colorFromResource2 = z ? getColorFromResource(textView, C2814R.C2815color.white) : getColorFromResource(textView, C2814R.C2815color.media_controls_track_item_unselected);
            i3 = z ? getColorFromResource(this.itemChapterListChapterNumber, C2814R.C2815color.media_controls_background) : getColorFromResource(this.itemChapterListChapterNumber, C2814R.C2815color.media_controls_track_item_unselected);
            i = colorFromResource;
            str3 = str5;
            str5 = Integer.toString(i5);
            i4 = i6;
            i6 = i8;
            int i9 = colorFromResource2;
            str2 = str4;
            f = dimension;
            i2 = i9;
        } else {
            str3 = null;
            str2 = null;
            str = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z = false;
            i = 0;
        }
        if ((5 & j) != 0) {
            this.itemChapterListChapterNumber.setVisibility(i6);
            TextViewBindingAdapter.setText(this.itemChapterListChapterNumber, str5);
            this.itemChapterListChapterNumber.setTextColor(i3);
            ViewBindingAdapter.setPaddingStart(this.itemChapterListContainer, f);
            BindingAdaptersKt.bindImageFromUrl(this.itemChapterListProductCover, str);
            this.itemChapterListProductCover.setVisibility(i4);
            this.itemChapterListSquare.setSelected(z);
            this.itemChapterListTime.setVisibility(i6);
            TextViewBindingAdapter.setText(this.itemChapterListTime, str3);
            this.itemChapterListTime.setTextColor(i2);
            TextViewBindingAdapter.setText(this.itemChapterListTitle, str2);
            this.itemChapterListTitle.setTextColor(i);
        }
        if ((j & 4) != 0) {
            this.itemChapterListContainer.setOnClickListener(this.mCallback1);
        }
    }

    public final void _internalCallbackOnClick(int i, View view) {
        ChapterItem chapterItem = this.mChapterItem;
        BindingClickListener bindingClickListener = this.mChapterClickListener;
        if (bindingClickListener != null) {
            bindingClickListener.onClick(chapterItem);
        }
    }
}
