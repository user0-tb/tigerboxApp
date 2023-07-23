package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ListenerSet;
import java.util.List;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda56 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda56(AnalyticsListener.EventTime eventTime, List list) {
        this.f$0 = eventTime;
        this.f$1 = list;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onCues(this.f$0, (List<Cue>) this.f$1);
    }
}
