package p012io.shipbook.shipbooksdk.Events;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.InnerLog;
import p012io.shipbook.shipbooksdk.LogManager;
import p012io.shipbook.shipbooksdk.Models.ActivityEvent;
import p012io.shipbook.shipbooksdk.Models.BaseLog;

@Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Events/ActivityEventCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "TAG", "", "createEvent", "", "event", "activity", "Landroid/app/Activity;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Events.ActivityEventCallbacks */
/* compiled from: ActivityEventCallbacks.kt */
public final class ActivityEventCallbacks implements Application.ActivityLifecycleCallbacks {
    public static final ActivityEventCallbacks INSTANCE = new ActivityEventCallbacks();
    private static final String TAG = "ActivityEventCallbacks";

    private ActivityEventCallbacks() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("ActivityEventCallbacks", "ActivityEventCallbacks::class.java.simpleName");
    }

    private final void createEvent(String str, Activity activity) {
        CharSequence title = activity.getTitle();
        String obj = title == null ? "" : title.toString();
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "activity.javaClass.name");
        ActivityEvent activityEvent = new ActivityEvent(name, str, obj, 0, (Date) null, (BaseLog.ThreadInfo) null, 56, (DefaultConstructorMarker) null);
        InnerLog.v$default(InnerLog.INSTANCE, TAG, Intrinsics.stringPlus("added activity event: ", activityEvent), (Throwable) null, 4, (Object) null);
        LogManager.INSTANCE.push(activityEvent);
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        createEvent("onActivityPaused", activity);
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        createEvent("onActivityResumed", activity);
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        createEvent("onActivityStarted", activity);
        View findViewById = activity.findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(android.R.id.content)");
        ActionEventManager.INSTANCE.registerViews((ViewGroup) findViewById);
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        createEvent("onActivityDestroyed", activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InnerLog.v$default(InnerLog.INSTANCE, TAG, "onActivitySaveInstanceState called", (Throwable) null, 4, (Object) null);
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        createEvent("onActivityStopped", activity);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        createEvent("onActivityCreated", activity);
        if (activity instanceof AppCompatActivity) {
            ((AppCompatActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(SupportFragmentEventCallbacks.INSTANCE, true);
        } else if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(SupportFragmentEventCallbacks.INSTANCE, true);
        } else if (Build.VERSION.SDK_INT >= 26) {
            activity.getFragmentManager().registerFragmentLifecycleCallbacks(FragmentEventCallbacks.INSTANCE, true);
        } else {
            InnerLog.w$default(InnerLog.INSTANCE, TAG, "doesn't have a version that supports registerFragmentLifecycleCallbacks", (Throwable) null, 4, (Object) null);
        }
    }
}
