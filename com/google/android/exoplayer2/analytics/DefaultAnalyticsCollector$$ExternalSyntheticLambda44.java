package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda44 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda44(AnalyticsListener.EventTime eventTime) {
        this.f$0 = eventTime;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmSessionReleased(this.f$0);
    }
}
