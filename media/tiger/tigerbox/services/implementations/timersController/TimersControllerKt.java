package media.tiger.tigerbox.services.implementations.timersController;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo33737d2 = {"isInLockedMode", "", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TimersController.kt */
public final class TimersControllerKt {
    public static final boolean isInLockedMode(LockedModeReason lockedModeReason) {
        Intrinsics.checkNotNullParameter(lockedModeReason, "<this>");
        return lockedModeReason != LockedModeReason.NONE;
    }
}
