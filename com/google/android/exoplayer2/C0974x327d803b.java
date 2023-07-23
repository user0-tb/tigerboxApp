package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.MediaSourceList;

/* renamed from: com.google.android.exoplayer2.MediaSourceList$ForwardingEventListener$$ExternalSyntheticLambda2 */
public final /* synthetic */ class C0974x327d803b implements Runnable {
    public final /* synthetic */ MediaSourceList.ForwardingEventListener f$0;
    public final /* synthetic */ Pair f$1;
    public final /* synthetic */ Exception f$2;

    public /* synthetic */ C0974x327d803b(MediaSourceList.ForwardingEventListener forwardingEventListener, Pair pair, Exception exc) {
        this.f$0 = forwardingEventListener;
        this.f$1 = pair;
        this.f$2 = exc;
    }

    public final void run() {
        this.f$0.mo15981xd702e5b6(this.f$1, this.f$2);
    }
}
