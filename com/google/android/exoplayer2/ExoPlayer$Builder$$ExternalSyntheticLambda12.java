package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.common.base.Supplier;

public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda12 implements Supplier {
    public final /* synthetic */ TrackSelector f$0;

    public /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda12(TrackSelector trackSelector) {
        this.f$0 = trackSelector;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$setTrackSelector$18(this.f$0);
    }
}
