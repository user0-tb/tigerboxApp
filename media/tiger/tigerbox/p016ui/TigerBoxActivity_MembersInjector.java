package media.tiger.tigerbox.p016ui;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.NfcService;

/* renamed from: media.tiger.tigerbox.ui.TigerBoxActivity_MembersInjector */
public final class TigerBoxActivity_MembersInjector implements MembersInjector<TigerBoxActivity> {
    private final Provider<NfcService> nfcServiceProvider;

    public TigerBoxActivity_MembersInjector(Provider<NfcService> provider) {
        this.nfcServiceProvider = provider;
    }

    public static MembersInjector<TigerBoxActivity> create(Provider<NfcService> provider) {
        return new TigerBoxActivity_MembersInjector(provider);
    }

    public void injectMembers(TigerBoxActivity tigerBoxActivity) {
        injectNfcService(tigerBoxActivity, this.nfcServiceProvider.get());
    }

    public static void injectNfcService(TigerBoxActivity tigerBoxActivity, NfcService nfcService) {
        tigerBoxActivity.nfcService = nfcService;
    }
}
