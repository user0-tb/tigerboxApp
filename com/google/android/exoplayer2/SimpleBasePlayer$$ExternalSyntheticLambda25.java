package com.google.android.exoplayer2;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda25 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State f$0;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda25(SimpleBasePlayer.State state) {
        this.f$0 = state;
    }

    public final Object get() {
        return this.f$0.buildUpon().setDeviceVolume(Math.max(0, this.f$0.deviceVolume - 1)).build();
    }
}
