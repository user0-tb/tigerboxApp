package androidx.core.location;

import android.location.Location;
import p009j$.util.function.Consumer;

public final /* synthetic */ class LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ androidx.core.util.Consumer f$0;

    public /* synthetic */ LocationManagerCompat$Api30Impl$$ExternalSyntheticLambda0(androidx.core.util.Consumer consumer) {
        this.f$0 = consumer;
    }

    public final void accept(Object obj) {
        this.f$0.accept((Location) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
