package media.tiger.tigerbox.p016ui.common;

import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder;", "", "()V", "scrollStates", "Ljava/util/HashMap;", "", "Landroid/os/Parcelable;", "Lkotlin/collections/HashMap;", "scrolledKeys", "", "clearScrollState", "", "restoreScrollState", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "scrollKeyProvider", "Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder$ScrollStateKeyProvider;", "saveScrollState", "setupRecyclerView", "ScrollStateKeyProvider", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.ScrollStateHolder */
/* compiled from: ScrollStateHolder.kt */
public final class ScrollStateHolder {
    private final HashMap<String, Parcelable> scrollStates = new HashMap<>();
    /* access modifiers changed from: private */
    public final Set<String> scrolledKeys = new LinkedHashSet();

    @Metadata(mo33736d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/ScrollStateHolder$ScrollStateKeyProvider;", "", "getScrollStateKey", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.common.ScrollStateHolder$ScrollStateKeyProvider */
    /* compiled from: ScrollStateHolder.kt */
    public interface ScrollStateKeyProvider {
        String getScrollStateKey();
    }

    public final void setupRecyclerView(RecyclerView recyclerView, ScrollStateKeyProvider scrollStateKeyProvider) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(scrollStateKeyProvider, "scrollKeyProvider");
        recyclerView.addOnScrollListener(new ScrollStateHolder$setupRecyclerView$1(this, scrollStateKeyProvider));
    }

    public final void clearScrollState() {
        this.scrollStates.clear();
        this.scrolledKeys.clear();
    }

    public final void saveScrollState(RecyclerView recyclerView, ScrollStateKeyProvider scrollStateKeyProvider) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(scrollStateKeyProvider, "scrollKeyProvider");
        String scrollStateKey = scrollStateKeyProvider.getScrollStateKey();
        if (scrollStateKey != null && this.scrolledKeys.contains(scrollStateKey) && (layoutManager = recyclerView.getLayoutManager()) != null) {
            Parcelable onSaveInstanceState = layoutManager.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                this.scrollStates.put(scrollStateKey, onSaveInstanceState);
            }
            this.scrolledKeys.remove(scrollStateKey);
        }
    }

    public final void restoreScrollState(RecyclerView recyclerView, ScrollStateKeyProvider scrollStateKeyProvider) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(scrollStateKeyProvider, "scrollKeyProvider");
        String scrollStateKey = scrollStateKeyProvider.getScrollStateKey();
        if (scrollStateKey != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            Parcelable parcelable = this.scrollStates.get(scrollStateKey);
            if (parcelable != null) {
                layoutManager.onRestoreInstanceState(parcelable);
            } else {
                layoutManager.scrollToPosition(0);
            }
            this.scrolledKeys.remove(scrollStateKey);
        }
    }
}
