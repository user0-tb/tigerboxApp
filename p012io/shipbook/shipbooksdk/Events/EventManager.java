package p012io.shipbook.shipbooksdk.Events;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.InnerLog;
import p012io.shipbook.shipbooksdk.LogManager;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.Models.ConfigEvent;
import p012io.shipbook.shipbooksdk.Models.Orientation;
import p012io.shipbook.shipbooksdk.Networking.SessionManager;

@Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Events/EventManager;", "", "()V", "TAG", "", "start", "", "ComponentCallbacks", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Events.EventManager */
/* compiled from: EventManager.kt */
public final class EventManager {
    public static final EventManager INSTANCE = new EventManager();
    /* access modifiers changed from: private */
    public static final String TAG = "EventManager";

    private EventManager() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("EventManager", "EventManager::class.java.simpleName");
    }

    public final void start() {
        Resources resources;
        Application application = SessionManager.INSTANCE.getApplication();
        if (application != null) {
            application.registerActivityLifecycleCallbacks(ActivityEventCallbacks.INSTANCE);
        }
        Application application2 = SessionManager.INSTANCE.getApplication();
        if (application2 != null) {
            application2.registerComponentCallbacks(new ComponentCallbacks());
        }
        InnerLog innerLog = InnerLog.INSTANCE;
        String str = TAG;
        Context appContext = SessionManager.INSTANCE.getAppContext();
        Configuration configuration = null;
        if (!(appContext == null || (resources = appContext.getResources()) == null)) {
            configuration = resources.getConfiguration();
        }
        InnerLog.i$default(innerLog, str, Intrinsics.stringPlus("Current configuration: ", configuration), (Throwable) null, 4, (Object) null);
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Events/EventManager$ComponentCallbacks;", "Landroid/content/ComponentCallbacks2;", "()V", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onLowMemory", "onTrimMemory", "level", "", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Events.EventManager$ComponentCallbacks */
    /* compiled from: EventManager.kt */
    public static final class ComponentCallbacks implements ComponentCallbacks2 {
        public void onLowMemory() {
            InnerLog.w$default(InnerLog.INSTANCE, EventManager.TAG, "low memory", (Throwable) null, 4, (Object) null);
        }

        public void onConfigurationChanged(Configuration configuration) {
            Orientation orientation;
            if (configuration != null) {
                InnerLog.i$default(InnerLog.INSTANCE, EventManager.TAG, Intrinsics.stringPlus("configuration changed ", configuration), (Throwable) null, 4, (Object) null);
                int i = configuration.orientation;
                if (i == 1) {
                    orientation = Orientation.Portrait;
                } else if (i != 2) {
                    orientation = Orientation.Undefined;
                } else {
                    orientation = Orientation.Landscape;
                }
                ConfigEvent configEvent = new ConfigEvent(orientation, 0, (Date) null, (BaseLog.ThreadInfo) null, 14, (DefaultConstructorMarker) null);
                InnerLog.v$default(InnerLog.INSTANCE, EventManager.TAG, Intrinsics.stringPlus("added config event: ", configEvent), (Throwable) null, 4, (Object) null);
                LogManager.INSTANCE.push(configEvent);
            }
        }

        public void onTrimMemory(int i) {
            InnerLog.w$default(InnerLog.INSTANCE, EventManager.TAG, Intrinsics.stringPlus("trim memory on level: ", Integer.valueOf(i)), (Throwable) null, 4, (Object) null);
        }
    }
}
