package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda61 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda61(AnalyticsListener.EventTime eventTime, boolean z, int i) {
        this.f$0 = eventTime;
        this.f$1 = z;
        this.f$2 = i;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onPlayWhenReadyChanged(this.f$0, this.f$1, this.f$2);
    }
}
