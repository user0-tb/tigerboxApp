package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

/* renamed from: com.google.android.exoplayer2.MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda6 */
public final /* synthetic */ class C0978x327d803f implements Runnable {
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f$0;
    public final /* synthetic */ Pair f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ C0978x327d803f(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, int i) {
        this.f$0 = forwardingEventListener;
        this.f$1 = pair;
        this.f$2 = i;
    }

    public final void run() {
        this.f$0.mo15980x73aea9a7(this.f$1, this.f$2);
    }
}
