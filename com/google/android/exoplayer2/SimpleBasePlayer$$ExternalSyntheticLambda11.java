package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda11 implements ListenerSet.Event {
    public final /* synthetic */ MediaItem f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda11(MediaItem mediaItem, int i) {
        this.f$0 = mediaItem;
        this.f$1 = i;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMediaItemTransition(this.f$0, this.f$1);
    }
}
