package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class DefaultTrackSelector$$ExternalSyntheticLambda2 implements DefaultTrackSelector.TrackInfo.Factory {
    public final /* synthetic */ DefaultTrackSelector f$0;
    public final /* synthetic */ DefaultTrackSelector.Parameters f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ DefaultTrackSelector$$ExternalSyntheticLambda2(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector.Parameters parameters, boolean z) {
        this.f$0 = defaultTrackSelector;
        this.f$1 = parameters;
        this.f$2 = z;
    }

    public final List create(int i, TrackGroup trackGroup, int[] iArr) {
        return this.f$0.mo18940xc9e179dc(this.f$1, this.f$2, i, trackGroup, iArr);
    }
}
