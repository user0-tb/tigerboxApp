package com.google.android.exoplayer2;

import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda38 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State f$0;
    public final /* synthetic */ MediaMetadata f$1;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda38(SimpleBasePlayer.State state, MediaMetadata mediaMetadata) {
        this.f$0 = state;
        this.f$1 = mediaMetadata;
    }

    public final Object get() {
        return this.f$0.buildUpon().setPlaylistMetadata(this.f$1).build();
    }
}
