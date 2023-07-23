package p009j$.util;

import java.security.AccessController;

/* renamed from: j$.util.Tripwire */
abstract class Tripwire {
    static final boolean ENABLED = ((Boolean) AccessController.doPrivileged(Tripwire$$ExternalSyntheticLambda0.INSTANCE)).booleanValue();

    static void trip(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
