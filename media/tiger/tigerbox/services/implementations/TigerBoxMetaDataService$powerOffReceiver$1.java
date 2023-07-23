package media.tiger.tigerbox.services.implementations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;

@Metadata(mo33736d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/TigerBoxMetaDataService$powerOffReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxMetaDataService.kt */
public final class TigerBoxMetaDataService$powerOffReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ TigerBoxMetaDataService this$0;

    TigerBoxMetaDataService$powerOffReceiver$1(TigerBoxMetaDataService tigerBoxMetaDataService) {
        this.this$0 = tigerBoxMetaDataService;
    }

    public void onReceive(Context context, Intent intent) {
        if (Intrinsics.areEqual((Object) intent != null ? intent.getAction() : null, (Object) "android.intent.action.ACTION_SHUTDOWN")) {
            this.this$0.infoSoundService.playSound(InfoSoundService.SoundType.SWITCH_OFF);
            this.this$0.saveSystemState();
        }
    }
}
