package com.google.android.exoplayer2;

import android.view.SurfaceHolder;
import com.google.android.exoplayer2.SimpleBasePlayer;
import com.google.common.base.Supplier;

public final /* synthetic */ class SimpleBasePlayer$$ExternalSyntheticLambda36 implements Supplier {
    public final /* synthetic */ SimpleBasePlayer.State f$0;
    public final /* synthetic */ SurfaceHolder f$1;

    public /* synthetic */ SimpleBasePlayer$$ExternalSyntheticLambda36(SimpleBasePlayer.State state, SurfaceHolder surfaceHolder) {
        this.f$0 = state;
        this.f$1 = surfaceHolder;
    }

    public final Object get() {
        return this.f$0.buildUpon().setSurfaceSize(SimpleBasePlayer.getSurfaceHolderSize(this.f$1)).build();
    }
}
