package p009j$.util;

import java.security.PrivilegedAction;

/* renamed from: j$.util.Tripwire$$ExternalSyntheticLambda0 */
public final /* synthetic */ class Tripwire$$ExternalSyntheticLambda0 implements PrivilegedAction {
    public static final /* synthetic */ Tripwire$$ExternalSyntheticLambda0 INSTANCE = new Tripwire$$ExternalSyntheticLambda0();

    private /* synthetic */ Tripwire$$ExternalSyntheticLambda0() {
    }

    public final Object run() {
        boolean z = Tripwire.ENABLED;
        return Boolean.valueOf(Boolean.getBoolean("org.openjdk.java.util.stream.tripwire"));
    }
}
