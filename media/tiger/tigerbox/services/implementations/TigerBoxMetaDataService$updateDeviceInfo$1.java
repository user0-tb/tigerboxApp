package media.tiger.tigerbox.services.implementations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.Constants;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimits;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.webserver.dto.LogoLight;
import media.tiger.tigerbox.webserver.dto.NightLight;
import media.tiger.tigerbox.webserver.dto.UpdateDeviceInfoDto;
import media.tiger.tigerbox.webserver.dto.WindowedTimerDto;
import media.tiger.tigerbox.webserver.dto.WindowedTimerDtoKt;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "media.tiger.tigerbox.services.implementations.TigerBoxMetaDataService$updateDeviceInfo$1", mo34424f = "TigerBoxMetaDataService.kt", mo34425i = {}, mo34426l = {}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* compiled from: TigerBoxMetaDataService.kt */
final class TigerBoxMetaDataService$updateDeviceInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UpdateDeviceInfoDto $updateDeviceInfoDto;
    int label;
    final /* synthetic */ TigerBoxMetaDataService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TigerBoxMetaDataService$updateDeviceInfo$1(UpdateDeviceInfoDto updateDeviceInfoDto, TigerBoxMetaDataService tigerBoxMetaDataService, Continuation<? super TigerBoxMetaDataService$updateDeviceInfo$1> continuation) {
        super(2, continuation);
        this.$updateDeviceInfoDto = updateDeviceInfoDto;
        this.this$0 = tigerBoxMetaDataService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TigerBoxMetaDataService$updateDeviceInfo$1(this.$updateDeviceInfoDto, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TigerBoxMetaDataService$updateDeviceInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String deviceName = this.$updateDeviceInfoDto.getDeviceName();
            if (deviceName != null) {
                TigerBoxMetaDataService tigerBoxMetaDataService = this.this$0;
                tigerBoxMetaDataService.storageService.setDisplayName(deviceName);
                tigerBoxMetaDataService.alertDisplayNameSubscribers(deviceName);
            }
            Integer maxVolume = this.$updateDeviceInfoDto.getMaxVolume();
            if (maxVolume != null) {
                TigerBoxMetaDataService tigerBoxMetaDataService2 = this.this$0;
                int intValue = maxVolume.intValue();
                boolean z = false;
                int volume = tigerBoxMetaDataService2.getMaxVolume() <= 0 ? 0 : (tigerBoxMetaDataService2.getVolume() * 100) / tigerBoxMetaDataService2.getMaxVolume();
                int streamMaxVolume = tigerBoxMetaDataService2.audioPlayerService.getStreamMaxVolume();
                if (intValue >= 0 && intValue <= streamMaxVolume) {
                    z = true;
                }
                if (z) {
                    tigerBoxMetaDataService2.setMaxVolume(intValue);
                    tigerBoxMetaDataService2.setVolume((volume * intValue) / 100);
                    tigerBoxMetaDataService2.alertMaxVolumeSubscribers();
                }
            }
            Float musicVolumeUnit = this.$updateDeviceInfoDto.getMusicVolumeUnit();
            if (musicVolumeUnit != null) {
                this.this$0.setMusicVolumeUnit(musicVolumeUnit.floatValue());
            }
            Boolean musicLightEnabled = this.$updateDeviceInfoDto.getMusicLightEnabled();
            if (musicLightEnabled != null) {
                this.this$0.lightControlService.setMusicLightEnabled(musicLightEnabled.booleanValue());
            }
            LogoLight logoLight = this.$updateDeviceInfoDto.getLogoLight();
            if (logoLight != null) {
                TigerBoxMetaDataService tigerBoxMetaDataService3 = this.this$0;
                Boolean enabled = logoLight.getEnabled();
                if (enabled != null) {
                    tigerBoxMetaDataService3.lightControlService.setTigerLightEnabled(enabled.booleanValue());
                }
                Integer intensity = logoLight.getIntensity();
                if (intensity != null) {
                    tigerBoxMetaDataService3.lightControlService.setTigerLightIntensity(intensity.intValue());
                }
            }
            NightLight nightLight = this.$updateDeviceInfoDto.getNightLight();
            if (nightLight != null) {
                this.this$0.nightLightTimerService.updateNightLightTimer(nightLight);
            }
            Integer sleepTimer = this.$updateDeviceInfoDto.getSleepTimer();
            int i = -1;
            if (sleepTimer != null) {
                TigerBoxMetaDataService tigerBoxMetaDataService4 = this.this$0;
                int intValue2 = sleepTimer.intValue();
                if (intValue2 > 0) {
                    tigerBoxMetaDataService4.shutDownTimerService.startTimer(intValue2);
                } else if (intValue2 == -1) {
                    tigerBoxMetaDataService4.shutDownTimerService.shutDownAtTheEndOfPlayback();
                } else {
                    tigerBoxMetaDataService4.shutDownTimerService.cancelTimer();
                }
            }
            Integer timeLimitInitialTimeSeconds = this.$updateDeviceInfoDto.getTimeLimitInitialTimeSeconds();
            if (timeLimitInitialTimeSeconds != null) {
                TigerBoxMetaDataService tigerBoxMetaDataService5 = this.this$0;
                int intValue3 = timeLimitInitialTimeSeconds.intValue();
                if (intValue3 > -1) {
                    i = intValue3;
                }
                String currentTime = tigerBoxMetaDataService5.timeService.getCurrentTime();
                if (currentTime == null) {
                    currentTime = Constants.DEFAULT_DATE;
                }
                tigerBoxMetaDataService5.storageService.setTimeLimit(tigerBoxMetaDataService5.storageService.getTimeLimit().copy(currentTime, i, i));
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new TigerBoxMetaDataService$updateDeviceInfo$1$8$1(tigerBoxMetaDataService5, currentTime, i, (Continuation<? super TigerBoxMetaDataService$updateDeviceInfo$1$8$1>) null), 3, (Object) null);
            }
            List<WindowedTimerDto> timeWindowList = this.$updateDeviceInfoDto.getTimeWindowList();
            if (timeWindowList != null) {
                TigerBoxMetaDataService tigerBoxMetaDataService6 = this.this$0;
                Iterable<WindowedTimerDto> iterable = timeWindowList;
                for (WindowedTimerDto validateAndSanitize : iterable) {
                    WindowedTimerDtoKt.validateAndSanitize(validateAndSanitize);
                }
                StorageService access$getStorageService$p = tigerBoxMetaDataService6.storageService;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (WindowedTimerDto windowedTimerDto : iterable) {
                    String windowedStart = windowedTimerDto.getWindowedStart();
                    String str = "";
                    if (windowedStart == null) {
                        windowedStart = str;
                    }
                    String windowedEnd = windowedTimerDto.getWindowedEnd();
                    if (windowedEnd != null) {
                        str = windowedEnd;
                    }
                    arrayList.add(new WindowedLimits.WindowedLimit(windowedStart, str));
                }
                access$getStorageService$p.setWindowedLimit(new WindowedLimits((List) arrayList));
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), (CoroutineContext) null, (CoroutineStart) null, new TigerBoxMetaDataService$updateDeviceInfo$1$9$3(tigerBoxMetaDataService6, (Continuation<? super TigerBoxMetaDataService$updateDeviceInfo$1$9$3>) null), 3, (Object) null);
            }
            Boolean systemSoundEnabled = this.$updateDeviceInfoDto.getSystemSoundEnabled();
            if (systemSoundEnabled != null) {
                this.this$0.infoSoundService.setSystemSoundEnabled(systemSoundEnabled.booleanValue());
            }
            Boolean wifiEnabled = this.$updateDeviceInfoDto.getWifiEnabled();
            if (wifiEnabled != null) {
                this.this$0.wifiService.setWifiEnabled(wifiEnabled.booleanValue());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
