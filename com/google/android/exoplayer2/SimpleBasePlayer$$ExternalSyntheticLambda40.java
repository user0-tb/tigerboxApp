package com.google.android.exoplayer2;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.common.base.Supplier;

public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda40 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State f$0;
    public final /* synthetic */ TrackSelectionParameters f$1;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda40(SimpleBasePlayer.State state, TrackSelectionParameters trackSelectionParameters) {
        this.f$0 = state;
        this.f$1 = trackSelectionParameters;
    }

    public final Object get() {
        return this.f$0.buildUpon().setTrackSelectionParameters(this.f$1).build();
    }
}
