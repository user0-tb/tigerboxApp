package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/WakeService;", "", "hasPartialWakeLock", "", "getHasPartialWakeLock", "()Z", "addPartialWakeLock", "", "keepAlive", "min", "", "removePartialWakeLock", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: WakeService.kt */
public interface WakeService {
    void addPartialWakeLock();

    boolean getHasPartialWakeLock();

    void keepAlive(int i);

    void removePartialWakeLock();
}
