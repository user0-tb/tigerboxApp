package media.tiger.tigerbox.services.implementations.receiver;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.NfcService;

public final class NfcBroadcastReceiver_MembersInjector implements MembersInjector<NfcBroadcastReceiver> {
    private final Provider<NfcService> nfcServiceProvider;

    public NfcBroadcastReceiver_MembersInjector(Provider<NfcService> provider) {
        this.nfcServiceProvider = provider;
    }

    public static MembersInjector<NfcBroadcastReceiver> create(Provider<NfcService> provider) {
        return new NfcBroadcastReceiver_MembersInjector(provider);
    }

    public void injectMembers(NfcBroadcastReceiver nfcBroadcastReceiver) {
        injectNfcService(nfcBroadcastReceiver, this.nfcServiceProvider.get());
    }

    public static void injectNfcService(NfcBroadcastReceiver nfcBroadcastReceiver, NfcService nfcService) {
        nfcBroadcastReceiver.nfcService = nfcService;
    }
}
