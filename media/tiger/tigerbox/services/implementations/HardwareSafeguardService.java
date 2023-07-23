package media.tiger.tigerbox.services.implementations;

import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.services.interfaces.SafeguardChangesListener;
import media.tiger.tigerbox.services.interfaces.SafeguardService;
import media.tiger.tigerbox.utils.FileUtils;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HardwareSafeguardService;", "Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;", "context", "Landroid/content/Context;", "fileUtils", "Lmedia/tiger/tigerbox/utils/FileUtils;", "(Landroid/content/Context;Lmedia/tiger/tigerbox/utils/FileUtils;)V", "blockHomeButton", "", "getBlockHomeButton", "()Z", "setBlockHomeButton", "(Z)V", "value", "hasHardwareError", "getHasHardwareError", "setHasHardwareError", "listeners", "", "Lmedia/tiger/tigerbox/services/interfaces/SafeguardChangesListener;", "alertSubscribers", "", "handleAction", "action", "", "intent", "Landroid/content/Intent;", "subscribeToSafeguardChanges", "listener", "unsubscribeFromSafeguardChanges", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareSafeguardService.kt */
public final class HardwareSafeguardService extends SafeguardService {
    private static final String BATTERY_CURRENT_PATH = "/sys/devices/20072000.i2c/i2c-0/0-001a/rk816-battery/power_supply/battery/cur";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SAFEGUARD_PATH = "system/aaa/safeguard.txt";
    private boolean blockHomeButton;
    private final Context context;
    private final FileUtils fileUtils;
    private final List<SafeguardChangesListener> listeners = new ArrayList();

    public HardwareSafeguardService(Context context2, FileUtils fileUtils2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(fileUtils2, "fileUtils");
        this.context = context2;
        this.fileUtils = fileUtils2;
    }

    public void handleAction(String str, Intent intent) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual((Object) str, (Object) SafeguardService.ACTION_SAFEGUARD_HARDWARE)) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("ACTION_SAFEGUARD_HARDWARE occurred: " + str + " intent " + intent, new Object[0]);
            if (!getHasHardwareError()) {
                setHasHardwareError(true);
            }
            alertSubscribers();
        }
    }

    public boolean getBlockHomeButton() {
        return this.blockHomeButton;
    }

    public void setBlockHomeButton(boolean z) {
        this.blockHomeButton = z;
    }

    public boolean getHasHardwareError() {
        if (!this.fileUtils.isFileExists(SAFEGUARD_PATH)) {
            return false;
        }
        boolean areEqual = Intrinsics.areEqual((Object) IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, (Object) FileUtils.INSTANCE.readToString(SAFEGUARD_PATH));
        if (areEqual) {
            FileUtils.INSTANCE.writeFile(BATTERY_CURRENT_PATH, SessionDescription.SUPPORTED_SDP_VERSION);
            setBlockHomeButton(true);
        }
        return areEqual;
    }

    public void setHasHardwareError(boolean z) {
        FileUtils.INSTANCE.writeFile(SAFEGUARD_PATH, z ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : SessionDescription.SUPPORTED_SDP_VERSION);
        if (z) {
            FileUtils.INSTANCE.writeFile(BATTERY_CURRENT_PATH, SessionDescription.SUPPORTED_SDP_VERSION);
            setBlockHomeButton(true);
        }
    }

    public void subscribeToSafeguardChanges(SafeguardChangesListener safeguardChangesListener) {
        Intrinsics.checkNotNullParameter(safeguardChangesListener, "listener");
        this.listeners.add(safeguardChangesListener);
    }

    public void unsubscribeFromSafeguardChanges(SafeguardChangesListener safeguardChangesListener) {
        Intrinsics.checkNotNullParameter(safeguardChangesListener, "listener");
        if (this.listeners.contains(safeguardChangesListener)) {
            this.listeners.remove(safeguardChangesListener);
        }
    }

    private final void alertSubscribers() {
        for (SafeguardChangesListener didReceiveSafeguardError : this.listeners) {
            didReceiveSafeguardError.didReceiveSafeguardError();
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HardwareSafeguardService$Companion;", "", "()V", "BATTERY_CURRENT_PATH", "", "SAFEGUARD_PATH", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HardwareSafeguardService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
