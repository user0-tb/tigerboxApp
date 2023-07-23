package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import java.util.Comparator;
import java.util.List;

public final /* synthetic */ class DefaultTrackSelector$$ExternalSyntheticLambda6 implements Comparator {
    public static final /* synthetic */ DefaultTrackSelector$$ExternalSyntheticLambda6 INSTANCE = new DefaultTrackSelector$$ExternalSyntheticLambda6();

    private /* synthetic */ DefaultTrackSelector$$ExternalSyntheticLambda6() {
    }

    public final int compare(Object obj, Object obj2) {
        return DefaultTrackSelector.AudioTrackInfo.compareSelections((List) obj, (List) obj2);
    }
}
