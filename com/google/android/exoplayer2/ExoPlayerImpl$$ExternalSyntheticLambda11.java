package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda11 implements ListenerSet.Event {
    public final /* synthetic */ float f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda11(float f) {
        this.f$0 = f;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onVolumeChanged(this.f$0);
    }
}
