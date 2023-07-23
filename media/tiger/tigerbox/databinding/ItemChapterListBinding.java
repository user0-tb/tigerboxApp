package media.tiger.tigerbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.model.domain.ChapterItem;
import media.tiger.tigerbox.p016ui.binding.BindingClickListener;

public abstract class ItemChapterListBinding extends ViewDataBinding {
    public final TextView itemChapterListChapterNumber;
    public final ConstraintLayout itemChapterListContainer;
    public final ImageView itemChapterListProductCover;
    public final LinearLayout itemChapterListSquare;
    public final TextView itemChapterListTime;
    public final TextView itemChapterListTitle;
    @Bindable
    protected BindingClickListener<ChapterItem> mChapterClickListener;
    @Bindable
    protected ChapterItem mChapterItem;

    public abstract void setChapterClickListener(BindingClickListener<ChapterItem> bindingClickListener);

    public abstract void setChapterItem(ChapterItem chapterItem);

    protected ItemChapterListBinding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.itemChapterListChapterNumber = textView;
        this.itemChapterListContainer = constraintLayout;
        this.itemChapterListProductCover = imageView;
        this.itemChapterListSquare = linearLayout;
        this.itemChapterListTime = textView2;
        this.itemChapterListTitle = textView3;
    }

    public BindingClickListener<ChapterItem> getChapterClickListener() {
        return this.mChapterClickListener;
    }

    public ChapterItem getChapterItem() {
        return this.mChapterItem;
    }

    public static ItemChapterListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChapterListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemChapterListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_chapter_list, viewGroup, z, obj);
    }

    public static ItemChapterListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChapterListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemChapterListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2814R.C2819layout.item_chapter_list, (ViewGroup) null, false, obj);
    }

    public static ItemChapterListBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemChapterListBinding bind(View view, Object obj) {
        return (ItemChapterListBinding) bind(obj, view, C2814R.C2819layout.item_chapter_list);
    }
}
