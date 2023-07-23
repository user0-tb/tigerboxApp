package media.tiger.tigerbox.infrastructure.p015di;

import android.app.AlarmManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.Objects;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/di/AndroidModule;", "", "()V", "provideAlarmManager", "Landroid/app/AlarmManager;", "context", "Landroid/content/Context;", "provideAudioManager", "Landroid/media/AudioManager;", "provideDisplayManager", "Landroid/hardware/display/DisplayManager;", "providePowerManager", "Landroid/os/PowerManager;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@Module
/* renamed from: media.tiger.tigerbox.infrastructure.di.AndroidModule */
/* compiled from: AndroidModule.kt */
public final class AndroidModule {
    public static final AndroidModule INSTANCE = new AndroidModule();

    private AndroidModule() {
    }

    @Singleton
    @Provides
    public final AudioManager provideAudioManager(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("audio");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        return (AudioManager) systemService;
    }

    @Singleton
    @Provides
    public final AlarmManager provideAlarmManager(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        return (AlarmManager) systemService;
    }

    @Singleton
    @Provides
    public final PowerManager providePowerManager(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return (PowerManager) systemService;
    }

    @Singleton
    @Provides
    public final DisplayManager provideDisplayManager(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("display");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        return (DisplayManager) systemService;
    }
}
