package p009j$.util.stream;

import java.security.AccessController;

/* renamed from: j$.util.stream.Tripwire */
abstract class Tripwire {
    static final boolean ENABLED = ((Boolean) AccessController.doPrivileged(Tripwire$$ExternalSyntheticLambda0.INSTANCE)).booleanValue();

    static void trip(Class cls, String str) {
        throw new UnsupportedOperationException(cls + " tripwire tripped but logging not supported: " + str);
    }
}
