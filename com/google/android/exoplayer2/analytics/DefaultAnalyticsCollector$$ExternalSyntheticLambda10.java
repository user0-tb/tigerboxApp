package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda10 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda10(AnalyticsListener.EventTime eventTime, int i, boolean z) {
        this.f$0 = eventTime;
        this.f$1 = i;
        this.f$2 = z;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onDeviceVolumeChanged(this.f$0, this.f$1, this.f$2);
    }
}
