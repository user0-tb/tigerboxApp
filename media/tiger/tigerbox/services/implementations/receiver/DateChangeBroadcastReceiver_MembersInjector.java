package media.tiger.tigerbox.services.implementations.receiver;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;

public final class DateChangeBroadcastReceiver_MembersInjector implements MembersInjector<DateChangeBroadcastReceiver> {
    private final Provider<TimersControllerService> limitTimerProvider;

    public DateChangeBroadcastReceiver_MembersInjector(Provider<TimersControllerService> provider) {
        this.limitTimerProvider = provider;
    }

    public static MembersInjector<DateChangeBroadcastReceiver> create(Provider<TimersControllerService> provider) {
        return new DateChangeBroadcastReceiver_MembersInjector(provider);
    }

    public void injectMembers(DateChangeBroadcastReceiver dateChangeBroadcastReceiver) {
        injectLimitTimer(dateChangeBroadcastReceiver, this.limitTimerProvider.get());
    }

    public static void injectLimitTimer(DateChangeBroadcastReceiver dateChangeBroadcastReceiver, TimersControllerService timersControllerService) {
        dateChangeBroadcastReceiver.limitTimer = timersControllerService;
    }
}
