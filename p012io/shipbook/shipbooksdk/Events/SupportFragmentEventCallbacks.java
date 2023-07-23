package p012io.shipbook.shipbooksdk.Events;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p012io.shipbook.shipbooksdk.InnerLog;
import p012io.shipbook.shipbooksdk.LogManager;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.Models.FragmentEvent;

@Metadata(mo33736d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J*\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Events/SupportFragmentEventCallbacks;", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "()V", "TAG", "", "createEvent", "", "event", "fragment", "Landroidx/fragment/app/Fragment;", "onFragmentActivityCreated", "fm", "Landroidx/fragment/app/FragmentManager;", "f", "savedInstanceState", "Landroid/os/Bundle;", "onFragmentAttached", "context", "Landroid/content/Context;", "onFragmentCreated", "onFragmentDestroyed", "onFragmentDetached", "onFragmentPaused", "onFragmentPreAttached", "onFragmentPreCreated", "onFragmentResumed", "onFragmentStarted", "onFragmentStopped", "onFragmentViewCreated", "v", "Landroid/view/View;", "onFragmentViewDestroyed", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Events.SupportFragmentEventCallbacks */
/* compiled from: SupportFragmentEventCallbacks.kt */
public final class SupportFragmentEventCallbacks extends FragmentManager.FragmentLifecycleCallbacks {
    public static final SupportFragmentEventCallbacks INSTANCE = new SupportFragmentEventCallbacks();
    private static final String TAG = "SupportFragmentEventCallbacks";

    private SupportFragmentEventCallbacks() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("SupportFragmentEventCallbacks", "SupportFragmentEventCall…ks::class.java.simpleName");
    }

    private final void createEvent(String str, Fragment fragment) {
        String name = fragment.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "fragment.javaClass.name");
        FragmentEvent fragmentEvent = new FragmentEvent(name, str, 0, (Date) null, (BaseLog.ThreadInfo) null, 28, (DefaultConstructorMarker) null);
        InnerLog.v$default(InnerLog.INSTANCE, TAG, Intrinsics.stringPlus("added fragment event: ", fragmentEvent), (Throwable) null, 4, (Object) null);
        LogManager.INSTANCE.push(fragmentEvent);
    }

    public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        Intrinsics.checkNotNullParameter(context, "context");
        createEvent("onFragmentPreAttached", fragment);
    }

    public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        Intrinsics.checkNotNullParameter(context, "context");
        createEvent("onFragmentAttached", fragment);
    }

    public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentPreCreated", fragment);
    }

    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentCreated", fragment);
    }

    public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentActivityCreated", fragment);
    }

    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        Intrinsics.checkNotNullParameter(view, "v");
        createEvent("onFragmentViewCreated", fragment);
    }

    public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentStarted", fragment);
    }

    public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentResumed", fragment);
    }

    public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentPaused", fragment);
    }

    public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentStopped", fragment);
    }

    public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentViewDestroyed", fragment);
    }

    public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentDestroyed", fragment);
    }

    public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fm");
        Intrinsics.checkNotNullParameter(fragment, "f");
        createEvent("onFragmentDetached", fragment);
    }
}
