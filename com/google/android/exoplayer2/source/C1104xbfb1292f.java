package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

/* renamed from: com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda0 */
public final /* synthetic */ class C1104xbfb1292f implements Supplier {
    public final /* synthetic */ DefaultMediaSourceFactory.DelegateFactoryLoader f$0;
    public final /* synthetic */ DataSource.Factory f$1;

    public /* synthetic */ C1104xbfb1292f(DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader, DataSource.Factory factory) {
        this.f$0 = delegateFactoryLoader;
        this.f$1 = factory;
    }

    public final Object get() {
        return this.f$0.mo17865x654ff537(this.f$1);
    }
}
