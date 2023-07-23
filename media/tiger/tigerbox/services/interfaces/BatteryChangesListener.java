package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import media.tiger.tigerbox.model.domain.BatterySummary;

@Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/BatteryChangesListener;", "", "onCablePluggedIn", "", "onStatusChanged", "batterySummary", "Lmedia/tiger/tigerbox/model/domain/BatterySummary;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: BatteryService.kt */
public interface BatteryChangesListener {
    void onCablePluggedIn();

    void onStatusChanged(BatterySummary batterySummary);
}
