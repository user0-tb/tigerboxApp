package media.tiger.tigerbox.p016ui.settings.sendLogs;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel_Factory */
public final class SendLogsNoneViewModel_Factory implements Factory<SendLogsNoneViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<ButtonService> buttonServiceProvider;

    public SendLogsNoneViewModel_Factory(Provider<ButtonService> provider, Provider<LightControlService> provider2) {
        this.buttonServiceProvider = provider;
        this._lightControlProvider = provider2;
    }

    public SendLogsNoneViewModel get() {
        SendLogsNoneViewModel newInstance = newInstance(this.buttonServiceProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static SendLogsNoneViewModel_Factory create(Provider<ButtonService> provider, Provider<LightControlService> provider2) {
        return new SendLogsNoneViewModel_Factory(provider, provider2);
    }

    public static SendLogsNoneViewModel newInstance(ButtonService buttonService) {
        return new SendLogsNoneViewModel(buttonService);
    }
}
