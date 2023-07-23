package media.tiger.tigerbox.p016ui.settings.sendLogs;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel_MembersInjector */
public final class SendLogsNoneViewModel_MembersInjector implements MembersInjector<SendLogsNoneViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public SendLogsNoneViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<SendLogsNoneViewModel> create(Provider<LightControlService> provider) {
        return new SendLogsNoneViewModel_MembersInjector(provider);
    }

    public void injectMembers(SendLogsNoneViewModel sendLogsNoneViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(sendLogsNoneViewModel, this._lightControlProvider.get());
    }
}
