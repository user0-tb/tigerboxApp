package com.google.android.exoplayer2.trackselection;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;

public final /* synthetic */ class DefaultTrackSelector$Parameters$$ExternalSyntheticLambda0 implements Bundleable.Creator {
    public static final /* synthetic */ DefaultTrackSelector$Parameters$$ExternalSyntheticLambda0 INSTANCE = new DefaultTrackSelector$Parameters$$ExternalSyntheticLambda0();

    private /* synthetic */ DefaultTrackSelector$Parameters$$ExternalSyntheticLambda0() {
    }

    public final Bundleable fromBundle(Bundle bundle) {
        return new DefaultTrackSelector.Parameters.Builder(bundle).build();
    }
}
