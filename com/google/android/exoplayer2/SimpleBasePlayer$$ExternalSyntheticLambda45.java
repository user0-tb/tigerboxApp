package com.google.android.exoplayer2;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda45 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda45(SimpleBasePlayer.State state, boolean z) {
        this.f$0 = state;
        this.f$1 = z;
    }

    public final Object get() {
        return this.f$0.buildUpon().setShuffleModeEnabled(this.f$1).build();
    }
}
