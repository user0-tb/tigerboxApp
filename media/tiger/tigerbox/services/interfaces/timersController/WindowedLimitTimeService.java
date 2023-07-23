package media.tiger.tigerbox.services.interfaces.timersController;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeService;", "", "checkWindowedLimit", "", "initiate", "", "registerWindowLimitListener", "listener", "Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeListener;", "unregisterWindowLimitListener", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WindowedLimitTimeService.kt */
public interface WindowedLimitTimeService {
    boolean checkWindowedLimit();

    void initiate();

    void registerWindowLimitListener(WindowedLimitTimeListener windowedLimitTimeListener);

    void unregisterWindowLimitListener(WindowedLimitTimeListener windowedLimitTimeListener);
}
