package media.tiger.tigerbox.p016ui.common;

import android.view.View;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.databinding.IncludeDialogHeaderBarBinding;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenFragment;", "()V", "getCloseButton", "Landroid/widget/ImageView;", "getHeaderBinding", "Lmedia/tiger/tigerbox/databinding/IncludeDialogHeaderBarBinding;", "onStart", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.FullScreenNoHeaderFragment */
/* compiled from: FullScreenNoHeaderFragment.kt */
public abstract class FullScreenNoHeaderFragment extends FullScreenFragment {
    public abstract ImageView getCloseButton();

    public IncludeDialogHeaderBarBinding getHeaderBinding() {
        return null;
    }

    public void onStart() {
        super.onStart();
        ImageView closeButton = getCloseButton();
        if (closeButton != null) {
            closeButton.setOnClickListener(new FullScreenNoHeaderFragment$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onStart$lambda-0  reason: not valid java name */
    public static final void m2371onStart$lambda0(FullScreenNoHeaderFragment fullScreenNoHeaderFragment, View view) {
        Intrinsics.checkNotNullParameter(fullScreenNoHeaderFragment, "this$0");
        fullScreenNoHeaderFragment.closeSafely();
    }
}
