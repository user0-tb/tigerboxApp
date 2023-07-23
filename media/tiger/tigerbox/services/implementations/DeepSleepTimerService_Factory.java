package media.tiger.tigerbox.services.implementations;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.EngageDeepSleep;
import media.tiger.tigerbox.RestartServicesSafely;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;

public final class DeepSleepTimerService_Factory implements Factory<DeepSleepTimerService> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<EngageDeepSleep> engageDeepSleepProvider;
    private final Provider<RestartServicesSafely> restartServicesSafelyProvider;

    public DeepSleepTimerService_Factory(Provider<ConfigurationProperties> provider, Provider<EngageDeepSleep> provider2, Provider<RestartServicesSafely> provider3) {
        this.configurationPropertiesProvider = provider;
        this.engageDeepSleepProvider = provider2;
        this.restartServicesSafelyProvider = provider3;
    }

    public DeepSleepTimerService get() {
        return newInstance(this.configurationPropertiesProvider.get(), this.engageDeepSleepProvider.get(), this.restartServicesSafelyProvider.get());
    }

    public static DeepSleepTimerService_Factory create(Provider<ConfigurationProperties> provider, Provider<EngageDeepSleep> provider2, Provider<RestartServicesSafely> provider3) {
        return new DeepSleepTimerService_Factory(provider, provider2, provider3);
    }

    public static DeepSleepTimerService newInstance(ConfigurationProperties configurationProperties, EngageDeepSleep engageDeepSleep, RestartServicesSafely restartServicesSafely) {
        return new DeepSleepTimerService(configurationProperties, engageDeepSleep, restartServicesSafely);
    }
}
