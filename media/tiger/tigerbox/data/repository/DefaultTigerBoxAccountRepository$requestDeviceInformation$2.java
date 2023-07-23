package media.tiger.tigerbox.data.repository;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.DeviceInformation;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "it", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserRepository.kt */
final class DefaultTigerBoxAccountRepository$requestDeviceInformation$2 extends Lambda implements Function1<DeviceInformation, DeviceInformation> {
    public static final DefaultTigerBoxAccountRepository$requestDeviceInformation$2 INSTANCE = new DefaultTigerBoxAccountRepository$requestDeviceInformation$2();

    DefaultTigerBoxAccountRepository$requestDeviceInformation$2() {
        super(1);
    }

    public final DeviceInformation invoke(DeviceInformation deviceInformation) {
        Intrinsics.checkNotNullParameter(deviceInformation, "it");
        return deviceInformation;
    }
}
