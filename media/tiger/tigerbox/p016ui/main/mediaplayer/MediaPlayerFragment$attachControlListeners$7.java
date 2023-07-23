package media.tiger.tigerbox.p016ui.main.mediaplayer;

import android.widget.SeekBar;
import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/mediaplayer/MediaPlayerFragment$attachControlListeners$7", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "", "onStartTrackingTouch", "onStopTrackingTouch", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerFragment$attachControlListeners$7 */
/* compiled from: MediaPlayerFragment.kt */
public final class MediaPlayerFragment$attachControlListeners$7 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ MediaPlayerFragment this$0;

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    MediaPlayerFragment$attachControlListeners$7(MediaPlayerFragment mediaPlayerFragment) {
        this.this$0 = mediaPlayerFragment;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.this$0.getMediaPlayerViewModel().updatePlayPosition(i);
        }
    }
}
