package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda43 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ TrackSelectionParameters f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda43(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        this.f$0 = eventTime;
        this.f$1 = trackSelectionParameters;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onTrackSelectionParametersChanged(this.f$0, this.f$1);
    }
}
