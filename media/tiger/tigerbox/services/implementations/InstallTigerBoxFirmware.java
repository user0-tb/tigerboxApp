package media.tiger.tigerbox.services.implementations;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.p016ui.onboarding.step3.InstallFirmware;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/InstallTigerBoxFirmware;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/InstallFirmware;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "invoke", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: InstallTigerBoxFirmware.kt */
public final class InstallTigerBoxFirmware implements InstallFirmware {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String OTA_BROADCAST_SIGNAL = "com.android.bts84.otaupgrade";
    private final Context context;

    public InstallTigerBoxFirmware(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public void invoke() {
        this.context.sendBroadcast(new Intent(OTA_BROADCAST_SIGNAL));
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/InstallTigerBoxFirmware$Companion;", "", "()V", "OTA_BROADCAST_SIGNAL", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: InstallTigerBoxFirmware.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
