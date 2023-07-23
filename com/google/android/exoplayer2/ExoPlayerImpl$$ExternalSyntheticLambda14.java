package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class ExoPlayerImpl$$ExternalSyntheticLambda14 implements ListenerSet.Event {
    public final /* synthetic */ TrackSelectionParameters f$0;

    public /* synthetic */ ExoPlayerImpl$$ExternalSyntheticLambda14(TrackSelectionParameters trackSelectionParameters) {
        this.f$0 = trackSelectionParameters;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTrackSelectionParametersChanged(this.f$0);
    }
}
