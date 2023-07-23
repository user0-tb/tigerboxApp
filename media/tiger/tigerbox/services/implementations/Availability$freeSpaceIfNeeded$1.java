package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Availability.kt */
/* synthetic */ class Availability$freeSpaceIfNeeded$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    Availability$freeSpaceIfNeeded$1(Object obj) {
        super(0, obj, Availability.class, "hasAvailableSpaceForDownloads", "hasAvailableSpaceForDownloads()Z", 0);
    }

    public final Boolean invoke() {
        return Boolean.valueOf(((Availability) this.receiver).hasAvailableSpaceForDownloads());
    }
}
