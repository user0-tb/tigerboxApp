package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.common.base.Supplier;

public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda14 implements Supplier {
    public final /* synthetic */ BandwidthMeter f$0;

    public /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda14(BandwidthMeter bandwidthMeter) {
        this.f$0 = bandwidthMeter;
    }

    public final Object get() {
        return ExoPlayer.Builder.lambda$setBandwidthMeter$20(this.f$0);
    }
}
