package media.tiger.tigerbox.p016ui.onboarding.step3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.model.dto.ReleaseInformation;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingViewModel;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateStep;

@Metadata(mo33736d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n*\u0002\u0011\u0016\b\u0007\u0018\u00002\u00020\u0001:\u000234B\u001f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010%\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020&H\u0002J\u0006\u0010/\u001a\u00020&J\b\u00100\u001a\u00020&H\u0002J\u0006\u00101\u001a\u00020&J\u000e\u00102\u001a\u00020&2\u0006\u0010 \u001a\u00020!R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001e¨\u00065"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel;", "Lmedia/tiger/tigerbox/ui/onboarding/OnboardingViewModel;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "firmwareUpdateService", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;", "batteryService", "Lmedia/tiger/tigerbox/services/interfaces/BatteryService;", "(Lkotlinx/coroutines/CoroutineScope;Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;Lmedia/tiger/tigerbox/services/interfaces/BatteryService;)V", "(Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;Lmedia/tiger/tigerbox/services/interfaces/BatteryService;)V", "_navigationEvent", "Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent;", "_viewState", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState;", "batteryChangesListener", "media/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$batteryChangesListener$1", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$batteryChangesListener$1;", "errorShown", "", "firmwareUpdateListener", "media/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$firmwareUpdateListener$1", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$firmwareUpdateListener$1;", "isCancellable", "()Z", "isForced", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "updateFailed", "updateSource", "Lmedia/tiger/tigerbox/ui/onboarding/step3/UpdateSource;", "updateStarted", "viewState", "getViewState", "noUpdateRequired", "", "postStepProgress", "step", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateStep;", "percent", "", "readyToInstall", "readyToUpdate", "readyToUpdateBatteryError", "reset", "showError", "startUpdate", "viewPrepared", "NavigationEvent", "ViewState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel */
/* compiled from: OnboardingUpdateViewModel.kt */
public final class OnboardingUpdateViewModel extends OnboardingViewModel {
    private final SingleLiveEvent<NavigationEvent> _navigationEvent;
    /* access modifiers changed from: private */
    public final MutableLiveData<ViewState> _viewState;
    private final OnboardingUpdateViewModel$batteryChangesListener$1 batteryChangesListener;
    /* access modifiers changed from: private */
    public final BatteryService batteryService;
    private CoroutineScope coroutineScope;
    private boolean errorShown;
    private final OnboardingUpdateViewModel$firmwareUpdateListener$1 firmwareUpdateListener;
    /* access modifiers changed from: private */
    public final FirmwareUpdateService firmwareUpdateService;
    private final LiveData<NavigationEvent> navigationEvent;
    private boolean updateFailed;
    private UpdateSource updateSource;
    private boolean updateStarted;
    private final LiveData<ViewState> viewState;

    @Inject
    public OnboardingUpdateViewModel(FirmwareUpdateService firmwareUpdateService2, BatteryService batteryService2) {
        Intrinsics.checkNotNullParameter(firmwareUpdateService2, "firmwareUpdateService");
        Intrinsics.checkNotNullParameter(batteryService2, "batteryService");
        this.firmwareUpdateService = firmwareUpdateService2;
        this.batteryService = batteryService2;
        this.coroutineScope = ViewModelKt.getViewModelScope(this);
        MutableLiveData<ViewState> mutableLiveData = new MutableLiveData<>();
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
        SingleLiveEvent<NavigationEvent> singleLiveEvent = new SingleLiveEvent<>();
        this._navigationEvent = singleLiveEvent;
        this.navigationEvent = singleLiveEvent;
        this.updateSource = UpdateSource.ONBOARDING;
        this.firmwareUpdateListener = new OnboardingUpdateViewModel$firmwareUpdateListener$1(this);
        this.batteryChangesListener = new OnboardingUpdateViewModel$batteryChangesListener$1(this);
    }

    public final LiveData<ViewState> getViewState() {
        return this.viewState;
    }

    public final LiveData<NavigationEvent> getNavigationEvent() {
        return this.navigationEvent;
    }

    public final boolean isCancellable() {
        return this.updateSource == UpdateSource.SETTINGS;
    }

    public final boolean isForced() {
        return this.firmwareUpdateService.isForced();
    }

    public final void viewPrepared(UpdateSource updateSource2) {
        Intrinsics.checkNotNullParameter(updateSource2, "updateSource");
        this.updateSource = updateSource2;
        if (this.updateFailed) {
            if (updateSource2 == UpdateSource.ONBOARDING) {
                this._navigationEvent.postValue(NavigationEvent.ShowLoginScreen.INSTANCE);
            } else if (this.errorShown) {
                this._navigationEvent.postValue(NavigationEvent.Close.INSTANCE);
            } else {
                this.errorShown = true;
                showError();
            }
        } else if (this.updateStarted) {
            this._viewState.postValue(ViewState.ShowProgress.INSTANCE);
        } else {
            this.firmwareUpdateService.registerFirmwareUpdateListener(this.firmwareUpdateListener);
            this.firmwareUpdateService.checkForUpdate(FirmwareUpdateService.CheckReason.MANUAL);
        }
    }

    public final void startUpdate() {
        ReleaseInformation.Release latestValidRelease = this.firmwareUpdateService.getLatestValidRelease();
        if (latestValidRelease != null) {
            this.updateStarted = true;
            this.firmwareUpdateService.downloadUpdate(latestValidRelease);
        }
    }

    public final void reset() {
        this.firmwareUpdateService.unregisterFirmwareUpdateListener(this.firmwareUpdateListener);
        this.errorShown = false;
        this.updateFailed = false;
        this.updateStarted = false;
    }

    /* access modifiers changed from: private */
    public final void noUpdateRequired() {
        if (this.updateSource == UpdateSource.SETTINGS) {
            this._viewState.postValue(ViewState.NoUpdate.INSTANCE);
        } else {
            this._navigationEvent.postValue(NavigationEvent.ShowLoginScreen.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void readyToUpdate() {
        this._viewState.postValue(new ViewState.AllowUpdate(isCancellable()));
    }

    /* access modifiers changed from: private */
    public final void readyToUpdateBatteryError() {
        this._viewState.postValue(new ViewState.BatteryInsufficient((int) this.batteryService.getBatteryPercent(), this.batteryService.isCharging(), isCancellable()));
        this.batteryService.subscribeToBatteryChanges(this.batteryChangesListener);
    }

    /* access modifiers changed from: private */
    public final void readyToInstall() {
        ReleaseInformation.Release latestValidRelease = this.firmwareUpdateService.getLatestValidRelease();
        if (latestValidRelease != null) {
            this.firmwareUpdateService.installUpdate(latestValidRelease);
        }
    }

    /* access modifiers changed from: private */
    public final void postStepProgress(FirmwareUpdateStep firmwareUpdateStep, int i) {
        this._viewState.postValue(new ViewState.ShowUpdateProgress(firmwareUpdateStep, i));
    }

    /* access modifiers changed from: private */
    public final void showError() {
        this.errorShown = true;
        this.updateFailed = true;
        this._navigationEvent.postValue(NavigationEvent.ShowError.INSTANCE);
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0006\t\n\u000b\f\r\u000e¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState;", "", "()V", "AllowUpdate", "BatteryInsufficient", "CheckingForUpdate", "NoUpdate", "ShowProgress", "ShowUpdateProgress", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$BatteryInsufficient;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$AllowUpdate;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$ShowUpdateProgress;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$ShowProgress;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$CheckingForUpdate;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$NoUpdate;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$ViewState */
    /* compiled from: OnboardingUpdateViewModel.kt */
    public static abstract class ViewState {
        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$BatteryInsufficient;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState;", "percent", "", "isCharging", "", "isCancellable", "(IZZ)V", "()Z", "getPercent", "()I", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$ViewState$BatteryInsufficient */
        /* compiled from: OnboardingUpdateViewModel.kt */
        public static final class BatteryInsufficient extends ViewState {
            private final boolean isCancellable;
            private final boolean isCharging;
            private final int percent;

            public BatteryInsufficient(int i, boolean z, boolean z2) {
                super((DefaultConstructorMarker) null);
                this.percent = i;
                this.isCharging = z;
                this.isCancellable = z2;
            }

            public final int getPercent() {
                return this.percent;
            }

            public final boolean isCancellable() {
                return this.isCancellable;
            }

            public final boolean isCharging() {
                return this.isCharging;
            }
        }

        private ViewState() {
        }

        @Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$AllowUpdate;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState;", "isCancellable", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$ViewState$AllowUpdate */
        /* compiled from: OnboardingUpdateViewModel.kt */
        public static final class AllowUpdate extends ViewState {
            private final boolean isCancellable;

            public static /* synthetic */ AllowUpdate copy$default(AllowUpdate allowUpdate, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = allowUpdate.isCancellable;
                }
                return allowUpdate.copy(z);
            }

            public final boolean component1() {
                return this.isCancellable;
            }

            public final AllowUpdate copy(boolean z) {
                return new AllowUpdate(z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AllowUpdate) && this.isCancellable == ((AllowUpdate) obj).isCancellable;
            }

            public int hashCode() {
                boolean z = this.isCancellable;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public String toString() {
                return "AllowUpdate(isCancellable=" + this.isCancellable + ')';
            }

            public AllowUpdate(boolean z) {
                super((DefaultConstructorMarker) null);
                this.isCancellable = z;
            }

            public final boolean isCancellable() {
                return this.isCancellable;
            }
        }

        @Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$ShowUpdateProgress;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState;", "updateStep", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateStep;", "percent", "", "(Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateStep;I)V", "getPercent", "()I", "getUpdateStep", "()Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateStep;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$ViewState$ShowUpdateProgress */
        /* compiled from: OnboardingUpdateViewModel.kt */
        public static final class ShowUpdateProgress extends ViewState {
            private final int percent;
            private final FirmwareUpdateStep updateStep;

            public static /* synthetic */ ShowUpdateProgress copy$default(ShowUpdateProgress showUpdateProgress, FirmwareUpdateStep firmwareUpdateStep, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    firmwareUpdateStep = showUpdateProgress.updateStep;
                }
                if ((i2 & 2) != 0) {
                    i = showUpdateProgress.percent;
                }
                return showUpdateProgress.copy(firmwareUpdateStep, i);
            }

            public final FirmwareUpdateStep component1() {
                return this.updateStep;
            }

            public final int component2() {
                return this.percent;
            }

            public final ShowUpdateProgress copy(FirmwareUpdateStep firmwareUpdateStep, int i) {
                Intrinsics.checkNotNullParameter(firmwareUpdateStep, "updateStep");
                return new ShowUpdateProgress(firmwareUpdateStep, i);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ShowUpdateProgress)) {
                    return false;
                }
                ShowUpdateProgress showUpdateProgress = (ShowUpdateProgress) obj;
                return this.updateStep == showUpdateProgress.updateStep && this.percent == showUpdateProgress.percent;
            }

            public int hashCode() {
                return (this.updateStep.hashCode() * 31) + this.percent;
            }

            public String toString() {
                return "ShowUpdateProgress(updateStep=" + this.updateStep + ", percent=" + this.percent + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ShowUpdateProgress(FirmwareUpdateStep firmwareUpdateStep, int i) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(firmwareUpdateStep, "updateStep");
                this.updateStep = firmwareUpdateStep;
                this.percent = i;
            }

            public final int getPercent() {
                return this.percent;
            }

            public final FirmwareUpdateStep getUpdateStep() {
                return this.updateStep;
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$ShowProgress;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$ViewState$ShowProgress */
        /* compiled from: OnboardingUpdateViewModel.kt */
        public static final class ShowProgress extends ViewState {
            public static final ShowProgress INSTANCE = new ShowProgress();

            private ShowProgress() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$CheckingForUpdate;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$ViewState$CheckingForUpdate */
        /* compiled from: OnboardingUpdateViewModel.kt */
        public static final class CheckingForUpdate extends ViewState {
            public static final CheckingForUpdate INSTANCE = new CheckingForUpdate();

            private CheckingForUpdate() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState$NoUpdate;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$ViewState;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$ViewState$NoUpdate */
        /* compiled from: OnboardingUpdateViewModel.kt */
        public static final class NoUpdate extends ViewState {
            public static final NoUpdate INSTANCE = new NoUpdate();

            private NoUpdate() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent;", "", "()V", "Close", "ShowError", "ShowLoginScreen", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent$ShowLoginScreen;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent$ShowError;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent$Close;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$NavigationEvent */
    /* compiled from: OnboardingUpdateViewModel.kt */
    public static abstract class NavigationEvent {
        public /* synthetic */ NavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent$ShowLoginScreen;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$NavigationEvent$ShowLoginScreen */
        /* compiled from: OnboardingUpdateViewModel.kt */
        public static final class ShowLoginScreen extends NavigationEvent {
            public static final ShowLoginScreen INSTANCE = new ShowLoginScreen();

            private ShowLoginScreen() {
                super((DefaultConstructorMarker) null);
            }
        }

        private NavigationEvent() {
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent$ShowError;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$NavigationEvent$ShowError */
        /* compiled from: OnboardingUpdateViewModel.kt */
        public static final class ShowError extends NavigationEvent {
            public static final ShowError INSTANCE = new ShowError();

            private ShowError() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent$Close;", "Lmedia/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$NavigationEvent$Close */
        /* compiled from: OnboardingUpdateViewModel.kt */
        public static final class Close extends NavigationEvent {
            public static final Close INSTANCE = new Close();

            private Close() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OnboardingUpdateViewModel(CoroutineScope coroutineScope2, FirmwareUpdateService firmwareUpdateService2, BatteryService batteryService2) {
        this(firmwareUpdateService2, batteryService2);
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(firmwareUpdateService2, "firmwareUpdateService");
        Intrinsics.checkNotNullParameter(batteryService2, "batteryService");
        this.coroutineScope = coroutineScope2;
    }
}
