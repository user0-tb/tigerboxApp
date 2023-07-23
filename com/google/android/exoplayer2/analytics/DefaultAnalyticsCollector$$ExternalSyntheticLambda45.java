package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.video.VideoSize;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda45 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ VideoSize f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda45(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.f$0 = eventTime;
        this.f$1 = videoSize;
    }

    public final void invoke(Object obj) {
        DefaultAnalyticsCollector.lambda$onVideoSizeChanged$57(this.f$0, this.f$1, (AnalyticsListener) obj);
    }
}
