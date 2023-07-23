package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.webserver.WebServer;
import media.tiger.tigerbox.webserver.controller.MediaRestController;

/* renamed from: media.tiger.tigerbox.infrastructure.di.WebServerModule_ProvideMediaRestControllerFactory */
public final class WebServerModule_ProvideMediaRestControllerFactory implements Factory<MediaRestController> {
    private final Provider<WebServer> webServerProvider;

    public WebServerModule_ProvideMediaRestControllerFactory(Provider<WebServer> provider) {
        this.webServerProvider = provider;
    }

    public MediaRestController get() {
        return provideMediaRestController(this.webServerProvider.get());
    }

    public static WebServerModule_ProvideMediaRestControllerFactory create(Provider<WebServer> provider) {
        return new WebServerModule_ProvideMediaRestControllerFactory(provider);
    }

    public static MediaRestController provideMediaRestController(WebServer webServer) {
        return (MediaRestController) Preconditions.checkNotNullFromProvides(WebServerModule.INSTANCE.provideMediaRestController(webServer));
    }
}
