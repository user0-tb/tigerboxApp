package media.tiger.tigerbox.p016ui.settings.sendLogs;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.TigerBoxLogTree;
import media.tiger.tigerbox.WriteToFileExceptionHandler;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel_Factory */
public final class SendLogsInProgressViewModel_Factory implements Factory<SendLogsInProgressViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<TigerBoxLogTree> boxLogTreeProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<WriteToFileExceptionHandler> writeToFileExceptionHandlerProvider;

    public SendLogsInProgressViewModel_Factory(Provider<ButtonService> provider, Provider<WriteToFileExceptionHandler> provider2, Provider<TigerBoxLogTree> provider3, Provider<LightControlService> provider4) {
        this.buttonServiceProvider = provider;
        this.writeToFileExceptionHandlerProvider = provider2;
        this.boxLogTreeProvider = provider3;
        this._lightControlProvider = provider4;
    }

    public SendLogsInProgressViewModel get() {
        SendLogsInProgressViewModel newInstance = newInstance(this.buttonServiceProvider.get(), this.writeToFileExceptionHandlerProvider.get(), this.boxLogTreeProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static SendLogsInProgressViewModel_Factory create(Provider<ButtonService> provider, Provider<WriteToFileExceptionHandler> provider2, Provider<TigerBoxLogTree> provider3, Provider<LightControlService> provider4) {
        return new SendLogsInProgressViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static SendLogsInProgressViewModel newInstance(ButtonService buttonService, WriteToFileExceptionHandler writeToFileExceptionHandler, TigerBoxLogTree tigerBoxLogTree) {
        return new SendLogsInProgressViewModel(buttonService, writeToFileExceptionHandler, tigerBoxLogTree);
    }
}
