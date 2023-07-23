package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideBatteryServiceFactory */
public final class ServiceModule_ProvideBatteryServiceFactory implements Factory<BatteryService> {
    private final Provider<Context> contextProvider;
    private final Provider<DisplayService> displayServiceProvider;
    private final Provider<LightControlService> lightControlServiceProvider;
    private final Provider<InfoSoundService> soundServiceProvider;

    public ServiceModule_ProvideBatteryServiceFactory(Provider<Context> provider, Provider<InfoSoundService> provider2, Provider<LightControlService> provider3, Provider<DisplayService> provider4) {
        this.contextProvider = provider;
        this.soundServiceProvider = provider2;
        this.lightControlServiceProvider = provider3;
        this.displayServiceProvider = provider4;
    }

    public BatteryService get() {
        return provideBatteryService(this.contextProvider.get(), this.soundServiceProvider.get(), this.lightControlServiceProvider.get(), this.displayServiceProvider.get());
    }

    public static ServiceModule_ProvideBatteryServiceFactory create(Provider<Context> provider, Provider<InfoSoundService> provider2, Provider<LightControlService> provider3, Provider<DisplayService> provider4) {
        return new ServiceModule_ProvideBatteryServiceFactory(provider, provider2, provider3, provider4);
    }

    public static BatteryService provideBatteryService(Context context, InfoSoundService infoSoundService, LightControlService lightControlService, DisplayService displayService) {
        return (BatteryService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideBatteryService(context, infoSoundService, lightControlService, displayService));
    }
}
