package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda21 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ MediaMetadata f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda21(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        this.f$0 = eventTime;
        this.f$1 = mediaMetadata;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMediaMetadataChanged(this.f$0, this.f$1);
    }
}
