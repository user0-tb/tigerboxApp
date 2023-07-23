package media.tiger.tigerbox.infrastructure.p015di;

import com.tigermedia.tigerbox.mdns.MulticastDNS;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: media.tiger.tigerbox.infrastructure.di.WebServerModule_ProvideMDNSModuleFactory */
public final class WebServerModule_ProvideMDNSModuleFactory implements Factory<MulticastDNS> {
    public MulticastDNS get() {
        return provideMDNSModule();
    }

    public static WebServerModule_ProvideMDNSModuleFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static MulticastDNS provideMDNSModule() {
        return (MulticastDNS) Preconditions.checkNotNullFromProvides(WebServerModule.INSTANCE.provideMDNSModule());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.WebServerModule_ProvideMDNSModuleFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final WebServerModule_ProvideMDNSModuleFactory INSTANCE = new WebServerModule_ProvideMDNSModuleFactory();

        private InstanceHolder() {
        }
    }
}
