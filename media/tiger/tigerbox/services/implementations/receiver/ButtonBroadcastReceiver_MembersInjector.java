package media.tiger.tigerbox.services.implementations.receiver;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.implementations.ButtonService;

public final class ButtonBroadcastReceiver_MembersInjector implements MembersInjector<ButtonBroadcastReceiver> {
    private final Provider<ButtonService> buttonServiceProvider;

    public ButtonBroadcastReceiver_MembersInjector(Provider<ButtonService> provider) {
        this.buttonServiceProvider = provider;
    }

    public static MembersInjector<ButtonBroadcastReceiver> create(Provider<ButtonService> provider) {
        return new ButtonBroadcastReceiver_MembersInjector(provider);
    }

    public void injectMembers(ButtonBroadcastReceiver buttonBroadcastReceiver) {
        injectButtonService(buttonBroadcastReceiver, this.buttonServiceProvider.get());
    }

    public static void injectButtonService(ButtonBroadcastReceiver buttonBroadcastReceiver, ButtonService buttonService) {
        buttonBroadcastReceiver.buttonService = buttonService;
    }
}
