package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda20 implements ListenerSet.Event {
    public final /* synthetic */ SimpleBasePlayer.State f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda20(SimpleBasePlayer.State state, int i) {
        this.f$0 = state;
        this.f$1 = i;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTimelineChanged(this.f$0.timeline, this.f$1);
    }
}
