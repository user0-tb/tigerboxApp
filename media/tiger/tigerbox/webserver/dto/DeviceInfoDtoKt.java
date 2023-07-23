package media.tiger.tigerbox.webserver.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, mo33737d2 = {"validateAndSanitize", "Lmedia/tiger/tigerbox/webserver/dto/UpdateDeviceInfoDto;", "app_tigerBoxRelease"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DeviceInfoDto.kt */
public final class DeviceInfoDtoKt {
    public static final UpdateDeviceInfoDto validateAndSanitize(UpdateDeviceInfoDto updateDeviceInfoDto) {
        Intrinsics.checkNotNullParameter(updateDeviceInfoDto, "<this>");
        boolean z = false;
        if (updateDeviceInfoDto.getSleepTimer() != null && updateDeviceInfoDto.getSleepTimer().intValue() < -1) {
            return UpdateDeviceInfoDto.copy$default(updateDeviceInfoDto, (String) null, (Integer) null, (Float) null, (Boolean) null, (LogoLight) null, (NightLight) null, 0, (Integer) null, (List) null, (Boolean) null, (Boolean) null, 1983, (Object) null);
        }
        IntRange intRange = new IntRange(1, 60);
        Integer sleepTimer = updateDeviceInfoDto.getSleepTimer();
        if (sleepTimer != null && intRange.contains(sleepTimer.intValue())) {
            z = true;
        }
        if (z) {
            return UpdateDeviceInfoDto.copy$default(updateDeviceInfoDto, (String) null, (Integer) null, (Float) null, (Boolean) null, (LogoLight) null, (NightLight) null, 60, (Integer) null, (List) null, (Boolean) null, (Boolean) null, 1983, (Object) null);
        }
        if (updateDeviceInfoDto.getSleepTimer() == null || updateDeviceInfoDto.getSleepTimer().intValue() <= 21600) {
            return updateDeviceInfoDto;
        }
        return UpdateDeviceInfoDto.copy$default(updateDeviceInfoDto, (String) null, (Integer) null, (Float) null, (Boolean) null, (LogoLight) null, (NightLight) null, Integer.valueOf(UpdateDeviceInfoDto.DEFAULT_MAX_SLEEP_TIME), (Integer) null, (List) null, (Boolean) null, (Boolean) null, 1983, (Object) null);
    }
}
