package media.tiger.tigerbox.services.implementations.receiver;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.SafeguardService;

public final class SafeguardBroadcastReceiver_MembersInjector implements MembersInjector<SafeguardBroadcastReceiver> {
    private final Provider<SafeguardService> serviceProvider;

    public SafeguardBroadcastReceiver_MembersInjector(Provider<SafeguardService> provider) {
        this.serviceProvider = provider;
    }

    public static MembersInjector<SafeguardBroadcastReceiver> create(Provider<SafeguardService> provider) {
        return new SafeguardBroadcastReceiver_MembersInjector(provider);
    }

    public void injectMembers(SafeguardBroadcastReceiver safeguardBroadcastReceiver) {
        injectService(safeguardBroadcastReceiver, this.serviceProvider.get());
    }

    public static void injectService(SafeguardBroadcastReceiver safeguardBroadcastReceiver, SafeguardService safeguardService) {
        safeguardBroadcastReceiver.service = safeguardService;
    }
}
