package com.google.android.exoplayer2.source;

import com.google.common.base.Supplier;

/* renamed from: com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda1 */
public final /* synthetic */ class C1105xbfb12930 implements Supplier {
    public final /* synthetic */ Class f$0;

    public /* synthetic */ C1105xbfb12930(Class cls) {
        this.f$0 = cls;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.newInstance(this.f$0);
    }
}
