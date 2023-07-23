package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.infrastructure.functional.DownloadProgressUpdate;

/* renamed from: media.tiger.tigerbox.infrastructure.di.RetrofitModule_ProvideDownloadProgressNotifierFactory */
public final class RetrofitModule_ProvideDownloadProgressNotifierFactory implements Factory<DownloadProgressUpdate> {
    public DownloadProgressUpdate get() {
        return provideDownloadProgressNotifier();
    }

    public static RetrofitModule_ProvideDownloadProgressNotifierFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DownloadProgressUpdate provideDownloadProgressNotifier() {
        return (DownloadProgressUpdate) Preconditions.checkNotNullFromProvides(RetrofitModule.INSTANCE.provideDownloadProgressNotifier());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.RetrofitModule_ProvideDownloadProgressNotifierFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RetrofitModule_ProvideDownloadProgressNotifierFactory INSTANCE = new RetrofitModule_ProvideDownloadProgressNotifierFactory();

        private InstanceHolder() {
        }
    }
}
