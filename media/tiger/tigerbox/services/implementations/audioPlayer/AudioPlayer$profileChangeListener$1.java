package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import media.tiger.tigerbox.data.repository.ProfileChangeListener;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/audioPlayer/AudioPlayer$profileChangeListener$1", "Lmedia/tiger/tigerbox/data/repository/ProfileChangeListener;", "didChangeProfile", "", "id", "", "didUpdateProfilesInfo", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlayer.kt */
public final class AudioPlayer$profileChangeListener$1 implements ProfileChangeListener {
    final /* synthetic */ AudioPlayer this$0;

    public void didUpdateProfilesInfo() {
    }

    AudioPlayer$profileChangeListener$1(AudioPlayer audioPlayer) {
        this.this$0 = audioPlayer;
    }

    public void didChangeProfile(int i) {
        this.this$0.stop();
    }
}
