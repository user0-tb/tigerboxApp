package media.tiger.tigerbox.services.implementations;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.HardwareEventPublisher;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HeadsetService;", "Lmedia/tiger/tigerbox/services/interfaces/HardwareEventPublisher;", "Lmedia/tiger/tigerbox/services/implementations/HeadsetService$HeadsetEvent;", "", "()V", "handleAction", "action", "", "intent", "Landroid/content/Intent;", "Companion", "HeadsetEvent", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeadsetService.kt */
public final class HeadsetService extends HardwareEventPublisher<HeadsetEvent, Unit> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int EXTRA_STATE_HEADSET_IN = 1;
    private static final int EXTRA_STATE_HEADSET_OUT = 0;

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HeadsetService$HeadsetEvent;", "", "(Ljava/lang/String;I)V", "HEADSET_PLUGGED_IN", "HEADSET_PLUGGED_OUT", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HeadsetService.kt */
    public enum HeadsetEvent {
        HEADSET_PLUGGED_IN,
        HEADSET_PLUGGED_OUT
    }

    public void handleAction(String str, Intent intent) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual((Object) intent.getAction(), (Object) "android.intent.action.HEADSET_PLUG")) {
            int intExtra = intent.getIntExtra("state", -1);
            if (intExtra == 0) {
                publish(HeadsetEvent.HEADSET_PLUGGED_OUT);
            } else if (intExtra == 1) {
                publish(HeadsetEvent.HEADSET_PLUGGED_IN);
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HeadsetService$Companion;", "", "()V", "EXTRA_STATE_HEADSET_IN", "", "EXTRA_STATE_HEADSET_OUT", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HeadsetService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
