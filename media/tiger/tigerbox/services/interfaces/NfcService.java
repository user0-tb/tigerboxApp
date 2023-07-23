package media.tiger.tigerbox.services.interfaces;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.TigerCard;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;

@Metadata(mo33736d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002&'B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0002H&J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\u000e\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0010J\u000e\u0010%\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u0010R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\tR*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0006¨\u0006("}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/NfcService;", "Lmedia/tiger/tigerbox/services/interfaces/HardwareEventPublisher;", "Lmedia/tiger/tigerbox/model/domain/TigerCard;", "Lmedia/tiger/tigerbox/services/interfaces/NfcService$NfcReadError;", "lockedModeService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;", "(Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;)V", "_insertedCard", "get_insertedCard", "()Lmedia/tiger/tigerbox/model/domain/TigerCard;", "set_insertedCard", "(Lmedia/tiger/tigerbox/model/domain/TigerCard;)V", "insertedCardPayload", "getInsertedCardPayload", "listeners", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/services/interfaces/NfcListener;", "Lkotlin/collections/ArrayList;", "getListeners", "()Ljava/util/ArrayList;", "setListeners", "(Ljava/util/ArrayList;)V", "getLockedModeService", "()Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;", "setLockedModeService", "disableForegroundDispatch", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "enableForegroundDispatch", "loadCard", "tigerCard", "parseIntent", "intent", "Landroid/content/Intent;", "registerListener", "listener", "unregisterListener", "Companion", "NfcReadError", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NfcService.kt */
public abstract class NfcService extends HardwareEventPublisher<TigerCard, NfcReadError> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NFC_IN = "com.android.bts84.nfcin";
    public static final String NFC_OUT = "com.android.bts84.nfcout";
    public static final String OLD_NFC_OUT = "tag_away";
    private TigerCard _insertedCard;
    private ArrayList<NfcListener> listeners = new ArrayList<>();
    private LockedModeService lockedModeService;

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/NfcService$NfcReadError;", "", "(Ljava/lang/String;I)V", "FILE_NOT_FOUND", "IO", "DATA_ERROR", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NfcService.kt */
    public enum NfcReadError {
        FILE_NOT_FOUND,
        IO,
        DATA_ERROR
    }

    public void disableForegroundDispatch(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
    }

    public void enableForegroundDispatch(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
    }

    public abstract void loadCard(TigerCard tigerCard);

    public void parseIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    public NfcService(LockedModeService lockedModeService2) {
        Intrinsics.checkNotNullParameter(lockedModeService2, "lockedModeService");
        this.lockedModeService = lockedModeService2;
    }

    public final LockedModeService getLockedModeService() {
        return this.lockedModeService;
    }

    public final void setLockedModeService(LockedModeService lockedModeService2) {
        Intrinsics.checkNotNullParameter(lockedModeService2, "<set-?>");
        this.lockedModeService = lockedModeService2;
    }

    /* access modifiers changed from: protected */
    public final TigerCard get_insertedCard() {
        return this._insertedCard;
    }

    /* access modifiers changed from: protected */
    public final void set_insertedCard(TigerCard tigerCard) {
        this._insertedCard = tigerCard;
    }

    public final TigerCard getInsertedCardPayload() {
        return this._insertedCard;
    }

    /* access modifiers changed from: protected */
    public final ArrayList<NfcListener> getListeners() {
        return this.listeners;
    }

    /* access modifiers changed from: protected */
    public final void setListeners(ArrayList<NfcListener> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.listeners = arrayList;
    }

    public final void registerListener(NfcListener nfcListener) {
        Intrinsics.checkNotNullParameter(nfcListener, "listener");
        if (!this.listeners.contains(nfcListener)) {
            this.listeners.add(nfcListener);
        }
    }

    public final void unregisterListener(NfcListener nfcListener) {
        Intrinsics.checkNotNullParameter(nfcListener, "listener");
        this.listeners.remove(nfcListener);
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/NfcService$Companion;", "", "()V", "NFC_IN", "", "NFC_OUT", "OLD_NFC_OUT", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NfcService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
