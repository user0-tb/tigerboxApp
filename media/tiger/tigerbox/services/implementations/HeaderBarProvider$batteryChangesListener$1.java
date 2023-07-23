package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.services.interfaces.BatteryChangesListener;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/HeaderBarProvider$batteryChangesListener$1", "Lmedia/tiger/tigerbox/services/interfaces/BatteryChangesListener;", "onCablePluggedIn", "", "onStatusChanged", "batterySummary", "Lmedia/tiger/tigerbox/model/domain/BatterySummary;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeaderBarProvider.kt */
public final class HeaderBarProvider$batteryChangesListener$1 implements BatteryChangesListener {
    final /* synthetic */ HeaderBarProvider this$0;

    HeaderBarProvider$batteryChangesListener$1(HeaderBarProvider headerBarProvider) {
        this.this$0 = headerBarProvider;
    }

    public void onStatusChanged(BatterySummary batterySummary) {
        Intrinsics.checkNotNullParameter(batterySummary, "batterySummary");
        this.this$0._batterySummary.postValue(batterySummary);
    }

    public void onCablePluggedIn() {
        this.this$0.getInfoSoundService().playSound(InfoSoundService.SoundType.CABLE_PLUGGED_IN);
    }
}
