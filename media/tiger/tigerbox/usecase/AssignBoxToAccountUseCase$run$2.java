package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.DeviceInformation;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "it", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AssignBoxToAccountUseCase.kt */
final class AssignBoxToAccountUseCase$run$2 extends Lambda implements Function1<DeviceInformation, DeviceInformation> {
    final /* synthetic */ AssignBoxToAccountUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssignBoxToAccountUseCase$run$2(AssignBoxToAccountUseCase assignBoxToAccountUseCase) {
        super(1);
        this.this$0 = assignBoxToAccountUseCase;
    }

    public final DeviceInformation invoke(DeviceInformation deviceInformation) {
        Intrinsics.checkNotNullParameter(deviceInformation, "it");
        Integer currentProfileId = deviceInformation.getCurrentProfileId();
        if (currentProfileId != null) {
            AssignBoxToAccountUseCase assignBoxToAccountUseCase = this.this$0;
            assignBoxToAccountUseCase.tigerBoxAccountRepository.setActiveProfile(currentProfileId.intValue());
        }
        return deviceInformation;
    }
}
