package media.tiger.tigerbox.p016ui.settings.sendLogs;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel_MembersInjector */
public final class SendLogsInProgressViewModel_MembersInjector implements MembersInjector<SendLogsInProgressViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public SendLogsInProgressViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<SendLogsInProgressViewModel> create(Provider<LightControlService> provider) {
        return new SendLogsInProgressViewModel_MembersInjector(provider);
    }

    public void injectMembers(SendLogsInProgressViewModel sendLogsInProgressViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(sendLogsInProgressViewModel, this._lightControlProvider.get());
    }
}
