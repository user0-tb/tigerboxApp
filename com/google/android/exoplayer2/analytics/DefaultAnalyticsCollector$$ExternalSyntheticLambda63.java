package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda63 implements ListenerSet.IterationFinishedEvent {
    public final /* synthetic */ DefaultAnalyticsCollector f$0;
    public final /* synthetic */ Player f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda63(DefaultAnalyticsCollector defaultAnalyticsCollector, Player player) {
        this.f$0 = defaultAnalyticsCollector;
        this.f$1 = player;
    }

    public final void invoke(Object obj, FlagSet flagSet) {
        this.f$0.mo16436xd6963fe(this.f$1, (AnalyticsListener) obj, flagSet);
    }
}
