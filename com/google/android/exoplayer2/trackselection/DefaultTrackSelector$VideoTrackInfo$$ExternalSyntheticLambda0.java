package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.Comparator;

public final /* synthetic */ class DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda0 INSTANCE = new DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda0();

    private /* synthetic */ DefaultTrackSelector$VideoTrackInfo$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.VideoTrackInfo.compareNonQualityPreferences((DefaultTrackSelector.VideoTrackInfo) obj, (DefaultTrackSelector.VideoTrackInfo) obj2);
    }
}
