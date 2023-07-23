package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.p016ui.main.maincontent.GetProductListRequest;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideGetProductListRequestFactory */
public final class ProcessModule_ProvideGetProductListRequestFactory implements Factory<GetProductListRequest> {
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public ProcessModule_ProvideGetProductListRequestFactory(Provider<TigerBoxWebService> provider, Provider<AvailabilityService> provider2) {
        this.tigerBoxWebServiceProvider = provider;
        this.availabilityServiceProvider = provider2;
    }

    public GetProductListRequest get() {
        return provideGetProductListRequest(this.tigerBoxWebServiceProvider.get(), this.availabilityServiceProvider.get());
    }

    public static ProcessModule_ProvideGetProductListRequestFactory create(Provider<TigerBoxWebService> provider, Provider<AvailabilityService> provider2) {
        return new ProcessModule_ProvideGetProductListRequestFactory(provider, provider2);
    }

    public static GetProductListRequest provideGetProductListRequest(TigerBoxWebService tigerBoxWebService, AvailabilityService availabilityService) {
        return (GetProductListRequest) Preconditions.checkNotNullFromProvides(ProcessModule.INSTANCE.provideGetProductListRequest(tigerBoxWebService, availabilityService));
    }
}
