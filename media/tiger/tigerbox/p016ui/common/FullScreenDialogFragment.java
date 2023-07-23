package media.tiger.tigerbox.p016ui.common;

import android.os.Bundle;
import kotlin.Metadata;
import media.tiger.tigerbox.C2814R;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/common/FullScreenDialogFragment;", "Lmedia/tiger/tigerbox/ui/common/FullScreenNoHeaderFragment;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.common.FullScreenDialogFragment */
/* compiled from: FullScreenDialogFragment.kt */
public abstract class FullScreenDialogFragment extends FullScreenNoHeaderFragment {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, C2814R.C2823style.FullscreenDialogTheme);
    }
}
