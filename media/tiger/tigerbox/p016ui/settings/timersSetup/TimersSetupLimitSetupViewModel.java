package media.tiger.tigerbox.p016ui.settings.timersSetup;

import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.infrastructure.Constants;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.implementations.timersController.TimeLimit;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

@Metadata(mo33736d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 32\u00020\u0001:\u000234B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u0018J\u0006\u0010-\u001a\u00020\u0018J\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0018R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8FX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u0014R\u0013\u0010%\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupViewModel;", "Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "timersControllerService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "timeLimitTimer", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitTimerService;", "shutDownTimerService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitTimerService;Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "activeSleepSeconds", "", "getActiveSleepSeconds", "()I", "setActiveSleepSeconds", "(I)V", "isSleepTimer", "", "()Z", "setSleepTimer", "(Z)V", "itemsList", "", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersTimeLimitItem;", "getItemsList", "()Ljava/util/List;", "itemsList$delegate", "Lkotlin/Lazy;", "limitSeconds", "getLimitSeconds", "selectedItem", "getSelectedItem", "()Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersTimeLimitItem;", "sleepTimeSeconds", "getSleepTimeSeconds", "customTime", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupViewModel$customHHMM;", "hasTimeLimit", "isCustomTime", "onSubmitClicked", "", "item", "customSeconds", "reset", "Companion", "customHHMM", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel */
/* compiled from: TimersSetupLimitSetupViewModel.kt */
public final class TimersSetupLimitSetupViewModel extends FullScreenViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SEC_10M = 600;
    public static final int SEC_15M = 900;
    public static final int SEC_1H = 3600;
    public static final int SEC_1H_30M = 5400;
    public static final int SEC_20M = 1200;
    public static final int SEC_2H = 7200;
    public static final int SEC_2H_30M = 9000;
    public static final int SEC_30M = 1800;
    public static final int SEC_40M = 2400;
    public static final int SEC_50M = 3000;
    public static final int SEC_5M = 300;
    private int activeSleepSeconds;
    private boolean isSleepTimer;
    private final Lazy itemsList$delegate = LazyKt.lazy(new TimersSetupLimitSetupViewModel$itemsList$2(this));
    private final ShutDownTimerService shutDownTimerService;
    private final StorageService storageService;
    private final TimeLimitTimerService timeLimitTimer;
    private final TimeService timeService;
    private final TimersControllerService timersControllerService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public TimersSetupLimitSetupViewModel(StorageService storageService2, TimeService timeService2, TimersControllerService timersControllerService2, TimeLimitTimerService timeLimitTimerService, ShutDownTimerService shutDownTimerService2, ButtonService buttonService, HeaderProvider headerProvider) {
        super(buttonService, headerProvider);
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        Intrinsics.checkNotNullParameter(timersControllerService2, "timersControllerService");
        Intrinsics.checkNotNullParameter(timeLimitTimerService, "timeLimitTimer");
        Intrinsics.checkNotNullParameter(shutDownTimerService2, "shutDownTimerService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(headerProvider, "headerProvider");
        this.storageService = storageService2;
        this.timeService = timeService2;
        this.timersControllerService = timersControllerService2;
        this.timeLimitTimer = timeLimitTimerService;
        this.shutDownTimerService = shutDownTimerService2;
    }

    public final boolean isSleepTimer() {
        return this.isSleepTimer;
    }

    public final void setSleepTimer(boolean z) {
        this.isSleepTimer = z;
    }

    public final int getActiveSleepSeconds() {
        return this.activeSleepSeconds;
    }

    public final void setActiveSleepSeconds(int i) {
        this.activeSleepSeconds = i;
    }

    /* access modifiers changed from: private */
    public final int getSleepTimeSeconds() {
        return this.shutDownTimerService.getInitialShutDownTimeSeconds();
    }

    /* access modifiers changed from: private */
    public final int getLimitSeconds() {
        return this.storageService.getTimeLimit().getInitialLimitSeconds();
    }

    public final boolean hasTimeLimit() {
        return this.storageService.getTimeLimit().hasSetLimit();
    }

    public final TimersTimeLimitItem getSelectedItem() {
        for (TimersTimeLimitItem next : getItemsList()) {
            if (next.getSelected()) {
                return next;
            }
        }
        return null;
    }

    public final List<TimersTimeLimitItem> getItemsList() {
        return (List) this.itemsList$delegate.getValue();
    }

    public final boolean isCustomTime() {
        boolean z = this.isSleepTimer;
        Integer valueOf = Integer.valueOf(SEC_1H);
        Integer valueOf2 = Integer.valueOf(SEC_30M);
        if (z) {
            if (!CollectionsKt.mutableListOf(0, -1, 300, 600, 900, Integer.valueOf(SEC_20M), valueOf2, Integer.valueOf(SEC_40M), 3000, valueOf).contains(Integer.valueOf(getSleepTimeSeconds()))) {
                return true;
            }
        } else {
            if (!CollectionsKt.mutableListOf(-1, valueOf2, valueOf, Integer.valueOf(SEC_1H_30M), Integer.valueOf(SEC_2H), Integer.valueOf(SEC_2H_30M)).contains(Integer.valueOf(getLimitSeconds()))) {
                return true;
            }
        }
        return false;
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupViewModel$customHHMM;", "", "hour", "", "minute", "(II)V", "getHour", "()I", "getMinute", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel$customHHMM */
    /* compiled from: TimersSetupLimitSetupViewModel.kt */
    public static final class customHHMM {
        private final int hour;
        private final int minute;

        public static /* synthetic */ customHHMM copy$default(customHHMM customhhmm, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = customhhmm.hour;
            }
            if ((i3 & 2) != 0) {
                i2 = customhhmm.minute;
            }
            return customhhmm.copy(i, i2);
        }

        public final int component1() {
            return this.hour;
        }

        public final int component2() {
            return this.minute;
        }

        public final customHHMM copy(int i, int i2) {
            return new customHHMM(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof customHHMM)) {
                return false;
            }
            customHHMM customhhmm = (customHHMM) obj;
            return this.hour == customhhmm.hour && this.minute == customhhmm.minute;
        }

        public int hashCode() {
            return (this.hour * 31) + this.minute;
        }

        public String toString() {
            return "customHHMM(hour=" + this.hour + ", minute=" + this.minute + ')';
        }

        public customHHMM(int i, int i2) {
            this.hour = i;
            this.minute = i2;
        }

        public final int getHour() {
            return this.hour;
        }

        public final int getMinute() {
            return this.minute;
        }
    }

    public final customHHMM customTime() {
        if (this.isSleepTimer) {
            return new customHHMM(((getSleepTimeSeconds() / 60) / 60) % 24, (getSleepTimeSeconds() / 60) % 60);
        }
        return new customHHMM(((getLimitSeconds() / 60) / 60) % 24, (getLimitSeconds() / 60) % 60);
    }

    public final void onSubmitClicked(TimersTimeLimitItem timersTimeLimitItem, int i, boolean z) {
        Intrinsics.checkNotNullParameter(timersTimeLimitItem, "item");
        if (this.isSleepTimer) {
            int title = timersTimeLimitItem.getTitle();
            if (title == C2814R.string.settings_timers_limit_custom) {
                this.shutDownTimerService.startTimer(i);
            } else if (title != C2814R.string.settings_timers_turn_off) {
                switch (title) {
                    case C2814R.string.settings_timers_sleep_10_minutes:
                        this.shutDownTimerService.startTimer(600);
                        return;
                    case C2814R.string.settings_timers_sleep_15_minutes:
                        this.shutDownTimerService.startTimer(900);
                        return;
                    case C2814R.string.settings_timers_sleep_1_hour:
                        this.shutDownTimerService.startTimer(SEC_1H);
                        return;
                    case C2814R.string.settings_timers_sleep_20_minutes:
                        this.shutDownTimerService.startTimer(SEC_20M);
                        return;
                    case C2814R.string.settings_timers_sleep_30_minutes:
                        this.shutDownTimerService.startTimer(SEC_30M);
                        return;
                    case C2814R.string.settings_timers_sleep_40_minutes:
                        this.shutDownTimerService.startTimer(SEC_40M);
                        return;
                    case C2814R.string.settings_timers_sleep_50_minutes:
                        this.shutDownTimerService.startTimer(3000);
                        return;
                    case C2814R.string.settings_timers_sleep_5_minutes:
                        this.shutDownTimerService.startTimer(300);
                        return;
                    case C2814R.string.settings_timers_sleep_end_of_product:
                        this.shutDownTimerService.shutDownAtTheEndOfPlayback();
                        return;
                    default:
                        return;
                }
            } else {
                this.shutDownTimerService.cancelTimer();
            }
        } else {
            String currentTime = this.timeService.getCurrentTime();
            if (currentTime == null) {
                currentTime = Constants.DEFAULT_DATE;
            }
            int title2 = timersTimeLimitItem.getTitle();
            if (title2 != C2814R.string.settings_timers_turn_off) {
                switch (title2) {
                    case C2814R.string.settings_timers_limit_0_5_hours:
                        i = SEC_30M;
                        break;
                    case C2814R.string.settings_timers_limit_1_5_hours:
                        i = SEC_1H_30M;
                        break;
                    case C2814R.string.settings_timers_limit_1_hour:
                        i = SEC_1H;
                        break;
                    case C2814R.string.settings_timers_limit_2_5_hours:
                        i = SEC_2H_30M;
                        break;
                    case C2814R.string.settings_timers_limit_2_hours:
                        i = SEC_2H;
                        break;
                    case C2814R.string.settings_timers_limit_custom:
                        break;
                    default:
                        i = 0;
                        break;
                }
            } else {
                i = -1;
            }
            this.timersControllerService.startTimedLimitTimer(new TimeLimit(currentTime, i, i), z);
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupLimitSetupViewModel$Companion;", "", "()V", "SEC_10M", "", "SEC_15M", "SEC_1H", "SEC_1H_30M", "SEC_20M", "SEC_2H", "SEC_2H_30M", "SEC_30M", "SEC_40M", "SEC_50M", "SEC_5M", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel$Companion */
    /* compiled from: TimersSetupLimitSetupViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
