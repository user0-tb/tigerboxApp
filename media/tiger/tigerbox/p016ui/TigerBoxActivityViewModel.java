package media.tiger.tigerbox.p016ui;

import androidx.lifecycle.LiveData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.p016ui.common.BaseViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.HardwareEventSubscriber;
import media.tiger.tigerbox.services.interfaces.SafeguardService;

@Metadata(mo33736d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0002\u0011\u001f\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020\u000bJ\u0006\u0010)\u001a\u00020\u000bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00198F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00198F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001b¨\u0006*"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/TigerBoxActivityViewModel;", "Lmedia/tiger/tigerbox/ui/common/BaseViewModel;", "displayService", "Lmedia/tiger/tigerbox/services/implementations/DisplayService;", "safeguardService", "Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "(Lmedia/tiger/tigerbox/services/implementations/DisplayService;Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;)V", "_resetButtonLongPressedEvent", "Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "", "get_resetButtonLongPressedEvent", "()Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "_safeguardHardwareErrorEvent", "_tigerButtonPressedEvent", "hardwareSafeguardErrorListener", "media/tiger/tigerbox/ui/TigerBoxActivityViewModel$hardwareSafeguardErrorListener$1", "Lmedia/tiger/tigerbox/ui/TigerBoxActivityViewModel$hardwareSafeguardErrorListener$1;", "resetButtonListener", "Lmedia/tiger/tigerbox/services/interfaces/HardwareEventSubscriber;", "Lmedia/tiger/tigerbox/services/implementations/ButtonService$ButtonEvent;", "getResetButtonListener", "()Lmedia/tiger/tigerbox/services/interfaces/HardwareEventSubscriber;", "resetButtonLongPressedEvent", "Landroidx/lifecycle/LiveData;", "getResetButtonLongPressedEvent", "()Landroidx/lifecycle/LiveData;", "safeguardHardwareErrorEvent", "getSafeguardHardwareErrorEvent", "tigerButtonListener", "media/tiger/tigerbox/ui/TigerBoxActivityViewModel$tigerButtonListener$1", "Lmedia/tiger/tigerbox/ui/TigerBoxActivityViewModel$tigerButtonListener$1;", "tigerButtonPressedEvent", "getTigerButtonPressedEvent", "checkSafeguardHardware", "isDisplayStateDim", "", "isDisplayStateOff", "isDisplayStateOn", "viewEntered", "viewExited", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.TigerBoxActivityViewModel */
/* compiled from: TigerBoxActivityViewModel.kt */
public final class TigerBoxActivityViewModel extends BaseViewModel {
    private final SingleLiveEvent<Unit> _resetButtonLongPressedEvent = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Unit> _safeguardHardwareErrorEvent = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Unit> _tigerButtonPressedEvent = new SingleLiveEvent<>();
    private final ButtonService buttonService;
    private final DisplayService displayService;
    private final TigerBoxActivityViewModel$hardwareSafeguardErrorListener$1 hardwareSafeguardErrorListener = new TigerBoxActivityViewModel$hardwareSafeguardErrorListener$1(this);
    private final HardwareEventSubscriber<ButtonService.ButtonEvent, Unit> resetButtonListener = new TigerBoxActivityViewModel$resetButtonListener$1(this);
    private final SafeguardService safeguardService;
    private final TigerBoxActivityViewModel$tigerButtonListener$1 tigerButtonListener = new TigerBoxActivityViewModel$tigerButtonListener$1(this);

    @Inject
    public TigerBoxActivityViewModel(DisplayService displayService2, SafeguardService safeguardService2, ButtonService buttonService2) {
        Intrinsics.checkNotNullParameter(displayService2, "displayService");
        Intrinsics.checkNotNullParameter(safeguardService2, "safeguardService");
        Intrinsics.checkNotNullParameter(buttonService2, "buttonService");
        this.displayService = displayService2;
        this.safeguardService = safeguardService2;
        this.buttonService = buttonService2;
    }

    public final boolean isDisplayStateOff() {
        return this.displayService.getCurrentState() == DisplayService.DisplayState.TIGERBOX_DISPLAY_OFF;
    }

    public final boolean isDisplayStateDim() {
        return this.displayService.getCurrentState() == DisplayService.DisplayState.TIGERBOX_DISPLAY_DIM;
    }

    public final boolean isDisplayStateOn() {
        return this.displayService.getCurrentState() == DisplayService.DisplayState.TIGERBOX_DISPLAY_ON;
    }

    public final LiveData<Unit> getSafeguardHardwareErrorEvent() {
        return this._safeguardHardwareErrorEvent;
    }

    public final void viewEntered() {
        this.safeguardService.subscribeToSafeguardChanges(this.hardwareSafeguardErrorListener);
        this.buttonService.subscribe(this.resetButtonListener);
        this.buttonService.subscribe(this.tigerButtonListener);
    }

    public final void viewExited() {
        this.safeguardService.unsubscribeFromSafeguardChanges(this.hardwareSafeguardErrorListener);
        this.buttonService.unsubscribe(this.resetButtonListener);
        this.buttonService.unsubscribe(this.tigerButtonListener);
    }

    public final void checkSafeguardHardware() {
        if (this.safeguardService.getHasHardwareError()) {
            this._safeguardHardwareErrorEvent.call();
        }
    }

    public final LiveData<Unit> getTigerButtonPressedEvent() {
        return this._tigerButtonPressedEvent;
    }

    /* access modifiers changed from: protected */
    public final SingleLiveEvent<Unit> get_resetButtonLongPressedEvent() {
        return this._resetButtonLongPressedEvent;
    }

    public final LiveData<Unit> getResetButtonLongPressedEvent() {
        return this._resetButtonLongPressedEvent;
    }

    public final HardwareEventSubscriber<ButtonService.ButtonEvent, Unit> getResetButtonListener() {
        return this.resetButtonListener;
    }
}
