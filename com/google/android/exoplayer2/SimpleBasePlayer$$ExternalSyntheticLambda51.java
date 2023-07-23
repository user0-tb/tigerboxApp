package com.google.android.exoplayer2;

import java.util.concurrent.Executor;

public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda51 implements Executor {
    public final /* synthetic */ SimpleBasePlayer f$0;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda51(SimpleBasePlayer simpleBasePlayer) {
        this.f$0 = simpleBasePlayer;
    }

    public final void execute(Runnable runnable) {
        this.f$0.postOrRunOnApplicationHandler(runnable);
    }
}
