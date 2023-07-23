package media.tiger.tigerbox.services.implementations.validators;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.implementations.DisplayService;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/validators/ShouldEngageDeepSleep;", "", "()V", "invoke", "", "displayState", "Lmedia/tiger/tigerbox/services/implementations/DisplayService$DisplayState;", "isBatteryCharging", "audioPlaying", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ShouldEngageDeepSleep.kt */
public final class ShouldEngageDeepSleep {
    public static final ShouldEngageDeepSleep INSTANCE = new ShouldEngageDeepSleep();

    private ShouldEngageDeepSleep() {
    }

    public final boolean invoke(DisplayService.DisplayState displayState, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(displayState, "displayState");
        return displayState == DisplayService.DisplayState.TIGERBOX_DISPLAY_OFF && !z && !z2;
    }
}
