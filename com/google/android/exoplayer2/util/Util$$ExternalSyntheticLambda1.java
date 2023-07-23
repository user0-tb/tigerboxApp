package com.google.android.exoplayer2.util;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class Util$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ SettableFuture f$0;
    public final /* synthetic */ ListenableFuture f$1;

    public /* synthetic */ Util$$ExternalSyntheticLambda1(SettableFuture settableFuture, ListenableFuture listenableFuture) {
        this.f$0 = settableFuture;
        this.f$1 = listenableFuture;
    }

    public final void run() {
        C1229Util.lambda$transformFutureAsync$1(this.f$0, this.f$1);
    }
}
