package media.tiger.tigerbox.services.implementations;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.HardwareEventPublisher;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0002X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/DisplayService;", "Lmedia/tiger/tigerbox/services/interfaces/HardwareEventPublisher;", "Lmedia/tiger/tigerbox/services/implementations/DisplayService$DisplayState;", "", "()V", "_currentState", "currentState", "getCurrentState", "()Lmedia/tiger/tigerbox/services/implementations/DisplayService$DisplayState;", "handleAction", "action", "", "intent", "Landroid/content/Intent;", "Companion", "DisplayState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DisplayService.kt */
public final class DisplayService extends HardwareEventPublisher<DisplayState, Unit> {
    public static final String ACTION_SCREEN_DIMS = "tiger_box.intent.action.SCREEN_DIMS";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SCREEN_DIMS_STATUS = "screen_dims_status";
    private DisplayState _currentState = DisplayState.TIGERBOX_DISPLAY_ON;

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/DisplayService$DisplayState;", "", "(Ljava/lang/String;I)V", "TIGERBOX_DISPLAY_ON", "TIGERBOX_DISPLAY_OFF", "TIGERBOX_DISPLAY_DIM", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DisplayService.kt */
    public enum DisplayState {
        TIGERBOX_DISPLAY_ON,
        TIGERBOX_DISPLAY_OFF,
        TIGERBOX_DISPLAY_DIM
    }

    public final DisplayState getCurrentState() {
        return this._currentState;
    }

    public void handleAction(String str, Intent intent) {
        DisplayState displayState;
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(intent, "intent");
        int hashCode = str.hashCode();
        if (hashCode != -2128145023) {
            if (hashCode != -1754776619) {
                if (hashCode == -1454123155 && str.equals("android.intent.action.SCREEN_ON")) {
                    DisplayState displayState2 = DisplayState.TIGERBOX_DISPLAY_ON;
                    this._currentState = displayState2;
                    publish(displayState2);
                    return;
                }
            } else if (str.equals(ACTION_SCREEN_DIMS)) {
                if (intent.getBooleanExtra(SCREEN_DIMS_STATUS, false)) {
                    displayState = DisplayState.TIGERBOX_DISPLAY_DIM;
                } else {
                    displayState = DisplayState.TIGERBOX_DISPLAY_ON;
                }
                this._currentState = displayState;
                publish(displayState);
                return;
            }
        } else if (str.equals("android.intent.action.SCREEN_OFF")) {
            DisplayState displayState3 = DisplayState.TIGERBOX_DISPLAY_OFF;
            this._currentState = displayState3;
            publish(displayState3);
            return;
        }
        DisplayState displayState4 = DisplayState.TIGERBOX_DISPLAY_ON;
        this._currentState = displayState4;
        publish(displayState4);
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/DisplayService$Companion;", "", "()V", "ACTION_SCREEN_DIMS", "", "SCREEN_DIMS_STATUS", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DisplayService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
