package media.tiger.tigerbox.utils;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo33737d2 = {"Lmedia/tiger/tigerbox/utils/SwipeInterpreter;", "Landroid/view/View$OnTouchListener;", "onSwipeDown", "Lkotlin/Function0;", "", "onSwipeUp", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "mode", "", "startY", "", "stopY", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SwipeInterpreter.kt */
public final class SwipeInterpreter implements View.OnTouchListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int NONE = 0;
    private static final int SWIPE = 1;
    private static final int THRESHOLD = 100;
    private int mode;
    private final Function0<Unit> onSwipeDown;
    private final Function0<Unit> onSwipeUp;
    private float startY;
    private float stopY;

    public SwipeInterpreter(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onSwipeDown");
        this.onSwipeDown = function0;
        this.onSwipeUp = function02;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SwipeInterpreter(Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : function02);
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/utils/SwipeInterpreter$Companion;", "", "()V", "NONE", "", "SWIPE", "THRESHOLD", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: SwipeInterpreter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        int action = motionEvent.getAction() & 255;
        if (action != 2) {
            if (action == 5) {
                this.mode = 1;
                this.startY = motionEvent.getY(0);
            } else if (action == 6) {
                this.mode = 0;
                if (Math.abs(this.startY - this.stopY) > 100.0f) {
                    if (this.startY > this.stopY) {
                        Function0<Unit> function0 = this.onSwipeUp;
                        if (function0 != null) {
                            function0.invoke();
                        }
                    } else {
                        this.onSwipeDown.invoke();
                    }
                }
                this.mode = 0;
            }
        } else if (this.mode == 1) {
            this.stopY = motionEvent.getY(0);
        }
        view.performClick();
        return true;
    }
}
