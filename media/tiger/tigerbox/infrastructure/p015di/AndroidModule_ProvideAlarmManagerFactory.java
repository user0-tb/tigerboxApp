package media.tiger.tigerbox.infrastructure.p015di;

import android.app.AlarmManager;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: media.tiger.tigerbox.infrastructure.di.AndroidModule_ProvideAlarmManagerFactory */
public final class AndroidModule_ProvideAlarmManagerFactory implements Factory<AlarmManager> {
    private final Provider<Context> contextProvider;

    public AndroidModule_ProvideAlarmManagerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public AlarmManager get() {
        return provideAlarmManager(this.contextProvider.get());
    }

    public static AndroidModule_ProvideAlarmManagerFactory create(Provider<Context> provider) {
        return new AndroidModule_ProvideAlarmManagerFactory(provider);
    }

    public static AlarmManager provideAlarmManager(Context context) {
        return (AlarmManager) Preconditions.checkNotNullFromProvides(AndroidModule.INSTANCE.provideAlarmManager(context));
    }
}
