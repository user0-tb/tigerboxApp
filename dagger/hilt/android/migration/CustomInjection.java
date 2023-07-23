package dagger.hilt.android.migration;

import android.app.Application;
import dagger.hilt.android.internal.migration.HasCustomInject;
import dagger.hilt.internal.Preconditions;

public final class CustomInjection {
    public static void inject(Application application) {
        Preconditions.checkNotNull(application);
        Preconditions.checkArgument(application instanceof HasCustomInject, "'%s' is not a custom inject application. Check that you have annotated the application with both @HiltAndroidApp and @CustomInject.", application.getClass());
        ((HasCustomInject) application).customInject();
    }

    private CustomInjection() {
    }
}
