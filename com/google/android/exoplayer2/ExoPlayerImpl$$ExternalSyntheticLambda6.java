package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda6 implements ListenerSet.Event {
    public final /* synthetic */ PlaybackInfo f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda6(PlaybackInfo playbackInfo) {
        this.f$0 = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackStateChanged(this.f$0.playbackState);
    }
}
