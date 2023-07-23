package media.tiger.tigerbox;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \b2\u00020\u0001:\u0001\bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/EngageDeepSleep;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "invoke", "", "turnOffNfc", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: EngageDeepSleep.kt */
public final class EngageDeepSleep {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NFC_OFF_INTENT = "tigerbox_nfc_off";
    private final Context context;

    public EngageDeepSleep(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final void invoke() {
        turnOffNfc();
    }

    private final void turnOffNfc() {
        try {
            Timber.Forest.mo50214d("Deep sleep: Turn off NFC", new Object[0]);
            this.context.sendBroadcast(new Intent(NFC_OFF_INTENT));
        } catch (Exception e) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("EngageDeepSleep: EXCEPTION " + e, new Object[0]);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/EngageDeepSleep$Companion;", "", "()V", "NFC_OFF_INTENT", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: EngageDeepSleep.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
