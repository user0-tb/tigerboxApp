package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda42 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ CueGroup f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda42(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        this.f$0 = eventTime;
        this.f$1 = cueGroup;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onCues(this.f$0, this.f$1);
    }
}
