package media.tiger.tigerbox.p016ui.settings.timersSetup;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.C2814R;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.implementations.timersController.TimeLimit;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.utils.DateUtilsKt;

@Metadata(mo33736d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0002\u0011\u001c\b\u0007\u0018\u00002\u00020\u0001:\u0001/B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020'H\u0002J\u0006\u0010)\u001a\u00020'J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020-R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00060"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel;", "Lmedia/tiger/tigerbox/ui/common/FullScreenViewModel;", "timersCtrlService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "shutDownTimerService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "_viewState", "Landroidx/lifecycle/MutableLiveData;", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel$ViewState;", "shutDownTimeListener", "media/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel$shutDownTimeListener$1", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel$shutDownTimeListener$1;", "sleepTimeSeconds", "", "getSleepTimeSeconds", "()I", "timeLimit", "Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "getTimeLimit", "()Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "timeLimitChangedListener", "media/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel$timeLimitChangedListener$1", "Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel$timeLimitChangedListener$1;", "viewState", "Landroidx/lifecycle/LiveData;", "getViewState", "()Landroidx/lifecycle/LiveData;", "windowedLimit", "Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;", "getWindowedLimit", "()Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;", "exit", "", "postViewState", "prepare", "sleepTimeDescription", "", "context", "Landroid/content/Context;", "timeLimitDescription", "ViewState", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel */
/* compiled from: TimersSetupViewModel.kt */
public final class TimersSetupViewModel extends FullScreenViewModel {
    private final MutableLiveData<ViewState> _viewState;
    private final TimersSetupViewModel$shutDownTimeListener$1 shutDownTimeListener = new TimersSetupViewModel$shutDownTimeListener$1(this);
    private final ShutDownTimerService shutDownTimerService;
    private final StorageService storageService;
    private final TimersSetupViewModel$timeLimitChangedListener$1 timeLimitChangedListener = new TimersSetupViewModel$timeLimitChangedListener$1(this);
    private final TimersControllerService timersCtrlService;
    private final LiveData<ViewState> viewState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public TimersSetupViewModel(TimersControllerService timersControllerService, ShutDownTimerService shutDownTimerService2, StorageService storageService2, ButtonService buttonService, HeaderProvider headerProvider) {
        super(buttonService, headerProvider);
        Intrinsics.checkNotNullParameter(timersControllerService, "timersCtrlService");
        Intrinsics.checkNotNullParameter(shutDownTimerService2, "shutDownTimerService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(headerProvider, "headerProvider");
        this.timersCtrlService = timersControllerService;
        this.shutDownTimerService = shutDownTimerService2;
        this.storageService = storageService2;
        MutableLiveData<ViewState> mutableLiveData = new MutableLiveData<>();
        this._viewState = mutableLiveData;
        this.viewState = mutableLiveData;
    }

    private final WindowedLimits getWindowedLimit() {
        return this.storageService.getWindowedLimit();
    }

    private final TimeLimit getTimeLimit() {
        return this.storageService.getTimeLimit();
    }

    private final int getSleepTimeSeconds() {
        return this.shutDownTimerService.getInitialShutDownTimeSeconds();
    }

    public final LiveData<ViewState> getViewState() {
        return this.viewState;
    }

    /* access modifiers changed from: private */
    public final void postViewState() {
        this._viewState.postValue(new ViewState(getTimeLimit(), getSleepTimeSeconds(), getWindowedLimit()));
    }

    public final void prepare() {
        this.shutDownTimerService.registerShutDownTimeListener(this.shutDownTimeListener);
        this.storageService.registerTimeLimitChangeListener(this.timeLimitChangedListener);
        postViewState();
    }

    public final void exit() {
        this.shutDownTimerService.unregisterShutDownTimeListener(this.shutDownTimeListener);
        this.storageService.unregisterTimeLimitChangeListener(this.timeLimitChangedListener);
    }

    public final String timeLimitDescription(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int initialLimitSeconds = getTimeLimit().getInitialLimitSeconds();
        if (initialLimitSeconds == -1) {
            String string = context.getString(C2814R.string.settings_timers_turn_off);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…settings_timers_turn_off)");
            return string;
        } else if (initialLimitSeconds == 1800) {
            String string2 = context.getString(C2814R.string.settings_timers_limit_0_5_hours);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…s_timers_limit_0_5_hours)");
            return string2;
        } else if (initialLimitSeconds == 3600) {
            String string3 = context.getString(C2814R.string.settings_timers_limit_1_hour);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…ings_timers_limit_1_hour)");
            return string3;
        } else if (initialLimitSeconds == 5400) {
            String string4 = context.getString(C2814R.string.settings_timers_limit_1_5_hours);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…s_timers_limit_1_5_hours)");
            return string4;
        } else if (initialLimitSeconds == 7200) {
            String string5 = context.getString(C2814R.string.settings_timers_limit_2_hours);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri…ngs_timers_limit_2_hours)");
            return string5;
        } else if (initialLimitSeconds != 9000) {
            return DateUtilsKt.toHumanTimerString((long) (getTimeLimit().getInitialLimitSeconds() * 1000));
        } else {
            String string6 = context.getString(C2814R.string.settings_timers_limit_2_5_hours);
            Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri…s_timers_limit_2_5_hours)");
            return string6;
        }
    }

    public final String sleepTimeDescription(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int sleepTimeSeconds = getSleepTimeSeconds();
        if (sleepTimeSeconds == -1) {
            String string = context.getString(C2814R.string.settings_timers_sleep_end_of_product);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…ers_sleep_end_of_product)");
            return string;
        } else if (sleepTimeSeconds == 0) {
            String string2 = context.getString(C2814R.string.settings_timers_turn_off);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…settings_timers_turn_off)");
            return string2;
        } else if (sleepTimeSeconds == 300) {
            String string3 = context.getString(C2814R.string.settings_timers_sleep_5_minutes);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…s_timers_sleep_5_minutes)");
            return string3;
        } else if (sleepTimeSeconds == 600) {
            String string4 = context.getString(C2814R.string.settings_timers_sleep_10_minutes);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…_timers_sleep_10_minutes)");
            return string4;
        } else if (sleepTimeSeconds == 900) {
            String string5 = context.getString(C2814R.string.settings_timers_sleep_15_minutes);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri…_timers_sleep_15_minutes)");
            return string5;
        } else if (sleepTimeSeconds == 1200) {
            String string6 = context.getString(C2814R.string.settings_timers_sleep_20_minutes);
            Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri…_timers_sleep_20_minutes)");
            return string6;
        } else if (sleepTimeSeconds == 1800) {
            String string7 = context.getString(C2814R.string.settings_timers_sleep_30_minutes);
            Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.stri…_timers_sleep_30_minutes)");
            return string7;
        } else if (sleepTimeSeconds == 2400) {
            String string8 = context.getString(C2814R.string.settings_timers_sleep_40_minutes);
            Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.stri…_timers_sleep_40_minutes)");
            return string8;
        } else if (sleepTimeSeconds == 3000) {
            String string9 = context.getString(C2814R.string.settings_timers_sleep_50_minutes);
            Intrinsics.checkNotNullExpressionValue(string9, "context.getString(R.stri…_timers_sleep_50_minutes)");
            return string9;
        } else if (sleepTimeSeconds != 3600) {
            return DateUtilsKt.toHumanTimerString((long) (getSleepTimeSeconds() * 1000));
        } else {
            String string10 = context.getString(C2814R.string.settings_timers_sleep_1_hour);
            Intrinsics.checkNotNullExpressionValue(string10, "context.getString(R.stri…ings_timers_sleep_1_hour)");
            return string10;
        }
    }

    @Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/timersSetup/TimersSetupViewModel$ViewState;", "", "timeLimit", "Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "sleepTimeSeconds", "", "windowedLimit", "Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;", "(Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;ILmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;)V", "getSleepTimeSeconds", "()I", "getTimeLimit", "()Lmedia/tiger/tigerbox/services/implementations/timersController/TimeLimit;", "getWindowedLimit", "()Lmedia/tiger/tigerbox/services/implementations/timersController/WindowedLimits;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel$ViewState */
    /* compiled from: TimersSetupViewModel.kt */
    public static final class ViewState {
        private final int sleepTimeSeconds;
        private final TimeLimit timeLimit;
        private final WindowedLimits windowedLimit;

        public static /* synthetic */ ViewState copy$default(ViewState viewState, TimeLimit timeLimit2, int i, WindowedLimits windowedLimits, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                timeLimit2 = viewState.timeLimit;
            }
            if ((i2 & 2) != 0) {
                i = viewState.sleepTimeSeconds;
            }
            if ((i2 & 4) != 0) {
                windowedLimits = viewState.windowedLimit;
            }
            return viewState.copy(timeLimit2, i, windowedLimits);
        }

        public final TimeLimit component1() {
            return this.timeLimit;
        }

        public final int component2() {
            return this.sleepTimeSeconds;
        }

        public final WindowedLimits component3() {
            return this.windowedLimit;
        }

        public final ViewState copy(TimeLimit timeLimit2, int i, WindowedLimits windowedLimits) {
            Intrinsics.checkNotNullParameter(timeLimit2, "timeLimit");
            Intrinsics.checkNotNullParameter(windowedLimits, "windowedLimit");
            return new ViewState(timeLimit2, i, windowedLimits);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) obj;
            return Intrinsics.areEqual((Object) this.timeLimit, (Object) viewState.timeLimit) && this.sleepTimeSeconds == viewState.sleepTimeSeconds && Intrinsics.areEqual((Object) this.windowedLimit, (Object) viewState.windowedLimit);
        }

        public int hashCode() {
            return (((this.timeLimit.hashCode() * 31) + this.sleepTimeSeconds) * 31) + this.windowedLimit.hashCode();
        }

        public String toString() {
            return "ViewState(timeLimit=" + this.timeLimit + ", sleepTimeSeconds=" + this.sleepTimeSeconds + ", windowedLimit=" + this.windowedLimit + ')';
        }

        public ViewState(TimeLimit timeLimit2, int i, WindowedLimits windowedLimits) {
            Intrinsics.checkNotNullParameter(timeLimit2, "timeLimit");
            Intrinsics.checkNotNullParameter(windowedLimits, "windowedLimit");
            this.timeLimit = timeLimit2;
            this.sleepTimeSeconds = i;
            this.windowedLimit = windowedLimits;
        }

        public final TimeLimit getTimeLimit() {
            return this.timeLimit;
        }

        public final int getSleepTimeSeconds() {
            return this.sleepTimeSeconds;
        }

        public final WindowedLimits getWindowedLimit() {
            return this.windowedLimit;
        }
    }
}
