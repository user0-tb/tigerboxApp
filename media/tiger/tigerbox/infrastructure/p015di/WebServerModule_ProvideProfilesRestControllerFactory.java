package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.webserver.WebServer;
import media.tiger.tigerbox.webserver.controller.ProfilesRestController;

/* renamed from: media.tiger.tigerbox.infrastructure.di.WebServerModule_ProvideProfilesRestControllerFactory */
public final class WebServerModule_ProvideProfilesRestControllerFactory implements Factory<ProfilesRestController> {
    private final Provider<WebServer> webServerProvider;

    public WebServerModule_ProvideProfilesRestControllerFactory(Provider<WebServer> provider) {
        this.webServerProvider = provider;
    }

    public ProfilesRestController get() {
        return provideProfilesRestController(this.webServerProvider.get());
    }

    public static WebServerModule_ProvideProfilesRestControllerFactory create(Provider<WebServer> provider) {
        return new WebServerModule_ProvideProfilesRestControllerFactory(provider);
    }

    public static ProfilesRestController provideProfilesRestController(WebServer webServer) {
        return (ProfilesRestController) Preconditions.checkNotNullFromProvides(WebServerModule.INSTANCE.provideProfilesRestController(webServer));
    }
}
