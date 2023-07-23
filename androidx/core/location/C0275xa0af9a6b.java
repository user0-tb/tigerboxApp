package androidx.core.location;

import androidx.core.location.LocationManagerCompat;
import java.lang.ref.WeakReference;
import p009j$.util.function.Predicate;

/* renamed from: androidx.core.location.LocationManagerCompat$LocationListenerTransport$$ExternalSyntheticLambda6 */
public final /* synthetic */ class C0275xa0af9a6b implements Predicate {
    public static final /* synthetic */ C0275xa0af9a6b INSTANCE = new C0275xa0af9a6b();

    private /* synthetic */ C0275xa0af9a6b() {
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    /* renamed from: or */
    public /* synthetic */ Predicate mo6806or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return LocationManagerCompat.LocationListenerTransport.lambda$register$0((WeakReference) obj);
    }
}
