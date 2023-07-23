package media.tiger.tigerbox.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.p016ui.common.TimedRefreshHandler;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.LightIntensityChangedListener;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEvent;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightEventKt;
import media.tiger.tigerbox.services.interfaces.TigerButtonLightStatus;
import media.tiger.tigerbox.utils.FileUtils;

@Metadata(mo33736d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 D2\u00020\u0001:\u0001DB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020&2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010)\u001a\u00020\u00192\f\u0010*\u001a\b\u0012\u0004\u0012\u00020&0+H\u0002J\u0018\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\bH\u0002J\u0010\u0010/\u001a\u00020&2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00100\u001a\u00020&2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00101\u001a\u00020&2\u0006\u0010.\u001a\u00020\bH\u0016J\u0010\u00102\u001a\u00020&2\u0006\u00103\u001a\u00020\u001aH\u0002J\u0010\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\bH\u0002J\b\u00106\u001a\u00020&H\u0016J\u0010\u00107\u001a\u00020&2\u0006\u00108\u001a\u00020\u0015H\u0016J\u0010\u00109\u001a\u00020&2\u0006\u0010'\u001a\u00020\bH\u0002J\u0010\u0010:\u001a\u00020&2\u0006\u0010'\u001a\u00020\bH\u0016J\u0010\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020\bH\u0002J\u0010\u0010=\u001a\u00020&2\u0006\u0010<\u001a\u00020\bH\u0002J\u0010\u0010>\u001a\u00020&2\u0006\u00108\u001a\u00020\u0015H\u0016J\b\u0010?\u001a\u00020&H\u0002J\u0018\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020B2\u0006\u0010\t\u001a\u00020BH\u0002J\f\u0010C\u001a\u00020B*\u00020\u001aH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR$\u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\u001a8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b8V@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006E"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/LightControl;", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "fileUtils", "Lmedia/tiger/tigerbox/utils/FileUtils;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/utils/FileUtils;)V", "currentEventBitmask", "", "value", "", "isMusicLightEnabled", "()Z", "setMusicLightEnabled", "(Z)V", "isTigerButtonLightEnabled", "setTigerButtonLightEnabled", "isTigerLightEnabled", "setTigerLightEnabled", "lightIntensityChangedListeners", "", "Lmedia/tiger/tigerbox/services/interfaces/LightIntensityChangedListener;", "pulsateHandler", "Lmedia/tiger/tigerbox/ui/common/TimedRefreshHandler;", "pulsateJob", "Lkotlinx/coroutines/Job;", "Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;", "tigerButtonLightState", "getTigerButtonLightState", "()Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;", "setTigerButtonLightState", "(Lmedia/tiger/tigerbox/services/interfaces/TigerButtonLightStatus;)V", "tigerLightIntensity", "getTigerLightIntensity", "()I", "setTigerLightIntensity", "(I)V", "addTigerButtonLightEvents", "", "eventsBitMask", "alertSubscribers", "executeInBackground", "lambda", "Lkotlin/Function0;", "flickerTigerButtonLight", "lightStatus", "count", "flickerTigerButtonLightGreen", "flickerTigerButtonLightRed", "flickerTigerButtonLightYellow", "modifyButtonLightState", "buttonLightStatus", "modifyTigerLightIntensity", "intensity", "prepareLightsForShutdown", "registerLightIntensityChangeListener", "listener", "removeBitMask", "removeTigerButtonLightEvents", "setFlickerLightOffTime", "time", "setFlickerLightOnTime", "unregisterLightIntensityChangeListener", "updateTigerButtonLightBasedOnEventBitmask", "writeFile", "path", "", "toFileValue", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: LightControl.kt */
public final class LightControl implements LightControlService {
    private static final String CONTROL_PATH_LIGHT_BREATH_EFFECTS = "/sys/devices/pwmleds.$/breathled_switch";
    private static final String CONTROL_PATH_LIGHT_MUSIC = "/sys/bus/i2c/devices/i2c-2/2-0064/led_debug";
    private static final String CONTROL_PATH_LIGHT_TIGER = "/sys/devices/pwmleds.$/laohutou_status";
    private static final String CONTROL_PATH_LIGHT_TRICOLOUR_OFF_TIME = "/sys/devices/pwmleds.$/time_off";
    private static final String CONTROL_PATH_LIGHT_TRICOLOUR_ON_TIME = "/sys/devices/pwmleds.$/time_on";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int FLICKER_OFF_TIME = 900;
    private static final int FLICKER_ON_TIME = 100;
    private static final String MUSIC_LIGHT_OFF = "0";
    private static final String MUSIC_LIGHT_ON = "1";
    private static final int NIGHT_LIGHT_MAX = 71;
    private static final String TIGER_BUTTON_LIGHT = "/sys/devices/pwmleds.$/modem_status";
    private static final String V19 = "19";
    private static final String V20 = "20";
    private static final String V21 = "21";
    private static final String V_MARKER = "$";
    private int currentEventBitmask;
    private final FileUtils fileUtils;
    private final List<LightIntensityChangedListener> lightIntensityChangedListeners = new ArrayList();
    /* access modifiers changed from: private */
    public final TimedRefreshHandler pulsateHandler = new TimedRefreshHandler();
    private Job pulsateJob;
    private final StorageService storageService;

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: LightControl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TigerButtonLightStatus.values().length];
            iArr[TigerButtonLightStatus.OFF.ordinal()] = 1;
            iArr[TigerButtonLightStatus.YELLOW_WITH_FLICKER.ordinal()] = 2;
            iArr[TigerButtonLightStatus.GREEN_WITH_FLICKER.ordinal()] = 3;
            iArr[TigerButtonLightStatus.RED_WITH_FLICKER.ordinal()] = 4;
            iArr[TigerButtonLightStatus.YELLOW_WITH_BREATH.ordinal()] = 5;
            iArr[TigerButtonLightStatus.GREEN_WITH_BREATH.ordinal()] = 6;
            iArr[TigerButtonLightStatus.RED_WITH_BREATH.ordinal()] = 7;
            iArr[TigerButtonLightStatus.YELLOW.ordinal()] = 8;
            iArr[TigerButtonLightStatus.GREEN.ordinal()] = 9;
            iArr[TigerButtonLightStatus.RED.ordinal()] = 10;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LightControl(StorageService storageService2, FileUtils fileUtils2) {
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(fileUtils2, "fileUtils");
        this.storageService = storageService2;
        this.fileUtils = fileUtils2;
        modifyButtonLightState(getTigerButtonLightState());
        setMusicLightEnabled(isMusicLightEnabled());
        setTigerLightEnabled(isTigerLightEnabled());
    }

    public void prepareLightsForShutdown() {
        executeInBackground(new LightControl$prepareLightsForShutdown$1(this));
    }

    public boolean isMusicLightEnabled() {
        return this.storageService.getMusicLightOn();
    }

    public void setMusicLightEnabled(boolean z) {
        executeInBackground(new LightControl$isMusicLightEnabled$1(this, z));
        this.storageService.setMusicLightOn(z);
    }

    public boolean isTigerLightEnabled() {
        return this.storageService.getTigerLightEnabled();
    }

    public void setTigerLightEnabled(boolean z) {
        this.storageService.setTigerLightEnabled(z);
        int tigerLightIntensity = z ? this.storageService.getTigerLightIntensity() : 0;
        modifyTigerLightIntensity(tigerLightIntensity);
        alertSubscribers(tigerLightIntensity);
    }

    public int getTigerLightIntensity() {
        return this.storageService.getTigerLightIntensity();
    }

    public void setTigerLightIntensity(int i) {
        int i2 = 0;
        int max = Math.max(Math.min(i, 100), 0);
        this.storageService.setTigerLightIntensity(max);
        if (isTigerLightEnabled()) {
            i2 = max;
        }
        executeInBackground(new LightControl$tigerLightIntensity$1(this, i2));
        alertSubscribers(i2);
    }

    public boolean isTigerButtonLightEnabled() {
        return this.storageService.getTigerButtonLightEnabled();
    }

    public void setTigerButtonLightEnabled(boolean z) {
        this.storageService.setTigerButtonLightEnabled(z);
        if (z) {
            modifyButtonLightState(getTigerButtonLightState());
        } else {
            modifyButtonLightState(TigerButtonLightStatus.OFF);
        }
    }

    public TigerButtonLightStatus getTigerButtonLightState() {
        return this.storageService.getTigerButtonLightState();
    }

    public void setTigerButtonLightState(TigerButtonLightStatus tigerButtonLightStatus) {
        Intrinsics.checkNotNullParameter(tigerButtonLightStatus, "value");
        this.storageService.setTigerButtonLightState(tigerButtonLightStatus);
        if (isTigerButtonLightEnabled()) {
            modifyButtonLightState(getTigerButtonLightState());
        } else {
            modifyButtonLightState(TigerButtonLightStatus.OFF);
        }
    }

    public void registerLightIntensityChangeListener(LightIntensityChangedListener lightIntensityChangedListener) {
        Intrinsics.checkNotNullParameter(lightIntensityChangedListener, "listener");
        this.lightIntensityChangedListeners.add(lightIntensityChangedListener);
    }

    public void unregisterLightIntensityChangeListener(LightIntensityChangedListener lightIntensityChangedListener) {
        Intrinsics.checkNotNullParameter(lightIntensityChangedListener, "listener");
        if (this.lightIntensityChangedListeners.contains(lightIntensityChangedListener)) {
            this.lightIntensityChangedListeners.remove(lightIntensityChangedListener);
        }
    }

    private final void alertSubscribers(int i) {
        for (LightIntensityChangedListener onChange : this.lightIntensityChangedListeners) {
            onChange.onChange(i);
        }
    }

    /* access modifiers changed from: private */
    public final void modifyTigerLightIntensity(int i) {
        writeFile(CONTROL_PATH_LIGHT_TIGER, String.valueOf((int) ((((double) i) / 100.0d) * ((double) 71))));
    }

    /* access modifiers changed from: private */
    public final void modifyButtonLightState(TigerButtonLightStatus tigerButtonLightStatus) {
        switch (WhenMappings.$EnumSwitchMapping$0[tigerButtonLightStatus.ordinal()]) {
            case 1:
                executeInBackground(new LightControl$modifyButtonLightState$1(this, tigerButtonLightStatus));
                return;
            case 2:
            case 3:
            case 4:
                executeInBackground(new LightControl$modifyButtonLightState$2(this, tigerButtonLightStatus));
                return;
            case 5:
                executeInBackground(new LightControl$modifyButtonLightState$3(this, tigerButtonLightStatus));
                return;
            case 6:
                executeInBackground(new LightControl$modifyButtonLightState$4(this, tigerButtonLightStatus));
                return;
            case 7:
                executeInBackground(new LightControl$modifyButtonLightState$5(this, tigerButtonLightStatus));
                return;
            default:
                executeInBackground(new LightControl$modifyButtonLightState$6(this, tigerButtonLightStatus));
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void setFlickerLightOnTime(int i) {
        writeFile(CONTROL_PATH_LIGHT_TRICOLOUR_ON_TIME, String.valueOf(i));
    }

    /* access modifiers changed from: private */
    public final void setFlickerLightOffTime(int i) {
        writeFile(CONTROL_PATH_LIGHT_TRICOLOUR_OFF_TIME, String.valueOf(i));
    }

    public void addTigerButtonLightEvents(int i) {
        this.currentEventBitmask = i | this.currentEventBitmask;
        updateTigerButtonLightBasedOnEventBitmask();
    }

    private final void removeBitMask(int i) {
        this.currentEventBitmask = (~i) & this.currentEventBitmask;
    }

    public void removeTigerButtonLightEvents(int i) {
        removeBitMask(i);
        updateTigerButtonLightBasedOnEventBitmask();
    }

    /* access modifiers changed from: private */
    public final void updateTigerButtonLightBasedOnEventBitmask() {
        TigerButtonLightStatus tigerButtonLightStatus = TigerButtonLightStatus.OFF;
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.BATTERY_BETWEEN_5_10)) > 0) {
            tigerButtonLightStatus = TigerButtonLightStatus.YELLOW;
        }
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.BATTERY_UNDER_5)) > 0) {
            tigerButtonLightStatus = TigerButtonLightStatus.YELLOW_WITH_FLICKER;
        }
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.BATTERY_FULL_PLUGGED)) > 0) {
            tigerButtonLightStatus = TigerButtonLightStatus.GREEN;
        }
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_IN_PROGRESS)) > 0) {
            tigerButtonLightStatus = TigerButtonLightStatus.YELLOW_WITH_BREATH;
        }
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_INTERRUPTED_BY_WIFI)) > 0) {
            tigerButtonLightStatus = TigerButtonLightStatus.OFF;
        }
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_UPDATE_IN_PROGRESS)) > 0) {
            tigerButtonLightStatus = TigerButtonLightStatus.YELLOW_WITH_BREATH;
        }
        setTigerButtonLightState(tigerButtonLightStatus);
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_FINISHED)) > 0) {
            removeBitMask(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_FINISHED) | TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_IN_PROGRESS) | TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_INTERRUPTED_BY_WIFI));
            flickerTigerButtonLightGreen(2);
        }
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_FAIL)) > 0) {
            removeBitMask(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_FINISHED) | TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_IN_PROGRESS) | TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_PRODUCTS_FAIL));
            flickerTigerButtonLightRed(2);
        }
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_UPDATE_FINISHED)) > 0) {
            removeBitMask(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_UPDATE_FINISHED) | TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_UPDATE_IN_PROGRESS));
            flickerTigerButtonLightGreen(2);
        }
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_UPDATE_FINISHED_ERROR)) > 0) {
            removeBitMask(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_UPDATE_IN_PROGRESS) | TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_UPDATE_FINISHED) | TigerButtonLightEventKt.toBit(TigerButtonLightEvent.DOWNLOAD_UPDATE_FINISHED_ERROR));
            flickerTigerButtonLightRed(2);
        }
        if ((this.currentEventBitmask & TigerButtonLightEventKt.toBit(TigerButtonLightEvent.ERROR)) > 0) {
            removeBitMask(TigerButtonLightEventKt.toBit(TigerButtonLightEvent.ERROR));
            flickerTigerButtonLightRed(2);
        }
    }

    public void flickerTigerButtonLightGreen(int i) {
        flickerTigerButtonLight(TigerButtonLightStatus.GREEN_WITH_FLICKER, i);
    }

    public void flickerTigerButtonLightYellow(int i) {
        flickerTigerButtonLight(TigerButtonLightStatus.YELLOW_WITH_FLICKER, i);
    }

    public void flickerTigerButtonLightRed(int i) {
        flickerTigerButtonLight(TigerButtonLightStatus.RED_WITH_FLICKER, i);
    }

    private final void flickerTigerButtonLight(TigerButtonLightStatus tigerButtonLightStatus, int i) {
        Job job = this.pulsateJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (isTigerButtonLightEnabled()) {
            this.pulsateJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new LightControl$flickerTigerButtonLight$1(this, tigerButtonLightStatus, i, (Continuation<? super LightControl$flickerTigerButtonLight$1>) null), 3, (Object) null);
        }
    }

    private final Job executeInBackground(Function0<Unit> function0) {
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new LightControl$executeInBackground$1(function0, (Continuation<? super LightControl$executeInBackground$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void writeFile(String str, String str2) {
        synchronized (this) {
            String replace$default = StringsKt.replace$default(str, V_MARKER, V19, false, 4, (Object) null);
            if (this.fileUtils.isFileExists(replace$default)) {
                this.fileUtils.writeFile(replace$default, str2);
            }
            String replace$default2 = StringsKt.replace$default(str, V_MARKER, V20, false, 4, (Object) null);
            if (this.fileUtils.isFileExists(replace$default2)) {
                this.fileUtils.writeFile(replace$default2, str2);
            }
            String replace$default3 = StringsKt.replace$default(str, V_MARKER, V21, false, 4, (Object) null);
            if (this.fileUtils.isFileExists(replace$default3)) {
                this.fileUtils.writeFile(replace$default3, str2);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final String toFileValue(TigerButtonLightStatus tigerButtonLightStatus) {
        switch (WhenMappings.$EnumSwitchMapping$0[tigerButtonLightStatus.ordinal()]) {
            case 1:
                return "000000";
            case 2:
                return "110000";
            case 3:
                return "001100";
            case 4:
                return "000011";
            case 5:
                return "7";
            case 6:
                return "1";
            case 7:
                return "5";
            case 8:
                return "100000";
            case 9:
                return "001000";
            case 10:
                return "000010";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/LightControl$Companion;", "", "()V", "CONTROL_PATH_LIGHT_BREATH_EFFECTS", "", "CONTROL_PATH_LIGHT_MUSIC", "CONTROL_PATH_LIGHT_TIGER", "CONTROL_PATH_LIGHT_TRICOLOUR_OFF_TIME", "CONTROL_PATH_LIGHT_TRICOLOUR_ON_TIME", "FLICKER_OFF_TIME", "", "FLICKER_ON_TIME", "MUSIC_LIGHT_OFF", "MUSIC_LIGHT_ON", "NIGHT_LIGHT_MAX", "TIGER_BUTTON_LIGHT", "V19", "V20", "V21", "V_MARKER", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: LightControl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
