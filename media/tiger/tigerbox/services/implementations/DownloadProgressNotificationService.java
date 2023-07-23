package media.tiger.tigerbox.services.implementations;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.functional.DownloadProgressUpdate;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J/\u0010\u000f\u001a\u00020\n2%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bH\u0016J/\u0010\u0011\u001a\u00020\n2%\u0010\u0010\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000bH\u0016R3\u0010\u0003\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005j\u0002`\u000b0\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/DownloadProgressNotificationService;", "Lmedia/tiger/tigerbox/infrastructure/functional/DownloadProgressUpdate;", "()V", "subscribers", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "percent", "", "Lmedia/tiger/tigerbox/infrastructure/functional/DownloadListener;", "invoke", "notify", "data", "subscribe", "listener", "unsubscribe", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadProgressNotificationService.kt */
public final class DownloadProgressNotificationService implements DownloadProgressUpdate {
    public static final DownloadProgressNotificationService INSTANCE = new DownloadProgressNotificationService();
    private static final List<Function1<Double, Unit>> subscribers = new ArrayList();

    private DownloadProgressNotificationService() {
    }

    public /* bridge */ /* synthetic */ void notify(Object obj) {
        notify(((Number) obj).doubleValue());
    }

    public void invoke(double d) {
        notify(d);
    }

    public void notify(double d) {
        for (Function1 invoke : subscribers) {
            invoke.invoke(Double.valueOf(d));
        }
    }

    public void subscribe(Function1<? super Double, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        List<Function1<Double, Unit>> list = subscribers;
        if (!list.contains(function1)) {
            list.add(function1);
        }
    }

    public void unsubscribe(Function1<? super Double, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        List<Function1<Double, Unit>> list = subscribers;
        if (list.contains(function1)) {
            list.remove(function1);
        }
    }
}
