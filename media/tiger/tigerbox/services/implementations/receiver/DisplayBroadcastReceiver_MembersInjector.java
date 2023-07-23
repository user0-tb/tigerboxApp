package media.tiger.tigerbox.services.implementations.receiver;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.implementations.DisplayService;

public final class DisplayBroadcastReceiver_MembersInjector implements MembersInjector<DisplayBroadcastReceiver> {
    private final Provider<DisplayService> displayServiceProvider;

    public DisplayBroadcastReceiver_MembersInjector(Provider<DisplayService> provider) {
        this.displayServiceProvider = provider;
    }

    public static MembersInjector<DisplayBroadcastReceiver> create(Provider<DisplayService> provider) {
        return new DisplayBroadcastReceiver_MembersInjector(provider);
    }

    public void injectMembers(DisplayBroadcastReceiver displayBroadcastReceiver) {
        injectDisplayService(displayBroadcastReceiver, this.displayServiceProvider.get());
    }

    public static void injectDisplayService(DisplayBroadcastReceiver displayBroadcastReceiver, DisplayService displayService) {
        displayBroadcastReceiver.displayService = displayService;
    }
}
