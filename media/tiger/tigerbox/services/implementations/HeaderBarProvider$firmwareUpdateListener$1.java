package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateListener;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/HeaderBarProvider$firmwareUpdateListener$1", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateListener;", "firmwareUpdateStateHasChanged", "", "state", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$State;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeaderBarProvider.kt */
public final class HeaderBarProvider$firmwareUpdateListener$1 implements FirmwareUpdateListener {
    final /* synthetic */ HeaderBarProvider this$0;

    HeaderBarProvider$firmwareUpdateListener$1(HeaderBarProvider headerBarProvider) {
        this.this$0 = headerBarProvider;
    }

    public void firmwareUpdateStateHasChanged(FirmwareUpdateService.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.this$0._firmwareUpdateAvailable.postValue(Boolean.valueOf(this.this$0.firmwareUpdateService.getLatestValidRelease() != null));
    }
}
