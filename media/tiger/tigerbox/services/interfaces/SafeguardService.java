package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&R\u0018\u0010\u0005\u001a\u00020\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u00020\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;", "Lmedia/tiger/tigerbox/services/interfaces/HardwareEventPublisher;", "Lmedia/tiger/tigerbox/services/interfaces/SafeguardService$SafeguardEvent;", "", "()V", "blockHomeButton", "", "getBlockHomeButton", "()Z", "setBlockHomeButton", "(Z)V", "hasHardwareError", "getHasHardwareError", "setHasHardwareError", "subscribeToSafeguardChanges", "listener", "Lmedia/tiger/tigerbox/services/interfaces/SafeguardChangesListener;", "unsubscribeFromSafeguardChanges", "Companion", "SafeguardEvent", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: SafeguardService.kt */
public abstract class SafeguardService extends HardwareEventPublisher<SafeguardEvent, Unit> {
    public static final String ACTION_SAFEGUARD_HARDWARE = "com.android.bts84.Abnormal_current";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/SafeguardService$SafeguardEvent;", "", "(Ljava/lang/String;I)V", "SAFEGUARD_ABNORMAL_CURRENT", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: SafeguardService.kt */
    public enum SafeguardEvent {
        SAFEGUARD_ABNORMAL_CURRENT
    }

    public abstract boolean getBlockHomeButton();

    public abstract boolean getHasHardwareError();

    public abstract void setBlockHomeButton(boolean z);

    public abstract void setHasHardwareError(boolean z);

    public abstract void subscribeToSafeguardChanges(SafeguardChangesListener safeguardChangesListener);

    public abstract void unsubscribeFromSafeguardChanges(SafeguardChangesListener safeguardChangesListener);

    @Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/SafeguardService$Companion;", "", "()V", "ACTION_SAFEGUARD_HARDWARE", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: SafeguardService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
