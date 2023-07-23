package media.tiger.tigerbox.services.implementations.receiver;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

public final class WindowedLimitBroadcastReceiver_MembersInjector implements MembersInjector<WindowedLimitBroadcastReceiver> {
    private final Provider<TimersControllerService> limitTimerProvider;

    public WindowedLimitBroadcastReceiver_MembersInjector(Provider<TimersControllerService> provider) {
        this.limitTimerProvider = provider;
    }

    public static MembersInjector<WindowedLimitBroadcastReceiver> create(Provider<TimersControllerService> provider) {
        return new WindowedLimitBroadcastReceiver_MembersInjector(provider);
    }

    public void injectMembers(WindowedLimitBroadcastReceiver windowedLimitBroadcastReceiver) {
        injectLimitTimer(windowedLimitBroadcastReceiver, this.limitTimerProvider.get());
    }

    public static void injectLimitTimer(WindowedLimitBroadcastReceiver windowedLimitBroadcastReceiver, TimersControllerService timersControllerService) {
        windowedLimitBroadcastReceiver.limitTimer = timersControllerService;
    }
}
