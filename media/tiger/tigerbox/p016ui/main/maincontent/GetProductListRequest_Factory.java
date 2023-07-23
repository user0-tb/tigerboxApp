package media.tiger.tigerbox.p016ui.main.maincontent;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;

/* renamed from: media.tiger.tigerbox.ui.main.maincontent.GetProductListRequest_Factory */
public final class GetProductListRequest_Factory implements Factory<GetProductListRequest> {
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public GetProductListRequest_Factory(Provider<TigerBoxWebService> provider, Provider<AvailabilityService> provider2) {
        this.tigerBoxWebServiceProvider = provider;
        this.availabilityServiceProvider = provider2;
    }

    public GetProductListRequest get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.availabilityServiceProvider.get());
    }

    public static GetProductListRequest_Factory create(Provider<TigerBoxWebService> provider, Provider<AvailabilityService> provider2) {
        return new GetProductListRequest_Factory(provider, provider2);
    }

    public static GetProductListRequest newInstance(TigerBoxWebService tigerBoxWebService, AvailabilityService availabilityService) {
        return new GetProductListRequest(tigerBoxWebService, availabilityService);
    }
}
