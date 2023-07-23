package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.common.base.Supplier;

public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda20 implements Supplier {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda20(Context context) {
        this.f$0 = context;
    }

    public final Object get() {
        return DefaultBandwidthMeter.getSingletonInstance(this.f$0);
    }
}
