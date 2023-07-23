package androidx.navigation.fragment;

import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, mo33737d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, mo33738k = 1, mo33739mv = {1, 6, 0})
/* compiled from: View.kt */
public final class AbstractListDetailFragment$onCreateView$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ SlidingPaneLayout $slidingPaneLayout$inlined;
    final /* synthetic */ AbstractListDetailFragment this$0;

    public AbstractListDetailFragment$onCreateView$$inlined$doOnLayout$1(AbstractListDetailFragment abstractListDetailFragment, SlidingPaneLayout slidingPaneLayout) {
        this.this$0 = abstractListDetailFragment;
        this.$slidingPaneLayout$inlined = slidingPaneLayout;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.removeOnLayoutChangeListener(this);
        OnBackPressedCallback access$getOnBackPressedCallback$p = this.this$0.onBackPressedCallback;
        Intrinsics.checkNotNull(access$getOnBackPressedCallback$p);
        access$getOnBackPressedCallback$p.setEnabled(this.$slidingPaneLayout$inlined.isSlideable() && this.$slidingPaneLayout$inlined.isOpen());
    }
}
