package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import com.google.android.exoplayer2.util.ConditionVariable;

public final /* synthetic */ class DefaultAudioSink$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AudioTrack f$0;
    public final /* synthetic */ ConditionVariable f$1;

    public /* synthetic */ DefaultAudioSink$$ExternalSyntheticLambda0(AudioTrack audioTrack, ConditionVariable conditionVariable) {
        this.f$0 = audioTrack;
        this.f$1 = conditionVariable;
    }

    public final void run() {
        DefaultAudioSink.lambda$releaseAudioTrackAsync$0(this.f$0, this.f$1);
    }
}
