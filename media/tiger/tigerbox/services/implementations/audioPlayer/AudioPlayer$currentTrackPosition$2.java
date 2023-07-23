package media.tiger.tigerbox.services.implementations.audioPlayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioTrackModel;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo33737d2 = {"<anonymous>", "", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AudioPlayer.kt */
final class AudioPlayer$currentTrackPosition$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AudioTrackModel $trackInfo;
    final /* synthetic */ long $value;
    final /* synthetic */ AudioPlayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AudioPlayer$currentTrackPosition$2(AudioPlayer audioPlayer, AudioTrackModel audioTrackModel, long j) {
        super(0);
        this.this$0 = audioPlayer;
        this.$trackInfo = audioTrackModel;
        this.$value = j;
    }

    public final void invoke() {
        this.this$0.getMExoPlayer().seekTo(Math.min(this.$value * ((long) 1000), this.this$0.getMExoPlayer().getDuration() > 0 ? this.this$0.getMExoPlayer().getDuration() : this.$trackInfo.getDuration() * ((long) 1000)));
    }
}
