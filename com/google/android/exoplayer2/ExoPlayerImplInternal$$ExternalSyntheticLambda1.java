package com.google.android.exoplayer2;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class ExoPlayerImplInternal$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ AtomicBoolean f$0;

    public /* synthetic */ ExoPlayerImplInternal$$ExternalSyntheticLambda1(AtomicBoolean atomicBoolean) {
        this.f$0 = atomicBoolean;
    }

    public final Object get() {
        return Boolean.valueOf(this.f$0.get());
    }
}
