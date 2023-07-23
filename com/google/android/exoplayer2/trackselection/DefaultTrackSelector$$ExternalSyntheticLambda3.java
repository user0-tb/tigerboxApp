package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.common.base.Predicate;

public final /* synthetic */ class DefaultTrackSelector$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ DefaultTrackSelector f$0;

    public /* synthetic */ DefaultTrackSelector$$ExternalSyntheticLambda3(DefaultTrackSelector defaultTrackSelector) {
        this.f$0 = defaultTrackSelector;
    }

    public final boolean apply(Object obj) {
        return this.f$0.isAudioFormatWithinAudioChannelCountConstraints((Format) obj);
    }
}
