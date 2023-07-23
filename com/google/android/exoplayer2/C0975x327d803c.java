package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

/* renamed from: com.google.android.exoplayer2.MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda3 */
public final /* synthetic */ class C0975x327d803c implements Runnable {
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f$0;
    public final /* synthetic */ Pair f$1;

    public /* synthetic */ C0975x327d803c(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair) {
        this.f$0 = forwardingEventListener;
        this.f$1 = pair;
    }

    public final void run() {
        this.f$0.mo15978xa0cc7cae(this.f$1);
    }
}
