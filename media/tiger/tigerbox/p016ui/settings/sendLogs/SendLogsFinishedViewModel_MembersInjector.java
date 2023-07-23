package media.tiger.tigerbox.p016ui.settings.sendLogs;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsFinishedViewModel_MembersInjector */
public final class SendLogsFinishedViewModel_MembersInjector implements MembersInjector<SendLogsFinishedViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public SendLogsFinishedViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<SendLogsFinishedViewModel> create(Provider<LightControlService> provider) {
        return new SendLogsFinishedViewModel_MembersInjector(provider);
    }

    public void injectMembers(SendLogsFinishedViewModel sendLogsFinishedViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(sendLogsFinishedViewModel, this._lightControlProvider.get());
    }
}
