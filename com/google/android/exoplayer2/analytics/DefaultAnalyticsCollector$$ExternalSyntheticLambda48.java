package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda48 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ Exception f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda48(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f$0 = eventTime;
        this.f$1 = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDrmSessionManagerError(this.f$0, this.f$1);
    }
}
