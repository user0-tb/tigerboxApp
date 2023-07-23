package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda8 implements ListenerSet.Event {
    public static final /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda8 INSTANCE = new ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda8();

    private /* synthetic */ ExoPlayerImpl$ComponentListener$$ExternalSyntheticLambda8() {
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onRenderedFirstFrame();
    }
}
