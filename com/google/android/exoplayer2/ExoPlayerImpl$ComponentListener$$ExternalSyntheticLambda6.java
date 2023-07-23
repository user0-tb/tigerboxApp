package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ListenerSet;
import java.util.List;

public final /* synthetic */ class ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda6 implements ListenerSet.Event {
    public final /* synthetic */ List f$0;

    public /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda6(List list) {
        this.f$0 = list;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onCues((List<Cue>) this.f$0);
    }
}
