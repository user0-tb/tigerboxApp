package media.tiger.tigerbox.p016ui.main.mediaplayer;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.databinding.IncludePlayerDeviceControlsBinding;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/databinding/IncludePlayerDeviceControlsBinding;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFragment$mediaPlayerDeviceControls$2 */
/* compiled from: MediaPlayerFragment.kt */
final class MediaPlayerFragment$mediaPlayerDeviceControls$2 extends Lambda implements Function0<IncludePlayerDeviceControlsBinding> {
    final /* synthetic */ MediaPlayerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaPlayerFragment$mediaPlayerDeviceControls$2(MediaPlayerFragment mediaPlayerFragment) {
        super(0);
        this.this$0 = mediaPlayerFragment;
    }

    public final IncludePlayerDeviceControlsBinding invoke() {
        return this.this$0.getBinding().mediaPlayerContent.mediaPlayerControls.mediaPlayerControlsDeviceControls;
    }
}
