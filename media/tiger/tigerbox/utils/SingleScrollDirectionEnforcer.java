package media.tiger.tigerbox.utils;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/utils/SingleScrollDirectionEnforcer;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "()V", "dx", "", "dy", "initialTouchX", "initialTouchY", "scrollPointerId", "scrollState", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "disallowIntercept", "onScrollStateChanged", "recyclerView", "newState", "onTouchEvent", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ViewExtensions.kt */
final class SingleScrollDirectionEnforcer extends RecyclerView.OnScrollListener implements RecyclerView.OnItemTouchListener {

    /* renamed from: dx */
    private int f657dx;

    /* renamed from: dy */
    private int f658dy;
    private int initialTouchX;
    private int initialTouchY;
    private int scrollPointerId = -1;
    private int scrollState;

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(recyclerView, "rv");
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.scrollPointerId = motionEvent.getPointerId(0);
            this.initialTouchX = (int) (motionEvent.getX() + 0.5f);
            this.initialTouchY = (int) (motionEvent.getY() + 0.5f);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.scrollPointerId);
            if (findPointerIndex >= 0 && this.scrollState != 1) {
                this.f657dx = ((int) (motionEvent.getX(findPointerIndex) + 0.5f)) - this.initialTouchX;
                this.f658dy = ((int) (motionEvent.getY(findPointerIndex) + 0.5f)) - this.initialTouchY;
            }
        } else if (actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            this.scrollPointerId = motionEvent.getPointerId(actionIndex);
            this.initialTouchX = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.initialTouchY = (int) (motionEvent.getY(actionIndex) + 0.5f);
        }
        return false;
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        RecyclerView.LayoutManager layoutManager;
        boolean canScrollHorizontally;
        boolean canScrollVertically;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int i2 = this.scrollState;
        this.scrollState = i;
        if (i2 == 0 && i == 1 && (layoutManager = recyclerView.getLayoutManager()) != null && (canScrollHorizontally = layoutManager.canScrollHorizontally()) != (canScrollVertically = layoutManager.canScrollVertically())) {
            if ((canScrollHorizontally && Math.abs(this.f658dy) > Math.abs(this.f657dx)) || (canScrollVertically && Math.abs(this.f657dx) > Math.abs(this.f658dy))) {
                recyclerView.stopScroll();
            }
        }
    }
}
