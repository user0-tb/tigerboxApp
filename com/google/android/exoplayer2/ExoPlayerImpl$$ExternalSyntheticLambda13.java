package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda13 implements ListenerSet.Event {
    public final /* synthetic */ AudioAttributes f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda13(AudioAttributes audioAttributes) {
        this.f$0 = audioAttributes;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onAudioAttributesChanged(this.f$0);
    }
}
