package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda21 implements ListenerSet.Event {
    public final /* synthetic */ Tracks f$0;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda21(Tracks tracks) {
        this.f$0 = tracks;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTracksChanged(this.f$0);
    }
}
