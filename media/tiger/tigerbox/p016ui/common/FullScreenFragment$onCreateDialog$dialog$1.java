package media.tiger.tigerbox.p016ui.common;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.p016ui.main.MainContentActivity;

@Metadata(mo33736d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, mo33737d2 = {"media/tiger/tigerbox/ui/common/FullScreenFragment$onCreateDialog$dialog$1", "Landroid/app/Dialog;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onBackPressed", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.FullScreenFragment$onCreateDialog$dialog$1 */
/* compiled from: FullScreenFragment.kt */
public final class FullScreenFragment$onCreateDialog$dialog$1 extends Dialog {
    final /* synthetic */ FullScreenFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FullScreenFragment$onCreateDialog$dialog$1(FullScreenFragment fullScreenFragment, Context context, int i) {
        super(context, i);
        this.this$0 = fullScreenFragment;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        FragmentActivity activity = this.this$0.getActivity();
        MainContentActivity mainContentActivity = activity instanceof MainContentActivity ? (MainContentActivity) activity : null;
        if (mainContentActivity != null) {
            FullScreenFragment fullScreenFragment = this.this$0;
            if (mainContentActivity.stopOnDisplayDimWithEvent(motionEvent)) {
                return true;
            }
            if (fullScreenFragment.canShowSettings()) {
                mainContentActivity.interpretSwipeForSettings(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.this$0.closeSafely();
    }
}
