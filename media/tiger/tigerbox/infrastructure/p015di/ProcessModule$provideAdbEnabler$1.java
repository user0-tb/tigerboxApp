package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.AdbEnabler;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/infrastructure/di/ProcessModule$provideAdbEnabler$1", "Lmedia/tiger/tigerbox/services/interfaces/AdbEnabler;", "invoke", "", "adbState", "Lmedia/tiger/tigerbox/services/interfaces/AdbEnabler$AdbState;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule$provideAdbEnabler$1 */
/* compiled from: ProcessModule.kt */
public final class ProcessModule$provideAdbEnabler$1 implements AdbEnabler {
    final /* synthetic */ Context $context;

    ProcessModule$provideAdbEnabler$1(Context context) {
        this.$context = context;
    }

    public void invoke(AdbEnabler.AdbState adbState) {
        Intrinsics.checkNotNullParameter(adbState, "adbState");
        Settings.Global.putInt(this.$context.getContentResolver(), "adb_enabled", adbState.getCode());
    }
}
