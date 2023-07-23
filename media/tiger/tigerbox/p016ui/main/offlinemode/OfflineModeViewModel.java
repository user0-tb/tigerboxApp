package media.tiger.tigerbox.p016ui.main.offlinemode;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.model.domain.ProductDomain;
import media.tiger.tigerbox.p016ui.common.BaseViewModel;
import media.tiger.tigerbox.p016ui.common.InfoDialogType;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.utils.DateUtilsKt;

@Metadata(mo33736d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0002\u001b)\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u000203J\u0006\u00105\u001a\u000203J\u0006\u00106\u001a\u000203R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010%8BX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0010\u0010(\u001a\u00020)X\u0004¢\u0006\u0004\n\u0002\u0010*R\u001a\u0010+\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0019\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150!8F¢\u0006\u0006\u001a\u0004\b1\u0010#R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u00068"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel;", "Lmedia/tiger/tigerbox/ui/common/BaseViewModel;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "displayService", "Lmedia/tiger/tigerbox/services/implementations/DisplayService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "(Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/implementations/DisplayService;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Lmedia/tiger/tigerbox/services/interfaces/WifiService;)V", "_downloadedContent", "Landroidx/lifecycle/MutableLiveData;", "", "Lmedia/tiger/tigerbox/model/domain/ProductDomain;", "_timeLimitError", "Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "Lmedia/tiger/tigerbox/ui/common/InfoDialogType;", "days21AlreadyDisplayed", "", "days27AlreadyDisplayed", "days28AlreadyDisplayed", "displayListener", "media/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel$displayListener$1", "Lmedia/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel$displayListener$1;", "downloaded", "getDownloaded", "()Ljava/util/List;", "downloadedContent", "Landroidx/lifecycle/LiveData;", "getDownloadedContent", "()Landroidx/lifecycle/LiveData;", "offlineStartTime", "Ljava/util/Date;", "getOfflineStartTime", "()Ljava/util/Date;", "profilesListener", "media/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel$profilesListener$1", "Lmedia/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel$profilesListener$1;", "shouldDisplayTimeWarningDialog", "getShouldDisplayTimeWarningDialog", "()Z", "setShouldDisplayTimeWarningDialog", "(Z)V", "timeLimitError", "getTimeLimitError", "checkOfflineTimeLimit", "", "enableWifi", "registerListeners", "unregisterListeners", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel */
/* compiled from: OfflineModeViewModel.kt */
public final class OfflineModeViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DAYS_21_IN_MILLIS = 1814400000;
    private static final long DAYS_27_IN_MILLIS = 2332800000L;
    private static final long DAYS_28_IN_MILLIS = 2419200000L;
    /* access modifiers changed from: private */
    public final MutableLiveData<List<ProductDomain>> _downloadedContent = new MutableLiveData<>();
    private final SingleLiveEvent<InfoDialogType> _timeLimitError = new SingleLiveEvent<>();
    private final TigerBoxAccountRepository accountRepository;
    /* access modifiers changed from: private */
    public final AvailabilityService availabilityService;
    private boolean days21AlreadyDisplayed;
    private boolean days27AlreadyDisplayed;
    private boolean days28AlreadyDisplayed;
    private final OfflineModeViewModel$displayListener$1 displayListener = new OfflineModeViewModel$displayListener$1(this);
    private final DisplayService displayService;
    private final OfflineModeViewModel$profilesListener$1 profilesListener = new OfflineModeViewModel$profilesListener$1(this);
    private boolean shouldDisplayTimeWarningDialog = true;
    private final StorageService storageService;
    private final TimeService timeService;
    private final WifiService wifiService;

    @Inject
    public OfflineModeViewModel(AvailabilityService availabilityService2, TigerBoxAccountRepository tigerBoxAccountRepository, StorageService storageService2, DisplayService displayService2, TimeService timeService2, WifiService wifiService2) {
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "accountRepository");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(displayService2, "displayService");
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        this.availabilityService = availabilityService2;
        this.accountRepository = tigerBoxAccountRepository;
        this.storageService = storageService2;
        this.displayService = displayService2;
        this.timeService = timeService2;
        this.wifiService = wifiService2;
    }

    public final LiveData<InfoDialogType> getTimeLimitError() {
        return this._timeLimitError;
    }

    public final List<ProductDomain> getDownloaded() {
        return this.availabilityService.downloadedProducts();
    }

    public final LiveData<List<ProductDomain>> getDownloadedContent() {
        return this._downloadedContent;
    }

    private final Date getOfflineStartTime() {
        String offlineStartTimeAndDate = this.storageService.getOfflineStartTimeAndDate();
        if (offlineStartTimeAndDate != null) {
            return DateUtilsKt.toDate$default(offlineStartTimeAndDate, (String) null, 1, (Object) null);
        }
        return null;
    }

    public final boolean getShouldDisplayTimeWarningDialog() {
        return this.shouldDisplayTimeWarningDialog;
    }

    public final void setShouldDisplayTimeWarningDialog(boolean z) {
        this.shouldDisplayTimeWarningDialog = z;
    }

    public final void registerListeners() {
        this.displayService.subscribe(this.displayListener);
        this.accountRepository.registerProfileChangeListener(this.profilesListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r0 = media.tiger.tigerbox.utils.DateUtilsKt.toDate$default(r0, (java.lang.String) null, 1, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkOfflineTimeLimit() {
        /*
            r8 = this;
            media.tiger.tigerbox.services.interfaces.TimeService r0 = r8.timeService
            java.lang.String r0 = r0.getCurrentTime()
            r1 = 0
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L_0x0017
            java.util.Date r0 = media.tiger.tigerbox.utils.DateUtilsKt.toDate$default(r0, r3, r4, r3)
            if (r0 == 0) goto L_0x0017
            long r5 = r0.getTime()
            goto L_0x0018
        L_0x0017:
            r5 = r1
        L_0x0018:
            java.util.Date r0 = r8.getOfflineStartTime()
            if (r0 == 0) goto L_0x0022
            long r1 = r0.getTime()
        L_0x0022:
            long r5 = r5 - r1
            media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent<media.tiger.tigerbox.ui.common.InfoDialogType> r0 = r8._timeLimitError
            r1 = 2419200000(0x90321000, double:1.1952436104E-314)
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x0038
            boolean r1 = r8.days28AlreadyDisplayed
            r1 = r1 ^ r4
            r8.shouldDisplayTimeWarningDialog = r1
            r8.days28AlreadyDisplayed = r4
            media.tiger.tigerbox.ui.common.InfoDialogType r3 = media.tiger.tigerbox.p016ui.common.InfoDialogType.FINAL_SYNC_WARNING
            goto L_0x005b
        L_0x0038:
            r1 = 2332800000(0x8b0bb400, double:1.1525563386E-314)
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x004b
            boolean r1 = r8.days27AlreadyDisplayed
            r1 = r1 ^ r4
            r8.shouldDisplayTimeWarningDialog = r1
            r8.days27AlreadyDisplayed = r4
            media.tiger.tigerbox.ui.common.InfoDialogType r3 = media.tiger.tigerbox.p016ui.common.InfoDialogType.SECOND_SYNC_WARNING
            goto L_0x005b
        L_0x004b:
            r1 = 1814400000(0x6c258c00, double:8.96432708E-315)
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x005b
            boolean r1 = r8.days21AlreadyDisplayed
            r1 = r1 ^ r4
            r8.shouldDisplayTimeWarningDialog = r1
            r8.days21AlreadyDisplayed = r4
            media.tiger.tigerbox.ui.common.InfoDialogType r3 = media.tiger.tigerbox.p016ui.common.InfoDialogType.FIRST_SYNC_WARNING
        L_0x005b:
            r0.setValue(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.p016ui.main.offlinemode.OfflineModeViewModel.checkOfflineTimeLimit():void");
    }

    public final void enableWifi() {
        this.wifiService.setWifiEnabled(true);
    }

    public final void unregisterListeners() {
        this.displayService.unsubscribe(this.displayListener);
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/offlinemode/OfflineModeViewModel$Companion;", "", "()V", "DAYS_21_IN_MILLIS", "", "DAYS_27_IN_MILLIS", "", "DAYS_28_IN_MILLIS", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel$Companion */
    /* compiled from: OfflineModeViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
