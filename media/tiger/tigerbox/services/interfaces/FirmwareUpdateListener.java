package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateListener;", "", "firmwareUpdateStateHasChanged", "", "state", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService$State;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: FirmwareUpdateService.kt */
public interface FirmwareUpdateListener {
    void firmwareUpdateStateHasChanged(FirmwareUpdateService.State state);
}
