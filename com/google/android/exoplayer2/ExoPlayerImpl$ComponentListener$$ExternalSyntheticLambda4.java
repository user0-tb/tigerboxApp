package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4 implements ListenerSet.Event {
    public final /* synthetic */ CueGroup f$0;

    public /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda4(CueGroup cueGroup) {
        this.f$0 = cueGroup;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onCues(this.f$0);
    }
}
