package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.C0963C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.ForwardingTimeline;
import com.google.android.exoplayer2.util.Assertions;

public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState2) {
        super(timeline);
        boolean z = false;
        Assertions.checkState(timeline.getPeriodCount() == 1);
        Assertions.checkState(timeline.getWindowCount() == 1 ? true : z);
        this.adPlaybackState = adPlaybackState2;
    }

    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        this.timeline.getPeriod(i, period, z);
        period.set(period.f150id, period.uid, period.windowIndex, period.durationUs == C0963C.TIME_UNSET ? this.adPlaybackState.contentDurationUs : period.durationUs, period.getPositionInWindowUs(), this.adPlaybackState, period.isPlaceholder);
        return period;
    }
}
