package media.tiger.tigerbox.p016ui.main.mediaplayer;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.ChapterItem;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/mediaplayer/ProductRowDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lmedia/tiger/tigerbox/model/domain/ChapterItem;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.ProductRowDiffCallback */
/* compiled from: ChapterListAdapter.kt */
public final class ProductRowDiffCallback extends DiffUtil.ItemCallback<ChapterItem> {
    public static final ProductRowDiffCallback INSTANCE = new ProductRowDiffCallback();

    private ProductRowDiffCallback() {
    }

    public boolean areItemsTheSame(ChapterItem chapterItem, ChapterItem chapterItem2) {
        Intrinsics.checkNotNullParameter(chapterItem, "oldItem");
        Intrinsics.checkNotNullParameter(chapterItem2, "newItem");
        return chapterItem.getId() == chapterItem2.getId();
    }

    public boolean areContentsTheSame(ChapterItem chapterItem, ChapterItem chapterItem2) {
        Intrinsics.checkNotNullParameter(chapterItem, "oldItem");
        Intrinsics.checkNotNullParameter(chapterItem2, "newItem");
        return Intrinsics.areEqual((Object) chapterItem, (Object) chapterItem2);
    }
}
