package media.tiger.tigerbox.services.implementations.receiver;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.implementations.HeadsetService;

public final class HeadsetBroadcastReceiver_MembersInjector implements MembersInjector<HeadsetBroadcastReceiver> {
    private final Provider<HeadsetService> headsetServiceProvider;

    public HeadsetBroadcastReceiver_MembersInjector(Provider<HeadsetService> provider) {
        this.headsetServiceProvider = provider;
    }

    public static MembersInjector<HeadsetBroadcastReceiver> create(Provider<HeadsetService> provider) {
        return new HeadsetBroadcastReceiver_MembersInjector(provider);
    }

    public void injectMembers(HeadsetBroadcastReceiver headsetBroadcastReceiver) {
        injectHeadsetService(headsetBroadcastReceiver, this.headsetServiceProvider.get());
    }

    public static void injectHeadsetService(HeadsetBroadcastReceiver headsetBroadcastReceiver, HeadsetService headsetService) {
        headsetBroadcastReceiver.headsetService = headsetService;
    }
}
