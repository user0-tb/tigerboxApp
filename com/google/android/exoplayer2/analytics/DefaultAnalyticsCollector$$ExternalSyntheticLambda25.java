package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda25 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ PlaybackException f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda25(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.f$0 = eventTime;
        this.f$1 = playbackException;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayerErrorChanged(this.f$0, this.f$1);
    }
}
