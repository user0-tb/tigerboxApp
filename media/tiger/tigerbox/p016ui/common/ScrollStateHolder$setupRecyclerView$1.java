package media.tiger.tigerbox.p016ui.common;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.p016ui.common.ScrollStateHolder;

@Metadata(mo33736d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, mo33737d2 = {"media/tiger/tigerbox/ui/common/ScrollStateHolder$setupRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.ScrollStateHolder$setupRecyclerView$1 */
/* compiled from: ScrollStateHolder.kt */
public final class ScrollStateHolder$setupRecyclerView$1 extends RecyclerView.OnScrollListener {
    final /* synthetic */ ScrollStateHolder.ScrollStateKeyProvider $scrollKeyProvider;
    final /* synthetic */ ScrollStateHolder this$0;

    ScrollStateHolder$setupRecyclerView$1(ScrollStateHolder scrollStateHolder, ScrollStateHolder.ScrollStateKeyProvider scrollStateKeyProvider) {
        this.this$0 = scrollStateHolder;
        this.$scrollKeyProvider = scrollStateKeyProvider;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0) {
            this.this$0.saveScrollState(recyclerView, this.$scrollKeyProvider);
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        String scrollStateKey = this.$scrollKeyProvider.getScrollStateKey();
        if (scrollStateKey != null && i != 0) {
            this.this$0.scrolledKeys.add(scrollStateKey);
        }
    }
}
