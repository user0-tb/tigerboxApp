package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

/* renamed from: com.google.android.exoplayer2.source.DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda4 */
public final /* synthetic */ class C1108xbfb12933 implements Supplier {
    public final /* synthetic */ Class f$0;
    public final /* synthetic */ DataSource.Factory f$1;

    public /* synthetic */ C1108xbfb12933(Class cls, DataSource.Factory factory) {
        this.f$0 = cls;
        this.f$1 = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.newInstance(this.f$0, this.f$1);
    }
}
