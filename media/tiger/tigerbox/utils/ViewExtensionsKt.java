package media.tiger.tigerbox.utils;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo33737d2 = {"enforceSingleScrollDirection", "", "Landroidx/recyclerview/widget/RecyclerView;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ViewExtensions.kt */
public final class ViewExtensionsKt {
    public static final void enforceSingleScrollDirection(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        SingleScrollDirectionEnforcer singleScrollDirectionEnforcer = new SingleScrollDirectionEnforcer();
        recyclerView.addOnItemTouchListener(singleScrollDirectionEnforcer);
        recyclerView.addOnScrollListener(singleScrollDirectionEnforcer);
    }
}
