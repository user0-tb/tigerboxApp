package media.tiger.tigerbox.services.implementations;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.HardwareEventPublisher;
import media.tiger.tigerbox.services.interfaces.SafeguardService;

@Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "Lmedia/tiger/tigerbox/services/interfaces/HardwareEventPublisher;", "Lmedia/tiger/tigerbox/services/implementations/ButtonService$ButtonEvent;", "", "safeguardService", "Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;", "(Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;)V", "handleAction", "action", "", "intent", "Landroid/content/Intent;", "ButtonEvent", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ButtonService.kt */
public final class ButtonService extends HardwareEventPublisher<ButtonEvent, Unit> {
    public static final String ACTION_RESET_BUTTON_LONG_DOWN = "org.huiyu.honeybot.action.RecButtonDown";
    public static final String ACTION_RESET_BUTTON_LONG_UP = "org.huiyu.honeybot.action.RecButtonUp";
    public static final String ACTION_RESET_BUTTON_PRESS = "org.huiyu.honeybot.action.ReadButton";
    public static final String ACTION_TIGERBOX_BUTTON_GO_HOME_PRESS = "tigerbox_go_home";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SafeguardService safeguardService;

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/ButtonService$ButtonEvent;", "", "(Ljava/lang/String;I)V", "TIGERBOX_BUTTON_PRESS", "RESET_BUTTON_PRESS", "RESET_BUTTON_LONG_DOWN", "RESET_BUTTON_LONG_UP", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ButtonService.kt */
    public enum ButtonEvent {
        TIGERBOX_BUTTON_PRESS,
        RESET_BUTTON_PRESS,
        RESET_BUTTON_LONG_DOWN,
        RESET_BUTTON_LONG_UP
    }

    public ButtonService(SafeguardService safeguardService2) {
        Intrinsics.checkNotNullParameter(safeguardService2, "safeguardService");
        this.safeguardService = safeguardService2;
    }

    public void handleAction(String str, Intent intent) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(intent, "intent");
        switch (str.hashCode()) {
            case -1777179282:
                if (str.equals(ACTION_RESET_BUTTON_LONG_DOWN)) {
                    publish(ButtonEvent.RESET_BUTTON_LONG_DOWN);
                    return;
                }
                return;
            case 118821479:
                if (str.equals(ACTION_RESET_BUTTON_LONG_UP)) {
                    publish(ButtonEvent.RESET_BUTTON_LONG_UP);
                    return;
                }
                return;
            case 1265490654:
                if (str.equals(ACTION_RESET_BUTTON_PRESS)) {
                    publish(ButtonEvent.RESET_BUTTON_PRESS);
                    return;
                }
                return;
            case 2074086723:
                if (str.equals(ACTION_TIGERBOX_BUTTON_GO_HOME_PRESS) && !this.safeguardService.getBlockHomeButton()) {
                    publish(ButtonEvent.TIGERBOX_BUTTON_PRESS);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/ButtonService$Companion;", "", "()V", "ACTION_RESET_BUTTON_LONG_DOWN", "", "ACTION_RESET_BUTTON_LONG_UP", "ACTION_RESET_BUTTON_PRESS", "ACTION_TIGERBOX_BUTTON_GO_HOME_PRESS", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: ButtonService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
