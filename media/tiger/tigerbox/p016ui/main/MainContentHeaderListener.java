package media.tiger.tigerbox.p016ui.main;

import kotlin.Metadata;
import media.tiger.tigerbox.services.implementations.timersController.LockedModeReason;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/MainContentHeaderListener;", "", "changeHeaderTitle", "", "title", "", "disableLockScreen", "enableLockScreen", "reason", "Lmedia/tiger/tigerbox/services/implementations/timersController/LockedModeReason;", "hideHeaderCloseButton", "hideMultiProductListInCardsMode", "showHeaderCloseButton", "showMultiProductListInCardsMode", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.MainContentHeaderListener */
/* compiled from: MainContentActivity.kt */
public interface MainContentHeaderListener {
    void changeHeaderTitle(String str);

    void disableLockScreen();

    void enableLockScreen(LockedModeReason lockedModeReason);

    void hideHeaderCloseButton();

    void hideMultiProductListInCardsMode();

    void showHeaderCloseButton();

    void showMultiProductListInCardsMode();
}
