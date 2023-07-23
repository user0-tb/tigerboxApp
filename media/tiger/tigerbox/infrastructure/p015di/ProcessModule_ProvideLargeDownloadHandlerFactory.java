package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideLargeDownloadHandlerFactory */
public final class ProcessModule_ProvideLargeDownloadHandlerFactory implements Factory<LargeDownloadHandler> {
    public LargeDownloadHandler get() {
        return provideLargeDownloadHandler();
    }

    public static ProcessModule_ProvideLargeDownloadHandlerFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static LargeDownloadHandler provideLargeDownloadHandler() {
        return (LargeDownloadHandler) Preconditions.checkNotNullFromProvides(ProcessModule.INSTANCE.provideLargeDownloadHandler());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideLargeDownloadHandlerFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ProcessModule_ProvideLargeDownloadHandlerFactory INSTANCE = new ProcessModule_ProvideLargeDownloadHandlerFactory();

        private InstanceHolder() {
        }
    }
}
