package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo33737d2 = {"toBit", "", "Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightEvent;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerButtonLightEvent.kt */
public final class TigerButtonLightEventKt {

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: TigerButtonLightEvent.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TigerButtonLightEvent.values().length];
            iArr[TigerButtonLightEvent.OFF.ordinal()] = 1;
            iArr[TigerButtonLightEvent.DOWNLOAD_PRODUCTS_IN_PROGRESS.ordinal()] = 2;
            iArr[TigerButtonLightEvent.DOWNLOAD_PRODUCTS_FINISHED.ordinal()] = 3;
            iArr[TigerButtonLightEvent.DOWNLOAD_PRODUCTS_INTERRUPTED_BY_WIFI.ordinal()] = 4;
            iArr[TigerButtonLightEvent.DOWNLOAD_PRODUCTS_FAIL.ordinal()] = 5;
            iArr[TigerButtonLightEvent.BATTERY_BETWEEN_5_10.ordinal()] = 6;
            iArr[TigerButtonLightEvent.BATTERY_UNDER_5.ordinal()] = 7;
            iArr[TigerButtonLightEvent.BATTERY_FULL_PLUGGED.ordinal()] = 8;
            iArr[TigerButtonLightEvent.ERROR.ordinal()] = 9;
            iArr[TigerButtonLightEvent.DOWNLOAD_UPDATE_IN_PROGRESS.ordinal()] = 10;
            iArr[TigerButtonLightEvent.DOWNLOAD_UPDATE_FINISHED.ordinal()] = 11;
            iArr[TigerButtonLightEvent.DOWNLOAD_UPDATE_FINISHED_ERROR.ordinal()] = 12;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int toBit(TigerButtonLightEvent tigerButtonLightEvent) {
        Intrinsics.checkNotNullParameter(tigerButtonLightEvent, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[tigerButtonLightEvent.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 16;
            case 6:
                return 32;
            case 7:
                return 64;
            case 8:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 1024;
            case 12:
                return 2048;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
